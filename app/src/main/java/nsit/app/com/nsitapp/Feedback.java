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
import android.widget.Toast;

import functions.Utils;


public class Feedback extends Fragment {
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
        if(activity!=null) {
            if (Utils.isNetworkAvailable(activity))
                browser.loadUrl("http://goo.gl/forms/DS8To6mufz");
            else
                Toast.makeText(activity, "Cannot connect to Internet", Toast.LENGTH_SHORT).show();
        }
        return rootView;

    }
}
