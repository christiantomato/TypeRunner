package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class MenuController {

    public void goToLoginPage(ActionEvent e) throws IOException {
        System.out.println("going to login page");
        ScreenNavigator.switchScene(e, "fxml/login.fxml");
    }

     public void goToLeaderboard(ActionEvent e) {
        System.out.println("going to leaderboard");
    }
    
    public void goToTutorial(ActionEvent e) {
        System.out.println("going to tutorial");
    }
    
    public void goToAdminControls(ActionEvent e) throws IOException{
        System.out.println("going to passkey page");
        ScreenNavigator.switchScene(e, "fxml/admin-passkey.fxml");
    }
    
    public void exit(ActionEvent e) throws IOException {
        System.out.println("exiting TypeRunner");
        ScreenNavigator.closeStage(e);
    }
}
