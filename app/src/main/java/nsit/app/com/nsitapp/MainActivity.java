package nsit.app.com.nsitapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    ListView lv;
    private ActionBarDrawerToggle mDrawerToggle;
    Boolean Nsitonline,Collegespace,Crosslinks,Junoon,Bullet,Rotaract;
    static final String[] sideitems = new String[] { "Home" , "My Feed","Video","Calendar" , "Item 5","About" };	//items on navigation drawer
    SwipeRefreshLayout swipeLayout;
    List<String> list = new ArrayList<String>();
    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list5 = new ArrayList<String>();
    List<String> list6 = new ArrayList<String>();
    List<String> list7 = new ArrayList<String>();
    Integer[] imageId = {
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent i = getIntent();


        Nsitonline = i.getBooleanExtra("nsitonline",false);
        Crosslinks = i.getBooleanExtra("crosslinks",false);
        Collegespace= i.getBooleanExtra("collegespace",false);
        Bullet = i.getBooleanExtra("bullet",false);
        Junoon = i.getBooleanExtra("junoon",false);
        Rotaract = i.getBooleanExtra("rotaract",false);


        if(Nsitonline)
            new DownloadWebPageTask2(Val.id_nsitonline).execute();
        if(Crosslinks)
            new DownloadWebPageTask2(Val.id_crosslinks).execute();
        if(Collegespace)
            new DownloadWebPageTask2(Val.id_collegespace).execute();
        if(Bullet)
            new DownloadWebPageTask2(Val.id_bullet).execute();
        if(Junoon)
            new DownloadWebPageTask2(Val.id_junoon).execute();
        if(Rotaract)
            new DownloadWebPageTask2(Val.id_rotaract).execute();



        lv = (ListView) findViewById(R.id.list);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);




        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);



        //All for navigation drawer


        CustomList2 adapter2 = new CustomList2(this, sideitems, imageId);
        mDrawerList.addHeaderView(new View(this));
        mDrawerList.addFooterView(new View(this));
        mDrawerList.setAdapter(adapter2);

/*        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.side_panel, sideitems));*/
        mDrawerToggle = new ActionBarDrawerToggle(

                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                toolbar,  /* navigation drawer icon to replace 'Up' caret */
                R.string.app_name,  /* "open drawer" description */
                R.string.app_name  /* "close drawer" description */
        ) ;

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "Position : " + position + " Clicked ", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                changeItem(position);
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("  Welcome");
        getSupportActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
    }

    @Override
    public void onRefresh() {
        //new DownloadWebPageTask2().execute();
        swipeLayout.setRefreshing(false);

    }

    String text;


    private class DownloadWebPageTask2 extends AsyncTask<String, Void, String> {


        String id;

        public DownloadWebPageTask2(String id) {
            this.id = id;
        }


        @Override
        protected String doInBackground(String... urls) {

            Log.e("Yo", "Started");
            String URL;
            if(id==Val.id_junoon)
                URL = "https://graph.facebook.com/"+id+"/feed?access_token=" + Val.common_access;

            else
                URL = "https://graph.facebook.com/"+id+"/feed?since=0000&until=1234567899999999999990&access_token=" + Val.common_access;
            HttpClient Client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                text = Client.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(String result) {
            Log.e("YO", "Done");
            Log.e("yrs",""+text);

            int j=0;
            JSONObject ob;
            JSONArray arr;
            try {
                ob = new JSONObject(text);
                arr = ob.getJSONArray("data");


                Log.e("yo", " " + arr + arr.length());
                for(int i = 0; i < arr.length(); i++){
                    try {
                        if(arr.getJSONObject(i).has("message")&&arr.getJSONObject(i).has("picture")&&arr.getJSONObject(i).has("link")&&arr.getJSONObject(i).has("likes")) {
                            list.add(arr.getJSONObject(i).getString("message"));
                            //   Log.e("YOLO", "Message : " + i + " " + arr.getJSONObject(i).getString("message"));

                        }
                        else {
                            continue;
                        }
                        if(!(arr.getJSONObject(i).has("object_id")))
                            list1.add(null);
                        else
                            list1.add(arr.getJSONObject(i).getString("object_id"));



                        if(arr.getJSONObject(i).has("picture")) {
                            list6.add(arr.getJSONObject(i).getString("picture"));
                            // Log.e("yo","Picture  " +i+ arr.getJSONObject(i).getString("picture"));
                        }
                        else
                            list6.add(null);
                        if(arr.getJSONObject(i).has("link")) {
                            list7.add(arr.getJSONObject(i).getString("link"));
                            // Log.e("yo", "link " + i+ arr.getJSONObject(i).getString("link"));
                        }
                        else
                            list7.add(null);
                        if(arr.getJSONObject(i).has("likes")) {
                            String s = arr.getJSONObject(i).getString("likes");
                            JSONObject o = new JSONObject(s);
                            JSONArray a2 = o.getJSONArray("data");
                            list2.add(Integer.toString(a2.length()));   //No of likes
                        }
                        else
                            list2.add("0");

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        Log.e("Error","Errror at : " + i + " "+e.getMessage());
                    }
                }



            } catch (Exception e) {

            }

            switch(id)
            {
                case Val.id_nsitonline : Nsitonline=false;break;
                case Val.id_collegespace :Collegespace=false;break;
                case Val.id_crosslinks : Crosslinks=false;break;
                case Val.id_bullet : Bullet=false;break;
                case Val.id_junoon : Junoon=false;break;
                case Val.id_rotaract : Rotaract=false;break;
            }

            done();

            Log.e("Yo", text);
        }
    }



    public void done()
    {
        if(!Nsitonline&&!Collegespace&&!Crosslinks&&!Bullet&&!Junoon&&!Rotaract) {
            String[] id = new String[list.size()];
            String[] des = new String[list.size()];
            String[] pic = new String[list.size()];
            String[] like = new String[list.size()];
            String[] link = new String[list.size()];


            des = list.toArray(des);
            like = list2.toArray(like);
            id = list1.toArray(id);
            pic = list6.toArray(pic);
            link = list7.toArray(link);


            swipeLayout.setRefreshing(false);
            CustomList adapter = new CustomList(MainActivity.this, pic, des, like, link, id);
            lv.addHeaderView(new View(MainActivity.this));
            lv.addFooterView(new View(MainActivity.this));
            lv.setAdapter(adapter);
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void changeItem(int position){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        // Locate Position
        switch (position) {
            case 1:
                    // TODO@Swati: Implement Home as a fragment and add it here.
//
//                Fragment f = new Home();
//                ft.replace(R.id.drawer_layout, f);
//                getSupportActionBar().setTitle("Home");
                break;

            case 3:
                Fragment f = new Video();
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("Video");
                break;
        }
        ft.commit();
        //drawerListView.setItemChecked(position, true);
        setTitle("Title");
        //drawerLayout.closeDrawer(drawerListView);
    }
}
