package nsit.app.com.nsitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Sumit Vohra on 7-Sept-15.
 */
public class CodeRadarList_Adapter extends BaseExpandableListAdapter {

    Context context;
    ArrayList<JudgeGroup> LocationItems = new ArrayList<>();
    ArrayList<String> LocationGroupItems = new ArrayList<>();
    public int groupClicked;

    private static LayoutInflater inflater = null;
    ExpandableListView listView;
    public static int lastExpandedGroupPosition = -1;


    public void setGroupClicked(int groupPosition){
        groupClicked = groupPosition;
    }

    public CodeRadarList_Adapter(Context context, ArrayList<JudgeGroup> LocationItems, ArrayList<String> LocationGroupItems) {
        this.context = context;
        this.LocationItems = LocationItems;
        this.LocationGroupItems = LocationGroupItems;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getGroupCount() {
        return LocationItems.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return  (this.LocationItems.get(groupPosition).CodeForces_Properties.size());
    }

    @Override
    public JudgeGroup getGroup(int groupPosition) {
        return LocationItems.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.LocationItems.get(groupPosition).CodeForces_Properties.get(childPosition);
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
        JudgeGroup LocGroup = getGroup(groupPosition);
        String headerTitle = LocGroup.GroupHeader;
        String groupType = LocGroup.GroupType;
        listView = (ExpandableListView)parent;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.location_listitem, null);
        }
        this.listView = (ExpandableListView)parent;

        TextView GroupHeader = (TextView) convertView
                .findViewById(R.id.LocationsGroupHeader);
        GroupHeader.setText(headerTitle);
        ImageView GroupIcon = (ImageView) convertView.findViewById(R.id.GroupTypeImage);
        Log.e("i  heercsa","D"+groupType+" "+groupPosition);
        switch (groupType) {
            case "Contest Reminder":
                GroupIcon.setImageResource(R.drawable.ic_alarm_black_24dp);
                break;
            case "CodeForces":
                GroupIcon.setImageResource(R.drawable.ic_code_black_24dp);
                break;
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = LocationItems.get(groupPosition).CodeForces_Properties.get(childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.locationgroup_listitem, null);
        }

        TextView txtHeader = (TextView) convertView.findViewById(R.id.LocationItem);
        txtHeader.setText(childText);

        if(lastExpandedGroupPosition == groupPosition) {
            AnimationSet set = new AnimationSet(true);
            TranslateAnimation slide = new TranslateAnimation(0, 0, -50, 0);
            slide.setInterpolator(new DecelerateInterpolator(5.0f));
            slide.setDuration(100);
            Animation fade = new AlphaAnimation(0, 1.0f);
            fade.setInterpolator(new DecelerateInterpolator(5.0f));
            fade.setDuration(100);
            set.addAnimation(slide);
            set.addAnimation(fade);
            set.setStartOffset(childPosition * 100);
            convertView.startAnimation(set);
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition){
        lastExpandedGroupPosition = groupPosition;
    }
}
