package nsit.app.com.nsitapp;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Swati garg on 29-06-2015.
 */


public class Subjects extends Fragment {


    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    Button b;

    ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Activity activity;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_subject, container, false);
         lv = (ListView) rootView.findViewById(R.id.list);

        JSONObject ob;
        JSONArray ar, ar2;

        try {
            ob = new JSONObject(Calender.timetable);
            ar = ob.getJSONArray("subjects");

            for(int i=0;i<ar.length();i++)
            {
                list1.add(ar.getJSONObject(i).getString("code"));
                list2.add(ar.getJSONObject(i).getString("title"));
            }

            CustomList_subjects a = new CustomList_subjects(getActivity(),list1,list2);
            lv.addHeaderView(new View(getActivity()));
            lv.addFooterView(new View(getActivity()));
            lv.setAdapter(a);


        }catch (Exception e){
            Log.e("erro",e.getMessage());
        }


        return rootView;
    }


}
