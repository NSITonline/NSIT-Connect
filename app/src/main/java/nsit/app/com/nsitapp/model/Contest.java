package nsit.app.com.nsitapp.model;

import android.content.ContentValues;

import nsit.app.com.nsitapp.data.ContestContract;

/**
 * Created by saisumit on 5/23/15.
 */
public class Contest {
    private String mTitle;
    private String mDescription;
    private String mSource;
    private Long mStartDate;
    private Long mFinishDate;

    public String getURL() {
        return mURL;
    }

    public Contest URL(String URL) {
        mURL = URL;
        return this;
    }

    private String mURL;

    public String getTitle() {
        return mTitle;
    }

    public Contest title(String title) {
        mTitle = title;
        return this;
    }

    public String getDescription() {
        return mDescription;
    }

    public Contest description(String description) {
        mDescription = description;
        return this;
    }

    public String getSource() {
        return mSource;
    }

    public Contest source(String source) {
        mSource = source;
        return this;
    }

    public Long getStartDate() {
        return mStartDate;
    }

    public Contest startDate(Long startDate) {
        mStartDate = startDate;
        return this;
    }

    public Long getFinishDate() {
        return mFinishDate;
    }

    public Contest finishDate(Long finishDate) {
        mFinishDate = finishDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Contest) {
            Contest contest = (Contest) o;
            boolean isMatch = true;

            isMatch = mTitle.equals(contest.getTitle());
            isMatch = isMatch && (mDescription.equals(contest.getDescription()));
            isMatch = isMatch && (mSource.equals(contest.getSource()));
            isMatch = isMatch && (mURL.equals(contest.getURL()));
            isMatch = isMatch && (mStartDate.equals(contest.getStartDate()));
            isMatch = isMatch && (mFinishDate.equals(contest.getFinishDate()));

            return isMatch;

        }
        return false;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ContestContract.ContestEntry.COLUMN_TITLE,mTitle);
        contentValues.put(ContestContract.ContestEntry.COLUMN_DESCRIPTION,mDescription);
        contentValues.put(ContestContract.ContestEntry.COLUMN_SOURCE,mSource);
        contentValues.put(ContestContract.ContestEntry.COLUMN_URL,mURL);
        contentValues.put(ContestContract.ContestEntry.COLUMN_START_TIME,mStartDate);
        contentValues.put(ContestContract.ContestEntry.COLUMN_END_TIME,mFinishDate);

        return contentValues;
    }
}
