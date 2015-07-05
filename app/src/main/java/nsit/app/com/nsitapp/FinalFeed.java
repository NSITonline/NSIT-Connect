package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
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
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
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
 * Created by Swati garg on 21-06-2015.
 */


public class FinalFeed extends Fragment {
    Boolean Collegespace=false,Crosslinks=false,Junoon=false,Bullet=false,Rotaract=false,Quiz=false,Ieee=false,Csi=false,Ashwa=false,Deb=false;
    boolean loadingMore=false;
    ProgressBar pb,pb2;
    SwipeRefreshLayout swipeLayout;
    String nextn;
    CustomList adapter;
    int first;
   String nextcollegespace,nextcrosslinks,nextjunoon,nextbullet,nextrotaract,nextquiz,nextieee,nextcsi,nextashwa,nextdeb;
    List<String> list = new ArrayList<String>();
    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list5 = new ArrayList<String>();
    List<String> list6 = new ArrayList<String>();
    List<String> list7 = new ArrayList<String>();
    List<String> list8 = new ArrayList<String>();
    View footerView;
    SharedPreferences i;
    ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setHasOptionsMenu(true);
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
        View rootView = inflater.inflate(R.layout.fragment_feedfinal, container, false);
        pb=(ProgressBar)rootView.findViewById(R.id.progressBar1);
        lv = (ListView) rootView.findViewById(R.id.list);
        first=1;



         i = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        Crosslinks = i.getBoolean("crosslinks", false);
        Collegespace = i.getBoolean("collegespace", false);
        Bullet = i.getBoolean("bullet", false);
        Junoon = i.getBoolean("junoon", false);
        Rotaract = i.getBoolean("rotaract", false);
        Csi = i.getBoolean("csi", false);
        Ieee = i.getBoolean("ieee", false);
        Deb = i.getBoolean("debsoc", false);
        Quiz = i.getBoolean("quiz", false);
        Ashwa = i.getBoolean("ashwa", false);




