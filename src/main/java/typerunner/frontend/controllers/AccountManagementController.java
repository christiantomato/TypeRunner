package typerunner.frontend.controllers;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import typerunner.backend.AccountManager;
import typerunner.backend.Admin;
import typerunner.backend.Player;
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
    /** the selected player we are managing, which can also include the admin itself! */
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

        //get the instance of the account manager
        AccountManager accountManager = AccountManager.getInstance();
        //look for the administrator
        Player p = accountManager.findPlayer(username);

        //check if they are actually an admin
        if(p instanceof Admin) {
            //cast
            Admin admin = (Admin) p;
            ArrayList<String> players = admin.getPlayers();
            populatePlayerMenu(admin, players);
        }
        else {
            System.out.println("not an admin.");
        }
    }

    /**
     * Populate Player Menu
     * 
     * After identifying the administrator, populate the menu with the 
     * corresponding players under them. Each created menu item is set with an action so that
     * if it is selected, it updates visually on the GUI. 
     * Make sure we also put the admin under the player menu!
     * 
     * @param admin the administrator to add in the list too
     * @param players the list of players the admin manages    
     * @see selectPlayer
     */

    private void populatePlayerMenu(Admin admin, ArrayList<String> players) {
        //clear before populating
        this.playerMenu.getItems().clear();

        //firstly, put the admin account itself under the menu
        MenuItem adminItem = new MenuItem(admin.getUsername());
        adminItem.setOnAction(this::selectPlayer);
        this.playerMenu.getItems().add(adminItem);

        //go through all the players
        for(String username : players) {
            //create a menu item for each player
            MenuItem item = new MenuItem(username);
            //set each menu button with an action to update the menu value if it is selected
            item.setOnAction(this::selectPlayer);
            //add it to the menu 
            this.playerMenu.getItems().add(item);
        }
    }

    /**
     * Select Player
     * 
     * updates the player menu to show the user the player
     * that has been selected to manage. 
     * 
     * @param e the selection event
     */

    @FXML
    private void selectPlayer(ActionEvent e) {
        MenuItem clicked = (MenuItem) e.getSource();
        this.playerMenu.setText(clicked.getText());
        selectedPlayer = clicked.getText();
    }

    /**
     * View Player Statistics
     * 
     * displays a pop-up window for the selected player which shows all
     * of their statistics. 
     * 
     * @param e the button event
     */

    @FXML
    private void viewPlayerStatistics(ActionEvent e) {
        System.out.println("displaying player stats");

        //get the stage we are on
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        ScreenNavigator.informationPopup(
            stage,
            "Player Statistics", 
            "Statistics for " + selectedPlayer, 
            "WPM: 85\nAccuracy: 97%\nPeak WPM: 120");
        
        //TODO: implement this with the player statistics ToString
    }

    /**
     * Reset Password
     * 
     * Displays a popup where the user can set a new password for the 
     * desired player account. 
     * 
     * @param e
     */

    @FXML
    private void resetPassword(ActionEvent e) {
        //get the stage we are on
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        //create the reset password dialog
        String newPassword = ScreenNavigator.inputStringDialog(
            stage, 
            "Reset Password",
            "Resetting password for " + selectedPlayer,
            "enter new password..."
        );

        System.out.println(newPassword);
        
        //TODO: pass in the new password to backend function.
    }

    /**
     * Reset Statistics
     * 
     * Resets the statistics for the desired player account.
     * A confirmation message is displayed before action is carried out. 
     * 
     * @param e the button event
     */

    @FXML
    private void resetStatistics(ActionEvent e) {
        //get the stage we are on 
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        //display a confirmation popup
        boolean confirmed = ScreenNavigator.confirmationPopup(
            stage,
            "Reset Statistics?",
            "Are you sure you want to reset the statistics for " + selectedPlayer + " ?"
        );

        if(confirmed) {
            //TODO: call the backend method to reset the statistics
            System.out.println("resetting statistics.");
        }
    }

   /**
     * Reset Highscore
     * 
     * Resets the highscore for the desired player account.
     * A confirmation message is displayed before action is carried out. 
     * 
     * @param e the button event
     */

    @FXML
    private void resetHighscore(ActionEvent e) {
        //get the stage we are on 
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        //display a confirmation popup
        boolean confirmed = ScreenNavigator.confirmationPopup(
            stage,
            "Reset Highscore?",
            "Are you sure you want to reset the highscore for " + selectedPlayer + " ?"
        );

        if(confirmed) {
            //TODO: call the backend method to reset the highscore
            System.out.println("resetting highscore");
        }
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
            ScreenNavigator.switchScene(e, "/fxml/admin-controls.fxml");
        }

        catch(Exception exception) {
            System.out.println("exception while returning to admin controls:\n" + exception);            
        }
    }
}
