package nsit.app.com.nsitapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

public class Choose extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    String[] sem={"Select semester","Sem 1","Sem 3","Sem 5","Sem 7"};
    String[] branch={"Select Branch","COE","IT","ECE","ICE","MPAE","BT"};
    String[] section={"Select section","Sec 1","Sec 2","Sec 3"};
    String[] section1={"Select section","Sec 1","Sec 2"};
    String[] Half2={"Select Half","First Half","Second Half"};

    String[] x ={"Select Section"};
    Spinner Sem,Branch,Sec,Half;
    Boolean s,b,sect,h;
    Button set;
    String se,br,sec,hal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Sem = (Spinner) findViewById(R.id.sem);
        Branch = (Spinner) findViewById(R.id.branch);
        Sec = (Spinner) findViewById(R.id.sec);
        Half = (Spinner) findViewById(R.id.half);
        set = (Button) findViewById(R.id.set);

        ArrayAdapter adapte = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,x);
        Sec.setAdapter(adapte);
        Sec.setOnItemSelectedListener(this);


        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,sem);
        Sem.setAdapter(adapter);
        Sem.setOnItemSelectedListener(this);

        ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,branch);
        Branch.setAdapter(adapter2);
        Branch.setOnItemSelectedListener(this);

        ArrayAdapter adapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,Half2);
        Half.setAdapter(adapter3);
        Half.setOnItemSelectedListener(this);


        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!s){
                    Toast.makeText(getApplicationContext(),"Select Semester",Toast.LENGTH_SHORT).show();
                }else if(!b){
                    Toast.makeText(getApplicationContext(),"Select Branch",Toast.LENGTH_SHORT).show();
                }else if(!sect){
                    Toast.makeText(getApplicationContext(),"Select Section",Toast.LENGTH_SHORT).show();
                }else if(!h){
                    Toast.makeText(getApplicationContext(),"Select Half",Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor e = s.edit();
                    e.putString("sem", se);
                    e.putString("sec", sec);
                    e.putString("branch", br);
                    e.putString("half", hal);

                    
                    Log.e("here",se +"\n"+sec+"\n"+br+"\n"+"  ");
                String timetableid = null;
                    if(se.equals("Sem 1")){
                        Log.e("in","Sem 1");
                        if(br.equals("COE")) {
                            if(sec.equals("Sec 1"))
                            timetableid = Val.COE_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.COE_sem1_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.COE_sem1_sec3;
                        }
                        if(br.equals("IT")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.IT_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.IT_sem1_sec2;
                             }
                        if(br.equals("ECE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ECE_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ECE_sem1_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ECE_sem1_sec3;
                        }
                        if(br.equals("ICE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ICE_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ICE_sem1_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ICE_sem1_sec3;
                        }
                        if(br.equals("MPAE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.MPAE_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.MPAE_sem1_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.MPAE_sem1_sec3;
                        }
                        if(br.equals("BT")) {
                                timetableid = Val.BT_sem1_sec1;
                        }

                    }
                    if(se.equals("Sem 3")){
                        Log.e("in","Sem 3");
                        if(br.equals("COE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.COE_sem3_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.COE_sem3_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.COE_sem3_sec3;
                        }
                        if(br.equals("IT")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.IT_sem3_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.IT_sem3_sec2;
                        }
                        if(br.equals("ECE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ECE_sem3_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ECE_sem3_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ECE_sem3_sec3;
                        }
                        if(br.equals("ICE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ICE_sem3_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ICE_sem3_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ICE_sem3_sec3;
                        }
                        if(br.equals("MPAE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.MPAE_sem3_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.MPAE_sem3_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.MPAE_sem3_sec3;
                        }
                        if(br.equals("BT")) {
                            timetableid = Val.BT_sem3_sec1;
                        }

                    }
                    if(se.equals("Sem 5")){
                        if(br.equals("COE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.COE_sem5_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.COE_sem5_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.COE_sem5_sec3;
                        }
                        if(br.equals("IT")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.IT_sem5_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.IT_sem5_sec2;
                        }
                        if(br.equals("ECE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ECE_sem5_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ECE_sem5_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ECE_sem5_sec3;
                        }
                        if(br.equals("ICE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ICE_sem5_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ICE_sem5_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ICE_sem5_sec3;
                        }
                        if(br.equals("MPAE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.MPAE_sem5_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.MPAE_sem5_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.MPAE_sem5_sec3;
                        }
                        if(br.equals("BT")) {
                            timetableid = Val.BT_sem5_sec1;
                        }

                    }
                    if(se.equals("Sem 7")){
                        if(br.equals("COE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.COE_sem7_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.COE_sem7_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.COE_sem7_sec3;
                        }
                        if(br.equals("IT")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.IT_sem7_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.IT_sem7_sec2;
                        }
                        if(br.equals("ECE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ECE_sem7_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ECE_sem7_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ECE_sem7_sec3;
                        }
                        if(br.equals("ICE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ICE_sem7_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ICE_sem7_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ICE_sem7_sec3;
                        }
                        if(br.equals("MPAE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.MPAE_sem7_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.MPAE_sem7_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.MPAE_sem7_sec3;
                        }
                        if(br.equals("BT")) {
                            timetableid = Val.BT_sem7_sec1;
                        }

                    } if(se.equals("Sem 1")){
                        if(br.equals("COE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.COE_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.COE_sem1_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.COE_sem1_sec3;
                        }
                        if(br.equals("IT")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.IT_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.IT_sem1_sec2;
                        }
                        if(br.equals("ECE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ECE_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ECE_sem1_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ECE_sem1_sec3;
                        }
                        if(br.equals("ICE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.ICE_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.ICE_sem1_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.ICE_sem1_sec3;
                        }
                        if(br.equals("MPAE")) {
                            if(sec.equals("Sec 1"))
                                timetableid = Val.MPAE_sem1_sec1;
                            if(sec.equals("Sec 2"))
                                timetableid = Val.MPAE_sem1_sec2;
                            if(sec.equals("Sec 3"))
                                timetableid = Val.MPAE_sem1_sec3;
                        }
                        if(br.equals("BT")) {
                            timetableid = Val.BT_sem1_sec1;
                        }

                    }


                    if(s.getString("timetableid",null).equals(timetableid))
                        e.putBoolean("timetablechanged",true);


                    e.putString("timetableid",timetableid);
                    e.putBoolean("classset", true);

                    Log.e("timetable id", " " + timetableid);

                    e.commit();
                    finish();
                }
            }
        });
        setTitle("Select Your Class ");

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        if(parent.getId()==R.id.sem) {
            if(position!=0){
              s=true;
                se = sem[position];
            }else {
                s = false;
            }
        }
        if(parent.getId()==R.id.branch) {
            if(position==0){
                ArrayAdapter adapte = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, x);
                Sec.setAdapter(adapte);
                b = false;
            }else {

                b=true;
                br = branch[position];
                if(position==2){
                    ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,section1);
                    Sec.setAdapter(adapter2);


                }else if(position==6){
                    ArrayAdapter adapte = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, x);
                    Sec.setAdapter(adapte);
                    h=true;

                }

               else {
                    ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,section);
                    Sec.setAdapter(adapter2);
                }
            }
        }
        if(parent.getId()==R.id.half){
            if(position==0){
                h=false;
            }
            else{
                h=true;
                hal = Half2[position];
            }
        }
        if(parent.getId()==R.id.sec){
            if(position==0){
                sect=false;
            }else{
                sect=true;
                sec = section[position];
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
