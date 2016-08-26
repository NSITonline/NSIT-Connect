package functions;

/**
 * Created by Swati garg on 04-06-2015.
 */

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.model.Friend;

public class Utils {
    public static void CopyStream(InputStream is, OutputStream os) {
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (; ; ) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
        } catch (Exception ex) {
        }
    }

    public static boolean isNetworkAvailable(Activity a) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) a.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            String nextLine = "";
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static String GetLocalDateStringFromUTCString(String utcLongDateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS");
        String localDateString;

        long when = 0;
        try {
            when = dateFormat.parse(utcLongDateTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        localDateString = dateFormat.format(new Date(when + TimeZone.getDefault().getRawOffset() +
                (TimeZone.getDefault().inDaylightTime(new Date()) ? TimeZone.getDefault().getDSTSavings() : 0)));
        return localDateString;
    }


    public static String getReadableDurationFromMillis(Long millis) {
        Long seconds = millis / 1000;

        long days = (seconds / 86400);
        seconds = seconds - (days * 86400);

        long hours = seconds / 3600;
        seconds = seconds - (hours * 3600);

        long minutes = seconds / 60;
        seconds = seconds - (minutes * 60);

        String readableDuration = "";

        if (days != 0) {
            readableDuration += (days + " days ");
        }

        if (hours != 0) {
            readableDuration += (hours + " hours ");
        }

        if (minutes != 0) {
            readableDuration += (minutes + " minutes ");
        }

        if (seconds != 0) {
            readableDuration += (seconds + " seconds ");
        }

        return readableDuration;
    }

    public static String getShortReadableDurationFromMillis(Long millis) {
        if (millis < 0) {
            return "right now";
        }

        Long seconds = millis / 1000;

        long days = (seconds / 86400);
        seconds = seconds - (days * 86400);

        long hours = seconds / 3600;
        seconds = seconds - (hours * 3600);

        long minutes = seconds / 60;
        seconds = seconds - (minutes * 60);

        if (days != 0) {
            return days + " days";
        }

        if (hours != 0) {
            return (hours + 1) + " hrs";
        }

        if (minutes != 0) {
            return (minutes + 1) + " mins";
        }

        if (seconds != 0) {
            return "1 mins";
        }

        return "0 secs";
    }

    public static final List<Friend> friends = new ArrayList<>();

    static {
        friends.add(new Friend(R.drawable.sidharth_patro, "SIDHARTH PATRO"
                ,"https://in.linkedin.com/in/sdpatro"
                , "https://www.facebook.com/sidharth.patro.39?fref=ts"
                , "https://github.com/sdpatro"
                ,R.color.sienna
                , "LinkedIn", "Facebook", "Github", "Developer", "UI Designer"));
        friends.add(new Friend(R.drawable.swati_garg, "SWATI GARG"
                , "https://in.linkedin.com/pub/swati-garg/b9/371/a79"
                ,"https://www.facebook.com/swati.garg.1690"
                ,"https://github.com/Swati4star"
                , R.color.saffron
                , "LinkedIn", "Facebook", "Github", "Developer", "Tester"));
        friends.add(new Friend(R.drawable.prabhakar, "PRABHAKAR GUPTA"
                ,"https://www.linkedin.com/in/prabhakargupta267"
                ,"https://www.facebook.com/prabhakar267"
                ,"https://github.com/prabhakar267"
                ,R.color.green
                , "LinkedIn", "Facebook", "Github", "Backend Developer", null));
        friends.add(new Friend(R.drawable.chetan, "CHETAN SHUKLA"
                ,"https://in.linkedin.com/pub/chetan-shukla/100/415/455"
                ,"https://www.facebook.com/chetan.shukla.5205?fref=ts"
                ,null
                ,R.color.pink
                ,"LinkedIn", "Facebook", "Github", "Content Writer", null));
        friends.add(new Friend(R.drawable.sagar_aggarwal, "SAGAR AGGARWAL"
                ,"https://in.linkedin.com/in/sagar-aggarwal-9319b3110"
                ,"https://web.facebook.com/sagar.aggarwal.773"
                ,"https://github.com/sgaggarwal2009"
                ,R.color.orange
                ,"LinkedIn", "Facebook", "Github", "Developer", "Tester"));
        friends.add(new Friend(R.drawable.naman_maheshwari, "NAMAN MAHESHWARI"
                ,"https://in.linkedin.com/in/naman1901"
                ,"https://www.facebook.com/naman1901"
                ,"https://github.com/naman1901"
                ,R.color.saffron
                ,"LinkedIn", "Facebook", "Github", "Developer", "Tester"));
        friends.add(new Friend(R.drawable.ayush_verma, "AYUSH VERMA"
                ,"https://in.linkedin.com/in/ayush-verma-210082114"
                ,"https://www.facebook.com/ayush.verma.5203"
                ,"https://github.com/Ayush-V1"
                ,R.color.green
                ,"LinkedIn", "Facebook", "Github","Developer", "Tester"));
        friends.add(new Friend(R.drawable.saisumit_vohra, "SAISUMIT VOHRA"
                ,"https://in.linkedin.com/in/sumit-vohra-224484a0"
                ,"https://www.facebook.com/sumit.vohra.353?ref=br_rs"
                ,"https://github.com/saisumit"
                ,R.color.purple
                ,"LinkedIn", "Facebook", "Github", "Developer", "Tester"));
    }

    /* private class OnPinchListener extends ScaleGestureDetector.SimpleOnScaleGestureListener
    {
        float currentSpan;
        float startFocusX;
        float startFocusY;

        public boolean onScaleBegin(ScaleGestureDetector detector)
        {
            currentSpan = detector.getCurrentSpan();
            startFocusX = detector.getFocusX();
            startFocusY = detector.getFocusY();
            return true;
        }

        public boolean onScale(ScaleGestureDetector detector)
        {

            mZoomableRelativeLayout.relativeScale(detector.getCurrentSpan() / currentSpan, startFocusX, startFocusY);

            currentSpan = detector.getCurrentSpan();

            return true;
        }

        public void onScaleEnd(ScaleGestureDetector detector)
        {

            mZoomableRelativeLayout.release();
        }
    }
*/
}