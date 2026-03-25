package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class AccountCreationController {
    
    public void returnToAdminControls(ActionEvent e) throws IOException {
        System.out.println("returning to admin controls");
        ScreenNavigator.switchScene(e, "fxml/admin-controls.fxml");
    }
}
