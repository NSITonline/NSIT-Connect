package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Sidharth Patro on 21-Jun-15.
 */
public class Locations extends Fragment {

    ArrayList<LocationGroup> LocationsGroupsList = new ArrayList<>();
    public ExpandableListView listView;
    ExpandableListAdapter listAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }


    Activity activity;
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = activity;
    }

    public void populateList(ArrayList<LocationGroup> Items){
        FillGroupsList();
        listAdapter = new LocationsList_Adapter(getActivity(),Items,null);
        listView.setAdapter(listAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_locations, container, false);
        listView = (ExpandableListView) rootView.findViewById(R.id.locations_list);
        populateList(LocationsGroupsList);



        this.listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String groupType =  LocationsGroupsList.get(groupPosition).GroupType;
                Integer IconId = null;
                switch(groupType){
                    case "College": IconId = R.drawable.ic_school_black_24dp;
                        break;
                    case "Campus": IconId = R.drawable.ic_business_black_24dp;
                        break;
                    case "Hostel": IconId = R.drawable.ic_hotel_black_24dp;
                        break;
                    case "Canteen": IconId = R.drawable.ic_local_cafe_black_24dp;
                        break;
                    case "Stationery": IconId = R.drawable.ic_brush_black_24dp;
                        break;
                    case "ATM": IconId = R.drawable.ic_credit_card_black_24dp;
                        break;
                    case "WiFi": IconId = R.drawable.ic_network_wifi_black_24dp;
                        break;
                    case "Sports": IconId = R.drawable.ic_directions_bike_black_24dp;
                        break;
                    case "Miscellaneous": IconId = R.drawable.ic_public_black_24dp;
                        break;
                }
                v.setTag(groupPosition);
                ShowOnMap(v,LocationsGroupsList.get(groupPosition).Locations.get(childPosition),IconId);
                return false;
            }
        });
        return rootView;
    }

    public void ShowOnMap(View view, Location LocationItem, Integer GroupItem){
        Intent myIntent = new Intent(view.getContext(),LocationMapView.class);
        myIntent.putExtra("LocationName", LocationItem.Name);
        myIntent.putExtra("LocationLat", String.valueOf(LocationItem.Coord.latitude));
        myIntent.putExtra("LocationLong", String.valueOf(LocationItem.Coord.longitude));
        myIntent.putExtra("LocationLong", String.valueOf(LocationItem.Coord.longitude));
        myIntent.putExtra("LocationIcon", GroupItem);
        Locations.this.startActivity(myIntent);
    }

    // Locations' data and definitions go below...
    class LocationGroup{
        String GroupHeader;
        String GroupType;
        ArrayList<Location> Locations;

        LocationGroup(String GroupHeader, String GroupType, ArrayList<Location> Locations){
            this.GroupHeader = GroupHeader;
            this.GroupType = GroupType;
            this.Locations = Locations;
        }
    }

    class Location{
        String Name;
        LatLng Coord;

        public Location(String Name, LatLng Coord) {
            this.Name = Name;
            this.Coord = Coord;
        }
    }

    public void FillGroupsList(){
        ArrayList<Location> NSIT_locations = new ArrayList<>();
        NSIT_locations.add(new Location("North Gate",new LatLng(28.613156, 77.033553)));
        NSIT_locations.add(new Location("South Gate",new LatLng(28.608464, 77.035069)));
        LocationGroup NSITGroup = new LocationGroup("NSIT","College",NSIT_locations);

        ArrayList<Location> Campus_locations = new ArrayList<>();
        Campus_locations.add(new Location("Administrative Block", new LatLng(28.609790, 77.036969)));
        Campus_locations.add(new Location("Block VI - ICE/MPAE", new LatLng(28.610334, 77.037869)));
        Campus_locations.add(new Location("Block V - COE/IT", new LatLng(28.609853, 77.038506)));
        Campus_locations.add(new Location("Block IV - ECE/BT", new LatLng(28.609706, 77.037629)));
        Campus_locations.add(new Location("Main Auditorium", new LatLng(28.609687, 77.037034)));
        Campus_locations.add(new Location("Mini Auditorium", new LatLng(28.609623, 77.038056)));
        LocationGroup CampusGroup = new LocationGroup("Main Campus","Campus",Campus_locations);

        ArrayList<Location> Hostel_locations = new ArrayList<>();
        Hostel_locations.add(new Location("Boys' Hostel I", new LatLng(28.612252, 77.035054)));
        Hostel_locations.add(new Location("Boys' Hostel II", new LatLng(28.612601, 77.035971)));
        Hostel_locations.add(new Location("Boys' Hostel III", new LatLng(28.613392, 77.035534)));
        Hostel_locations.add(new Location("Boys' Hostel IV - Ramanujam", new LatLng(28.613081, 77.034587)));
        Hostel_locations.add(new Location("Girls' Hostel", new LatLng(28.607378, 77.039520)));
        Hostel_locations.add(new Location("Girls' Hostel II", new LatLng(28.613694, 77.038296)));
        LocationGroup HostelGroup = new LocationGroup("Hostels","Hostel",Hostel_locations);

        ArrayList<Location> Canteens_locations = new ArrayList<>();
        Canteens_locations.add(new Location("Zayca", new LatLng(28.611066, 77.039385)));
        Canteens_locations.add(new Location("Mini Zayca", new LatLng(28.610205, 77.036651)));
        Canteens_locations.add(new Location("Just Cafe", new LatLng(28.612243, 77.036523)));
        Canteens_locations.add(new Location("McCain", new LatLng(28.612177, 77.036346)));
        LocationGroup CanteensGroup = new LocationGroup("Canteens","Canteen",Canteens_locations);

        ArrayList<Location> Stationery_locations = new ArrayList<>();
        Stationery_locations.add(new Location("Babloo Stationery", new LatLng(28.611066, 77.039385)));
        Stationery_locations.add(new Location("Radha Stationery", new LatLng(28.610205, 77.036651)));
        LocationGroup StationeryGroup = new LocationGroup("Stationery Stores","Stationery",Stationery_locations);

        ArrayList<Location> ATM_locations = new ArrayList<>();
        ATM_locations.add(new Location("Admin ATM", new LatLng(28.609541, 77.037096)));
        ATM_locations.add(new Location("North Gate ATM", new LatLng(28.613142, 77.033563)));
        ATM_locations.add(new Location("South Gate ATM", new LatLng(28.608451, 77.035091)));
        LocationGroup ATMGroup = new LocationGroup("ATMs","ATM",ATM_locations);

        ArrayList<Location> WiFi_locations = new ArrayList<>();
        WiFi_locations.add(new Location("CADLAB", new LatLng(28.609862, 77.038545)));
        WiFi_locations.add(new Location("GCLAB", new LatLng(28.609907, 77.038720)));
        WiFi_locations.add(new Location("KHUSHIL", new LatLng(28.609903, 77.038745)));
        LocationGroup WiFiGroup = new LocationGroup("WiFi Hotspots","WiFi",WiFi_locations);

        ArrayList<Location> Sports_locations = new ArrayList<>();
        Sports_locations.add(new Location("Pavilion", new LatLng(28.608879, 77.040770)));
        Sports_locations.add(new Location("Tennis Courts", new LatLng(28.609289, 77.040550)));
        Sports_locations.add(new Location("Basketball Courts", new LatLng(28.609990, 77.040421)));
        Sports_locations.add(new Location("Volleyball Courts", new LatLng(28.609712, 77.040389)));
        Sports_locations.add(new Location("Cricket Field", new LatLng(28.610056, 77.041441)));
        Sports_locations.add(new Location("Football Field", new LatLng(28.608709, 77.041505)));
        LocationGroup SportsGroup = new LocationGroup("Sports Ground","Sports",Sports_locations);

        ArrayList<Location> Misc_locations = new ArrayList<>();
        Misc_locations.add(new Location("Central Library", new LatLng(28.610287, 77.039059)));
        Misc_locations.add(new Location("Motorsports Garage", new LatLng(28.611212, 77.039334)));
        Misc_locations.add(new Location("Nescii Lawns", new LatLng(28.609595, 77.035431)));
        Misc_locations.add(new Location("Shopping Complex", new LatLng(28.612351, 77.037615)));
        LocationGroup MiscGroup = new LocationGroup("Others","Miscellaneous",Misc_locations);

        this.LocationsGroupsList.add(NSITGroup);
        this.LocationsGroupsList.add(CampusGroup);
        this.LocationsGroupsList.add(HostelGroup);
        this.LocationsGroupsList.add(CanteensGroup);
        this.LocationsGroupsList.add(StationeryGroup);
        this.LocationsGroupsList.add(ATMGroup);
        this.LocationsGroupsList.add(WiFiGroup);
        this.LocationsGroupsList.add(SportsGroup);
        this.LocationsGroupsList.add(MiscGroup);
    }


}