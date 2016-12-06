package src.main.java.model;

/**
 * Created by Shivani Upadhayay on 11/1/2016.
 */
public class HistoryReport extends Report {

    private double PPM;
    private int year;
    private String location;
    private double latitude;
    private double longitude;
    private String ppmType;
    private String month;

    public HistoryReport(String reporter, String location, double latitude, double longitude,
                         double PPM, String ppmType, String month, int year) {
        super(reporter, location, latitude, longitude);
        this.PPM = PPM;
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public double getLatitude() {
        return this.latitude;
    }

    @Override
    public double getLongitude() {
        return this.longitude;
    }

    public double getPPM() {
        return this.PPM;
    }

    public int getYear() {
        return this.year;
    }

    public String getPpmType() {
        return this.ppmType;
    }

    public String getMonth() {
        return this.month;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPPM(double ppm) {
        this.PPM = ppm;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPpmType(String ppmType) {
        this.ppmType = ppmType;
    }

    public void setMonth(String month) {
        this.month = month;
    }

}