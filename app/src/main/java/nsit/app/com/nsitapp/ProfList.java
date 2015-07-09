package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 22-06-2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;


public class ProfList extends Fragment {
    EditText s;
    public static final String[] titles = new String[] { "DM","DC","DP",
            "DM","H&M",
            "ECE",
            "COE","ICE","MPAE", "IT",   "BT","SAS"};

    public static final String[] full = new String[] {
            "DEPARTMENT OF MANAGEMENT","DEPARTMENT OF CHEMISTRY","DEPARTMENT OF PHYSICS",
            "DEPARTMENT OF MATHS","School Of Humanities & Management",
            "Division Of Electronics & Communication Engg",
            "Division Of Computer Engg",  "Division Of Instrumentation & Control Engg",
            "Division Of Manufacturing Processes & Automation Engg",
            "Division Of Information Technology",
            "Division Of Bio-Technology","School Of Applied Sciences"
    };


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
        View rootView = inflater.inflate(R.layout.fragment_proflist, container, false);
        Bundle i = this.getArguments();
        int dept = i.getInt("dept", 0);


        ListView listView;
        listView = (ListView) rootView.findViewById(R.id.profListView);
        listView.setTextFilterEnabled(true);
        TextView tv = (TextView) rootView.findViewById(R.id.textView);


        List<ProfListRowItem> profe=new ArrayList<ProfListRowItem>();

        tv.setText(full[dept]);

        final ProfListCustomListViewAdapter adapter;


        String[] name = new String[100], ids = new String[100], contact = new String[100];
        int k = 0;
        JSONArray ar;
        JSONObject ob;

        try {
            ar = new JSONArray(Val.pro);
            ob = ar.getJSONObject(dept);
            ar = ob.getJSONArray("ContentArray");
            Log.e("ar",ar.length() +" " );
            for (int j = 0; j < ar.length(); j++) {

                name[k] = ar.getJSONObject(j).getString("Name") ;
                if(ar.getJSONObject(j).getString("Designation")!="")
                    name[k] = name[k] + " , " + ar.getJSONObject(j).getString("Designation");
                ids[k] = ar.getJSONObject(j).getString("Email");
                contact[k] = ar.getJSONObject(j).getString("ContactNo");
                k++;
            }

        } catch (Exception e) {
            Log.e("eroor", e.getMessage()+" ");
        }
        for (int j = 0; j <k; j++) {
            ProfListRowItem item = new ProfListRowItem(name[j], ids[j], contact[j]);
            profe.add(item);

        }

        adapter = new ProfListCustomListViewAdapter(getActivity(), R.layout.prof_list_item, profe);
        listView.setAdapter(adapter);



    return rootView;
    }



}
