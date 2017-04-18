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

import butterknife.ButterKnife;
import butterknife.OnClick;
import functions.ButtonAnimation;

/**
 * Created by Swati garg on 21-06-2015.
 */


public class AboutUs extends Fragment {

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
        return rootView;
    }
    @OnClick(R.id.linked_sidharth)
    public void s1(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://in.linkedin.com/in/sdpatro");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.linked_swati)
    public void s2(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://in.linkedin.com/pub/swati-garg/b9/371/a79");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.facebook_sidharth)
    public void s3(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://www.facebook.com/sidharth.patro.39?fref=ts");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.facebook_swati)
    public void s4(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://www.facebook.com/swati.garg.1690");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.facebook_chetan)
    public void s5(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://www.facebook.com/chetan.shukla.5205?fref=ts");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.linked_chetan)
     public void s6(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://in.linkedin.com/pub/chetan-shukla/100/415/455");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.facebook_sumit)
    public void s8(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://www.facebook.com/sumit.vohra.353?ref=br_rs");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.linked_sumit)
    public void s9(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://in.linkedin.com/in/sumit-vohra-224484a0");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.linked_sagar)
    public void s10(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://in.linkedin.com/in/sagar-aggarwal-9319b3110");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.facebook_sagar)
    public void s11(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://web.facebook.com/sagar.aggarwal.773");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.facebook_ayush)
    public void s12(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://www.facebook.com/ayush.verma.5203");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.linked_ayush)
    public void s13(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://in.linkedin.com/in/ayush-verma-210082114");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.facebook_prabhakr)
    public  void prabhakrFB(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://www.facebook.com/prabhakar267");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.linked_prabhakr)
    public void prabhakrLinkedIn(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://www.linkedin.com/in/prabhakargupta267");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.facebook_naman)
    public void namanFB(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://www.facebook.com/naman1901");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.linked_naman)
    public void namanLinkedIn(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://in.linkedin.com/in/naman1901");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.github_sidharth)
    public void gitsidharth(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://github.com/sdpatro");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.github_swati)
    public void gitswati(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://github.com/Swati4star");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.github_prabhakr)
    public void gitprabhakr(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://github.com/prabhakar267");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.github_naman)
    public void gitnaman(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://github.com/naman1901");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.github_sagar)
    public void gitsagar(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://github.com/sgaggarwal2009");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.github_sumit)
    public void gitsumit(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://github.com/saisumit");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.image_prabhakr)
    public void prabhakrim(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("http://prabhakargupta.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.github_ayush)
    public void gitayush(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getActivity());
        Uri uri = Uri.parse("https://github.com/Ayush-V1");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.cont)
    public void con(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2/wiki");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    @OnClick(R.id.GoToRepo)
    public void rep(View view){
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, activity);
        Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
