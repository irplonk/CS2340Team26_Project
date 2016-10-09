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
    private String reporter;
    private String location;

    public Report(String reporter, String location) {
        this.reporter = reporter;
        this.location = location;
        reportNumber = "000000";
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
}
