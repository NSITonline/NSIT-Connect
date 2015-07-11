package nsit.app.com.nsitapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerList_Adapter extends ArrayAdapter<String>{
	private final Activity context;
	private final String[] web;
	private boolean isSpeakButtonLongPressed ;
	private final Integer[] imageId;
	public DrawerList_Adapter(Activity context, String[] web, Integer[] imageId) {
			super(context, R.layout.message, web);
			this.context = context;
			this.web = web;
			this.imageId = imageId;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.message, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1);
		txtTitle.setText(web[position]);
		imageView.setImageResource(imageId[position]);
		return rowView;
	}
}