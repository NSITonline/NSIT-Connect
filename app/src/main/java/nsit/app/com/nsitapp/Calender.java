package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 28-06-2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.List;

public class Calender extends Fragment {

  /*  public static final String timetable = "{\"subjects\":[{\"code\":\"IT-311\",\"title\":\"Multimedia and Applications\"},{\"code\":\"IT-312\",\"title\":\"Software Engg.\"},{\"code\":\"IT-313\",\"title\":\"Information Theory\"},{\"code\":\"IT-314\",\"title\":\"Elective-1\"},{\"code\":\"IT-315\",\"title\":\"Microwave Engg.\"},{\"code\":\"IT-316\",\"title\":\"Multimedia Lab\"}],\"professors\":[{\"codename\":\"UG\",\"fullname\":\"Usha Gautam\"},{\"codename\":\"APS\",\"fullname\":\"Apoorvi Sood\"},{\"codename\":\"RTS\",\"fullname\":\"Ritu Sibal\"}],\"timetable\":[[{\"subject\":\"IT-315\",\"professor\":\"UG\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-312\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-313\",\"professor\":\"VMM\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-314\",\"professor\":\"VMM\",\"type\":\"theory\",\"room\":\"102/8A\"}],[{\"subject\":\"IT-315\",\"professor\":\"UG\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-312\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-313\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-314\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-317\",\"type\":\"lab\",\"professorFH\":\"VMM\",\"roomFH\":\"102/8A\",\"professorSH\":\"VMK\",\"roomSH\":\"103/8A\"},{\"subject\":\"break\"}],[{\"subject\":\"IT-315\",\"professor\":\"UG\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-312\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-313\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-314\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-317\",\"type\":\"lab\",\"professorFH\":\"VMM\",\"roomFH\":\"102/8A\",\"professorSH\":\"VMK\",\"roomSH\":\"103/8A\"},{\"subject\":\"break\"}],[{\"subject\":\"IT-315\",\"professor\":\"UG\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-312\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-313\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-314\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-317\",\"type\":\"lab\",\"professorFH\":\"VMM\",\"roomFH\":\"102/8A\",\"professorSH\":\"VMK\",\"roomSH\":\"103/8A\"},{\"subject\":\"break\"}],[{\"subject\":\"IT-315\",\"professor\":\"UG\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-312\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-313\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-314\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-317\",\"type\":\"lab\",\"professorFH\":\"VMM\",\"roomFH\":\"102/8A\",\"professorSH\":\"VMK\",\"roomSH\":\"103/8A\"},{\"subject\":\"break\"}],[{\"subject\":\"IT-315\",\"professor\":\"UG\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-312\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-313\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-314\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-317\",\"type\":\"lab\",\"professorFH\":\"VMM\",\"roomFH\":\"102/8A\",\"professorSH\":\"VMK\",\"roomSH\":\"103/8A\"},{\"subject\":\"break\"}],[{\"subject\":\"IT-315\",\"professor\":\"UG\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"type\":\"theory\",\"room\":\"102/8A\"},{\"subject\":\"IT-311\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-312\",\"professor\":\"RTS\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-313\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-314\",\"professor\":\"VMM\",\"room\":\"102/8A\",\"type\":\"theory\"},{\"subject\":\"IT-317\",\"type\":\"lab\",\"professorFH\":\"VMM\",\"roomFH\":\"102/8A\",\"professorSH\":\"VMK\",\"roomSH\":\"103/8A\"},{\"subject\":\"break\"}]]}";*/

    static String timetable;

    boolean loadingMore=false;
    static  ArrayList<String> days = new ArrayList<String >();
    static  ArrayList<Subject_struct> p1 = new ArrayList<Subject_struct>();
    static  ArrayList<Subject_struct> p2 = new ArrayList<Subject_struct>();
    static  ArrayList<Subject_struct> p3 = new ArrayList<Subject_struct>();
    static  ArrayList<Subject_struct> p4 = new ArrayList<Subject_struct>();
    static  ArrayList<Subject_struct> p5 = new ArrayList<Subject_struct>();
    static  ArrayList<Subject_struct> p6 = new ArrayList<Subject_struct>();
    static  ArrayList<Subject_struct> p7 = new ArrayList<Subject_struct>();
    static  ArrayList<Subject_struct> p8 = new ArrayList<Subject_struct>();
    CustomList3 adapter2;
    TwoWayView lvTest;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    Activity activity;
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calender, container, false);
        lvTest = (TwoWayView) rootView.findViewById(R.id.lvItems);


Intent i = new Intent(getActivity(),Choose.class);
        startActivity(i);


        if(isNetworkAvailable())
        new DownloadWebPageTask2().execute();
        else
            Toast.makeText(getActivity(), "Cannot connect to Internet", Toast.LENGTH_SHORT).show();


        adapter2 = new CustomList3(getActivity(), days, p1,p2,p3,p4,p5,p6,p7,p8);




        return rootView;
    }








   void load() {
       JSONObject ob;
       JSONArray ar, ar2;

       try {
           ob = new JSONObject(timetable);
           ar = ob.getJSONArray("timetable");

           for(int j=0;j<ar.length();j++){
           ar2 = ar.getJSONArray(j);

// subject,type,professorfh,roomfh,professorsh,roomsh,professor,room;

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
               switch (i) {
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


               }
           }
           }
       } catch (Exception e) {
            Log.e("Error",e.getMessage());
       }
       days.add("Monday");
       days.add("Tuesday");
       days.add("Wednesday");
       days.add("Thursday");
       days.add("Friday");
       days.add("Saturday");
       days.add("Sunday");
   }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.subjects){

            Fragment mFragment = new Subjects();
             getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack(                    "tag").commit();

        }

        return super.onOptionsItemSelected(item);
    }





    String text;
    private class DownloadWebPageTask2 extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... urls) {

            Log.e("Yo", "Started");
            String URL;
            URL = "https://docs.google.com/uc?id=0B9uRC8Uvb5sFZFdNcVJVN0VhUEE&export=download";
            HttpClient Client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                text = Client.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(String result) {
            Log.e("YO", "Done");
            Log.e("yrs", "" + text);

            timetable = text;
            load();
            adapter2 = new CustomList3(getActivity(), days, p1,p2,p3,p4,p5,p6,p7,p8);
            lvTest.setAdapter(adapter2);
            lvTest.setItemMargin(10);
            lvTest.setOnScrollListener(new TwoWayView.OnScrollListener() {
                //useless here, skip!
                @Override
                public void onScrollStateChanged(TwoWayView view, int scrollState) {
                }

                @Override
                public void onScroll(TwoWayView view, int firstVisibleItem,
                                     int visibleItemCount, int totalItemCount) {
                    //what is the bottom iten that is visible
                    int lastInScreen = firstVisibleItem + visibleItemCount;
                    //is the bottom item visible & not loading more already ? Load more !
                    if ((lastInScreen == totalItemCount) && !(loadingMore)) {
                        load();
                    }
                    adapter2.notifyDataSetChanged();
                }
            });

        }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_calender, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
