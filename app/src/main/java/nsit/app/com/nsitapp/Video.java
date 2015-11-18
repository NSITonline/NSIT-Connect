package nsit.app.com.nsitapp;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import adapters.VideoList_Adapter;
import functions.ButtonAnimation;

/**
 * Created by Sidharth Patro on 21-Jun-15.
 */
public class Video extends Fragment {
    ListView listview;
    String nextPageToken = "";
    String prevPageToken = "";
    String navigateTo = "next";
    Button btnNextPage;
    Button btnPrevPage;
    View Spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }
     @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
    }


    public void populateList(JSONArray Items) {
        listview.setAdapter(new VideoList_Adapter(getActivity(), Items));
    }


    Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);
        listview = (ListView) rootView.findViewById(R.id.videos_list);
        Log.e("YouTube:", "Fetching data");
        Spinner = rootView.findViewById(R.id.VideoProgressSpinner);
        Spinner.setVisibility(View.VISIBLE);

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
            Log.e("YouTube:", "Cannot fetch " + e.toString());
        }


        btnNextPage = (Button) rootView.findViewById(R.id.NextPageButton);
        btnPrevPage = (Button) rootView.findViewById(R.id.PrevPageButton);

        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (nextPageToken != "") {
                        Spinner.setVisibility(View.VISIBLE);
                        navigateTo = "next";
                        ButtonAnimation btnAnimation = new ButtonAnimation();
                        btnAnimation.animateButton(v, getActivity());
                        new Video_RetrieveFeed().execute();
                    }
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
                    Log.e("YouTube:", "Cannot fetch " + e.toString());
                }
            }
        });
        btnPrevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (prevPageToken != "") {
                        Spinner.setVisibility(View.VISIBLE);
                        navigateTo = "prev";
                        ButtonAnimation btnAnimation = new ButtonAnimation();
                        btnAnimation.animateButton(v, getActivity());
                        new Video_RetrieveFeed().execute();
                    }
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
                    Log.e("YouTube:", "Cannot fetch " + e.toString());
                }
            }
        });

        return rootView;
    }

    public class Video_RetrieveFeed extends AsyncTask<String, Void, String> {
        private Exception exception;

        protected String doInBackground(String... urls) {
            try {
                String url = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=UUu445B5LTXzkNr5eft8wNHg&key=AIzaSyBgktirlOODUO9zWD-808D7zycmP7smp-Y";
                if (navigateTo == "next") {
                    url = url + "&pageToken=" + nextPageToken;
                } else if (navigateTo == "prev") {
                    url = url + "&pageToken=" + prevPageToken;
                }
                HttpClient client = new DefaultHttpClient();
                HttpUriRequest request = new HttpGet(url);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                String Result = client.execute(request, responseHandler);

                return Result;
            } catch (Exception e) {
                this.exception = e;
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String Result) {
            try {
                JSONObject YTFeed = new JSONObject(String.valueOf(Result));
                JSONArray YTFeedItems = YTFeed.getJSONArray("items");
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
                populateList(YTFeedItems);
                Spinner.setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
