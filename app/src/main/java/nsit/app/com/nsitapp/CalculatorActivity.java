package nsit.app.com.nsitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Fragment {

    Spinner s1;
    Spinner s2;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapter1;
    Button b;
    TextView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12;
    TextView tc10, tc11, tc12, tc9, tc4, tc5;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rooview = inflater.inflate(R.layout.activity_calculator, container, false);
        s1 = (Spinner) rooview.findViewById(R.id.spinb);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.branch, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        b = (Button) rooview.findViewById(R.id.button);
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
        s2 = (Spinner) rooview.findViewById(R.id.spins);
        adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.semester, android.R.layout.simple_list_item_1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        s2.setAdapter(adapter1);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                cc(rooview);
                if (s1.getSelectedItem().toString().equals("COE")) {
                    if (s2.getSelectedItem().toString().equals("Sem 1")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {


                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));

                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));

                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {


                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc5.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc4.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    }
                } else if (s1.getSelectedItem().toString().equals("IT")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {


                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {


                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc5.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc4.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    }
                } else if (s1.getSelectedItem().toString().equals("MPAE")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {
                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {
                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));

                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc4.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc5.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    }
                } else if (s1.getSelectedItem().toString().equals("ECE")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));

                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {

                    }
                } else if (s1.getSelectedItem().toString().equals("BT")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {


                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {
                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {
                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));

                    } else if (s2.getSelectedItem().toString().equals("Sem 7")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 8")) {

                    }

                } else if (s1.getSelectedItem().toString().equals("ICE")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 2")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc11.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 4")) {

                    } else if (s2.getSelectedItem().toString().equals("Sem 5")) {


                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc12.setTextColor(getResources().getColor(R.color.calculator_notselected));
                    } else if (s2.getSelectedItem().toString().equals("Sem 6")) {
                        tc9.setTextColor(getResources().getColor(R.color.calculator_notselected));
                        tc10.setTextColor(getResources().getColor(R.color.calculator_notselected));

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


    public void cc(View rv) {

        c1 = (TextView) rv.findViewById(R.id.tv1);
        c2 = (TextView) rv.findViewById(R.id.tv2);
        c3 = (TextView) rv.findViewById(R.id.tv3);
        c4 = (TextView) rv.findViewById(R.id.tv4);
        c5 = (TextView) rv.findViewById(R.id.tv5);
        c6 = (TextView) rv.findViewById(R.id.tv6);
        c7 = (TextView) rv.findViewById(R.id.tv7);
        c8 = (TextView) rv.findViewById(R.id.tv8);
        c9 = (TextView) rv.findViewById(R.id.tv9);
        c10 = (TextView) rv.findViewById(R.id.tv10);
        c11 = (TextView) rv.findViewById(R.id.tv11);
        c12 = (TextView) rv.findViewById(R.id.tv12);

        c1.setTextColor(getResources().getColor(R.color.calculator_selected));
        c2.setTextColor(getResources().getColor(R.color.calculator_selected));
        c3.setTextColor(getResources().getColor(R.color.calculator_selected));
        c4.setTextColor(getResources().getColor(R.color.calculator_selected));
        c5.setTextColor(getResources().getColor(R.color.calculator_selected));
        c6.setTextColor(getResources().getColor(R.color.calculator_selected));
        c7.setTextColor(getResources().getColor(R.color.calculator_selected));
        c8.setTextColor(getResources().getColor(R.color.calculator_selected));
        c9.setTextColor(getResources().getColor(R.color.calculator_selected));
        c10.setTextColor(getResources().getColor(R.color.calculator_selected));
        c11.setTextColor(getResources().getColor(R.color.calculator_selected));
        c12.setTextColor(getResources().getColor(R.color.calculator_selected));


    }


    public void onCalculate(View a) {

        double n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12;
        EditText t1 = (EditText) a.findViewById(R.id.one);
        EditText t2 = (EditText) a.findViewById(R.id.two);
        EditText t3 = (EditText) a.findViewById(R.id.three);
        EditText t4 = (EditText) a.findViewById(R.id.four);
        EditText t5 = (EditText) a.findViewById(R.id.five);
        EditText t6 = (EditText) a.findViewById(R.id.six);
        EditText t7 = (EditText) a.findViewById(R.id.seven);
        EditText t8 = (EditText) a.findViewById(R.id.eight);
        EditText t9 = (EditText) a.findViewById(R.id.nine);
        EditText t10 = (EditText) a.findViewById(R.id.ten);
        EditText t11 = (EditText) a.findViewById(R.id.eleven);
        EditText t12 = (EditText) a.findViewById(R.id.twelve);


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

        TextView rs = (TextView) a.findViewById(R.id.per);
        rs.setText(String.format("%.2f ", p));

    }


}