package model;

/**
 * Created by Isabella on 10/6/16.
 */
public class WaterPurityReport extends Report {
    private OverallWaterCondition overallWaterCondition;
    private double virusPPM;
    private double contaminantPPM;

    public WaterPurityReport(String reporter, String location, double latitude, double longitude, OverallWaterCondition overallWaterCondition,
        double virusPPM, double contaminantPPM) {
        super(reporter, location, latitude, longitude);
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

    public String toString() {
        return super.toString()
                + "  " + overallWaterCondition.getName()
                + "  " + virusPPM + "  " + contaminantPPM;
    }

}
