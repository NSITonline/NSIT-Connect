package adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import functions.ButtonAnimation;
import functions.Utils;
import nsit.app.com.nsitapp.Description;
import nsit.app.com.nsitapp.DescriptionFullImage;
import nsit.app.com.nsitapp.R;

import static functions.Constant.DES;
import static functions.Constant.IMAGE;
import static functions.Constant.LIKE;
import static functions.Constant.LINK;
import static functions.Constant.OBID;


public class FacebookPostAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final List<String> image, description, likes, link, objectId, date;

    /**
     * Initialize facebook post item
     *
     * @param context - context
     * @param image   - image of post
     * @param desc    - post description text
     * @param like    - likes count on post
     * @param links   - link of post
     * @param oid     - object id of post [internal use]
     * @param dates   - date of post
     */
    public FacebookPostAdapter(Activity context, List<String> image, List<String> desc, List<String> like, List<String> links,
                               List<String> oid, List<String> dates) {
        super(context, R.layout.message_layout, desc);
        this.context = context;
        this.image = image;
        description = desc;
        likes = like;
        objectId = oid;
        link = links;
        date = dates;
    }

    private class ViewHolder {
        TextView Des, likes, dates, read;
        ImageView imageView;
        FrameLayout frameLayout;
        Button button;
    }

    @NonNull
    @Override
    public View getView(final int position, View view, @NonNull ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = mInflater.inflate(R.layout.message_layout, parent, false);
            holder = new ViewHolder();
            holder.Des = view.findViewById(R.id.des);
            holder.likes = view.findViewById(R.id.likes);
            holder.dates = view.findViewById(R.id.date);
            holder.read = view.findViewById(R.id.read);
            holder.imageView = view.findViewById(R.id.image);
            holder.frameLayout = view.findViewById(R.id.frame);
            holder.button = view.findViewById(R.id.show);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();

        if (description.get(position) == null)
            holder.Des.setText(R.string.no_description);
        else
            holder.Des.setText(description.get(position));

        if (likes.get(position) == null)
            holder.likes.setText("0");
        else
            holder.likes.setText(likes.get(position));

        holder.dates.setVisibility(View.VISIBLE);
        if (date.get(position) != null) {
            String x = Utils.GetLocalDateStringFromUTCString(date.get(position));
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

        holder.read.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), Description.class);
            intent.putExtra(DES, description.get(position));
            intent.putExtra(LIKE, likes.get(position));
            intent.putExtra(IMAGE, image.get(position));
            intent.putExtra(LINK, link.get(position));
            intent.putExtra(OBID, objectId.get(position));
            ButtonAnimation btnAnimation = new ButtonAnimation();
            btnAnimation.animateButton(view1, context);
            context.startActivity(intent);
        });

        holder.frameLayout.setVisibility(View.VISIBLE);
        if (image.get(position) != null) {

            Picasso.with(context).load(image.get(position)).into(holder.imageView);
            holder.button.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), DescriptionFullImage.class);
                intent.putExtra(IMAGE, image.get(position));
                intent.putExtra(OBID, objectId.get(position));
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, context);
                context.startActivity(intent);
            });

        } else {
            holder.frameLayout.setVisibility(View.GONE);
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
}
