package nsit.app.com.nsitapp.PushNotification;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by AGGARWAL'S on 3/26/2016.
 */
public class NotificationAdapter {

    private DBHelper dbHelper;
    private SQLiteDatabase database;


    public NotificationAdapter(Context mContext) throws SQLException{
        Context mContext1 = mContext;
        dbHelper = new DBHelper(mContext);
    }

    private NotificationAdapter connect() throws SQLException{
        database = dbHelper.getWritableDatabase();
        return  this;
    }

    public void disconnect(){
        dbHelper.close();
    }

    public long insertNotification(String a,String b,String c,String d) throws SQLException{
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_OBJECT_ID,a);
        contentValues.put(DBHelper.KEY_MESSAGE,b);
        contentValues.put(DBHelper.KEY_TIME_CREATED, c);
        contentValues.put(DBHelper.KEY_LIKES,d);
        this.connect();
        return database.insert(DBHelper.TABLE_NAME,null,contentValues);
    }

    public Cursor retrieveAll() throws SQLException{
        this.connect();
        Cursor c = database.rawQuery("SELECT * FROM " + DBHelper.TABLE_NAME, null);
        c.moveToFirst();
        return c;
    }

    public boolean CheckIsDataAlreadyInDBorNot(String time_created) throws SQLException{
        this.connect();
        String Query = "SELECT * FROM " + DBHelper.TABLE_NAME + " WHERE " + DBHelper.KEY_TIME_CREATED + " = '" + time_created + "'";
        Cursor cursor = database.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    private int getProfilesCount() throws SQLException{
        this.connect();
        String countQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME;
        Cursor cursor = database.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    public void deletefirsthalf() throws SQLException{
        if (getProfilesCount()>100){
            this.connect();
            String deleteQuery = "delete from " + DBHelper.TABLE_NAME +
                    " where "+DBHelper.KEY_ROWID+" in (select "+ DBHelper.KEY_ROWID +" from "+ DBHelper.TABLE_NAME+" order by "+ DBHelper.KEY_ROWID+" LIMIT 100);";
            database.execSQL(deleteQuery);
            database.close();
            this.disconnect();
        }
    }

    public void deleteAll() throws SQLException{
        this.connect();
        database.execSQL("DELETE * FROM "+DBHelper.TABLE_NAME);
        database.close();
    }
}
