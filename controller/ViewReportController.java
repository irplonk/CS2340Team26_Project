package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.WaterSourceReport;
import model.Report;

/**
 * Created by Isabella on 10/9/16.
 */
public class ViewReportController {

    /** a link back to the main application class */
    private MainFXApplication mainApplication;

    private Stage viewReportStage;

    /* references to the widgets in the fxml file */
    //@FXML
    //private ListView<String> list = new ListView<>();

    //private ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private ListView<Report> list;

    private ObservableList<Report> items = FXCollections.observableArrayList();

    /**
     * Initializes the controller class. This method is automatically called
     * after the constructor and
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        /*for (Report r : WaterSourceReportController.reportList) {
            String str = r.getDate() + "  " + r.getReportNumber()
                    + "  " + r.getReporter() + "  " + r.getLocation()
                    + "  " + ((WaterSourceReport)r).getWaterCondition().getCondition()
                    + "  " + ((WaterSourceReport)r).getWaterType().getType() ;
            items.add(str);
        }
        list.setItems(items);*/
        try {
            items.addAll(WaterSourceReportController.reportList);
            list.setItems(items);
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(viewReportStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("No reports to view");
            alert.setContentText("No reports have been submitted at this time.");

            alert.showAndWait();
        }
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
     * @param viewReportStage sets the strage for this dialog
     */
    public void setViewReportsStage(Stage viewReportStage) {this.viewReportStage = viewReportStage;};


    /**
     * Called when user selects cancel
     */
    @FXML
    public void handleCancel() {
        viewReportStage.close();
    }

}
