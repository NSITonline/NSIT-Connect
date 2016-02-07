package nsit.app.com.nsitapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CalculatorActivity extends Fragment {

    Spinner s1;
    Spinner s2;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapter1;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rooview = inflater.inflate(R.layout.activity_calculator,container,false);
        s1 = (Spinner)rooview.findViewById(R.id.spinb);
        adapter = ArrayAdapter.createFromResource(getActivity(),R.array.branch,android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter);
      



        s2 = (Spinner)rooview.findViewById(R.id.spins);
        adapter1 = ArrayAdapter.createFromResource(getActivity(),R.array.semester,android.R.layout.simple_list_item_1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter1);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if(s1.getSelectedItem().toString().equals("COE"))
                {
                    if(s2.getSelectedItem().toString().equals("Sem 1"))
                    {
                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 2"))
                    {
                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }


                    else if(s2.getSelectedItem().toString().equals("Sem 3"))
                    {
                        cc(rooview);

                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }
                    else if(s2.getSelectedItem().toString().equals("Sem 4"))
                    {
                        cc(rooview);}

                    else if(s2.getSelectedItem().toString().equals("Sem 5"))
                    {
                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc9 = (TextView)rooview.findViewById(R.id.tv9);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc9.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 6"))
                    {
                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc9 = (TextView)rooview.findViewById(R.id.tv9);


                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc9.setTextColor(Color.parseColor("#b3b3b3"));

                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 7"))
                    {
                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);

                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));

                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 8"))
                    {
                        cc(rooview);

                        TextView tc4 = (TextView)rooview.findViewById(R.id.tv4);
                        TextView tc5 = (TextView)rooview.findViewById(R.id.tv5);
                        TextView tc9 = (TextView)rooview.findViewById(R.id.tv9);
                        TextView tc10= (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc9.setTextColor(Color.parseColor("#b3b3b3"));
                        tc5.setTextColor(Color.parseColor("#b3b3b3"));
                        tc4.setTextColor(Color.parseColor("#b3b3b3"));
                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }
                }
                else if (s1.getSelectedItem().toString().equals("IT"))
                {

                    if(s2.getSelectedItem().toString().equals("Sem 1")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 2")){

                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 3")){
                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc9 = (TextView)rooview.findViewById(R.id.tv9);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc9.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 4"))
                    {

                        cc(rooview);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);


                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 5")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc9 = (TextView)rooview.findViewById(R.id.tv9);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc9.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 6")){

                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }
                    else if(s2.getSelectedItem().toString().equals("Sem 7"))
                    {
                        cc(rooview);}

                    else if(s2.getSelectedItem().toString().equals("Sem 8"))
                    {
                        cc(rooview);

                        TextView tc4 = (TextView)rooview.findViewById(R.id.tv4);
                        TextView tc5 = (TextView)rooview.findViewById(R.id.tv5);
                        TextView tc9 = (TextView)rooview.findViewById(R.id.tv9);
                        TextView tc10= (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc9.setTextColor(Color.parseColor("#b3b3b3"));
                        tc5.setTextColor(Color.parseColor("#b3b3b3"));
                        tc4.setTextColor(Color.parseColor("#b3b3b3"));
                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }
                }

                else if (s1.getSelectedItem().toString().equals("MPAE"))
                {

                    if(s2.getSelectedItem().toString().equals("Sem 1")){

                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 2")){

                        cc(rooview);

                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 3")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 4"))
                    {
                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 5")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 6")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        tc10.setTextColor(Color.parseColor("#b3b3b3"));

                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 7"))
                    {

                        cc(rooview);
                        TextView tc10= (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);


                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 8"))
                    {
                        cc(rooview);
                        TextView tc4= (TextView)rooview.findViewById(R.id.tv4);
                        TextView tc5 = (TextView)rooview.findViewById(R.id.tv5);
                        TextView tc10= (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);


                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc4.setTextColor(Color.parseColor("#b3b3b3"));
                        tc5.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }
                }

                else if (s1.getSelectedItem().toString().equals("ECE")) {

                    if (s2.getSelectedItem().toString().equals("Sem 1")) {

                        cc(rooview);
                        TextView tc10 = (TextView) rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView) rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView) rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }
                    else if (s2.getSelectedItem().toString().equals("Sem 2")) {

                        cc(rooview);
                        TextView tc10 = (TextView) rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView) rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView) rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));

                    }
                    else if (s2.getSelectedItem().toString().equals("Sem 3")) {

                        cc(rooview);
                        TextView tc10 = (TextView) rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView) rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }
                    else if(s2.getSelectedItem().toString().equals("Sem 4"))
                    {
                        cc(rooview);}

                    else if (s2.getSelectedItem().toString().equals("Sem 5")) {

                        cc(rooview);
                        TextView tc10 = (TextView) rooview.findViewById(R.id.tv10);
                        TextView tc9 = (TextView) rooview.findViewById(R.id.tv9);
                        TextView tc12 = (TextView) rooview.findViewById(R.id.tv12);

                        tc9.setTextColor(Color.parseColor("#b3b3b3"));
                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }
                    else if(s2.getSelectedItem().toString().equals("Sem 6"))
                    {
                        cc(rooview);}
                    else if(s2.getSelectedItem().toString().equals("Sem 7"))
                    {
                        cc(rooview);}
                    else if(s2.getSelectedItem().toString().equals("Sem 8"))
                    {
                        cc(rooview);}
                }

                else if (s1.getSelectedItem().toString().equals("BT"))
                {

                    if(s2.getSelectedItem().toString().equals("Sem 1")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 2")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 3")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 4"))
                    {

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc9 = (TextView)rooview.findViewById(R.id.tv9);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc9.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 5")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 6")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));

                    }
                    else if(s2.getSelectedItem().toString().equals("Sem 7"))
                    {
                        cc(rooview);}
                    else if(s2.getSelectedItem().toString().equals("Sem 8"))
                    {
                        cc(rooview);}

                }

                else if (s1.getSelectedItem().toString().equals("ICE"))
                {

                    if(s2.getSelectedItem().toString().equals("Sem 1")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 2")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc11 = (TextView)rooview.findViewById(R.id.tv11);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc11.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 3")){

                        cc(rooview);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 4"))
                    {
                        cc(rooview);}

                    else if(s2.getSelectedItem().toString().equals("Sem 5")){

                        cc(rooview);
                        TextView tc9 = (TextView)rooview.findViewById(R.id.tv9);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);
                        TextView tc12 = (TextView)rooview.findViewById(R.id.tv12);

                        tc9.setTextColor(Color.parseColor("#b3b3b3"));
                        tc10.setTextColor(Color.parseColor("#b3b3b3"));
                        tc12.setTextColor(Color.parseColor("#b3b3b3"));
                    }

                    else if(s2.getSelectedItem().toString().equals("Sem 6")){

                        cc(rooview);
                        TextView tc9 = (TextView)rooview.findViewById(R.id.tv9);
                        TextView tc10 = (TextView)rooview.findViewById(R.id.tv10);

                        tc9.setTextColor(Color.parseColor("#b3b3b3"));
                        tc10.setTextColor(Color.parseColor("#b3b3b3"));

                    }
                    else if(s2.getSelectedItem().toString().equals("Sem 7"))
                    {
                        cc(rooview);}
                    else if(s2.getSelectedItem().toString().equals("Sem 8"))
                    {
                        cc(rooview);}


                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return rooview;
    }








    public void cc(View rv){

        TextView c1 = (TextView)rv.findViewById(R.id.tv1);
        TextView c2 = (TextView)rv.findViewById(R.id.tv2);
        TextView c3 = (TextView)rv.findViewById(R.id.tv3);
        TextView c4 = (TextView)rv.findViewById(R.id.tv4);
        TextView c5 = (TextView)rv.findViewById(R.id.tv5);
        TextView c6 = (TextView)rv.findViewById(R.id.tv6);
        TextView c7 = (TextView)rv.findViewById(R.id.tv7);
        TextView c8 = (TextView)rv.findViewById(R.id.tv8);
        TextView c9 = (TextView)rv.findViewById(R.id.tv9);
        TextView c10 = (TextView)rv.findViewById(R.id.tv10);
        TextView c11 = (TextView)rv.findViewById(R.id.tv11);
        TextView c12 = (TextView)rv.findViewById(R.id.tv12);

        c1.setTextColor(Color.parseColor("#01b29b"));
        c2.setTextColor(Color.parseColor("#01b29b"));
        c3.setTextColor(Color.parseColor("#01b29b"));
        c4.setTextColor(Color.parseColor("#01b29b"));
        c5.setTextColor(Color.parseColor("#01b29b"));
        c6.setTextColor(Color.parseColor("#01b29b"));
        c7.setTextColor(Color.parseColor("#01b29b"));
        c8.setTextColor(Color.parseColor("#01b29b"));
        c9.setTextColor(Color.parseColor("#01b29b"));
        c10.setTextColor(Color.parseColor("#01b29b"));
        c11.setTextColor(Color.parseColor("#01b29b"));
        c12.setTextColor(Color.parseColor("#01b29b"));



    }

    public void onSub(View b)
    {
        Intent i = new Intent(getActivity(),sub_load.class);
        startActivity(i);
    }

}
