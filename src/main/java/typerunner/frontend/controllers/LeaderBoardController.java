package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class LeaderBoardController {
    
    public void mainMenu(ActionEvent e) throws IOException {
        System.out.println("Back");
        ScreenNavigator.switchScene(e, "/fxml/menu.fxml");
    }

    public void individualStats(ActionEvent e) throws IOException {
        System.out.println("individual stats");
        ScreenNavigator.switchScene(e, "/fxml/leaderboard-individual-stats.fxml");
    }
}
