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

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalculatorActivity extends Fragment {

    @BindView(R.id.spinb)   Spinner     s1;
    @BindView(R.id.spins)   Spinner     s2;
    @BindView(R.id.tv10)    TextView    tc10;
    @BindView(R.id.tv11)    TextView    tc11;
    @BindView(R.id.tv12)    TextView    tc12;
    @BindView(R.id.tv9)     TextView    tc9;
    @BindView(R.id.tv4)     TextView    tc4;
    @BindView(R.id.tv5)     TextView    tc5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rooview = inflater.inflate(R.layout.activity_calculator, container, false);
        
        ButterKnife.bind(this,rooview);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.branch, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
        
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

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.semester, android.R.layout.simple_list_item_1);
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

    @BindView(R.id.tv1)TextView c1;
    @BindView(R.id.tv2)TextView c2;
    @BindView(R.id.tv3)TextView c3;
    //@BindView(R.id.tv4)TextView tc4;
    //@BindView(R.id.tv5)TextView tc5;
    @BindView(R.id.tv6)TextView c6;
    @BindView(R.id.tv7)TextView c7;
    @BindView(R.id.tv8)TextView c8;
    //@BindView(R.id.tv9)TextView tc9;
    //@BindView(R.id.tv10)TextView tc10;
    //@BindView(R.id.tv11)TextView tc11;
    //@BindView(R.id.tv12)TextView tc12;

    private void cc(View rv) {
        ButterKnife.bind(this,rv);
        c1.setTextColor(getResources().getColor(R.color.calculator_selected));
        c2.setTextColor(getResources().getColor(R.color.calculator_selected));
        c3.setTextColor(getResources().getColor(R.color.calculator_selected));
        tc4.setTextColor(getResources().getColor(R.color.calculator_selected));
        tc5.setTextColor(getResources().getColor(R.color.calculator_selected));
        c6.setTextColor(getResources().getColor(R.color.calculator_selected));
        c7.setTextColor(getResources().getColor(R.color.calculator_selected));
        c8.setTextColor(getResources().getColor(R.color.calculator_selected));
        tc9.setTextColor(getResources().getColor(R.color.calculator_selected));
        tc10.setTextColor(getResources().getColor(R.color.calculator_selected));
        tc11.setTextColor(getResources().getColor(R.color.calculator_selected));
        tc12.setTextColor(getResources().getColor(R.color.calculator_selected));
    }

    @BindView(R.id.one)EditText t1;
    @BindView(R.id.two)EditText t2;
    @BindView(R.id.three)EditText t3;
    @BindView(R.id.four)EditText t4;
    @BindView(R.id.five)EditText t5;
    @BindView(R.id.six)EditText t6;
    @BindView(R.id.seven)EditText t7;
    @BindView(R.id.eight)EditText t8;
    @BindView(R.id.nine)EditText t9;
    @BindView(R.id.ten)EditText t10;
    @BindView(R.id.eleven)EditText t11;
    @BindView(R.id.twelve)EditText t12;

    private void onCalculate(View a) {

        double n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12;
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
