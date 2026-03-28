package typerunner.frontend.controllers;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
    @FXML private MenuButton playerMenu; 
    /** the selected player we are managing */
    private String selectedPlayer;

    /**
     * Verifies Admin Account Exists
     * 
     * Takes the inputted values in the textfields and finds the 
     * associated admin account in order to load the corresponding
     * players this account manages. 
     * 
     * @param e the button event
     * @see populatePlayerMenu
     */

    @FXML
    private void checkAdminCredentials(ActionEvent e) {
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
        //populatePlayerMenu(players); 
    }

    /**
     * Populate Player Menu
     * 
     * After identifying the administrator, populate the menu with the 
     * corresponding players under them. Each created menu item is set with an action so that
     * if it is selected, it updates visually on the GUI. 
     * 
     * @param players the list of players the admin manages    
     * @see selectPlayer
     */

    @FXML
    private void populatePlayerMenu(List<String> players) {
        //go through all the players
        for(String player : players) {
            //create a menu item for each player
            MenuItem item = new MenuItem(player);
            //set each menu button with an action to update the menu value if it is selected
            item.setOnAction(this::selectPlayer);
            //add it to the menu 
            playerMenu.getItems().add(item);
        }
    }

    /**
     * 
     * @param e
     */


    @FXML
    private void selectPlayer(ActionEvent e) {
        MenuItem clicked = (MenuItem) e.getSource();
        playerMenu.setText(clicked.getText());
        selectedPlayer = clicked.getText();
    }

    @FXML
    private void viewPlayerStatistics(ActionEvent e) {

    }

    @FXML
    private void resetPassword(ActionEvent e) {

    }

    @FXML
    private void resetStatistics(ActionEvent e) {

    }

    @FXML
    private void resetHighscore(ActionEvent e) {

    }

    /**
     * Return to Admin Controls
     * 
     * takes the user back to the admin controls screen. 
     * 
     * @param e the button event
     */

    @FXML
    private void returnToAdminControls(ActionEvent e) {
        try {
            System.out.println("returning to admin controls");
            ScreenNavigator.switchScene(e, "fxml/admin-controls.fxml");
        }

        catch(Exception exception) {
            System.out.println("exception while returning to admin controls:\n" + exception);            
        }
    }
}
