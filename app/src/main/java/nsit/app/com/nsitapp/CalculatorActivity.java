package nsit.app.com.nsitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import nsit.app.com.nsitapp.subjects.SubjectLoad;

import static nsit.app.com.nsitapp.R.id.per;

public class CalculatorActivity extends Fragment {

    private Spinner branchSpinner, semSpinner;
    private TextView PR5textView, VS1textView, VS2textView, PR4textView, TH4textView, TH5textView, TH1textView, TH2textView, TH3textView, PR3textView, PR2textView, PR1textView, resultTextView;
    private double TH1 = -1.0, TH2 = -1.0, TH3 = -1.0, TH4 = -1.0, TH5 = -1.0, PR1 = -1.0, PR2 = -1.0, PR3 = -1.0, PR4 = -1.0, PR5 = -1.0, VS1 = -1.0, VS2 = -1.0;
    private EditText TH1editText, TH2editText, TH3editText, TH4editText, TH5editText, PR1editText, PR2editText, PR3editText, PR4editText, PR5editText, VS1editText, VS2editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_calculator, container, false);
        branchSpinner = rootView.findViewById(R.id.spinb);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.branch, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchSpinner.setAdapter(adapter);
        TH1editText = rootView.findViewById(R.id.one);
        TH2editText = rootView.findViewById(R.id.two);
        TH3editText = rootView.findViewById(R.id.three);
        TH4editText = rootView.findViewById(R.id.four);
        TH5editText = rootView.findViewById(R.id.five);
        PR1editText = rootView.findViewById(R.id.six);
        PR2editText = rootView.findViewById(R.id.seven);
        PR3editText = rootView.findViewById(R.id.eight);
        PR4editText = rootView.findViewById(R.id.nine);
        PR5editText = rootView.findViewById(R.id.ten);
        VS1editText = rootView.findViewById(R.id.eleven);
        VS2editText = rootView.findViewById(R.id.twelve);
        resultTextView = rootView.findViewById(per);
        Button b = rootView.findViewById(R.id.button);
        b.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), SubjectLoad.class);
            startActivity(i);

        });

        b = rootView.findViewById(R.id.buttC);
        b.setOnClickListener(v -> onCalculate(rootView));


        PR5textView = rootView.findViewById(R.id.tv10);
        VS1textView = rootView.findViewById(R.id.tv11);
        VS2textView = rootView.findViewById(R.id.tv12);
        PR4textView = rootView.findViewById(R.id.tv9);
        TH4textView = rootView.findViewById(R.id.tv4);
        TH5textView = rootView.findViewById(R.id.tv5);
        TH1textView = rootView.findViewById(R.id.tv1);
        TH2textView = rootView.findViewById(R.id.tv2);
        TH3textView = rootView.findViewById(R.id.tv3);
        PR3textView = rootView.findViewById(R.id.tv8);
        PR2textView = rootView.findViewById(R.id.tv7);
        PR1textView = rootView.findViewById(R.id.tv6);
        setColoredTextView(PR1textView, R.color.calculator_selected);
        setColoredTextView(PR2textView, R.color.calculator_selected);
        setColoredTextView(PR3textView, R.color.calculator_selected);
        setColoredTextView(PR4textView, R.color.calculator_selected);
        setColoredTextView(PR5textView, R.color.calculator_selected);
        setColoredTextView(TH1textView, R.color.calculator_selected);
        setColoredTextView(TH2textView, R.color.calculator_selected);
        setColoredTextView(TH3textView, R.color.calculator_selected);
        setColoredTextView(TH4textView, R.color.calculator_selected);
        setColoredTextView(TH5textView, R.color.calculator_selected);
        setColoredTextView(VS1textView, R.color.calculator_selected);
        setColoredTextView(VS2textView, R.color.calculator_selected);
        semSpinner = rootView.findViewById(R.id.spins);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.semester, android.R.layout.simple_list_item_1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        semSpinner.setAdapter(adapter1);
        semSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                //cc(rootView);
                switch (branchSpinner.getSelectedItem().toString()) {
                    case "COE":
                        switch (semSpinner.getSelectedItem().toString()) {
                            case "Sem 1":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 2":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 3":
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 4":

                                break;
                            case "Sem 5":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 6":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                break;
                            case "Sem 7":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 8":
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                setColoredTextView(TH5textView, R.color.calculator_notselected);
                                setColoredTextView(TH4textView, R.color.calculator_notselected);
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                        }
                        break;
                    case "IT":

                        switch (semSpinner.getSelectedItem().toString()) {
                            case "Sem 1":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 2":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 3":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 4":
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 5":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 6":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 7":

                                break;
                            case "Sem 8":
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                setColoredTextView(TH5textView, R.color.calculator_notselected);
                                setColoredTextView(TH4textView, R.color.calculator_notselected);
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                        }
                        break;
                    case "MPAE":

                        switch (semSpinner.getSelectedItem().toString()) {
                            case "Sem 1":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 2":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 3":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 4":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                break;
                            case "Sem 5":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 6":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                break;
                            case "Sem 7":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 8":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(TH4textView, R.color.calculator_notselected);
                                setColoredTextView(TH5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                        }
                        break;
                    case "ECE":

                        switch (semSpinner.getSelectedItem().toString()) {
                            case "Sem 1":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 2":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 3":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 4":

                                break;
                            case "Sem 5":
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 6":

                                break;
                            case "Sem 7":

                                break;
                            case "Sem 8":

                                break;
                        }
                        break;
                    case "BT":

                        switch (semSpinner.getSelectedItem().toString()) {
                            case "Sem 1":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 2":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 3":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 4":
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                break;
                            case "Sem 5":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 6":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 7":

                                break;
                            case "Sem 8":

                                break;
                        }

                        break;
                    case "ICE":

                        switch (semSpinner.getSelectedItem().toString()) {
                            case "Sem 1":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 2":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS1textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 3":
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 4":

                                break;
                            case "Sem 5":
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                setColoredTextView(VS2textView, R.color.calculator_notselected);
                                break;
                            case "Sem 6":
                                setColoredTextView(PR4textView, R.color.calculator_notselected);
                                setColoredTextView(PR5textView, R.color.calculator_notselected);
                                break;
                            case "Sem 7":

                                break;
                            case "Sem 8":

                                break;
                        }


                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rootView;
    }


    /*private void cc(View rv) {

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


    }*/


    private void onCalculate(View a) {


        double tux, pux, p = 0.0;
        int f = 1;


        switch (branchSpinner.getSelectedItem().toString()) {
            case "COE":
                switch (semSpinner.getSelectedItem().toString()) {
                    case "Sem 1":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());


                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = (3 * PR1) + 2 * (PR2 + PR3 + PR4);
                            p = (tux + pux) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 2":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());


                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux) / 28;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 3":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            PR5 = Double.parseDouble(PR5editText.getText().toString());


                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3) + (3 * PR4);
                            p = (tux + pux + PR5) / 30;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 4":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            PR5 = Double.parseDouble(PR5editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());
                            VS2 = Double.parseDouble(VS2editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4 + PR5);
                            p = (tux + pux + VS1 + VS2) / 32;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 5":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());


                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3);
                            p = (tux + pux + VS1) / 27;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 6":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());
                            VS2 = Double.parseDouble(VS2editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + VS2);
                            p = (tux + pux + VS1) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 7":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            VS1 = Double.parseDouble(VS1editText.getText().toString());


                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3) + 3 * PR4;
                            p = (tux + pux + VS1) / 30;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 8":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());

                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());

                            VS1 = Double.parseDouble(VS1editText.getText().toString());


                            tux = 4 * (TH1 + TH2 + TH3);
                            pux = (2 * PR1) + (8 * PR2) + (4 * PR3);
                            p = (tux + pux + VS1) / 27;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                }

                break;
            case "IT":
                switch (semSpinner.getSelectedItem().toString()) {
                    case "Sem 1":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = (3 * PR1) + 2 * (PR2 + PR3 + PR4);
                            p = (tux + pux) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 2":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux) / 28;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 3":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3);
                            p = (tux + pux + VS1) / 27;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 4":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            PR5 = Double.parseDouble(PR5editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4 + PR5);
                            p = (tux + pux) / 30;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 5":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());


                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3);
                            p = (tux + pux + VS1) / 27;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 6":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux + VS1) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 7":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());
                            VS2 = Double.parseDouble(VS2editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4 + VS2) + (4 * VS1);
                            p = (tux + pux) / 34;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 8":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3);
                            pux = (2 * PR1) + (8 * PR2) + (4 * PR3) + (2 * VS1);
                            p = (tux + pux) / 28;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                }

                break;
            case "MPAE":

                switch (semSpinner.getSelectedItem().toString()) {
                    case "Sem 1":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = (3 * PR1) + 2 * (PR2 + PR3 + PR4);
                            p = (tux + pux) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 2":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux + VS1) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 3":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux + VS1) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 4":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());
                            VS2 = Double.parseDouble(VS2editText.getText().toString());


                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux + VS1 + VS2) / 30;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 5":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux + VS1) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 6":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());
                            VS2 = Double.parseDouble(VS2editText.getText().toString());


                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux + VS1 + VS2) / 30;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 7":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux + VS1) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 8":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3);
                            pux = 2 * (PR1 + PR2) + (8 * PR3) + (2 * PR4);
                            p = (tux + pux + VS1) / 27;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                }

                break;
            case "ECE":
