<<<<<<< HEAD
package nsit.app.com.nsitapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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

import functions.GPSTracker;
import functions.Utils;

/**
 * Created by AGGARWAL'S on 10/21/2015.
 */
public class PlaceMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private double Lati;
    private double Longi;
    private String place_name;
    private String place_id;
    private String main_polylinrobject;
    private TextView transition,time,distance;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_maps);
        transition = (TextView)findViewById(R.id.destination);
        time = (TextView)findViewById(R.id.time);
        distance= (TextView)findViewById(R.id.distance);
        progressBar = (ProgressBar)findViewById(R.id.progress_path);
        Lati = Double.parseDouble(getIntent().getStringExtra(HangoutTypeAdapter.INTENT_LATI));
        Longi = Double.parseDouble(getIntent().getStringExtra(HangoutTypeAdapter.INTENT_LONG));
        place_name = getIntent().getStringExtra(HangoutTypeAdapter.INTENT_PLACE_NAME);
        place_id = getIntent().getStringExtra(HangoutTypeAdapter.INTENT_PLACE_ID);
        transition.setText("Current Location To "+place_name);
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.place_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if(Utils.isNetworkAvailable(this))
            new HttpGetDirections(googleMap).execute();
        else
            Toast.makeText(getApplicationContext(), "Cannot connect to Internet" + "\n" + "Path Not Displayed", Toast.LENGTH_LONG).show();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);
        UiSettings settings = googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        settings.setZoomGesturesEnabled(true);
        settings.setCompassEnabled(true);
        settings.setRotateGesturesEnabled(true);
        LatLng place = new LatLng(Lati,Longi);
        googleMap.addMarker(new MarkerOptions().position(place).title(place_name));
        CameraPosition position = new CameraPosition.Builder().target(place).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position));

    }


    private class HttpGetDirections extends AsyncTask<Void,Void,Void> {

        private String text;
        private String URL;
        private GoogleMap googleMap;

        HttpGetDirections(GoogleMap map){
            text = null;
            GPSTracker gpsGetLocation = new GPSTracker(PlaceMapActivity.this);
            URL = "https://maps.googleapis.com/maps/api/directions/json?origin="+
                    gpsGetLocation.getLatitude()+","+gpsGetLocation.getLongitude()+"&destination=place_id:"
                    + place_id+"&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y";
            googleMap = map;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if(URL!=null){
                HttpClient Client = new DefaultHttpClient();
                HttpGet httpget = new HttpGet(URL);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                try {
                    text = Client.execute(httpget, responseHandler);
                } catch (IOException e) {
                    e.printStackTrace();
                }}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            try{
                JSONObject jdirectionsobject = new JSONObject(text);
                JSONArray jroutesarray = jdirectionsobject.getJSONArray("routes");
                main_polylinrobject = jroutesarray.getJSONObject(0).getJSONObject("overview_polyline").getString("points");
                distance.setText(jroutesarray.getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("distance").getString("text"));
                time.setText(jroutesarray.getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").getString("text"));
            }catch (Exception e){}
            List<LatLng> polydeodedpoints = decodePoly(main_polylinrobject);
            PolylineOptions options = new PolylineOptions().addAll(polydeodedpoints);
            options.color(getResources().getColor(R.color.colorPrimaryDark)).width(7);
            googleMap.addPolyline(options);
            progressBar.setVisibility(View.GONE);
        }
    }

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
=======
package nsit.app.com.nsitapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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

import functions.GPSTracker;
import functions.Utils;

/**
 * Created by AGGARWAL'S on 10/21/2015.
 */
public class PlaceMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private double Lati;
    private double Longi;
    private String place_name;
    private String place_id;
    private String main_polylinrobject;
    private TextView transition,time,distance;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_maps);
        transition = (TextView)findViewById(R.id.destination);
        time = (TextView)findViewById(R.id.time);
        distance= (TextView)findViewById(R.id.distance);
        progressBar = (ProgressBar)findViewById(R.id.progress_path);
        Lati = Double.parseDouble(getIntent().getStringExtra(HangoutTypeAdapter.INTENT_LATI));
        Longi = Double.parseDouble(getIntent().getStringExtra(HangoutTypeAdapter.INTENT_LONG));
        place_name = getIntent().getStringExtra(HangoutTypeAdapter.INTENT_PLACE_NAME);
        place_id = getIntent().getStringExtra(HangoutTypeAdapter.INTENT_PLACE_ID);
        transition.setText("Current Location To "+place_name);
        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.place_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if(Utils.isNetworkAvailable(this))
            new HttpGetDirections(googleMap).execute();
        else
            Toast.makeText(getApplicationContext(), "Cannot connect to Internet" + "\n" + "Path Not Displayed", Toast.LENGTH_LONG).show();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);
        UiSettings settings = googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        settings.setZoomGesturesEnabled(true);
        settings.setCompassEnabled(true);
        settings.setRotateGesturesEnabled(true);
        LatLng place = new LatLng(Lati,Longi);
        googleMap.addMarker(new MarkerOptions().position(place).title(place_name));
        CameraPosition position = new CameraPosition.Builder().target(place).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(position));

    }


    private class HttpGetDirections extends AsyncTask<Void,Void,Void> {

        private String text;
        private String URL;
        private GoogleMap googleMap;

        HttpGetDirections(GoogleMap map){
            text = null;
            GPSTracker gpsGetLocation = new GPSTracker(PlaceMapActivity.this);
            URL = "https://maps.googleapis.com/maps/api/directions/json?origin="+
                    gpsGetLocation.getLatitude()+","+gpsGetLocation.getLongitude()+"&destination=place_id:"
                    + place_id+"&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y";
            googleMap = map;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if(URL!=null){
                HttpClient Client = new DefaultHttpClient();
                HttpGet httpget = new HttpGet(URL);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                try {
                    text = Client.execute(httpget, responseHandler);
                } catch (IOException e) {
                    e.printStackTrace();
                }}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            try{
                JSONObject jdirectionsobject = new JSONObject(text);
                JSONArray jroutesarray = jdirectionsobject.getJSONArray("routes");
                main_polylinrobject = jroutesarray.getJSONObject(0).getJSONObject("overview_polyline").getString("points");
                distance.setText(jroutesarray.getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("distance").getString("text"));
                time.setText(jroutesarray.getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").getString("text"));
            }catch (Exception e){}
            List<LatLng> polydeodedpoints = decodePoly(main_polylinrobject);
            PolylineOptions options = new PolylineOptions().addAll(polydeodedpoints);
            options.color(getResources().getColor(R.color.colorPrimaryDark)).width(7);
            googleMap.addPolyline(options);
            progressBar.setVisibility(View.GONE);
        }
    }

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
>>>>>>> refs/remotes/Swati4star/master
