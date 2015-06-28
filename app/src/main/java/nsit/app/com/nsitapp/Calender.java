package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 28-06-2015.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
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
import org.json.JSONObject;
import org.lucasr.twowayview.TwoWayView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Calender extends Fragment {

     boolean loadingMore=false;
    static  ArrayList<String> days = new ArrayList<String>();
    static  ArrayList<String> p1 = new ArrayList<String>();
    static  ArrayList<String> p2 = new ArrayList<String>();
    static  ArrayList<String> p3 = new ArrayList<String>();
    static  ArrayList<String> p4 = new ArrayList<String>();
    static  ArrayList<String> p5 = new ArrayList<String>();
    static  ArrayList<String> p6 = new ArrayList<String>();
    static  ArrayList<String> p7 = new ArrayList<String>();
    static  ArrayList<String> p8 = new ArrayList<String>();
    CustomList3 adapter2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        TwoWayView lvTest = (TwoWayView) rootView.findViewById(R.id.lvItems);


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


        return rootView;
    }


   void load()
   {
       days.add("Monday");
       days.add("Tuesday");
       days.add("Wednesday");
       days.add("Thursday");
       days.add("Friday");
       days.add("Saturday");
       days.add("Sunday");



       p1.add("Subject 1");
       p1.add("Subject 2");
       p1.add("Subject 3");
       p1.add("Subject 4");
       p1.add("Subject 5");
       p1.add("Subject 6");
       p1.add("Subject 7");
       p1.add("Subject 8");


       p2.add("Subject 2");
       p2.add("Subject 3");
       p2.add("Subject 4");
       p2.add("Subject 6");
       p2.add("Subject 7");
       p2.add("Subject 8");
       p2.add("Subject 1");
       p2.add("Subject 2");


       p3.add("Subject 2");
       p3.add("Subject 2");
       p3.add("Subject 3");
       p3.add("Subject 4");
       p3.add("Subject 2");
       p3.add("Subject 4");
       p3.add("Subject 6");
       p3.add("Subject 8");

       p4.add("Subject 2");
       p4.add("Subject 1");
       p4.add("Subject 2");
       p4.add("Subject 8");
       p4.add("Subject 9");
       p4.add("Subject 5");
       p4.add("Subject 3");
       p4.add("Subject 2");

       p5.add("Subject 1");
       p5.add("Subject 1");
       p5.add("Subject 2");
       p5.add("Subject 5");
       p5.add("Subject 3");
       p5.add("Subject 1");
       p5.add("Subject 3");
       p5.add("Subject 2");


       p6.add("Subject 9");
       p6.add("Subject 1");
       p6.add("Subject 8");
       p6.add("Subject 6");
       p6.add("Subject 5");
       p6.add("Subject 2");
       p6.add("Subject 1");
       p6.add("Subject 2");


       p7.add("Subject 1");
       p7.add("Subject 2");
       p7.add("Subject 3");
       p7.add("Subject 6");
       p7.add("Subject 8");
       p7.add("Subject 1");
       p7.add("Subject 3");
       p7.add("Subject 4");
       p7.add("Subject 4");


       p8.add("Subject 1");
       p8.add("Subject 4");
       p8.add("Subject 2");
       p8.add("Subject 1");
       p8.add("Subject 8");
       p8.add("Subject 7");
       p8.add("Subject 4");
       p8.add("Subject 3");
   }
}
