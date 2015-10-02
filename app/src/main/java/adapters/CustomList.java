package adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;

import functions.ButtonAnimation;


import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import functions.ImageLoader;
import nsit.app.com.nsitapp.Decsription;
import nsit.app.com.nsitapp.ImageAct;
import nsit.app.com.nsitapp.R;


public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final List<String> img, des, lik, link, obid, date;
    public ImageLoader imageLoader;
    ProgressBar p;

    public CustomList(Activity context, List<String> image, List<String> desc, List<String> like, List<String> links, List<String> oid, List<String> d) {
        super(context, R.layout.message_layout, desc);
        this.context = context;
        img = image;
        des = desc;
        lik = like;
        obid = oid;
        link = links;
        date = d;
        imageLoader = new ImageLoader(context.getApplicationContext());
    }

    private class ViewHolder {

        TextView Des;
        TextView likes;
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
            view = mInflater.inflate(R.layout.message_layout, null);

            holder = new ViewHolder();
            holder.Des = (TextView) view.findViewById(R.id.des);
            holder.likes = (TextView) view.findViewById(R.id.likes);
            holder.dates = (TextView) view.findViewById(R.id.date);
            holder.read = (TextView) view.findViewById(R.id.read);
            holder.imag = (ImageView) view.findViewById(R.id.image);
            holder.f = (FrameLayout) view.findViewById(R.id.frame);
            holder.b = (Button) view.findViewById(R.id.show);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();

        p = (ProgressBar) view.findViewById(R.id.progressBar1);


        if (des.get(position) == null)
            holder.Des.setText("No description");
        else
            holder.Des.setText(des.get(position));


        if (lik.get(position) == null)
            holder.likes.setText("0");
        else
            holder.likes.setText(lik.get(position));


        holder.dates.setVisibility(View.VISIBLE);
        if (date.get(position) != null) {
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

            holder.dates.setText(formattedDate);
        } else
            holder.dates.setVisibility(View.INVISIBLE);

        holder.read.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
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

        holder.f.setVisibility(View.VISIBLE);
        if (img.get(position) != null) {

            imageLoader.DisplayImage(img.get(position), holder.imag, p);
            holder.b.setOnClickListener(new OnClickListener() {

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

        } else {
            holder.f.setVisibility(View.GONE);
        }

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

    public String GetLocalDateStringFromUTCString(String utcLongDateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS");
        String localDateString = null;

        long when = 0;
        try {
            when = dateFormat.parse(utcLongDateTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        localDateString = dateFormat.format(new Date(when + TimeZone.getDefault().getRawOffset() +
                (TimeZone.getDefault().inDaylightTime(new Date()) ? TimeZone.getDefault().getDSTSavings() : 0)));
        return localDateString;
    }

}
