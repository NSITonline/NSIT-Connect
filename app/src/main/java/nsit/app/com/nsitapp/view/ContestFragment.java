package nsit.app.com.nsitapp.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.OnlineJudge;
import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.view.widget.SlidingTabLayout;

public class ContestFragment extends Fragment {


    @BindView(R.id.contest_pager) ViewPager mContestPager;
    @BindView(R.id.sliding_tabs) SlidingTabLayout mSlidingTabLayout;

    private final ContestListFragment mRunningContestFragment = new RunningContestFragment();
    private final ContestListFragment mUpcomingContestFragment = new UpcomingContestFragment();
    private int mCurrentItem;

    public static final String FILTER_PREFERENCE_FILE_KEY = "nsit.app.com.nsitapp.FILTER_PREFERENCE_FILE_KEY";

    private static final String VIEW_PAGER_CURRENT_ITEM = ContestFragment.class.getCanonicalName()+".viewpager";
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ContestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContestFragment newInstance() {
        return new ContestFragment();
    }

    public ContestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("we will win","we1");
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contest, container, false);
        ButterKnife.bind(this, view);
        Log.v("we will win","we1");
        SectionPagerAdapter mSectionPagerAdapter = new SectionPagerAdapter(getChildFragmentManager());

//        mContestPager = view.findViewById(R.id.contest_pager);
        mContestPager.setAdapter(mSectionPagerAdapter);

//        SlidingTabLayout mSlidingTabLayout = view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setDistributeEvenly();
        mSlidingTabLayout.setCustomTabColorizer(position -> getResources().getColor(R.color.tab_scroll_color));
        mSlidingTabLayout.setViewPager(mContestPager);

        Log.d("DEBUG","onCreateView()");
        if (savedInstanceState!=null) {
            Log.d("DEBUG","setCurrentItem");

            mCurrentItem = savedInstanceState.getInt(VIEW_PAGER_CURRENT_ITEM);
            Log.d("DEBUG",Integer.toString(mCurrentItem));
        } else {
            mCurrentItem = 0;
        }

        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mContestPager.setCurrentItem(mCurrentItem,false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        mCurrentItem = mContestPager.getCurrentItem();
        outState.putInt(VIEW_PAGER_CURRENT_ITEM,mCurrentItem);
    }

    public void onFilterChanged() {
        mUpcomingContestFragment.onFilterChanged();
        mRunningContestFragment.onFilterChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_contest_list,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.action_fitler :
                showFilterDialog();
                return true;
            default :
                return false;
        }
    }

    private void showFilterDialog() {
        FilterContestDialogFragment filterContestDialogFragment = new FilterContestDialogFragment();
        filterContestDialogFragment.show(getFragmentManager(),"filter");
    }

    private class SectionPagerAdapter extends FragmentPagerAdapter {

        private static final int TAB_RUNNING = 0;
        private static final int TAB_UPCOMING = 1;
        private static final int NUMBER_OF_TAB = 2;

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case TAB_RUNNING:
                    return mRunningContestFragment;
                case TAB_UPCOMING:
                    return mUpcomingContestFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUMBER_OF_TAB;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case TAB_RUNNING:
                    return getString(R.string.title_section_running).toUpperCase(l);
                case TAB_UPCOMING:
                    return getString(R.string.title_section_upcoming).toUpperCase(l);
            }
            return null;
        }
    }

    public static class FilterContestDialogFragment extends DialogFragment {
        private boolean [] mContestFlag;
        private static final String CONTEST_FLAG_KEY = FilterContestDialogFragment.class.getCanonicalName();

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (savedInstanceState!=null) {
                mContestFlag = savedInstanceState.getBooleanArray(CONTEST_FLAG_KEY);
            } else {
                loadContestFlagFromSharedPreference();
            }
        }


        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.filter_dialog_title)
                    .setMultiChoiceItems(R.array.contest_source, mContestFlag, (dialogInterface, i, b) -> mContestFlag[i] = b)
                    .setPositiveButton(R.string.filter_dialog_ok, (dialog, id) -> {
                        saveContestFlagToSharedPreference();
                        if (getActivity() instanceof CodeRadarActivity) {
                            ((CodeRadarActivity) getActivity()).onFilterChanged();
                        }
                    })
                    .setNegativeButton(R.string.filter_dialog_cancel, (dialog, id) -> {
                        // Do nothing
                    });
            return builder.create();
        }

        private void loadContestFlagFromSharedPreference() {
            mContestFlag = new boolean[OnlineJudge.OJ_NUMBER];
            Context context = getActivity();
            SharedPreferences sharedPreferences = context.getSharedPreferences(FILTER_PREFERENCE_FILE_KEY,Context.MODE_PRIVATE);

            for (int i=0;i<OnlineJudge.OJ_NUMBER;i++) {
                mContestFlag[i] = sharedPreferences.getBoolean(OnlineJudge.OJ_NAME[i],true);
            }
        }

        private void saveContestFlagToSharedPreference() {
            Context context = getActivity();
            SharedPreferences sharedPreferences = context.getSharedPreferences(FILTER_PREFERENCE_FILE_KEY,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            for (int i=0;i<OnlineJudge.OJ_NUMBER;i++) {
                editor.putBoolean(OnlineJudge.OJ_NAME[i],mContestFlag[i]);
            }
            sharedPreferences.edit()
                    .putBoolean(OnlineJudge.CODEFORCES, mContestFlag[OnlineJudge.CODEFORCES_ID])
                    .putBoolean(OnlineJudge.CODECHEF, mContestFlag[OnlineJudge.CODECHEF_ID])
                    .putBoolean(OnlineJudge.HACKERRANK, mContestFlag[OnlineJudge.HACKERRANK_ID])
                    .putBoolean(OnlineJudge.HACKEREARTH, mContestFlag[OnlineJudge.HACKEREARTH_ID])
                    .putBoolean(OnlineJudge.TOPCODER, mContestFlag[OnlineJudge.TOPCODER_ID])
                    .putBoolean(OnlineJudge.URIOJ, mContestFlag[OnlineJudge.URIOJ_ID])
                    .putBoolean(OnlineJudge.UNKNOWN, mContestFlag[OnlineJudge.UNKNOWN_ID])
                    .commit();
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            outState.putBooleanArray(CONTEST_FLAG_KEY,mContestFlag);
        }

        @Override
        public void onDestroyView() {
            if (getDialog() != null)
                getDialog().setOnDismissListener(null);
            super.onDestroyView();
        }
    }

}
