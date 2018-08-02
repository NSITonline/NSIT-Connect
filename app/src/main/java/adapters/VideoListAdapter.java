package adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.DateFormatSymbols;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import functions.ButtonAnimation;
import nsit.app.com.nsitapp.R;

/**
 * Created by Sidharth Patro on 22-Jun-15.
 */
public class VideoListAdapter extends BaseAdapter {

    private final JSONArray FeedItems;
    private static LayoutInflater inflater = null;
    private Context context;

    public VideoListAdapter(Context context, JSONArray FeedItems) {
        this.FeedItems = FeedItems;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @Override
    public int getCount() {
        return FeedItems.length();
    }

    @Override
    public Object getItem(int position) {
        try {
            return FeedItems.getJSONObject(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private String processDate(String Date) {
        String tempArray[] = Date.split("-");
        String Year = tempArray[0];
        String Day = tempArray[2].split("T")[0];
        int MonthInt = Integer.parseInt(tempArray[1]);
        String Month = new DateFormatSymbols().getMonths()[MonthInt-1];
        return Day + " " + Month + " " + Year;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.video_listitem, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        String VideoId = null;
        try {
            holder.title.setText(FeedItems.getJSONObject(position).getJSONObject("snippet").getString("title"));
            String DescriptionText = FeedItems.getJSONObject(position).getJSONObject("snippet").getString("description");
            if (Objects.equals(DescriptionText, "")) {
                holder.description.setText(R.string.no_description);
            }
            String publishedAt = processDate(FeedItems.getJSONObject(position).getJSONObject("snippet").getString("publishedAt"));
            holder.dateTxt.setText(publishedAt);
            VideoId = FeedItems.getJSONObject(position).getJSONObject("snippet").getJSONObject("resourceId").getString("videoId");
            if (FeedItems.getJSONObject(position).getJSONObject("snippet").getJSONObject("thumbnails").has("maxres")) {
                Picasso.with(context).load(FeedItems.getJSONObject(position).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("maxres").getString("url")).into(holder.VideoThumbnail);
            } else {
                Picasso.with(context).load(FeedItems.getJSONObject(position).getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").getString("url")).into(holder.VideoThumbnail);
            }
            Log.v("FeedItem", FeedItems.get(position).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String finalVideoId = VideoId;
        holder.playCont.setOnClickListener(v -> {
            Activity activity = (Activity) context;
            try {
                Log.e("activity", activity.toString());
                Log.e("finalVideoId", finalVideoId);
                Intent intent = YouTubeStandalonePlayer.createVideoIntent(activity, "AIzaSyD-hWnEb2F-94y6XyaG5WlKXZKBpKr9PaE", finalVideoId);
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, activity);
                activity.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                alertDialog.setTitle("YouTube API not found.");
                alertDialog.setMessage("This section needs YouTube app to be installed on your device. Please get it from the Google Play Store.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, context.getResources().getString(R.string.filter_dialog_ok),
                        (dialog, which) -> dialog.dismiss());
                alertDialog.show();
                e.printStackTrace();
            } catch (Exception e) {
                AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                alertDialog.setTitle("Oops!");
                alertDialog.setMessage("The error exception is " + e.toString() + " ; Send this to us and we will get this fixed.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, context.getResources().getString(R.string.filter_dialog_ok),
                        (dialog, which) -> dialog.dismiss());
                alertDialog.show();
            }
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
        convertView.startAnimation(set);

        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.VideoTitle)
        TextView title;
        @BindView(R.id.VideoDescription)
        TextView description;
        @BindView(R.id.DateStamp)
        TextView dateTxt;
        @BindView(R.id.VideoThumbnail)
        ImageView VideoThumbnail;
        @BindView(R.id.PlayContainer)
        LinearLayout playCont;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}