package nsit.app.com.nsitapp;

import android.app.Activity;
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
	private final ArrayList<Subject_struct> p1,p2,p3,p4,p5,p6,p7,p8;
	public CustomList3(Activity context,ArrayList  d,ArrayList<Subject_struct> b1,ArrayList<Subject_struct> b2,ArrayList<Subject_struct> b3,ArrayList<Subject_struct> b4,
					   ArrayList<Subject_struct> b5,ArrayList<Subject_struct> b6,ArrayList<Subject_struct> b7,ArrayList<Subject_struct> b8) {
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

	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.timetable_row_layout, null, true);
		TextView txtTitle;
		txtTitle= (TextView) rowView.findViewById(R.id.day);
		txtTitle.setText(day.get(position));
		txtTitle= (TextView) rowView.findViewById(R.id.p1);
		txtTitle.setText(p1.get(position).subject + "\n" + p1.get(position).room);
		txtTitle= (TextView) rowView.findViewById(R.id.p2);
		txtTitle.setText(p2.get(position).subject+"\n" + p2.get(position).room);
		txtTitle= (TextView) rowView.findViewById(R.id.p3);
		txtTitle.setText(p3.get(position).subject+"\n" + p3.get(position).room);
		txtTitle= (TextView) rowView.findViewById(R.id.p4);
		txtTitle.setText(p4.get(position).subject+"\n" + p4.get(position).room);
		txtTitle= (TextView) rowView.findViewById(R.id.p5);
		txtTitle.setText(p5.get(position).subject+"\n" + p5.get(position).room);
		txtTitle= (TextView) rowView.findViewById(R.id.p6);
		txtTitle.setText(p6.get(position).subject+"\n" + p6.get(position).room);
		txtTitle= (TextView) rowView.findViewById(R.id.p7);
		txtTitle.setText(p7.get(position).subject+"\n" + p7.get(position).room);
		txtTitle= (TextView) rowView.findViewById(R.id.p8);
		txtTitle.setText(p8.get(position).subject+"\n" + p8.get(position).room);

		return rowView;
	}



}