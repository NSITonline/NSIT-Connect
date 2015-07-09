package nsit.app.com.nsitapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class SubjectRemove extends AppCompatActivity {

    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    ArrayList<String> list3 = new ArrayList<String>();
    Button b;
    String code;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_show);
        lv = (ListView) findViewById(R.id.list);
        Intent i = getIntent();
        code = i.getStringExtra("code");

        setTitle("Attendance Pattern");
        DBhelp mDbHelper = new DBhelp(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                TableEntry._ID,
                TableEntry.COLUMN_NAME_SUBJECT,
                TableEntry.COLUMN_NAME_DATE ,
                TableEntry.COLUMN_NAME_STATUS,
                TableEntry.COLUMN_NAME_NUMBER
        };
        String sortOrder =
                TableEntry.COLUMN_NAME_DATE + " DESC";
        String[] whereArgs = new String[] {
                code};
        Cursor c = db.query(
                TableEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                TableEntry.COLUMN_NAME_SUBJECT + " = ?",                                // The columns for the WHERE clause
                whereArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );



        if (c.moveToFirst()){
            do{
                list1.add(c.getString(c.getColumnIndex(TableEntry.COLUMN_NAME_STATUS)));
                list2.add(c.getString(c.getColumnIndex(TableEntry.COLUMN_NAME_DATE)));
                list3.add(c.getString(c.getColumnIndex(TableEntry._ID)));
            }while(c.moveToNext());
        }




        CustomList_subjects_remove a = new CustomList_subjects_remove(this,list1,list2,list3);
        lv.addHeaderView(new View(this));
        lv.addFooterView(new View(this));
        lv.setAdapter(a);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subject_remove, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
