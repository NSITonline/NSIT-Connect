package nsit.app.com.nsitapp.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import models.OnlineJudge;
import nsit.app.com.nsitapp.data.ContestContract;


/**
 * Created by saisumit on 5/24/15.
 */
public class UpcomingContestFragment extends ContestListFragment {

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        StringBuilder whereClause = new StringBuilder(ContestContract.ContestEntry.COLUMN_START_TIME + " > ?");


        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences(ContestFragment.FILTER_PREFERENCE_FILE_KEY,Context.MODE_PRIVATE);

        whereClause.append(" AND " + ContestContract.ContestEntry.COLUMN_SOURCE + " NOT IN (");
        for (int i = 0; i < OnlineJudge.OJ_NUMBER; i++) {
            boolean isShown = sharedPref.getBoolean(OnlineJudge.OJ_NAME[i], true);
            if (!isShown) {
                whereClause.append("'").append(OnlineJudge.OJ_NAME[i]).append("', ");
            }
        }
        whereClause.append("'DUMMY')"); //This ensure


        String[] whereArgs = {
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
