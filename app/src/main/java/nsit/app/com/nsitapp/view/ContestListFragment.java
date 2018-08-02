package nsit.app.com.nsitapp.view;

import android.database.Cursor;
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
import android.widget.ImageView;
import android.widget.ListView;

import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.data.ContestContract;

public abstract class ContestListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private ContestAdapter mContestAdapter;

    private static final int CONTEST_LOADER_ID = 0;

    static final String[] CONTEST_SUMMARY_COLUMNS = {
            ContestContract.ContestEntry._ID,
            ContestContract.ContestEntry.COLUMN_TITLE,
            ContestContract.ContestEntry.COLUMN_SOURCE,
            ContestContract.ContestEntry.COLUMN_START_TIME
    };


    private static final int COL_CONTEST_ID = 0;
    static final int COL_CONTEST_TITLE = 1;
    static final int COL_CONTEST_SOURCE = 2;
    static final int COL_CONTEST_START_TIME = 3;

    public interface Callback {
        void onItemSelected(Uri contestUri, ImageView logo);
    }

    // TODO: Rename and change types and number of parameters

    public ContestListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contest_list, container, false);

        mContestAdapter = new ContestAdapter(getActivity());

        ListView mContestListView = view.findViewById(R.id.contest_listView);
        mContestListView.setAdapter(mContestAdapter);

        mContestListView.setOnItemClickListener((adapterView, view1, position, l) -> {

            Cursor cursor = (Cursor)adapterView.getItemAtPosition(position);

            ImageView logo = view1.findViewById(R.id.onlineJudge_image);

            if (cursor!=null) {
                Long contestId = cursor.getLong(COL_CONTEST_ID);
                ((Callback) getActivity())
                        .onItemSelected(ContestContract.ContestEntry.buildContestUriWithId(contestId),logo);
            }

        });

        updateContest();

        return view;
    }

    private void updateContest() {

        //SyncAdapter.syncImmediately(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(CONTEST_LOADER_ID,null,this);
    }

    public void onFilterChanged() {
        getLoaderManager().restartLoader(CONTEST_LOADER_ID, null, this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(CONTEST_LOADER_ID,null,this);
    }


    @NonNull
    @Override
    public abstract Loader<Cursor> onCreateLoader(int id, Bundle args);

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        mContestAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mContestAdapter.swapCursor(null);
    }

}
