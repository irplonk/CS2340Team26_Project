package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import model.*;

/**
 * Created by Isabella on 10/8/16.
 */
public class WaterPurityReportController {
    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage waterPurityReportStage;

    private Report report;

    public static AuthorizedUser user;

    @FXML
    private TextField waterLocation;

    @FXML
    private TextField virusPPM;

    @FXML
    private TextField contaminantPPM;

    @FXML
    private ComboBox<OverallWaterCondition> overallWaterCondition = new ComboBox<>();

    private final ObservableList<OverallWaterCondition> list = FXCollections.observableArrayList();

    /**
     * Called automatically after load
     */
    @FXML
    private void initialize() {
        list.addAll(OverallWaterCondition.values());
        overallWaterCondition.setItems(list);
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
     * @param waterPurityReportStage sets the stage for this dialog
     */
    public void setWaterPurityReportStage(Stage waterPurityReportStage) {this.waterPurityReportStage = waterPurityReportStage;};

    /**
     * Called when user clicks cancel
     */
    @FXML
    public void handleCancel() {
        waterPurityReportStage.close();
    }

    /**
     * Called when user clicks create account
     */
    @FXML
    public void handleSubmitReport() {
        if (isInputValid()) {
            double virus = Double.parseDouble(virusPPM.getText());
            double contaminant = Double.parseDouble(contaminantPPM.getText());
            report = new WaterPurityReport(this.user.getID(), waterLocation.getText(), overallWaterCondition.getValue(), virus, contaminant);
            WaterSourceReportController.reportList.add(report);
        }
        waterPurityReportStage.close();
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
        if (virusPPM.getText() == null || virusPPM.getText().length() == 0) {
            errorMessage += "Not a valid virus level\n";
        }
        if (contaminantPPM.getText() == null || contaminantPPM.getText().length() == 0) {
            errorMessage += "Not a valid contaminant level!\n";
        }

        // No error message means good input
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(waterPurityReportStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
