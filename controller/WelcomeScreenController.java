package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;


/**
 * The controller for the welcome screen
 * Created by Isabella on 9/23/16
 * @version 1.0
 */
public class WelcomeScreenController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage welcomeStage;

    @FXML
    private Button logout;

    @FXML
    private Button editProfile;

    /**
     * allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Sets up welcome screen stage
     * @param welcomeStage sets the strage for this dialog
     */
    public void setWelcomeStage(Stage welcomeStage) {this.welcomeStage = welcomeStage;};

    /**
     * Called when user clicks logout
     */
    @FXML
    private void handleLogout() {
        welcomeStage.close();
    }

    /**
     * Called when user clicks edit profile
     */
    @FXML
    private void handleEditProfile() {
        mainApplication.showProfileScreen();
    }
}
