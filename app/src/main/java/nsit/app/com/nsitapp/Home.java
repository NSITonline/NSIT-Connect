package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapters.FacebookPostAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import functions.Constant;
import functions.Utils;
import functions.dbAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Home extends Fragment implements Constant {

    private boolean loadingMore = false;
    private dbAdapter databaseAdapter;
    private Activity activity;

    private final List<String> Imageslist = new ArrayList<>();
    private final List<String> Descriptionlist = new ArrayList<>();
    private final List<String> Likeslist = new ArrayList<>();
    private final List<String> Linkslist = new ArrayList<>();
    private final List<String> ObjectIdlist = new ArrayList<>();
    private final List<String> Datelist = new ArrayList<>();

    @BindView(R.id.list)
    ListView lv;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.progressBar1)
    ProgressBar progressBar;

    private int first = 1;
    private String next = "https://graph.facebook.com/" + id_nsitonline + "/posts?limit=20&fields=id,picture,from,shares,message," +
            "object_id,link,created_time,comments.limit(0).summary(true),likes.limit(0).summary(true)" +
            "&access_token=" + common_access;
    private FacebookPostAdapter adapter;
    private View footerView;
    private int listCount;
    private Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity) activity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        databaseAdapter = new dbAdapter(activity);
        databaseAdapter.open();

        mHandler = new Handler(Looper.getMainLooper());
        adapter = new FacebookPostAdapter(activity, Linkslist, Imageslist, Likeslist, ObjectIdlist, Descriptionlist, Datelist);
        footerView = ((LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.footer_layout, container, false);

        lv.setAdapter(adapter);
        if (Utils.isNetworkAvailable(activity)) {
            databaseAdapter.deleteAll();
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
                        GetNSITOnlineFeed();
                        listCount = lastInScreen;
                    }
                }
            });
            GetNSITOnlineFeed();
        } else {
            showOffline();
            Snackbar.make(lv, R.string.internet_error, Snackbar.LENGTH_LONG).show();
        }
        swipeLayout.setOnRefreshListener(this::GetNSITOnlineFeed);
        return rootView;
    }

    private void GetNSITOnlineFeed() {

        // Facebook URI to fetch likes
        String uri = next;

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
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                mHandler.post(() -> {
                    progressBar.setVisibility(View.GONE);
                    JSONObject ob, ob2;
                    JSONArray arr;
                    databaseAdapter.deleteAll();
                    if (result != null)
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
                                    Imageslist.add(arr.getJSONObject(i).getString("message"));
                                else
                                    Imageslist.add(null);

                                if (!(arr.getJSONObject(i).has("object_id")))
                                    Descriptionlist.add(null);
                                else
                                    Descriptionlist.add(arr.getJSONObject(i).getString("object_id"));

                                if (arr.getJSONObject(i).has("picture")) {
                                    Linkslist.add(arr.getJSONObject(i).getString("picture"));
                                } else
                                    Linkslist.add(null);
                                if (arr.getJSONObject(i).has("link")) {
                                    ObjectIdlist.add(arr.getJSONObject(i).getString("link"));
                                } else
                                    ObjectIdlist.add(null);
                                if (arr.getJSONObject(i).has("likes")) {
                                    String s = arr.getJSONObject(i).getString("likes");
                                    JSONObject o = new JSONObject(s);
                                    String x = o.getString("summary");
                                    JSONObject o2 = new JSONObject(x);

                                    Likeslist.add(o2.getString("total_count"));   //No of likes
                                } else
                                    Likeslist.add("0");

                                if (arr.getJSONObject(i).has("created_time"))
                                    Datelist.add(arr.getJSONObject(i).getString("created_time"));
                                else
                                    Datelist.add(null);

                                databaseAdapter.insertRow(Imageslist.get(i), Descriptionlist.get(i), Likeslist.get(i), Linkslist.get(i), ObjectIdlist.get(i), Datelist.get(i), null, id_nsitonline);
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
                });
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

    private void showOffline() {
        Cursor c = databaseAdapter.getAllnsRows();
        if (c == null)
            return;
        try {
            do {
                Imageslist.add(c.getString(1));
                Descriptionlist.add(c.getString(2));
                Likeslist.add(c.getString(3));
                Linkslist.add(c.getString(4));
                ObjectIdlist.add(c.getString(5));
                Datelist.add(c.getString(6));
            } while (c.moveToNext());
            c.close();
            progressBar.setVisibility(View.GONE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }

}