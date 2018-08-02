package nsit.app.com.nsitapp.view;


import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;

import models.OnlineJudge;
import nsit.app.com.nsitapp.data.ContestContract;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class RunningContestFragment extends ContestListFragment {


    public RunningContestFragment() {
        super();
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.d("DEBUG","RunningContestFragment.onCreateLoader()");

        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences(ContestFragment.FILTER_PREFERENCE_FILE_KEY,Context.MODE_PRIVATE);

        StringBuilder whereClause = new StringBuilder(ContestContract.ContestEntry.COLUMN_START_TIME + " < ? AND " +
                ContestContract.ContestEntry.COLUMN_END_TIME + " > ?");

        whereClause.append(" AND " + ContestContract.ContestEntry.COLUMN_SOURCE + " NOT IN (");
        for (int i = 0; i < OnlineJudge.OJ_NUMBER; i++) {
            boolean isShown = sharedPref.getBoolean(OnlineJudge.OJ_NAME[i], true);
            if (!isShown) {
                whereClause.append("'").append(OnlineJudge.OJ_NAME[i]).append("', ");
            }
        }
        whereClause.append("'DUMMY')");

        String[] whereArgs = {
                Long.toString(System.currentTimeMillis()),
                Long.toString(System.currentTimeMillis())
        };

        return new CursorLoader(getActivity(),
                ContestContract.ContestEntry.CONTENT_URI,
                CONTEST_SUMMARY_COLUMNS,
                whereClause.toString(),
                whereArgs,
                ContestContract.ContestEntry.COLUMN_START_TIME+" ASC");
    }
}
