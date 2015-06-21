package nsit.app.com.nsitapp;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import functions.ImageLoader;


public class Decsription extends AppCompatActivity {
    public ImageLoader imageLoader;
    String img,des,like,link;
    TextView Des,Like;
    Button Link;
    ImageView imageView;
    String imglink,obid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decsription);

        setTitle("Post");
        Intent i = getIntent();
        img = i.getStringExtra("img");
        des = i.getStringExtra("dec");
        like = i.getStringExtra("like");
        link = i.getStringExtra("link");
        imageLoader=new ImageLoader(this);
        obid = i.getStringExtra("oid");

        imageView = (ImageView) findViewById(R.id.image);
        Like = (TextView) findViewById(R.id.likes);
        Link = (Button) findViewById(R.id.link);
        Des = (TextView) findViewById(R.id.des);

        Log.e("object id is : ", "" + obid);

        if(like==null)
            Like.setText("0");
        else
            Like.setText(like);
        Des.setText(des);
        Link.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Uri uri = Uri.parse(link);
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        startActivity(intent);
                                    }
                                }
        );
        if(isNetworkAvailable()) {
            if (img == null)
                imageView.setVisibility(View.GONE);
            else if (obid == null)
                imageLoader.DisplayImage(img, imageView);
            else
                new DownloadWebPageTask().execute();
        }
        if (img == null)
            imageView.setVisibility(View.GONE);
        else imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Decsription.this,ImageAct.class);
                i.putExtra("img",img);
                i.putExtra("oid",obid);
                startActivity(i);

            }
        });

    }

String text;
    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            Log.e("Yo", "Started");
            String URL = "https://graph.facebook.com/"+obid+"?fields=images&access_token="+ Val.common_access;
            HttpClient Client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                text = Client.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("eroore",e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Log.e("YO", "Done" + obid + text);
//            Log.e("yrs",text);
            JSONObject ob;
            JSONArray arr;
            try {
                ob = new JSONObject(text);

                arr = ob.getJSONArray("images");

                if(arr.getJSONObject(0).has("source"))
                imglink = arr.getJSONObject(0).getString("source");
                if(imglink!=null) {
                    if (isNetworkAvailable())
                        imageLoader.DisplayImage(imglink, imageView);
 }
                else
                    imageView.setVisibility(View.GONE);
                Log.e("yrs","Image Link is : " + imglink);

            } catch (Exception e) {
                    Log.e("yo",e.getMessage());
            }

            Log.e("Yo", imglink);
        }
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_decsription, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
