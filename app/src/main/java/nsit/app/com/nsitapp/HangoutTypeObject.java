package nsit.app.com.nsitapp;

/**
 * Created by AGGARWAL'S on 10/21/2015.
 */
public class HangoutTypeObject {

    boolean opennow;
    float photowidth;
    float photoheight;
    float rating;

    String name;
    String icon;
    String place_id;
    String phtotref;
    String longi;
    String latti;
    String vicinity;


    HangoutTypeObject(String name,
                        String icon,
                        String place_id,
                        String phtotref,
                        String longi,
                        String latti,
                        String vicinity,
                        boolean opennow,
                        float photowidth,
                        float photoheight,
                        float rating){
        this.name = name;
        this.icon = icon;
        this.place_id = place_id;
        this.phtotref = phtotref;
        this.longi = longi;
        this.latti = latti;
        this.vicinity = vicinity;
        this.opennow = opennow;
        this.photowidth = photowidth;
        this.photoheight = photoheight;
        this.rating = rating;
    }

    public String getName() { return  this.name;}

    public String getVicinity() { return this.vicinity;}

    public String getIcon() { return  this.icon;}

    public String getopennow() {
        String  temp;
        if (!opennow)
            temp  = "false";
        else
            temp = "true";
        return temp;
    }

    public boolean getopennowv() {return  this.opennow;}

    public String getPlace_id()  { return  this.place_id;}

    public String getPhtotref() { return  this.phtotref;}

    public String getLongi() { return  this.longi;}

    public String getLatti() { return  this.latti;}

    public float getPhotowidth()  {return  this.photowidth;}

    public float getPhotoheight() {return this.photoheight;}

    public float getRating() {return  this.rating ;}

    public void setOpennow(boolean opennow) {this.opennow = opennow;}

    public void setVicinity(String vicinity) {this.vicinity = vicinity;}

    public void  setPhotowidth(float photowidth) {this.photowidth = photowidth;}

    public void setPhotoheight(float photoheight) {this.photoheight = photoheight;}

    public void setRating(float rating ) {this.rating = rating; }

    public void setName(String name) {this.name = name;}

    public void  setIcon(String icon) {this.icon = icon;}

    public void  setPlace_id (String  place_id) {this.place_id = place_id;}

    public void setPhtotref(String phtotref){this.phtotref = phtotref;}

    public void setLongi(String longi) {this.longi = longi;}

    public void setLatti(String latti) {this.latti = latti;}

}
