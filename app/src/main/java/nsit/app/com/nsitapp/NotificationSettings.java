package nsit.app.com.nsitapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

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

        private final Context mContext;
        @SuppressLint("ValidFragment")
        public PrefSync(Context context) {
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
            ListPreference p = (ListPreference) findPreference("notify_sync_settings");
            if (!status) {
                p.setEnabled(false);
            } else
                p.setEnabled(true);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            switch (key) {
                case "notification_status":
                    boolean status = sharedPreferences.getBoolean(key, false);
                    break;
            }
        }
    }

}
