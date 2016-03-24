package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import functions.ButtonAnimation;
import functions.ZoomableRelativeLayout;

/**
 * Created by Swati garg on 21-06-2015.
 */


public class AboutUs extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        super.onCreate(savedInstanceState);
    }

    Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //setHasOptionsMenu(false);
        View rootView = inflater.inflate(R.layout.fragment_aboutus, container, false);
        ImageView s1, s2, s3, s4, s5, s6, s8, s9, s10, s11,s12,s13, namanFB, namanLinkedIn, prabhakrFB, prabhakrLinkedIn;
        ImageView gitsidharth, gitswati, gitprabhakr, gitnaman, gitsagar, gitsumit,prabhakrim,gitayush;


        TextView con;
        TextView rep;
        s1 = (ImageView) rootView.findViewById(R.id.linked_sidharth);
        s2 = (ImageView) rootView.findViewById(R.id.linked_swati);
        s3 = (ImageView) rootView.findViewById(R.id.facebook_sidharth);
        s4 = (ImageView) rootView.findViewById(R.id.facebook_swati);
        s8 = (ImageView) rootView.findViewById(R.id.facebook_sumit);
        s9 = (ImageView) rootView.findViewById(R.id.linked_sumit);
        s5 = (ImageView) rootView.findViewById(R.id.facebook_chetan);
        s6 = (ImageView) rootView.findViewById(R.id.linked_chetan);
        s12 = (ImageView) rootView.findViewById(R.id.facebook_ayush);
        s13 = (ImageView) rootView.findViewById(R.id.linked_ayush);


        prabhakrFB = (ImageView) rootView.findViewById(R.id.facebook_prabhakr);
        prabhakrLinkedIn = (ImageView) rootView.findViewById(R.id.linked_prabhakr);

        gitsidharth = (ImageView) rootView.findViewById(R.id.github_sidharth);
        gitswati = (ImageView) rootView.findViewById(R.id.github_swati);
        gitprabhakr = (ImageView) rootView.findViewById(R.id.github_prabhakr);
        gitsagar = (ImageView) rootView.findViewById(R.id.github_sagar);
        gitnaman = (ImageView) rootView.findViewById(R.id.github_naman);
        gitsumit = (ImageView) rootView.findViewById(R.id.github_sumit);
        gitayush = (ImageView) rootView.findViewById(R.id.github_ayush);

        prabhakrim = (ImageView) rootView.findViewById(R.id.image_prabhakr);

        s10 = (ImageView) rootView.findViewById(R.id.linked_sagar);
        s11 = (ImageView) rootView.findViewById(R.id.facebook_sagar);

        rep = (TextView) rootView.findViewById(R.id.GoToRepo);
        con = (TextView) rootView.findViewById(R.id.cont);
        namanFB = (ImageView) rootView.findViewById(R.id.facebook_naman);
        namanLinkedIn = (ImageView) rootView.findViewById(R.id.linked_naman);
        rep = (TextView) rootView.findViewById(R.id.GoToRepo);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://in.linkedin.com/in/sdpatro");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://in.linkedin.com/pub/swati-garg/b9/371/a79");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://www.facebook.com/sumit.vohra.353?ref=br_rs");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://in.linkedin.com/in/sumit-vohra-224484a0");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        s12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://www.facebook.com/ayush.verma.5203");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        s13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://in.linkedin.com/in/ayush-verma-210082114");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://www.facebook.com/sidharth.patro.39?fref=ts");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://www.facebook.com/swati.garg.1690");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://www.facebook.com/chetan.shukla.5205?fref=ts");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://in.linkedin.com/pub/chetan-shukla/100/415/455");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        s10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://in.linkedin.com/in/sagar-aggarwal-9319b3110");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        s11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://web.facebook.com/sagar.aggarwal.773");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        prabhakrFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://www.facebook.com/prabhakar267");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        prabhakrLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://www.linkedin.com/in/prabhakargupta267");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        namanFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://www.facebook.com/naman1901");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        namanLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://in.linkedin.com/in/naman1901");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


        gitsidharth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://github.com/sdpatro");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        gitswati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://github.com/Swati4star");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        gitprabhakr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://github.com/prabhakar267");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



        gitnaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://github.com/naman1901");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        gitsagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://github.com/sgaggarwal2009");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitayush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://github.com/Ayush-V1");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gitsumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("https://github.com/saisumit");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



        prabhakrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getActivity());
                Uri uri = Uri.parse("http://prabhakargupta.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, activity);
                Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2/wiki");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        return rootView;
    }


}
