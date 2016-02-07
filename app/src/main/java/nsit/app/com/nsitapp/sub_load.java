package nsit.app.com.nsitapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class sub_load extends AppCompatActivity {

    Spinner s3;
    Spinner s4;
    ArrayAdapter<CharSequence> adapter2;
    ArrayAdapter<CharSequence> adapter3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_load);

        s3 = (Spinner)findViewById(R.id.spinB);
        adapter2 = ArrayAdapter.createFromResource(this,R.array.branch,android.R.layout.simple_list_item_1);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(adapter2);
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String val = s3.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "Branch selected is " + val, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s4 = (Spinner)findViewById(R.id.spinS);
        adapter3 = ArrayAdapter.createFromResource(this,R.array.semester,android.R.layout.simple_list_item_1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(adapter3);
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String val = s4.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),"Semester selected is "+ val, Toast.LENGTH_SHORT).show();


                if(s3.getSelectedItem().toString().equals("Branch")) {
                    if (s4.getSelectedItem().toString().equals("Semester")) {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);


                        t1.setText("--");
                        t2.setText("--");
                        t3.setText("--");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("--");
                        t7.setText("--");
                        t8.setText("--");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("--");
                        t12.setText("--");

                        n1.setText("--");
                        n2.setText("--");
                        n3.setText("--");
                        n4.setText("--");
                        n5.setText("--");
                        n6.setText("--");
                        n7.setText("--");
                        n8.setText("--");
                        n9.setText("--");
                        n10.setText("--");
                        n11.setText("--");
                        n12.setText("--");
                    }
                }


                else if(s3.getSelectedItem().toString().equals("COE"))
                {
                    if(s4.getSelectedItem().toString().equals("Sem 1"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);


                        t1.setText("COE101");
                        t2.setText("COE102");
                        t3.setText("COE103");
                        t4.setText("COE104");
                        t5.setText("COE105");
                        t6.setText("COE106");
                        t7.setText("COE107");
                        t8.setText("COE108");
                        t9.setText("COE109");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 2"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("COE111");
                        t2.setText("COE112");
                        t3.setText("COE113");
                        t4.setText("COE114");
                        t5.setText("COE115");
                        t6.setText("COE116");
                        t7.setText("COE117");
                        t8.setText("COE118");
                        t9.setText("COE119");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 3"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);


                        t1.setText("COE201");
                        t2.setText("COE202");
                        t3.setText("COE203");
                        t4.setText("COE204");
                        t5.setText("COE205");
                        t6.setText("COE206");
                        t7.setText("COE207");
                        t8.setText("COE208");
                        t9.setText("COE209");
                        t10.setText("--");
                        t11.setText("COE210");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 4"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("COE211");
                        t2.setText("COE212");
                        t3.setText("COE213");
                        t4.setText("COE214");
                        t5.setText("COE215");
                        t6.setText("COE216");
                        t7.setText("COE217");
                        t8.setText("COE218");
                        t9.setText("COE219");
                        t10.setText("COE220");
                        t11.setText("COE221");
                        t12.setText("COE222");

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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 5"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("COE301");
                        t2.setText("COE302");
                        t3.setText("COE303");
                        t4.setText("COE304");
                        t5.setText("COE305");
                        t6.setText("COE306");
                        t7.setText("COE307");
                        t8.setText("COE308");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("COE309");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 6"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);
                        t1.setText("COE311");
                        t2.setText("COE312");
                        t3.setText("COE313");
                        t4.setText("COE314");
                        t5.setText("COE315");
                        t6.setText("COE316");
                        t7.setText("COE317");
                        t8.setText("COE318");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("COE319");
                        t12.setText("COE320");

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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 7"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("COE401");
                        t2.setText("COE402");
                        t3.setText("COE403");
                        t4.setText("COE404");
                        t5.setText("COE405");
                        t6.setText("COE406");
                        t7.setText("COE407");
                        t8.setText("COE408");
                        t9.setText("COE409");
                        t10.setText("--");
                        t11.setText("COE410");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 8"))
                    {


                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);
                        t1.setText("COE411");
                        t2.setText("COE412");
                        t3.setText("COE413");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("COE414");
                        t7.setText("COE415");
                        t8.setText("COE416");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("COE417");
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
                    }


                }

                else if(s3.getSelectedItem().toString().equals("IT"))
                {
                    if(s4.getSelectedItem().toString().equals("Sem 1"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IT101");
                        t2.setText("IT102");
                        t3.setText("IT103");
                        t4.setText("IT104");
                        t5.setText("IT105");
                        t6.setText("IT106");
                        t7.setText("IT107");
                        t8.setText("IT108");
                        t9.setText("IT109");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 2"))
                    {


                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);
                        t1.setText("IT111");
                        t2.setText("IT112");
                        t3.setText("IT113");
                        t4.setText("IT114");
                        t5.setText("IT115");
                        t6.setText("IT116");
                        t7.setText("IT117");
                        t8.setText("IT118");
                        t9.setText("IT119");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 3"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IT201");
                        t2.setText("IT202");
                        t3.setText("IT203");
                        t4.setText("IT204");
                        t5.setText("IT205");
                        t6.setText("IT206");
                        t7.setText("--");
                        t8.setText("IT208");
                        t9.setText("IT209");
                        t10.setText("--");
                        t11.setText("IT210");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 4"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IT211");
                        t2.setText("IT212");
                        t3.setText("IT213");
                        t4.setText("IT214");
                        t5.setText("IT215");
                        t6.setText("IT216");
                        t7.setText("IT217");
                        t8.setText("IT218");
                        t9.setText("IT219");
                        t10.setText("IT220");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 5"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IT301");
                        t2.setText("IT302");
                        t3.setText("IT303");
                        t4.setText("IT304");
                        t5.setText("IT305");
                        t6.setText("--");
                        t7.setText("IT306");
                        t8.setText("IT307");
                        t9.setText("IT308");
                        t10.setText("--");
                        t11.setText("IT309");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 6"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IT311");
                        t2.setText("IT312");
                        t3.setText("IT313");
                        t4.setText("IT314");
                        t5.setText("IT315");
                        t6.setText("IT316");
                        t7.setText("IT317");
                        t8.setText("IT318");
                        t9.setText("IT319");
                        t10.setText("--");
                        t11.setText("IT320");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 7"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IT401");
                        t2.setText("IT402");
                        t3.setText("IT403");
                        t4.setText("IT404");
                        t5.setText("IT405");
                        t6.setText("IT406");
                        t7.setText("IT407");
                        t8.setText("IT408");
                        t9.setText("IT409");
                        t10.setText("--");
                        t11.setText("IT410");
                        t12.setText("IT411");

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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 8"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IT412");
                        t2.setText("IT413");
                        t3.setText("IT414");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("IT415");
                        t7.setText("IT416");
                        t8.setText("IT417");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("IT418");
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
                    }


                }

                else if(s3.getSelectedItem().toString().equals("ICE"))
                {
                    if(s4.getSelectedItem().toString().equals("Sem 1"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IC101");
                        t2.setText("IC102");
                        t3.setText("IC103");
                        t4.setText("IC104");
                        t5.setText("IC105");
                        t6.setText("IC106");
                        t7.setText("IC107");
                        t8.setText("IC108");
                        t9.setText("IC109");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 2"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IC111");
                        t2.setText("IC112");
                        t3.setText("IC113");
                        t4.setText("IC114");
                        t5.setText("IC115");
                        t6.setText("IC116");
                        t7.setText("IC117");
                        t8.setText("IC118");
                        t9.setText("IC119");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 3"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IC201");
                        t2.setText("IC202");
                        t3.setText("IC203");
                        t4.setText("IC204");
                        t5.setText("IC205");
                        t6.setText("IC206");
                        t7.setText("IC207");
                        t8.setText("IC208");
                        t9.setText("IC209");
                        t10.setText("--");
                        t11.setText("IC210");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 4"))
                    {


                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);
                        t1.setText("IC211");
                        t2.setText("IC212");
                        t3.setText("IC213");
                        t4.setText("IC214");
                        t5.setText("IC215");
                        t6.setText("IC216");
                        t7.setText("IC217");
                        t8.setText("IC218");
                        t9.setText("IC219");
                        t10.setText("IC220");
                        t11.setText("IC221");
                        t12.setText("IC222");

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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 5"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("IC301");
                        t2.setText("IC302");
                        t3.setText("IC303");
                        t4.setText("IC304");
                        t5.setText("IC305");
                        t6.setText("IC306");
                        t7.setText("IC307");
                        t8.setText("IC308");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("IC310");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 6"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("MP311");
                        t2.setText("MP312");
                        t3.setText("MP313");
                        t4.setText("MP314");
                        t5.setText("MP315");
                        t6.setText("MP316");
                        t7.setText("MP317");
                        t8.setText("MP318");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("MP319");
                        t12.setText("MP320");

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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 7"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("--");
                        t2.setText("--");
                        t3.setText("--");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("--");
                        t7.setText("--");
                        t8.setText("--");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("--");
                        t12.setText("--");

                        n1.setText("--.");
                        n2.setText("--");
                        n3.setText("--");
                        n4.setText("--");
                        n5.setText("--");
                        n6.setText("--");
                        n7.setText("--");
                        n8.setText("--");
                        n9.setText("--");
                        n10.setText("--");
                        n11.setText("--");
                        n12.setText("--");
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 8"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("--");
                        t2.setText("--");
                        t3.setText("--");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("--");
                        t7.setText("--");
                        t8.setText("--");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("--");
                        t12.setText("--");

                        n1.setText("--");
                        n2.setText("--");
                        n3.setText("--");
                        n4.setText("--");
                        n5.setText("--");
                        n6.setText("--");
                        n7.setText("--");
                        n8.setText("--");
                        n9.setText("--");
                        n10.setText("--");
                        n11.setText("--");
                        n12.setText("--");
                    }


                }


                else if(s3.getSelectedItem().toString().equals("ECE"))
                {
                    if(s4.getSelectedItem().toString().equals("Sem 1"))
                    {


                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);
                        t1.setText("EC101");
                        t2.setText("EC102");
                        t3.setText("EC103");
                        t4.setText("EC104");
                        t5.setText("EC105");
                        t6.setText("EC106");
                        t7.setText("EC107");
                        t8.setText("EC108");
                        t9.setText("EC109");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 2"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("EC111");
                        t2.setText("EC112");
                        t3.setText("EC113");
                        t4.setText("EC114");
                        t5.setText("EC115");
                        t6.setText("EC116");
                        t7.setText("EC117");
                        t8.setText("EC118");
                        t9.setText("EC119");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 3"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("EC201");
                        t2.setText("EC202");
                        t3.setText("EC203");
                        t4.setText("EC204");
                        t5.setText("EC205");
                        t6.setText("EC206");
                        t7.setText("EC207");
                        t8.setText("EC208");
                        t9.setText("EC209");
                        t10.setText("--");
                        t11.setText("EC210");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 4"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("EC211");
                        t2.setText("EC212");
                        t3.setText("EC213");
                        t4.setText("EC214");
                        t5.setText("EC215");
                        t6.setText("EC216");
                        t7.setText("EC217");
                        t8.setText("EC218");
                        t9.setText("EC219");
                        t10.setText("EC220");
                        t11.setText("EC221");
                        t12.setText("EC222");

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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 5"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("EC301");
                        t2.setText("EC302");
                        t3.setText("EC303");
                        t4.setText("EC304");
                        t5.setText("EC305");
                        t6.setText("EC306");
                        t7.setText("EC307");
                        t8.setText("EC308");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("EC309");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 6"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("--");
                        t2.setText("--");
                        t3.setText("--");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("--");
                        t7.setText("--");
                        t8.setText("--");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("--");
                        t12.setText("--");

                        n1.setText("--");
                        n2.setText("--");
                        n3.setText("--");
                        n4.setText("--");
                        n5.setText("--");
                        n6.setText("--");
                        n7.setText("--");
                        n8.setText("--");
                        n9.setText("--");
                        n10.setText("--");
                        n11.setText("--");
                        n12.setText("--");
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 7"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("--");
                        t2.setText("--");
                        t3.setText("--");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("--");
                        t7.setText("--");
                        t8.setText("--");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("--");
                        t12.setText("--");

                        n1.setText("--");
                        n2.setText("--");
                        n3.setText("--");
                        n4.setText("--");
                        n5.setText("--");
                        n6.setText("--");
                        n7.setText("--");
                        n8.setText("--");
                        n9.setText("--");
                        n10.setText("--");
                        n11.setText("--");
                        n12.setText("--");
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 8"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("--");
                        t2.setText("--");
                        t3.setText("--");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("--");
                        t7.setText("--");
                        t8.setText("--");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("--");
                        t12.setText("--");

                        n1.setText("--");
                        n2.setText("--");
                        n3.setText("--");
                        n4.setText("--");
                        n5.setText("--");
                        n6.setText("--");
                        n7.setText("--");
                        n8.setText("--");
                        n9.setText("--");
                        n10.setText("--");
                        n11.setText("--");
                        n12.setText("--");
                    }


                }

                else if(s3.getSelectedItem().toString().equals("MPAE"))
                {
                    if(s4.getSelectedItem().toString().equals("Sem 1"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("MP101");
                        t2.setText("MP102");
                        t3.setText("MP103");
                        t4.setText("MP104");
                        t5.setText("MP105");
                        t6.setText("MP106");
                        t7.setText("MP107");
                        t8.setText("MP108");
                        t9.setText("MP109");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 2"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("MP111");
                        t2.setText("MP112");
                        t3.setText("MP113");
                        t4.setText("MP114");
                        t5.setText("MP115");
                        t6.setText("MP116");
                        t7.setText("MP117");
                        t8.setText("MP118");
                        t9.setText("MP119");
                        t10.setText("--");
                        t11.setText("MP120");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 3"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("MP201");
                        t2.setText("MP202");
                        t3.setText("MP203");
                        t4.setText("MP204");
                        t5.setText("MP205");
                        t6.setText("MP206");
                        t7.setText("MP207");
                        t8.setText("MP208");
                        t9.setText("MP209");
                        t10.setText("--");
                        t11.setText("MP210");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 4"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("MP211");
                        t2.setText("MP212");
                        t3.setText("MP213");
                        t4.setText("MP214");
                        t5.setText("MP215");
                        t6.setText("MP216");
                        t7.setText("MP217");
                        t8.setText("MP218");
                        t9.setText("MP219");
                        t10.setText("--");
                        t11.setText("MP220");
                        t12.setText("MP221");

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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 5"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("MP301");
                        t2.setText("MP302");
                        t3.setText("MP303");
                        t4.setText("MP304");
                        t5.setText("MP305");
                        t6.setText("MP306");
                        t7.setText("MP307");
                        t8.setText("MP308");
                        t9.setText("MP309");
                        t10.setText("--");
                        t11.setText("MP310");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 6"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("MP311");
                        t2.setText("MP312");
                        t3.setText("MP313");
                        t4.setText("MP314");
                        t5.setText("MP315");
                        t6.setText("MP316");
                        t7.setText("MP317");
                        t8.setText("MP318");
                        t9.setText("MP319");
                        t10.setText("--");
                        t11.setText("MP320");
                        t12.setText("MP321");

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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 7"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("MP401");
                        t2.setText("MP402");
                        t3.setText("MP403");
                        t4.setText("MP404");
                        t5.setText("MP405");
                        t6.setText("MP406");
                        t7.setText("MP407");
                        t8.setText("MP408");
                        t9.setText("MP409");
                        t10.setText("--");
                        t11.setText("MP410");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 8"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("MP411");
                        t2.setText("MP412");
                        t3.setText("MP413");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("MP414");
                        t7.setText("MP415");
                        t8.setText("MP416");
                        t9.setText("MP417");
                        t10.setText("--");
                        t11.setText("MP418");
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
                    }


                }
                else if(s3.getSelectedItem().toString().equals("BT"))
                {
                    if(s4.getSelectedItem().toString().equals("Sem 1"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("BT101");
                        t2.setText("BT102");
                        t3.setText("BT103");
                        t4.setText("MP104");
                        t5.setText("BT105");
                        t6.setText("BT106");
                        t7.setText("BT107");
                        t8.setText("BT108");
                        t9.setText("BT109");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 2"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("BT111");
                        t2.setText("BT112");
                        t3.setText("BT113");
                        t4.setText("BT114");
                        t5.setText("BT115");
                        t6.setText("BT116");
                        t7.setText("BT117");
                        t8.setText("BT118");
                        t9.setText("BT119");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 3"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("BT201");
                        t2.setText("BT202");
                        t3.setText("BT203");
                        t4.setText("BT204");
                        t5.setText("BT205");
                        t6.setText("BT206");
                        t7.setText("BT207");
                        t8.setText("BT208");
                        t9.setText("BT209");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 4"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("BT211");
                        t2.setText("BT212");
                        t3.setText("BT213");
                        t4.setText("BT214");
                        t5.setText("BT215");
                        t6.setText("BT216");
                        t7.setText("BT217");
                        t8.setText("BT218");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("BT219");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 5"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("BT301");
                        t2.setText("BT302");
                        t3.setText("BT303");
                        t4.setText("BT304");
                        t5.setText("BT305");
                        t6.setText("BT306");
                        t7.setText("BT307");
                        t8.setText("BT308");
                        t9.setText("BT309");
                        t10.setText("--");
                        t11.setText("BT310");
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
                    }
                    else if(s4.getSelectedItem().toString().equals("Sem 6"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("BT311");
                        t2.setText("BT312");
                        t3.setText("BT313");
                        t4.setText("BT314");
                        t5.setText("BT315");
                        t6.setText("BT316");
                        t7.setText("BT317");
                        t8.setText("BT318");
                        t9.setText("BT319");
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
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 7"))
                    {

                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);
                        t1.setText("--");
                        t2.setText("--");
                        t3.setText("--");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("--");
                        t7.setText("--");
                        t8.setText("--");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("--");
                        t12.setText("--");

                        n1.setText("--");
                        n2.setText("--");
                        n3.setText("--");
                        n4.setText("--");
                        n5.setText("--");
                        n6.setText("--");
                        n7.setText("--");
                        n8.setText("--");
                        n9.setText("--");
                        n10.setText("--");
                        n11.setText("--)");
                        n12.setText("--");
                    }

                    else if(s4.getSelectedItem().toString().equals("Sem 8"))
                    {
                        TextView t1 = (TextView)findViewById(R.id.co1);
                        TextView t2 = (TextView)findViewById(R.id.co2);
                        TextView t3 = (TextView)findViewById(R.id.co3);
                        TextView t4 = (TextView)findViewById(R.id.co4);
                        TextView t5 = (TextView)findViewById(R.id.co5);
                        TextView t6 = (TextView)findViewById(R.id.co6);
                        TextView t7 = (TextView)findViewById(R.id.co7);
                        TextView t8 = (TextView)findViewById(R.id.co8);
                        TextView t9 = (TextView)findViewById(R.id.co9);
                        TextView t10 = (TextView)findViewById(R.id.co10);
                        TextView t11 = (TextView)findViewById(R.id.co11);
                        TextView t12 = (TextView)findViewById(R.id.co12);

                        TextView n1 = (TextView)findViewById(R.id.su1);
                        TextView n2 = (TextView)findViewById(R.id.su2);
                        TextView n3 = (TextView)findViewById(R.id.su3);
                        TextView n4 = (TextView)findViewById(R.id.su4);
                        TextView n5 = (TextView)findViewById(R.id.su5);
                        TextView n6 = (TextView)findViewById(R.id.su6);
                        TextView n7 = (TextView)findViewById(R.id.su7);
                        TextView n8 = (TextView)findViewById(R.id.su8);
                        TextView n9 = (TextView)findViewById(R.id.su9);
                        TextView n10 = (TextView)findViewById(R.id.su10);
                        TextView n11 = (TextView)findViewById(R.id.su11);
                        TextView n12 = (TextView)findViewById(R.id.su12);

                        t1.setText("--");
                        t2.setText("--");
                        t3.setText("--");
                        t4.setText("--");
                        t5.setText("--");
                        t6.setText("--");
                        t7.setText("--");
                        t8.setText("--");
                        t9.setText("--");
                        t10.setText("--");
                        t11.setText("--");
                        t12.setText("--");

                        n1.setText("--");
                        n2.setText("--");
                        n3.setText("--");
                        n4.setText("--");
                        n5.setText("--");
                        n6.setText("--");
                        n7.setText("--");
                        n8.setText("--");
                        n9.setText("--");
                        n10.setText("--");
                        n11.setText("--");
                        n12.setText("--");
                    }


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







    }

}
