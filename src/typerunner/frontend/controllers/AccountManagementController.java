package typerunner.frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
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
    
    /** the admin username field */
    @FXML private TextField usernameField;
    /** the admin password field */
    @FXML private TextField passwordField;
    /** the drop down for the players the admin manages */
    @FXML private MenuButton playerDropdown; 


    /**
     * Verifies Admin Account Exists
     * 
     * takes the inputted values in the textfields and finds the 
     * associated admin account in order to load the corresponding
     * players this account manages. 
     * 
     * @param e the button event
     */

    @FXML
    private void checkAdminCredentials(ActionEvent e) {
        try {
            System.out.println("checking the admin credentials");

            //get the strings from the textfields
            String username = usernameField.getText();
            String password = passwordField.getText();

            //print out for debugging purposes
            System.out.println(username);
            System.out.println(password);

            //make sure the username or password are not blank
            if(username.isBlank() || password.isBlank()) {
                System.out.println("username or password is blank, or unselected type");
                return;
            }

            //TODO: check if the account exists, and if so, then popoulate the player menu
            //populatePlayerMenu(e); 
        } 
        catch(Exception exception) {
            System.out.println("exception while checking admin credentials:\n" + exception);
        }
    }

    /**
     * thanks for the delicioso matcha chrissy my love <3333
     * 
     * 
     * 
     * 
     * 
     * 
     * @param e
     */

    @FXML
    private void populatePlayerMenu(ActionEvent e) {

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
