package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomList_subjects_remove extends ArrayAdapter<String>{
	private final Activity context;
	TextView txtTitle2;
	Button rem;
	private final ArrayList<String> status,date,ids;
	public CustomList_subjects_remove(Activity context, ArrayList<String> a, ArrayList<String> b,ArrayList<String> c) {
		super(context, R.layout.subject_list_item, a);
		this.context = context;
		status=a;
		date=b;
		ids=c;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.subject_list_item_remove, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.status);
		txtTitle.setText(status.get(position));
		txtTitle = (TextView) rowView.findViewById(R.id.date);
		String s = getDate(Long.parseLong(date.get(position)), "dd/MM/yyyy");		//Convert date format
		txtTitle.setText(s);
		DBhelp mDbHelper = new DBhelp(getContext());
		final SQLiteDatabase db = mDbHelper.getReadableDatabase();

		rem = (Button) rowView.findViewById(R.id.rem);
		rem.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

				builder.setTitle("Remove");
				builder.setMessage("Are you sure you want to remove this date?");
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						db.delete(TableEntry.TABLE_NAME , TableEntry._ID
								+ " = " + ids.get(position), null);
						Log.e("yo","deleted");
						status.remove(position);
						date.remove(position);
						ids.remove(position);
						notifyDataSetChanged();

					}
				});
				builder.setNegativeButton("No", null);
				builder.show();

			}
		});




		return rowView;
	}


	public static String getDate(long milliSeconds, String dateFormat)
	{
		// Create a DateFormatter object for displaying date in specified format.
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

		// Create a calendar object that will convert the date and time value in milliseconds to date.
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		return formatter.format(calendar.getTime());
	}
}

