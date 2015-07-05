package nsit.app.com.nsitapp;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Swati garg on 30-06-2015.
 */


public class Subjects_Remove extends Fragment {


    ArrayList<String> list1 = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    ArrayList<String> list3 = new ArrayList<String>();
    Button b;
    String code;

    ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Activity activity;
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_subject, container, false);
         lv = (ListView) rootView.findViewById(R.id.list);
        Bundle i = this.getArguments();
        code = i.getString("code", null);

        DBhelp mDbHelper = new DBhelp(getActivity());
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                TableEntry._ID,
                TableEntry.COLUMN_NAME_SUBJECT,
                TableEntry.COLUMN_NAME_DATE ,
                TableEntry.COLUMN_NAME_STATUS,
                TableEntry.COLUMN_NAME_NUMBER
        };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                TableEntry.COLUMN_NAME_DATE + " DESC";
        String[] whereArgs = new String[] {
                code

        };
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




            CustomList_subjects_remove a = new CustomList_subjects_remove(getActivity(),list1,list2,list3);
            lv.addHeaderView(new View(getActivity()));
            lv.addFooterView(new View(getActivity()));
            lv.setAdapter(a);
        return rootView;
    }


}
