package nsit.app.com.nsitapp.view;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.sync.SyncAdapter;


public class contest_reminder extends FragmentActivity implements ContestListFragment.Callback{


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
             getIntent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // inside your activity (if you did not enable transitions in your theme)
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

            // set an exit transition
            getWindow().setEnterTransition(new Slide());
            getWindow().setReenterTransition(new Slide());
            getWindow().setExitTransition(new Fade());

        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contest_reminder);


        if (savedInstanceState == null) {
            Fragment fragment = new ContestFragment();

            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.
                    beginTransaction().
                    replace(R.id.content_frame,fragment).
                    commit();
            Log.v("we will win 44","we");
        }

        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActionBar().setElevation(0);
        }*/

        SyncAdapter.initializeSyncAdapter(this);

        Log.v("we will win 6","we");


      /*  boolean isReminderOn = PreferenceUtil.isReminderOn(this);

        if (!NotificationService.isAlarmOn(this) && isReminderOn) {
            NotificationService.startAlarm(this);
        }*/
    }

//restore menu main to its orignal empty and create a new menu called mnu mainer
   /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings :
                Intent i = new Intent(this,SettingsActivity.class);
                startActivity(i);
                return true;
        }

        return false;
    }

    @Override
    public void onItemSelected(Uri contestUri,ImageView logo) {
        Intent intent = new Intent(this, ContestDetailActivity.class);
        intent.setData(contestUri);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(this, logo, "logo");
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    public void onFilterChanged() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (fragment instanceof ContestFragment) {
            ((ContestFragment)fragment).onFilterChanged();
        }
    }
}
