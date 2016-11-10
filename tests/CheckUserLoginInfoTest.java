package tests;

import controller.LoginScreenController;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import model.*;
import fxapp.MainFXApplication;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by Samuel Sok
 */
public class CheckUserLoginInfoTest {

    LoginScreenController loginController = new LoginScreenController();
    MainFXApplication mainApp = new MainFXApplication();
    Stage stage;

    ArrayList<AuthorizedUser> listOfUsers;

    //Checks to see if user can successfully login with correct info
    @Test
    public void registeredUserTest() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new JFXPanel();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        stage = new Stage();
                        mainApp.start(stage);
                        loginController = new LoginScreenController();
                        loginController.setUserID("user");
                        loginController.setUserPassword("pass");

                        AuthorizedUser user = new User("user", "pass", "name");
                        listOfUsers = new ArrayList<>();
                        listOfUsers.add(user);

                        loginController.setCheckList(listOfUsers);

                        assertEquals((Boolean) true, loginController.checkUserInfo());
                    }
                });
            }
        });
        thread.start();// Initialize the thread
        Thread.sleep(100);
    }

    // Test to check if system does not let unregistered user login
    @Test
    public void checkUnregisteredUser() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new JFXPanel();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        stage = new Stage();
                        mainApp.start(stage);
                        loginController = new LoginScreenController();
                        loginController.setUserID("user");
                        loginController.setUserPassword("pass");

                        AuthorizedUser user = new User("person", "pass", "name");
                        listOfUsers = new ArrayList<>();
                        listOfUsers.add(user);

                        loginController.setCheckList(listOfUsers);

                        assertEquals((Boolean) false, loginController.checkUserInfo());
                    }
                });
            }
        });
        thread.start();
        Thread.sleep(100);
    }

    //Test to check if user entered wrong password
    @Test
    public void checkWrongPassword() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                new JFXPanel();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        stage = new Stage();
                        mainApp.start(stage);
                        loginController = new LoginScreenController();
                        loginController.setUserID("user");
                        loginController.setUserPassword("pass1");

                        AuthorizedUser user = new User("user", "pass", "name");
                        listOfUsers = new ArrayList<>();
                        listOfUsers.add(user);

                        loginController.setCheckList(listOfUsers);

                        assertEquals((Boolean) false, loginController.checkUserInfo());
                    }
                });
            }
        });
        thread.start();
        Thread.sleep(100);
    }
}

