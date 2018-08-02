package models;

/**
 * Created by dhruvmullick on 09/07/14.
 */
public class ProfListRowItem {

    private final String name;
    private final String room;
    private final String phone;
    private final String email;

    public ProfListRowItem(String name, String email, String con) {
        this.name = name;
        this.room = "";
        this.phone = con;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

