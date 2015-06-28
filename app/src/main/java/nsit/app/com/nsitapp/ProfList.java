package nsit.app.com.nsitapp;

/**
 * Created by kamlesh kumar garg on 22-06-2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Swati garg on 22-06-2015.
 */


public class ProfList extends Fragment {
    EditText s;
    public static final String[] acro = new String[] { "ECE",
            "COE", "ICE", "MPAE", "IT", "BT","PCME"};

    public static final String[] titles = new String[] {
            "DIVISION OF ELECTRONICS & COMMUNICATION ENGG",
            "DIVISION OF COMPUTER ENGINEERING","DIVISION OF INFORMATION TECHNOLOGY", "DIVISION OF INSTRUMENTATION & CONTROL ENGG.",
            "DIVISION OF MANUFACTURING PROCESSES AND  AUTOMATION ENGINEERING", "DIVISION OF BIO-TECHNOLOGY","SCHOOL OF APPLIED SCIENCES"
    };

    public static final String[] eceprofs = new String[]{"Dr. Raj Senani, Professor &  Head","Dr. Harish Parthasarathy, Professor","Dr. Maneesha Gupta,  Professor","Mrs. Sujata Sengar, Associate Professor","Sh. D.V. Gadre, Associate Professor","Dr. Parul Garg, Associate Professor","Dr. S.P. Singh, Associate Professor","Dr. D.K. Upadhyay, Associate Professor","Dr. Jyotsna Singh, Assistant Professor","Dr. Tarun Rawat, Assistant Professor","Sh. Shailesh Mishra, Assistant Professor","Dr. Ankur Bansal, Assistant Professor","Sh. Kunwar Singh, Assistant Professor","Ms. Bhawna Aggarwal, Assistant Professor","Ms. Urvashi Bansal, Assistant Professor"};
    public static final String[] eceids = new String[]{"senani@nsit.ac.in","harishp@nsit.ac.in","maneesha@nsit.ac.in","sujata@nsit.ac.in","dvgadre@nsit.ac.in","parul@nsit.ac.in","spsingh@nsit.ac.in","NotAvailable","jyotsna@nsit.ac.in","tarun@nsit.ac.in","","","","",""};


    public static final String[] coeprofs = new String[] {"Prof. Shampa Chakraverty, Head","Dr. Sangeeta Sabharwal, Professor","Dr. M.P.S. Bhatia, Professor","Dr. Satish Chand, Professor","Sh. Rajiv Kumar, Associate Professor","Dr. Satbir Jain, Associate Professor","Dr. Ritu Sibal, Associate Professor","Sh. Kushil Kr. Saini, Assistant Professor","Dr. Bijender Kumar, Assistant Professor","Smt. Veenu, Assistant Professor","Smt. Sushma Nagpal, Assistant Professor","Dr. Anand Gupta, Assistant Professor","Smt. Preeti Kaur, Assistant Professor","Smt. Vijeta Mehra, Assistant Professor","Smt. Poonam Rani, Assistant Professor","Smt. Savita Yadav, Assistant Professor"};
    public static final String[] coeids = new String[] {"shampa@nsit.ac.in","ssab@nsit.ac.in","mpsbhatia@nsit.ac.in","satish@nsit.ac.in","","sjain@nsit.ac.in","rsb@nsit.ac.in","khushil@nsit.ac.in","bijender@nsit.ac.in","veenu@nsit.ac.in","sushma@nsit.ac.in","anand.gupta@nsit.ac.in","preeti@nsit.ac.in","","",""};


    public static final String[] iceprofs = new String[] {"Prof. A.P. Mittal, Head","Dr. J.R.P. Gupta, Professor","Dr. Smriti Srivastava, Professor","Sh. R.C. Thakur, Associate Professor","Dr. K.P.S. Rana, Associate Professor","Dr. Vijander Singh, Associate Professor","Smt. Asha Rani, Associate Professor","Smt. Piyush Saxena, Associate Professor","Dr. Prerna Gaur, Associate Professor","Dr. Vineet Kumar, Associate Professor","Smt. Pragya Varshney, Associate Professor","Sh. S.K. Jha, Assistant Professor","Dr. Rajneesh Sharma, Assistant Professor","Sh. A.N. Jha, Assistant Professor","Sh. Vicky Suri, Assistant Professor","Sh. Bhavnesh Kumar, Assistant Professor","Ms. Jyoti Yadav, Assistant Professor","Ms. Manisha, Assistant Professor","Sh. Hasmat, Assistant Professor","Sh. Anil Sangwan, Assistant Professor"};
    public static final String[] iceids = new String[] {"headice@nsit.ac.in","jrpgupta@nsit.ac.in","smriti@nsit.ac.in","rct@nsit.ac.in","kpsrana@nsit.ac.in","","asha.rani@nsit.ac.in","piyush@nsit.ac.in","prernagaur@nsit.ac.in","vineet@nsit.ac.in","pragya@nsit.ac.in","skjha@nsit.ac.in","rajneesh@nsit.ac.in","anjha@nsit.ac.in","vicky@nsit.ac.in","","","","",""};


