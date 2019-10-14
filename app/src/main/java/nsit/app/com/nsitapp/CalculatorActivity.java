package nsit.app.com.nsitapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nsit.app.com.nsitapp.subjects.SubjectLoad;

import static nsit.app.com.nsitapp.R.id.per;

public class CalculatorActivity extends Fragment {

    @BindView(R.id.spinb) Spinner branchSpinner;
    @BindView(R.id.spins) Spinner semSpinner;
    //private TextView PR5textView, VS1textView, VS2textView, PR4textView, TH4textView, TH5textView, TH1textView, TH2textView, TH3textView, PR3textView, PR2textView, PR1textView, resultTextView;
    private double TH1 = -1.0, TH2 = -1.0, TH3 = -1.0, TH4 = -1.0, TH5 = -1.0, PR1 = -1.0, PR2 = -1.0, PR3 = -1.0, PR4 = -1.0, PR5 = -1.0, VS1 = -1.0, VS2 = -1.0;
    //private EditText TH1editText, TH2editText, TH3editText, TH4editText, TH5editText, PR1editText, PR2editText, PR3editText, PR4editText, PR5editText, VS1editText, VS2editText;
    @BindView(R.id.one) EditText TH1editText;
    @BindView(R.id.two) EditText TH2editText;
    @BindView(R.id.three) EditText TH3editText;
    @BindView(R.id.four) EditText TH4editText;
    @BindView(R.id.five) EditText TH5editText;
    @BindView(R.id.six) EditText PR1editText;
    @BindView(R.id.seven) EditText PR2editText;
    @BindView(R.id.eight) EditText PR3editText;
    @BindView(R.id.nine) EditText PR4editText;
    @BindView(R.id.ten) EditText PR5editText;
    @BindView(R.id.eleven) EditText VS1editText;
    @BindView(R.id.twelve) EditText VS2editText;
    @BindView(R.id.tv10) TextView PR5textView;
    @BindView(R.id.tv11) TextView VS1textView;
    @BindView(R.id.tv12) TextView VS2textView;
    @BindView(R.id.tv9) TextView PR4textView;
    @BindView(R.id.tv4) TextView TH4textView;
    @BindView(R.id.tv5) TextView TH5textView;
    @BindView(R.id.tv1) TextView TH1textView;
    @BindView(R.id.tv2) TextView TH2textView;
    @BindView(R.id.tv3) TextView TH3textView;
    @BindView(R.id.tv8) TextView PR3textView;
    @BindView(R.id.tv7) TextView PR2textView;
    @BindView(R.id.tv6) TextView PR1textView;
    @BindView(R.id.per) TextView resultTextView;
    @BindView(R.id.button) Button b;
    @BindView(R.id.buttC) Button c;
    @BindView(R.id.vol) ImageView voice_icon;
    Integer voice_icon_status = 1; /*initialising flag variable with 1*/
    TextToSpeech textToSpeech;   /*using text to speech class */

    @OnClick(R.id.button)
    public void onButtonBClicked(View view){
        Intent i = new Intent(getActivity(), SubjectLoad.class);
        startActivity(i);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        textToSpeech = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.getDefault());
                }
            }
        });
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.activity_calculator, container, false);
        ButterKnife.bind(this, rootView);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.branch, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchSpinner.setAdapter(adapter);
        c.setOnClickListener(v -> onCalculate(rootView));

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
        voice_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (voice_icon_status == 1){
                    voice_icon_status = 0;
                    voice_icon.setImageResource(R.drawable.mute);
                }
                else{
                    voice_icon_status = 1;
                    voice_icon.setImageResource(R.drawable.unmute);
                }
            }
        });
        if (voice_icon_status == 1){
            textToSpeech.speak(String.format("%.2f ", p),TextToSpeech.QUEUE_FLUSH,null);
        }
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
