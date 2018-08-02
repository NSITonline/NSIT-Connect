package nsit.app.com.nsitapp.Hangout;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import functions.GPSTracker;
import functions.Utils;
import models.HangoutTypeObject;
import nsit.app.com.nsitapp.R;

/**
 * Created by AGGARWAL'S on 10/11/2015.
 */
public class HangoutsTypeDisplay extends AppCompatActivity {

    private final static String MAIN_HTTP = "https://maps.googleapis.com/maps/api/place/";
    private final static String NEARBYPLACES = "nearbysearch";
    private final static String LOCATION = "/json?location=";
    private final static String RADIUS = "&radius=";
    private int radius = 1000;
    private final static String TYPE = "&types=";
    private final static String KEY = "&key=AIzaSyBLSYsHaIe7euGK_glMbU98ZW9SDNBcEkM";

    private final String[] HangoutPlaces = {"Restaurants", "Cafes", "Night Clubs", "Shopping Malls", "Bowling", "Movie", "Food", "Amusement Parks", "Park"};
    private final String[] searches = {"restaurant", "cafe", "night_club", "shopping_mall", "bowling_alley", "movie_theater", "food", "amusement_park", "park"};
    private int choice = -1;
    private int progress = 0;
    private ProgressBar progressBar;
    private ArrayList<HangoutTypeObject> objects;
    private HangoutTypeAdapter displayAdapter;
    private TextView radiusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangout_type_display_activity);
        choice = getIntent().getIntExtra(Hangouts.CHOICE_TYPE, 0);
        getSupportActionBar().setTitle("   " + HangoutPlaces[choice]);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_people_white_36dp);
        objects = new ArrayList<>();

        ListView display_list = findViewById(R.id.hangout_type_display_list);
        displayAdapter = new HangoutTypeAdapter(this, objects);
        display_list.setAdapter(displayAdapter);

        progressBar = findViewById(R.id.progress);

        if (Utils.isNetworkAvailable(this))
            new HttpGetInfo().execute();
        else
            Toast.makeText(getApplicationContext(), R.string.internet_error, Toast.LENGTH_LONG).show();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_hangouts, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.refresh:
                if (Utils.isNetworkAvailable(this))
                    new HttpGetInfo().execute();
                else
                    Toast.makeText(getApplicationContext(), R.string.internet_error, Toast.LENGTH_LONG).show();
                break;
            case R.id.change_radius:
                setradiusvalue();
                break;

            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setradiusvalue() {
        AlertDialog.Builder alert = new AlertDialog.Builder(HangoutsTypeDisplay.this);
        final View radiusview = getLayoutInflater().inflate(R.layout.raduis_layout, null);
        SeekBar radiusSeekBar = radiusview.findViewById(R.id.radius_seek);
        radiusTextView = radiusview.findViewById(R.id.radius_display);
        radiusSeekBar.setProgress(radius);
        radiusTextView.setText("Radius :" + radius + "(m)");
        radiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
                radiusTextView.setText("Radius :" + progress + "(m)");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        alert.setTitle("Set Radius")
                .setView(radiusview)
                .setPositiveButton(getString(R.string.filter_dialog_ok), (dialogInterface, i) -> {
                    radius = progress;
                    Toast.makeText(getApplicationContext(), "Radius :" + radius, Toast.LENGTH_SHORT).show();
                }).setNegativeButton(getString(R.string.filter_dialog_cancel), (dialogInterface, i) -> {

        }).show();
    }

    private class HttpGetInfo extends AsyncTask<Void, Void, Void> {

        private String text;
        private String URL;

        HttpGetInfo() {
            text = null;
            GPSTracker gpsGetLocation = new GPSTracker(HangoutsTypeDisplay.this);
            if (gpsGetLocation.canGetLocation())
                URL = MAIN_HTTP + NEARBYPLACES + LOCATION + gpsGetLocation.getLatitude() + "," + gpsGetLocation.getLongitude()
                        + RADIUS + String.valueOf(radius) + TYPE + searches[choice] + KEY;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            objects.clear();
            displayAdapter.notifyDataSetChanged();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            if (URL == null)
                return null;
            String uri = URL;
            Log.v("EXECUTING", uri);
            java.net.URL url;
            try {
                url = new URL(uri);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                text = Utils.readStream(con.getInputStream());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressBar.setVisibility(View.GONE);

            Log.e("got responses", text + " ");

            try {
                JSONObject jplaceobject = new JSONObject(text);
                JSONArray jplacearray = jplaceobject.getJSONArray("results");

                if (jplaceobject.getString("status").equals("ZERO_RESULTS"))
                    Toast.makeText(getApplicationContext(), "No " + HangoutPlaces[choice] + " Present in Current Radius", Toast.LENGTH_SHORT).show();

                int i;
                for (i = 0; i < jplacearray.length(); i++) {
                    try {
                        String name;
                        String icon;
                        String place_id;
                        String phtotref;
                        String longi = null;
                        String latti = null;
                        String vicinity;
                        boolean opennow = false;
                        float photowidth;
                        float photoheight;
                        float rating;

                        if (jplacearray.getJSONObject(i).has("icon"))
                            icon = jplacearray.getJSONObject(i).getString("icon");
                        else
                            icon = null;

                        if (jplacearray.getJSONObject(i).has("place_id"))
                            place_id = jplacearray.getJSONObject(i).getString("place_id");
                        else
                            place_id = null;

                        if (jplacearray.getJSONObject(i).has("name"))
                            name = jplacearray.getJSONObject(i).getString("name");
                        else
                            name = null;

                        if (jplacearray.getJSONObject(i).has("rating"))
                            rating = Float.parseFloat(jplacearray.getJSONObject(i).getString("rating"));
                        else
                            rating = 0;

                        if (jplacearray.getJSONObject(i).has("vicinity"))
                            vicinity = jplacearray.getJSONObject(i).getString("vicinity");
                        else
                            vicinity = null;

                        if (jplacearray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location").has("lng")) {
                            JSONObject object = jplacearray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location");
                            longi = object.getString("lng");
                            latti = object.getString("lat");
                        }
                        if (jplacearray.getJSONObject(i).has("photos")) {
                            JSONObject obj = jplacearray.getJSONObject(i).getJSONArray("photos").getJSONObject(0);
                            phtotref = obj.getString("photo_reference");
                            photoheight = Float.parseFloat(obj.getString("height"));
                            photowidth = Float.parseFloat(obj.getString("width"));
                        } else {
                            phtotref = null;
                            photoheight = 0;
                            photowidth = 0;
                        }

                        if (jplacearray.getJSONObject(i).has("opening_hours")) {
                            String bool = jplacearray.getJSONObject(i).getJSONObject("opening_hours").getString("open_now");
                            opennow = !bool.equals("false");
                        }

                        objects.add(new HangoutTypeObject(name, icon, place_id, phtotref, longi, latti, vicinity, opennow, photowidth, photoheight, rating));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            displayAdapter.notifyDataSetChanged();
        }
    }
}
