package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

/**
 * Controller for the Admin Controls screen
 * 
 * Handles GUI Inputs made on the screen taking the user to the correct screens following input
 * 
 * @author Sahej Sethi
 */
public class AdminControlsController {

    public void goToAccountManagement(ActionEvent e) throws IOException{
        System.out.println("going to Account Management");
        ScreenNavigator.switchScene(e, "/fxml/account-management.fxml");
    }

    public void goToCreateAccount(ActionEvent e) throws IOException{
        System.out.println("going to Account Creation");
        ScreenNavigator.switchScene(e, "/fxml/account-creation.fxml");
    }

    public void returnToMenu(ActionEvent e) throws IOException{
        System.out.println("returning to menu");
        ScreenNavigator.switchScene(e, "/fxml/menu.fxml");
    }
}
