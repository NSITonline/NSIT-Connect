package nsit.app.com.nsitapp;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Sidharth Patro on 21-Jun-15.
 */
public class Video extends Fragment {
    ListView listview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    Activity activity;
    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);
//        Videos List Initialization.
        listview = (ListView) rootView.findViewById(R.id.videos_list);
        listview.setAdapter(new VideoList_Adapter(getActivity(), new String[] { "data1",
                "data2" }));
//

//        Test Button to check whether YouTube Player API is working or not.
        Button TestYouTubePlayer = (Button)rootView.findViewById(R.id.startTestVideo);
        TestYouTubePlayer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    Intent intent = YouTubeStandalonePlayer.createVideoIntent(getActivity(), "AIzaSyD-hWnEb2F-94y6XyaG5WlKXZKBpKr9PaE", "zXLZvsSmBIs");
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                    alertDialog.setTitle("YouTube API not found.");
                    alertDialog.setMessage("This section needs YouTube app to be installed on your device. Please get it from the Google Play Store.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } catch (Exception e) {
                    AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                    alertDialog.setTitle("Oops!");
                    alertDialog.setMessage("The error exception is " + e.toString() + " ; Send this to us and we will get this fixed.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
//      Test Button to check whether YouTube Data API is working or not.
        Button TestYouTubeData = (Button)rootView.findViewById(R.id.fetchVideos);
        TestYouTubeData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.e("YouTube:", "Fetching data");
                try {
                    new Video_RetrieveFeed().execute();
                } catch (Exception e) {
                    AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                    alertDialog.setTitle("Can't connect.");
                    alertDialog.setMessage("We cannot connect to the internet right now. Please try again later. Exception e: " + e.toString());
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    Log.e("YouTube:", "Cannot fetch "+e.toString());
                }

            }
        });

//        End of TestButton

        return rootView;
    }

    public class Video_RetrieveFeed extends AsyncTask<String, Void, String> {
        private Exception exception;

        String ReceivedResult;

        protected String doInBackground(String... urls) {
            try {
                Log.e("YouTube Data","Starting to fetch stuff");
                HttpClient client = new DefaultHttpClient();
                HttpUriRequest request = new HttpGet("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=UUu445B5LTXzkNr5eft8wNHg&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y");
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String Result = client.execute(request, responseHandler);
                return Result;
            } catch (Exception e) {
                this.exception = e;
                Log.e("YouTube Data", e.toString());
                e.printStackTrace();
                return null;
            }
        }

        protected void onProgressUpdate(Integer... progress) {
            Log.e("Progress is: ",progress.toString());
        }

        @Override
        protected void onPostExecute(String Result) {
            try{
                Log.e("YouTube Data", "Received Result: "+Result.toString());
                JSONObject YTFeed = new JSONObject(String.valueOf(Result));
                Log.e("YouTube Data",YTFeed.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
