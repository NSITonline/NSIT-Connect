package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * Created by Swati garg on 21-06-2015.
 */


public class AboutUs extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    Activity activity;
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = activity;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_aboutus, container, false);
        ImageView s1,s2,rep;
        TextView con;
        s1 = (ImageView) rootView.findViewById(R.id.linked_sidharth);
        s2 = (ImageView) rootView.findViewById(R.id.linked_swati);
        rep = (ImageView) rootView.findViewById(R.id.git);
        con = (TextView) rootView.findViewById(R.id.cont);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://in.linkedin.com/in/sdpatro");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://in.linkedin.com/pub/swati-garg/b9/371/a79");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2/wiki");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
