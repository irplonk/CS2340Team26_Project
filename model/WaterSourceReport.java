package model;

/**
 * @author Isabella Plonk
 * @version 1.0
 */
public class WaterSourceReport extends Report {
    private final WaterType waterType;
    private final WaterCondition waterCondition;

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
    private WaterCondition getWaterCondition() {
        return waterCondition;
    }

    /**
     * Getter for water type
     * @return water condition for WaterSourceReport
     */
    private WaterType getWaterType() {
        return waterType;
    }

    /**
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
