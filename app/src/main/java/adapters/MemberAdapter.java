package adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import functions.ButtonAnimation;
import nsit.app.com.nsitapp.AboutUsMember;
import nsit.app.com.nsitapp.R;

/**
 * Created by Kartik Kwatra on 26-08-2017.
 */

public class MemberAdapter extends ArrayAdapter<AboutUsMember>{
    public MemberAdapter(@NonNull Context context, @NonNull List<AboutUsMember> teamMembers) {
        super(context, 0, teamMembers);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listIteamView=convertView;
        if(listIteamView==null){
            listIteamView= LayoutInflater.from(getContext()).inflate(R.layout.aboutus_listitem,parent,false);
        }
        AboutUsMember currentMember=getItem(position);

        TextView name=(TextView)listIteamView.findViewById(R.id.memberName);
        name.setText(currentMember.getName().toString());


        TextView batch=(TextView)listIteamView.findViewById(R.id.batch);
        batch.setText(currentMember.getBatch().toString());

        TextView role1=(TextView)listIteamView.findViewById(R.id.role1);
        role1.setText(currentMember.getRole1());

        ImageView memberImage=(ImageView)listIteamView.findViewById(R.id.memberImage);
        memberImage.setImageResource(currentMember.getImageResID());
        if(currentMember.getName().toString().equals("Prabhakar Gupta")){
            memberImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ButtonAnimation btnAnimation = new ButtonAnimation();
                    btnAnimation.animateButton(v, getContext());
                    Uri uri = Uri.parse("http://prabhakargupta.com/");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    getContext().startActivity(intent);

                }
            });
        }
        ImageView fbID=(ImageView)listIteamView.findViewById(R.id.facebook_image);
        final String fbId=currentMember.getFbID();
        final String gitId=currentMember.getGitID();
        final String linkedId=currentMember.getLinkedID();
        String role2=currentMember.getRole2();
        fbID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v,getContext());
                Uri fbUri=Uri.parse(fbId);
                Intent intent=new Intent(Intent.ACTION_VIEW,fbUri);
                getContext().startActivity(intent);
            }
        });
        if(gitId!=null&&!gitId.isEmpty()){
            ImageView gitimage=(ImageView)listIteamView.findViewById(R.id.github_image);
            gitimage.setVisibility(View.VISIBLE);
            gitimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ButtonAnimation btnAnimation = new ButtonAnimation();
                    btnAnimation.animateButton(v,getContext());
                    Uri gitUri=Uri.parse(gitId);
                    Intent intent=new Intent(Intent.ACTION_VIEW,gitUri);
                    getContext().startActivity(intent);
                }
            });
        }
        if(linkedId!=null&&!linkedId.isEmpty()){
            ImageView linkedImage=(ImageView)listIteamView.findViewById(R.id.linkedIn_image);
            linkedImage.setVisibility(View.VISIBLE);
            linkedImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ButtonAnimation btnAnimation = new ButtonAnimation();
                    btnAnimation.animateButton(v,getContext());
                    Uri linkedUri=Uri.parse(gitId);
                    Intent intent=new Intent(Intent.ACTION_VIEW,linkedUri);
                    getContext().startActivity(intent);
                }
            });
        }
        if(role2!=null&&!role2.isEmpty()){
            TextView role2text=(TextView)listIteamView.findViewById(R.id.role2);
            role2text.setText(role2);
            ImageView role2Image=(ImageView)listIteamView.findViewById(R.id.role2image);
            role2Image.setVisibility(View.VISIBLE);
            if(role2.equals("UI Designer")){

                role2Image.setImageResource(R.drawable.ic_brush_black_24dp);
            }else{
                role2Image.setImageResource(R.drawable.ic_build_black_24dp);
            }
        }

        return listIteamView;
    }
}
