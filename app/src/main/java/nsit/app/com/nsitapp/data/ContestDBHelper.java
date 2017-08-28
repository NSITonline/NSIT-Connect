package nsit.app.com.nsitapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nsit.app.com.nsitapp.data.ContestContract.ContestEntry;

/**
 * Created by saisumit on 5/19/15.
 */
class ContestDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;


    private static final String DATABASE_NAME = "contest.db";

    public ContestDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_CONTEST_TABLE = "CREATE TABLE " + ContestEntry.TABLE_NAME + " (" +

                ContestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                ContestEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                ContestEntry.COLUMN_DESCRIPTION + " TEXT ," +
                ContestEntry.COLUMN_URL + "  TEXT ," +
                ContestEntry.COLUMN_START_TIME + " INTEGER NOT NULL ," +
                ContestEntry.COLUMN_END_TIME + " INTEGER NOT NULL ," +
                ContestEntry.COLUMN_SOURCE + " TEXT ," +

                "UNIQUE (" + ContestEntry.COLUMN_TITLE + ") ON CONFLICT REPLACE );";

        sqLiteDatabase.execSQL(SQL_CREATE_CONTEST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS + " + ContestEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
