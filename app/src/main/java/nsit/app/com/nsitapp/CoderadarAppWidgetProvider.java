package nsit.app.com.nsitapp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;

import nsit.app.com.nsitapp.data.ContestContract;

/**
 * Created by saisumit on 6/22/15.
 */
public class CoderadarAppWidgetProvider extends AppWidgetProvider{

    private static final String[] CONTEST_COLUMNS = {
            ContestContract.ContestEntry._ID,
            ContestContract.ContestEntry.COLUMN_TITLE,
            ContestContract.ContestEntry.COLUMN_SOURCE,
            ContestContract.ContestEntry.COLUMN_START_TIME
    };

    static final int COL_CONTEST_ID = 0;
    static final int COL_CONTEST_TITLE = 1;
    static final int COL_CONTEST_SOURCE = 2;
    static final int COL_CONTEST_START_TIME = 3;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        ContentResolver contentResolver = context.getContentResolver();

        Cursor cursor = contentResolver.query(ContestContract.ContestEntry.CONTENT_URI,
                CONTEST_COLUMNS,
                null,
                null,
                ContestContract.ContestEntry.COLUMN_START_TIME+" ASC");

        if (cursor.moveToNext()) {
            // do something
        }


    }
}
