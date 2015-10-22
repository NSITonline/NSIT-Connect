package nsit.app.com.nsitapp;

import java.util.ArrayList;

/**
 * Created by hp1 on 11-09-2015.
 */
public class JudgeGroup {
    String GroupHeader;
    String GroupType;
    ArrayList<String> CodeForces_Properties;

    JudgeGroup(String GroupHeader, String GroupType, ArrayList<String> CodeForces_Properties) {
        this.GroupHeader = GroupHeader;
        this.GroupType = GroupType;
        this.CodeForces_Properties = CodeForces_Properties;
    }
}