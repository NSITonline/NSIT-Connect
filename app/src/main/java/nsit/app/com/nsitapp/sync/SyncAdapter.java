package nsit.app.com.nsitapp.sync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SyncRequest;
import android.content.SyncResult;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.data.ContestContract;
import nsit.app.com.nsitapp.model.Contest;
import nsit.app.com.nsitapp.network.StringDownloader;
import functions.ContestParser;


public class SyncAdapter extends AbstractThreadedSyncAdapter{

    public static final int SYNC_INTERVAL = 3 * 60 * 60;
    public static final int SYNC_FLEXTIME = SYNC_INTERVAL/2;
    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    @Override
    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        Log.d("DEBUG","onPerformSync");
        StringDownloader downloader = new StringDownloader();
        try {
            downloader.download("https://www.hackerrank.com/calendar/feed.rss");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String rssString = downloader.getString();

        ContestParser parser = new ContestParser();
        Log.d("DEBUG",rssString);
        ArrayList<Contest> contests = parser.parse(rssString);

        ContentValues[] cvArray = new ContentValues[contests.size()];
        for (int i=0;i<contests.size();i++) {
            cvArray[i] = contests.get(i).toContentValues();
        }

        String[] deleteSelectionArgs = new String[1];
        deleteSelectionArgs[0] = "0";
        getContext().getContentResolver().delete(ContestContract.ContestEntry.CONTENT_URI,
                ContestContract.ContestEntry.COLUMN_START_TIME + " >= ?",deleteSelectionArgs);
        getContext().getContentResolver().bulkInsert(ContestContract.ContestEntry.CONTENT_URI,
                cvArray);

        return;
    }

    public static Account getSyncAccount(Context context) {

        AccountManager accountManager =
                (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);

        Account newAccount = new Account(
               context.getString(R.string.app_name), context.getString(R.string.sync_account_type));


        if ( null == accountManager.getPassword(newAccount) ) {
                      if (!accountManager.addAccountExplicitly(newAccount, "", null))
                      {

                             return null;
                      }
            Log.v("i will win","5504");
            onAccountCreated(newAccount,context);
            Log.v("i will win","5505");
        }
        Log.v("i will win","5506");
        return newAccount;
    }

    public static void syncImmediately(Context context) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        ContentResolver.requestSync(getSyncAccount(context),
                context.getString(R.string.content_authority), bundle);
    }

    private static void onAccountCreated(Account newAccount, Context context) {

        SyncAdapter.configurePeriodicSync(context, SYNC_INTERVAL, SYNC_FLEXTIME);

        ContentResolver.setSyncAutomatically(newAccount, context.getString(R.string.content_authority), true);

        syncImmediately(context);
    }

    public static void configurePeriodicSync(Context context, int syncInterval, int flexTime) {
        Account account = getSyncAccount(context);
        String authority = context.getString(R.string.content_authority);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SyncRequest request = new SyncRequest.Builder().
                    syncPeriodic(syncInterval, flexTime).
                    setSyncAdapter(account, authority).
                    setExtras(new Bundle()).build();
            ContentResolver.requestSync(request);
        } else {
            ContentResolver.addPeriodicSync(account,
                    authority, new Bundle(), syncInterval);
        }
    }

    public static void initializeSyncAdapter(Context context) {

        getSyncAccount(context);
    }
}
