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
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.sync.SyncAdapter;

public class CodeRadarActivity extends FragmentActivity implements ContestListFragment.Callback {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        getIntent();
        setTitle("Code Radar");
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

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.
                    beginTransaction().
                    replace(R.id.content_frame, fragment).
                    commit();
        }

        try {
            SyncAdapter.initializeSyncAdapter(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public void onItemSelected(Uri contestUri, ImageView logo) {
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
            ((ContestFragment) fragment).onFilterChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
