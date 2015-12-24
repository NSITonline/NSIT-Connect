package adapters;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import functions.ButtonAnimation;
import functions.DBhelp;
import functions.TableEntry;
import nsit.app.com.nsitapp.Calculator;
import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.SubjectRemove;

public class CustomList_subjects_calculator extends ArrayAdapter<String>{
	private final Activity context;
	private final ArrayList<String> sn,co,na,cre;

	private class ViewHolder {

		TextView sn,co,cred;
		EditText et;

	}
	public CustomList_subjects_calculator(Activity context, ArrayList<String> s, ArrayList<String> c
			, ArrayList<String> n, ArrayList<String> cr) {
		super(context, R.layout.calculator_subject_list_item, s);
		this.context = context;
		sn=c;
		co=c;
		na=n;
		cre=cr;
	}


	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		ViewHolder holder = null;


		if (view == null) {
			view= mInflater.inflate(R.layout.calculator_subject_list_item, null, true);
			holder = new ViewHolder();
			holder.sn = (TextView) view.findViewById(R.id.sno);
			holder.co = (TextView) view.findViewById(R.id.code);
			holder.cred = (TextView) view.findViewById(R.id.credits);
			holder.et = (EditText) view.findViewById(R.id.marks);
			holder.sn.setText(sn.get(position));
			holder.co.setText(co.get(position));
			holder.cred.setText(cre.get(position));
			view.setTag(holder);
		} else
			holder = (ViewHolder) view.getTag();



		return view;
	}



}