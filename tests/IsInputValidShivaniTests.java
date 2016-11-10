package tests;
import controller.RegistrationScreenController;
import fxapp.MainFXApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.UserType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;
import javafx.scene.control.TextField;
import sun.applet.Main;
import java.io.IOException;

/**
 * Created by Shivani Upadhayay on 11/9/2016.
 */
public class IsInputValidShivaniTests {

    FXMLLoader loader;
    static RegistrationScreenController controller;
    static MainFXApplication main;
    static Stage dialogStage;
    static Scene scene;
    TextField firstName;
    TextField lastName;
    TextField userID;
    PasswordField password;
    UserType userType;

    public static class NewApp extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            main = new MainFXApplication();
            //main.showPasswordResetScreen("testtt");
            try {
                // Load the fxml file and create a new stage for the popup dialog.
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainFXApplication.class.getResource("../view/RegistrationScreen.fxml"));
                Pane page = loader.load();

                // Create the dialog Stage.
                dialogStage = new Stage();
                dialogStage.setTitle("Password recovery");
                scene = new Scene(page);
                dialogStage.setScene(scene);

                // Set the stage into the controller.
                controller = loader.getController();
                //controller.setCode("testtt");
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
                Application.launch(NewApp.class, new String[0]);
            }
        };
        t.setDaemon(true);
        t.start();
        Thread.sleep(1500);
    }
    /*
    These are all the true inputs
     */
    @Test
    public void testTrueValidInputAdmin() {
        controller.getFirstName().setText("Shivani");
        controller.getLastName().setText("Upadhayay");
        controller.getPassword().setText("password");
        controller.getUserID().setText("myName");
        controller.getUserType().setValue(UserType.ADMINISTRATOR);

        Assert.assertTrue("Every input is valid", controller.isInputValid());
    }

    @Test
    public void testTrueValidInputUser() {
        controller.getFirstName().setText("Shivani");
        controller.getLastName().setText("Upadhayay");
        controller.getPassword().setText("password");
        controller.getUserID().setText("myName");
        controller.getUserType().setValue(UserType.USER);

        Assert.assertTrue("Every input is valid", controller.isInputValid());
    }

    @Test
    public void testTrueValidInputWorker() {
        controller.getFirstName().setText("Shivani");
        controller.getLastName().setText("Upadhayay");
        controller.getPassword().setText("password");
        controller.getUserID().setText("myName");
        controller.getUserType().setValue(UserType.WORKER);

        Assert.assertTrue("Every input is valid", controller.isInputValid());
    }

    @Test
    public void testTrueValidInputManager() {
        controller.getFirstName().setText("Shivani");
        controller.getLastName().setText("Upadhayay");
        controller.getPassword().setText("password");
        controller.getUserID().setText("myName");
        controller.getUserType().setValue(UserType.MANAGER);

        Assert.assertTrue("Every input is valid", controller.isInputValid());
    }

    /*
    * Here are the false values
     */
    @Test
    public void testFalseValidInput1() {
        controller.getFirstName().setText("Shivani");
        controller.getLastName().setText("Upadhayay");
        controller.getPassword().setText("password");
        controller.getUserID().setText("myName");
        controller.getUserType().setValue(null);

        Assert.assertFalse("The user type should not be null", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput2() {
        controller.getFirstName().setText("");
        controller.getLastName().setText("hellokitty");
        controller.getPassword().setText("yoyo");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.MANAGER);

        Assert.assertFalse("First name cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput3() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("");
        controller.getPassword().setText("yoyo");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.MANAGER);

        Assert.assertFalse("last name cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput4() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("lastname");
        controller.getPassword().setText("");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.MANAGER);

        Assert.assertFalse("password cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput5() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("lastname");
        controller.getPassword().setText("password");
        controller.getUserID().setText("");
        controller.getUserType().setValue(userType.MANAGER);

        Assert.assertFalse("user id cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput6() {
        controller.getFirstName().setText("");
        controller.getLastName().setText("hellokitty");
        controller.getPassword().setText("yoyo");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.WORKER);

        Assert.assertFalse("First name cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput7() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("");
        controller.getPassword().setText("yoyo");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.WORKER);

        Assert.assertFalse("last name cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput8() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("lastname");
        controller.getPassword().setText("");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.WORKER);

        Assert.assertFalse("password cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput9() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("lastname");
        controller.getPassword().setText("password");
        controller.getUserID().setText("");
        controller.getUserType().setValue(userType.WORKER);

        Assert.assertFalse("user id cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput10() {
        controller.getFirstName().setText("");
        controller.getLastName().setText("hellokitty");
        controller.getPassword().setText("yoyo");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.ADMINISTRATOR);

        Assert.assertFalse("First name cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput11() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("");
        controller.getPassword().setText("yoyo");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.ADMINISTRATOR);

        Assert.assertFalse("last name cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput12() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("lastname");
        controller.getPassword().setText("");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.ADMINISTRATOR);

        Assert.assertFalse("password cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput13() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("lastname");
        controller.getPassword().setText("password");
        controller.getUserID().setText("");
        controller.getUserType().setValue(userType.ADMINISTRATOR);

        Assert.assertFalse("user id cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput14() {
        controller.getFirstName().setText("");
        controller.getLastName().setText("hellokitty");
        controller.getPassword().setText("yoyo");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.USER);

        Assert.assertFalse("First name cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput15() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("");
        controller.getPassword().setText("yoyo");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.USER);

        Assert.assertFalse("last name cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput16() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("lastname");
        controller.getPassword().setText("");
        controller.getUserID().setText("Lala");
        controller.getUserType().setValue(userType.USER);

        Assert.assertFalse("password cannot be empty", controller.isInputValid());
    }

    @Test
    public void testFalseValidInput17() {
        controller.getFirstName().setText("firstname");
        controller.getLastName().setText("lastname");
        controller.getPassword().setText("password");
        controller.getUserID().setText("");
        controller.getUserType().setValue(userType.USER);

        Assert.assertFalse("user id cannot be empty", controller.isInputValid());
    }


}
