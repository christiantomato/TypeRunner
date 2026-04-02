package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class LeaderboardIndividualStats {
    public void returnToMenu(ActionEvent e) throws IOException {
        System.out.println("back");
        ScreenNavigator.switchScene(e, "/fxml/leaderboard.fxml");
    }
}
