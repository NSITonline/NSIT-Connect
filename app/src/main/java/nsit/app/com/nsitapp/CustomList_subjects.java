package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
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
import android.widget.TextView;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomList_subjects extends ArrayAdapter<String>{
	private final Activity context;
	TextView txtTitle2,txtTitle3;
	private final ArrayList<String> code,title;
	public CustomList_subjects(Activity context, ArrayList<String> a, ArrayList<String> b) {
		super(context, R.layout.subject_list_item, a);
		this.context = context;
		code=a;
		title=b;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.subject_list_item, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.code);
		txtTitle.setText(code.get(position));
		txtTitle = (TextView) rowView.findViewById(R.id.title);
		txtTitle.setText(title.get(position));
		txtTitle2 = (TextView) rowView.findViewById(R.id.attendance);
		txtTitle3 = (TextView) rowView.findViewById(R.id.message);

		refresh(position);

		LinearLayout add,rem;
		add = (LinearLayout) rowView.findViewById(R.id.add);
		rem = (LinearLayout) rowView.findViewById(R.id.rem);


		rem.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				Fragment mFragment = new Subjects_Remove();
				Bundle bundle = new Bundle();
				bundle.putString("code", code.get(position));
				mFragment.setArguments(bundle);
				((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mFragment).commit();

			}
		});



		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
				final DatePicker picker = new DatePicker(getContext());
				picker.setCalendarViewShown(false);
				builder.setView(picker);
				builder.setTitle(title.get(position));
				builder.setMessage("Is class missed or attended?");
				builder.setPositiveButton("Attended", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						DBhelp mDbHelper = new DBhelp(getContext());
						SQLiteDatabase db = mDbHelper.getWritableDatabase();

						// Create a new map of values, where column names are the keys
						ContentValues values = new ContentValues();


						Calendar cal = Calendar.getInstance();
						cal.set(Calendar.DAY_OF_MONTH, picker.getDayOfMonth());
						cal.set(Calendar.MONTH, picker.getMonth());
						cal.set(Calendar.YEAR, picker.getYear());

						Log.e("date selected", "Month" + picker.getMonth() + "\nDay " + picker.getDayOfMonth());
						values.put(TableEntry.COLUMN_NAME_SUBJECT, code.get(position));
						values.put(TableEntry.COLUMN_NAME_DATE, cal.getTimeInMillis());
						values.put(TableEntry.COLUMN_NAME_STATUS, "Attended");

						db.insert(
								TableEntry.TABLE_NAME,
								TableEntry.COLUMN_NAME_STATUS,
								values);

						refresh(position);


					}
				});
				builder.setNegativeButton("Missed", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						DBhelp mDbHelper = new DBhelp(getContext());
						SQLiteDatabase db = mDbHelper.getWritableDatabase();

						// Create a new map of values, where column names are the keys
						Log.e("date selected", picker.getMonth() + " ");
						ContentValues values = new ContentValues();
						Calendar cal = Calendar.getInstance();
						cal.set(Calendar.DAY_OF_MONTH, picker.getDayOfMonth());
						cal.set(Calendar.MONTH, picker.getMonth());
						cal.set(Calendar.YEAR, picker.getYear());
						values.put(TableEntry.COLUMN_NAME_SUBJECT, code.get(position));
						values.put(TableEntry.COLUMN_NAME_DATE, cal.getTimeInMillis());
						values.put(TableEntry.COLUMN_NAME_STATUS, "Missed");

						// Insert the new row, returning the primary key value of the new row
						db.insert(
								TableEntry.TABLE_NAME,
								TableEntry.COLUMN_NAME_STATUS,
								values);

						Log.e("Calling", " " + position);
						refresh(position);
					}
				});
				builder.show();
			}
		});


		return rowView;
	}


	void refresh(int position){
		DBhelp mDbHelper = new DBhelp(getContext());
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
				TableEntry.COLUMN_NAME_SUBJECT + " ASC";
		String[] whereArgs = new String[] {
				code.get(position)

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


		float total = c.getCount();
		float attended=0;

		if (c.moveToFirst()){
			do{
				Log.e("Date", c.getString(c.getColumnIndex(TableEntry.COLUMN_NAME_SUBJECT)));
				if(c.getString(c.getColumnIndex(TableEntry.COLUMN_NAME_STATUS)).equals("Attended"))
					attended++;
			}while(c.moveToNext());
		}


		notifyDataSetChanged();

		if(total==0)
			txtTitle2.setText("No classes yet");
		else {
			float x = attended/total*100;
			if(x<75) {
				txtTitle3.setTextColor(Color.parseColor("#ff3300"));
				txtTitle3.setText(" Your attendance is short, you need to attend the next 5 classes to be safe.");
			}
			else {
				txtTitle3.setTextColor(Color.parseColor("#33cc00"));
				txtTitle3.setText(" You can afford to miss 7 classes and still be safe.");
			}
				txtTitle2.setText(Float.toString(x) + " % attendance");
		}

	}
}