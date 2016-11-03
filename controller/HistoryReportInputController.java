package controller;

import fxapp.MainFXApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.HistoryReport;
import model.UserType;

/**
 * Created by Shivani Upadhayay on 11/1/2016.
 */
public class HistoryReportInputController {

    /** a link back to the main application class */
    private MainFXApplication mainApplication;

    private Stage viewHistoryReportInputStage;

    private HistoryReport backingArray[] = new HistoryReport[10];

    @FXML
    private ComboBox<String> ppm = new ComboBox<>();

    @FXML
    private Button viewHistoryReport;

    @FXML
    private TextField latitude;

    @FXML
    private TextField longitude;

    @FXML
    private TextField location;

    @FXML
    private TextField year;

    private final ObservableList<String> listppm = FXCollections.observableArrayList();

    /**
     * Called automatically after load
     */
    @FXML
    private void initialize() {
        listppm.add("CONTAMINANT");
        listppm.add("VIRUS");
        ppm.setItems(listppm);
    }

    /**
     * Sets up view report screen stage
     * @param viewHistoryReportStage sets the strage for this dialog
     */
    public void setViewHistoryReportInputStage(Stage viewHistoryReportStage) {
        this.viewHistoryReportInputStage = viewHistoryReportStage;
    };

    /**
     * Allow for calling back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainFXApplication main) {
        mainApplication = main;
    }

    public void addReports() {
        HistoryReport rep1 = new HistoryReport("Kevin", "Atlanta, GA", 22.4, 34.5, 300, "virus", "May", 2016);
        HistoryReport rep2 = new HistoryReport("Isabella", "Chicago, IL", 34.8, 78.0, 400, "contaminant", "May", 2016);
        HistoryReport rep3 = new HistoryReport("Shivani", "New York, NY", 22.4, 38.6, 250, "contaminant", "May", 2016);
        HistoryReport rep4 = new HistoryReport("Ben", "Los Angeles, CA", 25.0, 45.0, 375, "virus", "September", 2009);
        HistoryReport rep5 = new HistoryReport("Sam", "Boston, MA", 60.5, 27.0, 180, "virus", "October", 2012);
        HistoryReport rep6 = new HistoryReport("Bob", "Austin, TX", 56.0, 50.0, 430, "contaminant", "December", 2014);
        backingArray[0] = rep1;
        backingArray[1] = rep2;
        backingArray[2] = rep3;
        backingArray[3] = rep4;
        backingArray[4] = rep5;
        backingArray[5] = rep6;
    }

    /**
     * Method to search for reports in certain year
     * @return whether there is a match in data
     */
    private boolean doesDataMatch() {
        String errorMessage = "";
        for (int i = 0; i < backingArray.length; i++) {
            if (latitude.getText() == Double.toString(backingArray[i].getLatitude())
                    && longitude.getText() == Double.toString(backingArray[i].getLongitude())
                    && location.getText() == backingArray[i].getLocation()
                    && year.getText() == Double.toString(backingArray[i].getYear())) {
                return true;
            } else {
                errorMessage += "Not a valid entry!\n";
                return false;
            }
        }
        return false;
    }


    private void collectData() {
        if (doesDataMatch()) {
            for (int i = 0; i < backingArray.length; i++) {
                if (backingArray[i].getPpmType() == "contaminant") {
                    for (int k = 0; k < backingArray.length; k++) {
                        if( (backingArray[i].equals(backingArray[k])) && (i != k)) {
                            int counter = 0;
                            double ppmval = 0;
                            ppmval += backingArray[i].getPPM();
                            counter++;
                            double average = ppmval / counter;
                        }
                    }
                } else if (backingArray[i].getPpmType() == "virus") {
                    for (int l = 0; l < backingArray.length; l++) {
                        if( (backingArray[i].equals(backingArray[l])) && (i != l)) {
                            int counter = 0;
                            double ppmval = 0;
                            ppmval += backingArray[i].getPPM();
                            counter++;
                            double average = ppmval / counter;
                        }
                    }
                }
            }
        }
    }
}
