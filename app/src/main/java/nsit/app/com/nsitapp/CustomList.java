package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import functions.ImageLoader;

public class CustomList extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] img,des,lik,link,obid;
	public ImageLoader imageLoader;
	public CustomList(Activity context,String[] image, String[] desc, String[] like,String[] links,String[] oid){
		super(context, R.layout.message_layout, desc);
		this.context = context;
		img=image;
		des=desc;
		lik=like;
		obid=oid;
		link = links;
		imageLoader=new ImageLoader(context.getApplicationContext());
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();

		View rowView= inflater.inflate(R.layout.message_layout, null, true);

		TextView txtTitle = (TextView) rowView.findViewById(R.id.des);
		txtTitle.setText(des[position]);
		TextView like = (TextView) rowView.findViewById(R.id.likes);
		if(lik[position]==null)
			like.setText("0");
		else
			like.setText(lik[position]);
			ImageView imageView = (ImageView) rowView.findViewById(R.id.image);

		LinearLayout l = (LinearLayout) rowView.findViewById(R.id.data);

		l.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Context c = getContext();
				Intent i = new Intent(getContext(),Decsription.class);
				i.putExtra("dec",des[position]);
				i.putExtra("like",lik[position]);
				i.putExtra("img",img[position]);
				i.putExtra("link",link[position]);
				i.putExtra("oid",obid[position]);
				c.startActivity(i);
			}
		});

		imageLoader.DisplayImage(img[position], imageView);


		if(img[position]==null)
			imageView.setVisibility(View.GONE);
		else
		imageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Context c = getContext();
				Intent i = new Intent(getContext(),ImageAct.class);
				i.putExtra("img",img[position]);
				i.putExtra("oid",obid[position]);
				c.startActivity(i);

			}
		});
		return rowView;
	}




}