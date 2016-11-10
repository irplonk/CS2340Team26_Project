package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Report;

/**
 * Controller for view purity report
 * @author Isabella Plonk
 * @version 1.0
 */
public class ViewPurityReportController {

    private Stage viewPurityReportStage;
    private MainFXApplication mainFXApplication;

    /**references to the widgets in the fxml file */
    @FXML
    private final ListView<Report> list = new ListView<>();

    private final ObservableList<Report> items = FXCollections.observableArrayList();

    /**
     * Initializes the controller class. This method is automatically called
     * after the constructor and
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        items.addAll(WaterPurityReportController.reportList);
        list.setItems(items);
    }

    /**
     * Sets the main application
     * @param mainFXApplication the main application
     */
    public void setMainApp(MainFXApplication mainFXApplication) {this.mainFXApplication = mainFXApplication;}


    /**
     * Sets up view report screen stage
     * @param viewPurityReportStage sets the stage for this dialog
     */
    public void setViewPurityReportsStage(Stage viewPurityReportStage) {this.viewPurityReportStage = viewPurityReportStage;}


    /**
     * Called when user selects cancel
     */
    @FXML
    public void handleCancel() {
        viewPurityReportStage.close();
    }

}
