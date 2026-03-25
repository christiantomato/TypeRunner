package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class AdminPasskeyController {

    public void validatePasskey(ActionEvent e) throws IOException {

        /*
        get the passkey from the textfield
        pass it into the corresponding method
        if true, navigate to the admin controls
        */
        System.out.println("going to admin controls");
        ScreenNavigator.switchScene(e, "fxml/admin-controls.fxml");
    }
    
    public void mainMenu(ActionEvent e) throws IOException {
        ScreenNavigator.switchScene(e, "fxml/menu.fxml");
    }

    //TODO: toggle the visibility of the textfield
    public void togglePasskey(ActionEvent e) {
        System.out.println("toggles visibility");
    }
}
