package nsit.app.com.nsitapp.view;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import nsit.app.com.nsitapp.model.OnlineJudge;
import nsit.app.com.nsitapp.utility.TimeUtil;

import nsit.app.com.nsitapp.R;



/**
 * Created by saisumit on 5/22/15.
 */
public class ContestAdapter extends CursorAdapter {

    public ContestAdapter(Context context,Cursor cursor,int flags) {
        super(context,cursor,flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.contest_list_item,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();

        String source = cursor.getString(ContestListFragment.COL_CONTEST_SOURCE);
        viewHolder.mSourceText.setText(source);

        String title = cursor.getString(ContestListFragment.COL_CONTEST_TITLE);
        viewHolder.mTitleText.setText(title);

        viewHolder.mOJImage.setImageResource(OnlineJudge.getIcon(source));

        Long startTime = cursor.getLong(ContestListFragment.COL_CONTEST_START_TIME);
        Long timeLeft = startTime - System.currentTimeMillis();
        viewHolder.mTimeText.setText(TimeUtil.getShortReadableDurationFromMillis(timeLeft));

        int themeColorResId = OnlineJudge.getColor(source);
        int themeColor = context.getResources().getColor(themeColorResId);

        viewHolder.mItemContainer.setBackgroundColor(themeColor);

    }

    public static class ViewHolder {
        public ImageView mOJImage;
        public TextView mTitleText;
        public TextView mSourceText;
        public TextView mTimeText;
        public FrameLayout mItemContainer;

        public ViewHolder(View view) {
            mOJImage = (ImageView) view.findViewById(R.id.onlineJudge_image);
            mTitleText = (TextView) view.findViewById(R.id.contestName_textView);
            mSourceText = (TextView) view.findViewById(R.id.onlineJudge_textView);
            mTimeText = (TextView) view.findViewById(R.id.timeBeforeContest_textView);
            mItemContainer = (FrameLayout) view.findViewById(R.id.contest_item_container);
        }
    }




}
