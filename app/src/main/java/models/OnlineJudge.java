package models;

import nsit.app.com.nsitapp.R;

/**
 * Created by saisumit on 5/15/15.
 */
public class OnlineJudge {

    public static final int OJ_NUMBER = 7;

    public static final int CODEFORCES_ID = 0;
    public static final int HACKERRANK_ID = 1;
    public static final int TOPCODER_ID = 2;
    public static final int HACKEREARTH_ID = 3;
    public static final int CODECHEF_ID = 4;
    public static final int URIOJ_ID = 5;
    public static final int  UNKNOWN_ID = 6;



    public static final String CODEFORCES = "Codeforces";
    public static final String TOPCODER = "Topcoder";
    public static final String CODECHEF = "Codechef";
    public static final String HACKERRANK = "Hackerrank";
    public static final String URIOJ = "URIOJ";
    public static final String HACKEREARTH = "Hackerearth";
    public static final String UNKNOWN = "Unknown";

    public static final String[] OJ_NAME = {
            CODEFORCES,
            HACKERRANK,
            TOPCODER,
            HACKEREARTH,
            CODECHEF,
            URIOJ,
            UNKNOWN
    };

    public static int getIcon(String source) {
        switch (source) {
            case CODEFORCES:
                return R.drawable.codeforces_logo;
            case TOPCODER:
                return R.drawable.topcoder_logo;
            case CODECHEF:
                return R.drawable.codechef_logo;
            case HACKERRANK:
                return R.drawable.hackerrank_logo;
            case URIOJ:
                return R.drawable.uri_logo;
            case HACKEREARTH:
                return R.drawable.hackerearth_logo;
            default:
                return R.drawable.unknown_logo;
        }
    }

    public static int getCover(String source) {
        switch (source) {
            case CODEFORCES:
                return R.drawable.hackerrank_cover;
            case TOPCODER:
                return R.drawable.topcoder_cover;
            case CODECHEF:
                return R.drawable.codechef_cover;
            case HACKERRANK:
                return R.drawable.hackerrank_cover;
            case URIOJ:
                return R.drawable.hackerrank_cover;
            case HACKEREARTH:
                return R.drawable.hackerearth_cover;
            default:
                return R.drawable.hackerrank_cover;
        }
    }

    public static int getColor(String source) {
        switch (source) {
            case CODEFORCES:
                return R.color.codeforces;
            case TOPCODER:
                return R.color.topcoder;
            case CODECHEF:
                return R.color.codechef;
            case HACKERRANK:
                return R.color.hackerrank;
            case URIOJ:
                return R.color.urioj;
            case HACKEREARTH:
                return R.color.hackerearth;
            default:
                return R.color.hackerrank;
        }
    }

    private final String mName;
    private final int mIcon;
    private final int mCover;
    private String mDescription;

    public OnlineJudge(String name,int icon,int cover) {
        mName = name;
        mIcon = icon;
        mCover = cover;
    }

    public String getName() {
        return mName;
    }

    public int getIconResource() {
        return mIcon;
    }

    public int getCoverResource() {
        return mCover;
    }

}
