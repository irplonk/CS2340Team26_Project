package controller;

import fxapp.MainFXApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import model.*;
import java.util.ArrayList;


/**
 * Created by Sam on 9/22/2016.
 */
public class LoginScreenController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage loginStage;

    @FXML
    private TextField userID;

    @FXML
    private TextField password;

    private boolean isClicked;

    private ArrayList<AuthorizedUser> checkList;

    public void setCheckList(ArrayList<AuthorizedUser> checkList) {
        this.checkList = checkList;
    }

    /**
     * Sets up login screen stage
     * @param loginStage sets the stage for this dialog
     */
    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
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
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancelPressed() {
        loginStage.close();
    }

    /**
     * Called when user clicks login.
     */
    @FXML
    public void handleLoginPressed() {
        if (isInputValid()) {
            if (checkUserInfo()) {
                loginStage.close();
                mainApplication.showWelcomeScreen();
                isClicked = true;
            }
        }
    }

    /**
     * Returns true if user presses login and the information is valid.
     * @return Returns isClicked
     */
    public boolean returnIsClicked() {
        return isClicked;
    }

    /**
     * Checks userID and password entered by user.
     */
    private boolean checkUserInfo() {
        boolean check = false;
        if (checkList != null) {
            for (int i = 0; i < checkList.size(); i++) {
                if (userID.getText().equals(checkList.get(i).getID()) && password.getText().equals(checkList.get(i).getPassword())) {
                    check = true;
                    ProfileScreenController.user = checkList.get(i);
                    WaterSourceReportController.user = checkList.get(i);
                    WaterPurityReportController.user = checkList.get(i);
                    WelcomeScreenController.user = checkList.get(i);
                }
            }
        }

        if (!check) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Username and/or Password.");
            alert.setContentText("Entered Username and/or Password is incorrect.");
            alert.showAndWait();
            return check;
        }
        return check;
    }

    /**
     * Checks if the input is valid
     * @return returns true if input in both fields is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        //for now just check they actually typed something
        if (userID.getText() == null || userID.getText().length() == 0) {
            errorMessage += "Not a valid username!\n";
        }
        if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "Not a valid password!\n";
        }


        //no error message means success / good input
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(loginStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
