package nsit.app.com.nsitapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Nitish Kumar on 27-08-2017.
 */

public class aboutUs_loader extends AsyncTaskLoader<List<AboutUsMember>> {
    public aboutUs_loader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<AboutUsMember> loadInBackground() {
        List<AboutUsMember> teamMembers = aboutUs_utility.driver();
        return teamMembers;
    }
}
