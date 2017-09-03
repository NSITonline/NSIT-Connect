package nsit.app.com.nsitapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapters.MemberAdapter;
import functions.ButtonAnimation;

/**
 * Created by Kartik Kwatra on 26-08-2017.
 */

public class AboutUs extends Fragment implements LoaderManager.LoaderCallbacks<List<AboutUsMember>> {


    private static MemberAdapter mAdapter;
    private static final String LOG_TAG = AboutUs.class.getName();
    private static final int LOADER_ID = 1;
    private Activity aboutUsAct;
    private View rootView;

    public AboutUs() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_aboutus, container, false);
        ListView aboutUsListView = (ListView) rootView.findViewById(R.id.teamList);
        aboutUsAct = getActivity();
        View footerView = ((LayoutInflater) aboutUsAct.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_aboutus_footer, null, false);
        mAdapter = new MemberAdapter(getActivity(), new ArrayList<AboutUsMember>());
        aboutUsListView.setAdapter(mAdapter);
        aboutUsListView.addFooterView(footerView);
        TextView goToRepo = (TextView) rootView.findViewById(R.id.GoToRepo);
        TextView contribute = (TextView) rootView.findViewById(R.id.contribute);
        goToRepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getContext());
                Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        contribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ButtonAnimation btnAnimation = new ButtonAnimation();
                btnAnimation.animateButton(view, getContext());
                Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2/wiki");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        getLoaderManager().initLoader(LOADER_ID, null, this);
        return rootView;

    }

    @Override
    public Loader<List<AboutUsMember>> onCreateLoader(int id, Bundle args) {
        return new AboutUsLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<AboutUsMember>> loader, List<AboutUsMember> teamMembers) {
        View loadingIndicator = rootView.findViewById(R.id.loadingIndicator1);
        loadingIndicator.setVisibility(View.GONE);
        mAdapter.clear();
        if (teamMembers != null && !teamMembers.isEmpty()) {
            mAdapter.addAll(teamMembers);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<AboutUsMember>> loader) {
        mAdapter.clear();
    }


}
