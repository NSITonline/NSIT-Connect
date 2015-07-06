package nsit.app.com.nsitapp;

/**
 * Created by kamlesh kumar garg on 21-06-2015.
 */

import android.app.Activity;
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
    CheckBox collegespace,crosslinks,junoon,bullet,rotaract,quiz,ieee,csi,ashwa,deb;
    Boolean Collegespace=false,Crosslinks=false,Junoon=false,Bullet=false,Rotaract=false,Quiz=false,Ieee=false,Csi=false,Ashwa=false,Deb=false;
    TextView tCollegespace,tCrosslinks,tJunoon,tBullet,tRotaract,tQuiz,tIeee,tCsi,tAshwa,tDeb;
    Button next;
    List<String> list = new ArrayList<String>();
    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list5 = new ArrayList<String>();
    List<String> list6 = new ArrayList<String>();
    List<String> list7 = new ArrayList<String>();
     SwipeRefreshLayout swipeLayout;

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
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        next = (Button) rootView.findViewById(R.id.next);

        collegespace = (CheckBox) rootView.findViewById(R.id.check_collegespace);
        crosslinks = (CheckBox) rootView.findViewById(R.id.check_crosslinks);
        junoon = (CheckBox) rootView.findViewById(R.id.check_junoon);
        rotaract = (CheckBox) rootView.findViewById(R.id.check_rotaract);
        bullet = (CheckBox) rootView.findViewById(R.id.check_bullet);
        csi = (CheckBox) rootView.findViewById(R.id.check_csi);
        ieee = (CheckBox) rootView.findViewById(R.id.check_ieee);
        deb = (CheckBox) rootView.findViewById(R.id.check_debsoc);
        quiz = (CheckBox) rootView.findViewById(R.id.check_quiz);
        ashwa = (CheckBox) rootView.findViewById(R.id.check_ashwa);



        tCollegespace = (TextView) rootView.findViewById(R.id.stars_collegespace);
        tCrosslinks = (TextView) rootView.findViewById(R.id.stars_crosslinks);
        tJunoon = (TextView) rootView.findViewById(R.id.stars_junoon);
        tRotaract = (TextView) rootView.findViewById(R.id.stars_rotaract);
        tBullet = (TextView) rootView.findViewById(R.id.stars_bullethawk);
        tCsi = (TextView) rootView.findViewById(R.id.stars_csi);
        tIeee = (TextView) rootView.findViewById(R.id.stars_ieee);
        tDeb = (TextView) rootView.findViewById(R.id.stars_debsoc);
        tQuiz = (TextView) rootView.findViewById(R.id.stars_quiz);
        tAshwa = (TextView) rootView.findViewById(R.id.stars_ashwa);

        SharedPreferences i = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
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


        collegespace.setChecked(Collegespace);
        crosslinks.setChecked(Crosslinks);
        junoon.setChecked(Junoon);
        bullet.setChecked(Bullet);
        rotaract.setChecked(Rotaract);
        quiz.setChecked(Quiz);
        ieee.setChecked(Ieee);
        csi.setChecked(Csi);
        ashwa.setChecked(Ashwa);
        deb.setChecked(Deb);


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
        csi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Csi = b;
            }
        });
        ieee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Ieee = b;
            }
        });
       deb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Deb = b;
            }
        });
        quiz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Quiz = b;
            }
        });
        ashwa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Ashwa = b;
            }
        });






        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
                SharedPreferences.Editor e = p.edit();
                Fragment mFragment = new FinalFeed();


                e.putBoolean("crosslinks", Crosslinks);
                e.putBoolean("collegespace", Collegespace);
                e.putBoolean("bullet", Bullet);
                e.putBoolean("junoon", Junoon);
                e.putBoolean("rotaract", Rotaract);
                e.putBoolean("csi", Csi);
                e.putBoolean("ieee", Ieee);
                e.putBoolean("debsoc", Deb);
                e.putBoolean("quiz", Quiz);
                e.putBoolean("ashwa", Ashwa);
                e.putBoolean("set", true);
                e.commit();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mFragment).commit();
            }
        });

        if(isNetworkAvailable()) {

            new Calclike(tCrosslinks, Val.id_crosslinks).execute();
            new Calclike(tCollegespace, Val.id_collegespace).execute();
            new Calclike(tJunoon, Val.id_junoon).execute();
            new Calclike(tBullet, Val.id_bullet).execute();
            new Calclike(tRotaract, Val.id_rotaract).execute();
            new Calclike(tCsi, Val.id_csi).execute();
            new Calclike(tIeee, Val.id_ieee).execute();
            new Calclike(tDeb, Val.id_debsoc).execute();
            new Calclike(tQuiz, Val.id_quiz).execute();
            new Calclike(tAshwa, Val.id_ashwa).execute();
        }
        else
            Toast.makeText(activity, "Cannot connect to Internet", Toast.LENGTH_SHORT).show();

        return rootView;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) activity.getSystemService(activity.CONNECTIVITY_SERVICE);
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
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

}
