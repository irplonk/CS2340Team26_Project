package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;

import fxapp.MainFXApplication;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import model.*;

import netscape.javascript.JSObject;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.stage.Stage;

import java.util.ArrayList;
import model.Report;

/**
 * Created by Sam on 10/16/2016.
 */
public class MapScreenController implements Initializable, MapComponentInitializedListener{

    @FXML
    private GoogleMapView mapView;

    private GoogleMap map;

    private Window mainStage;

    private MainFXApplication mainApplication;

    private Stage mapWindow;

    private ArrayList<Report> sourceReport;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
    }

    public void setCallbacks(Window stage, MainFXApplication app) {
        mainStage = stage;
        mainApplication = app;
    }


    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        //set up the center location for the map
        LatLong center = new LatLong(34, -88);

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
     * Allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    /**
     * Sets up view report screen stage
     * @param mapStage sets the stage for this dialog
     */
    public void setWaterAvailabilityReportScreen(Stage mapStage) { mapWindow = mapStage; }

    @FXML
    public void onCloseMenu() {
        mapWindow.close();
    }

    public void setSourceReport(ArrayList<Report> sourceReport) {
        this.sourceReport = sourceReport;
    }


}
