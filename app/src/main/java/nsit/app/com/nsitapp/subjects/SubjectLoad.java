package nsit.app.com.nsitapp.subjects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import nsit.app.com.nsitapp.R;

public class SubjectLoad extends AppCompatActivity {

    @BindView(R.id.spinB)
    public Spinner spinnerBranch;
    @BindView(R.id.spinS)
    public Spinner spinnerSemester;

    @BindView(R.id.co1) TextView t1;
    @BindView(R.id.co2) TextView t2;
    @BindView(R.id.co3) TextView t3;
    @BindView(R.id.co4) TextView t4;
    @BindView(R.id.co5) TextView t5;
    @BindView(R.id.co6) TextView t6;
    @BindView(R.id.co7) TextView t7;
    @BindView(R.id.co8) TextView t8;
    @BindView(R.id.co9) TextView t9;
    @BindView(R.id.co10) TextView t10;
    @BindView(R.id.co11) TextView t11;
    @BindView(R.id.co12) TextView t12;

    @BindView(R.id.su1) TextView n1;
    @BindView(R.id.su2) TextView n2;
    @BindView(R.id.su3) TextView n3;
    @BindView(R.id.su4) TextView n4;
    @BindView(R.id.su5) TextView n5;
    @BindView(R.id.su6) TextView n6;
    @BindView(R.id.su7) TextView n7;
    @BindView(R.id.su8) TextView n8;
    @BindView(R.id.su9) TextView n9;
    @BindView(R.id.su10) TextView n10;
    @BindView(R.id.su11) TextView n11;
    @BindView(R.id.su12) TextView n12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_load);

        ButterKnife.bind(this);

        ArrayList<TextView> codeTextViews = new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
        ArrayList<TextView> subjectTextViews = new ArrayList<>(Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12));

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.branch, android.R.layout.simple_list_item_1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBranch.setAdapter(adapter2);
        spinnerBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.semester, android.R.layout.simple_list_item_1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSemester.setAdapter(adapter3);
        spinnerSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (spinnerBranch.getSelectedItem().toString()) {
                    case "Branch":
                        if (spinnerSemester.getSelectedItem().toString().equals("Semester")) {
                            setDash(codeTextViews);
                            setDash(subjectTextViews);
                        }
                        break;
                    case "COE":
                        switch (spinnerSemester.getSelectedItem().toString()) {
                            case "Sem 1":
                                t1.setText("COE 101");
                                t2.setText("COE 102");
                                t3.setText("COE 103");
                                t4.setText("COE 104");
                                t5.setText("COE 105");
                                t6.setText("COE 106");
                                t7.setText("COE 107");
                                t8.setText("COE 108");
                                t9.setText("COE 109");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Humanities");
                                n2.setText("Mathematics I");
                                n3.setText("Physics I");
                                n4.setText("Chemistry");
                                n5.setText("M.Processes");
                                n6.setText("E.D");
                                n7.setText("Physics I");
                                n8.setText("Chemistry");
                                n9.setText("Workshop");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 2":
                                t1.setText("COE 111");
                                t2.setText("COE 112");
                                t3.setText("COE 113");
                                t4.setText("COE 114");
                                t5.setText("COE 115");
                                t6.setText("COE 116");
                                t7.setText("COE 117");
                                t8.setText("COE 118");
                                t9.setText("COE 119");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Principles of E.E");
                                n2.setText("App. Mech.");
                                n3.setText("Mathematics II");
                                n4.setText("Intro. to Programing");
                                n5.setText("Physics of Materials");
                                n6.setText("Principles of E.E");
                                n7.setText("App. Mech. ");
                                n8.setText("Intro. to Programing");
                                n9.setText("Physics of Materials");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 3":
                                t1.setText("COE 201");
                                t2.setText("COE 202");
                                t3.setText("COE 203");
                                t4.setText("COE 204");
                                t5.setText("COE 205");
                                t6.setText("COE 206");
                                t7.setText("COE 207");
                                t8.setText("COE 208");
                                t9.setText("COE 209");
                                t10.setText("--");
                                t11.setText("COE 210");
                                t12.setText("--");

                                n1.setText("Electronics I");
                                n2.setText("Circuits & Systems");
                                n3.setText("Power Apparatus");
                                n4.setText("E. Measurements");
                                n5.setText("Mathematics III");
                                n6.setText("Electronics I");
                                n7.setText("Power Apparatus");
                                n8.setText("Electrical Measurements");
                                n9.setText("Machine Drawing");
                                n10.setText("--");
                                n11.setText("Programming I");
                                n12.setText("--");
                                break;

                            case "Sem 4":
                                t1.setText("COE 211");
                                t2.setText("COE 212");
                                t3.setText("COE 213");
                                t4.setText("COE 214");
                                t5.setText("COE 215");
                                t6.setText("COE 216");
                                t7.setText("COE 217");
                                t8.setText("COE 218");
                                t9.setText("COE 219");
                                t10.setText("COE 220");
                                t11.setText("COE 221");
                                t12.setText("COE 222");

                                n1.setText("Electronics II");
                                n2.setText("Electromagnetics I");
                                n3.setText("Data Structures");
                                n4.setText("Digital Cir. & Systems I");
                                n5.setText("Principles of Comm. Engg.");
                                n6.setText("Electronics II");
                                n7.setText("Digital Cir. & Systems I");
                                n8.setText("Principles of Comm. Engg.");
                                n9.setText("Electrical Workshop & Drg.");
                                n10.setText("Practical Training");
                                n11.setText("Report Writing");
                                n12.setText("Programming II");
                                break;

                            case "Sem 5":
                                t1.setText("COE 301");
                                t2.setText("COE 302");
                                t3.setText("COE 303");
                                t4.setText("COE 304");
                                t5.setText("COE 305");
                                t6.setText("COE 306");
                                t7.setText("COE 307");
                                t8.setText("COE 308");
                                t9.setText("--");
                                t10.setText("--");
                                t11.setText("COE 309");
                                t12.setText("--");

                                n1.setText("Princ. of Comp. Graphics");
                                n2.setText("Discrete Maths & Design of Alg.");
                                n3.setText("Computer System Org.");
                                n4.setText("Linear Integrated Circ.");
                                n5.setText("Indus. Org.& Mana. Eco.");
                                n6.setText("Computer System Org.");
                                n7.setText("Linear Integrated Circuits");
                                n8.setText("Princ. of Comp. Graphics.");
                                n9.setText("--");
                                n10.setText("--");
                                n11.setText("Programming III");
                                n12.setText("--");
                                break;

                            case "Sem 6":
                                t1.setText("COE 311");
                                t2.setText("COE 312");
                                t3.setText("COE 313");
                                t4.setText("COE 314");
                                t5.setText("COE 315");
                                t6.setText("COE 316");
                                t7.setText("COE 317");
                                t8.setText("COE 318");
                                t9.setText("--");
                                t10.setText("--");
                                t11.setText("COE 319");
                                t12.setText("COE 320");

                                n1.setText("Microprocessors");
                                n2.setText("DBMS");
                                n3.setText("OS");
                                n4.setText("Control Engineering");
                                n5.setText("ACA");
                                n6.setText("Microprocessors");
                                n7.setText("DBMS");
                                n8.setText("Control Engineering");
                                n9.setText("--");
                                n10.setText("--");
                                n11.setText("Programming IV");
                                n12.setText("Practical Training");
                                break;

                            case "Sem 7":
                                t1.setText("COE 401");
                                t2.setText("COE 402");
                                t3.setText("COE 403");
                                t4.setText("COE 404");
                                t5.setText("COE 405");
                                t6.setText("COE 406");
                                t7.setText("COE 407");
                                t8.setText("COE 408");
                                t9.setText("COE 409");
                                t10.setText("--");
                                t11.setText("COE 410");
                                t12.setText("--");

                                n1.setText("Compiler & Trans. Desg.");
                                n2.setText("Digital Circ.& Systems II");
                                n3.setText("Micropr. App.");
                                n4.setText("Elective I");
                                n5.setText("Elective II");
                                n6.setText("Compiler and Trans. Desg.");
                                n7.setText("Digital Cir. and Systems II");
                                n8.setText("Electives I and II");
                                n9.setText("Practical Training");
                                n10.setText("--");
                                n11.setText("System Program. Lang.");
                                n12.setText("--");
                                break;

                            case "Sem 8":
                                t1.setText("COE 411");
                                t2.setText("COE 412");
                                t3.setText("COE 413");
                                t4.setText("--");
                                t5.setText("--");
                                t6.setText("COE 414");
                                t7.setText("COE 415");
                                t8.setText("COE 416");
                                t9.setText("--");
                                t10.setText("--");
                                t11.setText("COE 417");
                                t12.setText("--");

                                n1.setText("Comp. Comm. & Elect. Swng.");
                                n2.setText("Elective III");
                                n3.setText("Elective IV");
                                n4.setText("--");
                                n5.setText("--");
                                n6.setText("Elective III and IV");
                                n7.setText("Project");
                                n8.setText("Practical Training");
                                n9.setText("--");
                                n10.setText("--");
                                n11.setText("Seminar/Reports");
                                n12.setText("--");
                                break;
                        }
                        break;

                    case "IT":
                        switch (spinnerSemester.getSelectedItem().toString()) {
                            case "Sem 1":
                                t1.setText("IT 101");
                                t2.setText("IT 102");
                                t3.setText("IT 103");
                                t4.setText("IT 104");
                                t5.setText("IT 105");
                                t6.setText("IT 106");
                                t7.setText("IT 107");
                                t8.setText("IT 108");
                                t9.setText("IT 109");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Humanities");
                                n2.setText("Mathematics I");
                                n3.setText("Physics I");
                                n4.setText("Chemistry");
                                n5.setText("M.Processes");
                                n6.setText("E.D");
                                n7.setText("Physics I");
                                n8.setText("Chemistry");
                                n9.setText("Workshop I");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 2":
                                t1.setText("IT 111");
                                t2.setText("IT 112");
                                t3.setText("IT 113");
                                t4.setText("IT 114");
                                t5.setText("IT 115");
                                t6.setText("IT 116");
                                t7.setText("IT 117");
                                t8.setText("IT 118");
                                t9.setText("IT 119");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Principles of E.E");
                                n2.setText("Mechanical Sciences");
                                n3.setText("Enng. Mathematics I");
                                n4.setText("Intro. to Programing");
                                n5.setText("Discrete Structures");
                                n6.setText("Princ. of Elect. Sci. Lab");
                                n7.setText("Mech. Sci. Lab ");
                                n8.setText("Intro. to Programing Lab");
                                n9.setText("Linux/UNIX Lab");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 3":
                                t1.setText("IT 201");
                                t2.setText("IT 202");
                                t3.setText("IT 203");
                                t4.setText("IT 204");
                                t5.setText("IT 205");
                                t6.setText("IT 206");
                                t7.setText("--");
                                t8.setText("IT 208");
                                t9.setText("IT 209");
                                t10.setText("--");
                                t11.setText("IT 210");
                                t12.setText("--");

                                n1.setText("Data Structures");
                                n2.setText("Digital Cir. & Systems");
                                n3.setText("Analog Elect.");
                                n4.setText("Enng. Maths - II");
                                n5.setText("Organizational Manag.");
                                n6.setText("Data Struc. Lab");
                                n7.setText("--");
                                n8.setText("Digt. Circ. & Syst. Lab");
                                n9.setText("Analog Electronics");
                                n10.setText("--");
                                n11.setText("Programming I");
                                n12.setText("--");
                                break;

                            case "Sem 4":
                                t1.setText("IT 211");
                                t2.setText("IT 212");
                                t3.setText("IT 213");
                                t4.setText("IT 214");
                                t5.setText("IT 215");
                                t6.setText("IT 216");
                                t7.setText("IT 217");
                                t8.setText("IT 218");
                                t9.setText("IT 219");
                                t10.setText("IT 220");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Sys. Ana. & Desg.");
                                n2.setText("Analog and Digital Comm.");
                                n3.setText("OS");
                                n4.setText("Computer Graphics");
                                n5.setText("Computer System Arch.");
                                n6.setText("Sys. Analysis and Desg. Lab");
                                n7.setText("Analog and Digital Comm. Lab");
                                n8.setText("OS Lab");
                                n9.setText("Computer Graphics Lab");
                                n10.setText("Comp. Sys. Arch. Lab");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 5":
                                t1.setText("IT 301");
                                t2.setText("IT 302");
                                t3.setText("IT 303");
                                t4.setText("IT 304");
                                t5.setText("IT 305");
                                t6.setText("--");
                                t7.setText("IT 306");
                                t8.setText("IT 307");
                                t9.setText("IT 308");
                                t10.setText("--");
                                t11.setText("IT 309");
                                t12.setText("--");

                                n1.setText("Design and Analysis of Algo.");
                                n2.setText("Object Oriented Technology");
                                n3.setText("Microprocessors and App.");
                                n4.setText("Relational Database Management Systems");
                                n5.setText("Computer Networks");
                                n6.setText("--");
                                n7.setText("Microprocessor Lab");
                                n8.setText("RDBMS Lab");
                                n9.setText("Networking Lab");
                                n10.setText("--");
                                n11.setText("Tech. & Business Comm.");
                                n12.setText("--");
                                break;

                            case "Sem 6":
                                t1.setText("IT 311");
                                t2.setText("IT 312");
                                t3.setText("IT 313");
                                t4.setText("IT 314");
                                t5.setText("IT 315");
                                t6.setText("IT 316");
                                t7.setText("IT 317");
                                t8.setText("IT 318");
                                t9.setText("IT 319");
                                t10.setText("--");
                                t11.setText("IT 320");
                                t12.setText("--");

                                n1.setText("Multimedia and Applications");
                                n2.setText("Software Engineerin");
                                n3.setText("IT and Coding Techniques");
                                n4.setText("Elective - I");
                                n5.setText("Microwave and Satellite Comm.");
                                n6.setText("Multimedia La");
                                n7.setText("Software Engineering Lab");
                                n8.setText("Practical Training");
                                n9.setText("Microwave and Satellite Comm. Lab");
                                n10.setText("--");
                                n11.setText("Advanced Programming Lab");
                                n12.setText("--");
                                break;

                            case "Sem 7":
                                t1.setText("IT 401");
                                t2.setText("IT 402");
                                t3.setText("IT 403");
                                t4.setText("IT 404");
                                t5.setText("IT 405");
                                t6.setText("IT 406");
                                t7.setText("IT 407");
                                t8.setText("IT 408");
                                t9.setText("IT 409");
                                t10.setText("--");
                                t11.setText("IT 410");
                                t12.setText("IT 411");

                                n1.setText("Internet and Web Engineering");
                                n2.setText("Distributed Systems and Computing");
                                n3.setText("Compiler and Translator Design");
                                n4.setText("Elective - II");
                                n5.setText("Advances in Digital System Design");
                                n6.setText("nternet and Web Engineering Lab");
                                n7.setText("Distributed Systems and Computing Lab");
                                n8.setText("Elective II Lab");
                                n9.setText("Compiler and Translator Design Lab");
                                n10.setText("--");
                                n11.setText("Practical Training");
                                n12.setText("Minor Project");
                                break;

                            case "Sem 8":
                                t1.setText("IT 412");
                                t2.setText("IT 413");
                                t3.setText("IT 414");
                                t4.setText("--");
                                t5.setText("--");
                                t6.setText("IT 415");
                                t7.setText("IT 416");
                                t8.setText("IT 417");
                                t9.setText("--");
                                t10.setText("--");
                                t11.setText("IT 418");
                                t12.setText("--");

                                n1.setText("Comp. Comm. & Elect. Swng.");
                                n2.setText("Elective III");
                                n3.setText("Elective IV");
                                n4.setText("--");
                                n5.setText("--");
                                n6.setText("Elective III and IV");
                                n7.setText("Project");
                                n8.setText("Practical Training");
                                n9.setText("--");
                                n10.setText("--");
                                n11.setText("Seminar/Reports");
                                n12.setText("--");
                                break;
                        }
                        break;

                    case "ICE":
                        switch (spinnerSemester.getSelectedItem().toString()) {
                            case "Sem 1":
                                t1.setText("IC 101");
                                t2.setText("IC 102");
                                t3.setText("IC 103");
                                t4.setText("IC 104");
                                t5.setText("IC 105");
                                t6.setText("IC 106");
                                t7.setText("IC 107");
                                t8.setText("IC 108");
                                t9.setText("IC 109");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Humanities");
                                n2.setText("Mathematics I");
                                n3.setText("Physics I");
                                n4.setText("Chemistry");
                                n5.setText("M.Processes");
                                n6.setText("E.D");
                                n7.setText("Physics I");
                                n8.setText("Chemistry");
                                n9.setText("Workshop I");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 2":
                                t1.setText("IC 111");
                                t2.setText("IC 112");
                                t3.setText("IC 113");
                                t4.setText("IC 114");
                                t5.setText("IC 115");
                                t6.setText("IC 116");
                                t7.setText("IC 117");
                                t8.setText("IC 118");
                                t9.setText("IC 119");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Princ.of Elect. Engg");
                                n2.setText("Applied Mechanics");
                                n3.setText("Mathematics II");
                                n4.setText("Intro. to Programming");
                                n5.setText("Physics of Materials");
                                n6.setText("Principles of Electrical Engg");
                                n7.setText("Applied Mechanics");
                                n8.setText("Introduction to Programming");
                                n9.setText("Mecanics of Solids Lab");
                                n10.setText("Physics of Materials");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 3":
                                t1.setText("IC 201");
                                t2.setText("IC 202");
                                t3.setText("IC 203");
                                t4.setText("IC 204");
                                t5.setText("IC 205");
                                t6.setText("IC 206");
                                t7.setText("IC 207");
                                t8.setText("IC 208");
                                t9.setText("IC 209");
                                t10.setText("--");
                                t11.setText("IC 210");
                                t12.setText("--");

                                n1.setText("Electronics I");
                                n2.setText("Circuits and Systems");
                                n3.setText("Power Apparatus");
                                n4.setText("Electrical Measurements");
                                n5.setText("Mathematics III");
                                n6.setText("Electronics I");
                                n7.setText("Power Apparatus");
                                n8.setText("Electrical Measurements");
                                n9.setText("Machine Drawing");
                                n10.setText("--");
                                n11.setText("Programming I Lab");
                                n12.setText("--");
                                break;

                            case "Sem 4":
                                t1.setText("IC 211");
                                t2.setText("IC 212");
                                t3.setText("IC 213");
                                t4.setText("IC 214");
                                t5.setText("IC 215");
                                t6.setText("IC 216");
                                t7.setText("IC 217");
                                t8.setText("IC 218");
                                t9.setText("IC 219");
                                t10.setText("IC 220");
                                t11.setText("IC 221");
                                t12.setText("IC 222");

                                n1.setText("Electronics II");
                                n2.setText("Fluid Mech. and Thermo.");
                                n3.setText("Electronic Instru. & Measuring Tech.");
                                n4.setText("Computer Graphics");
                                n5.setText("Transducers & Components");
                                n6.setText("Electronics II");
                                n7.setText("Computer Graphics");
                                n8.setText("Instrumentation LabI");
                                n9.setText("Electrical Workshop & Drg.");
                                n10.setText("Practical Training");
                                n11.setText("Report Writing");
                                n12.setText("Programming II");
                                break;

                            case "Sem 5":
                                t1.setText("IC 301");
                                t2.setText("IC 302");
                                t3.setText("IC 303");
                                t4.setText("IC 304");
                                t5.setText("IC 305");
                                t6.setText("IC 306");
                                t7.setText("IC 307");
                                t8.setText("IC 308");
                                t9.setText("--");
                                t10.setText("--");
                                t11.setText("IC 310");
                                t12.setText("--");

                                n1.setText("Analog and Digital Communication");
                                n2.setText("Industrial and Analytical Instruments");
                                n3.setText("Digital Integrated Circuits I");
                                n4.setText("Linear Integrated Circuits I");
                                n5.setText("Industrial Org. and Mana. Eco");
                                n6.setText("Analog and Digital Communication");
                                n7.setText("Digital Integrated Circuits I");
                                n8.setText("MA 304 based Lab");
                                n9.setText("Linear Integrated Circuits");
                                n10.setText("--");
                                n11.setText("Programming III");
                                n12.setText("--");
                                break;

                            case "Sem 6":
                                t1.setText("IC 311");
                                t2.setText("IC 312");
                                t3.setText("IC 313");
                                t4.setText("IC 314");
                                t5.setText("IC 315");
                                t6.setText("IC 316");
                                t7.setText("IC 317");
                                t8.setText("IC 318");
                                t9.setText("--");
                                t10.setText("--");
                                t11.setText("IC 319");
                                t12.setText("IC 320");

                                n1.setText("Microprocessor");
                                n2.setText("Computer Aided Design");
                                n3.setText("Industrial Electronics");
                                n4.setText("Control Systems I");
                                n5.setText("Telemetry & Data Transmission");
                                n6.setText("Microprocessor");
                                n7.setText("CAD Lab");
                                n8.setText("Control Systems Lab");
                                n9.setText("--");
                                n10.setText("--");
                                n11.setText("Programming IV");
                                n12.setText("Practical Training");
                                break;

                            case "Sem 7":
                                setDash(codeTextViews);
                                setDash(subjectTextViews);
                                break;

                            case "Sem 8":
                                setDash(codeTextViews);
                                setDash(subjectTextViews);
                                break;
                        }
                        break;

                    case "ECE":
                        switch (spinnerSemester.getSelectedItem().toString()) {
                            case "Sem 1":
                                t1.setText("EC 101");
                                t2.setText("EC 102");
                                t3.setText("EC 103");
                                t4.setText("EC 104");
                                t5.setText("EC 105");
                                t6.setText("EC 106");
                                t7.setText("EC 107");
                                t8.setText("EC 108");
                                t9.setText("EC 109");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Humanities");
                                n2.setText("Mathematics I");
                                n3.setText("Physics I");
                                n4.setText("Chemistry");
                                n5.setText("M.Processes");
                                n6.setText("E.D");
                                n7.setText("Physics I");
                                n8.setText("Chemistry");
                                n9.setText("Workshop I");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 2":
                                t1.setText("EC 111");
                                t2.setText("EC 112");
                                t3.setText("EC 113");
                                t4.setText("EC 114");
                                t5.setText("EC 115");
                                t6.setText("EC 116");
                                t7.setText("EC 117");
                                t8.setText("EC 118");
                                t9.setText("EC 119");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Principles of Electrical Engg");
                                n2.setText("Applied Mechanics");
                                n3.setText("Mathematics II");
                                n4.setText("Physics II");
                                n5.setText("Electrical Engineering and Materials");
                                n6.setText("Principles of Electrical Engg. Lab");
                                n7.setText("Applied Mechanics Lab");
                                n8.setText("Physics II/Electrical Engg Materials Lab");
                                n9.setText("Workshop II");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 3":
                                t1.setText("EC 201");
                                t2.setText("EC 202");
                                t3.setText("EC 203");
                                t4.setText("EC 204");
                                t5.setText("EC 205");
                                t6.setText("EC 206");
                                t7.setText("EC 207");
                                t8.setText("EC 208");
                                t9.setText("EC 209");
                                t10.setText("--");
                                t11.setText("EC 210");
                                t12.setText("--");

                                n1.setText("Electronics I");
                                n2.setText("Circuits and Systems");
                                n3.setText("Electrical Machines I");
                                n4.setText("Electrical Measurements");
                                n5.setText("Mathematics III");
                                n6.setText("Electronics I Lab");
                                n7.setText("Electrical Machines I Lab");
                                n8.setText("Electrical Measurements Lab");
                                n9.setText("Machine Drawing");
                                n10.setText("--");
                                n11.setText("Programming I");
                                n12.setText("--");
                                break;

                            case "Sem 4":
                                t1.setText("EC 211");
                                t2.setText("EC 212");
                                t3.setText("EC 213");
                                t4.setText("EC 214");
                                t5.setText("EC 215");
                                t6.setText("EC 216");
                                t7.setText("EC 217");
                                t8.setText("EC 218");
                                t9.setText("EC 219");
                                t10.setText("EC 220");
                                t11.setText("EC 221");
                                t12.setText("EC 222");

                                n1.setText("Electronics II");
                                n2.setText("Electromagnetics");
                                n3.setText("Network Analysis and Synthesis");
                                n4.setText("Digital Circuits and Systems I");
                                n5.setText("Electrical Machines II");
                                n6.setText("Electronics II Lab");
                                n7.setText("Digital Circuits and Systems I Lab");
                                n8.setText("Electrical Machines II Lab");
                                n9.setText("Electrical Workshop and Electric Drg");
                                n10.setText("Practical Training");
                                n11.setText("Report Writing");
                                n12.setText("Programming II");
                                break;

                            case "Sem 5":
                                t1.setText("EC 301");
                                t2.setText("EC 302");
                                t3.setText("EC 303");
                                t4.setText("EC 304");
                                t5.setText("EC 305");
                                t6.setText("EC 306");
                                t7.setText("EC 307");
                                t8.setText("EC 308");
                                t9.setText("--");
                                t10.setText("--");
                                t11.setText("EC 309");
                                t12.setText("--");

                                n1.setText("Machine Tools, CNC & Automation");
                                n2.setText("Transducers and Measurements");
                                n3.setText("Tool Design");
                                n4.setText("Industrial Control Systems");
                                n5.setText("Microprocessors and App.");
                                n6.setText("Machine Tools Lab");
                                n7.setText("Tool Design Lab");
                                n8.setText("MA 304 based Lab");
                                n9.setText("Transducers and Measurements Lab");
                                n10.setText("--");
                                n11.setText("Programming III");
                                n12.setText("--");
                                break;

                            case "Sem 6":
                                setDash(codeTextViews);
                                setDash(subjectTextViews);
                                break;

                            case "Sem 7":
                                setDash(codeTextViews);
                                setDash(subjectTextViews);
                                break;

                            case "Sem 8":
                                setDash(codeTextViews);
                                setDash(subjectTextViews);
                                break;
                        }
                        break;

                    case "MPAE":
                        switch (spinnerSemester.getSelectedItem().toString()) {
                            case "Sem 1":
                                t1.setText("MA 101");
                                t2.setText("MA 102");
                                t3.setText("MA 103");
                                t4.setText("MA 104");
                                t5.setText("MA 105");
                                t6.setText("MA 106");
                                t7.setText("MA 107");
                                t8.setText("MA 108");
                                t9.setText("MA 109");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Humanities");
                                n2.setText("Mathematics I");
                                n3.setText("Physics I");
                                n4.setText("Chemistry");
                                n5.setText("M.Processes");
                                n6.setText("E.D");
                                n7.setText("Physics I");
                                n8.setText("Chemistry");
                                n9.setText("Workshop I");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;
                            case "Sem 2":

                                t1.setText("MA 111");
                                t2.setText("MA 112");
                                t3.setText("MA 113");
                                t4.setText("MA 114");
                                t5.setText("MA 115");
                                t6.setText("MA 116");
                                t7.setText("MA 117");
                                t8.setText("MA 118");
                                t9.setText("MA 119");
                                t10.setText("--");
                                t11.setText("MA 120");
                                t12.setText("--");

                                n1.setText("Electrical Sciences");
                                n2.setText("Mathematics II");
                                n3.setText("Mechanical Sciences");
                                n4.setText("Sciecnce of Materials");
                                n5.setText("Mechanics of Solids");
                                n6.setText("Electrical Science Lab");
                                n7.setText("Mechanical Sciences Lab");
                                n8.setText("Intro. to Comp. Lab");
                                n9.setText("Mecanics of Solids Lab");
                                n10.setText("--");
                                n11.setText("Programming I Lab");
                                n12.setText("--");
                                break;

                            case "Sem 3":
                                t1.setText("MA 201");
                                t2.setText("MA 202");
                                t3.setText("MA 203");
                                t4.setText("MA 204");
                                t5.setText("MA 205");
                                t6.setText("MA 206");
                                t7.setText("MA 207");
                                t8.setText("MA 208");
                                t9.setText("MA 209");
                                t10.setText("--");
                                t11.setText("MA 210");
                                t12.setText("--");

                                n1.setText("Machine Drawing and Graphics");
                                n2.setText("Manufacturing Processes I");
                                n3.setText("Electro mechanics");
                                n4.setText("Analog and Digital Electronics");
                                n5.setText("Technology and Society");
                                n6.setText("Machine Drawing and Graphics Lab");
                                n7.setText("Sci. of Mater. & Manufac. Proces.");
                                n8.setText("Electro Mechanics Lab");
                                n9.setText("Analog and Digital Electronics Lab");
                                n10.setText("--");
                                n11.setText("Programming I Lab");
                                n12.setText("--");
                                break;

                            case "Sem 4":
                                t1.setText("MA 211");
                                t2.setText("MA 212");
                                t3.setText("MA 213");
                                t4.setText("MA 214");
                                t5.setText("MA 215");
                                t6.setText("MA 216");
                                t7.setText("MA 217");
                                t8.setText("MA 218");
                                t9.setText("MA 219");
                                t10.setText("--");
                                t11.setText("MA 220");
                                t12.setText("MA 221");

                                n1.setText("KDM");
                                n2.setText("Control Sys.");
                                n3.setText("Mathematics III");
                                n4.setText("M.P II");
                                n5.setText("Management of Manufac. Sys.");
                                n6.setText("KDM Lab");
                                n7.setText("Control Sys.Lab");
                                n8.setText("MP II");
                                n9.setText("Practical Training");
                                n10.setText("--");
                                n11.setText("Report Writing");
                                n12.setText("Programming II");
                                break;

                            case "Sem 5":
                                t1.setText("MA 301");
                                t2.setText("MA 302");
                                t3.setText("MA 303");
                                t4.setText("MA 304");
                                t5.setText("MA 305");
                                t6.setText("MA 306");
                                t7.setText("MA 307");
                                t8.setText("MA 308");
                                t9.setText("MA 309");
                                t10.setText("--");
                                t11.setText("MA 310");
                                t12.setText("--");

                                n1.setText("Machine Tools, CNC & Automation");
                                n2.setText("Transducers and Measurements");
                                n3.setText("Tool Design");
                                n4.setText("Industrial Control Systems");
                                n5.setText("Microprocessors and App.");
                                n6.setText("Machine Tools Lab");
                                n7.setText("Tool Design Lab");
                                n8.setText("MA 304 based Lab");
                                n9.setText("Transducers and Measurements Lab");
                                n10.setText("--");
                                n11.setText("Programming III");
                                n12.setText("--");
                                break;

                            case "Sem 6":
                                t1.setText("MA 311");
                                t2.setText("MA 312");
                                t3.setText("MA 313");
                                t4.setText("MA 314");
                                t5.setText("MA 315");
                                t6.setText("MA 316");
                                t7.setText("MA 317");
                                t8.setText("MA 318");
                                t9.setText("MA 319");
                                t10.setText("--");
                                t11.setText("MA 320");
                                t12.setText("MA 321");

                                n1.setText("Robotics and CAM I");
                                n2.setText("Computer Graphics");
                                n3.setText("Applied Plasticity (Forming Processes)");
                                n4.setText("M.D");
                                n5.setText("Metroloay & Statistical Quality Control");
                                n6.setText("Robotics and CAM I Lab");
                                n7.setText("MA312 based Lab");
                                n8.setText("Forming Processes Lab");
                                n9.setText("Mechanical Design");
                                n10.setText("--");
                                n11.setText("Practical Training");
                                n12.setText("Programming V");
                                break;

                            case "Sem 7":
                                t1.setText("MA 401");
                                t2.setText("MA 402");
                                t3.setText("MA 403");
                                t4.setText("MA 404");
                                t5.setText("MA 405");
                                t6.setText("MA 406");
                                t7.setText("MA 407");
                                t8.setText("MA 408");
                                t9.setText("MA 409");
                                t10.setText("--");
                                t11.setText("MA 410");
                                t12.setText("--");

                                n1.setText("Intro. to CAD and Prod. Desg.");
                                n2.setText("Modern Methods of Manufacturing");
                                n3.setText("Industrial Electronics");
                                n4.setText("Elective I");
                                n5.setText("Elective II");
                                n6.setText("CAD Lab");
                                n7.setText("Modern Methods of Manufacturing Lab");
                                n8.setText("Industrial Electronics Lab");
                                n9.setText("Practical Training");
                                n10.setText("--");
                                n11.setText("Programming IV (AUTOCAD)");
                                n12.setText("--");
                                break;

                            case "Sem 8":
                                t1.setText("MA 411");
                                t2.setText("MA 412");
                                t3.setText("MA 413");
                                t4.setText("--");
                                t5.setText("--");
                                t6.setText("MA 414");
                                t7.setText("MA 415");
                                t8.setText("MA 416");
                                t9.setText("MA 417");
                                t10.setText("--");
                                t11.setText("MA 418");
                                t12.setText("--");

                                n1.setText("Macaronis or AI");
                                n2.setText("Elective III");
                                n3.setText("Elective IV");
                                n4.setText("--");
                                n5.setText("--");
                                n6.setText("MA 411 based Lab");
                                n7.setText("Elective III and IV Lab");
                                n8.setText("Project");
                                n9.setText("Practical Training");
                                n10.setText("--");
                                n11.setText("Seminar/Reports");
                                n12.setText("--");
                                break;
                        }
                        break;

                    case "BT":
                        switch (spinnerSemester.getSelectedItem().toString()) {
                            case "Sem 1":
                                t1.setText("BT 101");
                                t2.setText("BT 102");
                                t3.setText("BT 103");
                                t4.setText("MP 104");
                                t5.setText("BT 105");
                                t6.setText("BT 106");
                                t7.setText("BT 107");
                                t8.setText("BT 108");
                                t9.setText("BT 109");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Humanities");
                                n2.setText("Mathematics I");
                                n3.setText("Physics I");
                                n4.setText("Chemistry");
                                n5.setText("M.Processes");
                                n6.setText("E.D");
                                n7.setText("Physics I");
                                n8.setText("Chemistry");
                                n9.setText("Workshop I");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 2":
                                t1.setText("BT 111");
                                t2.setText("BT 112");
                                t3.setText("BT 113");
                                t4.setText("BT 114");
                                t5.setText("BT 115");
                                t6.setText("BT 116");
                                t7.setText("BT 117");
                                t8.setText("BT 118");
                                t9.setText("BT 119");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Intro.to Biotechnology");
                                n2.setText("Physics II");
                                n3.setText("Chemistry I");
                                n4.setText("Mechanical Sciences");
                                n5.setText("Engineering Mathematics");
                                n6.setText("Introduction to Biotech Lab");
                                n7.setText("Physics II Lab");
                                n8.setText("Intro. to Comp. Lab");
                                n9.setText("Chemistry II");
                                n10.setText("--");
                                n11.setText("Mechanical Sciences Lab");
                                n12.setText("--");
                                break;

                            case "Sem 3":
                                t1.setText("BT 201");
                                t2.setText("BT 202");
                                t3.setText("BT 203");
                                t4.setText("BT 204");
                                t5.setText("BT 205");
                                t6.setText("BT 206");
                                t7.setText("BT 207");
                                t8.setText("BT 208");
                                t9.setText("BT 209");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Cell Biology");
                                n2.setText("Biochemistry");
                                n3.setText("Microbiology");
                                n4.setText("Basics of Computer Systems and Programming");
                                n5.setText("Basic Electronics and Instrumentation");
                                n6.setText("Cell Biology Lab");
                                n7.setText("Biochemistry and Microbiology Lab");
                                n8.setText("Basics of Computer Systems and Programming Lab");
                                n9.setText("Basic Electronics and Instrumentation Lab");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 4":
                                t1.setText("BT 211");
                                t2.setText("BT 212");
                                t3.setText("BT 213");
                                t4.setText("BT 214");
                                t5.setText("BT 215");
                                t6.setText("BT 216");
                                t7.setText("BT 217");
                                t8.setText("BT 218");
                                t9.setText("--");
                                t10.setText("--");
                                t11.setText("BT 219");
                                t12.setText("");

                                n1.setText("Molecular Biology");
                                n2.setText("Genetics");
                                n3.setText("Methods and Inst. in Biotech.");
                                n4.setText("Statistics for Biology");
                                n5.setText("Data Structures and Algorithms");
                                n6.setText("Molecular Biology and Genetics Lab");
                                n7.setText("Methods and Instrumentation in Biotechnology Lab");
                                n8.setText("Data Structures Lab");
                                n9.setText("--");
                                n10.setText("--");
                                n11.setText("Project");
                                n12.setText("--");
                                break;

                            case "Sem 5":
                                t1.setText("BT 301");
                                t2.setText("BT 302");
                                t3.setText("BT 303");
                                t4.setText("BT 304");
                                t5.setText("BT 305");
                                t6.setText("BT 306");
                                t7.setText("BT 307");
                                t8.setText("BT 308");
                                t9.setText("BT 309");
                                t10.setText("--");
                                t11.setText("BT 310");
                                t12.setText("--");

                                n1.setText("Structural Biology");
                                n2.setText("Immunology and Immuno-technology");
                                n3.setText("Recombinant-DNA Technology I");
                                n4.setText("DBMS");
                                n5.setText("Chemical Engineering Principles.");
                                n6.setText("Structural Biology Lab");
                                n7.setText("Immunology and Immuno-technology Lab");
                                n8.setText("Recombinant-DNA Technology I Lab");
                                n9.setText("DBMS Lab");
                                n10.setText("--");
                                n11.setText("Term Paper and Seminar");
                                n12.setText("--");
                                break;

                            case "Sem 6":
                                t1.setText("BT 311");
                                t2.setText("BT 312");
                                t3.setText("BT 313");
                                t4.setText("BT 314");
                                t5.setText("BT 315");
                                t6.setText("BT 316");
                                t7.setText("BT 317");
                                t8.setText("BT 318");
                                t9.setText("BT 319");
                                t10.setText("--");
                                t11.setText("--");
                                t12.setText("--");

                                n1.setText("Recombinant-DNA Technology II");
                                n2.setText("Enzymology and Enzyme Technology");
                                n3.setText("Plant and Animal Biotechnology");
                                n4.setText("Computational Biology I");
                                n5.setText("Fundamentals of Biochemical Engineering");
                                n6.setText("Recombinant-DNA Technology II Lab");
                                n7.setText("Enzymology and Enzyme Technology Lab");
                                n8.setText("Plant and Animal Biotechnology Lab");
                                n9.setText("Computational Biology I Lab");
                                n10.setText("--");
                                n11.setText("--");
                                n12.setText("--");
                                break;

                            case "Sem 7":
                                setDash(codeTextViews);
                                setDash(subjectTextViews);
                                break;

                            case "Sem 8":
                                setDash(codeTextViews);
                                setDash(subjectTextViews);
                                break;
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void setDash(ArrayList<TextView> view) {
        for (TextView v : view) {
            v.setText("--");
        }
    }
}