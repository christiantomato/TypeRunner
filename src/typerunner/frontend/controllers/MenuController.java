package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class MenuController {

    public void loginPage(ActionEvent e) throws IOException {
        System.out.println("going to login page");
        ScreenNavigator.switchScene(e, "fxml/login.fxml");
    }

    public void viewLeaderboard(ActionEvent e) throws IOException{
        System.out.println("leaderboard");
        ScreenNavigator.switchScene(e, "fxml/leaderboard.fxml");
    }
    
    public void tutorial(ActionEvent e) {
        System.out.println("tutorial");
    }
    
    public void adminControls(ActionEvent e) throws IOException{
        System.out.println("admin");
        ScreenNavigator.switchScene(e, "fxml/admin-passkey.fxml");
    }
    
    public void exit(ActionEvent e) throws IOException {
        System.out.println("exiting TypeRunner");
        ScreenNavigator.closeStage(e);
    }
}
