package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class LoginController {
    
    public void mainMenu(ActionEvent e) throws IOException {
        System.out.println("going back to menu page");
        ScreenNavigator.switchScene(e, "fxml/menu.fxml");
    }
}
