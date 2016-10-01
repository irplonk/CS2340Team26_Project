package controller;

import fxapp.MainFXApplication;

import javafx.fxml.FXML;

import javafx.scene.control.Alert;

/**
 * The controller for the root/main window
 *
 */
public class MainScreenController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Close menu item event handler
     */
    @FXML
    private void handleCloseMenu() {
        System.exit(0);

    }

    /**
     * About menu item event handler
     */
    @FXML
    private void handleAboutMenu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("M4 Main Screen");
        alert.setHeaderText("About");
        alert.setContentText("Login & Registration buttons");

        alert.showAndWait();

    }


    /**
     * Button handler for login button
     */
    @FXML
    public void loginPressed() {
        mainApplication.showLoginScreen();

    }

    /**
     * Button handler for login button
     */
    @FXML
    public void createAccountPressed() {
        mainApplication.showRegistrationScreen();
    }


    /**
     * Button handler for registration
     * Currently not implemented
     */
    @FXML
    public void registerPressed() {
        // Show the error message if bad data
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initOwner(mainApplication.getMainScreen());
        alert.setTitle("Unimplemented");
        alert.setHeaderText("Unimplemented Feature");
        alert.setContentText("Sorry, Register is not yet implemented!");

        alert.showAndWait();

    }
}
