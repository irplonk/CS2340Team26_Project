package model;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Isabella on 10/6/16.
 */
public abstract class Report {
    private DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    private Date dateObj = new Date();
    private String date = df.format(dateObj);
    private String reportNumber;
    private static int reportNum = -1;
    private String reporter;
    private String location;
    private double latitude;
    private double longitude;

    /**
     * Sets reporter name, location, and report number of Report
     * Increments report number by one
     *
     * @param reporter String representation of Report reporter
     * @param location String representation of Report location
     */
    public Report(String reporter, String location, double latitude, double longitude) {
        this.reporter = reporter;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        reportNum++;
        this.reportNumber = Integer.toString(reportNum);
    }

    public String getDate() {
        return date;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public String getReporter() {
        return reporter;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String toString() {
        return getDate() + "  " + getReportNumber()
                + "  " + getReporter()
                + "  " + getLocation()
                + "  " + getLatitude()
                + "  " + getLongitude();
    }

    public String getDescription() {
        return  "Marker " + getLocation() + "  Date Submitted: " + getDate()
                + "  " + "<h2>Report Number: "  + getReportNumber()
                + "</h2> <br> Source Report for " + getLocation()
                + "<br> Reporter: " + getReporter()
                + "<br> Location"
                + "<br> Latitude: " + getLatitude()
                + "  " + "Longitude: " + getLongitude();
    }
}
