package typerunner.frontend;

import java.io.IOException;

import javafx.event.ActionEvent;

public class AdminPasskeyController {
    
    public void mainMenu(ActionEvent e) throws IOException {
        ScreenNavigator.switchScene(e, "menu.fxml");
    }

}
