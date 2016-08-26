package adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import nsit.app.com.nsitapp.R;

/**
 * Created by Naman Maheshwari on 26-08-16.
 */
public class ImageViewPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<Bitmap> images;
    private Context context;

    public ImageViewPagerAdapter(Context context, ArrayList<Bitmap> images) {
        this.images = images;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.image_slideshow_view, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_preview);
        imageView.setImageBitmap(images.get(position));

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == ((View) obj);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
