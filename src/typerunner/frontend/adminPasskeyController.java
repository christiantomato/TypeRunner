package typerunner.frontend;

import java.io.IOException;

import javafx.event.ActionEvent;

public class adminPasskeyController {
    
    public void mainMenu(ActionEvent e) throws IOException {
        sceneNavigator.switchScene(e, "menu.fxml");
    }

}
