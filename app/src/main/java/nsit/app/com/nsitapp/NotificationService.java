package nsit.app.com.nsitapp;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import nsit.app.com.nsitapp.data.ContestContract;
import nsit.app.com.nsitapp.model.OnlineJudge;
import nsit.app.com.nsitapp.utility.PreferenceUtil;
import nsit.app.com.nsitapp.utility.TimeUtil;

/**
 * Created by saisumit on 5/29/15.
 */
public class NotificationService extends IntentService {

    private static final String NAME = NotificationService.class.getSimpleName();
    private static final int NOTIFICATION_MILLIS = 30 * 60 * 1000;

    private int currentNotificationId = 0;

    private static final int MAX_NOTIFICATION = 10;

    private static final String[] CONTEST_COLUMNS = {
            ContestContract.ContestEntry._ID,
            ContestContract.ContestEntry.COLUMN_TITLE,
            ContestContract.ContestEntry.COLUMN_SOURCE,
            ContestContract.ContestEntry.COLUMN_START_TIME
    };

    static final int COL_CONTEST_ID = 0;
    static final int COL_CONTEST_TITLE = 1;
    static final int COL_CONTEST_SOURCE = 2;
    static final int COL_CONTEST_START_TIME = 3;

    public NotificationService() {
        super(NAME);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("DEBUG","NotificationService.onHandleIntent()");
        Cursor cursor = getContentResolver().query(ContestContract.ContestEntry.CONTENT_URI,
                CONTEST_COLUMNS,
                null,
                null,
                null);


        long notificationMillis = PreferenceUtil.getReminderValue(this) * 60 * 1000;

        long earliestTime = -1;

        while(cursor!= null && cursor.moveToNext()) {
            long contestStartTime = cursor.getLong(COL_CONTEST_START_TIME);
            long currentTime = System.currentTimeMillis();
            if (contestStartTime - notificationMillis > currentTime) {
                if (earliestTime == -1) {
                    earliestTime = contestStartTime;
                } else if (contestStartTime < earliestTime) {
                    earliestTime = contestStartTime;
                }
            }

            final int ERROR_TOLERANT =  60000;
            if (notificationMillis != -1 && contestStartTime > currentTime && contestStartTime < currentTime + notificationMillis + ERROR_TOLERANT) {
                String contestSourceName = cursor.getString(COL_CONTEST_SOURCE);
                if (PreferenceUtil.isReminderOn(this, contestSourceName)) {
                    buildNotification(cursor.getString(COL_CONTEST_TITLE),
                            cursor.getString(COL_CONTEST_SOURCE),
                            contestStartTime - currentTime);
                }
            }

        }

        if (earliestTime!=-1 && notificationMillis!=-1) {
            setAlarm(this,earliestTime - notificationMillis );
        }

    }

    private void buildNotification(String contestTitle,String contestSource,Long timeLeft) {
        Log.d("DEBUG","NotificationService.buildNotification");
        PendingIntent pi = PendingIntent
                .getActivity(this,0,new Intent(this, MainActivity.class),0);

        String timeLeftString = TimeUtil.getShortReadableDurationFromMillis(timeLeft);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(OnlineJudge.getIcon(contestSource))
                .setContentTitle(getString(R.string.notification_remider_title) + " - "+contestTitle)
                .setContentText("will start in "+timeLeftString)
                .setContentIntent(pi)
                .setVibrate(new long[]{500L, 500L, 500L, 500L})
                .setLights(Color.BLUE, 500, 500)
                .setSound(alarmSound)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(currentNotificationId,notification);
        currentNotificationId++;
        if (currentNotificationId> MAX_NOTIFICATION)
            currentNotificationId = 0;
    }

    public static void setAlarm(Context context, Long time) {
        Log.d("DEBUG","NotificationService.setAlarm()");
        Intent i = new Intent(context,NotificationService.class);
        PendingIntent pi = PendingIntent.getService(
                context,0,i,0);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP,time,pi);

    }

    public static void startAlarm(Context context) {
        Log.d("DEBUG","NotificationService.startAlarm()");
        PendingIntent pi = createReminderAlarmPendingIntent(context);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pi);
    }

    public static void cancelAlarm(Context context) {
        PendingIntent pi = createReminderAlarmPendingIntent(context);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pi);
        pi.cancel();
    }

    public static boolean isAlarmOn(Context context) {
        Log.d("DEBUG","NotificationService.isAlarmOn()");
        Intent i = new Intent(context,NotificationService.class);
        PendingIntent pi = PendingIntent.getService(
                context,0,i,PendingIntent.FLAG_NO_CREATE);

        return pi!=null;
    }

    private static PendingIntent createReminderAlarmPendingIntent(Context context) {
        Intent i = new Intent(context,NotificationService.class);
        PendingIntent pi = PendingIntent.getService(
                context,0,i,0);
        return pi;
    }
}
