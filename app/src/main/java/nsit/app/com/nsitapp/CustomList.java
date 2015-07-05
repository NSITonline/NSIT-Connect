package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import functions.ImageLoader;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CustomList extends ArrayAdapter<String>{
	private final Activity context;
	private final List<String> img,des,lik,link,obid,date;
	public ImageLoader imageLoader;
	String obids;
	public CustomList(Activity context,List<String>image, List<String>desc, List<String>like,List<String>links,List<String>oid,List<String>d){
		super(context, R.layout.message_layout, desc);
		this.context = context;
		img=image;
		des=desc;
		lik=like;
		obid=oid;
		link = links;
		date=d;
		imageLoader=new ImageLoader(context.getApplicationContext());
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		ProgressBar pb, pb2;

		View rowView = inflater.inflate(R.layout.message_layout, null, true);
		pb = (ProgressBar) rowView.findViewById(R.id.progressBar1);

		TextView txtTitle = (TextView) rowView.findViewById(R.id.des);
		txtTitle.setText(des.get(position));
		TextView like = (TextView) rowView.findViewById(R.id.likes);
		if (lik.get(position) == null)
			like.setText("0");
		else
			like.setText(lik.get(position));
		ImageView imageView = (ImageView) rowView.findViewById(R.id.image);

		TextView d = (TextView) rowView.findViewById(R.id.date);

		Date dates=null;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		try {
			dates = format.parse(date.get(position));
		}catch (Exception e){
			//Log.e("vsf",e.getMessage());
		}



if(dates!=null) {
	DateFormat formatter = new SimpleDateFormat("dd MMMM, HH:mm");
	String dateFormatted = formatter.format(dates);

	d.setText(dateFormatted);
}
			LinearLayout l = (LinearLayout) rowView.findViewById(R.id.data);

		l.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Context c = getContext();
				Intent i = new Intent(getContext(), Decsription.class);
				i.putExtra("dec", des.get(position));
				i.putExtra("like", lik.get(position));
				i.putExtra("img", img.get(position));
				i.putExtra("link", link.get(position));
				i.putExtra("oid", obid.get(position));
				c.startActivity(i);
			}
		});

		imageLoader.DisplayImage(img.get(position), imageView);


		if (img.get(position) == null)
			imageView.setVisibility(View.GONE);
		else
			imageView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Context c = getContext();
					Intent i = new Intent(getContext(), ImageAct.class);
					i.putExtra("img", img.get(position));
					i.putExtra("oid", obid.get(position));
					c.startActivity(i);

				}
			});
		return rowView;
	}

	public String GetLocalDateStringFromUTCString(String utcLongDateTime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String localDateString = null;

		long when = 0;
		try {
			when = dateFormat.parse(utcLongDateTime).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		localDateString = dateFormat.format(new Date(when + TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().inDaylightTime(new Date()) ? TimeZone.getDefault().getDSTSavings() : 0)));

		return localDateString;
	}


		public static Timestamp convertStringToTimestamp(String str_date) {
			try {
				DateFormat formatter;
				formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// you can change format of date
				Date date = formatter.parse(str_date);
				java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

				return timeStampDate;
			} catch (ParseException e) {
				System.out.println("Exception :" + e);
				return null;
			}
		}
	}




