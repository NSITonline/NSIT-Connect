package nsit.app.com.nsitapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import functions.GPSTracker;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static nsit.app.com.nsitapp.Hangout.HangoutTypeAdapter.INTENT_LATI;
import static nsit.app.com.nsitapp.Hangout.HangoutTypeAdapter.INTENT_LONG;
import static nsit.app.com.nsitapp.Hangout.HangoutTypeAdapter.INTENT_PLACE_ID;
import static nsit.app.com.nsitapp.Hangout.HangoutTypeAdapter.INTENT_PLACE_NAME;

/**
 * Created by AGGARWAL'S on 10/21/2015.
 */
public class PlaceMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private double Lati;
    private double Longi;
    private String place_name, place_id, main_polylinrobject;
    private TextView time;
    private TextView distance;
    private ProgressBar progressBar;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_maps);

        // Initialize variables
        TextView transition = findViewById(R.id.destination);
        time = findViewById(R.id.time);
        distance = findViewById(R.id.distance);
        progressBar = findViewById(R.id.progress_path);

        // Get data from previous activity
        Intent intent = getIntent();
        Lati = Double.parseDouble(intent.getStringExtra(INTENT_LATI));
        Longi = Double.parseDouble(intent.getStringExtra(INTENT_LONG));
        place_name = intent.getStringExtra(INTENT_PLACE_NAME);
        place_id = intent.getStringExtra(INTENT_PLACE_ID);

        mHandler = new Handler(Looper.getMainLooper());
        transition.setText("Current Location To " + place_name);

        // Initialize map
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.place_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //If internet is available
        if (Utils.isNetworkAvailable(this))
            getDirections(googleMap);
        else
            Toast.makeText(getApplicationContext(), "Cannot connect to Internet" + "\n" + "Path Not Displayed", Toast.LENGTH_LONG).show();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);

        UiSettings settings = googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        settings.setZoomGesturesEnabled(true);
        settings.setCompassEnabled(true);
        settings.setRotateGesturesEnabled(true);

        LatLng place = new LatLng(Lati, Longi);
        googleMap.addMarker(new MarkerOptions().position(place).title(place_name));
        CameraPosition position = new CameraPosition.Builder().target(place).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position));

    }


    private void getDirections(final GoogleMap googleMap) {

        GPSTracker gpsGetLocation = new GPSTracker(PlaceMapActivity.this);
        String URL = "https://maps.googleapis.com/maps/api/directions/json?origin=" +
                gpsGetLocation.getLatitude() + "," + gpsGetLocation.getLongitude() + "&destination=place_id:"
                + place_id + "&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y";

        progressBar.setVisibility(View.VISIBLE);

        //Set up client
        OkHttpClient client = new OkHttpClient();
        //Execute request
        Request request = new Request.Builder()
                .url(URL)
                .build();
        //Setup callback
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Request Failed", "Message : " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                mHandler.post(() -> {

                    try {
                        JSONObject jdirectionsobject = new JSONObject(response.body().string());
                        JSONArray jroutesarray = jdirectionsobject.getJSONArray("routes");
                        main_polylinrobject = jroutesarray.getJSONObject(0).getJSONObject("overview_polyline").getString("points");
                        distance.setText(jroutesarray.getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("distance").getString("text"));
                        time.setText(jroutesarray.getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").getString("text"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    List<LatLng> polydeodedpoints = decodePoly(main_polylinrobject);
                    PolylineOptions options = new PolylineOptions().addAll(polydeodedpoints);
                    options.color(getResources().getColor(R.color.colorPrimaryDark)).width(7);
                    googleMap.addPolyline(options);
                    progressBar.setVisibility(View.GONE);
                });
            }

        });
    }

    // Plot points on map from encoded string
    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }

}
