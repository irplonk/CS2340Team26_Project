package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.*;

/**
 * The controller for the registration screen
 * Created by Shivani on 10/2/16
 * @version 1.0
 */
public class ProfilePageController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage registrationStage;

    @FXML
    private Button SubmitReport;

    @FXML
    private Button viewWaterSources;


    @FXML
    private ComboBox<UserType> userType = new ComboBox<>();

    private final ObservableList<UserType> list = FXCollections.observableArrayList();

    private AuthorizedUser user;

    /**
     * called automatically after load
     */
    @FXML
    private void initialize() {
        list.addAll(UserType.values());
        userType.setItems(list);
    }


    /**
     * allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Sets up welcome screen stage
     * @param registrationStage sets the strage for this dialog
     */
    public void setRegistrationStage(Stage registrationStage) {this.registrationStage = registrationStage;};


    /**
     * Called when user clicks submit report
     */
    @FXML
    public void handleSubmitReport() {

    }

    /**
     * Called when user clicks view water sources
     */
    @FXML
    public void handleViewWaterSources() {

    }

    public void setUser(AuthorizedUser user) {
        this.user = user;
    }
}
