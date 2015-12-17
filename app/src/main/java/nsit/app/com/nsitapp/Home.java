package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 21-06-2015.
 */

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import adapters.CustomList;
import functions.Utils;
import functions.Val;
import functions.dbAdapter;


public class Home extends Fragment {

    boolean loadingMore = false;
    dbAdapter db ;

    List<String> list = new ArrayList<String>();
    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list6 = new ArrayList<String>();
    List<String> list7 = new ArrayList<String>();
    List<String> list8 = new ArrayList<String>();
    ListView lv;
    int first = 1;
    SwipeRefreshLayout swipeLayout;
    ProgressBar pb;
    String next = "https://graph.facebook.com/" + Val.id_nsitonline + "/posts?limit=20&fields=id,picture,from,shares,message," +
            "object_id,link,created_time,comments.limit(0).summary(true),likes.limit(0).summary(true)"+
            "&access_token=" + Val.common_access;
    CustomList adapter;
    View footerView;
    int listCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    Activity activity;

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        this.activity = activity;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        db = new dbAdapter(activity);
        db.open();

        lv = (ListView) rootView.findViewById(R.id.list);
        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        pb = (ProgressBar) rootView.findViewById(R.id.progressBar1);
        adapter = new CustomList(activity, list6, list, list2, list7, list1, list8);
        footerView = ((LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer_layout, null, false);

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
                        new DownloadWebPageTask3(Val.id_nsitonline).execute();
                        listCount = lastInScreen;
                    }

                }
            });
            new DownloadWebPageTask3(Val.id_nsitonline).execute();
        } else {
            show_off();
            SnackbarManager.show(
                    Snackbar.with(activity.getApplicationContext())
                            .text("No Your Internet Connection")
                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);

        }

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new DownloadWebPageTask3(Val.id_nsitonline).execute();
            }
        });
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        return rootView;
    }



    private class DownloadWebPageTask3 extends AsyncTask<String, Void, String> {
        String id;

        public DownloadWebPageTask3(String id) {
            this.id = id;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... urls) {

            String URL;

            URL = next;
            String text = "";
            if (URL != null) {
                HttpClient Client = new DefaultHttpClient();
                HttpGet httpget = new HttpGet(URL);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                try {
                    text = Client.execute(httpget, responseHandler);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return text;
        }

        @Override
        protected void onPostExecute(String result) {
            pb.setVisibility(View.GONE);
            int j = 0;
            JSONObject ob, ob2;
            JSONArray arr;
            db.deleteAll();
            if (result != null)
                try {
                    ob = new JSONObject(result);
                    arr = ob.getJSONArray("data");


                    for (int i = 0; i < arr.length(); i++) {

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
                            JSONArray a2 = o.getJSONArray("data");
                            String x = o.getString("summary");
                            JSONObject o2 = new JSONObject(x);

                            list2.add(o2.getString("total_count"));   //No of likes
                        } else
                            list2.add("0");

                        if (arr.getJSONObject(i).has("created_time"))
                            list8.add(arr.getJSONObject(i).getString("created_time"));
                        else
                            list8.add(null);


                        db.insertRow(list.get(i), list1.get(i), list2.get(i), list6.get(i), list7.get(i), list8.get(i),null, Val.id_nsitonline);


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
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }


    public void show_off() {

        Cursor c = db.getAllnsRows();
        if(c==null)
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
        }catch (Exception e){
        }
        adapter.notifyDataSetChanged();
    }

}
