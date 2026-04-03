package typerunner.frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import typerunner.frontend.ScreenNavigator;

public class TutorialController {
    @FXML
    private void returnToMenu(ActionEvent e) {
        try {
            System.out.println("going back to menu page");
            ScreenNavigator.switchScene(e, "/fxml/menu.fxml");
        } 

        catch(Exception exception) {
            System.out.println("exception going back to menu:\n" + exception);
        }
    }
}
