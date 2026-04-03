package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import typerunner.backend.GameEngine;
import typerunner.backend.Level;
import typerunner.backend.LoginManager;
import typerunner.frontend.ScreenNavigator;

public class SelectLevelController {
    /*message text field */
    @FXML private Text message;
    @FXML private Circle highschoolCircle;
    @FXML private Circle collegeCircle;
    @FXML private Circle olympicsCircle;
    @FXML private Button collegeButton;
    @FXML private Button olympicsButton;

    @FXML
    public void initialize(){
        //intitially disable buttons
        collegeButton.setDisable(true);
        olympicsButton.setDisable(true);

        //check player level and enable buttons accordingly
        if(LoginManager.getInstance().getCurrentUser().getStatistics().getLevel() == Level.COLLEGE){
            collegeButton.setDisable(false);
        }else if(LoginManager.getInstance().getCurrentUser().getStatistics().getLevel() == Level.OLYMPICS){
            collegeButton.setDisable(false);
            olympicsButton.setDisable(false);
        }

        if(GameEngine.getInstance().getLevel() == Level.HIGHSCHOOL){
            highschoolCircle.getStyleClass().add("clicked");
        }else if(GameEngine.getInstance().getLevel() == Level.COLLEGE){
            collegeCircle.getStyleClass().add("clicked");
        }else{
            olympicsCircle.getStyleClass().add("clicked");
        }
    }

    private void removeColour(){
        highschoolCircle.getStyleClass().remove("clicked");
        collegeCircle.getStyleClass().remove("clicked");
        olympicsCircle.getStyleClass().remove("clicked");
    }

    public void highSchool(ActionEvent e){
        removeColour();

        System.out.println("high school");
        GameEngine.getInstance().setLevel(Level.HIGHSCHOOL);
        if(GameEngine.getInstance().getLevel() == Level.HIGHSCHOOL){
            message.setText("level changed to high school");
        }else{
            message.setText("The level did not change.");
        }
        highschoolCircle.getStyleClass().add("clicked");
    }

    public void college(ActionEvent e){
        removeColour();

        System.out.println("college");
        GameEngine.getInstance().setLevel(Level.COLLEGE);
        if(GameEngine.getInstance().getLevel() == Level.COLLEGE){
            message.setText("level changed to College");
        }else{
            message.setText("The level did not change.");
        }

        collegeCircle.getStyleClass().add("clicked");
    }

    public void olympics(ActionEvent e){
        removeColour();

        System.out.println("olympics");
        GameEngine.getInstance().setLevel(Level.OLYMPICS);
        if(GameEngine.getInstance().getLevel() == Level.OLYMPICS){
            message.setText("level changed to olympics");
        }else{
            message.setText("The level did not change.");
        }

        olympicsCircle.getStyleClass().add("clicked");
    }

    public void returnToMenu(ActionEvent e) throws IOException{
        removeColour();

        System.out.println("back");
        ScreenNavigator.switchScene(e, "/fxml/player-screen.fxml");
    }
}
