package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 28-06-2015.
 */
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
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

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lucasr.twowayview.TwoWayView;

import java.io.IOException;
import java.util.ArrayList;
import functions.Constant;
import functions.Utils;

public class Calender extends Fragment implements Constant {

    static String timetable = null;
    boolean loadingMore = false;
    static ArrayList<String> days = new ArrayList<String>();
    static ArrayList<Subject_struct> p0 = new ArrayList<Subject_struct>();
    static ArrayList<Subject_struct> p1 = new ArrayList<Subject_struct>();
    static ArrayList<Subject_struct> p2 = new ArrayList<Subject_struct>();
    static ArrayList<Subject_struct> p3 = new ArrayList<Subject_struct>();
    static ArrayList<Subject_struct> p4 = new ArrayList<Subject_struct>();
    static ArrayList<Subject_struct> p5 = new ArrayList<Subject_struct>();
    static ArrayList<Subject_struct> p6 = new ArrayList<Subject_struct>();
    static ArrayList<Subject_struct> p7 = new ArrayList<Subject_struct>();
    static ArrayList<Subject_struct> p8 = new ArrayList<Subject_struct>();
    static ArrayList<Subject_struct> p9 = new ArrayList<Subject_struct>();
    CustomList_calendar adapter2;
    TwoWayView lvTest;
    SharedPreferences s;
    SharedPreferences.Editor e;
    static Activity activity;

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
        if (activity == null)
            return rootView;


        s = PreferenceManager.getDefaultSharedPreferences(activity);
        e = s.edit();
        Boolean b = s.getBoolean(IS_CLASS_SET, false);
        if (!b) {
            Intent i = new Intent(activity, ChooseClass.class);
            startActivity(i);
        }


        Boolean a = s.getBoolean(IS_TIME_TABLE_CHANGED, true);
        timetable = s.getString(GET_TIME_TABLE, null);

