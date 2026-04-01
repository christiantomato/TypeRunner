package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class StatisticsController {
    public void backButton(ActionEvent e) throws IOException{
        System.out.println("back");
        ScreenNavigator.switchScene(e, "/fxml/player-screen.fxml");
    }
}
