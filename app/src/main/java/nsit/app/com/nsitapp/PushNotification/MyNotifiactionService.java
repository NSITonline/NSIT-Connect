package nsit.app.com.nsitapp.PushNotification;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import functions.Constant;
import functions.Utils;
import nsit.app.com.nsitapp.MainActivity;
import nsit.app.com.nsitapp.R;

/**
 * Created by AGGARWAL'S on 3/25/2016.
 */
public class MyNotifiactionService extends IntentService implements Constant {

    public static final String URL = "https://graph.facebook.com/" + id_nsitonline + "/posts?limit=20&fields=id,picture,from,shares,message," +
            "object_id,link,created_time,comments.limit(0).summary(true),likes.limit(0).summary(true)"+
            "&access_token=" + common_access;
    private List<String> message = new ArrayList<String>();
    private List<String> object_id = new ArrayList<String>();
    private List<String> time_created = new ArrayList<String>();
    private List<String> likes = new ArrayList<String>();


    public MyNotifiactionService() {
        super("MyNotifiactionService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String text = "";
        if (URL != null) {
            String uri = URL;
            java.net.URL url = null;
            try {
                url = new URL(uri);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                text = Utils.readStream(con.getInputStream());
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        int j = 0;
        JSONObject ob, ob2;
        JSONArray arr;
        if (text != null)
            try {
                ob = new JSONObject(text);
                arr = ob.getJSONArray("data");


                for (int i = 0; i < arr.length(); i++) {

                    String s2 = arr.getJSONObject(i).getString("from");
                    ob2 = new JSONObject(s2);
                    s2 = ob2.getString("id");
                    if (!s2.equals(id_nsitonline))
                        continue;

                    if (arr.getJSONObject(i).has("message"))
                        message.add(arr.getJSONObject(i).getString("message"));
                    else
                        message.add(null);

                    if (!(arr.getJSONObject(i).has("object_id")))
                        object_id.add(null);
                    else
                        object_id.add(arr.getJSONObject(i).getString("object_id"));

                    if (arr.getJSONObject(i).has("likes")) {
                        String s = arr.getJSONObject(i).getString("likes");
                        JSONObject o = new JSONObject(s);
                        JSONArray a2 = o.getJSONArray("data");
                        String x = o.getString("summary");
                        JSONObject o2 = new JSONObject(x);

                        likes.add(o2.getString("total_count"));   //No of likes
                    } else
                        likes.add("0");

                    if (arr.getJSONObject(i).has("created_time"))
                        time_created.add(arr.getJSONObject(i).getString("created_time"));
                    else
                        time_created.add(null);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        ArrayList<String> newmessage = new ArrayList<String>();
        try {
            NotificationAdapter notify = new NotificationAdapter(this);
            for (int i=time_created.size()-1;i>=0;i--){
                if (notify.CheckIsDataAlreadyInDBorNot(String.valueOf(time_created.get(i)))){
                    newmessage.add(message.get(i));
                    notify.insertNotification(String.valueOf(time_created.get(i)),
                                              String.valueOf(message.get(i)),
                                              String.valueOf(time_created.get(i)),
                                              String.valueOf(likes.get(i)));
                }
            }
            notify.deletefirsthalf();
            notify.disconnect();

        }catch (Exception e){
            e.printStackTrace();
        }



        if (newmessage.size()>0){
            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle("NSIT Connect")
                    .setContentText(" You Have "+ newmessage.size()+" Notifications")
                    .setVibrate(new long[]{500L, 500L, 500L, 500L})
                    .setLights(Color.BLUE, 500, 500)
                    .setSound(alarmSound)
                    .setContentIntent(contentIntent)
                    .setAutoCancel(true);
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            Collections.reverse(newmessage);
            for (int i=0;i<newmessage.size();i++) {
               if (newmessage.get(i)==null)
                   continue;
                inboxStyle.addLine("@ " + newmessage.get(i));
            }
            notification.setStyle(inboxStyle);
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(0, notification.build());
        }
    }


}
