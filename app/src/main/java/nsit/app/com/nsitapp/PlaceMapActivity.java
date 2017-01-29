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

import butterknife.BindView;
import butterknife.ButterKnife;
import functions.GPSTracker;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by AGGARWAL'S on 10/21/2015.
 */
public class PlaceMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private double Lati;
    private double Longi;
    private String place_name, place_id, main_polylinrobject;
    @BindView(R.id.time) TextView time;
    @BindView(R.id.destination)TextView transition;
    @BindView(R.id.distance)TextView distance;
    @BindView(R.id.progress_path)ProgressBar progressBar;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_maps);
        ButterKnife.bind(this);

        // Get data from previous activity
        Intent intent = getIntent();
        Lati = Double.parseDouble(intent.getStringExtra(HangoutsTypeDisplay.HangoutTypeAdapter.INTENT_LATI));
        Longi = Double.parseDouble(intent.getStringExtra(HangoutsTypeDisplay.HangoutTypeAdapter.INTENT_LONG));
        place_name = intent.getStringExtra(HangoutsTypeDisplay.HangoutTypeAdapter.INTENT_PLACE_NAME);
        place_id = intent.getStringExtra(HangoutsTypeDisplay.HangoutTypeAdapter.INTENT_PLACE_ID);

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

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            JSONObject jdirectionsobject = new JSONObject(response.body().string());
                            JSONArray jroutesarray = jdirectionsobject.getJSONArray("routes");
                            main_polylinrobject = jroutesarray.getJSONObject(0).getJSONObject("overview_polyline").getString("points");
                            distance.setText(jroutesarray.getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("distance").getString("text"));
                            time.setText(jroutesarray.getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").getString("text"));
                        } catch (Exception e) {
                        }
                        List<LatLng> polydeodedpoints = decodePoly(main_polylinrobject);
                        PolylineOptions options = new PolylineOptions().addAll(polydeodedpoints);
                        options.color(getResources().getColor(R.color.colorPrimaryDark)).width(7);
                        googleMap.addPolyline(options);
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }

        });
    }

    // Plot points on map from encoded string
    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<LatLng>();
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
