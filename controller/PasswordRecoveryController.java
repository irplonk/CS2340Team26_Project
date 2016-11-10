package controller;

import fxapp.MainFXApplication;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.UUID;


/**
 * Controller for password recovery
 * @author Kevin Wang
 * @version 1.0
 */
public class PasswordRecoveryController {

    /** reference back to mainApplication if needed */
    private MainFXApplication mainApplication;

    private Stage passwordRecoveryStage;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField verificationCode;

    @FXML
    private Button resetButton;

    private String code;

    private static String sendEmail(String emailAddress) {
        String resetCode = null;

        try{
            // Setup mail server properties
            Properties mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");

            // Setup message and mail Session
            Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            MimeMessage generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
            generateMailMessage.setSubject("Greetings from CS2340...");
            UUID resetUUID = UUID.randomUUID();
            resetCode = resetUUID.toString().substring(1,6);
            String emailBody = "Hello! <br>" +
                    "Thanks for resetting your password. Here is your reset code <br><br>" +
                    resetCode +
                    "<br><br> Regards, <br>Team 26";
            generateMailMessage.setContent(emailBody, "text/html");

            // Send message
            Transport transport = getMailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", "team26cs2340@gmail.com", "jerrythecat");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

        return resetCode;
    }

    /**
     * Initialize password recovery screen, hide button
     */
    @FXML
    public void initialize() {
        resetButton.setVisible(false);
    }

    /**
     * Sets up Pass recovery screen stage
     * @param passwordRecoveryStage sets the stage for this dialog
     */
    public void setPasswordRecoveryStage(Stage passwordRecoveryStage) {
        this.passwordRecoveryStage = passwordRecoveryStage;
    }

    /**
     * Setup the main application link so we can call methods there
     *
     * @param mainFXApplication  a reference (link) to our main class
     */
    public void setMainApp(MainFXApplication mainFXApplication) {

        mainApplication = mainFXApplication;
    }

    /**
     * Called when user clicks 'send code'
     */
    @FXML
    public void handleSendCode() {
        if (inputEmail.getText() != null && !inputEmail.getText().isEmpty()) {
            code = sendEmail(inputEmail.getText());
            System.out.println(code);
            resetButton.setVisible(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(passwordRecoveryStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please enter an email address dude");

            alert.showAndWait();
        }
    }

    /**
     * Called when user clicks 'reset'
     */
    @FXML
    public void handleReset() {
        if (verificationCode.getText().equals(this.code)) {
            mainApplication.showPasswordResetScreen(this.code);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(passwordRecoveryStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Reset code not correct");

            alert.showAndWait();
        }
    }
}