        footerView = ((LayoutInflater)getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer_layout, null, false);
        lv.addFooterView(footerView);

        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeLayout.setRefreshing(false);
            }
        });
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        if(!Csi && !Collegespace && !Crosslinks && !Bullet && !Junoon && !Ieee&& !Ashwa&& !Quiz&& !Deb &&!Rotaract) {
            Toast.makeText(getActivity(),"No item selected",Toast.LENGTH_SHORT).show();
        }else {

            if (isNetworkAvailable()) {


                if (Crosslinks)
                    new DownloadWebPageTask2(Val.id_crosslinks).execute();
                if (Collegespace)
                    new DownloadWebPageTask2(Val.id_collegespace).execute();
                if (Bullet)
                    new DownloadWebPageTask2(Val.id_bullet).execute();
                if (Junoon)
                    new DownloadWebPageTask2(Val.id_junoon).execute();
                if (Rotaract)
                    new DownloadWebPageTask2(Val.id_rotaract).execute();
                if (Csi)
                    new DownloadWebPageTask2(Val.id_csi).execute();
                if (Ieee)
                    new DownloadWebPageTask2(Val.id_ieee).execute();
                if (Ashwa)
                    new DownloadWebPageTask2(Val.id_ashwa).execute();
                if (Quiz)
                    new DownloadWebPageTask2(Val.id_quiz).execute();
                if (Deb)
                    new DownloadWebPageTask2(Val.id_debsoc).execute();

            } else
                Toast.makeText(getActivity(), "Cannot connect to Internet", Toast.LENGTH_SHORT).show();

        }

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                int lastInScreen = firstVisibleItem + visibleItemCount;
                if ((lastInScreen == totalItemCount) && !(loadingMore) && first!=1) {
                    loadingMore=true;
                    lv.addFooterView(footerView);
                    if(isNetworkAvailable()){
                        Crosslinks = i.getBoolean("crosslinks", false);
                        Collegespace = i.getBoolean("collegespace", false);
                        Bullet = i.getBoolean("bullet", false);
                        Junoon = i.getBoolean("junoon", false);
                        Rotaract = i.getBoolean("rotaract", false);
                        Csi = i.getBoolean("csi", false);
                        Ieee = i.getBoolean("ieee", false);
                        Deb = i.getBoolean("debsoc", false);
                        Quiz = i.getBoolean("quiz", false);
                        Ashwa = i.getBoolean("ashwa", false);
                        if (Crosslinks)
                            new DownloadWebPageTask3(Val.id_crosslinks,nextcrosslinks).execute();
                        if (Collegespace)
                            new DownloadWebPageTask3(Val.id_collegespace,nextcollegespace).execute();
                        if (Bullet)
                            new DownloadWebPageTask3(Val.id_bullet,nextbullet).execute();
                        if (Junoon)
                            new DownloadWebPageTask3(Val.id_junoon,nextjunoon).execute();
                        if (Rotaract)
                            new DownloadWebPageTask3(Val.id_rotaract,nextrotaract).execute();
                        if (Csi)
                            new DownloadWebPageTask3(Val.id_csi,nextcsi).execute();
                        if (Ieee)
                            new DownloadWebPageTask3(Val.id_ieee,nextieee).execute();
                        if (Ashwa)
                            new DownloadWebPageTask3(Val.id_ashwa,nextashwa).execute();
                        if (Quiz)
                            new DownloadWebPageTask3(Val.id_quiz,nextquiz).execute();
                        if (Deb)
                            new DownloadWebPageTask3(Val.id_debsoc,nextdeb).execute();

                    }
                    else
                        Toast.makeText(getActivity(), "Cannot connect to Internet", Toast.LENGTH_SHORT).show();



                }

            }
        });




        return rootView;
    }

    String text;
    private class DownloadWebPageTask2 extends AsyncTask<String, Void, String> {
        String id;

        public DownloadWebPageTask2(String id) {
            this.id = id;
        }

        @Override
        protected String doInBackground(String... urls) {

            Log.e("Yo", "Started");
            String URL;
            URL = "https://graph.facebook.com/" + id + "/feed?limit=10&fields=picture,shares,message,object_id,link,comments.limit(0).summary(true),likes.limit(0).summary(true)&access_token=" + Val.common_access;
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
            Log.e("yrs",""+text);

            int j=0;
            JSONObject ob;
            JSONArray arr;
            try {
                ob = new JSONObject(text);
                arr = ob.getJSONArray("data");


                for(int i = 0; i < arr.length(); i++){
                    try {
                        if(arr.getJSONObject(i).has("message")&&arr.getJSONObject(i).has("picture")&&arr.getJSONObject(i).has("link")&&arr.getJSONObject(i).has("likes")) {
                            list.add(arr.getJSONObject(i).getString("message"));
                        }
                        else {
                            continue;
                        }
                        if(!(arr.getJSONObject(i).has("object_id")))
                            list1.add(null);
                        else
                            list1.add(arr.getJSONObject(i).getString("object_id"));



                        if(arr.getJSONObject(i).has("picture")) {
                            list6.add(arr.getJSONObject(i).getString("picture"));
                        }
                        else
                            list6.add(null);
                        if(arr.getJSONObject(i).has("link")) {
                            list7.add(arr.getJSONObject(i).getString("link"));
                        }
                        else
                            list7.add(null);
                        if(arr.getJSONObject(i).has("likes")) {
                            String s = arr.getJSONObject(i).getString("likes");
                            JSONObject o = new JSONObject(s);
                            JSONArray a2 = o.getJSONArray("data");
                            String x = o.getString("summary");
                            JSONObject o2 = new JSONObject(x);

                            list2.add(o2.getString("total_count"));    //No of likes
                        }
                        else
                            list2.add("0");


                        list8.add(arr.getJSONObject(i).getString("created_time"));
                    } catch (Exception e) {
                         Log.e("Error","Errror at : " + i + " "+e.getMessage());
                    }
                }
                ob = ob.getJSONObject("paging");
                nextn = ob.getString("next");


            } catch (Exception e) {
                Log.e("Error","Errror at : "+ " "+e.getMessage());

            }
            if(first==1) {

                switch (id) {
                    case Val.id_collegespace:nextcollegespace=nextn;
                        Collegespace = false;
                        break;
                    case Val.id_crosslinks:nextcrosslinks=nextn;
                        Crosslinks = false;
                        break;
                    case Val.id_bullet:nextbullet=nextn;
                        Bullet = false;
                        break;
                    case Val.id_junoon:nextjunoon=nextn;
                        Junoon = false;
                        break;
                    case Val.id_rotaract:nextrotaract=nextn;
                        Rotaract = false;
                        break;
                    case Val.id_csi:nextcsi=nextn;
                        Csi = false;
                        break;
                    case Val.id_ieee:nextieee=nextn;
                        Ieee = false;
                        break;
                    case Val.id_quiz:nextquiz=nextn;
                        Quiz = false;
                        break;
                    case Val.id_ashwa:nextashwa=nextn;
                        Ashwa = false;
                        break;
                    case Val.id_debsoc:nextdeb=nextn;
                        Deb = false;
                        break;
                }

                done();
            }

        }
    }

    private class DownloadWebPageTask3 extends AsyncTask<String, Void, String> {
        String id,token,next;

        public DownloadWebPageTask3(String id,String n) {
            this.id = id;
            next=n;
        }

        @Override
        protected String doInBackground(String... urls) {

            Log.e("Yo", "Started");
            String URL;

            String[] x = next.split("&__paging_token=");
            token=x[1];

            URL = "https://graph.facebook.com/" + id + "/feed?limit=10&fields=picture,shares,message,object_id,link,comments.limit(0).summary(true)" +
                    ",likes.limit(0).summary(true)&access_token=" + Val.common_access+"&__paging_token="+token;
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
            Log.e("yrs",""+text);

            int j=0;
            JSONObject ob;
            JSONArray arr;
            try {
                ob = new JSONObject(text);
                arr = ob.getJSONArray("data");


                for(int i = 0; i < arr.length(); i++){
                    try {
                        if(arr.getJSONObject(i).has("message")&&arr.getJSONObject(i).has("picture")&&arr.getJSONObject(i).has("link")&&arr.getJSONObject(i).has("likes")) {
                            list.add(arr.getJSONObject(i).getString("message"));
                        }
                        else {
                            continue;
                        }
                        if(!(arr.getJSONObject(i).has("object_id")))
                            list1.add(null);
                        else
                            list1.add(arr.getJSONObject(i).getString("object_id"));



                        if(arr.getJSONObject(i).has("picture")) {
                            list6.add(arr.getJSONObject(i).getString("picture"));
                        }
                        else
                            list6.add(null);
                        if(arr.getJSONObject(i).has("link")) {
                            list7.add(arr.getJSONObject(i).getString("link"));
                        }
                        else
                            list7.add(null);
                        if(arr.getJSONObject(i).has("likes")) {
                            String s = arr.getJSONObject(i).getString("likes");
                            JSONObject o = new JSONObject(s);
                            JSONArray a2 = o.getJSONArray("data");
                            String x = o.getString("summary");
                            JSONObject o2 = new JSONObject(x);

                            list2.add(o2.getString("total_count"));    //No of likes
                        }
                        else
                            list2.add("0");

                        list8.add(arr.getJSONObject(i).getString("created_time"));





                    } catch (Exception e) {
                        Log.e("Error","Errror at : " + i + " "+e.getMessage());
                    }
                    ob = ob.getJSONObject("paging");
                    nextn = ob.getString("next");

                }


            } catch (Exception e) {
                Log.e("Error","Errror at : "+ " "+e.getMessage());

            }

                switch (id) {
                    case Val.id_collegespace: nextcollegespace=nextn;
                        break;
                    case Val.id_crosslinks:nextcrosslinks=nextn;
                        Crosslinks = false;
                        break;
                    case Val.id_bullet:nextbullet=nextn;
                        Bullet = false;
                        break;
                    case Val.id_junoon:nextjunoon=nextn;
                        Junoon = false;
                        break;
                    case Val.id_rotaract:nextrotaract=nextn;
                        Rotaract = false;
                        break;
                    case Val.id_csi:nextcsi=nextn;
                        Csi = false;
                        break;
                    case Val.id_ieee:nextieee=nextn;
                        Ieee = false;
                        break;
                    case Val.id_quiz:nextquiz=nextn;
                        Quiz = false;
                        break;
                    case Val.id_ashwa:nextashwa=nextn;
                        Ashwa = false;
                        break;
                    case Val.id_debsoc:nextdeb=nextn;
                        Deb = false;
                        break;
             }
            adapter.notifyDataSetChanged();
            loadingMore=false;
            lv.removeFooterView(footerView);


        }
    }


    public void done()
    {


        Log.e("status : "," "+ Csi + Collegespace+Crosslinks+Crosslinks+Bullet+Junoon+Ieee+Ashwa+Quiz+Deb+Rotaract);
        if(!Csi && !Collegespace && !Crosslinks && !Bullet && !Junoon && !Ieee&& !Ashwa&& !Quiz&& !Deb &&!Rotaract) {

            Log.e("EFinish", "All done");


            pb.setVisibility(View.GONE);

            lv.removeFooterView(footerView);

            adapter = new CustomList(getActivity(), list6, list, list2, list7, list1, list8);
            lv.addHeaderView(new View(getActivity()));
            lv.addFooterView(new View(getActivity()));
            lv.setAdapter(adapter);
            first = 0;
            Log.e("first","zero");

        }
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_feed, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.items){

            Fragment mFragment = new Feed();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mFragment).commit();
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
