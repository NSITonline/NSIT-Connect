package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 28-06-2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lucasr.twowayview.TwoWayView;

import java.io.IOException;
import java.util.ArrayList;

import functions.Constant;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Calender extends Fragment implements Constant {

    private static String timetable = null;
    private boolean loadingMore = false;

    private static ArrayList<String> days = new ArrayList<String>();
    private static ArrayList<Subject_struct> p0 = new ArrayList<Subject_struct>();
    private static ArrayList<Subject_struct> p1 = new ArrayList<Subject_struct>();
    private static ArrayList<Subject_struct> p2 = new ArrayList<Subject_struct>();
    private static ArrayList<Subject_struct> p3 = new ArrayList<Subject_struct>();
    private static ArrayList<Subject_struct> p4 = new ArrayList<Subject_struct>();
    private static ArrayList<Subject_struct> p5 = new ArrayList<Subject_struct>();
    private static ArrayList<Subject_struct> p6 = new ArrayList<Subject_struct>();
    private static ArrayList<Subject_struct> p7 = new ArrayList<Subject_struct>();
    private static ArrayList<Subject_struct> p8 = new ArrayList<Subject_struct>();
    private static ArrayList<Subject_struct> p9 = new ArrayList<Subject_struct>();

    private CustomList_calendar adapter;
    private TwoWayView lvTest;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Activity activity;
    private Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calender, container, false);

        lvTest = (TwoWayView) rootView.findViewById(R.id.lvItems);
        mHandler = new Handler(Looper.getMainLooper());

        if (activity == null)
            return rootView;

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        editor = sharedPreferences.edit();

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
        adapter = new CustomList_calendar(activity, days, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        lvTest.setAdapter(adapter);
        lvTest.setItemMargin(10);


        // Update timetable if required
        if (is_time_table_changed || timetable == null) {
            // If internet is available
            if (Utils.isNetworkAvailable(activity))
                downloadTimeTable();
            else {
                SnackbarManager.show(
                        Snackbar.with(activity.getApplicationContext())
                                .text("Check Your Internet Connection")
                                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);
            }
        } else {
            // else load the previous saved timetable
            load();
        }

        loadingMore = true;


        // Set onscroll listener for infinite scrolling
        lvTest.setOnScrollListener(new TwoWayView.OnScrollListener() {
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
        });

        return rootView;
    }


    // Convert timetable string to subject objects
    private void load() {
        JSONObject object;
        JSONArray array1, array2;

        loadingMore = true;

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
                    Subject_struct x = new Subject_struct(value, proffh, subfh, roomfh, profsh, subsh, roomsh);
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
        loadingMore = false;
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
        lvTest.scrollTo(0, 0);
        adapter.notifyDataSetChanged();
        final ProgressDialog progress = new ProgressDialog(activity);
        progress.setTitle("Loading");
        progress.setMessage("Fetching timetable...");
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
                    editor.putBoolean(IS_TIME_TABLE_CHANGED, false);
                    editor.putString(GET_TIME_TABLE, response.body().string());
                    editor.apply();


                    JSONObject ob;
                    try {
                        ob = new JSONObject(timetable);
                        ob = ob.getJSONObject("metadata");
                        String s = ob.optString("last_updated", "null");
                        if (s.equals("null")) {
                            SnackbarManager.show(
                                    Snackbar.with(activity.getApplicationContext())
                                            .text("Sorry, Time Table is not available now. It will be updated shortly.")
                                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("ERROR : ", e.getMessage() + " ");
                    }


                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progress.dismiss();
                            adapter = new CustomList_calendar(activity, days, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
                            load();
                            lvTest.setAdapter(adapter);
                        }
                    });
                } catch (final Exception e) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                            alertDialog.setTitle("Can't connect.");
                            alertDialog.setMessage("We cannot connect to the internet right now. Please try again later. Exception e: " + e.toString());
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                        }
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
            adapter = new CustomList_calendar(activity, days, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
            lvTest.setAdapter(adapter);
            lvTest.setItemMargin(10);

            if (a || timetable == null) {
                if (Utils.isNetworkAvailable(activity))
                    downloadTimeTable();
                else {
                    SnackbarManager.show(
                            Snackbar.with(activity.getApplicationContext())
                                    .text("Check Your Internet Connection")
                                    .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);
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

    public class CustomList_calendar extends ArrayAdapter<Subject_struct> {
        private final Activity context;
        ArrayList<String> day;
        private final ArrayList<Subject_struct> p0, p1, p2, p3, p4, p5, p6, p7, p8, p9;

        public CustomList_calendar(Activity context, ArrayList d, ArrayList<Subject_struct> b0, ArrayList<Subject_struct> b1, ArrayList<Subject_struct> b2, ArrayList<Subject_struct> b3, ArrayList<Subject_struct> b4,
                                   ArrayList<Subject_struct> b5, ArrayList<Subject_struct> b6, ArrayList<Subject_struct> b7
                , ArrayList<Subject_struct> b8, ArrayList<Subject_struct> b9) {
            super(context, R.layout.message, b0);
            this.context = context;
            day = d;
            p0 = b0;
            p1 = b1;
            p2 = b2;
            p3 = b3;
            p4 = b4;
            p5 = b5;
            p6 = b6;
            p7 = b7;
            p8 = b8;
            p9 = b9;

        }

        private class ViewHolder {
            TextView dat, t0, t1, t2, t3, t4, t5, t6, t7, t8, t9;
        }


        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            ViewHolder holder;
            if (view == null) {
                view = mInflater.inflate(R.layout.timetable_row_layout, null, false);
                holder = new ViewHolder();
                holder.dat = (TextView) view.findViewById(R.id.day);
                holder.t0 = (TextView) view.findViewById(R.id.p0);
                holder.t1 = (TextView) view.findViewById(R.id.p1);
                holder.t2 = (TextView) view.findViewById(R.id.p2);
                holder.t3 = (TextView) view.findViewById(R.id.p3);
                holder.t4 = (TextView) view.findViewById(R.id.p4);
                holder.t5 = (TextView) view.findViewById(R.id.p5);
                holder.t6 = (TextView) view.findViewById(R.id.p6);
                holder.t7 = (TextView) view.findViewById(R.id.p7);
                holder.t8 = (TextView) view.findViewById(R.id.p8);
                holder.t9 = (TextView) view.findViewById(R.id.p9);
                view.setTag(holder);
            } else
                holder = (ViewHolder) view.getTag();
            //mon0 tue1 wed2 thu3 fri4 sat5 sun6

            holder.dat.setText(day.get(position));
            if (position < p1.size()) {
                add(p0.get(position), holder.t0);
                add(p1.get(position), holder.t1);
                add(p2.get(position), holder.t2);
                add(p3.get(position), holder.t3);
                add(p4.get(position), holder.t4);
                add(p5.get(position), holder.t5);
                add(p6.get(position), holder.t6);


            }
            if (position < p7.size())
                add(p7.get(position), holder.t7);
            if (position < p8.size())
                add(p8.get(position), holder.t8);
            if (position < p9.size())
                add(p9.get(position), holder.t9);
            return view;


        }


        public void add(Subject_struct p, TextView t) {
            Typeface custom_font = Typeface.createFromAsset(context.getAssets(), "fonts/food_icons.ttf");
            t.setTypeface(Typeface.DEFAULT);
            t.setText(" ");
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);

            if (!p.value.contains("break"))
                if (p.value.contains("theory"))
                    t.setText(p.subfh + "\n" + p.roomfh);
                else
                    t.setText(p.subfh + "," + p.subsh + "\n" + p.roomfh + "," + p.roomsh);

            else {
                if (p.value.contains("lunch")) {
                    t.setTypeface(custom_font);
                    t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                    t.setText("BOH");
                } else {

                    t.setTypeface(Typeface.DEFAULT);
                    t.setText(" ");
                }
            }
        }

    }
}
