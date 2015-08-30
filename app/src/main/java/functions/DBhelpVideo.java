package functions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Swati garg on 30-06-2015.
 */
public class DBhelpVideo extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "NSITConnect.db";


    private static final String INT_TYPE = " INT";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";


    public static final String COLUMN_NAME2_MESSAGE = "message";
    public static final String COLUMN_NAME2_OBJECTID = "ob_id";
    public static final String COLUMN_NAME2_TO_NAME = "to_name";
    public static final String COLUMN_NAME2_PICTURE = "picture";
    public static final String COLUMN_NAME2_LINK = "link";
    public static final String COLUMN_NAME2_LIKES_COUNT = "likes";
    public static final String COLUMN_NAME2_TIME = "time";
    public static final String COLUMN_NAME2_SOCIETY = "society_name";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TableEntryFeed.TABLE2_NAME + " (" +
                    TableEntryFeed.COLUMN_NAME2_MESSAGE + TEXT_TYPE + COMMA_SEP +
                    TableEntryFeed.COLUMN_NAME2_OBJECTID + TEXT_TYPE + COMMA_SEP +
                    TableEntryFeed.COLUMN_NAME2_TO_NAME + TEXT_TYPE + COMMA_SEP +
                    TableEntryFeed.COLUMN_NAME2_PICTURE + TEXT_TYPE + COMMA_SEP +
                    TableEntryFeed.COLUMN_NAME2_LINK + TEXT_TYPE + COMMA_SEP +
                    TableEntryFeed.COLUMN_NAME2_TIME + TEXT_TYPE + COMMA_SEP +
                    TableEntryFeed.COLUMN_NAME2_SOCIETY + TEXT_TYPE + COMMA_SEP +
                    TableEntryFeed.COLUMN_NAME2_LIKES_COUNT + TEXT_TYPE +
            " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TableEntryFeed.TABLE2_NAME;

    public DBhelpVideo(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}