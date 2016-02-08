package nsit.app.com.nsitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import nsit.app.com.nsitapp.view.contest_reminder;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    ListView lv;
    private ActionBarDrawerToggle mDrawerToggle;
    static final String[] sideitems = new String[]{"Home", "My Feed", "Video", "TimeTable", "Locations",
            "Calculator", "CodeRadar", "Professors", "Feedback", "About Us"};    //items on navigation drawer
    SwipeRefreshLayout swipeLayout;
    Fragment current;


    Integer[] imageId = {
            R.drawable.ic_action_home,
            R.drawable.ic_action_tiles_large,
            R.drawable.ic_action_video,
            R.drawable.ic_action_calendar_month,
            R.drawable.ic_action_location,
            R.drawable.ic_format_list_numbered_black_24dp,
            R.drawable.ic_laptop_mac_black_24dp,
            R.drawable.ic_action_user,
            R.drawable.ic_feedback_black_24dp,
            R.drawable.ic_action_info};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setProgressBarIndeterminateVisibility(false);


        if(savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment f = new Home();
            current = f;
            ft.replace(R.id.content_frame, f);
            getSupportActionBar().setTitle("Home");
            ft.commit();
        }
        lv = (ListView) findViewById(R.id.list);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);


        //All for navigation drawer
        DrawerList_Adapter adapter2 = new DrawerList_Adapter(this, sideitems, imageId);
        mDrawerList.setAdapter(adapter2);
        try {
            mDrawerToggle = new ActionBarDrawerToggle(
                    this,                  /* host Activity */
                    mDrawerLayout,         /* DrawerLayout object */
                    toolbar,  /* navigation drawer icon to replace 'Up' caret */
                    R.string.app_name,  /* "open drawer" description */
                    R.string.app_name  /* "close drawer" description */
            );
        } catch (Exception e) {
        }
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                changeItem(position);
            }
        });

        try {
            mDrawerLayout.setDrawerListener(mDrawerToggle);
        } catch (Exception e) {

        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
        try {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, current);
            ft.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeItem(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Intent i;
        Fragment f = null;
        switch (position + 1) {
            case 1:
                f = new Home();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("Home");
                break;
            case 2:
                f = new FinalFeed();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("My Feed");
                break;
            case 3:
                f = new Video();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("Video");
                break;
            case 4:
                f = new Calender();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("Time Table");
                break;
            case 5:
                f = new Hangouts();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("Hangouts");
                break;
            case 6:
                f = new CalculatorActivity();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("Calculator");
                break;
            case 7:
                i = new Intent(this, contest_reminder.class);
                startActivity(i);
                break;
            case 8:
                f = new Professors();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("Professors List");
                break;
            case 9:
                f = new Feedback();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("Feedback");
                break;
            case 10:
                f = new AboutUs();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("About Us");
                break;
        }
        current = f;
        ft.commit();
    }


    public class DrawerList_Adapter extends ArrayAdapter<String> {
        private final Activity context;
        private final String[] web;
        private boolean isSpeakButtonLongPressed;
        private final Integer[] imageId;

        public DrawerList_Adapter(Activity context, String[] web, Integer[] imageId) {
            super(context, R.layout.message, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;
        }

        private class ViewHolder {
            TextView t1;
            ImageView imag;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder holder = null;
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                view = mInflater.inflate(R.layout.message, null);
                holder = new ViewHolder();
                holder.t1 = (TextView) view.findViewById(R.id.textView1);
                holder.imag = (ImageView) view.findViewById(R.id.imageView1);
                view.setTag(holder);
            } else
                holder = (ViewHolder) view.getTag();
            holder.t1.setText(web[position]);
            holder.imag.setImageResource(imageId[position]);
            return view;
        }
    }
}
