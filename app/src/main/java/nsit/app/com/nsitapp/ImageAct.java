package nsit.app.com.nsitapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageAct extends AppCompatActivity {
    String img,des,like,link,obid,imglink;
    //ProgressBar pb;
    TouchImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
       Intent i = getIntent();
        img = i.getStringExtra("img");
        obid = i.getStringExtra("oid");
        iv  = (TouchImageView) findViewById(R.id.iv);
        //=(ProgressBar)findViewById(R.id.progressBar1);

        setTitle("Image");

        if(isNetworkAvailable()) {
            if (img == null)
                iv.setVisibility(View.GONE);
            else if (obid == null)
                new DownloadImageTask(iv).execute(img);
            else
                new DownloadWebPageTask().execute();
        }
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
        if(id== R.id.save)
        {
            iv.setDrawingCacheEnabled(true);
            Bitmap b = iv.getDrawingCache();

            File root = Environment.getExternalStorageDirectory();
            File dir = new File(root.getAbsolutePath() +"/NSIT Online");
            try{
                if(dir.mkdir()) {
                    System.out.println("Directory created");
                    Log.e("yo", "Directory created");
                } else {
                    System.out.println("Directory is not created");
                    Log.e("yo", "Directory not created");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
              File cachePath = new File(root.getAbsolutePath() + "/NSIT Online/image_"+ System.currentTimeMillis()+ ".jpg");




            try
            {
                cachePath.createNewFile();
                FileOutputStream ostream = new FileOutputStream(cachePath);
                b.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                ostream.close();
                Toast.makeText(ImageAct.this,"Image Saved",Toast.LENGTH_SHORT).show();

            }
            catch (Exception e)
            {
                e.printStackTrace();
                Log.e("Error","Error : " + e.getMessage());
            }

        }

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
         bmImage.setImageBitmap(result);
           // pb.setVisibility(View.INVISIBLE);
        }
    }

    String text;
    private class DownloadWebPageTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {

            //  bar.setVisibility(View.VISIBLE);

        };

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
            }

            return null;

        }

        @Override
        protected void onPostExecute(String result) {
            Log.e("YO", "Done" + obid);
            Log.e("yrs",text);
            JSONObject ob;
            JSONArray arr;
            try {
                ob = new JSONObject(text);
                arr = ob.getJSONArray("images");

                imglink = arr.getJSONObject(0).getString("source");
                if(imglink!=null)
                    if(isNetworkAvailable())
                        new DownloadImageTask(iv).execute(imglink);
                    else iv.setVisibility(View.GONE);
            } catch (Exception e) {
                Log.e("yo",e.getMessage());
            }


            Log.e("yrs","Image Link is : " + imglink);

        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
