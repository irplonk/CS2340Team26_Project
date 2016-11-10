package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Report;

/**
 * Controller for view report
 * @author Isabella Plonk
 * @version 1.0
 */
public class ViewReportController {

    private Stage viewReportStage;

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
        items.addAll(WaterSourceReportController.reportList);
        list.setItems(items);
    }

    /**
     * Sets up view report screen stage
     * @param viewReportStage sets the stage for this dialog
     */
    public void setViewReportsStage(Stage viewReportStage) {this.viewReportStage = viewReportStage;}


    /**
     * Called when user selects cancel
     */
    @FXML
    public void handleCancel() {
        viewReportStage.close();
    }

}
