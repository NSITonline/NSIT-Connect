package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import functions.ButtonAnimation;
import functions.DBhelp;
import functions.TableEntry;


public class SubjectRemove extends AppCompatActivity {

    private ArrayList<String> list1 = new ArrayList<String>();
    private ArrayList<String> list2 = new ArrayList<String>();
    private ArrayList<String> list3 = new ArrayList<String>();
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects_show);
        ListView lv = (ListView) findViewById(R.id.list);
        Intent i = getIntent();
        String code = i.getStringExtra("code");

        setTitle("Attendance Pattern");
        DBhelp mDbHelper = new DBhelp(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                TableEntry._ID,
                TableEntry.COLUMN_NAME_SUBJECT,
                TableEntry.COLUMN_NAME_DATE,
                TableEntry.COLUMN_NAME_STATUS,
                TableEntry.COLUMN_NAME_NUMBER
        };
        String sortOrder =
                TableEntry.COLUMN_NAME_DATE + " DESC";
        String[] whereArgs = new String[]{
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


        if (c.moveToFirst()) {
            do {
                list1.add(c.getString(c.getColumnIndex(TableEntry.COLUMN_NAME_STATUS)));
                list2.add(c.getString(c.getColumnIndex(TableEntry.COLUMN_NAME_DATE)));
                list3.add(c.getString(c.getColumnIndex(TableEntry._ID)));
            } while (c.moveToNext());
        }

        c.close();

        CustomList_subjects_remove a = new CustomList_subjects_remove(this, list1, list2, list3);
        lv.addHeaderView(new View(this));
        lv.addFooterView(new View(this));
        lv.setAdapter(a);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subject_remove, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    public class CustomList_subjects_remove extends ArrayAdapter<String> {
        private final Activity context;
        private final ArrayList<String> status, date, ids;

        public CustomList_subjects_remove(Activity context, ArrayList<String> a, ArrayList<String> b, ArrayList<String> c) {
            super(context, R.layout.subject_list_item, a);
            this.context = context;
            status = a;
            date = b;
            ids = c;
        }

        private class ViewHolder {
            TextView stat, dat;
            LinearLayout rem;

        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            ViewHolder holder;
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                view = mInflater.inflate(R.layout.subject_list_item_remove, parent, false);
                holder = new ViewHolder();
                holder.stat = (TextView) view.findViewById(R.id.status);
                holder.dat = (TextView) view.findViewById(R.id.date);
                holder.rem = (LinearLayout) view.findViewById(R.id.rem);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            if (status.get(position).equals("Missed"))
                holder.stat.setTextColor(Color.parseColor("#ff3300"));
            else
                holder.stat.setTextColor(Color.parseColor("#33cc00"));
            holder.stat.setText(status.get(position));

            String s = getDate(Long.parseLong(date.get(position)));        //Convert date format
            holder.dat.setText(s);
            DBhelp mDbHelper = new DBhelp(getContext());
            final SQLiteDatabase db = mDbHelper.getReadableDatabase();

            holder.rem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Remove");
                    builder.setMessage("Are you sure you want to remove this date?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            db.delete(TableEntry.TABLE_NAME, TableEntry._ID
                                    + " = " + ids.get(position), null);
                            Log.e("yo", "deleted");
                            status.remove(position);
                            date.remove(position);
                            ids.remove(position);
                            notifyDataSetChanged();

                        }
                    });
                    builder.setNegativeButton("No", null);
                    ButtonAnimation btnAnimation = new ButtonAnimation();
                    btnAnimation.animateButton(view, getContext());
                    builder.show();
                }
            });

            AnimationSet set = new AnimationSet(true);
            TranslateAnimation slide = new TranslateAnimation(-100, 0, -100, 0);
            slide.setInterpolator(new DecelerateInterpolator(5.0f));
            slide.setDuration(300);
            Animation fade = new AlphaAnimation(0, 1.0f);
            fade.setInterpolator(new DecelerateInterpolator(5.0f));
            fade.setDuration(300);
            set.addAnimation(slide);
            set.addAnimation(fade);
            view.startAnimation(set);
            return view;
        }


        public  String getDate(long milliSeconds) {
            // Create a DateFormatter object for displaying date in specified format.
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(milliSeconds);
            return formatter.format(calendar.getTime());
        }
    }


}
