package nsit.app.com.nsitapp;

/**
 * Created by Swati garg on 22-06-2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapters.ProfListCustomListViewAdapter;
import functions.Val;


public class ProfList extends AppCompatActivity {
    EditText s;
    public static final String[] titles = new String[]{"DM", "DC", "DP",
            "DM", "H&M",
            "ECE",
            "COE", "ICE", "MPAE", "IT", "BT", "SAS"};

    public static final String[] full = new String[]{
            "DEPARTMENT OF MANAGEMENT", "DEPARTMENT OF CHEMISTRY", "DEPARTMENT OF PHYSICS",
            "DEPARTMENT OF MATHS", "School Of Humanities & Management",
            "Division Of Electronics & Communication Engg",
            "Division Of Computer Engg", "Division Of Instrumentation & Control Engg",
            "Division Of Manufacturing Processes & Automation Engg",
            "Division Of Information Technology",
            "Division Of Bio-Technology", "School Of Applied Sciences"
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_proflist);


        Intent i = getIntent();
        int dept = i.getIntExtra("dept", 0);

        setTitle("Professors");

        ListView listView;
        listView = (ListView) findViewById(R.id.profListView);
        listView.setTextFilterEnabled(true);
        TextView tv = (TextView) findViewById(R.id.textView);


        List<ProfListRowItem> profe = new ArrayList<ProfListRowItem>();

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
            for (int j = 0; j < ar.length(); j++) {

                name[k] = ar.getJSONObject(j).getString("Name");
                if (ar.getJSONObject(j).getString("Designation") != "")
                    name[k] = name[k] + " , " + ar.getJSONObject(j).getString("Designation");
                ids[k] = ar.getJSONObject(j).getString("Email");
                contact[k] = ar.getJSONObject(j).getString("ContactNo");
                k++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < k; j++) {
            ProfListRowItem item = new ProfListRowItem(name[j], ids[j], contact[j]);
            profe.add(item);

        }

        adapter = new ProfListCustomListViewAdapter(this, R.layout.prof_list_item, profe);
        listView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
