package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import butterknife.BindView;
import functions.Utils;


public class Feedback extends Fragment {
    @BindView(R.id.webview) WebView browser;
    @BindView(R.id.pb) ProgressBar pb;
    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        this.activity = (Activity) activity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_feedback, container, false);
//        WebView browser = rootView.findViewById(R.id.webview);
//        pb = rootView.findViewById(R.id.pb);

        browser.setWebViewClient(new MyWebViewClient());
        if (activity != null) {
            if (Utils.isNetworkAvailable(activity))
                browser.loadUrl("http://goo.gl/forms/DS8To6mufz");
            else
                Snackbar.make(pb, R.string.internet_error, Snackbar.LENGTH_LONG).show();
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
        public void onPageFinished(WebView webview, String url) {
            super.onPageFinished(webview, url);
            pb.setVisibility(View.GONE);
            activity.setProgressBarIndeterminateVisibility(false);
        }
    }
}
