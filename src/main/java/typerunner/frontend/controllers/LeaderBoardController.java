package typerunner.frontend.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import typerunner.backend.AccountManager;
import typerunner.backend.Player;
import typerunner.frontend.ScreenNavigator;

/**
 * Controller for the Leaderboard Screen
 * 
 * Controls GUI Events on this screen. Populates the leaderboard with the 
 * highscores from each player in the database.
 * 
 * @author Christian Tamayo
 * @author Sahej Sethi
 */

public class LeaderBoardController {

    /** a sorted list of players by highscore */
    private ArrayList<Player> players;

    /*
    all the buttons, currently they are disabled and we just display a score, but in the
    future we can make it take to a new screen which displays more indepth stats about the highscore. 
    */

    /** highscore 1 */
    @FXML private Button button1;
    /** highscore 2 */
    @FXML private Button button2;
    /** highscore 3 */
    @FXML private Button button3;
    /** highscore 4 */
    @FXML private Button button4;
    /** highscore 5 */
    @FXML private Button button5;
    /** highscore 6 */
    @FXML private Button button6;
    /** highscore 7 */
    @FXML private Button button7;
    /** highscore 8 */
    @FXML private Button button8;
    /** highscore 9 */
    @FXML private Button button9;
    /** highscore 10 */
    @FXML private Button button10;

    /** array list of the buttons */
    private ArrayList<Button> buttons;

    /**
     * Initalize
     * 
     * JavaFX method to initalize an inital state for the screen.
     */

    @FXML
    private void initialize() {
        //get the sorted list of players
        this.players = AccountManager.getInstance().sortByHighscore();

        //initalize the buttons list
        this.buttons = new ArrayList<>();

        //add all of the buttons
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button10);

        //write the text on them for all the players, but max 10!
        for(int i = 0; i < players.size() && i < 10; i++) {
            //get the player
            Player p = players.get(i);
            //set the text
            buttons.get(i).setText((i + 1) + ". " + p.getUsername() + " score: " + p.getStatistics().getHighscore().getScoreValue());
        }
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
