package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import functions.ButtonAnimation;

/**
 * Created by Swati garg on 21-06-2015.
 */


public class AboutUs extends Fragment {
    @BindView(R.id.linked_sidharth)ImageView s1;
    @BindView(R.id.linked_swati)ImageView s2;
    @BindView(R.id.facebook_sidharth)ImageView s3;
    @BindView(R.id.facebook_swati)ImageView s4;
    @BindView(R.id.facebook_chetan)ImageView s5;
    @BindView(R.id.linked_chetan)ImageView s6;
    @BindView(R.id.facebook_sumit)ImageView s8;
    @BindView(R.id.linked_sumit)ImageView s9;
    @BindView(R.id.facebook_ayush)ImageView s12;
    @BindView(R.id.linked_ayush)ImageView s13;
    @BindView(R.id.facebook_prabhakr)ImageView prabhakrFB;
    @BindView(R.id.linked_prabhakr)ImageView prabhakrLinkedIn;
    @BindView(R.id.linked_sagar)ImageView s10;
    @BindView(R.id.facebook_sagar)ImageView s11;
    @BindView(R.id.facebook_naman)ImageView namanFB;
    @BindView(R.id.linked_naman)ImageView namanLinkedIn;
    @BindView(R.id.github_sidharth)ImageView gitsidharth;
    @BindView(R.id.github_swati)ImageView gitswati;
    @BindView(R.id.github_prabhakr)ImageView gitprabhakr;
    @BindView(R.id.github_naman)ImageView gitnaman;
    @BindView(R.id.github_sagar)ImageView gitsagar;
    @BindView(R.id.github_sumit)ImageView gitsumit;
    @BindView(R.id.image_prabhakr)ImageView prabhakrim;
    @BindView(R.id.github_ayush)ImageView gitayush;
    @BindView(R.id.cont)TextView con;
    @BindView(R.id.GoToRepo)TextView rep;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        super.onCreate(savedInstanceState);
    }

    private Activity activity;

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
        ButterKnife.bind(this,rootView);

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
