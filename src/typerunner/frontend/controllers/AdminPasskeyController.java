package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class AdminPasskeyController {
    
    public void mainMenu(ActionEvent e) throws IOException {
        ScreenNavigator.switchScene(e, "fxml/menu.fxml");
    }

    //TODO: toggle the visibility of the textfield
    public void togglePasskey(ActionEvent e) {
        System.out.println("toggles visibility");
    }
}
