package typerunner.frontend.controllers;

import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

/**
 * Controller for the Account Management Screen
 * 
 * Handles GUI events on this page. After an admin inputs their credentials, they can 
 * select a player from the drop down and perform actions on their account.
 * 
 * @author Christian Tamayo
 * 
 */

public class AccountManagementController {
    


    public void checkAdminCredentials(ActionEvent e) {
        
    }

    public void populatePlayerMenu(ActionEvent e) {

    }

    public void viewPlayerStatistics(ActionEvent e) {

    }

    public void resetPassword(ActionEvent e) {

    }

    public void resetStatistics(ActionEvent e) {

    }

    public void resetHighscore(ActionEvent e) {

    }

    /**
     * Return to Admin Controls
     * 
     * takes the user back to the admin controls screen. 
     * 
     * @param e the button event
     */

    public void returnToAdminControls(ActionEvent e) {
        try {
            System.out.println("returning to admin controls");
            ScreenNavigator.switchScene(e, "fxml/admin-controls.fxml");
        }

        catch(Exception exception) {
            System.out.println("exception while returning to admin controls:\n" + exception);            
        }
    }
}
