package controller;

import fxapp.MainFXApplication;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Report;
import model.WaterPurityReport;

import java.util.ArrayList;

/**
 * @author Shivani Upadhayay
 * @version 1.0
 */
class ViewHistoricalReportController {

    private Stage viewHistoryReportStage;

    /**references to the widgets in the fxml file */
    @FXML
    private ListView<Report> list = new ListView<>();

    private ArrayList<WaterPurityReport> waterPurityReportList;

    XYChart.Series<String, Double> virusPPM = new XYChart.Series<>();
    XYChart.Series<String, Double> contaminantPPM = new XYChart.Series<>();

    /**
     * Setter method to add the month categories to line graph
     * @param value the String objects to be added to categories
     */
    public final void setCategories(ObservableList<String> value) {
        value.add("Jan");
        value.add("Feb");
        value.add("Mar");
        value.add("Apr");
        value.add("May");
        value.add("June");
        value.add("July");
        value.add("Aug");
        value.add("Sept");
        value.add("Oct");
        value.add("Nov");
        value.add("Dec");
    }

    /**
     * Sets up view report screen stage
     * @param viewHistoryReportStage sets the stage for this dialog
     */
    public void setViewHistoryReportsStage(Stage viewHistoryReportStage) {
        this.viewHistoryReportStage = viewHistoryReportStage;
    }


    /**
     * Called when user selects cancel
     */
    @FXML
    public void handleCancel() {
        viewHistoryReportStage.close();
    }

}
