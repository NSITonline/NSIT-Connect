package nsit.app.com.nsitapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import functions.Constant;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ChooseFeedItems extends AppCompatActivity implements Constant {
    private Boolean Collegespace = false;
    private Boolean Crosslinks = false;
    private Boolean Junoon = false;
    private Boolean Bullet = false;
    private Boolean Rotaract = false;
    private Boolean Quiz = false;
    private Boolean Ieee = false;
    private Boolean Csi = false;
    private Boolean Ashwa = false;
    private Boolean Deb = false;
    private Boolean Enactus = false;
    private Boolean Aagaz = false;
    private Handler mHandler;
    String likes;

      @BindView(R.id.check_collegespace)CheckBox collegespace;
      @BindView(R.id.check_crosslinks)CheckBox crosslinks;
      @BindView(R.id.check_junoon)CheckBox junoon;
      @BindView(R.id.check_rotaract)CheckBox rotaract;
      @BindView(R.id.check_bullet)CheckBox bullet;
      @BindView(R.id.check_csi)CheckBox csi;
      @BindView(R.id.check_ieee)CheckBox ieee;
      @BindView(R.id.check_debsoc)CheckBox deb;
      @BindView(R.id.check_quiz)CheckBox quiz;
      @BindView(R.id.check_ashwa)CheckBox ashwa;
      @BindView(R.id.check_enactus)CheckBox enactus;
      @BindView(R.id.check_aagaz)CheckBox aagaz;
      @BindView(R.id.likes_collegespace)TextView tCollegespace ;
      @BindView(R.id.likes_crosslinks)TextView tCrosslinks;
      @BindView(R.id.likes_junoon)TextView tJunoon;
      @BindView(R.id.likes_rotaract)TextView tRotaract;
      @BindView(R.id.likes_bullethawk)TextView tBullet;
      @BindView(R.id.likes_csi)TextView tCsi;
      @BindView(R.id.likes_ieee)TextView tIeee;
      @BindView(R.id.likes_debsoc)TextView tDeb;
      @BindView(R.id.likes_quiz)TextView tQuiz;
      @BindView(R.id.likes_ashwa)TextView tAshwa;
      @BindView(R.id.likes_enactus)TextView tEnactus;
      @BindView(R.id.likes_aagaz)TextView tAagaz;
      @BindView(R.id.next)Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_feed_items);
        ButterKnife.bind(this);
        setTitle("My Feed Items");

        mHandler = new Handler(Looper.getMainLooper());

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
        Aagaz = i.getBoolean(AAGAZ, false);
        Enactus = i.getBoolean(ENACTUS, false);


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
        aagaz.setChecked(Aagaz);
        enactus.setChecked(Enactus);


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
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Ieee = b;
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
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Ashwa = b;
            }
        });
        enactus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Enactus = b;
            }
        });
        aagaz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Aagaz = b;
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
                e.putBoolean(ENACTUS, Enactus);
                e.putBoolean(AAGAZ, Aagaz);
                e.putBoolean(SOCIETY_SET, true);
                e.putBoolean(SOCIETY_ITEM_CHANGED, true);
                e.apply();
                finish();
            }
        });

        if (Utils.isNetworkAvailable(ChooseFeedItems.this)) {

            caculateLikes(tCrosslinks, id_crosslinks);
            caculateLikes(tCrosslinks, id_crosslinks);
            caculateLikes(tCollegespace, id_collegespace);
            caculateLikes(tJunoon, id_junoon);
            caculateLikes(tBullet, id_bullet);
            caculateLikes(tRotaract, id_rotaract);
            caculateLikes(tCsi, id_csi);
            caculateLikes(tIeee, id_ieee);
            caculateLikes(tDeb, id_debsoc);
            caculateLikes(tQuiz, id_quiz);
            caculateLikes(tAshwa, id_ashwa);
            caculateLikes(tAagaz, id_aagaz);
            caculateLikes(tEnactus, id_enactus);
        } else
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext())
                            .text("Check Your Internet Connection")
                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }


    private void caculateLikes(final TextView bmImage, String id) {

        // Facebook URI to fetch likes
        String uri = "https://graph.facebook.com/" + id + "?access_token=" + common_access;

        //Set up client
        OkHttpClient client = new OkHttpClient();
        //Execute request
        Request request = new Request.Builder()
                .url(uri)
                .build();
        //Setup callback
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Request Failed", "Message : " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject ob;
                    try {
                        ob = new JSONObject(response.body().string());
                        if (ob.has("likes"))
                            likes = ob.getString("likes");
                        else
                            likes = "1000";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            bmImage.setText(likes);
                        }
                    });
                } catch (Exception e) {
                    Log.e("ERROR : ", e.getMessage());
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_final_feed, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        if (item.getItemId() == R.id.check) {
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
            e.putBoolean(ENACTUS, Enactus);
            e.putBoolean(AAGAZ, Aagaz);
            e.putBoolean(SOCIETY_SET, true);
            e.putBoolean(SOCIETY_ITEM_CHANGED, true);
            e.apply();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}