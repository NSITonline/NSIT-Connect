package nsit.app.com.nsitapp.Hangout;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import functions.Constant;
import functions.GPSTracker;
import functions.Utils;
import nsit.app.com.nsitapp.R;

/**
 * Created by Sidharth Patro on 01-Jul-15.
 */
public class HangoutCollegeLocationMapView extends Activity implements Constant, OnMapReadyCallback {
    private String OriginLat;
    private String OriginLong;
    private String DestinationLat;
    private String DestinationLong;
    @BindView(R.id.MapProgressBar) ProgressBar MapSpinner;
    private GoogleMap mGoogleMap;
    private String des;

    Integer locationIcon;
    String LocationName;

    @BindView(R.id.LocDescription) TextView desc;
    @BindView(R.id.LocationTitle) TextView txtHeader;
    @BindView(R.id.LocationDistance) TextView txtLocationDistance;
    @BindView(R.id.TimeDrive) TextView txtTimeDrive;
    @BindView(R.id.TimeWalk) TextView txtTimeWalk;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view);
        ButterKnife.bind(this);
        //MapSpinner = findViewById(R.id.MapProgressBar);
        MapSpinner.setVisibility(View.VISIBLE);
        Bundle extras = getIntent().getExtras();
        Log.e("extras", extras.toString() + " ");
        String LocationLat = extras.getString(LOCATION_LAT);
        String LocationLong = extras.getString(LOCATION_LON);
        LocationName = extras.getString(LOCATION_NAME);
        Log.e("here", LocationName);
        if (LocationName.contains("North Gate"))
            des = getResources().getString(R.string.north_gate_desc);
        if (LocationName.contains("South Gate"))
            des = getResources().getString(R.string.south_gate_desc);
        if (LocationName.contains("Administrative Block"))
            des = getResources().getString(R.string.admin_block_desc);
        if (LocationName.contains("Block VI"))
            des = getResources().getString(R.string.block6_desc);
        else if (LocationName.contains("Block V"))
            des = getResources().getString(R.string.block5_desc);
        if (LocationName.contains("Block IV"))
            des = getResources().getString(R.string.block4_desc);
        if (LocationName.contains("Main Auditorium"))
            des = getResources().getString(R.string.main_audi_desc);
        if (LocationName.contains("Mini Auditorium"))
            des = getResources().getString(R.string.mini_audi_desc);
        if (LocationName.contains("Boys' Hostel IV")) {
            des = getResources().getString(R.string.bh4_desc);
        } else if (LocationName.contains("Boys' Hostel III")) {
            des = getResources().getString(R.string.bh3_desc);
        } else if (LocationName.contains("Boys' Hostel II")) {
            des = getResources().getString(R.string.bh2_desc);
        } else if (LocationName.contains("Boys' Hostel I")) {
            des = getResources().getString(R.string.bh1_desc);
        }
        if (LocationName.contains("Girls' Hostel II"))
            des = getResources().getString(R.string.gh2_desc);
        else if (LocationName.contains("Girls' Hostel"))
            des = getResources().getString(R.string.gh1_desc);
        if (LocationName.contains("Mini Zayca"))
            des = getResources().getString(R.string.mini_zayca);
        else if (LocationName.contains("Zayca"))
            des = getResources().getString(R.string.main_zayca);
        if (LocationName.contains("Just Cafe"))
            des = getResources().getString(R.string.just_cafe);
        if (LocationName.contains("McCain"))
            des = getResources().getString(R.string.McCain);
        if (LocationName.contains("Babloo"))
            des = getResources().getString(R.string.babloo);
        if (LocationName.contains("Radha"))
            des = getResources().getString(R.string.radha);
        if (LocationName.contains("Admin ATM"))
            des = getResources().getString(R.string.admin_atm);
        if (LocationName.contains("North Gate ATM"))
            des = getResources().getString(R.string.northgate_atm);
        if (LocationName.contains("South Gate ATM"))
            des = getResources().getString(R.string.southgate_atm);
        if (LocationName.contains("CADLAB"))
            des = getResources().getString(R.string.cad_lab);
        if (LocationName.contains("GCLAB"))
            des = getResources().getString(R.string.gc_lab);
        if (LocationName.contains("KHUSHIL"))
            des = getResources().getString(R.string.khushil);
        if (LocationName.contains("Pavilion"))
            des = getResources().getString(R.string.pavillion);
        if (LocationName.contains("Tennis"))
            des = getResources().getString(R.string.tennis);
        if (LocationName.contains("Basketball"))
            des = getResources().getString(R.string.basketball);
        if (LocationName.contains("Volleyball"))
            des = getResources().getString(R.string.volleyball);
        if (LocationName.contains("Cricket"))
            des = getResources().getString(R.string.cricket);
        if (LocationName.contains("Football"))
            des = getResources().getString(R.string.football);
        if (LocationName.contains("Library"))
            des = getResources().getString(R.string.library);
        if (LocationName.contains("Garage"))
            des = getResources().getString(R.string.garage);
        if (LocationName.contains("Lawns"))
            des = getResources().getString(R.string.nescii);
        if (LocationName.contains("Shopping"))
            des = getResources().getString(R.string.shoppingcomplex);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //desc = findViewById(R.id.LocDescription);
        desc.setText(des);
        locationIcon = extras.getInt(LOCATION_ICON);
        //TODO
        txtHeader = findViewById(R.id.LocationTitle);

        this.DestinationLat = LocationLat;
        this.DestinationLong = LocationLong;
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            this.OriginLong = String.valueOf(location.getLongitude());
            this.OriginLat = String.valueOf(location.getLatitude());
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtHeader.setText(LocationName);

        final LocationGetDirections getDirections = new LocationGetDirections();
        GPSTracker tracker = new GPSTracker(this);
        if (!tracker.canGetLocation()) {
            tracker.showSettingsAlert();
        } else {
            OriginLat = Double.toString(tracker.getLatitude());
            OriginLong = Double.toString(tracker.getLongitude());
            getDirections.execute();
        }
    }

    private void ShowMarker(Double LocationLat, Double LocationLong, String LocationName, Integer LocationIcon) {
        LatLng Coord = new LatLng(LocationLat, LocationLong);

        if (mGoogleMap != null) {
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Coord, 17));
            mGoogleMap.addMarker(new MarkerOptions()
                    .title(LocationName)
                    .position(Coord)
                    .icon(BitmapDescriptorFactory.fromResource(LocationIcon)));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        ShowMarker(Double.parseDouble(this.DestinationLat), Double.parseDouble(this.DestinationLong ), LocationName, locationIcon);
    }

    private class LocationGetDirections extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... Coordinates) {

            String DriveResult = "", WalkResult = "";

            String uri = "https://maps.googleapis.com/maps/api/directions/json?origin=" + OriginLat + "," +
                    OriginLong + "&destination=" + DestinationLat + "," + DestinationLong + "&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y&mode=driving";
            Log.e("uri1", uri);
            java.net.URL url;
            try {
                url = new URL(uri);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                DriveResult = Utils.readStream(con.getInputStream());
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            uri = "https://maps.googleapis.com/maps/api/directions/json?origin=" + OriginLat + "," + OriginLong + "&destination=" + DestinationLat + "," + DestinationLong +
                    "&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y&mode=walking";
            Log.e("uri2", uri);
            try {
                url = new URL(uri);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                WalkResult = Utils.readStream(con.getInputStream());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return DriveResult + "/NSITAPP/" + WalkResult;
        }

        @Override
        protected void onPostExecute(String Result) {
            try {
                String[] ResultArray = Result.split("/NSITAPP/");
                JSONObject DriveObject = new JSONObject(ResultArray[0]);
                JSONObject WalkObject = new JSONObject(ResultArray[1]);
                String Distance = DriveObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("distance").getString("text");
                String TimeDrive = DriveObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").getString("text");
                String TimeWalk = WalkObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").getString("text");
//                TextView txtLocationDistance = findViewById(R.id.LocationDistance);
//                TextView txtTimeDrive = findViewById(R.id.TimeDrive);
//                TextView txtTimeWalk = findViewById(R.id.TimeWalk);
                txtLocationDistance.setText(Distance);
                txtTimeDrive.setText(TimeDrive);
                txtTimeWalk.setText(TimeWalk);
                MapSpinner.setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}