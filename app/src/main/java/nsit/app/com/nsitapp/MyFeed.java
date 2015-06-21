package nsit.app.com.nsitapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

public class MyFeed extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    static final String[] sideitems = new String[] { "Item 1" , "Item 2","Item 3","Item 4" , "Item 5","Item 6" };	//items on navigation drawer
    Integer[] imageId = {
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10,
            R.drawable.ic_action_star_10};
    CheckBox nsitonline,collegespace,crosslinks,junoon,bullet,rotaract;
    Boolean Nsitonline,Collegespace,Crosslinks,Junoon,Bullet,Rotaract;
    TextView tNsitonline,tCollegespace,tCrosslinks,tJunoon,tBullet,tRotaract;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_feed);


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        next = (Button) findViewById(R.id.next);
        nsitonline = (CheckBox) findViewById(R.id.check_nsitonline);
        collegespace = (CheckBox) findViewById(R.id.check_collegespace);
        crosslinks = (CheckBox) findViewById(R.id.check_crosslinks);
        junoon = (CheckBox) findViewById(R.id.check_junoon);
        rotaract = (CheckBox) findViewById(R.id.check_rotaract);
        bullet = (CheckBox) findViewById(R.id.check_bullet);
        tNsitonline = (TextView) findViewById(R.id.stars_nsitonline);
        tCollegespace = (TextView) findViewById(R.id.stars_collegespace);
        tCrosslinks = (TextView) findViewById(R.id.stars_crosslinks);
        tJunoon = (TextView) findViewById(R.id.stars_junoon);
        tRotaract = (TextView) findViewById(R.id.stars_rotaract);
        tBullet = (TextView) findViewById(R.id.stars_bullethawk);

        nsitonline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Nsitonline = b;
            }
        });
        crosslinks.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Crosslinks = b;
            }
        });
        collegespace.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Collegespace = b;
            }
        });
        bullet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Bullet = b;
            }
        });
        junoon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Junoon = b;
            }
        });
        rotaract.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {Rotaract = b;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyFeed.this, MainActivity.class);
                i.putExtra("nsitonline", Nsitonline);
                i.putExtra("crosslinks", Crosslinks);
                i.putExtra("collegespace", Collegespace);
                i.putExtra("bullet", Bullet);
                i.putExtra("junoon", Junoon);
                i.putExtra("rotaract", Rotaract);
                startActivity(i);
            }
        });


        new Calclike(tNsitonline,Val.id_nsitonline).execute();
        new Calclike(tCrosslinks,Val.id_crosslinks).execute();
        new Calclike(tCollegespace,Val.id_collegespace).execute();
        new Calclike(tJunoon,Val.id_junoon).execute();
        new Calclike(tBullet,Val.id_bullet).execute();
        new Calclike(tRotaract,Val.id_rotaract).execute();



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
                Toast.makeText(MyFeed.this, "Position : " + position + " Clicked ", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("My Feed");
        getSupportActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
    }




    String text;
    private class Calclike extends AsyncTask<String, Void, String> {
        TextView bmImage;
        String id;

        public Calclike(TextView bmImage,String id) {
            this.bmImage = bmImage;
            this.id = id;
        }

        @Override
        protected String doInBackground(String... urls) {

            Log.e("Yo", "Started");
            String URL = "https://graph.facebook.com/"+id+"?access_token=" + Val.common_access;
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
            //pd.dismiss();
            //Toast.makeText(MainActivity.this,"Response : " + text , Toast.LENGTH_LONG).show();
            Log.e("yrs", text);

            int j = 0;
            JSONObject ob;
            JSONArray arr;
            try {
                ob = new JSONObject(text);
                if(ob.has("likes"))
                text = ob.getString("likes");
                else
                    text="1000";
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
            }
            bmImage.setText(text);
        }
    }




                @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_feed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
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
}
