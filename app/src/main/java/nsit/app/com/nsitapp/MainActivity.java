package nsit.app.com.nsitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import nsit.app.com.nsitapp.AboutUs.AboutUsFragment;
import nsit.app.com.nsitapp.Calendar.Calendar;
import nsit.app.com.nsitapp.Hangout.Hangouts;
import nsit.app.com.nsitapp.professor.ProfessorsFragment;
import nsit.app.com.nsitapp.view.CodeRadarActivity;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private static final String[] sideitems = new String[]{"Home", "Video", "TimeTable", "Locations",
            "Calculator", "CodeRadar", "Professors", "Feedback", "About Us"};    //items on navigation drawer
    private Fragment current;
    public static Context appContext;

    private final Integer[] imageId = {
            R.drawable.ic_action_home,
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
        appContext = getApplicationContext();
        setProgressBarIndeterminateVisibility(false);

        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment f = new Home();
            current = f;
            ft.replace(R.id.content_frame, f);
            getSupportActionBar().setTitle(sideitems[0]);
            ft.commit();
        }
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ListView mDrawerList = findViewById(R.id.left_drawer);

        //All for navigation drawer
        DrawerListAdapter adapter2 = new DrawerListAdapter(this, imageId);
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
            e.printStackTrace();
        }
        mDrawerList.setOnItemClickListener((parent, view, position, id) -> {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
            changeItem(position);
        });

        try {
            mDrawerLayout.setDrawerListener(mDrawerToggle);
        } catch (Exception e) {
            e.printStackTrace();

        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(R.string.prompt_exit)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, (dialog, id) -> finish())
                .setNegativeButton(R.string.no, null)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
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
                break;
            /*case 2:
                f = new FinalFeed();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ft.replace(R.id.content_frame, f);
                getSupportActionBar().setTitle("My Feed");
                break;*/
            case 2:
                f = new Video();
                break;
            case 3:
                f = new Calendar();
                break;
            case 4:
                f = new Hangouts();
                break;
            case 5:
                f = new CalculatorActivity();
                break;
            case 6:
                i = new Intent(this, CodeRadarActivity.class);
                startActivity(i);
                break;
            case 7:
                f = new ProfessorsFragment();
                break;
            case 8:
                f = new Feedback();
                break;
            case 9:
                f = new AboutUsFragment();
                break;
        }
        current = f;
        if (f != null) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.replace(R.id.content_frame, f);
            String title = sideitems[position];
            getSupportActionBar().setTitle(title);
        }
        ft.commit();
    }


    public class DrawerListAdapter extends ArrayAdapter<String> {
        private final Activity context;
        private final String[] web;
        private final Integer[] imageId;

        DrawerListAdapter(Activity context, Integer[] imageId) {
            super(context, R.layout.message, MainActivity.sideitems);
            this.context = context;
            this.web = MainActivity.sideitems;
            this.imageId = imageId;
        }

        class ViewHolder {
            @BindView(R.id.textView1) TextView text;
            @BindView(R.id.imageView1) ImageView imag;
            ViewHolder(View view){
                ButterKnife.bind(this, view);
            }
        }

        @NonNull
        @Override
        public View getView(int position, View view, @NonNull ViewGroup parent) {
            ViewHolder holder;
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                view = mInflater.inflate(R.layout.message, parent, false);
                holder = new ViewHolder(view);
//                holder.text = view.findViewById(R.id.textView1);
//                holder.imag = view.findViewById(R.id.imageView1);
                view.setTag(holder);
            } else
                holder = (ViewHolder) view.getTag();
            holder.text.setText(web[position]);
            holder.imag.setImageResource(imageId[position]);
            return view;
        }
    }
}