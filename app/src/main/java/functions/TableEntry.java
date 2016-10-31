package functions;

import android.provider.BaseColumns;

/**
 * Created by Swati garg on 30-06-2015.
 * Inner class that defines the table contents
 */

public abstract class TableEntry implements BaseColumns {
    public static final String TABLE_NAME = "subjects";
    public static final String COLUMN_NAME_SUBJECT = "subjectid";
    public static final String COLUMN_NAME_DATE = "date";
    public static final String COLUMN_NAME_STATUS = "status";
    public static final String COLUMN_NAME_NUMBER = "number";
    public static final String COLUMN_NAME_ATTENDANCE = "attendance";
}

