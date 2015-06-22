package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
    Boolean Nsitonline,Collegespace,Crosslinks,Junoon,Bullet,Rotaract;

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
        lv = (ListView) rootView.findViewById(R.id.list);
        Bundle i = this.getArguments();
        Nsitonline = i.getBoolean("nsitonline", false);
        Crosslinks = i.getBoolean("crosslinks", false);
        Collegespace = i.getBoolean("collegespace", false);
        Bullet = i.getBoolean("bullet", false);
        Junoon = i.getBoolean("junoon", false);
        Rotaract = i.getBoolean("rotaract", false);

        if (Nsitonline)
            new DownloadWebPageTask2(Val.id_nsitonline).execute();
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

        if (!Nsitonline && !Collegespace && !Crosslinks && !Bullet && !Junoon && !Rotaract) {
            new DownloadWebPageTask2(Val.id_nsitonline).execute();

        }
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
            if(id== Val.id_junoon)
                URL = "https://graph.facebook.com/"+id+"/feed?access_token=" + Val.common_access;

            else
                URL = "https://graph.facebook.com/"+id+"/feed?since=0000&until=1234567899999999999990&access_token=" + Val.common_access;
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


                Log.e("yo", " " + arr + arr.length());
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
                            list2.add(Integer.toString(a2.length()));   //No of likes
                        }
                        else
                            list2.add("0");

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        Log.e("Error","Errror at : " + i + " "+e.getMessage());
                    }
                }



            } catch (Exception e) {

            }

            switch(id)
            {
                case Val.id_nsitonline : Nsitonline=false;break;
                case Val.id_collegespace :Collegespace=false;break;
                case Val.id_crosslinks : Crosslinks=false;break;
                case Val.id_bullet : Bullet=false;break;
                case Val.id_junoon : Junoon=false;break;
                case Val.id_rotaract : Rotaract=false;break;
            }

            done();

            Log.e("Yo", text);
        }
    }



    public void done()
    {
        if(!Nsitonline&&!Collegespace&&!Crosslinks&&!Bullet&&!Junoon&&!Rotaract) {
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



            CustomList adapter = new CustomList(getActivity(), pic, des, like, link, id);
            lv.addHeaderView(new View(getActivity()));
            lv.addFooterView(new View(getActivity()));
            lv.setAdapter(adapter);
        }
    }



}
