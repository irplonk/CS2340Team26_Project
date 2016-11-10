package model;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Isabella Plonk
 * @version 1.0
 */
public abstract class Report {
    private final DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    private final Date dateObj = new Date();
    private final String date = df.format(dateObj);
    private final String reportNumber;
    private static int reportNum = -1;
    private final String reporter;
    private final String location;
    private final double latitude;
    private final double longitude;

    /**
     * Sets reporter name, location, and report number of Report
     * Increments report number by one
     *
     * @param reporter String representation of Report reporter
     * @param location String representation of Report location
     */
    Report(String reporter, String location, double latitude, double longitude) {
        this.reporter = reporter;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        reportNum++;
        this.reportNumber = Integer.toString(reportNum);
    }

    String getDate() {
        return date;
    }

    String getReportNumber() {
        return reportNumber;
    }

    String getReporter() {
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
