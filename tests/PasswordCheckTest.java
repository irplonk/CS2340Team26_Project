package tests;

import fxapp.MainFXApplication;
import javafx.embed.swing.JFXPanel;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Test;

import controller.RegistrationScreenController;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * @author Isabella Plonk
 * @version 1.0
 */
public class PasswordCheckTest {

    private static final int TIMEOUT = 200;

    private RegistrationScreenController controller;

    @Test(timeout = TIMEOUT)
    public void testReturnsTrue() throws InterruptedException {
        Thread thread = new Thread("JavaFX Init Thread") {
            @Override
            public void run() {
                new JFXPanel();
                Platform.runLater(() -> {
                    new MainFXApplication().start(new Stage());
                    controller = new RegistrationScreenController();
                    controller.initialize();
                    assertTrue("The password and the confirmation password should be equal", controller.passwordCheck());
                });
            }
        };
        thread.start();
    }

    @Test(timeout = TIMEOUT)
    public void testReturnsFalse() throws InterruptedException {
        Thread thread = new Thread("JavaFX Init Thread") {
            @Override
            public void run() {
                new JFXPanel();
                Platform.runLater(() -> {
                    new MainFXApplication().start(new Stage());
                    controller = new RegistrationScreenController();
                    controller.initialize();
                    controller.getPassword().setText("pass1");
                    controller.getConfirmPass().setText("pass2");
                    assertFalse("The password and the confirmation password should not be equal", controller.passwordCheck());
                });
            }
        };
        thread.start();
    }
}
