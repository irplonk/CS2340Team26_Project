package controller;

import fxapp.MainFXApplication;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.AuthorizedUser;
import model.HistoryReport;
import model.Report;
import model.WaterPurityReport;

import java.util.ArrayList;

/**
 * Created by Shivani Upadhayay on 11/1/2016.
 */
public class ViewHistoricalReportController {

    /** a link back to the main application class */
    private MainFXApplication mainApplication;

    private Stage viewHistoryReportStage;

    /**references to the widgets in the fxml file */
    @FXML
    private ListView<Report> list = new ListView<>();

    private ArrayList<WaterPurityReport> waterPurityReportList;

    XYChart.Series<String, Double> virusPPM = new XYChart.Series<String, Double>();
    XYChart.Series<String, Double> contaminantPPM = new XYChart.Series<String, Double>();

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
     * Allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Sets up view report screen stage
     * @param viewHistoryReportStage sets the strage for this dialog
     */
    public void setViewHistoryReportsStage(Stage viewHistoryReportStage) {
        this.viewHistoryReportStage = viewHistoryReportStage;
    };


    /**
     * Called when user selects cancel
     */
    @FXML
    public void handleCancel() {
        viewHistoryReportStage.close();
    }

}
