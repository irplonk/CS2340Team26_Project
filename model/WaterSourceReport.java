package model;

/**
 * Created by Isabella on 10/6/16.
 */
public class WaterSourceReport extends Report {
    private WaterType waterType;
    private WaterCondition waterCondition;

    public WaterSourceReport(String reporter, String location, double latitude, double longitude, WaterType waterType, WaterCondition waterCondition) {
        super(reporter, location, latitude, longitude);
        this.waterType = waterType;
        this.waterCondition = waterCondition;
    }

    public WaterCondition getWaterCondition() {
        return waterCondition;
    }

    public WaterType getWaterType() {
        return waterType;
    }

    public String toString() {
        return super.toString()
                + "  " + waterType.getType()
                + "  " + waterCondition.getCondition();
    }

    public String getDescription() {
        return  "Marker " + getLocation() + "  Date Submitted: " + getDate()
                + "  " + "<h2>Report Number: "  + getReportNumber()
                + "</h2> <br> Source Report for " + getLocation()
                + "<br> Reporter: " + getReporter()
                + "<br> Location"
                + "<br> Latitude: " + getLatitude()
                + "  " + "Longitude: " + getLongitude()
                + "<br> Water Type: " + getWaterType()
                + "<br> Water Condition" + getWaterCondition();
    }
}
