package model;

/**
 * Created by Isabella on 10/6/16.
 */
public class WaterPurityReport extends Report {
    private OverallWaterCondition overallWaterCondition;
    private double virusPPM;
    private double contaminantPPM;

    public WaterPurityReport(String reporter, String location, OverallWaterCondition overallWaterCondition,
        double virusPPM, double contaminantPPM) {
        super(reporter, location);
        this.overallWaterCondition = overallWaterCondition;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
    }

    public OverallWaterCondition getOverallWaterCondition() {
        return overallWaterCondition;
    }

    public double getVirusPPM() {
        return virusPPM;
    }

    public double getContaminantPPM() {
        return contaminantPPM;
    }

}
