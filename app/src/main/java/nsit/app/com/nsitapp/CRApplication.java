package nsit.app.com.nsitapp;

import android.app.Application;
import android.content.Context;

/**

 * This class is created to provide Context object for every class.
 * For example to get resources in string.xml. We can call App.getContext().getResources() and so on.
 */
public class CRApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }

    public static Context getContext() {
        return mContext;
    }
}
