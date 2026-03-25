package typerunner.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class menuController {

    public void loginPage(ActionEvent e) throws IOException {
        System.out.println("going to login page");
        switchScene(e, "login.fxml");
    }

     public void viewLeaderboard(ActionEvent e) {
        System.out.println("leaderboard");
    }
    
    public void tutorial(ActionEvent e) {
        System.out.println("tutorial");
    }
    
    public void adminControls(ActionEvent e) throws IOException{
        System.out.println("admin");
        switchScene(e, "adminPasskey.fxml");
    }
    
    public void exit(ActionEvent e) throws IOException {
        System.out.println("exiting");
        //get the current stage
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //close it
        stage.close();
    }

    //helper method to swtich scenes
    private void switchScene(ActionEvent e, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = stage.getScene();
        scene.setRoot(root);
    }
}
