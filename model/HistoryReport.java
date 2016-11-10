package model;

/**
 * @author Shivani Upadhayay
 * @version 1.0
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

    /**
     * Method to get location
     * @return string location
     */
    @Override
    public String getLocation() {
        return this.location;
    }

    /**
     * Method to get latitude
     * @return double latitude
     */
    @Override
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Method to get longitude
     * @return double longitude
     */
    @Override
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Method to get ppm value
     * @return ppm
     */
    public double getPPM() {
        return this.PPM;
    }

    /**
     * Method to get year
     * @return int year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Method to get ppm value
     * @return ppm
     */
    public String getPpmType() {
        return this.ppmType;
    }

    /**
     * Method to get month
     * @return String month
     */
    public String getMonth() {
        return this.month;
    }

    /**
     * Method to set location
     * @param location the location to be inputted
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Method to set latitude
     * @param latitude the latitude to be inputted
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Method to set longitude
     * @param longitude the longitude to be inputted
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Method to set ppm
     * @param ppm the ppm to be inputted
     */
    public void setPPM(double ppm) {
        this.PPM = ppm;
    }

    /**
     * Method to set year
     * @param year the year to be inputted
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Method to set ppm type
     * @param ppmType the ppmType to be inputted
     */
    public void setPpmType(String ppmType) {
        this.ppmType = ppmType;
    }

    /**
     * Method to set month
     * @param month the month to be inputted
     */
    public void setMonth(String month) {
        this.month = month;
    }

}
