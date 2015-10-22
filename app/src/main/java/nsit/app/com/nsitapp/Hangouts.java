package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.Locations;

/**
 * Created by AGGARWAL'S on 10/11/2015.
 */
public class Hangouts extends Fragment{

    public static final String CHOICE_TYPE  = "Choice";
    private Activity activity;
    private ListView listView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rooview = inflater.inflate(R.layout.fragment_hangouts,container,false);
        listView = (ListView)rooview.findViewById(R.id.hangouts_list);
        listView.setAdapter(new HangoutList_Adapter(getActivity()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i != 0) {
                    Intent intent = new Intent(getActivity(), HangoutsTypeDisplay.class);
                    intent.putExtra(CHOICE_TYPE, i-1);
                    startActivity(intent);
                } else {

                    Intent intent = new Intent(getActivity(), Locations.class);
                   startActivity(intent);


                }
            }
        });
        return rooview;
    }
}
