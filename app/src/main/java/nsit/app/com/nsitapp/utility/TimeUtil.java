package nsit.app.com.nsitapp.utility;

/**
 * Created by saisumit on 5/24/15.
 */
public class TimeUtil {

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
}
