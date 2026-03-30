package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class PlayerScreenController {
    public void newGame(ActionEvent e) throws IOException{
        System.out.println("new game");
        ScreenNavigator.switchScene(e, "fxml/game-screen.fxml");
    }

    public void selectLevel(ActionEvent e) throws IOException{
        System.out.println("select level");
        ScreenNavigator.switchScene(e, "fxml/select-level.fxml");
    }

    public void viewStats(ActionEvent e) throws IOException{
        System.out.println("statistics");
        ScreenNavigator.switchScene(e, "fxml/statistics.fxml");
    }

    public void logOut(ActionEvent e) throws IOException{
        System.out.println("log out");
        ScreenNavigator.switchScene(e, "fxml/login.fxml");
    }
}
