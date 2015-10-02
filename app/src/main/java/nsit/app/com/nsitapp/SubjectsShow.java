package nsit.app.com.nsitapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import adapters.CustomList_subjects;


public class SubjectsShow extends AppCompatActivity {
    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    Button b;
    ListView lv;
    CustomList_subjects a;

    @Override
    protected void onResume() {
        super.onResume();
        a.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_show);
        lv = (ListView) findViewById(R.id.list);

        setTitle("Attendance");
        JSONObject ob;
        JSONArray ar;

        if (Calender.timetable != null)
            try {
                ob = new JSONObject(Calender.timetable);
                ar = ob.getJSONArray("subjects");
                for (int i = 0; i < ar.length(); i++) {
                    list1.add(ar.getJSONObject(i).getString("code"));
                    list2.add(ar.getJSONObject(i).getString("title"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("error", e.getMessage() + " ");
            }

        a = new CustomList_subjects(this, list1, list2);
        lv.setAdapter(a);
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
