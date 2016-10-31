package nsit.app.com.nsitapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import functions.ButtonAnimation;
import functions.Constant;
import functions.ImageLoader;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static nsit.app.com.nsitapp.R.id.imag_cont;


public class Description extends AppCompatActivity implements Constant {
    private ProgressBar pb;
    private ImageLoader imageLoader;
    private String img;
    private String link;
    private ImageView imageView;
    private String imglink;
    private String obid;
    private FrameLayout img_cont;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decsription);
        pb = (ProgressBar) findViewById(R.id.progressBar1);
        mHandler = new Handler(Looper.getMainLooper());

        setTitle("Post");

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

        if (like == null)
            like1.setText("0");
        else
            like1.setText(like);


        if (des == null)
            des1.setText(R.string.no_description);
        else
            des1.setText(des);

        if (link == null)
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
        if (Utils.isNetworkAvailable(Description.this)) {
            if (img == null) {
                img_cont.setVisibility(View.GONE);
                pb.setVisibility(View.GONE);
            } else if (obid == null) {
                imageLoader.DisplayImage(img, imageView, pb);
            } else
                loadFeed();
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
                Intent i = new Intent(Description.this, DescriptionFullImage.class);
                i.putExtra(IMAGE, img);
                i.putExtra(OBID, obid);
                startActivity(i);
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getApplicationContext());
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }


    // Make http call
    private void loadFeed() {

        String uri = "https://graph.facebook.com/" + obid + "?fields=images&access_token=" + common_access;

        //Set up client
        OkHttpClient client = new OkHttpClient();
        //Execute request
        Request request = new Request.Builder()
                .url(uri)
                .build();
        //Setup callback
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Request Failed", "Message : " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                try {
                    final String result = response.body().string();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {

                            JSONObject ob;
                            JSONArray arr;
                            try {
                                ob = new JSONObject(result);

                                arr = ob.getJSONArray("images");

                                if (arr.getJSONObject(0).has("source"))
                                    imglink = arr.getJSONObject(0).getString("source");
                                if (imglink != null) {
                                    if (Utils.isNetworkAvailable(Description.this)) {
                                        imageLoader.DisplayImage(imglink, imageView, pb);
                                        pb.setVisibility(View.GONE);
                                    }
                                } else {
                                    img_cont.setVisibility(View.GONE);
                                    pb.setVisibility(View.GONE);
                                }
                                Log.e("yrs", "Image Link is : " + imglink);

                            } catch (Exception e) {
                                Log.e("yo", "" + e.getMessage() + " ");
                            }

                            pb.setVisibility(View.GONE);

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
