package nsit.app.com.nsitapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.Snackbar;
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

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import functions.ButtonAnimation;
import functions.Constant;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Description extends AppCompatActivity implements Constant {

    @BindView(R.id.progressBar1)
    ProgressBar pb;
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.imag_cont)
    FrameLayout imageCount;
    @BindView(R.id.likes)
    TextView likeTv;
    @BindView(R.id.link)
    Button linkTv;
    @BindView(R.id.des)
    TextView desTv;
    @BindView(R.id.but_con)
    LinearLayout showOnPage;

    private String img;
    private String link;
    private String imglink;
    private String obid;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decsription);

        ButterKnife.bind(this);

        setTitle("Post");

        Intent intent = getIntent();
        img = intent.getStringExtra(IMAGE);
        String des = intent.getStringExtra(DES);
        String like = intent.getStringExtra(LIKE);
        link = intent.getStringExtra(LINK);
        obid = intent.getStringExtra(OBID);

        mHandler = new Handler(Looper.getMainLooper());

        if (like == null)
            likeTv.setText("0");
        else
            likeTv.setText(like);

        if (des == null)
            desTv.setText(R.string.no_description);
        else
            desTv.setText(des);

        if (link == null)
            showOnPage.setVisibility(View.GONE);
        else
            linkTv.setOnClickListener(view -> {
                        Uri uri = Uri.parse(link);
                        Intent in = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(in);
                        ButtonAnimation btnAnimation = new ButtonAnimation();
                        btnAnimation.animateButton(view, getApplicationContext());
                    }
            );

        if (Utils.isNetworkAvailable(Description.this)) {
            if (img == null) {
                imageCount.setVisibility(View.GONE);
                pb.setVisibility(View.GONE);
            } else if (obid == null) {
                Picasso.with(Description.this).load(img).into(imageView);
            } else
                donwloadImages();
        } else
            Snackbar.make(pb, R.string.internet_error, Snackbar.LENGTH_LONG).show();

        if (img == null)
            imageCount.setVisibility(View.GONE);
        else imageView.setOnClickListener(view -> {
            Intent i1 = new Intent(Description.this, DescriptionFullImage.class);
            i1.putExtra(IMAGE, img);
            i1.putExtra(OBID, obid);
            startActivity(i1);
            ButtonAnimation btnAnimation = new ButtonAnimation();
            btnAnimation.animateButton(view, getApplicationContext());
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void donwloadImages() {

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
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                mHandler.post(() -> {
                    JSONObject ob;
                    JSONArray arr;
                    if (result == null) {
                        Picasso.with(Description.this).load(img).into(imageView);
                    } else {
                        try {
                            ob = new JSONObject(result);
                            arr = ob.getJSONArray("images");

                            if (arr.getJSONObject(0).has("source"))
                                imglink = arr.getJSONObject(0).getString("source");
                            if (imglink != null) {
                                if (Utils.isNetworkAvailable(Description.this)) {
                                    Picasso.with(Description.this).load(imglink).into(imageView);
                                    pb.setVisibility(View.GONE);
                                }
                            } else {
                                imageCount.setVisibility(View.GONE);
                                pb.setVisibility(View.GONE);
                            }
                            Log.e("yrs", "Image Link is : " + imglink);
                        } catch (Exception e) {
                            Log.e("yo", "" + e.getMessage() + " ");
                        }
                    }
                    pb.setVisibility(View.GONE);
                });
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
