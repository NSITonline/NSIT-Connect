package nsit.app.com.nsitapp.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import FliperView.Adapter.BaseFlipAdapter;
import FliperView.Utils.FlipSettings;
import functions.ButtonAnimation;
import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.model.Friend;

/**
 * Created by AGGARWAL'S on 8/25/2016.
 */
public class AboutUsAdapter extends BaseFlipAdapter<Friend> {


    private Typeface tex;
    private  Activity activity;
    private final int PAGES = 3;
    private int[] IDS_INTEREST = {R.id.interest_1, R.id.interest_2, R.id.interest_3, R.id.interest_4,R.id.interest_5};

    public AboutUsAdapter(Activity context, List<Friend> items, FlipSettings settings) {
        super(context, items, settings);
        activity = context;
//        tex = Typeface.createFromAsset(activity.getAssets(), "fonts/texgyreadventor-bold.otf");
    }

    @Override
    public View getPage(int position, View convertView, ViewGroup parent, final Friend friend1, final Friend friend2) {
        final FriendsHolder holder;

        if (convertView == null) {
            holder = new FriendsHolder();
            convertView = activity.getLayoutInflater().inflate(R.layout.fragment_about_merge, parent, false);
            holder.leftAvatar = (ImageView) convertView.findViewById(R.id.first);
            holder.rightAvatar = (ImageView) convertView.findViewById(R.id.second);
            holder.left = (TextView) convertView.findViewById(R.id.name1);
            holder.right = (TextView) convertView.findViewById(R.id.name2);
            holder.infoPage = activity.getLayoutInflater().inflate(R.layout.fragment_about_info, parent, false);
            holder.nickName = (TextView) holder.infoPage.findViewById(R.id.nickname);
            holder.fv1 = (FontTextView) holder.infoPage.findViewById(R.id.interest_1);
            holder.fv2 = (FontTextView) holder.infoPage.findViewById(R.id.interest_2);
            holder.fv3 = (FontTextView) holder.infoPage.findViewById(R.id.interest_3);
            holder.fv4 = (FontTextView) holder.infoPage.findViewById(R.id.interest_4);
            holder.fv5 = (FontTextView) holder.infoPage.findViewById(R.id.interest_5);

            for (int id : IDS_INTEREST)
                holder.interests.add((TextView) holder.infoPage.findViewById(id));

            convertView.setTag(holder);
        } else {
            holder = (FriendsHolder) convertView.getTag();
        }

        switch (position) {
            case 1:
                Picasso.with(activity).load(friend1.getAvatar()).into(holder.leftAvatar);
                holder.left.setTypeface(tex);
                holder.left.setText(friend1.getNickname());


                if (friend2 != null) {

                    holder.right.setText(friend2.getNickname());
                    //holder.right.setTypeface(tex);
                    Picasso.with(activity).load(friend2.getAvatar()).into(holder.rightAvatar);
                }
                break;
            default:
                fillHolder(holder, position == 0 ? friend1 : friend2);
                holder.infoPage.setTag(holder);
                return holder.infoPage;
        }


        return convertView;
    }


    @Override
    public int getPagesCount() {
        return PAGES;
    }

    private void fillHolder(FriendsHolder holder, final Friend friend) {
        if (friend == null)
            return;
        Iterator<TextView> iViews = holder.interests.iterator();
        Iterator<String> iInterests = friend.getInterests().iterator();
        while (iViews.hasNext() && iInterests.hasNext()) {
            String interest = iInterests.next();
            if(interest != null)
                iViews.next().setText(interest);
            else
                iViews.next().setVisibility(View.INVISIBLE);
        }
        holder.infoPage.setBackgroundColor(activity.getResources().getColor(friend.getBackground()));
        holder.nickName.setText(friend.getNickname());

        holder.nickName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("fsgb", "clikc");
            }
        });


        holder.fv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, activity);
                Uri uri = Uri.parse(friend.getLinkedin());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                activity.startActivity(intent);

            }
        });


        holder.fv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, activity);
                Uri uri = Uri.parse(friend.getFacebook());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                activity.startActivity(intent);

            }
        });


        holder.fv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, activity);
                Uri uri = Uri.parse(friend.getGithub());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                activity.startActivity(intent);

            }
        });



    }

    class FriendsHolder {
        ImageView leftAvatar;
        ImageView rightAvatar;
        View infoPage;
        TextView fv1, fv2, fv3, fv4,fv5;
        TextView left,right;

        List<TextView> interests = new ArrayList<>();
        TextView nickName;
    }

}
