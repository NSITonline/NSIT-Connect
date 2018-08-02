package nsit.app.com.nsitapp.AboutUs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.MemberAdapter;
import butterknife.ButterKnife;
import butterknife.OnClick;
import functions.ButtonAnimation;
import models.AboutUsMember;
import nsit.app.com.nsitapp.R;

/**
 * Created by Kartik Kwatra on 26-08-2017.
 */

public class AboutUsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<AboutUsMember>> {

    private static MemberAdapter mAdapter;
    private static final int LOADER_ID = 1;
    private Context context;
    private View rootView;

    ListView aboutUsListView;

    public AboutUsFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_aboutus, container, false);

        View footerView = ((LayoutInflater)context
                .getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.fragment_aboutus_footer, null, false);
        ButterKnife.bind(this, footerView);

        mAdapter = new MemberAdapter(context, new ArrayList<>());
        aboutUsListView = rootView.findViewById(R.id.teamList);
        aboutUsListView.setAdapter(mAdapter);
        aboutUsListView.addFooterView(footerView);

        getLoaderManager().initLoader(LOADER_ID, null, this);

        return rootView;
    }

    @OnClick(R.id.GoToRepo)
    public void goToRepo(View view) {
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getContext());
        Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @OnClick(R.id.contribute)
    public void contribute(View view) {
        ButtonAnimation btnAnimation = new ButtonAnimation();
        btnAnimation.animateButton(view, getContext());
        Uri uri = Uri.parse("https://github.com/Swati4star/NSIT-App-v2/wiki");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @NonNull
    @Override
    public Loader<List<AboutUsMember>> onCreateLoader(int id, Bundle args) {
        return new AboutUsLoader(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<AboutUsMember>> loader, List<AboutUsMember> teamMembers) {
        View loadingIndicator = rootView.findViewById(R.id.loadingIndicator1);
        loadingIndicator.setVisibility(View.GONE);
        mAdapter.clear();
        if (teamMembers != null && !teamMembers.isEmpty()) {
            mAdapter.addAll(teamMembers);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<AboutUsMember>> loader) {
        mAdapter.clear();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
