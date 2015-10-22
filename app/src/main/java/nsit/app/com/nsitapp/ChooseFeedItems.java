package nsit.app.com.nsitapp;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import functions.Constant;
import functions.Utils;
import functions.Val;


public class ChooseFeedItems extends AppCompatActivity implements Constant {
    CheckBox collegespace,crosslinks,junoon,bullet,rotaract,quiz,ieee,csi,ashwa,deb;
    Boolean Collegespace=false,Crosslinks=false,Junoon=false,Bullet=false,Rotaract=false,Quiz=false,Ieee=false,Csi=false,Ashwa=false,Deb=false;
    TextView tCollegespace,tCrosslinks,tJunoon,tBullet,tRotaract,tQuiz,tIeee,tCsi,tAshwa,tDeb;
    Button next;
    List<String> list = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_feed_items);

        setTitle("My Feed Items");

        next = (Button)  findViewById(R.id.next);

        collegespace = (CheckBox)  findViewById(R.id.check_collegespace);
        crosslinks = (CheckBox)  findViewById(R.id.check_crosslinks);
        junoon = (CheckBox)  findViewById(R.id.check_junoon);
        rotaract = (CheckBox)  findViewById(R.id.check_rotaract);
        bullet = (CheckBox)  findViewById(R.id.check_bullet);
        csi = (CheckBox)  findViewById(R.id.check_csi);
        ieee = (CheckBox)  findViewById(R.id.check_ieee);
        deb = (CheckBox)  findViewById(R.id.check_debsoc);
        quiz = (CheckBox)  findViewById(R.id.check_quiz);
        ashwa = (CheckBox)  findViewById(R.id.check_ashwa);



        tCollegespace = (TextView)  findViewById(R.id.stars_collegespace);
        tCrosslinks = (TextView)  findViewById(R.id.stars_crosslinks);
        tJunoon = (TextView)  findViewById(R.id.stars_junoon);
        tRotaract = (TextView)  findViewById(R.id.stars_rotaract);
        tBullet = (TextView)  findViewById(R.id.stars_bullethawk);
        tCsi = (TextView)  findViewById(R.id.stars_csi);
        tIeee = (TextView)  findViewById(R.id.stars_ieee);
        tDeb = (TextView)  findViewById(R.id.stars_debsoc);
        tQuiz = (TextView)  findViewById(R.id.stars_quiz);
        tAshwa = (TextView)  findViewById(R.id.stars_ashwa);

        SharedPreferences i = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Crosslinks = i.getBoolean(CROSSLINKS, false);
        Collegespace = i.getBoolean(COLLEGESPACE, false);
        Bullet = i.getBoolean(BULLET, false);
        Junoon = i.getBoolean(JUNOON, false);
        Rotaract = i.getBoolean(ROTARACT, false);
        Csi = i.getBoolean(CSI, false);
        Ieee = i.getBoolean(IEEE, false);
        Deb = i.getBoolean(DEB, false);
        Quiz = i.getBoolean(QUIZ, false);
        Ashwa = i.getBoolean(ASHWA, false);


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
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Crosslinks = b;
            }
        });
        collegespace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Collegespace = b;
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
                SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor e = p.edit();
                e.putBoolean(CROSSLINKS, Crosslinks);
                e.putBoolean(COLLEGESPACE, Collegespace);
                e.putBoolean(BULLET, Bullet);
                e.putBoolean(JUNOON, Junoon);
                e.putBoolean(ROTARACT, Rotaract);
                e.putBoolean(CSI, Csi);
                e.putBoolean(IEEE, Ieee);
                e.putBoolean(DEB, Deb);
                e.putBoolean(QUIZ, Quiz);
                e.putBoolean(ASHWA, Ashwa);
                e.putBoolean(SOCIETY_SET, true);
                e.putBoolean(SOCIETY_ITEM_CHANGED, true);
                e.commit();
                finish();
            }
        });

        if(Utils.isNetworkAvailable(ChooseFeedItems.this)) {

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
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext())
                            .text("Check You Internet Connection")
                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT),this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

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

            try {
                int j = 0;
                JSONObject ob;
                JSONArray arr;
                try {
                    ob = new JSONObject(text);
                    if (ob.has("likes"))
                        text = ob.getString("likes");
                    else
                        text = "1000";
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bmImage.setText(text);
            }catch(Exception e){

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_final_feed, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        if(item.getItemId() == R.id.check){
            SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor e = p.edit();
            e.putBoolean(CROSSLINKS, Crosslinks);
            e.putBoolean(COLLEGESPACE, Collegespace);
            e.putBoolean(BULLET, Bullet);
            e.putBoolean(JUNOON, Junoon);
            e.putBoolean(ROTARACT, Rotaract);
            e.putBoolean(CSI, Csi);
            e.putBoolean(IEEE, Ieee);
            e.putBoolean(DEB, Deb);
            e.putBoolean(QUIZ, Quiz);
            e.putBoolean(ASHWA, Ashwa);
            e.putBoolean(SOCIETY_SET, true);
            e.putBoolean(SOCIETY_ITEM_CHANGED, true);
            e.commit();
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
