package nsit.app.com.nsitapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import nsit.app.com.nsitapp.PushNotification.MyAlarmReceiver;
import nsit.app.com.nsitapp.R;

/**
 * Created by AGGARWAL'S on 3/27/2016.
 */
public class NotificationSettings extends AppCompatActivity {

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getFragmentManager().beginTransaction().addToBackStack(null).replace(android.R.id.content, new PrefSync(this)).commit();

    }

    @SuppressLint("ValidFragment")
    public static class PrefSync extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

        private Context mContext;

        @SuppressLint("ValidFragment")
        public PrefSync(Context context){
            super();
            mContext = context;
        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_notification_settings);
            PreferenceManager.getDefaultSharedPreferences(getActivity()).registerOnSharedPreferenceChangeListener(this);
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            boolean status = sharedPreferences.getBoolean("notification_status", false);
            ListPreference p = (ListPreference)findPreference("notify_sync_settings");
            if (!status){
                p.setEnabled(false);
            }else
                p.setEnabled(true);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            switch (key){
                case "notification_status":boolean status = sharedPreferences.getBoolean(key,false);
                    ListPreference p = (ListPreference)findPreference("notify_sync_settings");
                                           if (!status){
                                               p.setEnabled(false);
                                               Intent intent = new Intent(mContext, MyAlarmReceiver.class);
                                               final PendingIntent pIntent = PendingIntent.getBroadcast(mContext, MyAlarmReceiver.REQUEST_CODE,
                                                       intent, PendingIntent.FLAG_UPDATE_CURRENT);
                                               AlarmManager alarm = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
                                               alarm.cancel(pIntent);
                                           }else
                                               p.setEnabled(true);
                    break;
            }
        }
    }

}
