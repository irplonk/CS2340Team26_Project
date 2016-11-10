package tests;

import controller.PasswordResetController;
import fxapp.MainFXApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;
import javafx.scene.control.TextField;
import sun.applet.Main;

import java.io.IOException;

/**
 * @author Kevin Wang
 * @version 1.0
 */
public class PasswordResetTest {
    FXMLLoader loader;
    static PasswordResetController controller;
    static MainFXApplication main;
    static Stage dialogStage;
    static Scene scene;
    TextField firstPass;
    TextField secondPass;

    public static class AsNonApp extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            main = new MainFXApplication();
            //main.showPasswordResetScreen("testtt");
            try {
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainFXApplication.class.getResource("../view/PasswordResetScreen.fxml"));
                Pane page = loader.load();

                // Create the dialog Stage.
                dialogStage = new Stage();
                dialogStage.setTitle("Password recovery");
                scene = new Scene(page);
                dialogStage.setScene(scene);

                // Set the stage into the controller.
                controller = loader.getController();
                controller.setCode("testtt");
                controller.setMainApp(main);

                dialogStage.show();
                dialogStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeClass
    public static void initJFX() throws InterruptedException {
        Thread t = new Thread("JavaFX Init Thread") {
            public void run() {
                Application.launch(AsNonApp.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();
        Thread.sleep(500);
    }

    /*
    @BeforeClass
    public void setUp() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        main = new MainFXApplication();
        //main.showPasswordResetScreen("testtt");
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFXApplication.class.getResource("../view/PasswordResetScreen.fxml"));
            Pane page = loader.load();

            // Create the dialog Stage.
            dialogStage = new Stage();
            dialogStage.setTitle("Password recovery");
            scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the stage into the controller.
            controller = loader.getController();
            controller.setCode("testtt");
            controller.setMainApp(main);
            controller.getFirstPass().setText("53");
            System.out.println(controller.getFirstPass().getText());

            dialogStage.show();
            dialogStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    */

    @Test
    public void testValidPassword() {
        controller.getFirstPass().setText("hellokitty");
        controller.getSecondPass().setText("hellokitty");

        Assert.assertTrue(controller.passwordCheck());
    }

    @Test
    public void testValidPassword2() {
        controller.getFirstPass().setText("kevin1356");
        controller.getSecondPass().setText("kevin1356");

        Assert.assertTrue(controller.passwordCheck());
    }

    @Test
    public void testValidPassword3() {
        controller.getFirstPass().setText("kev#%@2");
        controller.getSecondPass().setText("kev#%@2");

        Assert.assertTrue(controller.passwordCheck());
    }

    @Test
    public void testValidPasswordMinLength() {
        controller.getFirstPass().setText("123456");
        controller.getSecondPass().setText("123456");

        Assert.assertTrue(controller.passwordCheck());
    }

    @Test
    public void testValidPasswordMaxLength() {
        controller.getFirstPass().setText("1234561234561234561");
        controller.getSecondPass().setText("1234561234561234561");

        Assert.assertTrue(controller.passwordCheck());
    }

    @Test
    public void testInvalidPasswordMinLength() {
        // 5 characters
        controller.getFirstPass().setText("12345");
        controller.getSecondPass().setText("12345");

        Assert.assertFalse(controller.passwordCheck());
    }

    @Test
    public void testInvalidPasswordMaxLength() {
        // 20 characters
        controller.getFirstPass().setText("12345612345612345612");
        controller.getSecondPass().setText("12345612345612345612");

        Assert.assertFalse(controller.passwordCheck());
    }

    @Test
    public void testInvalidPasswordCharacters() {
        // 20 upside down question mark??
        controller.getFirstPass().setText("hellokid¿");
        controller.getSecondPass().setText("hellokid¿");

        Assert.assertFalse(controller.passwordCheck());
    }
}