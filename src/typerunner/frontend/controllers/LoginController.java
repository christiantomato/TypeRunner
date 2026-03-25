package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class LoginController {

    /** 
     * Player Login
     * 
     * @param e
     * @throws IOException
    */

    public void login(ActionEvent e) throws IOException {

        /*
        get the username and password as strings
        pass into the login method login(username, password)
        if return is true, switch scenes to the player screen. 
        */

        ScreenNavigator.switchScene(e, "fxml/player-screen.fxml");
    }
    
    public void returnToMenu(ActionEvent e) throws IOException {
        System.out.println("going back to menu page");
        ScreenNavigator.switchScene(e, "fxml/menu.fxml");
    }
}
