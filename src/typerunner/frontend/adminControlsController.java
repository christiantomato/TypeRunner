package typerunner.frontend;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class adminControlsController {
    public void accountManage (ActionEvent e) throws IOException{
        System.out.println("Account Management");
        switchScene(e, "accountManagement.fxml");
    }

    public void createAccount (ActionEvent e) throws IOException{
        System.out.println("Create Account");
        switchScene(e, "createAccount.fxml");
    }

    public void adminBack (ActionEvent e) throws IOException{
        System.out.println("Back Button");
        switchScene(e, "menu.fxml");
    }

    //helper method to swtich scenes
    private void switchScene(ActionEvent e, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        
        Scene scene = stage.getScene();
        scene.setRoot(root);
    }
}
