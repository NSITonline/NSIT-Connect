package nsit.app.com.nsitapp;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import functions.Utils;


public class Feedback extends Fragment {
    ProgressBar pb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
        View rootView = inflater.inflate(R.layout.activity_feedback, container, false);
        WebView browser = (WebView) rootView.findViewById(R.id.webview);
        pb= (ProgressBar) rootView.findViewById(R.id.pb);

        browser.setWebViewClient(new MyWebViewClient());
        if(activity!=null) {
            if (Utils.isNetworkAvailable(activity))
                browser.loadUrl("http://goo.gl/forms/DS8To6mufz");
            else
                SnackbarManager.show(
                        Snackbar.with(activity.getApplicationContext())
                                .text("Check You Internet Connection")
                                .duration(Snackbar.SnackbarDuration.LENGTH_SHORT), activity);
        }
        return rootView;

    }
    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }
        @Override
        public void onPageFinished(WebView webview, String url){
            super.onPageFinished(webview, url);
            pb.setVisibility(View.GONE);
            activity.setProgressBarIndeterminateVisibility(false);
        }
    }

}
