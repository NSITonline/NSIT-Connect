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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import functions.ButtonAnimation;
import models.AboutUsMember;
import nsit.app.com.nsitapp.R;

/**
 * Created by Kartik Kwatra on 26-08-2017.
 */

public class MemberAdapter extends ArrayAdapter<AboutUsMember> {

    @BindView(R.id.memberName) TextView name;
    @BindView(R.id.batch) TextView batch;
    @BindView(R.id.role1) TextView role1;
    @BindView(R.id.memberImage) ImageView memberImage;
    @BindView(R.id.facebook_image) ImageView fbID;
    @BindView(R.id.github_image) ImageView gitimage;
    @BindView(R.id.linkedIn_image) ImageView linkedImage;
    @BindView(R.id.role2) TextView role2text;
    @BindView(R.id.role2image) ImageView role2Image;

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
        ButterKnife.bind(this, listIteamView);
        name.setText(currentMember.getName());
        batch.setText(currentMember.getBatch());
        role1.setText(currentMember.getRole1());
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

        role2text.setText("");

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
