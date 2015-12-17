package functions;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;

/**
 * Created by Naman Maheshwari on 11-10-15.
 */
public class dbAdapter implements  Constant {

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

    public static final String KEY_SOC = "socName";
    public static final int COL_SOC = 8;

    public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_LIST, KEY_LIST1, KEY_LIST2, KEY_LIST6, KEY_LIST7, KEY_LIST8, KEY_LIST9, KEY_SOC };

    public static final String DATABASE_NAME = "NSITConnect";
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
                    + KEY_LIST9 + " TEXT, "
                    + KEY_SOC + " TEXT "
                    + ");";

    private Context context;

    private DatabaseHelper NSITConnectHelper;
    private SQLiteDatabase db;

    public dbAdapter(Context ctx) {
        this.context = ctx;
        NSITConnectHelper = new DatabaseHelper(context);
    }

    public dbAdapter open() {
        try {
            db = NSITConnectHelper.getWritableDatabase();
        }catch(Exception e){

        }
        return this;
    }

    public void close() {
        NSITConnectHelper.close();
    }

    public long insertRow(String a, String b, String c, String g, String h, String i, String j, String soc) {

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
        values.put(KEY_SOC, soc);

        return db.insert(DATABASE_TABLE, null, values);
    }

    public void deleteAll() {
        db.delete(DATABASE_TABLE, null, null);
    }

    public Cursor getAllRows() {

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);

        String whereArgs = " IN (  ";

        if(pref.getBoolean(CROSSLINKS, false))
            whereArgs+= (Val.id_crosslinks + ", ");
        if(pref.getBoolean(COLLEGESPACE, false))
            whereArgs+= (Val.id_collegespace+ ", ");
        if(pref.getBoolean(BULLET, false))
            whereArgs+= (Val.id_bullet+ ", ");
        if(pref.getBoolean(ASHWA, false))
            whereArgs+=(Val.id_ashwa+ ", ");
        if(pref.getBoolean(JUNOON, false))
            whereArgs+=(Val.id_junoon + ", ");
        if(pref.getBoolean(ROTARACT, false))
            whereArgs+=(Val.id_rotaract + ", ");
        if(pref.getBoolean(CSI, false))
            whereArgs+=(Val.id_csi + ", ");
        if(pref.getBoolean(IEEE, false))
            whereArgs+= (Val.id_ieee + ", ");
        if(pref.getBoolean(DEB, false))
            whereArgs+= (Val.id_debsoc + ", ");
        if(pref.getBoolean(QUIZ, false))
            whereArgs+= (Val.id_quiz + ", ");
        if(pref.getBoolean(AAGAZ, false))
            whereArgs+= (Val.id_aagaz + ", ");
        if(pref.getBoolean(ENACTUS, false))
            whereArgs+= (Val.id_enactus + ", ");

        whereArgs = whereArgs.substring(0,whereArgs.length()-2);
        whereArgs += " ) ";


        Cursor c = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE " + KEY_SOC + whereArgs, null);
        c.moveToFirst();
        return c;
    }



    public Cursor getAllnsRows() {
        String whereArgs = " IN (  "+Val.id_nsitonline +" )";
        Cursor c = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE " + KEY_SOC + whereArgs, null);
        c.moveToFirst();
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



}