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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

    public static User user;

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

    private final ObservableList<User> data = FXCollections.observableArrayList();

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
     * @param profileScreenStage sets the stage for this dialog
     */
    public void setProfileScreenStage(Stage profileScreenStage) throws SQLException, ClassNotFoundException {
        this.profileScreenStage = profileScreenStage;

        Connection connection = Database.getConnection();

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE userid = '" + User.id + "'");

        if(rs.next()) {
            this.Name.setText(rs.getString("firstname") + " " + rs.getString("lastname"));
            this.ID.setText(rs.getString("userid"));

            String email = rs.getString("email");
            if(email != null) {
                this.EmailAddress.setText(email);
            }

            String homeAddress = rs.getString("home_address");
            if(homeAddress != null) {
                this.HomeAddress.setText(homeAddress);
            }

            String title = rs.getString("title");
            if(title != null) {
                this.Title.setText(title);
            }
        }

        connection.close();
    }

    /**
     * Called when user clicks cancel
     */
    @FXML
    public void handleCancel() throws SQLException, ClassNotFoundException {
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
     * Called when user clicks Save
     */
    @FXML
    public void handleSave() throws SQLException, ClassNotFoundException {

        Connection connection = Database.getConnection();

        Statement stmt = connection.createStatement();

        stmt.executeUpdate("Update Users SET userid = '" + ID.getText() + "', email = '" + EmailAddress.getText() + "', home_address = '"
                + HomeAddress.getText() + "', title = '" + Title.getText() + "' WHERE userid = '" + User.id + "'");

        connection.close();

        profileScreenStage.close();
    }

}