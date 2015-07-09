package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomList3 extends ArrayAdapter<Subject_struct>{
	private final Activity context;
	ArrayList<String> day;
	int h;
	private final ArrayList<Subject_struct> p1,p2,p3,p4,p5,p6,p7,p8,p9;
	public CustomList3(Activity context,ArrayList  d,ArrayList<Subject_struct> b1,ArrayList<Subject_struct> b2,ArrayList<Subject_struct> b3,ArrayList<Subject_struct> b4,
					   ArrayList<Subject_struct> b5,ArrayList<Subject_struct> b6,ArrayList<Subject_struct> b7
			,ArrayList<Subject_struct> b8,ArrayList<Subject_struct> b9) {
			super(context, R.layout.message, d);
			this.context = context;
			day=d;
		p1=b1;
		p2=b2;
		p3=b3;
		p4=b4;
		p5=b5;
		p6=b6;
		p7=b7;
		p8=b8;
		p9=b9;

	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.timetable_row_layout, null, true);
		TextView txtTitle;
		txtTitle= (TextView) rowView.findViewById(R.id.day);
		txtTitle.setText(day.get(position));
		txtTitle= (TextView) rowView.findViewById(R.id.p1);
		SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
		String half = s.getString("half", null);
		if(half.contains("first"))
			h=1;
		else
		h=2;

		add(p1.get(position),txtTitle);

		txtTitle= (TextView) rowView.findViewById(R.id.p2);
		add(p2.get(position),txtTitle);

		txtTitle= (TextView) rowView.findViewById(R.id.p3);
		add(p3.get(position), txtTitle);

		txtTitle= (TextView) rowView.findViewById(R.id.p4);
		add(p4.get(position),txtTitle);

		txtTitle= (TextView) rowView.findViewById(R.id.p5);
		add(p5.get(position),txtTitle);

		txtTitle= (TextView) rowView.findViewById(R.id.p6);
		add(p6.get(position), txtTitle);

		txtTitle= (TextView) rowView.findViewById(R.id.p7);
		add(p7.get(position), txtTitle);

		txtTitle= (TextView) rowView.findViewById(R.id.p8);
		add(p8.get(position), txtTitle);

		txtTitle= (TextView) rowView.findViewById(R.id.p9);
		if(position< p9.size())
			add(p9.get(position),txtTitle);

		return rowView;
	}


	public void add(Subject_struct p,TextView t){



		if(!p.subject.contains("break"))
			if(p.type.contains("theory"))
			t.setText(p.subject + "\n" + p.room);
			else{
			if(h==1)
				t.setText(p.subject + "\n" + p.roomfh);
			else
				t.setText(p.subject + "\n" + p.roomsh);

			}
		else
			t.setText("Break");

	}

}