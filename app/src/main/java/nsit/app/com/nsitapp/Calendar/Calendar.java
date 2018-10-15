package nsit.app.com.nsitapp.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import functions.Constant;
import functions.Utils;
import models.SubjectObject;
import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.subjects.SubjectsShow;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Calendar extends Fragment implements Constant {

    private static String timetable = null;

    private static final ArrayList<String> days = new ArrayList<>();
    private static final ArrayList<SubjectObject> p0 = new ArrayList<>();
    private static final ArrayList<SubjectObject> p1 = new ArrayList<>();
    private static final ArrayList<SubjectObject> p2 = new ArrayList<>();
    private static final ArrayList<SubjectObject> p3 = new ArrayList<>();
    private static final ArrayList<SubjectObject> p4 = new ArrayList<>();
    private static final ArrayList<SubjectObject> p5 = new ArrayList<>();
    private static final ArrayList<SubjectObject> p6 = new ArrayList<>();
    private static final ArrayList<SubjectObject> p7 = new ArrayList<>();
    private static final ArrayList<SubjectObject> p8 = new ArrayList<>();
    private static final ArrayList<SubjectObject> p9 = new ArrayList<>();

    private CalendarAdapter adapter;
    @BindView(R.id.lvItems) RecyclerView recyclerView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Activity activity;
    private Handler mHandler;
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity)activity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
        view = rootView;

        ButterKnife.bind(this, rootView);

        //recyclerView = rootView.findViewById(R.id.lvItems);
        mHandler = new Handler(Looper.getMainLooper());

        if (activity == null)
            return rootView;

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);

        // If class is not selected, open activity
        Boolean is_class_already_set = sharedPreferences.getBoolean(IS_CLASS_SET, false);
        if (!is_class_already_set) {
            Intent i = new Intent(activity, ChooseClass.class);
            startActivity(i);
        }

        // Fetch the timetable we already have
        Boolean is_time_table_changed = sharedPreferences.getBoolean(IS_TIME_TABLE_CHANGED, true);
        timetable = sharedPreferences.getString(GET_TIME_TABLE, null);

        // Set adapter
        adapter = new CalendarAdapter(activity, days, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL,
                false
        );
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        // Update timetable if required
        if (is_time_table_changed || timetable == null) {
            // If internet is available
            if (Utils.isNetworkAvailable(activity))
                downloadTimeTable();
            else {
                Snackbar.make(view, R.string.internet_error, Snackbar.LENGTH_LONG).show();
            }
        } else {
            // else load the previous saved timetable
            load();
        }

        // Set onscroll listener for infinite scrolling
        /*recyclerView.setOnScrollListener(new TwoWayView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(TwoWayView view, int scrollState) {
            }

            @Override
            public void onScroll(TwoWayView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                int lastInScreen = firstVisibleItem + visibleItemCount;
                if ((lastInScreen == totalItemCount) && !(loadingMore)) {
                    load(); // infinite scrolling
                }
                adapter.notifyDataSetChanged();
            }
        });*/
        return rootView;
    }

    // Convert timetable string to subject objects
    private void load() {
        JSONObject object;
        JSONArray array1, array2;

        timetable = sharedPreferences.getString(GET_TIME_TABLE, null);

        if (timetable == null)
            return;

        try {
            object = new JSONObject(timetable);
            array1 = object.getJSONArray(GET_TIME_TABLE);

            int len1 = array1.length();
            for (int j = 0; j < len1; j++) {
                array2 = array1.getJSONArray(j);

                String value, proffh, subfh, roomfh, profsh, subsh, roomsh;

                int len2 = array2.length();

                for (int i = 0; i < len2; i++) {
                    value = array2.getJSONObject(i).getString("value");

                    //break or lunch break
                    if (value.contains("break")) {
                        proffh = subfh = roomfh = profsh = subsh = roomsh = null;
                    } else if (value.contains("theory")) {           //Theory
                        proffh = array2.getJSONObject(i).getString("prof");
                        roomfh = array2.getJSONObject(i).getString("room");
                        subfh = array2.getJSONObject(i).getString("subject");
                        profsh = subsh = roomsh = null;
                    } else {        //Lab
                        proffh = array2.getJSONObject(i).getString("prof_FH");
                        roomfh = array2.getJSONObject(i).getString("room_FH");
                        subfh = array2.getJSONObject(i).optString("subject_FH", array2.getJSONObject(i).getString("subject"));
                        profsh = array2.getJSONObject(i).getString("prof_SH");
                        roomsh = array2.getJSONObject(i).getString("room_SH");
                        subsh = array2.getJSONObject(i).optString("subject_SH", array2.getJSONObject(i).getString("subject"));
                    }

                    // Create new subject object
                    SubjectObject x = new SubjectObject(value, proffh, subfh, roomfh, profsh, subsh, roomsh);
                    // Assign it to particular period
                    switch (i - 1) {
                        case -1:
                            p0.add(x);
                            break;
                        case 0:
                            p1.add(x);
                            break;
                        case 1:
                            p2.add(x);
                            break;
                        case 2:
                            p3.add(x);
                            break;
                        case 3:
                            p4.add(x);
                            break;
                        case 4:
                            p5.add(x);
                            break;
                        case 5:
                            p6.add(x);
                            break;
                        case 6:
                            p7.add(x);
                            break;
                        case 7:
                            p8.add(x);
                            break;
                        case 8:
                            p9.add(x);
                            break;
                    }
                }
            }
        } catch (JSONException e) {
            Log.e("ERROR : ", e.getMessage() + "  ");
        }
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // View subjects
        if (item.getItemId() == R.id.subjects) {
            Intent i = new Intent(activity, SubjectsShow.class);
            startActivity(i);
        }
        // Choose your class
        if (item.getItemId() == R.id.choose) {
            Intent i = new Intent(activity, ChooseClass.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private void downloadTimeTable() {

        p0.clear();
        p1.clear();
        p2.clear();
        p3.clear();
        p4.clear();
        p5.clear();
        p6.clear();
        p7.clear();
        p8.clear();
        p9.clear();

        //Scroll to first column
        recyclerView.scrollTo(0, 0);
        adapter.notifyDataSetChanged();
        final ProgressDialog progress = new ProgressDialog(activity);
        progress.setTitle(getString(R.string.loading));
        progress.setMessage(getString(R.string.loading_timetable));
        progress.show();

        int branch, sem, sec;
        branch = sharedPreferences.getInt(CALENDAR_BRANCH, 1);
        sec = sharedPreferences.getInt(CALENDAR_SECTION, 1);
        sem = sharedPreferences.getInt(CALENDAR_SEM, 1);

        // URL to fetch timetable
        String uri = TIMETABLE_API +
                "branch=" +
                branch +
                "&semester=" +
                sem +
                "&section=" +
                sec;

        //Set up client
        OkHttpClient client = new OkHttpClient();
        //Execute request
        final Request request = new Request.Builder()
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
                try {
                    timetable = response.body().string();
                    editor = sharedPreferences.edit();
                    editor.putBoolean(IS_TIME_TABLE_CHANGED, false);
                    editor.putString(GET_TIME_TABLE, response.body().string());
                    editor.apply();

                    JSONObject ob;
                    try {
                        ob = new JSONObject(timetable);
                        ob = ob.getJSONObject("metadata");
                        String s = ob.optString("last_updated", "null");
                        if (s.equals("null")) {
                            Snackbar.make(view, "Sorry, Time Table is not available now. It will be updated shortly.", Snackbar.LENGTH_LONG).show();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("ERROR : ", e.getMessage() + " ");
                    }

                    mHandler.post(() -> {
                        progress.dismiss();
                        adapter = new CalendarAdapter(activity, days, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
                        load();
                        recyclerView.setAdapter(adapter);
                    });
                } catch (final Exception e) {
                    mHandler.post(() -> {
                        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                        alertDialog.setTitle("Can't connect.");
                        alertDialog.setMessage("We cannot connect to the internet right now. Please try again later. Exception e: " + e.toString());
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.filter_dialog_ok),
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    });
                    Log.e("Error : ", e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onResume() {
        if (activity != null) {
            Boolean a = sharedPreferences.getBoolean(IS_TIME_TABLE_CHANGED, true);
            timetable = sharedPreferences.getString(GET_TIME_TABLE, null);
            adapter = new CalendarAdapter(activity, days, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
            recyclerView.setAdapter(adapter);
            if (a || timetable == null) {
                if (Utils.isNetworkAvailable(activity))
                    downloadTimeTable();
                else {
                    Snackbar.make(view, R.string.internet_error, Snackbar.LENGTH_LONG).show();
                }
            } else {
                load();
            }
        }
        super.onResume();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_calender, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
