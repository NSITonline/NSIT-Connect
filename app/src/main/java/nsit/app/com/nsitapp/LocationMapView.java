package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by Sidharth Patro on 01-Jul-15.
 */
public class LocationMapView extends Activity {
    com.google.android.gms.maps.MapFragment mapFragment;
    String OriginLat;
    String OriginLong;
    String DestinationLat;
    String DestinationLong;
    String StartAddress;
    private LocationManager locmgr = null;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view);
        this.mapFragment = (com.google.android.gms.maps.MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        Bundle extras = getIntent().getExtras();
        Log.e("extras",extras.toString());
        if (extras != null) {
            String LocationLat = extras.getString("LocationLat");
            String LocationLong = extras.getString("LocationLong");
            String LocationName = extras.getString("LocationName");
            TextView txtHeader = (TextView)findViewById(R.id.LocationTitle);
            this.DestinationLat = LocationLat;
            this.DestinationLong = LocationLong;
            LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
            try {
                Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                this.OriginLong = String.valueOf(location.getLongitude());
                this.OriginLat = String.valueOf(location.getLatitude());
            }catch(Exception e){
                Log.e("Maps Error",e.toString());
                e.printStackTrace();
            }

            Log.e("TextHeader",String.valueOf(txtHeader));
            txtHeader.setText(LocationName);
            ShowMarker(Double.parseDouble(LocationLat), Double.parseDouble(LocationLong), LocationName);
        }

        final Location_GetDirections getDirections = new Location_GetDirections();

        locmgr = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        final LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location loc) {
                Toast msg = Toast.makeText(LocationMapView.this, "Lon: " + Double.toString(loc.getLongitude()) + " Lat: " + Double.toString(loc.getLatitude()), Toast.LENGTH_SHORT);
                float acc = loc.getAccuracy();
                Toast msg2 = Toast.makeText(LocationMapView.this,String.valueOf(acc), Toast.LENGTH_SHORT);
                msg.show();
                msg2.show();
                OriginLat = Double.toString(loc.getLongitude());
                OriginLong = Double.toString(loc.getLatitude());
                locmgr.removeUpdates(this);
                getDirections.execute();
            }
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}
        };
        locmgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);

    }

    public void ShowMarker(Double LocationLat, Double LocationLong, String LocationName){
        GoogleMap map = mapFragment.getMap();
        LatLng Coord = new LatLng(LocationLat, LocationLong);

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Coord, 17));

        map.addMarker(new MarkerOptions()
                .title(LocationName)
                .position(Coord)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
    }

    public class Location_GetDirections extends AsyncTask<String, Void, String> {
        private Exception exception;

        protected String doInBackground(String... Coordinates) {
            try {
                Log.e("Locations Directions","Starting to fetch stuff");
                HttpClient client = new DefaultHttpClient();


                HttpUriRequest request = new HttpGet("https://maps.googleapis.com/maps/api/directions/json?origin="+OriginLat+","+OriginLong+"&destination="+DestinationLat+","+DestinationLong+"&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y&mode=driving");
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String DriveResult = client.execute(request, responseHandler);
                Log.e("URL","https://maps.googleapis.com/maps/api/directions/json?origin="+OriginLat+","+OriginLong+"&destination="+DestinationLat+","+DestinationLong+"&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y&mode=driving");
                request = new HttpGet("https://maps.googleapis.com/maps/api/directions/json?origin="+OriginLat+","+OriginLong+"&destination="+DestinationLat+","+DestinationLong+"&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y&mode=walking");
                String WalkResult = client.execute(request, responseHandler);

                return DriveResult+"/NSITAPP/"+WalkResult;
            } catch (Exception e) {
                this.exception = e;
                Log.e("Locations Directions", e.toString());
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String Result) {
            try{
                String[] ResultArray = Result.split("/NSITAPP/");
                JSONObject DriveObject = new JSONObject(ResultArray[0]);
                JSONObject WalkObject = new JSONObject(ResultArray[1]);
                Log.e("DriveObject",DriveObject.toString());
                Log.e("WalkObject",DriveObject.toString());
                String Distance = DriveObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("distance").getString("text");
                String TimeDrive = DriveObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").getString("text");
                String TimeWalk = WalkObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").getString("text");
                TextView txtLocationDistance = (TextView)findViewById(R.id.LocationDistance);
                TextView txtTimeDrive = (TextView)findViewById(R.id.TimeDrive);
                TextView txtTimeWalk = (TextView)findViewById(R.id.TimeWalk);
                txtLocationDistance.setText(Distance);
                txtTimeDrive.setText(TimeDrive);
                txtTimeWalk.setText(TimeWalk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
