package nsit.app.com.nsitapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.FrameLayout;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import functions.ButtonAnimation;
import functions.Constant;
import functions.ImageLoader;
import functions.Utils;
import functions.Val;

import static nsit.app.com.nsitapp.R.id.imag_cont;


public class Decsription extends AppCompatActivity implements Constant{
    ProgressBar pb;
    public ImageLoader imageLoader;
    String img,des,like,link;
    TextView Des,Like;
    Button Link;
    ImageView imageView;
    String imglink,obid;
    FrameLayout img_cont;
    LinearLayout but_con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decsription);
        pb=(ProgressBar)findViewById(R.id.progressBar1);







        setTitle("Post");

        Intent i = getIntent();
        img = i.getStringExtra(IMAGE);
        des = i.getStringExtra(DES);
        like = i.getStringExtra(LIKE);
        link = i.getStringExtra(LINK);
        imageLoader=new ImageLoader(this);
        obid = i.getStringExtra(OBID);

        imageView = (ImageView) findViewById(R.id.image);
        Like = (TextView) findViewById(R.id.likes);
        Link = (Button) findViewById(R.id.link);
        Des = (TextView) findViewById(R.id.des);
        img_cont = (FrameLayout) findViewById(imag_cont);
        but_con = (LinearLayout) findViewById(R.id.but_con);



        if(like==null)
            Like.setText("0");
        else
            Like.setText(like);


        if(des==null)
            Des.setText("No description");
        else
            Des.setText(des);

        if(link==null)
            but_con.setVisibility(View.GONE);
        else
        Link.setOnClickListener(new View.OnClickListener() {
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
                Intent i = new Intent(Decsription.this,ImageAct.class);
                i.putExtra(IMAGE,img);
                i.putExtra(OBID,obid);
                startActivity(i);
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getApplicationContext());
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

String text;
    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {


            String URL = "https://graph.facebook.com/"+obid+"?fields=images&access_token="+ Val.common_access;
            HttpClient Client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                text = Client.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("eroore",e.getMessage()+" ");
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Log.e("YO", "Done" + obid + text);
            JSONObject ob;
            JSONArray arr;
            if(text==null){
                imageLoader.DisplayImage(img, imageView,pb);
            }else {
                try {
                    ob = new JSONObject(text);

                    arr = ob.getJSONArray("images");

                    if (arr.getJSONObject(0).has("source"))
                        imglink = arr.getJSONObject(0).getString("source");
                    if (imglink != null) {
                        if (Utils.isNetworkAvailable(Decsription.this)) {
                            imageLoader.DisplayImage(imglink, imageView,pb);
                            pb.setVisibility(View.GONE);
                        }
                    } else {
                        img_cont.setVisibility(View.GONE);
                        pb.setVisibility(View.GONE);
                    }
                    Log.e("yrs", "Image Link is : " + imglink);

                } catch (Exception e) {
                    Log.e("yo", "" + e.getMessage()+" ");
                }
            }
            pb.setVisibility(View.GONE);

            Log.e("Yo", imglink+"");
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
