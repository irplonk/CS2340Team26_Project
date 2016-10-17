package model;

/**
 * Created by Isabella on 10/6/16.
 */
public class WaterPurityReport extends Report {
    private OverallWaterCondition overallWaterCondition;
    private double virusPPM;
    private double contaminantPPM;

    /**
     * Constructor for WaterPurityReport
     * @param reporter String representation of WaterPurityReport reporter
     * @param location String representation of WaterPurityReport location
     * @param overallWaterCondition OverallWaterCondition enum of WaterPurityReport water condition
     * @param virusPPM double representation of WaterPurityReport virus level in PPM
     * @param contaminantPPM double representation of WaterPurityReport contaminant level in PPM
     */
    public WaterPurityReport(String reporter, String location, OverallWaterCondition overallWaterCondition,
        double virusPPM, double contaminantPPM) {
        super(reporter, location);
        this.overallWaterCondition = overallWaterCondition;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
    }

    /**
     * Getter method for overall water condition
     * @return overall water condition
     */
    public OverallWaterCondition getOverallWaterCondition() {
        return overallWaterCondition;
    }

    /**
     * Getter method for virus level
     * @return virus level in PPM
     */
    public double getVirusPPM() {
        return virusPPM;
    }

    /**
     * Getter method for contaminant level
     * @return contaminant level in PPM
     */
    public double getContaminantPPM() {
        return contaminantPPM;
    }

    /**
     * @Override
     * @return a String representation of all WaterPurityReport values
     */
    public String toString() {
        return super.toString()
                + "  " + overallWaterCondition.getName()
                + "  " + virusPPM + "  " + contaminantPPM;
    }

}
