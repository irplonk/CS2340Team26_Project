package model;

/**
 * Created by Isabella on 10/6/16.
 */
public class WaterSourceReport extends Report {
    private WaterType waterType;
    private WaterCondition waterCondition;

    public WaterSourceReport(String reporter, String location, WaterType waterType, WaterCondition waterCondition) {
        super(reporter, location);
        this.waterType = waterType;
        this.waterCondition = waterCondition;
    }

    public WaterCondition getWaterCondition() {
        return waterCondition;
    }

    public WaterType getWaterType() {
        return waterType;
    }
}
