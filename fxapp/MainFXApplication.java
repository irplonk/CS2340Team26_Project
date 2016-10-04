package fxapp;


import controller.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


/**
 * Main application class.  Some code reused from the code makery tutorial
 *
 * This class handles all the scene switching to reuse the main stage.
 *
 */
public class MainFXApplication extends Application {
    /**  the java logger for this class */
    private static final Logger LOGGER =Logger.getLogger("MainFXApplication");

    /** the main container for the application window */
    private Stage mainScreen;

    /** the main layout for the main window */
    private BorderPane rootLayout;

    private ArrayList<AuthorizedUser> checkList;

    @Override
    public void start(Stage primaryStage) {
        mainScreen = primaryStage;
        initRootLayout(mainScreen);
    }

    /**
     * return a reference to the main window stage
     * @return reference to main stage
     * */
    public Stage getMainScreen() { return mainScreen;}


    /**
     * Initialize the main screen for the application.  Most other views will be shown in this screen.
     *
     * @param mainScreen  the main Stage window of the application
     */
    private void initRootLayout(Stage mainScreen) {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFXApplication.class.getResource("../view/MainScreen.fxml"));
            rootLayout = loader.load();

            // Give the controller access to the main app.
            MainScreenController controller = loader.getController();
            controller.setMainApp(this);

            // Set the Main App title
            mainScreen.setTitle("Clean Water Crowdsourcing");

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for MainScreen!!");
            e.printStackTrace();
        }
    }


    /**
     * Opens a dialog to login
     *
     */
    public void showLoginScreen() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFXApplication.class.getResource("../view/LoginScreen.fxml"));
            Pane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Login");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the stage into the controller.
            LoginScreenController controller = loader.getController();
            controller.setLoginStage(dialogStage);
            controller.setMainApp(this);
            controller.setCheckList(checkList);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified student. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * We can also open the dialog to add a completely new student if we pass null in
     *
     */
    public void showWelcomeScreen() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFXApplication.class.getResource("../view/WelcomeScreen.fxml"));
            Pane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Welcome!");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the stage into the controller.
            WelcomeScreenController controller = loader.getController();
            controller.setWelcomeStage(dialogStage);
            controller.setMainApp(this);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the registration screen
     */
    public void showRegistrationScreen() {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFXApplication.class.getResource("../view/RegistrationScreen.fxml"));
            Pane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Create an Account");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the stage into the controller.
            RegistrationScreenController controller = loader.getController();
            controller.setRegistrationStage(dialogStage);
            controller.setMainApp(this);
            checkList = controller.getUserList();

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Displays profile page
     */
    public void showProfileScreen() {

        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFXApplication.class.getResource("../view/ProfileScreen.fxml"));
            Pane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Your Profile");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(mainScreen);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the stage into the controller.
            ProfileScreenController controller = loader.getController();
            controller.setProfileScreenStage(dialogStage);
            controller.setMainApp(this);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            //scene = new Scene(page);
            //mainScreen.setScene(scene);
            //mainScreen.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
