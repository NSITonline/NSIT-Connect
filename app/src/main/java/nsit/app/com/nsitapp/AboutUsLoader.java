package nsit.app.com.nsitapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Kartik Kwatra on 27-08-2017.
 */

public class AboutUsLoader extends AsyncTaskLoader<List<AboutUsMember>> {
    public AboutUsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<AboutUsMember> loadInBackground() {
        List<AboutUsMember> teamMembers = AboutUsUtility.driver();
        return teamMembers;
    }
}
