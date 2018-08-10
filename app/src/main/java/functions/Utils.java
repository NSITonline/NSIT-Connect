package functions;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import nsit.app.com.nsitapp.R;

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
            ex.printStackTrace();
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
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String nextLine;
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

    public static void setAnimation(View view) {
        AnimationSet set = new AnimationSet(true);
        TranslateAnimation slide = new TranslateAnimation(-100, 0, -100, 0);
        slide.setInterpolator(new DecelerateInterpolator(5.0f));
        slide.setDuration(300);
        Animation fade = new AlphaAnimation(0, 1.0f);
        fade.setInterpolator(new DecelerateInterpolator(5.0f));
        fade.setDuration(300);
        set.addAnimation(slide);
        set.addAnimation(fade);
        view.startAnimation(set);
    }

    public static HashMap<String, Integer> getLocationsIdMap() {
        HashMap<String, Integer> locationsIdMap = new HashMap<>();
        locationsIdMap.put("College", R.drawable.ic_school_black_24dp);
        locationsIdMap.put("Campus", R.drawable.ic_business_black_24dp);
        locationsIdMap.put("Hostel", R.drawable.ic_hotel_black_24dp);
        locationsIdMap.put("Canteen", R.drawable.ic_local_cafe_black_24dp);
        locationsIdMap.put("Stationery", R.drawable.ic_brush_black_24dp);
        locationsIdMap.put("ATM", R.drawable.ic_credit_card_black_24dp);
        locationsIdMap.put("WiFi", R.drawable.ic_network_wifi_black_24dp);
        locationsIdMap.put("Sports", R.drawable.ic_directions_bike_black_24dp);
        locationsIdMap.put("Miscellaneous", R.drawable.ic_public_black_24dp);
        return locationsIdMap;
    }
}