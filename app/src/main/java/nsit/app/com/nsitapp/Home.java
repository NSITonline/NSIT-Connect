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
import android.util.Log;
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
import functions.DBhelpFeed;
import functions.TableEntryFeed;
import functions.Utils;
import functions.Val;


public class Home extends Fragment {

    boolean loadingMore = false;
    DBhelpFeed dbhe;
    SQLiteDatabase db;

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
    String next = " ";
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
        dbhe = new DBhelpFeed(activity);
        db = dbhe.getWritableDatabase();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        lv = (ListView) rootView.findViewById(R.id.list);
        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        pb = (ProgressBar) rootView.findViewById(R.id.progressBar1);
        adapter = new CustomList(activity, list6, list, list2, list7, list1, list8);
        footerView = ((LayoutInflater) activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer_layout, null, false);

        if (Utils.isNetworkAvailable(activity)) {

            lv.addFooterView(footerView);
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
            new DownloadWebPageTask2(Val.id_nsitonline).execute();
        } else {
            SnackbarManager.show(
                    Snackbar.with(activity.getApplicationContext())
                            .text("No Internet Connection")
                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);
            show_off();

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


    String text2;

    private class DownloadWebPageTask2 extends AsyncTask<String, Void, String> {
        String id;

        public DownloadWebPageTask2(String id) {
            this.id = id;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... urls) {

            String URL;
            URL = "https://graph.facebook.com/" + id + "/posts?limit=20&fields=id,picture,from,shares,message," +
                    "object_id,link,created_time,comments.limit(0).summary(true),likes.limit(0).summary(true)" +
                    "&access_token=" + Val.common_access;
            HttpClient Client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                text2 = Client.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pb.setVisibility(View.GONE);
            int j = 0;
            JSONObject ob, ob2;
            JSONArray arr;
            if (text2 == null)
                return;
            try {
                ob = new JSONObject(text2);
                arr = ob.getJSONArray("data");


                for (int i = 0; i < arr.length(); i++) {


                    String s2 = arr.getJSONObject(i).getString("from");
                    ob2 = new JSONObject(s2);
                    s2 = ob2.getString("id");
                    if (!s2.equals(id))
                        continue;


                    if (arr.getJSONObject(i).has("message")) {
                        list.add(arr.getJSONObject(i).getString("message"));
                    } else {
                        list.add(null);
                    }
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


                    Cursor c = db.rawQuery("SELECT * FROM " + TableEntryFeed.TABLE2_NAME + " WHERE " +
                            TableEntryFeed.COLUMN_NAME2_ID + " IS '" + arr.getJSONObject(i).getString("id") + "'", null);
                    if (c.moveToFirst())
                        continue;


                    DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS", Locale.ENGLISH);
                    java.util.Date d = originalFormat.parse(list8.get(i));
                    String millisec = Long.toString(d.getTime());
                    ContentValues values = new ContentValues();
                    values.put(TableEntryFeed.COLUMN_NAME2_ID, arr.getJSONObject(i).getString("id"));
                    values.put(TableEntryFeed.COLUMN_NAME2_MESSAGE, list.get(i));
                    values.put(TableEntryFeed.COLUMN_NAME2_OBJECTID, list1.get(i));
                    values.put(TableEntryFeed.COLUMN_NAME2_PICTURE, list6.get(i));
                    values.put(TableEntryFeed.COLUMN_NAME2_LINK, list7.get(i));
                    values.put(TableEntryFeed.COLUMN_NAME2_LIKES_COUNT, list2.get(i));
                    values.put(TableEntryFeed.COLUMN_NAME2_TIME, list8.get(i));
                    values.put(TableEntryFeed.COLUMN_NAME2_TIME_ADDED, millisec);


                    db.insert(
                            TableEntryFeed.TABLE2_NAME,
                            TableEntryFeed.COLUMN_NAME2_ID,
                            values);

                    Log.e("here", "inserting" + i + " " + list.get(i));

                }

                ob = ob.getJSONObject("paging");
                next = ob.getString("next");
                first = 0;
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            swipeLayout.setRefreshing(false);
            if (activity != null)
                lv.setAdapter(adapter);
        }
    }


    String text;

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

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            pb.setVisibility(View.GONE);
            int j = 0;
            JSONObject ob, ob2;
            JSONArray arr;
            if (text != null)
                try {
                    ob = new JSONObject(text);
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


                        Cursor c = db.rawQuery("SELECT * FROM " + TableEntryFeed.TABLE2_NAME + " WHERE " +
                                TableEntryFeed.COLUMN_NAME2_ID + " IS '" + arr.getJSONObject(i).getString("id") + "'", null);
                        if (c.moveToFirst())
                            continue;


                        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS", Locale.ENGLISH);
                        java.util.Date d = originalFormat.parse(list8.get(i));
                        String millisec = Long.toString(d.getTime());

                        ContentValues values = new ContentValues();
                        values.put(TableEntryFeed.COLUMN_NAME2_ID, arr.getJSONObject(i).getString("id"));
                        values.put(TableEntryFeed.COLUMN_NAME2_MESSAGE, list.get(i));
                        values.put(TableEntryFeed.COLUMN_NAME2_OBJECTID, list1.get(i));
                        values.put(TableEntryFeed.COLUMN_NAME2_PICTURE, list6.get(i));
                        values.put(TableEntryFeed.COLUMN_NAME2_LINK, list7.get(i));
                        values.put(TableEntryFeed.COLUMN_NAME2_LIKES_COUNT, list2.get(i));
                        values.put(TableEntryFeed.COLUMN_NAME2_TIME, list8.get(i));
                        values.put(TableEntryFeed.COLUMN_NAME2_TIME_ADDED, millisec);


                        db.insert(
                                TableEntryFeed.TABLE2_NAME,
                                TableEntryFeed.COLUMN_NAME2_ID,
                                values);

                        Log.e("here", "inserting" + i + " " + list.get(i));

                    }

                    ob = ob.getJSONObject("paging");
                    next = ob.getString("next");


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
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
        Cursor c = db.rawQuery("SELECT * FROM " + TableEntryFeed.TABLE2_NAME + " ORDER BY " +
                TableEntryFeed.COLUMN_NAME2_TIME_ADDED + " DESC ", null);

        Log.e("add", "adding");
        if (c.moveToFirst())
            do {

                list.add(c.getString(c.getColumnIndex(TableEntryFeed.COLUMN_NAME2_MESSAGE)));
                list1.add(c.getString(c.getColumnIndex(TableEntryFeed.COLUMN_NAME2_OBJECTID)));
                list6.add(c.getString(c.getColumnIndex(TableEntryFeed.COLUMN_NAME2_PICTURE)));
                list7.add(c.getString(c.getColumnIndex(TableEntryFeed.COLUMN_NAME2_LINK)));
                list2.add(c.getString(c.getColumnIndex(TableEntryFeed.COLUMN_NAME2_LIKES_COUNT)));
                list8.add(c.getString(c.getColumnIndex(TableEntryFeed.COLUMN_NAME2_TIME)));

                Log.e("add", "adding");
            } while (c.moveToNext());


        pb.setVisibility(View.INVISIBLE);
        adapter.notifyDataSetChanged();
        lv.setAdapter(adapter);
    }

}
