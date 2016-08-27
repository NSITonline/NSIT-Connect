package nsit.app.com.nsitapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import functions.ButtonAnimation;
import functions.Constant;
import functions.ImageLoader;
import functions.Utils;

import static nsit.app.com.nsitapp.R.id.imag_cont;


public class Decsription extends AppCompatActivity implements Constant{
    private ProgressBar pb;
    private ImageLoader imageLoader;
    private String img;
    private String link;
    private ImageView imageView;
    private String imglink;
    private String obid;
    private FrameLayout img_cont;
    private ArrayList<Bitmap> images;
    private ImageSlideshowFragment f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decsription);
        pb=(ProgressBar)findViewById(R.id.progressBar1);

        setTitle("Post");

        images = new ArrayList<>();
        Intent i = getIntent();
        img = i.getStringExtra(IMAGE);
        String des = i.getStringExtra(DES);
        String like = i.getStringExtra(LIKE);
        link = i.getStringExtra(LINK);
        imageLoader = new ImageLoader(this);
        obid = i.getStringExtra(OBID);

        imageView = (ImageView) findViewById(R.id.image);
        TextView like1 = (TextView) findViewById(R.id.likes);
        Button link1 = (Button) findViewById(R.id.link);
        TextView des1 = (TextView) findViewById(R.id.des);
        img_cont = (FrameLayout) findViewById(imag_cont);
        LinearLayout but_con = (LinearLayout) findViewById(R.id.but_con);

        if(like ==null)
            like1.setText("0");
        else
            like1.setText(like);


        if(des ==null)
            des1.setText(R.string.no_description);
        else
            des1.setText(des);

        if(link==null)
            but_con.setVisibility(View.GONE);
        else
        link1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Uri uri = Uri.parse(link);
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        startActivity(intent);
                                        ButtonAnimation btnAnimation = new ButtonAnimation();
                                        btnAnimation.animateButton(view, getApplicationContext());
                                    }
                                }
        );
        if(Utils.isNetworkAvailable(Decsription.this)) {
            if (img == null) {
                img_cont.setVisibility(View.GONE);
                pb.setVisibility(View.GONE);
            }
            else if (obid == null) {
                imageLoader.DisplayImage(img, imageView,pb);
            }
            else
                new DownloadWebPageTask().execute();
        } else
            SnackbarManager.show(
                    Snackbar.with(getApplicationContext())
                            .text("Check You Internet Connection")
                            .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), this);

        if (img == null)
            img_cont.setVisibility(View.GONE);
        else imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(Decsription.this, Description_FullImage.class);
//                i.putExtra(IMAGE,img);
//                i.putExtra(OBID,obid);
//                startActivity(i);
//                ButtonAnimation btnAnimation = new ButtonAnimation();
//                btnAnimation.animateButton(view, getApplicationContext());
                Bundle bundle = new Bundle();
                bundle.putSerializable("images", images);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                f = new ImageSlideshowFragment();
                f.setArguments(bundle);
                f.show(ft, "slideshow");
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {


            String uri = "https://graph.facebook.com/"+obid+"?fields=images&access_token="+ common_access;

            java.net.URL url = null;
            String readStream = null;
            try {
                url = new URL(uri);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                readStream = Utils.readStream(con.getInputStream());
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            return readStream;
        }

        @Override
        protected void onPostExecute(String result) {
            Log.e("YO", "Done" + obid + result);
            JSONObject ob;
            JSONArray arr;
            if(result==null){
                Ion.with(Decsription.this)
                        .load(img)
                        .withBitmap()
                        .asBitmap()
                        .setCallback(new FutureCallback<Bitmap>() {
                            @Override
                            public void onCompleted(Exception e, Bitmap result) {
                                imageView.setImageBitmap(result);
                                f.notifyDataSetChanged();
                                images.add(result);
                            }
                        });
            }else {
                try {
                    ob = new JSONObject(result);

                    arr = ob.getJSONArray("images");

                    if (arr.getJSONObject(0).has("source"))
                        imglink = arr.getJSONObject(0).getString("source");
                    if (imglink != null) {
                        Ion.with(imageView)
                                .load(imglink);
                    } else {
                        img_cont.setVisibility(View.GONE);
                        pb.setVisibility(View.GONE);
                    }
                    Log.e("yrs", "Image Link is : " + imglink);
                    for(int i=0;i<arr.length();i++) {
                        JSONObject x = arr.getJSONObject(i);
                        if(x.has("source")) {
                            String URL = x.getString("source");
                            Log.e("Hey", "URL:" + URL);
                            Ion.with(Decsription.this)
                                    .load(URL)
                                    .withBitmap()
                                    .asBitmap()
                                    .setCallback(new FutureCallback<Bitmap>() {
                                        @Override
                                        public void onCompleted(Exception e, Bitmap result) {
                                            f.notifyDataSetChanged();
                                            images.add(result);
                                        }
                                    });
                        }
                    }

                } catch (Exception e) {
                    Log.e("yo", "" + e.getMessage()+" ");
                }
            }
            pb.setVisibility(View.GONE);

            Log.e("Yo", imglink+"");
        }
    }

}
