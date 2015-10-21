package nsit.app.com.nsitapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Naman Maheshwari on 11-10-15.
 */
public class dbAdapter {
    public static final String KEY_ROWID = "_id";
    public static final int COL_ROWID = 0;

    public static final String KEY_LIST = "list";
    public static final int COL_LIST = 1;

    public static final String KEY_LIST1 = "list1";
    public static final int COL_LIST1 = 2;

    public static final String KEY_LIST2 = "list2";
    public static final int COL_LIST2 = 3;

    public static final String KEY_LIST6 = "list6";
    public static final int COL_LIST6 = 4;

    public static final String KEY_LIST7 = "list7";
    public static final int COL_LIST7 = 5;

    public static final String KEY_LIST8 = "list8";
    public static final int COL_LIST8 = 6;

    public static final String KEY_LIST9 = "list9";
    public static final int COL_LIST9 = 7;

    public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_LIST, KEY_LIST1, KEY_LIST2, KEY_LIST6, KEY_LIST7, KEY_LIST8, KEY_LIST9};

    public static final String DATABASE_NAME = "NSIT Connect";
    public static final String DATABASE_TABLE = "myFeed";

    public static final long DATABASE_VERSION = 3;

    private static final String DATABASE_CREATE_SQL =
            "create table " + DATABASE_TABLE
            + " (" + KEY_ROWID + " integer primary key autoincrement, "
            + KEY_LIST + " TEXT, "
            + KEY_LIST1 + " TEXT, "
            + KEY_LIST2 + " TEXT, "
            + KEY_LIST6 + " TEXT, "
            + KEY_LIST7 + " TEXT, "
            + KEY_LIST8 + " TEXT, "
            + KEY_LIST9 + " TEXT"
            + ");";

    private Context context;

    private DatabaseHelper NSITConnectHelper;
    private SQLiteDatabase db;

    public dbAdapter(Context ctx) {
        this.context = ctx;
        NSITConnectHelper = new DatabaseHelper(context);
    }

    public dbAdapter open() {
        db = NSITConnectHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        Cursor c = getAllRows();

        NSITConnectHelper.close();
    }

    public long insertRow(String a, String b, String c, String g, String h, String i, String j) {

        /*THIS IS GIVING AN ERROR I CANNOT FIGURE OUT.
        Cursor cursor = db.query(DATABASE_TABLE, ALL_KEYS, KEY_LIST1 + "=?", new String[] { b }, null, null, null);
        if(cursor.moveToFirst())
            return 0;*/
        ContentValues values = new ContentValues();
        values.put(KEY_LIST, a);
        values.put(KEY_LIST1, b);
        values.put(KEY_LIST2, c);
        values.put(KEY_LIST6, g);
        values.put(KEY_LIST7, h);
        values.put(KEY_LIST8, i);
        values.put(KEY_LIST9, j);

        Log.e("inseri=ting",b+" "+c);
        return db.insert(DATABASE_TABLE, null, values);
    }
/*

    Redundant code. Keeping for reference only.

    public boolean deleteRow(long rowID) {
        String where = KEY_ROWID + "=" + rowID;
        return db.delete(DATABASE_TABLE, where, null) != 0;
    }

    public void deleteAll() {
        Cursor c = getAllRows();
        long rowID = c.getColumnIndexOrThrow(KEY_ROWID);
        if(c.moveToFirst()) {
            do {
                deleteRow(c.getLong((int) rowID));
            } while(c.moveToNext());
            c.close();
        }
    }
*/

    public void deleteAll() {
        db.delete(DATABASE_TABLE, null, null);
    }

    public Cursor getAllRows() {
        Cursor c = db.query(DATABASE_TABLE, ALL_KEYS,
                null, null, null, null, null);
        if(c!=null) {
            c.moveToFirst();
        }
        return c;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, (int) DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(DATABASE_CREATE_SQL);
        }

        @Override
        public void onUpgrade (SQLiteDatabase _db, int oldVersion, int newVersion) {
            _db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

            onCreate(_db);
        }

    }
}
