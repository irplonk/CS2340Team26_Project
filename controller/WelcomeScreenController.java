package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import model.*;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


/**
 * Controller for welcome screen
 * @author Isabella Plonk
 * @version 1.0
 */
public class WelcomeScreenController implements Initializable, MapComponentInitializedListener {

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

    @FXML
    private GoogleMapView mapView;

    private GoogleMap map;

    public static AuthorizedUser user;

    private ArrayList<Report> sourceReport;

    public WelcomeScreenController() {
    }

    /**
     * allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Sets up welcome screen stage
     * @param welcomeStage sets the stage for this dialog
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
     * Initialize method for the map
     * @param url contains map data
     * @param rb contains map resources
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
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
        mainApplication.showViewHistoryReportInputScreen();
    }

    private boolean isManager() {
        System.out.print(user.getClass().getName());
        return (Objects.equals(user.getClass().getName(), "model.Manager"));
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

    /**
     * Sets stage and the MainFXApp
     * @param stage contains the data for the stage
     * @param app Is used to link back to the mainFXApp
     */
    public void setCallbacks(Stage stage, MainFXApplication app) {
        welcomeStage = stage;
        mainApplication = app;
    }

    /**
     * Initializes the map with pins
     */
    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        //set up the center location for the map
        LatLong center = new LatLong(34, -84);

        options.center(center)
                .zoom(9)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.TERRAIN);

        map = mapView.createMap(options);

        //Grabbing locations from water source reports submitted
        for (Report l: sourceReport) {
            MarkerOptions markerOptions = new MarkerOptions();
            LatLong loc = new LatLong(l.getLatitude(), l.getLongitude());

            markerOptions.position(loc)
                    .visible(Boolean.TRUE)
                    .title(l.getLocation());

            Marker marker = new Marker(markerOptions);

            map.addUIEventHandler(marker,
                    UIEventType.click,
                    (JSObject obj) -> {
                        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                        infoWindowOptions.content(l.getDescription());

                        InfoWindow window = new InfoWindow(infoWindowOptions);
                        window.open(map, marker);
                    });

            map.addMarker(marker);
        }
    }

    /**
     * Sets the source report which contains Water Source Reports which contains information for the pins
     * @param sourceReport list of Water Source Reports
     */
    public void setSourceReport(ArrayList<Report> sourceReport) {
        this.sourceReport = sourceReport;
    }

}