    public static final String[] mpaeprofs = new String[] {"Prof. Sachin Maheshwari, Head","Dr. Sanjay Chak, Associate Professor","Dr. S.K.Jha, Associate Professor","Sh. D.K. Singh, Associate Professor","Dr. Vijayant Agarwal, Associate Professor","Sh. Sanjay Gupta, Assistant Professor","Sh. A.V. Muley, Assistant Professor","Sh. Pradeep Khanna, Assistant Professor","Sh. Aditya Kumar, Assistant Professor","Sh. Parmendra Kumar Bajpai, Assistant Professor","Sh. Umang Soni, Assistant Professor","Sh. Arvind Meena, Assistant Professor","Sh. Manish Kumar, Assistant Professor","Sh. Andriya Narasimhulu, Assistant Professor","Sh. Narendra Kumar, Assistant Professor","Sh. Abhishek Tevatia, Assistant Professor"};
    public static final String[] mpaeids = new String[] {"sachin@nsit.ac.in","skchak@nsit.ac.in","shailendra@nsit.ac.in","dksingh@nsit.ac.in","vijayant@nsit.ac.in","sgupta@nsit.ac.in","avmuley@nsit.ac.in","pradeep@nsit.ac.in","aditya@nsit.ac.in","pramendra.bajpai@nsit.ac.in","umang.soni@nsit.ac.in","arvind.meena@nsit.ac.in","manish.kumar@nsit.ac.in","andriya@nsit.ac.in","narender.kumar@nsit.ac.in","abhishek.tevatia@nsit.ac.in"};


    public static final String[] itprofs = new String[] {"Prof.  Sangeeta Sabharwal, Head","Dr. S.K. Dhurandher, Associate Professor ","Smt. Amarjit Malhotra, Assistant Professor","Sh. Devender Kumar, Assistant Professor"};
    public static final String[] itids = new String[] {"ssab@nsit.ac.in","","",""};


    public static final String[] btprofs = new String[] {"Prof. A.K. Dubey, Head","Dr. Sonika Bhatnagar, Assistant Professor","Sh. Krishan Kumar. P.A. to HOD (BT)"};
    public static final String[] btids = new String[] {"headappsc@nsit.ac.in","sbhatnagar@nsit.ac.in",""};


    public static final String[] pcmeprofs = new String[] {"Prof. Vijay Gupta, Head, Mathematics","Dr. J.K. Misra, Associate Professor, Mathematics","Dr. Mamta Misra, Associate Professor, Mathematics","Dr. Jasobanta Jena, Associate Professor, Mathematics","Dr. J.K. Singh, Assistant Professor, Mathematics","Dr. Neeraj Kumar, Assistant Professor, Mathematics","Prof. O.P.Thakur, Head, Physics","Dr. Ranjana Jha, Associate Professor, Physics","Dr. Sanjeev Thakur, Associate Professor, Head, Chemistry","Dr. Anjana Sarkar, Assistant Professor, Chemistry","Dr. Purnima Jain, Assistant Professor, Chemistry","Dr. Tanushree Choudhary, Assistant Professor, Head, Humanities and Social Sciences","Dr. Duru Arun Kumar, Assistant Professor, Humanities and Social Sciences","Dr. Prasanta Kumar Bhuyan, Assistant Professor, Humanities and Social Sciences","Sh. Pankaj Deshwal, Assistant Professor, Humanities and Social Sciences"};
    public static final String[] pcmeids = new String[] {"vijay@nsit.ac.in","jkmishra@nsit.ac.in","mmishra@nsit.ac.in","jjena@nsit.ac.in","jksingh@nsit.ac.in","neeraj@nsit.ac.in","opthakur@nsit.ac.in","ranjana@nsit.ac.in","sanjeevthakur@nsit.ac.in","anjana@nsit.ac.in","purnima@nsit.ac.in","tanushree@nsit.ac.in","darun@nsit.ac.in","",""};



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Activity activity;
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_proflist, container, false);
        Bundle i = this.getArguments();
       int dept = i.getInt("dept", 0);


        s = (EditText) rootView.findViewById(R.id.search);
