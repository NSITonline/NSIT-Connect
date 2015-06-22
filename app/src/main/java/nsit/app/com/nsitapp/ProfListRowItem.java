package nsit.app.com.nsitapp;

/**
 * Created by dhruvmullick on 09/07/14.
 */
public class ProfListRowItem {

        private String name;
        private String room;
        private String phone;
        private String email;

        public ProfListRowItem(String name, String email) {
            this.name = name;
            this.room = "";
            this.phone = "";
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

