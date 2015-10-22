package nsit.app.com.nsitapp.view;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.data.ContestContract;

public abstract class ContestListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    //private OnFragmentInteractionListener mListener;
    private ListView mContestListView;
    private ContestAdapter mContestAdapter;

    private static final int CONTEST_LOADER_ID = 0;

    protected static final String[] CONTEST_SUMMARY_COLUMNS = {
            ContestContract.ContestEntry._ID,
            ContestContract.ContestEntry.COLUMN_TITLE,
            ContestContract.ContestEntry.COLUMN_SOURCE,
            ContestContract.ContestEntry.COLUMN_START_TIME
    };


    static final int COL_CONTEST_ID = 0;
    static final int COL_CONTEST_TITLE = 1;
    static final int COL_CONTEST_SOURCE = 2;
    static final int COL_CONTEST_START_TIME = 3;

    public interface Callback {
        public void onItemSelected(Uri contestUri, ImageView logo);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contest_list, container, false);

        mContestAdapter = new ContestAdapter(getActivity(),null,0);

        mContestListView = (ListView) view.findViewById(R.id.contest_listView);
        mContestListView.setAdapter(mContestAdapter);

        mContestListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Cursor cursor = (Cursor)adapterView.getItemAtPosition(position);

                ImageView logo = (ImageView) view.findViewById(R.id.onlineJudge_image);

                if (cursor!=null) {
                    Long contestId = cursor.getLong(COL_CONTEST_ID);
                    ((Callback) getActivity())
                            .onItemSelected(ContestContract.ContestEntry.buildContestUriWithId(contestId),logo);
                }

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


    @Override
    public abstract Loader<Cursor> onCreateLoader(int id, Bundle args);

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mContestAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mContestAdapter.swapCursor(null);
    }

}
