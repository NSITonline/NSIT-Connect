package adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import models.AboutUsMember;
import nsit.app.com.nsitapp.R;

/**
 * Created by Kartik Kwatra on 26-08-2017.
 */

public class MemberAdapter extends ArrayAdapter<AboutUsMember> {
    public MemberAdapter(@NonNull Context context, @NonNull List<AboutUsMember> teamMembers) {
        super(context, 0, teamMembers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listIteamView = convertView;
        if (listIteamView == null) {
            listIteamView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_aboutus_listitem, null);
        }
        final AboutUsMember currentMember = getItem(position);

        TextView name = listIteamView.findViewById(R.id.memberName);
        name.setText(currentMember.getName());
        TextView batch = listIteamView.findViewById(R.id.batch);
        batch.setText(currentMember.getBatch());
        TextView role1 = listIteamView.findViewById(R.id.role1);
        role1.setText(currentMember.getRole1());
        ImageView memberImage = listIteamView.findViewById(R.id.memberImage);
        memberImage.setImageResource(currentMember.getImageResID());
        if (currentMember.getName().equals("Prabhakar Gupta")) {
            memberImage.setOnClickListener(v -> {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, getContext());
                Uri uri = Uri.parse("http://prabhakargupta.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getContext().startActivity(intent);
            });
        }
        ImageView fbID = listIteamView.findViewById(R.id.facebook_image);
        String gitId = currentMember.getGitID();
        String linkedId = currentMember.getLinkedID();
        String role2 = currentMember.getRole2();
        fbID.setOnClickListener(v -> {
            ButtonAnimation btnAnimation = new ButtonAnimation();
            btnAnimation.animateButton(v, getContext());
            Uri fbUri = Uri.parse(currentMember.getFbID());
            Intent intent = new Intent(Intent.ACTION_VIEW, fbUri);
            getContext().startActivity(intent);
        });
        ImageView gitimage = listIteamView.findViewById(R.id.github_image);
        gitimage.setVisibility(View.GONE);
        if (gitId != null && !gitId.isEmpty()) {
            gitimage.setVisibility(View.VISIBLE);
            gitimage.setOnClickListener(v -> {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, getContext());
                Uri gitUri = Uri.parse(currentMember.getGitID());
                Intent intent = new Intent(Intent.ACTION_VIEW, gitUri);
                getContext().startActivity(intent);
            });
        }
        ImageView linkedImage = listIteamView.findViewById(R.id.linkedIn_image);
        linkedImage.setVisibility(View.GONE);
        if (linkedId != null && !linkedId.isEmpty()) {
            linkedImage.setVisibility(View.VISIBLE);
            linkedImage.setOnClickListener(v -> {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, getContext());
                Uri linkedUri = Uri.parse(currentMember.getLinkedID());
                Intent intent = new Intent(Intent.ACTION_VIEW, linkedUri);
                getContext().startActivity(intent);
            });
        }
        TextView role2text = listIteamView.findViewById(R.id.role2);
        role2text.setText("");
        ImageView role2Image = listIteamView.findViewById(R.id.role2image);
        role2Image.setVisibility(View.GONE);
        if (role2 != null && !role2.isEmpty()) {
            role2text.setText(role2);
            role2Image.setVisibility(View.VISIBLE);
            if (role2.equals("UI Designer")) {
                role2Image.setImageResource(R.drawable.ic_brush_black_24dp);
            } else {
                role2Image.setImageResource(R.drawable.ic_build_black_24dp);
            }
        }
        return listIteamView;
    }
}
