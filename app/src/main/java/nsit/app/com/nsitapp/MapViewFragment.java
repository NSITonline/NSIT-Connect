package nsit.app.com.nsitapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Sidharth Patro on 01-Jul-15.
 */
public class MapViewFragment extends FragmentActivity implements OnMapReadyCallback {
    com.google.android.gms.maps.MapFragment mapFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("Map onCreate", "Called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view);
        this.mapFragment = (com.google.android.gms.maps.MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        this.mapFragment.getMapAsync(this);

        GoogleMap map = mapFragment.getMap();
        map.addMarker(new MarkerOptions()
                .position(new LatLng(37.7750, 122.4183))
                .title("San Francisco"));
        Log.e("Marker", "Added");
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(10, 10))
                .title("Hello world"));
        Log.e("Marker", "Added");
    }
}