        adapter2 = new CustomList_calendar(activity, days, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        lvTest.setAdapter(adapter2);
        lvTest.setItemMargin(10);



        if (a == true || timetable == null) {
            if (Utils.isNetworkAvailable(activity))
                new DownloadWebPageTask2().execute();
            else {
                SnackbarManager.show(
                        Snackbar.with(activity.getApplicationContext())
                                .text("Check Your Internet Connection")
                                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);
            }
        } else {
            load();
        }




        lvTest.setOnScrollListener(new TwoWayView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(TwoWayView view, int scrollState) {
            }

            @Override
            public void onScroll(TwoWayView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                int lastInScreen = firstVisibleItem + visibleItemCount;
                if ((lastInScreen == totalItemCount) && !(loadingMore)) {
                    load();
                }
                adapter2.notifyDataSetChanged();
            }
        });
        return rootView;
    }


    void load() {
        JSONObject ob;
        JSONArray ar, ar2;
        if (activity == null)
            return;


        SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
        timetable = s.getString(GET_TIME_TABLE, null);

        if (timetable == null)
            return;

        try {
            ob = new JSONObject(timetable);
            ar = ob.getJSONArray(GET_TIME_TABLE);

            for (int j = 0; j < ar.length(); j++) {
                ar2 = ar.getJSONArray(j);

                String a, b, c, d, e, f, g, h;
                for (int i = 0; i < ar2.length(); i++) {
                    a = ar2.getJSONObject(i).getString("subject");

                    if (a.contains("break")) {
                        b = c = d = e = f = g = h = null;
                    } else {
                        b = ar2.getJSONObject(i).getString("type");

                        if (b.contains("theory")) {
                            g = ar2.getJSONObject(i).getString("professor");
                            h = ar2.getJSONObject(i).getString("room");
                            c = d = e = f = null;
                        } else {
                            g = null;
                            h = null;
                            c = ar2.getJSONObject(i).getString("professorFH");
                            d = ar2.getJSONObject(i).getString("roomFH");
                            e = ar2.getJSONObject(i).getString("professorSH");
                            f = ar2.getJSONObject(i).getString("roomSH");

                        }
                    }
                    Subject_struct x = new Subject_struct(a, b, c, d, e, f, g, h);
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
        } catch (Exception e) {
        }
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        adapter2.notifyDataSetChanged();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.subjects) {
            Intent i = new Intent(activity, SubjectsShow.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.choose) {
            Intent i = new Intent(activity, ChooseClass.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }



    private class DownloadWebPageTask2 extends AsyncTask<String, Void, String> {

        ProgressDialog progress;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
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
            lvTest.scrollTo(0, 0);
            adapter2.notifyDataSetChanged();
            progress = new ProgressDialog(activity);
            progress.setTitle("Loading");
            progress.setMessage("Fetching timetable...");

        }

        @Override
        protected String doInBackground(String... urls) {

            int branch,sem,sec;
            branch = s.getInt(CALENDAR_BRANCH, 1);
            sec = s.getInt(CALENDAR_SECTION, 1);
            sem = s.getInt(CALENDAR_SEM, 1);
            String text = null;




            String URL;
            URL = "http://nsitonline.in/NSITconnect/api/get-data.php?branch=" +
                    branch +
                    "&semester=" +
                    sem +
                    "&section=" +
                    sec;
            HttpClient Client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                text = Client.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return text;

        }

        @Override
        protected void onPostExecute(String result) {
            timetable = result;
            if (activity == null)
                return;


            e.putBoolean(IS_TIME_TABLE_CHANGED, false);
            e.putString(GET_TIME_TABLE, result);
            e.commit();


            JSONObject ob;

            if (timetable == null)
                return;
            try {
                ob = new JSONObject(timetable);
                ob = ob.getJSONObject("metadata");
                String s2 = ob.optString("last_updated","null");
                if (s2.equals("null")) {
                    SnackbarManager.show(
                            Snackbar.with(activity.getApplicationContext())
                                    .text("Sorry, Time Table is not available now. It will be updated shortly.")
                                    .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            adapter2 = new CustomList_calendar(activity, days, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
            load();
            lvTest.setAdapter(adapter2);
            lvTest.setItemMargin(10);
            lvTest.setOnScrollListener(new TwoWayView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(TwoWayView view, int scrollState) {
                }

                @Override
                public void onScroll(TwoWayView view, int firstVisibleItem,
                                     int visibleItemCount, int totalItemCount) {
                    int lastInScreen = firstVisibleItem + visibleItemCount;
                    if ((lastInScreen == totalItemCount) && !(loadingMore)) {
                        load();
                    }
                    adapter2.notifyDataSetChanged();
                }
            });

            progress.dismiss();

        }
    }

    @Override
    public void onResume() {
        if (activity != null) {

            Boolean a = s.getBoolean(IS_TIME_TABLE_CHANGED, true);
            timetable = s.getString(GET_TIME_TABLE, null);
            adapter2 = new CustomList_calendar(activity, days, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
            lvTest.setAdapter(adapter2);
            lvTest.setItemMargin(10);

            if (a || timetable == null) {
                if (Utils.isNetworkAvailable(activity))
                    new DownloadWebPageTask2().execute();
                else {
                    if (activity != null)
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
            super(context, R.layout.message, d);
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

            TextView dat;
            TextView t0;
            TextView t1;
            TextView t2;
            TextView t3;
            TextView t4;
            TextView t5;
            TextView t6;
            TextView t7;
            TextView t8;
            TextView t9;

        }


        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            ViewHolder holder = null;
            if (view == null) {
                view = mInflater.inflate(R.layout.timetable_row_layout, null);
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

            if (!p.subject.contains("break"))
                if (p.type.contains("theory"))
                    t.setText(p.subject + "\n" + p.room);
                else
                    t.setText(p.subject + "\n" + p.roomfh + "," + p.roomsh);

            else {
                if (p.subject.contains("lunch")) {
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
