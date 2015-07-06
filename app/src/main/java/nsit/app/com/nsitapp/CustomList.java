package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
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

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
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
		ImageView imageView;

		imageView = (ImageView) rowView.findViewById(R.id.image);

		TextView d = (TextView) rowView.findViewById(R.id.date);

		String x = GetLocalDateStringFromUTCString(date.get(position));
		String formattedDate=x;
try {

	DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS", Locale.ENGLISH);
	DateFormat targetFormat = new SimpleDateFormat("dd MMMM , hh:mm a");
	Date date2 = originalFormat.parse(x);
	formattedDate = targetFormat.format(date2);
}catch(Exception e){
	Log.e("error",e.getMessage()+" ");
}

		d.setText(formattedDate);




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



		if (img.get(position) == null)
			imageView.setVisibility(View.GONE);
		else {


			if(obid.get(position)==null)
				imageLoader.DisplayImage(img.get(position), imageView);
			else{
				new DownloadWebPageTask(obid.get(position),img.get(position),imageView).execute();
			}


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
		}
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



	private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
		String obids,imgs;
		ImageView imageView;
		String text,imglink;
		private  DownloadWebPageTask(String a,String b,ImageView imageView){
			obids = a;
			imgs = b;
			this.imageView = imageView;
		}
		@Override
		protected String doInBackground(String... urls) {

			String URL = "https://graph.facebook.com/"+obids+"?fields=images&access_token="+ Val.common_access;
			HttpClient Client = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(URL);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			try {
				text = Client.execute(httpget, responseHandler);
			} catch (IOException e) {
				e.printStackTrace();
				Log.e("eroore",e.getMessage());
			}

			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			JSONObject ob;
			JSONArray arr;
			if(text==null){

				imageLoader.DisplayImage(imgs, imageView);

			}else {
				try {
					ob = new JSONObject(text);

					arr = ob.getJSONArray("images");

					if (arr.getJSONObject(0).has("source"))
						imglink = arr.getJSONObject(0).getString("source");
					if (imglink != null) {
						if (isNetworkAvailable()) {
							imageLoader.DisplayImage(imglink, imageView);

						}
					} else {
						imageView.setVisibility(View.GONE);

					}

				} catch (Exception e) {
					Log.e("yo", "" + e.getMessage());
				}
			}

	}
	}


	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager
				= (ConnectivityManager) getContext().getSystemService(getContext().CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}




