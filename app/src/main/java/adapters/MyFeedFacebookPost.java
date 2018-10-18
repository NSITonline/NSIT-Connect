
package adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import functions.Constant;
import functions.Utils;
import nsit.app.com.nsitapp.Description;
import nsit.app.com.nsitapp.DescriptionFullImage;
import nsit.app.com.nsitapp.R;

import static functions.Utils.setAnimation;


public class MyFeedFacebookPost extends ArrayAdapter<String> implements Constant {
    private final Activity context;
    private final List<String> image, description, like, link, objectId, date, category;

    public MyFeedFacebookPost(Activity context, List<String> image, List<String> desc, List<String> like, List<String> links
            , List<String> oid, List<String> d, List<String> e) {
        super(context, R.layout.message_layout, desc);
        this.context = context;
        this.image = image;
        description = desc;
        this.like = like;
        objectId = oid;
        link = links;
        date = d;
        category = e;
    }

    class ViewHolder {

        @BindView(R.id.des) TextView Des;
        @BindView(R.id.likes) TextView likes;
        @BindView(R.id.date) TextView cats;
        @BindView(R.id.cat) TextView dates;
        @BindView(R.id.read) TextView read;
        @BindView(R.id.image) ImageView imag;
        @BindView(R.id.frame) FrameLayout f;
        @BindView(R.id.show) Button b;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    @NonNull
    @Override
    public View getView(final int position, View view, @NonNull ViewGroup parent) {
        ViewHolder holder;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = mInflater.inflate(R.layout.myfeed_listitem, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else
            holder = (ViewHolder) view.getTag();

        if (description.get(position) == null)
            holder.Des.setText(R.string.no_description);
        else
            holder.Des.setText(description.get(position));


        if (like.get(position) == null)
            holder.likes.setText("0");
        else
            holder.likes.setText(like.get(position));


        if (category.get(position) != null) {
            holder.cats.setText(category.get(position));
        } else
            holder.cats.setText(" ");


        holder.dates.setVisibility(View.VISIBLE);
        if (date.get(position) != null) {
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
        } else
            holder.dates.setVisibility(View.INVISIBLE);

        holder.read.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), Description.class);
            intent.putExtra(DES, description.get(position));
            intent.putExtra(LIKE, like.get(position));
            intent.putExtra(IMAGE, image.get(position));
            intent.putExtra(LINK, link.get(position));
            intent.putExtra(OBID, objectId.get(position));
            context.startActivity(intent);
        });

        holder.f.setVisibility(View.VISIBLE);
        if (image.get(position) != null) {
            Picasso.with(context).load(image.get(position)).into(holder.imag);
            holder.b.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), DescriptionFullImage.class);
                intent.putExtra(IMAGE, image.get(position));
                intent.putExtra(OBID, objectId.get(position));
                context.startActivity(intent);
            });
        } else
            holder.f.setVisibility(View.GONE);

        setAnimation(view);
        return view;
    }

}


