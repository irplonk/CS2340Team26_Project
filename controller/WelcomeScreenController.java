package controller;

import fxapp.MainFXApplication;

import javafx.fxml.FXML;

/**
 * The controller for the root/main window
 *
 */
public class WelcomeScreenController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    /**
     * allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    @FXMl
    private MenuBar menuBar;

    @FXML
    private Menu menu;

    @FXML
    private MenuItem view;

    @FXMl
    private MenuItem submit;

    @FXML
    private Button logout;

    @FXML
    private void handleLogOut() {
        Stage stage;
        Parent root;
        stage = (Stage) logout.getScene();
        root = FXMLLoder.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void handleMenuItem() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Option unavailable");
        alert.setContentText("This option is not available at this time.");
        alert.showAndWait();
    }

}
