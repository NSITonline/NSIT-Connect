package functions;

/**
 * Created by Swati garg on 04-06-2015.
 */

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {

    /**
     * Checks if internet connection is active
     * @param a Activity referenced from
     * @return  boolean ig net is available or not
     */
    public static boolean isNetworkAvailable(Activity a) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) a.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Converts input stream to string
     * @param in    input stream
     * @return      output string
     */
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

    /**
     * Copy one stream to another
     * @param is    input stream
     * @param os    output stream
     */
    static void CopyStream(InputStream is, OutputStream os) {
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
            Log.e("ERROR ", ex.getMessage());
        }
    }

    /**
     * convert utc time format to local time
     * @param utcLongDateTime   date in utc format
     * @return                  date in local format
     */
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

    /**
     * Convert milliseconds to time in string
     * @param millis    milliseconds
     * @return          date in string
     */
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

    /**
     * Convert millisecnds to time in short format
     * @param millis    milliseconds to be converted
     * @return          output date
     */
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