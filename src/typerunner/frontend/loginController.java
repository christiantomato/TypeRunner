package typerunner.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;

public class LoginController {
    
    public void mainMenu(ActionEvent e) throws IOException {
        System.out.println("going back to menu page");
        ScreenNavigator.switchScene(e, "menu.fxml");
    }
}
