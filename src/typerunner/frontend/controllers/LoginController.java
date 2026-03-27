package typerunner.frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import typerunner.frontend.ScreenNavigator;

/**
 * Controller for the Login Screen
 * 
 * Handles the GUI events on this page, and works with the backend by
 * processing user input for logging in.
 * 
 * @author Christian Tamayo
 */

public class LoginController {

    /** the username textfield */
    @FXML private TextField usernameField;
    /** the password textfield */
    @FXML private TextField passwordField;

    /** 
     * Player Login
     * 
     * Processes the text in the textfields and sends the information to the 
     * login method in the backend. Sends user to player screen if successful.
     * 
     * @param e the button event
    */

    @FXML
    private void login(ActionEvent e) {
        try {
            System.out.println("pressed login");

            //get the username and password
            String username = usernameField.getText();
            String password = passwordField.getText();

            //print for debugging purposes
            System.out.println(username);
            System.out.println(password);

            //make sure they are not blank
            if(username.isBlank() || password.isBlank()) {
                System.out.println("a field is empty");
                return;
            }

            /*
            boolean successful = backend.login(username, password);
            if successful, switch scenes, otherwise provide feedback for invalid login.
            */
            
            //ScreenNavigator.switchScene(e, "fxml/player-screen.fxml");
        } 

        catch(Exception exception) {
            System.out.println("exception while logging in:\n" + exception);
        }
    }
    
    /**
     * Return to the Main Menu
     * 
     * Takes the user back to the main menu. 
     * 
     * @param e the button event
     */

    @FXML
    private void returnToMenu(ActionEvent e) {
        try {
            System.out.println("going back to menu page");
            ScreenNavigator.switchScene(e, "fxml/menu.fxml");
        } 

        catch(Exception exception) {
            System.out.println("exception going back to menu:\n" + exception);
        }
    }
}
