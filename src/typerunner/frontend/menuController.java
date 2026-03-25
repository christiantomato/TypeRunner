package typerunner.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;

public class MenuController {

    public void loginPage(ActionEvent e) throws IOException {
        System.out.println("going to login page");
        SceneNavigator.switchScene(e, "login.fxml");
    }

     public void viewLeaderboard(ActionEvent e) {
        System.out.println("leaderboard");
    }
    
    public void tutorial(ActionEvent e) {
        System.out.println("tutorial");
    }
    
    public void adminControls(ActionEvent e) throws IOException{
        System.out.println("admin");
        SceneNavigator.switchScene(e, "admin-passkey.fxml");
    }
    
    public void exit(ActionEvent e) throws IOException {
        System.out.println("exiting TypeRunner");
        SceneNavigator.closeStage(e);
    }
}
