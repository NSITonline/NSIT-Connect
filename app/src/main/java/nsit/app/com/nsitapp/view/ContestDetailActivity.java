package nsit.app.com.nsitapp.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import java.io.File;
import java.io.FileOutputStream;

import nsit.app.com.nsitapp.R;

public  class ContestDetailActivity extends FragmentActivity  {

    ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // inside your activity (if you did not enable transitions in your theme)
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

            // set an exit transition
            getWindow().setEnterTransition(new Slide());
            getWindow().setExitTransition(new Slide());
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_detail);


        if (savedInstanceState == null) {
            Uri contestUri = getIntent().getData();
            Fragment fragment = ContestDetailFragment.newInstance(contestUri);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contest_detail_container,fragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contest_detail, menu);
        return true;
    }

    private Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    private static File saveBitmap(Bitmap bm){
        final String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Screenshots";
        File dir = new File(path);
        if(!dir.exists())
            dir.mkdirs();
        File file = new File(dir, "mantis_image.png");
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 90, fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v("helloooo","i am here");
        if(item.getItemId()==R.id.share_item)
        { Log.v("helloooo","i am here");
            //TODO
            Bitmap bm = screenShot(this.getWindow().getDecorView().findViewById(android.R.id.content));
            File file = saveBitmap(bm);
            Log.i("chase", "filepath: " + file.getAbsolutePath());
            Uri uri = Uri.fromFile(new File(file.getAbsolutePath()));
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this Contest.");
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.setType("image/*");
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(shareIntent, "share via"));
          return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
