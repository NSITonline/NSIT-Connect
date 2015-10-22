package nsit.app.com.nsitapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;



public class usr_list extends ActionBarActivity {



    ArrayList<JudgeGroup> Judges = new ArrayList<>();
    public ExpandableListView listView;
    ExpandableListAdapter listAdapter;



    public static User_Info.User Contents =User_Info.user_info;

    public void populateList(ArrayList<JudgeGroup> Items) {
        FillGroupsList();
        listAdapter = new CodeRadarList_Adapter(this,Items,null);
        listView.setAdapter(listAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_code_radar);
        listView = (ExpandableListView) findViewById(R.id.CodeRadar_list);
        populateList(Judges);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_usr_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        if (item.getItemId() == android.R.id.home) {
            finish();

        }

        return super.onOptionsItemSelected(item);
    }



    public void FillGroupsList() {
        ArrayList<String> Handle = new ArrayList<>();
        ArrayList<String> Email = new ArrayList<>();
        ArrayList<String> FirstName = new ArrayList<>();
        ArrayList<String> LastName = new ArrayList<>();
        ArrayList<String> Country = new ArrayList<>();
        ArrayList<String>  City = new ArrayList<>();
        ArrayList<String>  Organization = new ArrayList<>();
        ArrayList<String>  Contribution = new ArrayList<>();
        ArrayList<String> Rank = new ArrayList<>();
        ArrayList<String> Rating = new ArrayList<>();
        ArrayList<String> MaxRank = new ArrayList<>();
        ArrayList<String> MaxRating= new ArrayList<>();





        Handle.add(Contents.handle);
        Email.add(Contents.email);
        FirstName.add(Contents.firstName);
        LastName.add(Contents.lastName);
        Country.add(Contents.country);
        City.add(Contents.city);
        Organization.add(Contents.organization);
        Contribution.add(Integer.toString(Contents.contribution));
        Rank.add(Contents.rank);
        Rating.add(Integer.toString(Contents.rating));
        MaxRank.add(Contents.maxRank);
        MaxRating.add(Integer.toString(Contents.maxRating));







        JudgeGroup NSITGroup;
        Log.v("MADE IN INDIA", "13");
       if(Handle.get(0)!=null)
       { NSITGroup = new JudgeGroup("Handle", "Handle", Handle);
        this.Judges.add(NSITGroup);}
        if(Email.get(0)!=null)
        {NSITGroup=new JudgeGroup("Email", "Email",Email);
        this.Judges.add(NSITGroup);}
        if(FirstName.get(0)!=null)
        {NSITGroup=new JudgeGroup("First Name", "FirstName",FirstName);
        this.Judges.add(NSITGroup);}
        if(LastName.get(0)!=null)
        {NSITGroup=new JudgeGroup("Last Name", "Last Name ",LastName);
        this.Judges.add(NSITGroup);}
        if(Country.get(0)!=null)
        {NSITGroup=new JudgeGroup("Country", "Country",Country);
        this.Judges.add(NSITGroup);}
        if(City.get(0)!=null)
        {NSITGroup=new JudgeGroup("City", "City",City);
        this.Judges.add(NSITGroup);}
        if(Organization.get(0)!=null)
        {NSITGroup=new JudgeGroup("Organization", "Organization",Organization);
        this.Judges.add(NSITGroup);}
        NSITGroup=new JudgeGroup("Contribution", "Contribution",Contribution);
        this.Judges.add(NSITGroup);
        NSITGroup=new JudgeGroup("Rank", "Rank",Rank);
        this.Judges.add(NSITGroup);
        NSITGroup=new JudgeGroup("Rating", "Rating",Rating);
        this.Judges.add(NSITGroup);
        NSITGroup=new JudgeGroup("MaxRank", "MaxRank",MaxRank);
        this.Judges.add(NSITGroup);
        NSITGroup=new JudgeGroup("MaxRating", "MaxRating",MaxRating);
        this.Judges.add(NSITGroup);



    }

}
