package nsit.app.com.nsitapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import adapters.ImageViewPagerAdapter;


/**
 * Created by Naman Maheshwari on 26-08-16.
 */
public class ImageSlideshowFragment extends DialogFragment {

    private ArrayList<Bitmap> images;
    private ViewPager viewPager;
    private TextView imagePos;
    private ImageViewPagerAdapter imageViewPagerAdapter;

    public ImageSlideshowFragment() {
        // Empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_slideshow, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.imageviewpager);
        imagePos = (TextView) view.findViewById(R.id.image_pos);

        images = (ArrayList<Bitmap>) getArguments().getSerializable("images");

        imageViewPagerAdapter = new ImageViewPagerAdapter(getContext(), images);
        viewPager.setAdapter(imageViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                imagePos.setText((position+1) + " / " + images.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setCurrentItem(0, false);
        imagePos.setText("1 / " + images.size());

        return view;
    }

    public void notifyDataSetChanged(int x) {
        Log.d("HEY", "NOTIFIED!!!"+Integer.toString(x));
        imageViewPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
