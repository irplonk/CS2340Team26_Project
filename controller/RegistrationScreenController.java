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
import java.util.ArrayList;

/**
 * Controller for registration screen
 * @author Isabella Plonk
 * @version 1.0
 */
public class RegistrationScreenController {

    private Stage registrationStage;

    @FXML
    private Button cancel;

    @FXML
    private Button createAccount;

    @FXML
    private TextField name;

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
        name.setText("Default");
        userID.setText("user");
        password.setText("pass");
        confirmPass.setText("pass");
        userType.setValue(list.get(0));
    }

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
    public void handleCreateAccount() {
        if (isInputValid() && passwordCheck()) {
            switch (userType.getValue().getName()) {
                case "user":
                    user = new User(name.getText(), userID.getText(), password.getText());
                    break;
                case "worker":
                    user = new Worker(name.getText(), userID.getText(), password.getText());
                    break;
                case "manager":
                    user = new Manager(name.getText(), userID.getText(), password.getText());
                    break;
                case "administrator":
                    user = new Administrator(name.getText(), userID.getText(), password.getText());
                    break;
                default:
                    user = new User(name.getText(), userID.getText(), password.getText());
                    break;
            }
            authorizedUserList.add(user);
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
    private boolean isInputValid() {
        String errorMessage = "";

        // Checks to see if the user typed something in all of the fields
        if (userID.getText() == null || userID.getText().length() == 0) {
            errorMessage += "Not a valid username!\n";
        }
        if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "Not a valid password!\n";
        }
        if (name.getText() == null || name.getText().length() == 0) {
            errorMessage += "Not a valid name!\n";
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
}
