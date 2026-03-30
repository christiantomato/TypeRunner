package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import typerunner.frontend.ScreenNavigator;

public class SelectLevelController {
    public void highSchool(ActionEvent e){
        System.out.println("high school");
    }

    public void college(ActionEvent e){
        System.out.println("college");
    }

    public void olympics(ActionEvent e){
        System.out.println("olympics");
    }

    public void backButton(ActionEvent e) throws IOException{
        System.out.println("back");
        ScreenNavigator.switchScene(e, "fxml/player-screen.fxml");
    }
}
