package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class AccountManagementController {
    
    public void returnToAdminControls(ActionEvent e) throws IOException {
        System.out.println("returning to admin controls");
        ScreenNavigator.switchScene(e, "fxml/admin-controls.fxml");
    }

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
}
