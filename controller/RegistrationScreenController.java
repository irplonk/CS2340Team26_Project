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
 * Created by Isabella on 10/1/16
 * @version 1.0
 */
public class RegistrationScreenController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage registrationStage;

    @FXML
    private Button cancel;

    @FXML
    private Button createAccount;

    @FXML
    private TextField lastName;

    @FXML
    private TextField firstName;

    @FXML
    private TextField userID;

    @FXML
    private TextField password;

    @FXML
    private ComboBox<UserType> userType = new ComboBox<>();

    private final ObservableList<UserType> list = FXCollections.observableArrayList();

    private AuthorizedUser user;

    /**
     * Called automatically after load
     */
    @FXML
    private void initialize() {
        list.addAll(UserType.values());
        userType.setItems(list);
    }


    /**
     * Allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Sets up registration screen stage
     * @param registrationStage sets the strage for this dialog
     */
    public void setRegistrationStage(Stage registrationStage) {this.registrationStage = registrationStage;};

    /**
     * Called when user clicks cancel
     */
    @FXML
    public void handleCancel() {
        registrationStage.close();
    }

    /**
     * Called when user clicks create account
     */
    @FXML
    public void handleCreateAccount() {
        if (isInputValid()) {
            switch (userType.getValue().getName()) {
                case "user":
                    user = new User(lastName.getText() + ", " + firstName.getText(), userID.getText(), password.getText());
                    break;
                case "worker":
                    user = new Worker(lastName.getText() + ", " + firstName.getText(), userID.getText(), password.getText());
                    break;
                case "manager":
                    user = new Manager(lastName.getText() + ", " + firstName.getText(), userID.getText(), password.getText());
                    break;
                case "administrator":
                    user = new Administrator(lastName.getText() + ", " + firstName.getText(), userID.getText(), password.getText());
                    break;
            }
            registrationStage.close();
        }
    }

    /**
     * Checks if the input is valid
     * @return returns true if input in both fields is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        // Checks to see if the user typed something in all of the fields
        if (userID.getText() == null || userID.getText().length() == 0) {
            errorMessage += "Not a valid username!\n";
        }
        if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "Not a valid password!\n";
        }
        if (lastName.getText() == null || lastName.getText().length() == 0) {
            errorMessage += "Not a valid last name!\n";
        }
        if (firstName.getText() == null || firstName.getText().length() == 0) {
            errorMessage += "Not a valid first name!\n";
        }

        // No error message means good input
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(registrationStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    public void setUser(AuthorizedUser user) {
        this.user = user;
    }
}
