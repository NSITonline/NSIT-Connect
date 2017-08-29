package nsit.app.com.nsitapp;

/**
 * Created by Kartik Kwatra on 24-08-2017.
 */

public class AboutUsMember {
    private String mName;
    private String mBatch;
    private String mGitID;
    private String mFbID;
    private String mLinkedID;
    private String mRole1;
    private String mRole2;
    private int mImageResID;

    public AboutUsMember(String name, String batch, int imageResID, String role, String fbID) {
        mName = name;
        mBatch = batch;
        mImageResID = imageResID;
        mRole1 = role;
        mFbID = fbID;
    }

    public void setGitID(String mGitID) {
        this.mGitID = mGitID;
    }

    public void setLinkedID(String mLinkedID) {
        this.mLinkedID = mLinkedID;
    }

    public void setRole2(String mRole2) {
        this.mRole2 = mRole2;
    }

    public String getName() {
        return mName;
    }

    public int getImageResID() {
        return mImageResID;
    }

    public String getBatch() {
        return mBatch;
    }

    public String getFbID() {
        return mFbID;
    }

    public String getGitID() {
        return mGitID;
    }

    public String getLinkedID() {
        return mLinkedID;
    }

    public String getRole1() {
        return mRole1;
    }

    public String getRole2() {
        return mRole2;
    }
}
