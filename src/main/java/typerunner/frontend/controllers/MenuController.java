package typerunner.frontend.controllers;

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
     */

    @FXML
    private void goToLogin(ActionEvent e) {
        try {
            System.out.println("going to login");
            ScreenNavigator.switchScene(e, "/fxml/login.fxml");
        } 

        catch(Exception exception) {
            System.out.println("exception going to login:\n" + exception);
        }
    }

    /**
     * Go to Passkey Screen
     *
     * Takes the user to the admin passkey screen.
     * 
     * @param e the button event
     */

    @FXML
    private void goToPasskey(ActionEvent e) {
        try {
            System.out.println("going to passkey first");
            ScreenNavigator.switchScene(e, "/fxml/admin-passkey.fxml");
        } 
        
        catch(Exception exception) {
            System.out.println("exception going to passkey:\n" + exception);
        }
    }

    /**
     * Go to Leaderboard Screen
     * 
     * Takes the user to the leaderboard screen.
     * 
     * @param e the button event
     */

    @FXML
    private void goToLeaderboard(ActionEvent e) {
         try {
            System.out.println("going to leaderboard");
            ScreenNavigator.switchScene(e, "/fxml/leaderboard.fxml");
        } 
        
        catch(Exception exception) {
            System.out.println("exception going to leaderboard:\n" + exception);
        }
    }

    /**
     * Go to Tutorial Screen
     * 
     * Takes the user to the tutorial screen.
     * 
     * @param e the button event
     */
    
    @FXML
    private void goToTutorial(ActionEvent e) {
         try {
            System.out.println("going to tutorial");
            ScreenNavigator.switchScene(e, "/fxml/tutorial.fxml");
        } 
        
        catch(Exception exception) {
            System.out.println("exception going to tutorial:\n" + exception);
        }
    }

    /**
     * Exit TypeRunner
     * 
     * Closes the game.
     * 
     * @param e the button event
     */
    
    @FXML
    private void exit(ActionEvent e) {
         try {
            System.out.println("exiting TypeRunner");
            ScreenNavigator.closeStage(e);
        } 
        
        catch(Exception exception) {
            System.out.println("exception going to passkey:\n" + exception);
        }
    }
}