// 6, 7, 8 Credits not found false data taken


                switch (semSpinner.getSelectedItem().toString()) {
                    case "Sem 1":
                        try {

                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = (3 * PR1) + 2 * (PR2 + PR3 + PR4);
                            p = (tux + pux) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 2":
                        try {

                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5 + PR3);
                            pux = 2 * (PR1 + PR2 + PR4);
                            p = (tux + pux) / 30;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 3":
                        try {

                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3) + 3 * PR4;
                            p = (tux + pux + VS1) / 30;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 4":


                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            PR5 = Double.parseDouble(PR5editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());
                            VS2 = Double.parseDouble(VS2editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4 + PR5);
                            p = (tux + pux + VS1 + VS2) / 32;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 5":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3);
                            p = (tux + pux + VS1) / 27;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 6":
                        Toast.makeText(getActivity(), "Sem 6 ECE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();
                        f = 0;
                    /* EditText TH1editText = (EditText)a.a.findViewById(R.id.one);

                     tux = 4*(TH1+TH2+TH3+TH4+TH5);
                     pux = 2*(PR1+PR2+PR3+PR4);
                     p   = (tux+pux+VS1+VS2)/30;

                     resultTextView.setText(String.format("%.2f ",p));*/

                        break;
                    case "Sem 7":
                        Toast.makeText(getActivity(), "Sem 7 ECE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();
                    /* EditText TH1editText = (EditText)findViewById(R.id.one);
                     resultTextView.setText(String.format("%.2f ",p));*/
                        f = 0;

                        break;
                    case "Sem 8":
                        Toast.makeText(getActivity(), "Sem 8 ECE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();
                        f = 0;
                    /* EditText TH1editText = (EditText)findViewById(R.id.one);
                     resultTextView.setText(String.format("%.2f ",p));*/

                        break;
                }

                break;
            case "ICE":
// 7, 8 credits not found false data taken


                switch (semSpinner.getSelectedItem().toString()) {
                    case "Sem 1":
                        try {

                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = (3 * PR1) + 2 * (PR2 + PR3 + PR4);
                            p = (tux + pux) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }
                        break;
                    case "Sem 2":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux) / 28;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 3":
                        try {

                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3) + 3 * PR4;
                            p = (tux + pux + VS1) / 30;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 4":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            PR5 = Double.parseDouble(PR5editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());
                            VS2 = Double.parseDouble(VS2editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4 + PR5);
                            p = (tux + pux + VS1 + VS2) / 32;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 5":
                        try {

                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3);
                            p = (tux + pux + VS1) / 27;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 6":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());
                            VS2 = Double.parseDouble(VS2editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + VS2);
                            p = (tux + pux + VS1) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 7":
                        Toast.makeText(getActivity(), "Sem 7 ICE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();
                        f = 0;
                        break;
                    case "Sem 8":
                        Toast.makeText(getActivity(), "Sem 8 ICE credits not found. Can't calculate result", Toast.LENGTH_LONG).show();
                        f = 0;
                        break;
                }

                break;
            case "BT":
// 7,8 Credits not found false data taken


                switch (semSpinner.getSelectedItem().toString()) {
                    case "Sem 1":
                        try {

                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = (3 * PR1) + 2 * (PR2 + PR3 + PR4);
                            p = (tux + pux) / 29;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 2":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux) / 28;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 3":

                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());
                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + PR4);
                            p = (tux + pux) / 28;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 4":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + VS1);
                            p = (tux + pux) / 28;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 5":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            VS1 = Double.parseDouble(VS1editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3 + VS1);
                            p = (tux + pux) / 30;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }

                        break;
                    case "Sem 6":
                        try {
                            TH1 = Double.parseDouble(TH1editText.getText().toString());
                            TH2 = Double.parseDouble(TH2editText.getText().toString());
                            TH3 = Double.parseDouble(TH3editText.getText().toString());
                            TH4 = Double.parseDouble(TH4editText.getText().toString());
                            TH5 = Double.parseDouble(TH5editText.getText().toString());
                            PR1 = Double.parseDouble(PR1editText.getText().toString());
                            PR2 = Double.parseDouble(PR2editText.getText().toString());
                            PR3 = Double.parseDouble(PR3editText.getText().toString());
                            PR4 = Double.parseDouble(PR4editText.getText().toString());

                            tux = 4 * (TH1 + TH2 + TH3 + TH4 + TH5);
                            pux = 2 * (PR1 + PR2 + PR3);
                            p = (tux + pux + PR4) / 28;
                        } catch (NumberFormatException e) {
                            Toast.makeText(getActivity(), "Fill out all the highlighted fields.", Toast.LENGTH_LONG).show();
                            f = 0;
                        }


                        break;
                    case "Sem 7":
                        Toast.makeText(getActivity(), "Sem 7 BT credits not found. Can't calculate result", Toast.LENGTH_LONG).show();
                        f = 0;
                        break;
                    case "Sem 8":
                        Toast.makeText(getActivity(), "Sem 8 BT credits not found. Can't calculate result", Toast.LENGTH_LONG).show();
                        f = 0;
                        break;
                }

                break;
        }

        resultTextView.setText(String.format("%.2f ", p));
        if (f == 1)
            addToStorage();

    }

    private void setColoredTextView(TextView textView, int color) {
        textView.setTextColor(ContextCompat.getColor(getContext(), color));
    }

    public void addToStorage() {
        File root = android.os.Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath() + "/NSITConnect");
        dir.mkdirs();
        File file = new File(dir, branchSpinner.getSelectedItem().toString() + "_" + semSpinner.getSelectedItem().toString() + ".txt");
        PrintWriter pw = null;
        FileOutputStream f = null;
        try {
            f = new FileOutputStream(file);
            pw = new PrintWriter(f);
            pw.println(TH1textView.getText() + "=" + TH1);
            pw.println(TH2textView.getText() + "=" + TH2);
            pw.println(TH3textView.getText() + "=" + TH3);
            pw.println(TH4textView.getText() + "=" + TH4);
            pw.println(TH5textView.getText() + "=" + TH5);
            pw.println(PR1textView.getText() + "=" + PR1);
            pw.println(PR2textView.getText() + "=" + PR2);
            pw.println(PR3textView.getText() + "=" + PR3);
            pw.println(PR4textView.getText() + "=" + PR4);
            pw.println(PR5textView.getText() + "=" + PR5);
            pw.println(VS1textView.getText() + "=" + VS1);
            pw.println(VS2textView.getText() + "=" + VS2);
            pw.flush();
            file.setReadOnly();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                pw.close();
            if (f != null)
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    public void readFileFromStorage() {
        File root = android.os.Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath() + "/NSITConnect");
        File file = new File(dir, branchSpinner.getSelectedItem().toString() + "_" + semSpinner.getSelectedItem().toString() + ".txt");
        if (!file.exists()) {
            Toast.makeText(getContext(), "Marks for " + branchSpinner.getSelectedItem().toString() + " " + semSpinner.getSelectedItem().toString() + " not available", Toast.LENGTH_SHORT).show();
            return;
        }
        BufferedReader reader = null;
        String s;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((s = reader.readLine()) != null) {
                String[] splits = s.split("=");
                if (splits[0].equals("TH 1") && !splits[1].equals("-1.0"))
                    TH1editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("TH 2") && !splits[1].equals("-1.0"))
                    TH2editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("TH 3") && !splits[1].equals("-1.0"))
                    TH3editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("TH 4") && !splits[1].equals("-1.0"))
                    TH4editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("TH 5") && !splits[1].equals("-1.0"))
                    TH5editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("PR 1") && !splits[1].equals("-1.0"))
                    PR1editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("PR 2") && !splits[1].equals("-1.0"))
                    PR2editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("PR 3") && !splits[1].equals("-1.0"))
                    PR3editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("PR 4") && !splits[1].equals("-1.0"))
                    PR4editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("PR 5") && !splits[1].equals("-1.0"))
                    PR5editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("VS 1") && !splits[1].equals("-1.0"))
                    VS1editText.setText("" + (int) (Double.parseDouble(splits[1])));
                if (splits[0].equals("VS 2") && !splits[1].equals("-1.0"))
                    VS2editText.setText("" + (int) (Double.parseDouble(splits[1])));
                //Toast.makeText(getContext(),splits[0]+splits[1],Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_calculator, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.clear:
                TH1editText.setText("");
                TH2editText.setText("");
                TH3editText.setText("");
                TH4editText.setText("");
                TH5editText.setText("");
                PR1editText.setText("");
                PR2editText.setText("");
                PR3editText.setText("");
                PR4editText.setText("");
                PR5editText.setText("");
                VS1editText.setText("");
                VS2editText.setText("");
                resultTextView.setText("");
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