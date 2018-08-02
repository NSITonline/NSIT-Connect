package nsit.app.com.nsitapp.Hangout;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.HangoutTypeObject;
import nsit.app.com.nsitapp.PlaceMapActivity;
import nsit.app.com.nsitapp.R;

public class HangoutTypeAdapter extends BaseAdapter {

    public static final String INTENT_LATI = "Lati";
    public static final String INTENT_LONG = "Long";
    public static final String INTENT_PLACE_NAME = "place_name";
    public static final String INTENT_PLACE_ID = "place_id";
    private final Context mContext;
    private final ArrayList<HangoutTypeObject> hangoutObjects;

    HangoutTypeAdapter(Context context, ArrayList<HangoutTypeObject> object) {
        mContext = context;
        hangoutObjects = object;
    }

    @Override
    public int getCount() {
        return hangoutObjects.size();
    }

    @Override
    public Object getItem(int i) {
        return hangoutObjects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {

        ViewHolder holder;
        if (convertview == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.hangouttype_listitem, viewGroup, false);
            holder = new ViewHolder(convertview);
            convertview.setTag(holder);
        } else
            holder = (ViewHolder) convertview.getTag();

        holder.placename.setText(hangoutObjects.get(i).getName());
        holder.placename.setId(i);

        holder.vicinity.setText(hangoutObjects.get(i).getVicinity());
        holder.vicinity.setId(i);

        holder.rating.setRating(hangoutObjects.get(i).getRating());
        holder.rating.setId(i);

        if (hangoutObjects.get(i).phtotref != null)
            Picasso.with(mContext)
                    .load("https://maps.googleapis.com/maps/api/place/photo?maxheight=145&photoreference=" + hangoutObjects.get(i).phtotref + "&key=AIzaSyBz-tWFzOVJRWUBuF6TYkd5T2SfPOfV-GE")
                    .placeholder(R.drawable.imagenotavailable)
                    .error(R.drawable.imagenotavailable)
                    .into(holder.placephoto);
        else
            Picasso.with(mContext).load(R.drawable.imagenotavailable).into(holder.placephoto);

        if (hangoutObjects.get(i).getopennowv())
            holder.placeopen.setText(R.string.open_now);
        else
            holder.placeopen.setText(R.string.close_now);
        holder.placeopen.setId(i);

        final int position = i;
        holder.placelocate.setId(i);
        holder.placelocate.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, PlaceMapActivity.class);
            intent.putExtra(INTENT_LATI, hangoutObjects.get(position).getLatitude());
            intent.putExtra(INTENT_LONG, hangoutObjects.get(position).getLongitude());
            intent.putExtra(INTENT_PLACE_NAME, hangoutObjects.get(position).getName());
            intent.putExtra(INTENT_PLACE_ID, hangoutObjects.get(position).getId());
            mContext.startActivity(intent);
        });

        AnimationSet set = new AnimationSet(true);
        TranslateAnimation slide = new TranslateAnimation(-200, 0, -200, 0);
        slide.setInterpolator(new DecelerateInterpolator(5.0f));
        slide.setDuration(300);
        Animation fade = new AlphaAnimation(0, 1.0f);
        fade.setInterpolator(new DecelerateInterpolator(5.0f));
        fade.setDuration(300);
        set.addAnimation(slide);
        set.addAnimation(fade);
        convertview.startAnimation(set);
        return convertview;
    }

    class ViewHolder {
        @BindView(R.id.hangottype_photo)
        ImageView placephoto;
        @BindView(R.id.title_hangout_type)
        TextView placename;
        @BindView(R.id.vicinity)
        TextView vicinity;
        @BindView(R.id.rating_bar)
        RatingBar rating;
        @BindView(R.id.open_close)
        TextView placeopen;
        @BindView(R.id.locate_button)
        LinearLayout placelocate;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}