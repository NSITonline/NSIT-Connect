
package adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import functions.Constant;
import functions.ImageLoader;
import functions.Utils;
import nsit.app.com.nsitapp.Description;
import nsit.app.com.nsitapp.Description_FullImage;
import nsit.app.com.nsitapp.R;


public class MyFeedList extends ArrayAdapter<String> implements Constant{
    private final Activity context;
    private final List<String> img,des,lik,link,obid,date,cat;
    private ImageLoader imageLoader;
    public MyFeedList(Activity context,List<String>image, List<String>desc, List<String>like,List<String>links
            ,List<String>oid,List<String>d,List<String>e){
        super(context, R.layout.message_layout, desc);
        this.context = context;
        img=image;
        des=desc;
        lik=like;
        obid=oid;
        link = links;
        date=d;
        cat =e;
        imageLoader=new ImageLoader(context.getApplicationContext());
    }

    private class ViewHolder {

        TextView Des;
        TextView likes, cats;
        TextView dates;
        TextView read;
        ImageView imag;
        FrameLayout f;
        Button b;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = mInflater.inflate(R.layout.myfeed_listitem, null);
            holder = new ViewHolder();
            holder.Des = (TextView) view.findViewById(R.id.des);
            holder.likes = (TextView) view.findViewById(R.id.likes);
            holder.dates = (TextView) view.findViewById(R.id.date);
            holder.cats = (TextView) view.findViewById(R.id.cat);
            holder.read = (TextView) view.findViewById(R.id.read);
            holder.imag = (ImageView) view.findViewById(R.id.image);
            holder.f = (FrameLayout) view.findViewById(R.id.frame);
            holder.b = (Button) view.findViewById(R.id.show);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();

        ProgressBar p = (ProgressBar) view.findViewById(R.id.progressBar1);


        if(des.get(position)==null)
            holder.Des.setText(R.string.no_description);
        else
            holder.Des.setText(des.get(position));


        if (lik.get(position) == null)
            holder.likes.setText("0");
        else
            holder.likes.setText(lik.get(position));


        if(cat.get(position)!=null) {
            holder.cats.setText(cat.get(position));
        }
        else
            holder.cats.setText(" ");


        holder.dates.setVisibility(View.VISIBLE);
        if(date.get(position)!=null) {
            String x = Utils.GetLocalDateStringFromUTCString(date.get(position));
            String formattedDate = x;
            try {

                DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS", Locale.ENGLISH);
                DateFormat targetFormat = new SimpleDateFormat("dd MMMM , hh:mm a");
                Date date2 = originalFormat.parse(x);
                formattedDate = targetFormat.format(date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            holder.dates.setText(formattedDate);
        }
        else
            holder.dates.setVisibility(View.INVISIBLE);


        holder.read.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Context c = getContext();
                Intent i = new Intent(getContext(), Description.class);
                i.putExtra(DES, des.get(position));
                i.putExtra(LIKE, lik.get(position));
                i.putExtra(IMAGE, img.get(position));
                i.putExtra(LINK, link.get(position));
                i.putExtra(OBID, obid.get(position));
                c.startActivity(i);
            }
        });

        holder.f.setVisibility(View.VISIBLE);
        if(img.get(position)!=null) {
            imageLoader.DisplayImage(img.get(position),  holder.imag,p);
            holder.b.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Context c = getContext();
                    Intent i = new Intent(getContext(), Description_FullImage.class);
                    i.putExtra(IMAGE, img.get(position));
                    i.putExtra(OBID, obid.get(position));
                    c.startActivity(i);

                }
            });

        }else
            holder.f.setVisibility(View.GONE);


        AnimationSet set = new AnimationSet(true);
        TranslateAnimation slide = new TranslateAnimation(-100, 0, -100, 0);
        slide.setInterpolator(new DecelerateInterpolator(5.0f));
        slide.setDuration(300);
        Animation fade = new AlphaAnimation(0, 1.0f);
        fade.setInterpolator(new DecelerateInterpolator(5.0f));
        fade.setDuration(300);
        set.addAnimation(slide);
        set.addAnimation(fade);
        view.startAnimation(set);

        return view;
    }

}


