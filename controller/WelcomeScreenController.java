package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import model.AuthorizedUser;
import model.User;
import model.Manager;
import model.Worker;
import model.Administrator;


/**
 * The controller for the welcome screen
 * Created by Isabella on 9/23/16
 * @version 1.0
 */
public class WelcomeScreenController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage welcomeStage;

    @FXML
    private Button logout;

    @FXML
    private Button editProfile;

    @FXML
    private Button submitSourceReport;

    @FXML
    private Button submitPurityReport;

    @FXML
    private Button viewReports;

    @FXML
    private Button viewWaterAvailReport;

    @FXML
    private Button viewWaterPurityReport;

    @FXML
    private Button viewHistoryReport;

    public static AuthorizedUser user;

    /**
     * allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Sets up welcome screen stage
     * @param welcomeStage sets the strage for this dialog
     */
    public void setWelcomeStage(Stage welcomeStage) {this.welcomeStage = welcomeStage;}

    /**
     * Called when user clicks logout
     */
    @FXML
    private void handleLogout() {
        welcomeStage.close();
    }

    /**
     * Called when user clicks edit profile
     */
    @FXML
    private void handleEditProfile() {
        mainApplication.showProfileScreen();
    }

    /**
     * Called when user clicks submit source report
     */
    @FXML
    private void handleSubmitSourceReport() {
        if (user instanceof User) {
            mainApplication.showWaterSourceReportScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(welcomeStage);
            alert.setTitle("Not allowed");
            alert.setHeaderText("You do not have the rights to complete this action.");
            alert.setContentText("You do not have permission to submit source reports.");

            alert.showAndWait();
        }
    }

    /**
     * Called when user clicks submit purity report
     */
    @FXML
    private void handleSubmitPurityReport() {
        if (user instanceof Worker) {
            mainApplication.showWaterPurityReportScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(welcomeStage);
            alert.setTitle("Not allowed");
            alert.setHeaderText("You do not have the rights to complete this action.");
            alert.setContentText("You do not have permission to submit purity reports.");

            alert.showAndWait();
        }
    }

    /**
     * Called when user clicks view source reports
     */
    @FXML
    private void handleViewReports() {mainApplication.showViewReportsScreen();}

    /**
     * Called when user clicks view purity reports
     */
    @FXML
    private void handleViewPurityReport() {
        if (user instanceof Manager) {
            mainApplication.showViewPurityReportsScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(welcomeStage);
            alert.setTitle("Not allowed");
            alert.setHeaderText("You do not have the rights to complete this action.");
            alert.setContentText("You do not have permission to submit source reports.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleViewWaterAvailReport() {
        if (user instanceof User) {
            mainApplication.showMapScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(welcomeStage);
            alert.setTitle("Not allowed");
            alert.setHeaderText("You do not have the rights to complete this action.");
            alert.setContentText("You do not have permission to submit source reports.");

            alert.showAndWait();
        }
    }

    /**
     * Called when user clicks view history report
     */
    @FXML
    private void handleViewHistoryReport() {
//        if (isManager()) {
//            viewHistoryReport.setVisible(true);
//        } else {
//            viewHistoryReport.setVisible(false);
//        }
        mainApplication.showViewHistoryReportScreen();
    }

    private boolean isManager() {
        System.out.print(user.getClass().getName());
        return (user.getClass().getName() == "model.Manager");
    }
    /**
     * Called automatically after logging in
     */
    @FXML
    public void initialize() {
        if (isManager()) {
            viewHistoryReport.setVisible(true);
        } else {
            viewHistoryReport.setVisible(false);
        }
    }

}
