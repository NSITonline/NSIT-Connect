package nsit.app.com.nsitapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapters.CustomList_subjects_calculator;
import adapters.SubjectCalculate;
import functions.Constant;
import functions.Val;

public class Calculator extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Constant {


    int br,sem;
    TextView sub,credit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Intent i =getIntent();
        br = i.getIntExtra(CALCULATOR_BRANCH,1);
        sem = i.getIntExtra(CALCULATOR_SEM,1);

        sub = (TextView) findViewById(R.id.subject);
        credit = (TextView) findViewById(R.id.tcredits);

        JSONObject ob;
        JSONArray ar = null;
        String s="";

        try {
            ob = new JSONObject(Val.subjects);

            switch(br) {
                case 1 :ar = ob.getJSONArray("coe"); s = "COE" ;break;
                case 2 :ar = ob.getJSONArray("it");s = "IT" ;break;
                case 3 :ar = ob.getJSONArray("ece");s = "ECE" ;break;
                case 4 :ar = ob.getJSONArray("ice");s = "ICE" ;break;
                case 5 :ar = ob.getJSONArray("mpae");s = "MPAE" ;break;
                case 6 :ar = ob.getJSONArray("bt");s = "BT" ;break;
            }

            s = s +" Semester : "+sem;



            ob = ar.getJSONObject(sem-1);




            sub.setText(s);
            credit.append(ob.getString("totalCredits"));
            CustomList_subjects_calculator ad;




            ob= ob.getJSONObject("subjects");
            ArrayList<String> sno = new ArrayList<>();
            ArrayList<String> code = new ArrayList<>();
            ArrayList<String> name= new ArrayList<>();
            ArrayList<String> cred= new ArrayList<>();

            JSONArray ob2 ;
            ob2 = ob.getJSONArray("theory");
            for(int it=0;it<ob2.length();it++){
                sno.add(ob2.getJSONObject(it).getString("sno"));
                code.add( ob2.getJSONObject(it).getString("code"));
                name.add(ob2.getJSONObject(it).getString("name"));
                cred.add(ob2.getJSONObject(it).getString("credits"));


            }
            ob2 = ob.getJSONArray("practical");
            for(int it=0;it<ob2.length();it++){
                sno.add(ob2.getJSONObject(it).getString("sno"));
                code.add( ob2.getJSONObject(it).getString("code"));
                name.add(ob2.getJSONObject(it).getString("name"));
                cred.add(ob2.getJSONObject(it).getString("credits"));

            }



            ad = new CustomList_subjects_calculator(this,sno,code,name,cred);
            ListView lv = (ListView) findViewById(R.id.lv);
            lv.setAdapter(ad);


        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("error",""+e.getMessage());
        }


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
