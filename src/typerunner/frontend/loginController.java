package typerunner.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;

public class loginController {
    
    public void mainMenu(ActionEvent e) throws IOException {
        System.out.println("going back to menu page");
        sceneNavigator.switchScene(e, "menu.fxml");
    }
}
