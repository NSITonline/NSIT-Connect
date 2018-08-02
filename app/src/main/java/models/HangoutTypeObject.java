package models;

/**
 * Created by AGGARWAL'S on 10/21/2015.
 */
public class HangoutTypeObject {

    private boolean opennow;
    private float photowidth;
    private float photoheight;
    private float rating;

    private String name;
    private String icon;
    private String id;
    public String phtotref;
    private String longitude;
    private String latitude;
    private String vicinity;


    /**
     * Instantiates Hangout type object
     *
     * @param name - name of the place
     * @param icon - icon of place
     * @param id - place id
     * @param phtotref - photo link of place
     * @param longi - place longitude
     * @param latti - place latitude
     * @param vicinity - address of place
     * @param opennow - bool, true if place is open currently
     * @param photowidth - photo width
     * @param photoheight - photo height
     * @param rating - rating of place
     */
    public HangoutTypeObject(String name,
                             String icon,
                             String id,
                             String phtotref,
                             String longi,
                             String latti,
                             String vicinity,
                             boolean opennow,
                             float photowidth,
                             float photoheight,
                             float rating) {
        this.name = name;
        this.icon = icon;
        this.id = id;
        this.phtotref = phtotref;
        this.longitude = longi;
        this.latitude = latti;
        this.vicinity = vicinity;
        this.opennow = opennow;
        this.photowidth = photowidth;
        this.photoheight = photoheight;
        this.rating = rating;
    }

    public String getName() {
        return this.name;
    }

    public String getVicinity() {
        return this.vicinity;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getopennow() {
        String temp;
        if (!opennow)
            temp = "false";
        else
            temp = "true";
        return temp;
    }

    public boolean getopennowv() {
        return this.opennow;
    }

    public String getId() {
        return this.id;
    }

    public String getPhtotref() {
        return this.phtotref;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public float getPhotowidth() {
        return this.photowidth;
    }

    public float getPhotoheight() {
        return this.photoheight;
    }

    public float getRating() {
        return this.rating;
    }

    public void setOpennow(boolean opennow) {
        this.opennow = opennow;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public void setPhotowidth(float photowidth) {
        this.photowidth = photowidth;
    }

    public void setPhotoheight(float photoheight) {
        this.photoheight = photoheight;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhtotref(String phtotref) {
        this.phtotref = phtotref;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

}
