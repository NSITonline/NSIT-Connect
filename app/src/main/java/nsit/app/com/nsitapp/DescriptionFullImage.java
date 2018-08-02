package nsit.app.com.nsitapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import functions.Constant;
import functions.TouchImageView;
import functions.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DescriptionFullImage extends AppCompatActivity implements Constant {
    private String img, obid;
    private TouchImageView touchImageView;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent intent = getIntent();
        img = intent.getStringExtra(IMAGE);
        obid = intent.getStringExtra(OBID);
        touchImageView = findViewById(R.id.iv);
        mHandler = new Handler(Looper.getMainLooper());
        setTitle("Image");

        Picasso.with(this).load(img).into(touchImageView);

        if (Utils.isNetworkAvailable(this)) {
            if (img == null)
                touchImageView.setVisibility(View.GONE);
            else if (obid == null)
                Picasso.with(this).load(img).into(touchImageView);
            else
                donwloadFullSizeImages();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home)
            finish();

        if (id == R.id.save) {
            touchImageView.setDrawingCacheEnabled(true);
            Bitmap b = touchImageView.getDrawingCache();

            File root = Environment.getExternalStorageDirectory();
            File dir = new File(root.getAbsolutePath() + "/NSIT Online");
            dir.mkdir();

            File cachePath = new File(root.getAbsolutePath() + "/NSIT Online/image_" + System.currentTimeMillis() + ".jpg");
            try {
                cachePath.createNewFile();
                FileOutputStream ostream = new FileOutputStream(cachePath);
                b.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                ostream.close();
                Snackbar.make(touchImageView, R.string.image_saved, Snackbar.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Error", "Error : " + e.getMessage());
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void donwloadFullSizeImages() {

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
                    if (result == null) {
                        Picasso.with(DescriptionFullImage.this).load(img).into(touchImageView);;
                    } else {
                        try {
                            JSONObject ob;
                            JSONArray arr;
                            ob = new JSONObject(result);
                            arr = ob.getJSONArray("images");

                            String imglink = arr.getJSONObject(0).getString("source");
                            if (imglink != null)
                                if (Utils.isNetworkAvailable(DescriptionFullImage.this))
                                    Picasso.with(DescriptionFullImage.this).load(imglink).into(touchImageView);
                                else touchImageView.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Picasso.with(DescriptionFullImage.this).load(img).into(touchImageView);;
                        }
                    }
                });
            }
        });
    }

}
