package typerunner.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;

public class AdminControlsController {

    public void accountManage(ActionEvent e) throws IOException{
        System.out.println("Account Management");
        ScreenNavigator.switchScene(e, "accountManagement.fxml");
    }

    public void createAccount(ActionEvent e) throws IOException{
        System.out.println("Create Account");
        ScreenNavigator.switchScene(e, "createAccount.fxml");
    }

    public void adminBack(ActionEvent e) throws IOException{
        System.out.println("Back Button");
        ScreenNavigator.switchScene(e, "menu.fxml");
    }
}
