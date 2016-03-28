package nsit.app.com.nsitapp.PushNotification;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AGGARWAL'S on 3/26/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME ="NSITConnectFeed.db";
    public static final String TABLE_NAME = "myNotificationFeed";

    private static final String INT_TYPE = " INT";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String KEY_ROWID = "row_id";
    public static final String KEY_OBJECT_ID = "object_id";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_TIME_CREATED = "time_created";
    public static final String KEY_LIKES = "likes";
    private static final String SQL_CREATE_ENTRIES_FEED=
            "CREATE TABLE " + TABLE_NAME  + " (" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    KEY_OBJECT_ID + TEXT_TYPE + COMMA_SEP +
                    KEY_MESSAGE+ TEXT_TYPE + COMMA_SEP +
                    KEY_TIME_CREATED + TEXT_TYPE + COMMA_SEP +
                    KEY_LIKES + TEXT_TYPE +
                    " )";

    private static final String SQL_DELETE_ENTRIES_FEED=
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES_FEED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES_FEED);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @Override
    protected void finalize() throws Throwable {
        this.close();
        super.finalize();
    }
}
