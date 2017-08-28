package nsit.app.com.nsitapp.PushNotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by AGGARWAL'S on 3/25/2016.
 */
public class MyAlarmReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "nsit.app.com.nsitapp.PushNotification.MyAlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("Alarm Manger", "Service About To start");
        Intent i = new Intent(context, MyNotifiactionService.class);
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected())
            context.startService(i);

    }


}
