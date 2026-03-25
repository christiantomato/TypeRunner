package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class AdminControlsController {

    public void accountManage(ActionEvent e) throws IOException{
        System.out.println("Account Management");
        ScreenNavigator.switchScene(e, "fxml/accountManagement.fxml");
    }

    public void createAccount(ActionEvent e) throws IOException{
        System.out.println("Create Account");
        ScreenNavigator.switchScene(e, "fxml/createAccount.fxml");
    }

    public void adminBack(ActionEvent e) throws IOException{
        System.out.println("Back Button");
        ScreenNavigator.switchScene(e, "fxml/menu.fxml");
    }
}
