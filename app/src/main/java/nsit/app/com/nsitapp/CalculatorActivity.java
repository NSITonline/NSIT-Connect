package nsit.app.com.nsitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import static nsit.app.com.nsitapp.R.id.per;

public class CalculatorActivity extends Fragment {

    private Spinner s1,s2;
    private TextView tc10, tc11, tc12, tc9, tc4, tc5, tc1,tc2,tc3,tc8,tc7,tc6,rs;
    private double n1=-1.0, n2=-1.0, n3=-1.0, n4=-1.0, n5=-1.0, n6=-1.0, n7=-1.0, n8=-1.0, n9=-1.0, n10=-1.0, n11=-1.0, n12=-1.0;
    private EditText t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rooview = inflater.inflate(R.layout.activity_calculator, container, false);
        s1 = (Spinner) rooview.findViewById(R.id.spinb);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.branch, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        t1 = (EditText) rooview.findViewById(R.id.one);
        t2 = (EditText) rooview.findViewById(R.id.two);
        t3 = (EditText) rooview.findViewById(R.id.three);
        t4 = (EditText) rooview.findViewById(R.id.four);
        t5 = (EditText) rooview.findViewById(R.id.five);
        t6 = (EditText) rooview.findViewById(R.id.six);
        t7 = (EditText) rooview.findViewById(R.id.seven);
        t8 = (EditText) rooview.findViewById(R.id.eight);
        t9 = (EditText) rooview.findViewById(R.id.nine);
        t10 = (EditText) rooview.findViewById(R.id.ten);
        t11 = (EditText) rooview.findViewById(R.id.eleven);
        t12 = (EditText) rooview.findViewById(R.id.twelve);
        rs = (TextView) rooview.findViewById(per);
        Button b = (Button) rooview.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Sub_load.class);
                startActivity(i);

            }
        });

        b = (Button) rooview.findViewById(R.id.buttC);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCalculate(rooview);

            }
        });


        tc10 = (TextView) rooview.findViewById(R.id.tv10);
        tc11 = (TextView) rooview.findViewById(R.id.tv11);
        tc12 = (TextView) rooview.findViewById(R.id.tv12);
        tc9 = (TextView) rooview.findViewById(R.id.tv9);
        tc4 = (TextView) rooview.findViewById(R.id.tv4);
        tc5 = (TextView) rooview.findViewById(R.id.tv5);
        tc1 = (TextView) rooview.findViewById(R.id.tv1);
        tc2 = (TextView) rooview.findViewById(R.id.tv2);
        tc3 = (TextView) rooview.findViewById(R.id.tv3);
        tc8 = (TextView) rooview.findViewById(R.id.tv8);
        tc7 = (TextView) rooview.findViewById(R.id.tv7);
        tc6 = (TextView) rooview.findViewById(R.id.tv6);
        s2 = (Spinner) rooview.findViewById(R.id.spins);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.semester, android.R.layout.simple_list_item_1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        s2.setAdapter(adapter1);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                cc(rooview);
                if (s1.getSelectedItem().toString().equals("COE")) {
                    if (s2.getSelectedItem().toString().equals("Sem 1")) {


                        //tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        //tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        //tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {


                        //tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        //tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        //tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {


                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        //tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));

                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));

                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {


                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc5.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc4.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    }
                } else if (s1.getSelectedItem().toString().equals("IT")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {


                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {


                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc5.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc4.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    }
                } else if (s1.getSelectedItem().toString().equals("MPAE")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));

                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc4.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc5.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    }
                } else if (s1.getSelectedItem().toString().equals("ECE")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));

                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {

                    }
                } else if (s1.getSelectedItem().toString().equals("BT")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {


                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {
                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));

                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {

                    }

                } else if (s1.getSelectedItem().toString().equals("ICE")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {


                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {
                        tc9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));
                        tc10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_notselected));

                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {

                    }


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rooview;
    }


    private void cc(View rv) {

        TextView c1 = (TextView) rv.findViewById(R.id.tv1);
        TextView c2 = (TextView) rv.findViewById(R.id.tv2);
        TextView c3 = (TextView) rv.findViewById(R.id.tv3);
        TextView c4 = (TextView) rv.findViewById(R.id.tv4);
        TextView c5 = (TextView) rv.findViewById(R.id.tv5);
        TextView c6 = (TextView) rv.findViewById(R.id.tv6);
        TextView c7 = (TextView) rv.findViewById(R.id.tv7);
        TextView c8 = (TextView) rv.findViewById(R.id.tv8);
        TextView c9 = (TextView) rv.findViewById(R.id.tv9);
        TextView c10 = (TextView) rv.findViewById(R.id.tv10);
        TextView c11 = (TextView) rv.findViewById(R.id.tv11);
        TextView c12 = (TextView) rv.findViewById(R.id.tv12);

        c1.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c2.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c3.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c4.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c5.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c6.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c7.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c8.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c9.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c10.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c11.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));
        c12.setTextColor(ContextCompat.getColor(getContext(),R.color.calculator_selected));


    }


    private void onCalculate(View a) {




        double tux, pux, p = 0.0;


        if (s1.getSelectedItem().toString().equals("COE")) {
            if (s2.getSelectedItem().toString().equals("Sem 1")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());


                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = (3 * n6) + 2 * (n7 + n8 + n9);
                    p = (tux + pux) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 2")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());


                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux) / 28;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n10 = Double.parseDouble(t10.getText().toString());


                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8) + (3 * n9);
                    p = (tux + pux + n10) / 30;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n10 = Double.parseDouble(t10.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());
                    n12 = Double.parseDouble(t12.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9 + n10);
                    p = (tux + pux + n11 + n12) / 32;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());


                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8);
                    p = (tux + pux + n11) / 27;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 6")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());
                    n12 = Double.parseDouble(t12.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n12);
                    p = (tux + pux + n11) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    n11 = Double.parseDouble(t11.getText().toString());


                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8) + 3 * n9;
                    p = (tux + pux + n11) / 30;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 8")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());

                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());

                    n11 = Double.parseDouble(t11.getText().toString());


                    tux = 4 * (n1 + n2 + n3);
                    pux = (2 * n6) + (8 * n7) + (4 * n8);
                    p = (tux + pux + n11) / 27;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            }

        } else if (s1.getSelectedItem().toString().equals("IT")) {
            if (s2.getSelectedItem().toString().equals("Sem 1")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = (3 * n6) + 2 * (n7 + n8 + n9);
                    p = (tux + pux) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 2")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux) / 28;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8);
                    p = (tux + pux + n11) / 27;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n10 = Double.parseDouble(t10.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9 + n10);
                    p = (tux + pux) / 30;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());


                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8);
                    p = (tux + pux + n11) / 27;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 6")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux + n11) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());
                    n12 = Double.parseDouble(t12.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9 + n12) + (4 * n11);
                    p = (tux + pux) / 34;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 8")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3);
                    pux = (2 * n6) + (8 * n7) + (4 * n8) + (2 * n11);
                    p = (tux + pux) / 28;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            }

        } else if (s1.getSelectedItem().toString().equals("MPAE")) {

            if (s2.getSelectedItem().toString().equals("Sem 1")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = (3 * n6) + 2 * (n7 + n8 + n9);
                    p = (tux + pux) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 2")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux + n11) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux + n11) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());
                    n12 = Double.parseDouble(t12.getText().toString());


                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux + n11 + n12) / 30;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux + n11) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 6")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());
                    n12 = Double.parseDouble(t12.getText().toString());


                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux + n11 + n12) / 30;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux + n11) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 8")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3);
                    pux = 2 * (n6 + n7) + (8 * n8) + (2 * n9);
                    p = (tux + pux + n11) / 27;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            }

        } else if (s1.getSelectedItem().toString().equals("ECE"))  // 6, 7, 8 Credits not found false data taken
        {

            if (s2.getSelectedItem().toString().equals("Sem 1")) {
                try {

                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = (3 * n6) + 2 * (n7 + n8 + n9);
                    p = (tux + pux) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 2")) {
                try {

                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5 + n8);
                    pux = 2 * (n6 + n7 + n9);
                    p = (tux + pux) / 30;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 3")) {
                try {

                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8) + 3 * n9;
                    p = (tux + pux + n11) / 30;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 4")) {


                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n10 = Double.parseDouble(t10.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());
                    n12 = Double.parseDouble(t12.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9 + n10);
                    p = (tux + pux + n11 + n12) / 32;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8);
                    p = (tux + pux + n11) / 27;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 6")) {
                Toast.makeText(getActivity(), "Sem 6 ECE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();

                    /* EditText t1 = (EditText)a.a.findViewById(R.id.one);

                     tux = 4*(n1+n2+n3+n4+n5);
                     pux = 2*(n6+n7+n8+n9);
                     p   = (tux+pux+n11+n12)/30;

                     rs.setText(String.format("%.2f ",p));*/

            } else if (s2.getSelectedItem().toString().equals("Sem 7")) {
                Toast.makeText(getActivity(), "Sem 7 ECE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();
                    /* EditText t1 = (EditText)findViewById(R.id.one);
                     rs.setText(String.format("%.2f ",p));*/

            } else if (s2.getSelectedItem().toString().equals("Sem 8")) {
                Toast.makeText(getActivity(), "Sem 8 ECE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();

                    /* EditText t1 = (EditText)findViewById(R.id.one);
                     rs.setText(String.format("%.2f ",p));*/

            }

        } else if (s1.getSelectedItem().toString().equals("ICE")) // 7, 8 credits not found false data taken
        {


            if (s2.getSelectedItem().toString().equals("Sem 1")) {
                try {

                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = (3 * n6) + 2 * (n7 + n8 + n9);
                    p = (tux + pux) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }
            } else if (s2.getSelectedItem().toString().equals("Sem 2")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux) / 28;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 3")) {
                try {

                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8) + 3 * n9;
                    p = (tux + pux + n11) / 30;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    n10 = Double.parseDouble(t10.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());
                    n12 = Double.parseDouble(t12.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9 + n10);
                    p = (tux + pux + n11 + n12) / 32;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 5")) {
                try {

                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8);
                    p = (tux + pux + n11) / 27;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 6")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());
                    n12 = Double.parseDouble(t12.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n12);
                    p = (tux + pux + n11) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                }


            } else if (s2.getSelectedItem().toString().equals("Sem 7")) {
                Toast.makeText(getActivity(), "Sem 7 ICE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();

            } else if (s2.getSelectedItem().toString().equals("Sem 8")) {
                Toast.makeText(getActivity(), "Sem 8 ICE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();

            }

        } else if (s1.getSelectedItem().toString().equals("BT")) // 7,8 Credits not found false data taken
        {

            if (s2.getSelectedItem().toString().equals("Sem 1")) {
                try {

                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = (3 * n6) + 2 * (n7 + n8 + n9);
                    p = (tux + pux) / 29;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 2")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux) / 28;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());
                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n9);
                    p = (tux + pux) / 28;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 4")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n11);
                    p = (tux + pux) / 28;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 5")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n11 = Double.parseDouble(t11.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8 + n11);
                    p = (tux + pux) / 30;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }

            } else if (s2.getSelectedItem().toString().equals("Sem 6")) {
                try {
                    n1 = Double.parseDouble(t1.getText().toString());
                    n2 = Double.parseDouble(t2.getText().toString());
                    n3 = Double.parseDouble(t3.getText().toString());
                    n4 = Double.parseDouble(t4.getText().toString());
                    n5 = Double.parseDouble(t5.getText().toString());
                    n6 = Double.parseDouble(t6.getText().toString());
                    n7 = Double.parseDouble(t7.getText().toString());
                    n8 = Double.parseDouble(t8.getText().toString());
                    n9 = Double.parseDouble(t9.getText().toString());

                    tux = 4 * (n1 + n2 + n3 + n4 + n5);
                    pux = 2 * (n6 + n7 + n8);
                    p = (tux + pux + n9) / 28;
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();

                }


            } else if (s2.getSelectedItem().toString().equals("Sem 7")) {
                Toast.makeText(getActivity(), "Sem 7 BT credits not found. Can't calculate result", Toast.LENGTH_LONG).show();

            } else if (s2.getSelectedItem().toString().equals("Sem 8")) {
                Toast.makeText(getActivity(), "Sem 8 BT credits not found. Can't calculate result", Toast.LENGTH_LONG).show();

            }

        }

        rs.setText(String.format("%.2f ", p));
        addToStorage();

    }

    public void addToStorage() {
        File root = android.os.Environment.getExternalStorageDirectory();
        File dir = new File (root.getAbsolutePath() + "/NSITConnect");
        dir.mkdirs();
        File file = new File(dir, s1.getSelectedItem().toString()+"_"+s2.getSelectedItem().toString()+".txt");
        PrintWriter pw = null;
        FileOutputStream f = null;
        try{
            f = new FileOutputStream(file);
            pw = new PrintWriter(f);
            pw.println(tc1.getText()+"="+n1);
            pw.println(tc2.getText()+"="+n2);
            pw.println(tc3.getText()+"="+n3);
            pw.println(tc4.getText()+"="+n4);
            pw.println(tc5.getText()+"="+n5);
            pw.println(tc6.getText()+"="+n6);
            pw.println(tc7.getText()+"="+n7);
            pw.println(tc8.getText()+"="+n8);
            pw.println(tc9.getText()+"="+n9);
            pw.println(tc10.getText()+"="+n10);
            pw.println(tc11.getText()+"="+n11);
            pw.println(tc12.getText()+"="+n12);
            pw.flush();
            file.setReadOnly();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(pw!=null)
                pw.close();
            if(f!=null)
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    public void readFileFromStorage(){
        //InputStream is = this.getResources().openRawResource(R.raw.marksfile);
        File root = android.os.Environment.getExternalStorageDirectory();
        File dir = new File (root.getAbsolutePath() + "/NSITConnect");
        File file = new File(dir, s1.getSelectedItem().toString()+"_"+s2.getSelectedItem().toString()+".txt");
        if(!file.exists()){
            Toast.makeText(getContext(),"Marks not available",Toast.LENGTH_SHORT).show();
            return;
        }
        BufferedReader reader = null;
        String s="";
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((s=reader.readLine())!=null){
                String[] splits = s.split("=");
                if(splits[0].equals("TH 1")&&!splits[1].equals("-1.0"))
                    t1.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("TH 2")&&!splits[1].equals("-1.0"))
                    t2.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("TH 3")&&!splits[1].equals("-1.0"))
                    t3.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("TH 4")&&!splits[1].equals("-1.0"))
                    t4.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("TH 5")&&!splits[1].equals("-1.0"))
                    t5.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("PR 1")&&!splits[1].equals("-1.0"))
                    t6.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("PR 2")&&!splits[1].equals("-1.0"))
                    t7.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("PR 3")&&!splits[1].equals("-1.0"))
                    t8.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("PR 4")&&!splits[1].equals("-1.0"))
                    t9.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("PR 5")&&!splits[1].equals("-1.0"))
                    t10.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("VS 1")&&!splits[1].equals("-1.0"))
                    t11.setText(""+(int)(Double.parseDouble(splits[1])));
                if(splits[0].equals("VS 2")&&!splits[1].equals("-1.0"))
                    t12.setText(""+(int)(Double.parseDouble(splits[1])));
                //Toast.makeText(getContext(),splits[0]+splits[1],Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_calculator,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.clear:
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t12.setText("");
                rs.setText("");
                return true;

            case R.id.show_previous_marks:
                readFileFromStorage();
                return true;
            default:
                break;
        }

        return false;
    }
}