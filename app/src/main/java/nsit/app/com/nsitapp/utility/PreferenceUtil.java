package nsit.app.com.nsitapp.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import nsit.app.com.nsitapp.PreferenceKey;
import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.model.OnlineJudge;

public class PreferenceUtil {

    public static boolean isReminderOn(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int minutes= Integer.parseInt(sharedPreferences.getString(String.valueOf(R.string.pref_reminder_key), "180"));
        return minutes != -1;
    }

    public static int getReminderValue(Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int minutes =Integer.parseInt(sharedPreferences.getString(String.valueOf(R.string.pref_reminder_key),"180"));
        return minutes;

    }

    public static boolean isReminderOn(Context context, String ojName) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean isReminderOn = false;
        if (ojName.equals(OnlineJudge.CODEFORCES)) {
            isReminderOn = sharedPreferences.getBoolean(PreferenceKey.CODEFORCES_REMINDER,true);
        } else if (ojName.equals(OnlineJudge.CODECHEF)){
            isReminderOn = sharedPreferences.getBoolean(PreferenceKey.CODECHEF_REMINDER,true);
        } else if (ojName.equals(OnlineJudge.TOPCODER)) {
            isReminderOn = sharedPreferences.getBoolean(PreferenceKey.TOPCODER_REMINDER,true);
        } else if (ojName.equals(OnlineJudge.HACKERRANK)) {
            isReminderOn = sharedPreferences.getBoolean(PreferenceKey.HACKERRANK_REMINDER,true);
        } else if (ojName.equals(OnlineJudge.HACKEREARTH)) {
            isReminderOn = sharedPreferences.getBoolean(PreferenceKey.HACKEREARTH_REMINDER,true);
        } else if (ojName.equals(OnlineJudge.URIOJ)) {
            isReminderOn = sharedPreferences.getBoolean(PreferenceKey.URIOJ_REMINDER,true);
        } else if (ojName.equals(OnlineJudge.UNKNOWN)) {
            isReminderOn = sharedPreferences.getBoolean(PreferenceKey.UNKNOWN_REMINDER,true);
        }
        return isReminderOn;
    }


}
