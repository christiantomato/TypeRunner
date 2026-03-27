package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import typerunner.frontend.ScreenNavigator;

/**
 * Controller for the Main Menu
 * 
 * Includes the methods for the 5 different options available from the main menu:
 * login, leaderboard, tutorial, admin controls, and exit. 
 * 
 * @author Christian Tamayo
 */

public class MenuController {

    /**
     * Go to Login Screen
     * 
     * Takes the user to the login screen.
     * 
     * @param e the button event
     * @throws IOException if there is an input/output problem
     */

    @FXML
    private void goToLogin(ActionEvent e) throws IOException {
        System.out.println("going to login");
        ScreenNavigator.switchScene(e, "fxml/login.fxml");
    }

    /**
     * Go to Passkey Screen
     *
     * Takes the user to the admin passkey screen.
     * 
     * @param e the button event
     * @throws IOException if there is an input/output problem
     */

    @FXML
    private void goToPasskey(ActionEvent e) throws IOException{
        System.out.println("going to passkey first");
        ScreenNavigator.switchScene(e, "fxml/admin-passkey.fxml");
    }

    /**
     * Go to Leaderboard Screen
     * 
     * Takes the user to the leaderboard screen.
     * 
     * @param e the button event
     * @throws IOException if there is an input/output problem
     */

    @FXML
    private void goToLeaderboard(ActionEvent e) {
        System.out.println("going to leaderboard");
    }

    /**
     * Go to Tutorial Screen
     * 
     * Takes the user to the tutorial screen.
     * 
     * @param e the button event
     * @throws IOException if there is an input/output problem
     */
    
    @FXML
    private void goToTutorial(ActionEvent e) {
        System.out.println("going to tutorial");
    }

    /**
     * Exit TypeRunner
     * 
     * Closes the game.
     * 
     * @param e the button event
     * @throws IOException if there is an input/output problem
     */
    
    @FXML
    private void exit(ActionEvent e) throws IOException {
        System.out.println("exiting TypeRunner");
        ScreenNavigator.closeStage(e);
    }
}
