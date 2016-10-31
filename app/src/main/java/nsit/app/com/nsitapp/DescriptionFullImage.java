package nsit.app.com.nsitapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;
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
    private TouchImageView iv;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent i = getIntent();
        img = i.getStringExtra("img");
        obid = i.getStringExtra("oid");
        iv = (TouchImageView) findViewById(R.id.iv);
        setTitle("Image");
        mHandler = new Handler(Looper.getMainLooper());

        if (Utils.isNetworkAvailable(this)) {
            if (img == null)
                iv.setVisibility(View.GONE);
            else if (obid == null)
                Picasso.with(this).load(img).into(iv);
            else
                loadImageLink();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home)
            finish();

        if (id == R.id.save) {
            iv.setDrawingCacheEnabled(true);
            Bitmap b = iv.getDrawingCache();

            File root = Environment.getExternalStorageDirectory();
            File dir = new File(root.getAbsolutePath() + "/NSIT Online");
            try {
                if (dir.mkdir()) {
                    System.out.println("Directory created");
                    Log.e("yo", "Directory created");
                } else {
                    System.out.println("Directory is not created");
                    Log.e("yo", "Directory not created");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            File cachePath = new File(root.getAbsolutePath() + "/NSIT Online/image_" + System.currentTimeMillis() + ".jpg");
            try {
                cachePath.createNewFile();
                FileOutputStream ostream = new FileOutputStream(cachePath);
                b.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                ostream.close();
                SnackbarManager.show(
                        Snackbar.with(getApplicationContext())
                                .text("Image Saved to Device")
                                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), DescriptionFullImage.this);


            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Error", "Error : " + e.getMessage());
            }

        }

        return super.onOptionsItemSelected(item);
    }


    // Make http call
    private void loadImageLink() {

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

                            try {
                                JSONObject ob;
                                JSONArray arr;
                                ob = new JSONObject(result);
                                arr = ob.getJSONArray("images");

                                String imglink = arr.getJSONObject(0).getString("source");
                                if (imglink != null)
                                    if (Utils.isNetworkAvailable(DescriptionFullImage.this))
                                        Picasso.with(DescriptionFullImage.this).load(imglink).into(iv);
                                    else iv.setVisibility(View.GONE);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
