package nsit.app.com.nsitapp.view;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.data.ContestContract;
import nsit.app.com.nsitapp.model.Contest;
import nsit.app.com.nsitapp.model.OnlineJudge;

import static functions.Utils.getReadableDurationFromMillis;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContestDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContestDetailFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String CONTEST_DETAIL_URI = ContestDetailFragment
            .class.getCanonicalName() +
            ".contestDetailUri";

    private Uri mContestUri;

    private RelativeLayout mOJCover;
    private View mBanner;
    private ImageView mOJIcon;
    private TextView mTitleText;
    private TextView mSourceText;
    private TextView mDescriptionText;
    private TextView mStartTimeText;
    private TextView mDurationText;
    private TextView mURLText;

    private TextView mDescriptionHeaderText;
    private TextView mStartTimeHeaderText;
    private TextView mDurationHeaderText;
    private TextView mURLHeaderText;

    private Contest mContest;

    private static final String[] CONTEST_DETAIL_COLUMNS = {
            ContestContract.ContestEntry._ID,
            ContestContract.ContestEntry.COLUMN_TITLE,
            ContestContract.ContestEntry.COLUMN_SOURCE,
            ContestContract.ContestEntry.COLUMN_DESCRIPTION,
            ContestContract.ContestEntry.COLUMN_START_TIME,
            ContestContract.ContestEntry.COLUMN_END_TIME,
            ContestContract.ContestEntry.COLUMN_URL
    };

    public static final int COLUMN_ID = 0;
    private static final int COLUMN_TITLE = 1;
    private static final int COLUMN_SOURCE = 2;
    private static final int COLUMN_DESCRIPTION = 3;
    private static final int COLUMN_START_TIME = 4;
    private static final int COLUMN_END_TIME = 5;
    private static final int COLUMN_URL = 6;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param contestUri Parameter 1.
     * @return A new instance of fragment ContestDetailFragment.
     */
    public static ContestDetailFragment newInstance(Uri contestUri) {
        ContestDetailFragment fragment = new ContestDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(CONTEST_DETAIL_URI, contestUri);
        fragment.setArguments(args);
        return fragment;
    }

    public ContestDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContestUri = getArguments().getParcelable(CONTEST_DETAIL_URI);
        }
        setRetainInstance(true);
        mContest = new Contest();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contest_detail,container,false);

        bindView(view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        int LOADER_ID = 0;
        getLoaderManager().initLoader(LOADER_ID, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    private void bindView(View view) {

        mOJCover = (RelativeLayout) view.findViewById(R.id.onlineJudge_cover);

        mBanner = view.findViewById(R.id.banner);

        mOJIcon = (ImageView) view.findViewById(R.id.onlineJudge_icon);

        mTitleText = (TextView) view.findViewById(R.id.title_text);
        mSourceText = (TextView) view.findViewById(R.id.source_text);
        mDescriptionText = (TextView) view.findViewById(R.id.description_body_text);
        mStartTimeText = (TextView) view.findViewById(R.id.start_time_body_text);
        mDurationText = (TextView) view.findViewById(R.id.duration_body_text);
        mURLText = (TextView) view.findViewById(R.id.url_body_text);

        mDescriptionHeaderText = (TextView) view.findViewById(R.id.description_header_text);
        mStartTimeHeaderText = (TextView) view.findViewById(R.id.start_time_header_text);
        mDurationHeaderText = (TextView) view.findViewById(R.id.duration_header_text);
        mURLHeaderText = (TextView) view.findViewById(R.id.url_header_text);
    }

    private void setThemeColor(int color) {
        mDescriptionHeaderText.setTextColor(color);
        mStartTimeHeaderText.setTextColor(color);
        mDurationHeaderText.setTextColor(color);
        mURLHeaderText.setTextColor(color);

        mBanner.setBackgroundColor(color);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        return new CursorLoader(
                getActivity(),
                mContestUri,
                CONTEST_DETAIL_COLUMNS,
                null,
                null,
                null
        );
    }


    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor data) {
        if (data!=null && data.moveToFirst()) {

            mContest.title(data.getString(COLUMN_TITLE))
                    .source(data.getString(COLUMN_SOURCE))
                    .description(data.getString(COLUMN_DESCRIPTION))
                    .startDate(data.getLong(COLUMN_START_TIME))
                    .finishDate(data.getLong(COLUMN_END_TIME))
                    .URL(data.getString(COLUMN_URL));

            mTitleText.setText(mContest.getTitle());

            mSourceText.setText(mContest.getSource());

            mDescriptionText.setText(mContest.getDescription());


            SimpleDateFormat sdf = new SimpleDateFormat("ccc, d MMM yyyy HH:mm");
            Date date = new Date(mContest.getStartDate());
            mStartTimeText.setText(sdf.format(date));

            Long durationMillis = mContest.getFinishDate() - mContest.getStartDate();
            mDurationText.setText(getReadableDurationFromMillis(durationMillis));

            if (mContest.getURL().equals("")) {
                mURLText.setText(R.string.no_url);
            } else {
                mURLText.setText(mContest.getURL());
            }

            int themeColorResId = OnlineJudge.getColor(mContest.getSource());
            int themeColor = getActivity().getResources().getColor(themeColorResId);
            setThemeColor(themeColor);

            mOJCover.setBackgroundColor(themeColor);

            mOJIcon.setImageResource(OnlineJudge.getIcon(mContest.getSource()));

        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                NavUtils.navigateUpFromSameTask(getActivity());
                return true;
            case R.id.action_calendar : {
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.Events.TITLE, mContest.getTitle())
                        .putExtra(CalendarContract.Events.DESCRIPTION,mContest.getDescription())
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, mContest.getStartDate())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, mContest.getFinishDate());
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;
            }
            case R.id.action_browse : {
                if (mContest.getURL().equals("")) {
                    Toast.makeText(getActivity(),"No Url available",Toast.LENGTH_SHORT).show();
                } else {
                    Uri webpage = Uri.parse(mContest.getURL());
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
