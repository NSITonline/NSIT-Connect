package nsit.app.com.nsitapp;

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
import android.view.View;
import android.view.ViewGroup;
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
    ProgressBar pb,pb2;
    SwipeRefreshLayout swipeLayout;

    List<String> list = new ArrayList<String>();
    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list5 = new ArrayList<String>();
    List<String> list6 = new ArrayList<String>();
    List<String> list7 = new ArrayList<String>();
    ListView lv;
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
        View rootView = inflater.inflate(R.layout.fragment_feedfinal, container, false);
        pb=(ProgressBar)rootView.findViewById(R.id.progressBar1);
        lv = (ListView) rootView.findViewById(R.id.list);
        Bundle i = this.getArguments();
        Crosslinks = i.getBoolean("crosslinks", false);
        Collegespace = i.getBoolean("collegespace", false);
        Bullet = i.getBoolean("bullet", false);
        Junoon = i.getBoolean("junoon", false);
        Rotaract = i.getBoolean("rotaract", false);
        Csi = i.getBoolean("csi", false);
        Ieee = i.getBoolean("ieee", false);
        Deb = i.getBoolean("debsoc", false);
        Quiz = i.getBoolean("quiz", false);
        Ashwa = i.getBoolean("ashwq", false);

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


        if(isNetworkAvailable()){

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

        }
        else
            Toast.makeText(getActivity(), "Cannot connect to Internet", Toast.LENGTH_SHORT).show();

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
            URL = "https://graph.facebook.com/"+id+"/feed?fields=picture,shares,message,object_id,link,comments.limit(0).summary(true),likes.limit(0).summary(true)&access_token=" + Val.common_access;
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

                    } catch (Exception e) {
                         Log.e("Error","Errror at : " + i + " "+e.getMessage());
                    }
                }


            } catch (Exception e) {
                Log.e("Error","Errror at : "+ " "+e.getMessage());

            }

            switch(id)
            {
                case Val.id_collegespace :Collegespace=false;break;
                case Val.id_crosslinks : Crosslinks=false;break;
                case Val.id_bullet : Bullet=false;break;
                case Val.id_junoon : Junoon=false;break;
                case Val.id_rotaract : Rotaract=false;break;
                case Val.id_csi :Csi=false;break;
                case Val.id_ieee : Ieee=false;break;
                case Val.id_quiz : Quiz=false;break;
                case Val.id_ashwa : Ashwa=false;break;
                case Val.id_debsoc : Deb=false;break;
            }

            done();

        }
    }



    public void done()
    {


        Log.e("status : "," "+ Csi + Collegespace+Crosslinks+Crosslinks+Bullet+Junoon+Ieee+Ashwa+Quiz+Deb+Rotaract);
        if(!Csi && !Collegespace && !Crosslinks && !Bullet && !Junoon && !Ieee&& !Ashwa&& !Quiz&& !Deb &&!Rotaract) {
            String[] id = new String[list.size()];
            String[] des = new String[list.size()];
            String[] pic = new String[list.size()];
            String[] like = new String[list.size()];
            String[] link = new String[list.size()];


            des = list.toArray(des);
            like = list2.toArray(like);
            id = list1.toArray(id);
            pic = list6.toArray(pic);
            link = list7.toArray(link);

            Log.e("EFinish","All done");


            pb.setVisibility(View.GONE);
            CustomList adapter = new CustomList(getActivity(), pic, des, like, link, id);
            lv.addHeaderView(new View(getActivity()));
            lv.addFooterView(new View(getActivity()));
            lv.setAdapter(adapter);
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
