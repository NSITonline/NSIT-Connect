package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import functions.ButtonAnimation;

/**
 * Created by SUMIT VOHRA ON 07/09/15
 */


public class CodeRadar extends Fragment {

    ArrayList<JudgeGroup> Judges = new ArrayList<>();
    public ExpandableListView listView;
    ExpandableListAdapter listAdapter;

    static Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        setHasOptionsMenu(false);
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public void populateList(ArrayList<JudgeGroup> Items) {
        FillGroupsList();
        listAdapter = new CodeRadarList_Adapter(getActivity(), Items, null);
        listView.setAdapter(listAdapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_code_radar, container, false);
        listView = (ExpandableListView) rootView.findViewById(R.id.CodeRadar_list);
        populateList(Judges);

        this.listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, getActivity());
                String groupType = Judges.get(groupPosition).GroupType;
                Integer IconId = null;
                switch (groupType) {
                    case "CodeForces":
                        IconId = R.drawable.ic_school_black_24dp;
                        break;

                }
                v.setTag(groupPosition);
                try

                {
                    Log.v("childPsition", Integer.toString(childPosition));
                    if (groupPosition == 1) {
                        if (childPosition == 0) {
                            Intent intent = new Intent(getActivity(), User_Info.class);
                            startActivity(intent);
                        }
                    } else if (groupPosition == 0) {
                        if (childPosition == 0) {
                            Intent intent = new Intent(getActivity(), nsit.app.com.nsitapp.view.contest_reminder.class);
                            startActivity(intent);

                        }


                    }
                  } catch (Exception e) {
                    Log.e("I_AM_NOT_HAPPY", "Error "+ e.getMessage()+" ");
                }

                return false;
            }
        });


        return rootView;
    }


    public void FillGroupsList() {
        ArrayList<String> CodeForces_locations = new ArrayList<>();
        CodeForces_locations.add("User Information");

        ArrayList<String> contest_remind = new ArrayList<>();
        contest_remind.add("View Contests");
        JudgeGroup NSITGroup = new JudgeGroup("Contest Reminder", "Contest Reminder", contest_remind);

        this.Judges.add(NSITGroup);

        NSITGroup = new JudgeGroup("CodeForces", "CodeForces", CodeForces_locations);
        this.Judges.add(NSITGroup);


    }

}










