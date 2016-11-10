package controller;

import fxapp.MainFXApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import model.*;
import java.util.ArrayList;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.UUID;


/**
 * Created by Kevin on 10/30/2016.
 */
public class PasswordResetController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage passwordResetStage;

    @FXML
    private TextField firstPass;

    @FXML
    private TextField secondPass;

    @FXML
    private Button resetButton;

    private String code;

    /**
     * Constructor for testing purposes
     *
    public PasswordResetController() {
        firstPass = new TextField();
        secondPass = new TextField();
    }*/

    /**
     * Initialize password recovery screen, hide button
     */
    @FXML
    public void initialize() {
        //resetButton.setVisible(false);
    }

    /**
     * Setter for password reset code, provided as a UUID from
     * PasswordRecoveryController
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Sets up Pass recovery screen stage
     * @param passwordResetStage sets the stage for this dialog
     */
    public void setPasswordResetStage(Stage passwordResetStage) {
        this.passwordResetStage = passwordResetStage;
    }

    /**
     * Setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(MainFXApplication mainFXApplication) {

        mainApplication = mainFXApplication;
    }

    /**
     * Called when user clicks 'reset'
     *
     * Returns whether or not password is reset
     */
    @FXML
    public void handleReset() {
        if (passwordCheck()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(passwordResetStage);
            alert.setTitle("Password Reset");
            alert.setHeaderText("Password successfully reset");
            alert.setContentText("(not actually tho)");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(passwordResetStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Passwords do not match or are not between 6-19 chars");
            alert.showAndWait();
        }
    }

    /**
     * Method to check whether or not password fields are valid
     *
     * Made public for JUnit tests
     */
    public boolean passwordCheck() {
        if (!firstPass.getText().isEmpty()
                && firstPass.getText().length() > 5
                && firstPass.getText().length() < 20) {
            String a = firstPass.getText();
            String b = secondPass.getText();
            boolean temp = firstPass.getText().equals(secondPass.getText());
            return firstPass.getText().equals(secondPass.getText());
        } else {
            return false;
        }
    }

    /**
     * Set first password. For testing purposes
     */
    public void setFirstPass(TextField firstPass) {
        this.firstPass = firstPass;
    }

    /**
     * Set second password. For testing purposes
     */
    public void setSecondPass(TextField secondPass) {
        this.secondPass = secondPass;
    }

    /**
     * Return first password. For testing purposes
     */
    public TextField getFirstPass() {
        return firstPass;
    }

    /**
     * Return second password. For testing purposes
     */
    public TextField getSecondPass() {
        return secondPass;
    }
}
