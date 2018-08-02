package nsit.app.com.nsitapp.professor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.ButterKnife;
import functions.Constant;
import models.ProfListRowItem;
import nsit.app.com.nsitapp.R;


public class ProfessorsList extends AppCompatActivity implements Constant {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_proflist);

        ButterKnife.bind(this);

        Intent i = getIntent();
        int dept = i.getIntExtra("dept", 0);

        setTitle(R.string.professor);

        ListView listView;
        listView = findViewById(R.id.profListView);
        listView.setTextFilterEnabled(true);
        TextView tv = findViewById(R.id.textView);

        List<ProfListRowItem> profListRowItems = new ArrayList<>();

        tv.setText(DEPARTMENT_LIST[dept]);

        final ProfListCustomListViewAdapter adapter;

        String[] name = new String[100], ids = new String[100], contact = new String[100];
        int length = 0;
        JSONArray array;
        JSONObject object;

        try {
            array = new JSONArray(pro);
            object = array.getJSONObject(dept);
            array = object.getJSONArray("ContentArray");

            int len1 = array.length();
            for (int j = 0; j < len1; j++) {

                name[length] = array.getJSONObject(j).getString("Name");
                if (!Objects.equals(array.getJSONObject(j).getString("Designation"), ""))
                    name[length] = name[length] + " , " + array.getJSONObject(j).getString("Designation");
                ids[length] = array.getJSONObject(j).getString("Email");
                contact[length] = array.getJSONObject(j).getString("ContactNo");
                length++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < length; j++) {
            ProfListRowItem item = new ProfListRowItem(name[j], ids[j], contact[j]);
            profListRowItems.add(item);
        }

        adapter = new ProfListCustomListViewAdapter(this, profListRowItems);
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
