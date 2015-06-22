package nsit.app.com.nsitapp;

/**
 * Created by kamlesh kumar garg on 21-06-2015.
 */

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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


public class Home extends Fragment {

    List<String> list = new ArrayList<String>();
    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list5 = new ArrayList<String>();
    List<String> list6 = new ArrayList<String>();
    List<String> list7 = new ArrayList<String>();
    ListView lv;
    SwipeRefreshLayout swipeLayout;

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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        lv = (ListView) rootView.findViewById(R.id.list);
        swipeLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_container);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new DownloadWebPageTask2(Val.id_nsitonline).execute();
            }
        });
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        new DownloadWebPageTask2(Val.id_nsitonline).execute();
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


            swipeLayout.setRefreshing(false);
            CustomList adapter = new CustomList(getActivity(), pic, des, like, link, id);
            lv.addHeaderView(new View(getActivity()));
            lv.addFooterView(new View(getActivity()));
            lv.setAdapter(adapter);
            Log.e("Yo", text);
        }
    }

}
