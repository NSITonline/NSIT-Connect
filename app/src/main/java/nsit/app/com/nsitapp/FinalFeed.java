package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapters.MyFeedList;
import functions.Constant;
import functions.DbAdapter;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Swati garg on 21-06-2015.
 * <p>
 * Displays final customised feed of user
 */

public class FinalFeed extends Fragment implements Constant {

    private int NUMBER_OF_SOCITIES = 12;
    private ArrayList<Boolean> is_society_checked = new ArrayList<>();
    private ArrayList<String> society_id = new ArrayList<>();
    private ArrayList<String> society_name = new ArrayList<>();
    private ArrayList<String> society_next_link = new ArrayList<>();

    private Boolean loadingMore = false;
    private String nextn;
    private int first = 1;  // Implies loading data for first time

    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeLayout;
    private MyFeedList adapter;
    private Handler mHandler;
    private View footerView;
    private ListView listView;
    private SharedPreferences sharedPreferences;
    private Activity activity;

    private List<String> list = new ArrayList<>();  //description
    private List<String> list1 = new ArrayList<>(); //Object id
    private List<String> list2 = new ArrayList<>(); //likes
    private List<String> list6 = new ArrayList<>(); //image
    private List<String> list7 = new ArrayList<>(); //link
    private List<String> list8 = new ArrayList<>(); //time
    private List<String> list9 = new ArrayList<>(); //post by


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feedfinal, container, false);

        // Initialize variables
        mHandler = new Handler(Looper.getMainLooper());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar1);
        listView = (ListView) rootView.findViewById(R.id.list);
        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);
        footerView = ((LayoutInflater) activity.getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer_layout, null, false);
        setSocietyVariables();

        // Open up choose socities screen, if no society selected
        Boolean is_societies_selected = sharedPreferences.getBoolean(SOCIETY_SET, false);
        if (!is_societies_selected) {
            Intent i = new Intent(getActivity(), ChooseFeedItems.class);
            startActivity(i);
        }

        // Initialise adapter
        adapter = new MyFeedList(activity, list6, list, list2, list7, list1, list8, list9);

        // fetch data for selected societies
        fetchFeed();

        // TODO : Refresh items on refresh layout swiped
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.setRefreshing(false);
            }
        });

        return rootView;
    }

    // If internet connection available : load from internet and save to database
    // else load from database
    private void fetchFeed() {

        // Fetch selected society values
        fetchSocietyValues();

        DbAdapter db = new DbAdapter(getActivity());

        listView.addFooterView(footerView);

        if (!checkIfSomeSocietyIsChecked()) {
            SnackbarManager.show(
                    Snackbar.with(activity.getApplicationContext())
                            .text("No item Selected")
                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);
        } else {

            // If internet is available
            if (Utils.isNetworkAvailable(activity)) {

                db.open();
                db.deleteAll();
                db.close();

                // Download feed : true indicates first time
                downloadFeedForSociety(true);
            }
            // Internet not available Fetch data from database
            else {
                SnackbarManager.show(
                        Snackbar.with(activity.getApplicationContext())
                                .text(R.string.internet_error)
                                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);
                db.open();
                // Fetch from databse
                Cursor c = db.getAllRows();
                if (c.moveToFirst()) {
                    do {
                        // Load values to lists
                        list.add(c.getString(1));
                        list1.add(c.getString(2));
                        list2.add(c.getString(3));
                        list6.add(c.getString(4));
                        list7.add(c.getString(5));
                        list8.add(c.getString(6));
                        list9.add(c.getString(7));
                    } while (c.moveToNext());
                }
                db.close();
                progressBar.setVisibility(View.GONE);
            }

            // Populate listview
            listView.setAdapter(adapter);
        }

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                int lastInScreen = firstVisibleItem + visibleItemCount;

                DbAdapter db = new DbAdapter(getActivity());

                if ((lastInScreen == totalItemCount) && !(loadingMore) && first != 1) {
                    loadingMore = true;
                    listView.addFooterView(footerView);
                    if (Utils.isNetworkAvailable(activity)) {
                        fetchSocietyValues();

                        // Download feed : false means not first time
                        downloadFeedForSociety(false);
                    } else {
                        SnackbarManager.show(
                                Snackbar.with(activity.getApplicationContext())
                                        .text(R.string.internet_error)
                                        .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);

                        db.open();
                        Cursor c = db.getAllRows();
                        if (c.moveToFirst()) {
                            do {
                                list.add(c.getString(1));
                                Log.v("DATABASE LOGS", c.getString(1));
                                list1.add(c.getString(2));
                                list2.add(c.getString(3));
                                list6.add(c.getString(4));
                                list7.add(c.getString(5));
                                list8.add(c.getString(6));
                                list9.add(c.getString(7));
                            } while (c.moveToNext());
                        }
                        db.close();
                        progressBar.setVisibility(View.GONE);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    // Download feed for particular society
    private void downloadFeedForSociety(Boolean first) {
        for (int i = 0; i < NUMBER_OF_SOCITIES; i++) {
            if (is_society_checked.get(i)) {
                loadFeed(society_id.get(i), first, society_next_link.get(i));
            }
        }

    }

    // Make http call
    private void loadFeed(final String id, Boolean isFirst, String next) {

        // Facebook URI to fetch requests
        String uri;
        if (isFirst) {
            uri = "https://graph.facebook.com/" + id + "/posts?limit=10&fields=picture,shares,message,object_id," +
                    "link,comments.limit(0).summary(true),to,created_time,likes.limit(0).summary(true)&access_token=" +
                    common_access;
        } else {
            uri = next;
        }

        Log.d("calling", uri);

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
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            JSONObject ob;
                            JSONArray arr;
                            try {
                                ob = new JSONObject(response.body().string());
                                arr = ob.getJSONArray("data");
                                // Setup next variable for particular society
                                if (ob.has("paging")) {
                                    ob = ob.getJSONObject("paging");
                                    if (ob.has("next"))
                                        nextn = ob.getString("next");
                                    else
                                        nextn = null;
                                } else
                                    nextn = null;

                                // Assign next link to specific society
                                assignNextLinkToSociety(id, nextn);

                                // Populate data into lists and database
                                populateListViewAndDatabase(arr, id);

                                // If feed is loaded, society checked is set false
                                for (int i = 0; i < NUMBER_OF_SOCITIES; i++)
                                    if (society_id.get(i).equals(id))
                                        is_society_checked.set(i, false);

                                // Update values if all societies are done
                                if (first == 1) {
                                    done();
                                }

                            } catch (JSONException | IOException e) {
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

    // Assign next link to particular society
    private void assignNextLinkToSociety(String id, String nextn) {

        for (int i = 0; i < NUMBER_OF_SOCITIES; i++) {
            if (id.equals(society_id.get(i))) {
                society_next_link.set(i, nextn);
                break;
            }
        }
    }

    // Populate data to list and add to database
    private void populateListViewAndDatabase(JSONArray arr, String id) {

        // Open connection to database
        DbAdapter db = new DbAdapter(getActivity());
        db.open();

        int length = arr.length();
        try {
            //Fetch data from JSON
            for (int i = 0; i < length; i++) {

                if (arr.getJSONObject(i).has("message"))
                    list.add(arr.getJSONObject(i).getString("message"));
                else {
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
                    String x = o.getString("summary");
                    JSONObject o2 = new JSONObject(x);

                    list2.add(o2.getString("total_count"));    //No of likes
                } else
                    list2.add("0");


                if (arr.getJSONObject(i).has("created_time"))
                    list8.add(arr.getJSONObject(i).getString("created_time"));
                else
                    list8.add(null);

                if (arr.getJSONObject(i).has("to")) {
                    JSONObject o = new JSONObject(arr.getJSONObject(i).getString("to"));
                    JSONArray a2 = o.getJSONArray("data");
                    String x = a2.getJSONObject(0).getString("name");
                    list9.add(x);
                } else
                    list9.add(null);

                db.insertRow(list.get(list.size() - 1), list1.get(list1.size() - 1), list2.get(list2.size() - 1), list6.get(list6.size() - 1),
                        list7.get(list7.size() - 1), list8.get(list8.size() - 1), list9.get(list9.size() - 1), id);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("ERROR : ", e.getMessage());
        }
        db.close();
        adapter.notifyDataSetChanged();
    }

    // Checks if all socities's feed is loaded
    private void done() {
        if (!checkIfSomeSocietyIsChecked()) {

            adapter.notifyDataSetChanged();
            progressBar.setVisibility(View.GONE);
            listView.removeFooterView(footerView);

            if (activity != null)
                listView.setAdapter(adapter);
            first = 0;
        }
    }

    // Assigns value to society
    private void fetchSocietyValues() {
        // Check which socities are selected
        for (int i = 0; i < NUMBER_OF_SOCITIES; i++)
            is_society_checked.set(i, sharedPreferences.getBoolean(society_name.get(i), false));
    }

    /**
     * Checks if some or more societies are selected
     *
     * @return Returns true if any one of the society is selected
     */
    private Boolean checkIfSomeSocietyIsChecked() {

        for (int i = 0; i < NUMBER_OF_SOCITIES; i++)
            if (is_society_checked.get(i))
                return true;
        return false;
    }


    // Set facebook page id, names of societies
    private void setSocietyVariables() {

        for (int i = 0; i < NUMBER_OF_SOCITIES; i++) {
            is_society_checked.add(false);
            society_next_link.add(null);
        }

        society_id.add(id_collegespace);
        society_id.add(id_crosslinks);
        society_id.add(id_junoon);
        society_id.add(id_bullet);
        society_id.add(id_rotaract);
        society_id.add(id_quiz);
        society_id.add(id_ieee);
        society_id.add(id_csi);
        society_id.add(id_ashwa);
        society_id.add(id_debsoc);
        society_id.add(id_enactus);
        society_id.add(id_aagaz);

        society_name.add(COLLEGESPACE);
        society_name.add(CROSSLINKS);
        society_name.add(JUNOON);
        society_name.add(BULLET);
        society_name.add(ROTARACT);
        society_name.add(QUIZ);
        society_name.add(IEEE);
        society_name.add(CSI);
        society_name.add(ASHWA);
        society_name.add(DEB);
        society_name.add(ENACTUS);
        society_name.add(AAGAZ);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_feed, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.items) {
            // For selecting socities
            Intent i = new Intent(getActivity(), ChooseFeedItems.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    // Refresh the feed
    @Override
    public void onResume() {
        if (sharedPreferences.getBoolean("item_changed", false)) {
            list.clear();
            list1.clear();
            list2.clear();
            list6.clear();
            list7.clear();
            list8.clear();
            adapter.notifyDataSetChanged();
            sharedPreferences.edit().putBoolean("item_changed", false).apply();
            // Reload data
            fetchFeed();
        }
        super.onResume();
    }

}