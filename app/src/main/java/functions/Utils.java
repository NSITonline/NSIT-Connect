package functions;

/**
 * Created by Swati garg on 04-06-2015.
 */

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

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
                = (ConnectivityManager) a.getSystemService(a.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {

            String nextLine = "";
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static String getReadableDurationFromMillis(Long millis) {
        Long seconds = millis / 1000;

        long days = (seconds / 86400);
        seconds = seconds - (days * 86400);

        long hours = seconds/3600;
        seconds = seconds - (hours * 3600);

        long minutes = seconds /60;
        seconds = seconds - (minutes * 60);

        String readableDuration = "";

        if (days!=0) {
            readableDuration += (days + " days ");
        }

        if (hours!=0) {
            readableDuration += (hours + " hours ");
        }

        if (minutes!=0) {
            readableDuration += (minutes + " minutes ");
        }

        if (seconds!=0) {
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

        long hours = seconds/3600;
        seconds = seconds - (hours * 3600);

        long minutes = seconds /60;
        seconds = seconds - (minutes * 60);

        if (days!=0) {
            return days + " days";
        }

        if (hours!=0) {
            return (hours+1) + " hrs";
        }

        if (minutes!=0) {
            return (minutes+1) + " mins";
        }

        if (seconds!=0) {
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