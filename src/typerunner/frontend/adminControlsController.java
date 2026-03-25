package typerunner.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;

public class adminControlsController {

    public void accountManage(ActionEvent e) throws IOException{
        System.out.println("Account Management");
        sceneNavigator.switchScene(e, "accountManagement.fxml");
    }

    public void createAccount(ActionEvent e) throws IOException{
        System.out.println("Create Account");
        sceneNavigator.switchScene(e, "createAccount.fxml");
    }

    public void adminBack(ActionEvent e) throws IOException{
        System.out.println("Back Button");
        sceneNavigator.switchScene(e, "menu.fxml");
    }
}
