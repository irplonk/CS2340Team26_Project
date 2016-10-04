package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

/**
 * The controller for the profile page screen
 * Created by Shivani on 10/3/16
 * @version 1.0
 */

public class ProfileScreenController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage profileScreenStage;

    private final ObservableList<UserType> list = FXCollections.observableArrayList();

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
     * allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }


    /**
     * Sets up profile screen screen stage
     * @param profileScreenStage sets the strage for this dialog
     */
    public void setProfileScreenStage(Stage profileScreenStage) {this.profileScreenStage = profileScreenStage;};

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
     * Called when user clicks Save
     */
    @FXML
    public void handleSave() {
        if (isInputValid()) {
            AuthorizedUser au = new User();
            au.setName(Name.getText());
            au.setID(ID.getText());
            au.setEmailaddress(EmailAddress.getText());
            au.setHomeaddress(HomeAddress.getText());
            au.setTitle(Title.getText());
            data.add(au);
            }

        profileScreenStage.close();

    }

}