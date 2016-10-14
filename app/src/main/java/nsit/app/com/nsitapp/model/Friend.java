package nsit.app.com.nsitapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AGGARWAL'S on 8/25/2016.
 */
public class Friend {
    private int avatar;
    private String nickname;
    private int background;
    private String linkedin;
    private String facebook;
    private String github;
    private List<String> interests = new ArrayList<>();

    public Friend(int avatar, String nickname,String linkedin,String facebook,String github, int background, String... interest) {
        this.avatar = avatar;
        this.nickname = nickname;
        this.background = background;
        this.linkedin = linkedin;
        this.facebook = facebook;
        this.github = facebook;
        interests.addAll(Arrays.asList(interest));
    }

    public int getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getGithub() {
        return github;
    }

    public int getBackground() {
        return background;
    }

    public List<String> getInterests() {
        return interests;
    }
}
