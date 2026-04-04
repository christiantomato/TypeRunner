package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import typerunner.backend.LoginManager;
import typerunner.frontend.ScreenNavigator;

/**
 * Player Screen Controller
 * 
 * Handles logic on this page. 
 * 
 * @author Sahej Singh
 * @author Christian Tamayo
 */

public class PlayerScreenController {

    /** the text for the current player */
    @FXML private Text currentPlayer;

    /**
     * Initalize
     * 
     * JavaFX method to initalize an inital state for the screen.
     */

    @FXML
    private void initialize() {
        //get the login manager so we can see who is logged in
        LoginManager loginManager = LoginManager.getInstance();
        
        //check if we are logged in
        if(loginManager.isLoggedIn()) {
            //get the username
            String username = loginManager.getCurrentUser().getUsername();
            //display it
            currentPlayer.setText(username);
        }
    }

    /**
     * methods that take gui button presses and send the player to the appropriate screen
     * @param e
     * @throws IOException
     */
    public void newGame(ActionEvent e) throws IOException{
        System.out.println("new game");
        ScreenNavigator.switchScene(e, "/fxml/game-screen.fxml");
    }

    public void selectLevel(ActionEvent e) throws IOException{
        System.out.println("select level");
        ScreenNavigator.switchScene(e, "/fxml/select-level.fxml");
    }

    public void viewStats(ActionEvent e) throws IOException{
        System.out.println("statistics");
        ScreenNavigator.switchScene(e, "/fxml/statistics.fxml");
    }

    public void logOut(ActionEvent e) throws IOException{
        System.out.println("log out");

        //get the login manager so we can log out
        LoginManager loginManager = LoginManager.getInstance();
        loginManager.logout();

        ScreenNavigator.switchScene(e, "/fxml/menu.fxml");
    }
}
