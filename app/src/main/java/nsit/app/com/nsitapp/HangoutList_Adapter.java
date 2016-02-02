<<<<<<< HEAD
package nsit.app.com.nsitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AGGARWAL'S on 10/11/2015.
 */
public class HangoutList_Adapter extends BaseAdapter {

    private String[] HangoutPlaces = {
            "College",
            "Restaurant","Cafes","Night Clubs","Shopping Malls","Bowling","Movie","Food","Amusement Parks","Park"};
    private Integer[] Imageids = {
            R.drawable.ic_school_black_24dp,
            R.drawable.restauarnts,
            R.drawable.coffee,
            R.drawable.nightclubs,
            R.drawable.shoppingmall,
            R.drawable.bowling,
            R.drawable.movie,
            R.drawable.food,
            R.drawable.amusment_park,
            R.drawable.park};
    private Context mContext;

    public HangoutList_Adapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return HangoutPlaces.length;
    }

    @Override
    public Object getItem(int i) {
        return HangoutPlaces[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertview == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.hangout_listitem,null);
            viewHolder.HangoutTypeText = (TextView)convertview.findViewById(R.id.HangoutType);
            viewHolder.HangoutTypeImage = (ImageView)convertview.findViewById(R.id.HangoutTypeImage);
            convertview.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder)convertview.getTag();

        viewHolder.HangoutTypeText.setText(HangoutPlaces[i]);
        viewHolder.HangoutTypeText.setId(i);

        viewHolder.HangoutTypeImage.setImageResource(Imageids[i]);
        viewHolder.HangoutTypeImage.setId(i);
        AnimationSet set = new AnimationSet(true);
        Animation in  = AnimationUtils.loadAnimation(mContext,android.R.anim.slide_in_left);
        in.setDuration(300);
        Animation fade = new AlphaAnimation(0,1.0f);
        fade.setInterpolator(new DecelerateInterpolator(5.0f));
        fade.setDuration(300);
        set.addAnimation(in);
        set.addAnimation(fade);
        convertview.startAnimation(set);
        return convertview;
    }

    class ViewHolder {
        TextView HangoutTypeText;
        ImageView HangoutTypeImage;
    }
}
=======
package nsit.app.com.nsitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AGGARWAL'S on 10/11/2015.
 */
public class HangoutList_Adapter extends BaseAdapter {

    private String[] HangoutPlaces = {
            "College",
            "Restaurant","Cafes","Night Clubs","Shopping Malls","Bowling","Movie","Food","Amusement Parks","Park"};
    private Integer[] Imageids = {
            R.drawable.ic_school_black_24dp,
            R.drawable.restauarnts,
            R.drawable.coffee,
            R.drawable.nightclubs,
            R.drawable.shoppingmall,
            R.drawable.bowling,
            R.drawable.movie,
            R.drawable.food,
            R.drawable.amusment_park,
            R.drawable.park};
    private Context mContext;

    public HangoutList_Adapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return HangoutPlaces.length;
    }

    @Override
    public Object getItem(int i) {
        return HangoutPlaces[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertview == null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflater.inflate(R.layout.hangout_listitem,null);
            viewHolder.HangoutTypeText = (TextView)convertview.findViewById(R.id.HangoutType);
            viewHolder.HangoutTypeImage = (ImageView)convertview.findViewById(R.id.HangoutTypeImage);
            convertview.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder)convertview.getTag();

        viewHolder.HangoutTypeText.setText(HangoutPlaces[i]);
        viewHolder.HangoutTypeText.setId(i);

        viewHolder.HangoutTypeImage.setImageResource(Imageids[i]);
        viewHolder.HangoutTypeImage.setId(i);
        AnimationSet set = new AnimationSet(true);
        Animation in  = AnimationUtils.loadAnimation(mContext,android.R.anim.slide_in_left);
        in.setDuration(300);
        Animation fade = new AlphaAnimation(0,1.0f);
        fade.setInterpolator(new DecelerateInterpolator(5.0f));
        fade.setDuration(300);
        set.addAnimation(in);
        set.addAnimation(fade);
        convertview.startAnimation(set);
        return convertview;
    }

    class ViewHolder {
        TextView HangoutTypeText;
        ImageView HangoutTypeImage;
    }
}
>>>>>>> refs/remotes/Swati4star/master
