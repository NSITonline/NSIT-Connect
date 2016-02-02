package nsit.app.com.nsitapp.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by saisumit on 5/19/15.
 */
public class ContestContract {

    public static final String CONTENT_AUTHORITY = "nsit.app.com.nsitapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_CONTEST = "contest";

    public static final class ContestEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_CONTEST).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CONTEST;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CONTEST;

        public static final String TABLE_NAME = "contest";

        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_START_TIME = "start_time";
        public static final String COLUMN_END_TIME = "end_time";
        public static final String COLUMN_SOURCE = "source";

        public static Uri buildContestUriWithId(long id) {
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        public static Uri buildContestWithSource(String source) {
            return CONTENT_URI.buildUpon().appendPath(source).build();
        }

        public static String getSourceFromUri(Uri uri) {
            String source = uri.getLastPathSegment();
            return source;
        }

        public static int getIDFromUri(Uri uri) {
            String id = uri.getLastPathSegment();
            return Integer.parseInt(id);
        }

    }
}