s.setVisibility(View.GONE);
        ListView listView;
        listView = (ListView) rootView.findViewById(R.id.profListView);
        listView.setTextFilterEnabled(true);
        TextView tv = (TextView) rootView.findViewById(R.id.textView);

        List<ProfListRowItem> eceItems;
        List<ProfListRowItem> coeItems;
        List<ProfListRowItem> iceItems;
        List<ProfListRowItem> mpaeItems;
        List<ProfListRowItem> itItems;
        List<ProfListRowItem> btItems;
        List<ProfListRowItem> pcmeItems;


        eceItems = new ArrayList<ProfListRowItem>();
        coeItems = new ArrayList<ProfListRowItem>();
        iceItems = new ArrayList<ProfListRowItem>();
        mpaeItems = new ArrayList<ProfListRowItem>();
        itItems = new ArrayList<ProfListRowItem>();
        btItems = new ArrayList<ProfListRowItem>();
        pcmeItems = new ArrayList<ProfListRowItem>();

        final ProfListCustomListViewAdapter adapter;
        switch (dept) {
            case 0:
                tv.setText(titles[dept]);

                for (int j = 0; j < eceprofs.length; j++) {
                    ProfListRowItem item = new ProfListRowItem(eceprofs[j],eceids[j]);
                    eceItems.add(item);}
                    adapter = new ProfListCustomListViewAdapter(getActivity(), R.layout.prof_list_item, eceItems);
                    listView.setAdapter(adapter);


                break;
            case 1:
                tv.setText(titles[dept]);

                for (int j = 0; j < coeprofs.length; j++) {
                    ProfListRowItem item = new ProfListRowItem(coeprofs[j],coeids[j]);
                    coeItems.add(item);}
                     adapter = new ProfListCustomListViewAdapter(getActivity(),
                            R.layout.prof_list_item, coeItems);
                    listView.setAdapter(adapter);


                break;
            case 2:
                tv.setText(titles[dept]);

                for (int j = 0; j < itprofs.length; j++) {
                    ProfListRowItem item = new ProfListRowItem(itprofs[j],itids[j]);
                    itItems.add(item);}
                adapter = new ProfListCustomListViewAdapter(getActivity(),
                        R.layout.prof_list_item, itItems);
                listView.setAdapter(adapter);


                break;
            case 3:
                tv.setText(titles[dept]);

                for (int j = 0; j < iceprofs.length; j++) {
                    ProfListRowItem item = new ProfListRowItem(iceprofs[j],iceids[j]);
                    iceItems.add(item);}
                    adapter = new ProfListCustomListViewAdapter(getActivity(),
                            R.layout.prof_list_item, iceItems);
                    listView.setAdapter(adapter);


                break;
            case 4:
                tv.setText(titles[dept]);

                for (int j = 0; j < mpaeprofs.length; j++) {
                    ProfListRowItem item = new ProfListRowItem(mpaeprofs[j],mpaeids[j]);
                    mpaeItems.add(item);}
                     adapter = new ProfListCustomListViewAdapter(getActivity(),
                            R.layout.prof_list_item, mpaeItems);
                    listView.setAdapter(adapter);


                break;

            case 5:
                tv.setText(titles[dept]);

                for (int j = 0; j < btprofs.length; j++) {
                    ProfListRowItem item = new ProfListRowItem(btprofs[j],btids[j]);
                    btItems.add(item);}
                   adapter = new ProfListCustomListViewAdapter(getActivity(),
                            R.layout.prof_list_item, btItems);
                    listView.setAdapter(adapter);


                break;
            case 6:
                tv.setText(titles[dept]);

                for (int j = 0; j < pcmeprofs.length; j++) {
                    ProfListRowItem item = new ProfListRowItem(pcmeprofs[j],pcmeids[j]);
                    pcmeItems.add(item);}
                   adapter = new ProfListCustomListViewAdapter(getActivity(),
                            R.layout.prof_list_item, pcmeItems);
                    listView.setAdapter(adapter);



                break;
        }

        final ProfListCustomListViewAdapter adapter2= new ProfListCustomListViewAdapter(getActivity(), R.layout.prof_list_item, eceItems);
        s.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
              //
              //  adapter2.getFilter().filter(s.toString());
                Log.e("vgsves"," "+s.toString());
            }
        });


    return rootView;
    }



}
