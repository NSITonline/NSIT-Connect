package nsit.app.com.nsitapp.Calendar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import functions.ButtonAnimation;
import functions.Constant;
import nsit.app.com.nsitapp.R;

public class ChooseClass extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Constant {

    private final String[] sem = {"Semester", "Sem 1", "Sem 2", "Sem 3", "Sem 4", "Sem 5", "Sem 6", "Sem 7", "Sem 8"};
    private final String[] branch = {"Branch", "COE", "IT", "ECE", "ICE", "MPAE", "BT", "ME"};
    private final String[] section = {"Section", "Sec 1", "Sec 2", "Sec 3"};
    private final String[] section1 = {"Section", "Sec 1", "Sec 2"};
    private final String[] section2 = {"Section", "Sec 1"};

    private final String[] sectionDefault = {"Section"};
    private Boolean s, b, sect;
    private int se, br, sec;

    @BindView(R.id.sem)
    Spinner sem1;
    @BindView(R.id.branch)
    Spinner branch1;
    @BindView(R.id.sec)
    Spinner Sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        ButterKnife.bind(this);

        ArrayAdapter adapte = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sectionDefault);
        Sec.setAdapter(adapte);
        Sec.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sem);
        sem1.setAdapter(adapter);
        sem1.setOnItemSelectedListener(this);

        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, branch);
        branch1.setAdapter(adapter2);
        branch1.setOnItemSelectedListener(this);

        setTitle("Select Your Class ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @OnClick(R.id.set)
    public void setclicked(View view) {
        if (!s) {
            Snackbar.make(sem1, "Please Enter Semester", Snackbar.LENGTH_LONG).show();
        } else if (!b) {
            Snackbar.make(sem1, "Please Enter Branch", Snackbar.LENGTH_LONG).show();
        } else if (!sect && br != 7) {
            Snackbar.make(sem1, "Please Enter Section", Snackbar.LENGTH_LONG).show();
        } else {

            Log.e("here", se + "\n" + sec + "\n" + br + "\n" + "  ");
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(CALENDAR_SEM, se);
            editor.putInt(CALENDAR_BRANCH, br);
            editor.putInt(CALENDAR_SECTION, sec);
            editor.putBoolean(IS_CLASS_SET, true);
            editor.putBoolean(IS_TIME_TABLE_CHANGED, true);
            editor.apply();

            finish();
        }
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getApplicationContext());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.sem) {
            if (position != 0) {
                s = true;
                se = position;
            } else {
                s = false;
            }
        }
        if (parent.getId() == R.id.branch) {
            if (position == 0) {
                ArrayAdapter adapte = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sectionDefault);
                Sec.setAdapter(adapte);
                b = false;
            } else {
                b = true;
                br = position;
                switch (position) {
                    case 2: {
                        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, section1);
                        Sec.setAdapter(adapter2);
                        break;
                    }
                    case 6:
                    case 7:
                        ArrayAdapter adapte = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, section2);
                        Sec.setAdapter(adapte);
                        break;
                    default: {
                        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, section);
                        Sec.setAdapter(adapter2);
                        break;
                    }
                }
            }
        }

        if (parent.getId() == R.id.sec) {
            if (position == 0) {
                sect = false;
            } else {
                sect = true;
                sec = position;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}