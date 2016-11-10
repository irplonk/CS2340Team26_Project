package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;

/**
 * Controller for profile screen
 * @author Shivani Upadhayay
 * @version 1.0
 */

public class ProfileScreenController {

    private Stage profileScreenStage;
    private MainFXApplication mainFXApplication;

    private final ObservableList<UserType> list = FXCollections.observableArrayList();

    public static AuthorizedUser user;

    @FXML
    private TextField Name;

    @FXML
    private TextField ID;

    @FXML
    private TextField EmailAddress;

    @FXML
    private TextField HomeAddress;

    @FXML
    private TextField Title;

    private final ObservableList<AuthorizedUser> data = FXCollections.observableArrayList();

    @FXML
    private Button Save;

    /**
     * Sets up profile screen screen stage
     * @param profileScreenStage sets the stage for this dialog
     */
    public void setProfileScreenStage(Stage profileScreenStage) {
        this.profileScreenStage = profileScreenStage;
        this.Name.setText(user.getName());
        this.ID.setText(user.getID());
        this.EmailAddress.setText(user.getEmailaddress());
        this.HomeAddress.setText(user.getHomeaddress());
        this.Title.setText(user.getTitle());
    }

    /**
     * @param user sets the user
     */
    public void setUser(AuthorizedUser user) {
        ProfileScreenController.user = user;}

    /**
     * Called when user clicks cancel
     */
    @FXML
    public void handleCancel() {
        profileScreenStage.close();
    }

    /**
     * Checks if the input is valid
     * @return returns true if input in all fields are valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        // Checks to see if the user typed something in all of the fields
        if (Name.getText() == null || Name.getText().length() == 0) {
            errorMessage += "Not a valid name!\n";
        }
        if (ID.getText() == null || ID.getText().length() == 0) {
            errorMessage += "Not a valid ID!\n";
        }
        if (EmailAddress.getText() == null || EmailAddress.getText().length() == 0) {
            errorMessage += "Not a valid last email address!\n";
        }
        if (HomeAddress.getText() == null || HomeAddress.getText().length() == 0) {
            errorMessage += "Not a valid first home address!\n";
        }
        if (Title.getText() == null || Title.getText().length() == 0) {
            errorMessage += "Not a valid Title! \n";
        }

        // No error message means good input
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message if bad data
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(profileScreenStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    /**
     * Sets the main application
     * @param mainFXApplication the main application
     */
    public void setMainApp(MainFXApplication mainFXApplication) {this.mainFXApplication = mainFXApplication;}


    /**
     * Called when user clicks Save
     */
    @FXML
    public void handleSave() {
        if (isInputValid()) {
            user.setName(Name.getText());
            user.setID(ID.getText());
            user.setEmailaddress(EmailAddress.getText());
            user.setHomeaddress(HomeAddress.getText());
            user.setTitle(Title.getText());
        }

        profileScreenStage.close();

    }

}
