package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 22-06-2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Professors extends Fragment implements
        AdapterView.OnItemClickListener {
    public static final String[] titles = new String[] { "ECE",
            "COE", "ICE", "MPAE", "IT", "BT","PCME"};

    public static final String[] full = new String[] {
            "Division Of Electronics & Communication Engg",
            "Division Of Computer Engg", "Division Of Instrumentation & Control Engg",
            "Division Of Manufacturing Processes & Automation Engg", "Division Of Information Technology","Division Of Bio-Technology","School Of Applied Sciences"
    };

    ListView listView;
    List<RowItem> rowItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Activity activity;
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_prof, container, false);


        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(titles[i].toUpperCase(), full[i]);
            rowItems.add(item);
        }

        listView = (ListView) rootView.findViewById(R.id.list);
        CustomListViewAdapter adapter = new CustomListViewAdapter(getActivity(),
                R.layout.list_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


        return rootView;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment mFragment = new ProfList();
        Bundle bundle = new Bundle();
        bundle.putInt("dept", position);
        mFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mFragment).addToBackStack( "tag" ).commit();

    }

}
