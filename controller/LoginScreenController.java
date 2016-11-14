package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Controller for login screen
 * @author Sam Sok
 * @version 1.0
 */
public class LoginScreenController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage loginStage;

    @FXML
    private TextField userID;

    @FXML
    private PasswordField password;

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
    public void handleLoginPressed() throws SQLException, ClassNotFoundException{
/*        if (isInputValid()) {
            if (checkUserInfo()) {
                //loginStage.close();
                mainApplication.showWelcomeScreen();
                loginStage.close();
                isClicked = true;
            }
        }*/
        if (isInputValid()) {

            Connection connection = Database.getConnection();

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE userid = '" + userID.getText() + "' AND password = '"
                    + password.getText() + "'");

            if (rs.next()) {
                loginStage.close();
                User.id = userID.getText();
                User.title = rs.getString("usertype");
                mainApplication.showWelcomeScreen();
                isClicked = true;
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Invalid Username and/or Password.");
                alert.setContentText("Entered Username and/or Password is incorrect.");
                alert.showAndWait();
            }

            connection.close();
        }
    }

    /**
     * Called when the user clicks 'forgot password'.
     */
    @FXML
    private void handleForgot() {
        mainApplication.showPasswordRecoveryScreen();
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
    public boolean checkUserInfo() {
        boolean check = false;
        if (checkList != null) {
            for (AuthorizedUser aCheckList : checkList) {
                if (userID.getText().equals(aCheckList.getID()) && password.getText().equals(aCheckList.getPassword())) {
                    check = true;
                    ProfileScreenController.user = aCheckList;
                    WaterSourceReportController.user = aCheckList;
                    WaterPurityReportController.user = aCheckList;
                    WelcomeScreenController.user = aCheckList;
                }
            }
        }

        if (!check) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Username and/or Password.");
            alert.setContentText("Entered Username and/or Password is incorrect.");
            alert.showAndWait();
            return false;
        }
        return true;
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

    /**
     * For junit testing purposes
     */
    public void setUserID(String ID) {
        userID.setText(ID);
    }

    /**
     * For junit testing purposes
     */
    public void setUserPassword(String password) {
        this.password.setText(password);
    }
}
