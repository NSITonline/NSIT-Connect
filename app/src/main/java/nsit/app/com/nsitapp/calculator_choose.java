package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import functions.ButtonAnimation;
import functions.Constant;
import functions.Val;

/**
 * Created by Swati garg on 23-12-2015.
 */


public class calculator_choose extends Fragment implements AdapterView.OnItemSelectedListener, Constant {

    Spinner Sem,Branch;
    Boolean s,b;
    int se,br;
    LinearLayout set;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    static Activity activity;
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = activity;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //setHasOptionsMenu(false);
        View rootView = inflater.inflate(R.layout.fragment_calculatorchoose, container, false);
        Sem = (Spinner) rootView.findViewById(R.id.sem);
        Branch = (Spinner) rootView.findViewById(R.id.branch);
        ArrayAdapter adapter = new ArrayAdapter(activity,android.R.layout.simple_spinner_dropdown_item, Val.sem);
        Sem.setAdapter(adapter);
        Sem.setOnItemSelectedListener(this);

        ArrayAdapter adapter2 = new ArrayAdapter(activity,android.R.layout.simple_spinner_dropdown_item,Val.branch);
        Branch.setAdapter(adapter2);
        Branch.setOnItemSelectedListener(this);

        set = (LinearLayout) rootView.findViewById(R.id.PlayContainer);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!s) {
                    SnackbarManager.show(
                            Snackbar.with(activity)
                                    .text("Please Enter Semester")
                                    .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);
                } else if (!b) {
                    SnackbarManager.show(
                            Snackbar.with(activity)
                                    .text("Please Enter Branch")
                                    .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);
                }else {
                    Intent i = new Intent(activity, Calculator.class);
                    i.putExtra(CALCULATOR_BRANCH, br);
                    i.putExtra(CALCULATOR_SEM,se);
                    startActivity(i);
                }
            }
        });



        return rootView;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



        if(parent.getId()==R.id.sem) {
            if(position!=0){
                s=true;
                se = position;
            }else {
                s = false;
            }
        }
        if(parent.getId()==R.id.branch) {
            if(position!=0){
                b=true;
                br = position;
            }else {
                b = false;
            }
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
