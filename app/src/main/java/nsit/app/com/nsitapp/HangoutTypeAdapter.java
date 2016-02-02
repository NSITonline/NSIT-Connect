<<<<<<< HEAD
package nsit.app.com.nsitapp;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AGGARWAL'S on 10/21/2015.
 */
public class HangoutTypeAdapter extends BaseAdapter {

    public static final String INTENT_LATI = "Lati";
    public static final String INTENT_LONG = "Long";
    public static final String INTENT_PLACE_NAME = "place_name";
    public static final String INTENT_PLACE_ID = "place_id";
    private Context mContext;
    private ArrayList<HangoutTypeObject> hangoutObjects;

    public HangoutTypeAdapter(Context context,ArrayList<HangoutTypeObject> object){
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
        ViewHolder holder = new ViewHolder();

        if (convertview == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.hangouttype_listitem,null);
            holder.placephoto = (ImageView)convertview.findViewById(R.id.hangottype_photo);
            holder.placename = (TextView)convertview.findViewById(R.id.title_hangout_type);
            holder.vicinity = (TextView)convertview.findViewById(R.id.vicinity);
            holder.rating = (RatingBar)convertview.findViewById(R.id.rating_bar);
            holder.placeopen = (TextView)convertview.findViewById(R.id.open_close);
            holder.placelocate = (LinearLayout)convertview.findViewById(R.id.locate_button);
            convertview.setTag(holder);
        }else
            holder = (ViewHolder)convertview.getTag();

        holder.placename.setText(hangoutObjects.get(i).getName());
        holder.placename.setId(i);

        holder.vicinity.setText(hangoutObjects.get(i).getVicinity());
        holder.vicinity.setId(i);

        holder.rating.setRating(hangoutObjects.get(i).getRating());
        holder.rating.setId(i);

        if (hangoutObjects.get(i).phtotref != null)
        Picasso.with(mContext).load("https://maps.googleapis.com/maps/api/place/photo?maxheight=145&photoreference="+hangoutObjects.get(i).phtotref+"&key=AIzaSyBz-tWFzOVJRWUBuF6TYkd5T2SfPOfV-GE").into(holder.placephoto);
        else
        Picasso.with(mContext).load(R.drawable.imagenotavailable).into(holder.placephoto);

        if (hangoutObjects.get(i).getopennowv())
            holder.placeopen.setText("OPEN NOW");
        else
            holder.placeopen.setText("CLOSED NOW");
        holder.placeopen.setId(i);

        final int position = i;
        holder.placelocate.setId(i);
        holder.placelocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PlaceMapActivity.class);
                intent.putExtra(INTENT_LATI, hangoutObjects.get(position).getLatti());
                intent.putExtra(INTENT_LONG, hangoutObjects.get(position).getLongi());
                intent.putExtra(INTENT_PLACE_NAME, hangoutObjects.get(position).getName());
                intent.putExtra(INTENT_PLACE_ID, hangoutObjects.get(position).getPlace_id());
                mContext.startActivity(intent);
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
        convertview.startAnimation(set);
        return convertview;
    }

    class ViewHolder {
        ImageView placephoto;
        TextView placename;
        TextView vicinity;
        RatingBar rating;
        TextView placeopen;
        LinearLayout placelocate;

    }
}
=======
package nsit.app.com.nsitapp;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by AGGARWAL'S on 10/21/2015.
 */
public class HangoutTypeAdapter extends BaseAdapter {

    public static final String INTENT_LATI = "Lati";
    public static final String INTENT_LONG = "Long";
    public static final String INTENT_PLACE_NAME = "place_name";
    public static final String INTENT_PLACE_ID = "place_id";
    private Context mContext;
    private ArrayList<HangoutTypeObject> hangoutObjects;

    public HangoutTypeAdapter(Context context,ArrayList<HangoutTypeObject> object){
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
        ViewHolder holder = new ViewHolder();

        if (convertview == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.hangouttype_listitem,null);
            holder.placephoto = (ImageView)convertview.findViewById(R.id.hangottype_photo);
            holder.placename = (TextView)convertview.findViewById(R.id.title_hangout_type);
            holder.vicinity = (TextView)convertview.findViewById(R.id.vicinity);
            holder.rating = (RatingBar)convertview.findViewById(R.id.rating_bar);
            holder.placeopen = (TextView)convertview.findViewById(R.id.open_close);
            holder.placelocate = (LinearLayout)convertview.findViewById(R.id.locate_button);
            convertview.setTag(holder);
        }else
            holder = (ViewHolder)convertview.getTag();

        holder.placename.setText(hangoutObjects.get(i).getName());
        holder.placename.setId(i);

        holder.vicinity.setText(hangoutObjects.get(i).getVicinity());
        holder.vicinity.setId(i);

        holder.rating.setRating(hangoutObjects.get(i).getRating());
        holder.rating.setId(i);

        if (hangoutObjects.get(i).phtotref != null)
        Picasso.with(mContext).load("https://maps.googleapis.com/maps/api/place/photo?maxheight=145&photoreference="+hangoutObjects.get(i).phtotref+"&key=AIzaSyBz-tWFzOVJRWUBuF6TYkd5T2SfPOfV-GE").into(holder.placephoto);
        else
        Picasso.with(mContext).load(R.drawable.imagenotavailable).into(holder.placephoto);

        if (hangoutObjects.get(i).getopennowv())
            holder.placeopen.setText("OPEN NOW");
        else
            holder.placeopen.setText("CLOSED NOW");
        holder.placeopen.setId(i);

        final int position = i;
        holder.placelocate.setId(i);
        holder.placelocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PlaceMapActivity.class);
                intent.putExtra(INTENT_LATI, hangoutObjects.get(position).getLatti());
                intent.putExtra(INTENT_LONG, hangoutObjects.get(position).getLongi());
                intent.putExtra(INTENT_PLACE_NAME, hangoutObjects.get(position).getName());
                intent.putExtra(INTENT_PLACE_ID, hangoutObjects.get(position).getPlace_id());
                mContext.startActivity(intent);
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
        convertview.startAnimation(set);
        return convertview;
    }

    class ViewHolder {
        ImageView placephoto;
        TextView placename;
        TextView vicinity;
        RatingBar rating;
        TextView placeopen;
        LinearLayout placelocate;

    }
}
>>>>>>> refs/remotes/Swati4star/master
