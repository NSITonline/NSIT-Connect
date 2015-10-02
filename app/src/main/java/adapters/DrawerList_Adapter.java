package adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import nsit.app.com.nsitapp.R;

public class DrawerList_Adapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] web;
    private boolean isSpeakButtonLongPressed;
    private final Integer[] imageId;

    public DrawerList_Adapter(Activity context, String[] web, Integer[] imageId) {
        super(context, R.layout.message, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }

    private class ViewHolder {
        TextView t1;
        ImageView imag;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = mInflater.inflate(R.layout.message, null);
            holder = new ViewHolder();
            holder.t1 = (TextView) view.findViewById(R.id.textView1);
            holder.imag = (ImageView) view.findViewById(R.id.imageView1);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();
        holder.t1.setText(web[position]);
        holder.imag.setImageResource(imageId[position]);
        return view;
    }
}