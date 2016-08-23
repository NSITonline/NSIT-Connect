package nsit.app.com.nsitapp.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;


public class ContestProvider extends ContentProvider {

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private static final int CONTEST = 100;
    private static final int CONTEST_WITH_ID = 101;
    private static final int CONTEST_WITH_SOURCE = 200;

    private static final SQLiteQueryBuilder sQueryBuilder;

    static {
        sQueryBuilder = new SQLiteQueryBuilder();
        sQueryBuilder.setTables(ContestContract.ContestEntry.TABLE_NAME);
    }

    private ContestDBHelper mOpenHelper;


    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = ContestContract.CONTENT_AUTHORITY;

        matcher.addURI(authority,ContestContract.PATH_CONTEST,CONTEST);
        matcher.addURI(authority,ContestContract.PATH_CONTEST + "/#",CONTEST_WITH_ID);
        matcher.addURI(authority,ContestContract.PATH_CONTEST + "/*",CONTEST_WITH_SOURCE);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new ContestDBHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
        int match = sUriMatcher.match(uri);

        switch (match) {
            case CONTEST:
                return ContestContract.ContestEntry.CONTENT_DIR_TYPE;
            case CONTEST_WITH_ID:
                return ContestContract.ContestEntry.CONTENT_ITEM_TYPE;
            case CONTEST_WITH_SOURCE:
                return ContestContract.ContestEntry.CONTENT_DIR_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int match = sUriMatcher.match(uri);
        Cursor retCursor;
        switch (match) {
            case CONTEST:
                retCursor = getContest(projection,selection,selectionArgs,sortOrder);
                break;
            case CONTEST_WITH_SOURCE:
                retCursor = getContestWithSource(uri,projection,sortOrder);
                break;
            case CONTEST_WITH_ID:
                retCursor = getContestWithID(uri,projection,sortOrder);
                break;
            default:
                throw  new UnsupportedOperationException("Unknown uri : " + uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(),uri);
        return retCursor;
    }

    private Cursor getContest(String[] projection, String selection,
                              String[] selectionArgs, String sortOrder) {

        return sQueryBuilder.query(mOpenHelper.getReadableDatabase(),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );
    }

    private Cursor getContestWithSource(Uri uri,String[] projection, String sortOrder) {
        String source = ContestContract.ContestEntry.getSourceFromUri(uri);

        String selection = ContestContract.ContestEntry.COLUMN_SOURCE + " = ? ";
        String[] selectionArgs = new String[] {source};

        return sQueryBuilder.query(mOpenHelper.getReadableDatabase(),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);
    }

    private Cursor getContestWithID(Uri uri,String[] projection, String sortOrder) {
        int id = ContestContract.ContestEntry.getIDFromUri(uri);

        String selection = ContestContract.ContestEntry._ID + " = ? ";
        String[] selectionArgs = new String[] {Integer.toString(id)};

        return sQueryBuilder.query(mOpenHelper.getReadableDatabase(),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        int match = sUriMatcher.match(uri);
        Uri returnUri;
        switch(match) {
            case CONTEST: {

                long _id = db.insert(ContestContract.ContestEntry.TABLE_NAME,null,contentValues);
                if (_id>0) {
                    returnUri = ContestContract.ContestEntry.buildContestUriWithId(_id);
                }
                else {
                    throw new SQLException("Failed to insert row into + "+uri);
                }
                break;

            }
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        getContext().getContentResolver().notifyChange(uri,null);

        return returnUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        int match = sUriMatcher.match(uri);
        int rowsDeleted = 0;
        switch(match) {
            case CONTEST: {


                rowsDeleted = db.delete(ContestContract.ContestEntry.TABLE_NAME,
                        selection,
                        selectionArgs);
                break;

            }
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        if (rowsDeleted!=0)
            getContext().getContentResolver().notifyChange(uri,null);

        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues newValues, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        int match = sUriMatcher.match(uri);
        int rowsUpdated = 0;
        switch(match) {
            case CONTEST: {

                rowsUpdated = db.update(ContestContract.ContestEntry.TABLE_NAME,
                        newValues,
                        selection,
                        selectionArgs);
                break;

            }
            default:
                throw new UnsupportedOperationException("Unknown uri : " + uri);
        }

        if (rowsUpdated!=0)
            getContext().getContentResolver().notifyChange(uri,null);

        return rowsUpdated;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case CONTEST:
                db.beginTransaction();
                int returnCount = 0;
                try {
                    for (ContentValues value : values) {
                        if (value.getAsString(ContestContract.ContestEntry.COLUMN_DESCRIPTION).equals("")) {
                            value.remove(ContestContract.ContestEntry.COLUMN_DESCRIPTION);
                            value.put(ContestContract.ContestEntry.COLUMN_DESCRIPTION,
                                    "No description available.");
                        }

                        long _id = db.insert(ContestContract.ContestEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                getContext().getContentResolver().notifyChange(uri, null);
                return returnCount;
            default:
                return super.bulkInsert(uri, values);
        }

    }
}
