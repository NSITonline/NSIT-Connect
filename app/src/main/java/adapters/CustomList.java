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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import functions.ButtonAnimation;
import functions.ImageLoader;
import functions.Utils;
import nsit.app.com.nsitapp.Description;
import nsit.app.com.nsitapp.DescriptionFullImage;
import nsit.app.com.nsitapp.R;

/**
 * Adapter for Home page showing NSITOnline feed
 */
public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final List<String> img, des, lik, link, obid, date;
    private final ImageLoader imageLoader;

    /**
     * Returns instance of CustomList adapter
     * @param context   reference
     * @param image     Image link
     * @param desc      Post description
     * @param like      Number of likes
     * @param links     Facebook link
     * @param oid       Object Id for image
     * @param dates     Post date
     */
    public CustomList(Activity context, List<String> image, List<String> desc, List<String> like, List<String> links,
                      List<String> oid, List<String> dates) {
        super(context, R.layout.message_layout, desc);
        this.context = context;
        img = image;
        des = desc;
        lik = like;
        obid = oid;
        link = links;
        date = dates;
        imageLoader = new ImageLoader(context.getApplicationContext());
    }

    private class ViewHolder {
        TextView Des, likes, dates, read;
        ImageView imageView;
        FrameLayout frameLayout;
        Button button;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = mInflater.inflate(R.layout.message_layout, parent, false);
            holder = new ViewHolder();
            holder.Des = (TextView) view.findViewById(R.id.des);
            holder.likes = (TextView) view.findViewById(R.id.likes);
            holder.dates = (TextView) view.findViewById(R.id.date);
            holder.read = (TextView) view.findViewById(R.id.read);
            holder.imageView = (ImageView) view.findViewById(R.id.image);
            holder.frameLayout = (FrameLayout) view.findViewById(R.id.frame);
            holder.button = (Button) view.findViewById(R.id.show);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();

        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar1);

        // Post description
        if (des.get(position) == null)
            holder.Des.setText(R.string.no_description);
        else
            holder.Des.setText(des.get(position));

        // Number of likes
        if (lik.get(position) == null)
            holder.likes.setText("0");
        else
            holder.likes.setText(lik.get(position));

        // Post date
        holder.dates.setVisibility(View.VISIBLE);
        if (date.get(position) != null) {
            String formattedDate = Utils.GetLocalDateStringFromUTCString(date.get(position));
            try {
                DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SSSS", Locale.ENGLISH);
                DateFormat targetFormat = new SimpleDateFormat("dd MMMM , hh:mm a");
                Date date = originalFormat.parse(formattedDate);
                formattedDate = targetFormat.format(date);
            } catch (Exception e) {
                Log.e("ERROR ", e.getMessage() + " ");
            }
            holder.dates.setText(formattedDate);
        } else
            holder.dates.setVisibility(View.INVISIBLE);

        // Read more
        holder.read.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Context c = getContext();
                Intent i = new Intent(getContext(), Description.class);
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

        holder.frameLayout.setVisibility(View.VISIBLE);

        // Display Image
        if (img.get(position) != null) {
            imageLoader.DisplayImage(img.get(position), holder.imageView, progressBar);
            holder.button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Context c = getContext();
                    Intent i = new Intent(getContext(), DescriptionFullImage.class);
                    i.putExtra("img", img.get(position));
                    i.putExtra("oid", obid.get(position));
                    ButtonAnimation btnAnimation = new ButtonAnimation();
                    btnAnimation.animateButton(v, c);
                    c.startActivity(i);
                }
            });

        } else {
            holder.frameLayout.setVisibility(View.GONE);
        }

        // Scrolling animations
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
