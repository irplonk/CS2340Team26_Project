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
import javafx.scene.control.PasswordField;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Controller for registration screen
 * @author Isabella Plonk
 * @version 1.0
 */
public class RegistrationScreenController {

    private Stage registrationStage;
    private MainFXApplication mainFXApplication;

    @FXML
    private Button cancel;

//    @FXML
//    private TextField password;

    @FXML
    private Button createAccount;

    @FXML
    private TextField lastName;

    @FXML
    private TextField firstName;
    //@FXML
    //private TextField name;

    @FXML
    private TextField userID;

    @FXML
    private PasswordField password;

    @FXML
    private ComboBox<UserType> userType;

    @FXML
    private final TextField confirmPass = new TextField();

    private final ObservableList<UserType> list = FXCollections.observableArrayList();

    private static AuthorizedUser user;

    private final ArrayList<AuthorizedUser> authorizedUserList = new ArrayList<>();

    /**
     * Called automatically after load
     */
    @FXML
    public void initialize() {
        list.addAll(UserType.values());
        userType.setItems(list);
    }

    /**
     * Sets the main application
     * @param mainFXApplication the main application
     */
    public void setMainApp(MainFXApplication mainFXApplication) {this.mainFXApplication = mainFXApplication;}

    /**
     * Sets up registration screen stage
     * @param registrationStage sets the stage for this dialog
     */
    public void setRegistrationStage(Stage registrationStage) {this.registrationStage = registrationStage;}

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
    public void handleCreateAccount() throws SQLException, ClassNotFoundException {

        if (isInputValid()) {
            Connection connection = Database.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE userid = '" + userID.getText() + "'");

            if(!rs.isBeforeFirst()) {
                stmt.executeUpdate("INSERT INTO Users VALUES ('"
                        + userID.getText() + "', '" + firstName.getText() +
                        "', '" + lastName.getText() + "', '" + password.getText() + "', '" + userType.getValue() + "', NULL, NULL, NULL)");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(registrationStage);
                alert.setTitle("Invalid User ID");
                alert.setHeaderText("Invalid User ID");
                alert.setContentText("There seems to already be an account with this User ID. Please try again.");

                alert.showAndWait();
            }

            connection.close();
            registrationStage.close();
        }

    }

    /**
     * Checks both password fields to see if they are identical.
     * Returns true if they are or false otherwise
     * @return true if password are identical
     */
    public boolean passwordCheck() {
        boolean check = false;
        if (password.getText().equals(confirmPass.getText())) {
            check = true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(registrationStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText("The passwords you have entered do not match.");

            alert.showAndWait();
        }
        return check;
    }

    /**
     * Checks if the input is valid
     * @return returns true if input in both fields is valid
     */
    public boolean isInputValid() {
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
        if (userType.getValue() == null) {
            errorMessage += "Not a valid user type!\n";
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

    /**
     * Getter method for authorizedUserList
     * @return ArrayList list of authorized users
     */
    public ArrayList<AuthorizedUser> getUserList() {
        return authorizedUserList;
    }

    /**
     * Setter method for user
     * @param user the AuthorizedUser to set user to
     */
    public void setUser(AuthorizedUser user) {
        RegistrationScreenController.user = user;
    }

    public PasswordField getPassword() {
        return password;
    }

    public TextField getConfirmPass() {
        return confirmPass;
    }

    public TextField getFirstName() {
        return firstName;
    }

    public TextField getLastName() {
        return lastName;
    }

    public TextField getUserID() {
        return userID;
    }

    public ComboBox<UserType> getUserType() {
        return userType;
    }
}
