package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import nsit.app.com.nsitapp.Locations;
import nsit.app.com.nsitapp.R;

import static functions.Utils.getLocationsIdMap;
import static functions.Utils.setAnimation;


/**
 * Created by Sidharth Patro on 22-Jun-15.
 */
public class LocationsListAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private ArrayList<Locations.LocationGroup> LocationItems;
    private static int lastExpandedGroupPosition = -1;
    private HashMap<String, Integer> locationsIdMap;

    @BindView(R.id.LocationsGroupHeader) TextView GroupHeader;
    @BindView(R.id.GroupTypeImage) ImageView GroupIcon;

    public LocationsListAdapter(Context context, ArrayList<Locations.LocationGroup> LocationItems) {
        this.context = context;
        this.LocationItems = LocationItems;
        locationsIdMap = getLocationsIdMap();
    }

    @Override
    public int getGroupCount() {
        return LocationItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.LocationItems.get(groupPosition).Locations.size();
    }

    @Override
    public Locations.LocationGroup getGroup(int groupPosition) {
        return LocationItems.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.LocationItems.get(groupPosition).Locations.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Locations.LocationGroup LocGroup = getGroup(groupPosition);
        String headerTitle = LocGroup.GroupHeader;
        String groupType = LocGroup.GroupType;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.location_listitem, parent, false);
        }
        ButterKnife.bind(this, convertView);

        GroupHeader.setText(headerTitle);
        GroupIcon.setImageResource(locationsIdMap.get(groupType));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = ((Locations.Location) getChild(groupPosition, childPosition)).Name;

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.locationgroup_listitem, parent, false);
        }

        TextView txtHeader = convertView.findViewById(R.id.LocationItem);
        txtHeader.setText(childText);

        if (lastExpandedGroupPosition == groupPosition)
            setAnimation(convertView);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        lastExpandedGroupPosition = groupPosition;
    }
}

