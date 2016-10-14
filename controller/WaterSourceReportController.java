package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import model.AuthorizedUser;
import model.Report;
import model.WaterCondition;
import model.WaterSourceReport;
import model.WaterType;

import java.util.ArrayList;

/**
 * Created by Isabella on 10/6/16.
 */
public class WaterSourceReportController {
    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage waterSourceReportStage;

    public static AuthorizedUser user;

    @FXML
    private TextField waterLocation;

    @FXML
    private ComboBox<WaterType> waterType = new ComboBox<>();

    @FXML
    private ComboBox<WaterCondition> waterCondition = new ComboBox<>();

    private Report report;

    private final ObservableList<WaterType> tList = FXCollections.observableArrayList();

    private final ObservableList<WaterCondition> cList = FXCollections.observableArrayList();

    public static ArrayList<Report> reportList = new ArrayList<>();

    /**
     * Called automatically after load
     */
    @FXML
    private void initialize() {
        tList.addAll(WaterType.values());
        cList.addAll(WaterCondition.values());
        waterType.setItems(tList);
        waterCondition.setItems(cList);
    }

    /**
     * Allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Sets up water source report screen stage
     * @param waterSourceReportStage sets the stage for this dialog
     */
    public void setWaterSourceReportStage(Stage waterSourceReportStage) {this.waterSourceReportStage = waterSourceReportStage;};

    /**
     * @param user sets the user
     */
    public void setUser(AuthorizedUser user) {this.user = user;};

    /**
     * Called when user clicks cancel
     */
    @FXML
    public void handleCancel() {
        waterSourceReportStage.close();
    }

    /**
     * Called when user clicks create account
     */
    @FXML
    public void handleSubmitReport() {
        if (isInputValid()) {
            report = new WaterSourceReport(this.user.getID(), waterLocation.getText(), waterType.getValue(), waterCondition.getValue());
            reportList.add(report);
        }
        waterSourceReportStage.close();
    }

    /**
     * Checks if the input is valid
     * @return returns true if input in both fields is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        // Checks to see if the user typed something in all of the fields
        if (waterLocation.getText() == null || waterLocation.getText().length() == 0) {
            errorMessage += "Not a valid location!\n";
        }

        // No error message means good input
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(waterSourceReportStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
