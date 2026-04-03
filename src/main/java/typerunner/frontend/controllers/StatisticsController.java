package typerunner.frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import typerunner.backend.LoginManager;
import typerunner.backend.Player;
import typerunner.frontend.ScreenNavigator;

/**
 * Controller for Statistics Screen
 * 
 * Simply Displays all the stats for the player. 
 * 
 * @author Christian Tamayo
 * @author Sahej Sethi
 */

public class StatisticsController {

    /** the text where the to string will go */
    @FXML private Text statsText;

    /**
     * Initalize
     * 
     * JavaFX method to initalize an inital state for the screen,
     * loading the player stats. 
     */

    @FXML
    private void initialize() {
        //get currently logged in
        Player player = LoginManager.getInstance().getCurrentUser();
        //set the text using the to string
        statsText.setText(player.getStatistics().toString());
    }

   /**
     * Return to Player Screen
     * 
     * Returns back to the player screen
     * 
     * @param e the button event
     */
    
    @FXML
    private void returnToPlayerScreen(ActionEvent e) {
        try {
            System.out.println("going back to player screen");
            ScreenNavigator.switchScene(e, "/fxml/menu.fxml");
        } 

        catch(Exception exception) {
            System.out.println("exception going back to player screen:\n" + exception);
        }
    }
}
