package adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import butterknife.BindView;
import butterknife.ButterKnife;
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
import static functions.Utils.setAnimation;


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

    public class ViewHolder {
        @BindView(R.id.des)
        TextView Des;
        @BindView(R.id.likes)
        TextView likes;
        @BindView(R.id.date)
        TextView dates;
        @BindView(R.id.read)
        TextView read;
        @BindView(R.id.image)
        ImageView imageView;
        @BindView(R.id.frame)
        FrameLayout frameLayout;
        @BindView(R.id.show)
        Button button;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @NonNull
    @Override
    public View getView(final int position, View view, @NonNull ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = mInflater.inflate(R.layout.message_layout, parent, false);
            holder = new ViewHolder(view);
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

        setAnimation(view);
        return view;
    }
}
