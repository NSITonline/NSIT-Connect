package nsit.app.com.nsitapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import functions.GPSTracker;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by AGGARWAL'S on 10/11/2015.
 */
public class HangoutsTypeDisplay extends AppCompatActivity {


    private final static String MAIN_HTTP = "https://maps.googleapis.com/maps/api/place/";
    private final static String NEARBYPLACES = "nearbysearch";
    private final static String LOCATION = "/json?location=";
    private final static String QUERY = "/xml?query=";
    private final static String RADIUS = "&radius=";
    private int radius = 500;
    private final static String TYPE = "&types=";
    private final static String KEY = "&key=AIzaSyBLSYsHaIe7euGK_glMbU98ZW9SDNBcEkM";

    private String[] HangoutPlaces = {"Restaurants", "Cafes", "Night Clubs", "Shopping Malls", "Bowling", "Movie", "Food", "Amusement Parks", "Park"};
    private String[] searches = {"restaurant", "cafe", "night_club", "shopping_mall", "bowling_alley", "movie_theater", "food", "amusement_park", "park"};
    private int choice = -1;
    private int progress = 0;
    private ProgressBar progressBar;
    private ArrayList<HangoutTypeObject> objects;
    private HangoutTypeAdapter displayAdapter;
    private TextView radiusTextView;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangout_type_display_activity);
        choice = getIntent().getIntExtra(Hangouts.CHOICE_TYPE, 0);
        getSupportActionBar().setTitle("   " + HangoutPlaces[choice]);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_people_white_36dp);
        objects = new ArrayList<>();
        mHandler = new Handler(Looper.getMainLooper());

        ListView display_list = (ListView) findViewById(R.id.hangout_type_display_list);
        displayAdapter = new HangoutTypeAdapter(this, objects);
        display_list.setAdapter(displayAdapter);

        progressBar = (ProgressBar) findViewById(R.id.progress);

        if (Utils.isNetworkAvailable(this))
            HttpGetInfo();
        else
            Toast.makeText(getApplicationContext(), "Cannot connect to Internet", Toast.LENGTH_LONG).show();

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
                    HttpGetInfo();
                else
                    Toast.makeText(getApplicationContext(), "Cannot connect to Internet", Toast.LENGTH_LONG).show();
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
        SeekBar radiusSeekBar = (SeekBar) radiusview.findViewById(R.id.radius_seek);
        radiusTextView = (TextView) radiusview.findViewById(R.id.radius_display);
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
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        radius = progress;
                        Toast.makeText(getApplicationContext(), "Radius :" + radius, Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();

    }


    // Make http call
    private void HttpGetInfo() {

        String text;
        String uri = null;
        text = null;
        GPSTracker gpsGetLocation = new GPSTracker(HangoutsTypeDisplay.this);
        if (gpsGetLocation.canGetLocation())
            uri = MAIN_HTTP + NEARBYPLACES + LOCATION + gpsGetLocation.getLatitude() + "," + gpsGetLocation.getLongitude()
                    + RADIUS + String.valueOf(radius) + TYPE + searches[choice] + KEY;

        progressBar.setVisibility(View.VISIBLE);
        objects.clear();
        displayAdapter.notifyDataSetChanged();

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
            public void onResponse(Call call, final Response response) throws IOException {

                final String res = response.body().string();
                try {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);

                            try {
                                JSONObject jplaceobject = new JSONObject(res);
                                JSONArray jplacearray = jplaceobject.getJSONArray("results");

                                if (jplaceobject.getString("status").equals("ZERO_RESULTS"))
                                    Toast.makeText(getApplicationContext(), "No " + HangoutPlaces[choice] + " Present in Current Radius", Toast.LENGTH_SHORT).show();

                                int i;
                                for (i = 0; i < jplacearray.length(); i++) {
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

                                }
                            }catch (JSONException e){
                                Log.e("ERROR ", e.getMessage());
                            }
                            displayAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public class HangoutTypeAdapter extends BaseAdapter {

        public static final String INTENT_LATI = "Lati";
        public static final String INTENT_LONG = "Long";
        public static final String INTENT_PLACE_NAME = "place_name";
        public static final String INTENT_PLACE_ID = "place_id";
        private Context mContext;
        private ArrayList<HangoutTypeObject> hangoutObjects;

        public HangoutTypeAdapter(Context context, ArrayList<HangoutTypeObject> object) {
            mContext = context;
            hangoutObjects = object;
        }

        @Override
        public int getCount() {
            return hangoutObjects.size();
        }

        @Override
        public Object getItem(int i) {
            return hangoutObjects.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertview, ViewGroup viewGroup) {
            ViewHolder holder = new ViewHolder();

            if (convertview == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertview = inflater.inflate(R.layout.hangouttype_listitem, viewGroup, false);
                holder.placephoto = (ImageView) convertview.findViewById(R.id.hangottype_photo);
                holder.placename = (TextView) convertview.findViewById(R.id.title_hangout_type);
                holder.vicinity = (TextView) convertview.findViewById(R.id.vicinity);
                holder.rating = (RatingBar) convertview.findViewById(R.id.rating_bar);
                holder.placeopen = (TextView) convertview.findViewById(R.id.open_close);
                holder.placelocate = (LinearLayout) convertview.findViewById(R.id.locate_button);
                convertview.setTag(holder);
            } else
                holder = (ViewHolder) convertview.getTag();

            holder.placename.setText(hangoutObjects.get(i).getName());
            holder.placename.setId(i);

            holder.vicinity.setText(hangoutObjects.get(i).getVicinity());
            holder.vicinity.setId(i);

            holder.rating.setRating(hangoutObjects.get(i).getRating());
            holder.rating.setId(i);

            if (hangoutObjects.get(i).phtotref != null)
                Picasso.with(mContext).load("https://maps.googleapis.com/maps/api/place/photo?maxheight=145&photoreference=" + hangoutObjects.get(i).phtotref + "&key=AIzaSyBz-tWFzOVJRWUBuF6TYkd5T2SfPOfV-GE").into(holder.placephoto);
            else
                Picasso.with(mContext).load(R.drawable.imagenotavailable).into(holder.placephoto);

            if (hangoutObjects.get(i).getopennowv())
                holder.placeopen.setText("OPEN NOW");
            else
                holder.placeopen.setText("CLOSED NOW");
            holder.placeopen.setId(i);

            final int position = i;
            holder.placelocate.setId(i);
            holder.placelocate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, PlaceMapActivity.class);
                    intent.putExtra(INTENT_LATI, hangoutObjects.get(position).getLatti());
                    intent.putExtra(INTENT_LONG, hangoutObjects.get(position).getLongi());
                    intent.putExtra(INTENT_PLACE_NAME, hangoutObjects.get(position).getName());
                    intent.putExtra(INTENT_PLACE_ID, hangoutObjects.get(position).getPlace_id());
                    mContext.startActivity(intent);
                }
            });

            AnimationSet set = new AnimationSet(true);
            TranslateAnimation slide = new TranslateAnimation(-200, 0, -200, 0);
            slide.setInterpolator(new DecelerateInterpolator(5.0f));
            slide.setDuration(300);
            Animation fade = new AlphaAnimation(0, 1.0f);
            fade.setInterpolator(new DecelerateInterpolator(5.0f));
            fade.setDuration(300);
            set.addAnimation(slide);
            set.addAnimation(fade);
            convertview.startAnimation(set);
            return convertview;
        }

        class ViewHolder {
            ImageView placephoto;
            TextView placename;
            TextView vicinity;
            RatingBar rating;
            TextView placeopen;
            LinearLayout placelocate;

        }
    }

}
