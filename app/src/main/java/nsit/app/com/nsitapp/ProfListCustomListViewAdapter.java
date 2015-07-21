package nsit.app.com.nsitapp;

/**
 * Created by dhruvmullick on 09/07/14.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
public class ProfListCustomListViewAdapter extends ArrayAdapter<ProfListRowItem> {

    Context context;
    List<ProfListRowItem> it;
    //private ProfFilter filter;
    public ProfListCustomListViewAdapter(Context context, int resourceId,
                                         List<ProfListRowItem> items) {
        super(context, resourceId, items);
        this.context = context;
        it = items;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView txtName;
        TextView txtPhone;
        TextView txtEmail;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        final ProfListRowItem rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
//            System.out.println("Convert View is Null");
            convertView = mInflater.inflate(R.layout.prof_list_item, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.tvname);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.tvphone);
            holder.txtEmail = (TextView) convertView.findViewById(R.id.tvemail);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }


        holder.txtName.setText(rowItem.getName());
        holder.txtPhone.setText(rowItem.getPhone());
        holder.txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                String[] x = rowItem.getPhone().split("(DID)");
                String p = "tel:" + x[0];
                i.setData(Uri.parse(p));
                getContext().startActivity(i);
            }
        });
        holder.txtEmail.setText(rowItem.getEmail());
        holder.txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { rowItem.getEmail() });
                intent.putExtra(Intent.EXTRA_SUBJECT, " ");
                intent.putExtra(Intent.EXTRA_TEXT, rowItem.getName());
                getContext().startActivity(Intent.createChooser(intent, "ChooseClass..."));
            }
        });

        AnimationSet set = new AnimationSet(true);
        TranslateAnimation slide = new TranslateAnimation(-200,0,-200,0);
        slide.setInterpolator(new DecelerateInterpolator(5.0f));
        slide.setDuration(300);
        Animation fade = new AlphaAnimation(0,1.0f);
        fade.setInterpolator(new DecelerateInterpolator(5.0f));
        fade.setDuration(300);
        set.addAnimation(slide);
        set.addAnimation(fade);
       convertView.startAnimation(set);
        return convertView;
    }



}
