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

import functions.ContestParser;
import models.Contest;
import nsit.app.com.nsitapp.R;
import nsit.app.com.nsitapp.data.ContestContract;


public class SyncAdapter extends AbstractThreadedSyncAdapter{

    private static final int SYNC_INTERVAL = 3 * 60 * 60;
    private static final int SYNC_FLEXTIME = SYNC_INTERVAL/2;
    public SyncAdapter(Context context) {
        super(context, true);
    }

    @Override
    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        Log.d("DEBUG","onPerformSync");
        StringDownloader downloader = new StringDownloader();
        try {
            downloader.download();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String rssString = downloader.getString();

        ContestParser parser = new ContestParser();
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

    }

    private static Account getSyncAccount(Context context) {

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

    private static void syncImmediately(Context context) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        ContentResolver.requestSync(getSyncAccount(context),
                context.getString(R.string.content_authority), bundle);
    }

    private static void onAccountCreated(Account newAccount, Context context) {

        SyncAdapter.configurePeriodicSync(context);

        ContentResolver.setSyncAutomatically(newAccount, context.getString(R.string.content_authority), true);

        syncImmediately(context);
    }

    private static void configurePeriodicSync(Context context) {
        Account account = getSyncAccount(context);
        String authority = context.getString(R.string.content_authority);
        SyncRequest request = new SyncRequest.Builder().
                syncPeriodic(SyncAdapter.SYNC_INTERVAL, SyncAdapter.SYNC_FLEXTIME).
                setSyncAdapter(account, authority).
                setExtras(new Bundle()).build();
        ContentResolver.requestSync(request);
    }

    public static void initializeSyncAdapter(Context context) {

        getSyncAccount(context);
    }
}
