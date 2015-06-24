package nsit.app.com.nsitapp;

/**
 * Created by kamlesh kumar garg on 21-06-2015.
 */

import android.app.Activity;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Feed extends Fragment {
    ProgressBar pb,pb2;
    CheckBox nsitonline,collegespace,crosslinks,junoon,bullet,rotaract;
    Boolean Nsitonline=false,Collegespace=false,Crosslinks=false,Junoon=false,Bullet=false,Rotaract=false;
    TextView tNsitonline,tCollegespace,tCrosslinks,tJunoon,tBullet,tRotaract;
    Button next;
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
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        lv = (ListView) rootView.findViewById(R.id.list);
        next = (Button) rootView.findViewById(R.id.next);
        nsitonline = (CheckBox) rootView.findViewById(R.id.check_nsitonline);
        collegespace = (CheckBox) rootView.findViewById(R.id.check_collegespace);
        crosslinks = (CheckBox) rootView.findViewById(R.id.check_crosslinks);
        junoon = (CheckBox) rootView.findViewById(R.id.check_junoon);
        rotaract = (CheckBox) rootView.findViewById(R.id.check_rotaract);
        bullet = (CheckBox) rootView.findViewById(R.id.check_bullet);
        tNsitonline = (TextView) rootView.findViewById(R.id.stars_nsitonline);
        tCollegespace = (TextView) rootView.findViewById(R.id.stars_collegespace);
        tCrosslinks = (TextView) rootView.findViewById(R.id.stars_crosslinks);
        tJunoon = (TextView) rootView.findViewById(R.id.stars_junoon);
        tRotaract = (TextView) rootView.findViewById(R.id.stars_rotaract);
        tBullet = (TextView) rootView.findViewById(R.id.stars_bullethawk);

        nsitonline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Nsitonline = b;
            }
        });
        crosslinks.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Crosslinks = b;
            }
        });
        collegespace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Collegespace = b;
            }
        });
        bullet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Bullet = b;
            }
        });
        junoon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Junoon = b;
            }
        });
        rotaract.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Rotaract = b;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment mFragment = new FinalFeed();
                Bundle bundle = new Bundle();
                bundle.putBoolean("nsitonline", Nsitonline);
                bundle.putBoolean("crosslinks", Crosslinks);
                bundle.putBoolean("collegespace", Collegespace);
                bundle.putBoolean("bullet", Bullet);
                bundle.putBoolean("junoon", Junoon);
                bundle.putBoolean("rotaract", Rotaract);
                mFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack( "tag" ).commit();
            }
        });

        if(isNetworkAvailable()) {

            new Calclike(tNsitonline, Val.id_nsitonline).execute();
            new Calclike(tCrosslinks, Val.id_crosslinks).execute();
            new Calclike(tCollegespace, Val.id_collegespace).execute();
            new Calclike(tJunoon, Val.id_junoon).execute();
            new Calclike(tBullet, Val.id_bullet).execute();
            new Calclike(tRotaract, Val.id_rotaract).execute();
        }
        else
            Toast.makeText(getActivity(), "Cannot connect to Internet", Toast.LENGTH_SHORT).show();


        return rootView;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    String text;
    private class Calclike extends AsyncTask<String, Void, String> {
        TextView bmImage;
        String id;

        public Calclike(TextView bmImage,String id) {
            this.bmImage = bmImage;
            this.id = id;
        }

        @Override
        protected String doInBackground(String... urls) {

            Log.e("Yo", "Started");
            String URL = "https://graph.facebook.com/"+id+"?access_token=" + Val.common_access;
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
            //pd.dismiss();
            //Toast.makeText(MainActivity.this,"Response : " + text , Toast.LENGTH_LONG).show();
            Log.e("yrs", text);

            int j = 0;
            JSONObject ob;
            JSONArray arr;
            try {
                ob = new JSONObject(text);
                if(ob.has("likes"))
                    text = ob.getString("likes");
                else
                    text="1000";
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
            }
            bmImage.setText(text);
        }
    }

}
