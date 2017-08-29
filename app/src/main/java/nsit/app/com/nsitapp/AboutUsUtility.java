package nsit.app.com.nsitapp;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static nsit.app.com.nsitapp.MainActivity.appContext;

/**
 * Created by Kartik Kwatra on 26-08-2017.
 */

class AboutUsUtility {

    private static final String LOG_TAG = AboutUsUtility.class.getName();

    public static List<AboutUsMember> driver() {
        String jsonResult = fetchJsonString();
        List<AboutUsMember> teamList = fetchMemberList(jsonResult);
        return teamList;
    }

    private static String fetchJsonString() {
        StringBuilder output = new StringBuilder();
        final Resources resources = appContext.getResources();
        InputStream inputStream = resources.openRawResource(R.raw.teammembers);
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String line = bufferedReader.readLine();
                while (line != null) {
                    output.append(line);
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                Log.e(LOG_TAG, "Problem in reading from text file");
            }
        }
        return output.toString();
    }

    private static List<AboutUsMember> fetchMemberList(String jsonResult) {
        if (TextUtils.isEmpty(jsonResult)) {
            return null;
        }
        List<AboutUsMember> team = new ArrayList<>();
        try {
            JSONObject baseJson = new JSONObject(jsonResult);
            JSONArray teamMembers = baseJson.getJSONArray("TeamMembers");
            for (int i = 0; i < teamMembers.length(); i++) {
                JSONObject member = teamMembers.getJSONObject(i);
                String name = member.getString("name");
                String batch = member.getString("batch");
                String fbID = member.getString("fbID");
                String role1 = member.getString("role1");
                String image = member.getString("imageResId");
                int imageResID = getResourceID(image, R.drawable.class);
                AboutUsMember member1 = new AboutUsMember(name, batch, imageResID, role1, fbID);
                String gitID = member.getString("gitID");
                String linkedID = member.getString("linkedID");
                String role2 = member.getString("role2");
                if (gitID != null&&!gitID.isEmpty()) {
                    member1.setGitID(gitID);
                }
                if (role2 != null&&!role2.isEmpty()) {
                    member1.setRole2(role2);
                }
                if (linkedID != null&&!linkedID.isEmpty()) {
                    member1.setLinkedID(linkedID);
                }
                team.add(member1);
                Log.e(LOG_TAG,member1.getName()+member1.getRole2()+member1.getGitID());
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error in fetching json results", e);
        }
        return team;
    }

    public static int getResourceID(String imageId, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(imageId);
            return idField.getInt(idField);
        } catch (IllegalAccessException e) {
            Log.e(LOG_TAG, "Illegal access exception");
        } catch (NoSuchFieldException e) {
            Log.e(LOG_TAG, "No such file found");
        }

        return -1;
    }

}
