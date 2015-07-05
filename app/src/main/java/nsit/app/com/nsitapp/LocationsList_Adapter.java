package nsit.app.com.nsitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sidharth Patro on 22-Jun-15.
 */
public class LocationsList_Adapter extends BaseExpandableListAdapter {

    Context context;
    ArrayList<Locations.LocationGroup> LocationItems = new ArrayList<>();
    ArrayList<Locations.Location> LocationGroupItems = new ArrayList<>();
    private static LayoutInflater inflater = null;

    public LocationsList_Adapter(Context context, ArrayList<Locations.LocationGroup> LocationItems, ArrayList<Locations.Location> LocationGroupItems) {
        this.context = context;
        this.LocationItems = LocationItems;
        this.LocationGroupItems = LocationGroupItems;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    @Override
//    public int getCount() {
//        Log.e("Size", String.valueOf(LocationItems.size()));
//        return LocationItems.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return LocationItems.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View vi = convertView;
//        if (vi == null)
//            vi = inflater.inflate(R.layout.location_listitem, null);
//        TextView Header = (TextView)vi.findViewById(R.id.LocationsGroupHeader);
//        Log.e("Header", (String) Header.getText());
//        ListView GroupsList = (ListView)vi.findViewById(R.id.LocationsGroupList);
//        Header.setText(LocationItems.get(position).GroupHeader);
//        ArrayList<Locations.Location> LocationGroupsList = LocationItems.get(position).Locations;
//        GroupsList.setAdapter(new LocationsGroupsList_Adapter(context,LocationGroupsList));
//        return vi;
//    }

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
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.location_listitem, null);
        }

        TextView GroupHeader = (TextView) convertView
                .findViewById(R.id.LocationsGroupHeader);
        GroupHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = ((Locations.Location)getChild(groupPosition, childPosition)).Name;

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.locationgroup_listitem, null);
        }

        TextView txtHeader = (TextView) convertView.findViewById(R.id.LocationItem);
        txtHeader.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}



//public class ExpandableListAdapter extends BaseExpandableListAdapter {
//
//    private Context _context;
//    private List<String> _listDataHeader; // header titles
//    // child data in format of header title, child title
//    private HashMap<String, List<String>> _listDataChild;
//
//    public ExpandableListAdapter(Context context, List<String> listDataHeader,
//                                 HashMap<String, List<String>> listChildData) {
//        this._context = context;
//        this._listDataHeader = listDataHeader;
//        this._listDataChild = listChildData;
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosititon) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//                .get(childPosititon);
//    }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition) {
//        return childPosition;
//    }
//
//    @Override
//    public View getChildView(int groupPosition, final int childPosition,
//                             boolean isLastChild, View convertView, ViewGroup parent) {
//
//        final String childText = (String) getChild(groupPosition, childPosition);
//
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this._context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.list_item, null);
//        }
//
//        TextView txtListChild = (TextView) convertView
//                .findViewById(R.id.lblListItem);
//
//        txtListChild.setText(childText);
//        return convertView;
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//                .size();
//    }
//
//    @Override
//    public Object getGroup(int groupPosition) {
//        return this._listDataHeader.get(groupPosition);
//    }
//
//    @Override
//    public int getGroupCount() {
//        return this._listDataHeader.size();
//    }
//
//    @Override
//    public long getGroupId(int groupPosition) {
//        return groupPosition;
//    }
//
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded,
//                             View convertView, ViewGroup parent) {
//        String headerTitle = (String) getGroup(groupPosition);
//        if (convertView == null) {
//            LayoutInflater infalInflater = (LayoutInflater) this._context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = infalInflater.inflate(R.layout.list_group, null);
//        }
//
//        TextView lblListHeader = (TextView) convertView
//                .findViewById(R.id.lblListHeader);
//        lblListHeader.setTypeface(null, Typeface.BOLD);
//        lblListHeader.setText(headerTitle);
//
//        return convertView;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return false;
//    }
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        return true;
//    }
//}