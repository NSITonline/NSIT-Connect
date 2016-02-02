package nsit.app.com.nsitapp;

import android.content.res.Resources;

public class PreferenceKey {

    private static final Resources sResource = CRApplication.getContext().getResources();
    public static final String CODEFORCES_REMINDER = sResource.getString(R.string.pref_codeforces_reminder_key);
    public static final String CODECHEF_REMINDER = sResource.getString(R.string.pref_codechef_reminder_key);
    public static final String HACKERRANK_REMINDER = sResource.getString(R.string.pref_hackerrank_reminder_key);
    public static final String TOPCODER_REMINDER = sResource.getString(R.string.pref_topcoder_reminder_key);
    public static final String HACKEREARTH_REMINDER = sResource.getString(R.string.pref_hackerearth_reminder_key);
    public static final String URIOJ_REMINDER = sResource.getString(R.string.pref_urioj_reminder_key);
    public static final String UNKNOWN_REMINDER = sResource.getString(R.string.pref_unknown_reminder_key);

    public static final String REMINDER = sResource.getString(R.string.pref_reminder_key);

    public static final String REMINDER_FILTER = sResource.getString(R.string.pref_reminder_filter_title_key);

    public static final String REMINDER_VIBRATION = sResource.getString(R.string.pref_reminder_vibration_key);

}
