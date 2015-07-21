package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import functions.ImageLoader;

public class CustomList_feed extends ArrayAdapter<String>{
	private final Activity context;
	private final List<String> img,des,lik,link,obid,date;
	public ImageLoader imageLoader;
	public CustomList_feed(Activity context, List<String> image, List<String> desc, List<String> like, List<String> links, List<String> oid, List<String> d){
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
		ImageView imageView;

		imageView = (ImageView) rowView.findViewById(R.id.image);

		TextView d = (TextView) rowView.findViewById(R.id.date);

		if(date.get(position)!=null) {
			String x = GetLocalDateStringFromUTCString(date.get(position));
			String formattedDate = x;
			try {

				DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS", Locale.ENGLISH);
				DateFormat targetFormat = new SimpleDateFormat("dd MMMM , hh:mm a");
				Date date2 = originalFormat.parse(x);
				formattedDate = targetFormat.format(date2);
			} catch (Exception e) {
				Log.e("error", e.getMessage() + " ");
			}

			d.setText(formattedDate);
		}
		else
		d.setVisibility(View.INVISIBLE);

		TextView b = (TextView) rowView.findViewById(R.id.read);


		b.setOnClickListener(new OnClickListener() {
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
				ButtonAnimation btnAnimation = new ButtonAnimation();
				btnAnimation.animateButton(view, c);
				c.startActivity(i);
			}
		});

		ImageView imageView2;

		imageView2 = (ImageView) rowView.findViewById(R.id.image2);

		Button b1 = (Button) rowView.findViewById(R.id.show);

			imageLoader.DisplayImage(img.get(position), imageView);
			b1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					Context c = getContext();
					Intent i = new Intent(getContext(), ImageAct.class);
					i.putExtra("img", img.get(position));
					i.putExtra("oid", obid.get(position));
                    ButtonAnimation btnAnimation = new ButtonAnimation();
                    btnAnimation.animateButton(v, c);
					c.startActivity(i);
				}
			});



			AnimationSet set = new AnimationSet(true);
			TranslateAnimation slide = new TranslateAnimation(-200, 0, -200, 0);
			slide.setInterpolator(new DecelerateInterpolator(5.0f));
			slide.setDuration(300);
			Animation fade = new AlphaAnimation(0, 1.0f);
			fade.setInterpolator(new DecelerateInterpolator(5.0f));
			fade.setDuration(300);
			set.addAnimation(slide);
			set.addAnimation(fade);
				return rowView;
	}

	public String GetLocalDateStringFromUTCString(String utcLongDateTime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS");
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



	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager
				= (ConnectivityManager) getContext().getSystemService(getContext().CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}




