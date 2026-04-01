package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import typerunner.backend.GameEngine;
import typerunner.backend.Level;
import typerunner.frontend.ScreenNavigator;

public class SelectLevelController {
    /*message text field */
    @FXML private Text message;
    public void highSchool(ActionEvent e){
        System.out.println("high school");
        GameEngine.getInstance().setLevel(Level.HIGHSCHOOL);
        if(GameEngine.getInstance().getLevel() == Level.HIGHSCHOOL){
            message.setText("level changed to high school");
        }else{
            message.setText("The level did not change.");
        }
        
    }

    public void college(ActionEvent e){
        System.out.println("college");
        GameEngine.getInstance().setLevel(Level.COLLEGE);
        if(GameEngine.getInstance().getLevel() == Level.COLLEGE){
            message.setText("level changed to College");
        }else{
            message.setText("The level did not change.");
        }
    }

    public void olympics(ActionEvent e){
        System.out.println("olympics");
        GameEngine.getInstance().setLevel(Level.OLYMPICS);
        if(GameEngine.getInstance().getLevel() == Level.OLYMPICS){
            message.setText("level changed to olympics");
        }else{
            message.setText("The level did not change.");
        }
    }

    public void backButton(ActionEvent e) throws IOException{
        System.out.println("back");
        ScreenNavigator.switchScene(e, "fxml/player-screen.fxml");
    }
}
