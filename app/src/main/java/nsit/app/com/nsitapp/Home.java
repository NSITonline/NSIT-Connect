package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 21-06-2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapters.CustomList;
import functions.Constant;
import functions.DbAdapter;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Home extends Fragment implements Constant {

    private boolean loadingMore = false;
    private DbAdapter db;
    private Handler mHandler;

    private List<String> list = new ArrayList<>();
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private List<String> list6 = new ArrayList<>();
    private List<String> list7 = new ArrayList<>();
    private List<String> list8 = new ArrayList<>();
    private ListView lv;
    private int first = 1;
    private SwipeRefreshLayout swipeLayout;
    private ProgressBar pb;
    private String next = "https://graph.facebook.com/" + id_nsitonline + "/posts?limit=20&fields=id,picture,from,shares,message," +
            "object_id,link,created_time,comments.limit(0).summary(true),likes.limit(0).summary(true)" +
            "&access_token=" + common_access;
    private CustomList adapter;
    private View footerView;
    private int listCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    private Activity activity;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        this.activity = activity;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        db = new DbAdapter(activity);
        db.open();

        lv = (ListView) rootView.findViewById(R.id.list);
        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        pb = (ProgressBar) rootView.findViewById(R.id.progressBar1);
        adapter = new CustomList(activity, list6, list, list2, list7, list1, list8);
        footerView = ((LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer_layout, container, false);
        mHandler = new Handler(Looper.getMainLooper());


        lv.setAdapter(adapter);
        if (Utils.isNetworkAvailable(activity)) {

            db.deleteAll();
            lv.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView absListView, int i) {
                }

                @Override
                public void onScroll(AbsListView absListView, int firstVisibleItem,
                                     int visibleItemCount, int totalItemCount) {
                    int lastInScreen = firstVisibleItem + visibleItemCount;
                    if ((lastInScreen == totalItemCount) && !(loadingMore) && first != 1) {
                        loadingMore = true;
                        lv.addFooterView(footerView);
                        loadFeed();
                        listCount = lastInScreen;
                    }

                }
            });
            loadFeed();
        } else {
            show_off();
            SnackbarManager.show(
                    Snackbar.with(activity.getApplicationContext())
                            .text(R.string.internet_error)
                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);

        }

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadFeed();
            }
        });
        return rootView;
    }


    // Make http call
    private void loadFeed() {

        String uri = next;
        final String id = id_nsitonline;

        //Set up client
        OkHttpClient client = new OkHttpClient();
        //Execute request
        Request request = new Request.Builder()
                .url(uri)
                .build();
        //Setup callback
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Request Failed", "Message : " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                try {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb.setVisibility(View.GONE);
                            JSONObject ob, ob2;
                            JSONArray arr;
                            db.deleteAll();
                            try {
                                ob = new JSONObject(result);
                                arr = ob.getJSONArray("data");

                                int len = arr.length();
                                for (int i = 0; i < len; i++) {

                                    String s2 = arr.getJSONObject(i).getString("from");
                                    ob2 = new JSONObject(s2);
                                    s2 = ob2.getString("id");
                                    if (!s2.equals(id))
                                        continue;

                                    if (arr.getJSONObject(i).has("message"))
                                        list.add(arr.getJSONObject(i).getString("message"));
                                    else
                                        list.add(null);

                                    if (!(arr.getJSONObject(i).has("object_id")))
                                        list1.add(null);
                                    else
                                        list1.add(arr.getJSONObject(i).getString("object_id"));

                                    if (arr.getJSONObject(i).has("picture")) {
                                        list6.add(arr.getJSONObject(i).getString("picture"));
                                    } else
                                        list6.add(null);
                                    if (arr.getJSONObject(i).has("link")) {
                                        list7.add(arr.getJSONObject(i).getString("link"));
                                    } else
                                        list7.add(null);
                                    if (arr.getJSONObject(i).has("likes")) {
                                        String s = arr.getJSONObject(i).getString("likes");
                                        JSONObject o = new JSONObject(s);
                                        String x = o.getString("summary");
                                        JSONObject o2 = new JSONObject(x);

                                        list2.add(o2.getString("total_count"));   //No of likes
                                    } else
                                        list2.add("0");

                                    if (arr.getJSONObject(i).has("created_time"))
                                        list8.add(arr.getJSONObject(i).getString("created_time"));
                                    else
                                        list8.add(null);


                                    db.insertRow(list.get(i), list1.get(i), list2.get(i), list6.get(i), list7.get(i), list8.get(i), null, id_nsitonline);


                                }

                                ob = ob.getJSONObject("paging");
                                next = ob.getString("next");
                                first = 0;

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            swipeLayout.setRefreshing(false);
                            loadingMore = false;
                            lv.removeFooterView(footerView);
                            adapter.notifyDataSetChanged();
                            try {
                                lv.smoothScrollToPosition(listCount + 1);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home_notification, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.notification_settings) {
            Intent intent = new Intent(getActivity(), NotificationSettings.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void show_off() {

        Cursor c = db.getAllnsRows();
        if (c == null)
            return;
        try {
            do {
                list.add(c.getString(1));
                list1.add(c.getString(2));
                list2.add(c.getString(3));
                list6.add(c.getString(4));
                list7.add(c.getString(5));
                list8.add(c.getString(6));
            } while (c.moveToNext());
            pb.setVisibility(View.GONE);
        } catch (Exception e) {
            Log.e("ERROR ", e.getMessage());
        }
        adapter.notifyDataSetChanged();
    }

}