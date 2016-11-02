package model;

/**
 * Created by Shivani Upadhayay on 11/1/2016.
 */
public class HistoryReport extends Report {

    private double PPM;
    private int year;

    public HistoryReport(String reporter, String location, double latitude, double longitude,
                         double PPM, int year) {
        super(reporter, location, latitude, longitude);
        this.PPM = PPM;
    }

}
