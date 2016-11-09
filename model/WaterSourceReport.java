package model;

/**
 * Created by Isabella on 10/6/16.
 */
public class WaterSourceReport extends Report {
    private WaterType waterType;
    private WaterCondition waterCondition;

    /**
     * Constructor for WaterSourceReport
     * @param reporter String representation of WaterSourceReport reporter
     * @param location String representation of WaterSourceReport location
     * @param waterType WaterType enum representation of WaterSourceReport water type
     * @param waterCondition WaterType enum representation of WaterSourceReport water condition
     */
    public WaterSourceReport(String reporter, String location, double latitude, double longitude, WaterType waterType, WaterCondition waterCondition) {
        super(reporter, location, latitude, longitude);
        this.waterType = waterType;
        this.waterCondition = waterCondition;
    }

    /**
     * Getter for water condition
     * @return water condition for WaterSourceReport
     */
    public WaterCondition getWaterCondition() {
        return waterCondition;
    }

    /**
     * Getter for water type
     * @return water condition for WaterSourceReport
     */
    public WaterType getWaterType() {
        return waterType;
    }

    /**
     * @Override
     * @return a String representation of all WaterSourceReport values
     */
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
                + "<br> Water Condition: " + getWaterCondition();
    }
}
