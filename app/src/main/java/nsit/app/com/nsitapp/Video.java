package nsit.app.com.nsitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import adapters.VideoListAdapter;
import functions.ButtonAnimation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Sidharth Patro on 21-Jun-15.
 */
public class Video extends Fragment {
    private ListView listview;
    private String nextPageToken = "";
    private String prevPageToken = "";
    private String navigateTo = "next";
    private Button btnNextPage;
    private Button btnPrevPage;
    private View Spinner;
    private Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void populateList(JSONArray Items) {
        listview.setAdapter(new VideoListAdapter(activity, Items));
    }

    private Activity activity;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity)activity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);
        listview = rootView.findViewById(R.id.videos_list);
        Spinner = rootView.findViewById(R.id.VideoProgressSpinner);
        Spinner.setVisibility(View.VISIBLE);
        mHandler = new Handler(Looper.getMainLooper());

        // Loading videos initially
        loadFeed();

        // Set up buttons for next and previous page
        btnNextPage = rootView.findViewById(R.id.NextPageButton);
        btnPrevPage = rootView.findViewById(R.id.PrevPageButton);

        btnNextPage.setOnClickListener(v -> {
            if (!Objects.equals(nextPageToken, "")) {
                Spinner.setVisibility(View.VISIBLE);
                navigateTo = "next";
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, activity);
                loadFeed();
            }

        });
        btnPrevPage.setOnClickListener(v -> {
            if (!Objects.equals(prevPageToken, "")) {
                Spinner.setVisibility(View.VISIBLE);
                navigateTo = "prev";
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(v, activity);
                loadFeed();
            }
        });

        return rootView;
    }

    private void loadFeed() {

        // Youtube URI to fetch requests
        String uri = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=UUu445B5LTXzkNr5eft8wNHg&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y";
        if (Objects.equals(navigateTo, "next")) {
            uri = uri + "&pageToken=" + nextPageToken;
        } else if (Objects.equals(navigateTo, "prev")) {
            uri = uri + "&pageToken=" + prevPageToken;
        }

        Log.e("Video", uri);

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
                final String res = response.body().string();
                try {
                    JSONObject YTFeed = new JSONObject(res);
                    final JSONArray YTFeedItems = YTFeed.getJSONArray("items");
                    if (YTFeed.has("nextPageToken")) {
                        nextPageToken = YTFeed.getString("nextPageToken");
                        btnNextPage.setAlpha(1f);
                    } else {
                        nextPageToken = "";
                        btnNextPage.setAlpha(0.3f);
                    }
                    if (YTFeed.has("prevPageToken")) {
                        prevPageToken = YTFeed.getString("prevPageToken");
                        btnPrevPage.setAlpha(1f);
                    } else {
                        prevPageToken = "";
                        btnPrevPage.setAlpha(0.3f);
                    }
                    mHandler.post(() -> {
                        populateList(YTFeedItems);
                        Spinner.setVisibility(View.GONE);
                    });
                } catch (final Exception e) {
                    mHandler.post(() -> {
                        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
                        alertDialog.setTitle("Can't connect.");
                        alertDialog.setMessage("We cannot connect to the internet right now. Please try again later. Exception e: " + e.toString());
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.filter_dialog_ok),
                                (dialog, which) -> dialog.dismiss());
                        alertDialog.show();
                    });
                    Log.e("Error : ", e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}