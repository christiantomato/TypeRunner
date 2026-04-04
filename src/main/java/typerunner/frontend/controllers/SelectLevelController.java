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

/**
 * Java Controller to handle the user selecting their level
 * 
 * @author Sahej
 */
public class SelectLevelController {
    /*message text field */
    @FXML private Text message;
    /*circle within highschool button */
    @FXML private Circle highschoolCircle;
    /*cicle within college button */
    @FXML private Circle collegeCircle;
    /*cicle within the olympics button */
    @FXML private Circle olympicsCircle;
    /*college button */
    @FXML private Button collegeButton;
    /*olympics button */
    @FXML private Button olympicsButton;

    @FXML
    public void initialize(){
        //intitially disable buttons
        collegeButton.setDisable(true);
        olympicsButton.setDisable(true);

        //check player level unlocked and enable buttons accordingly
        if(LoginManager.getInstance().getCurrentUser().getStatistics().getLevel() == Level.COLLEGE){
            collegeButton.setDisable(false);
        }else if(LoginManager.getInstance().getCurrentUser().getStatistics().getLevel() == Level.OLYMPICS){
            collegeButton.setDisable(false);
            olympicsButton.setDisable(false);
        }
        //adding clicked to button style classes so they corrispond to the correct code in css
        if(GameEngine.getInstance().getLevel() == Level.HIGHSCHOOL){
            highschoolCircle.getStyleClass().add("clicked");
        }else if(GameEngine.getInstance().getLevel() == Level.COLLEGE){
            collegeCircle.getStyleClass().add("clicked");
        }else{
            olympicsCircle.getStyleClass().add("clicked");
        }
    }

    /**
     * insures no button is clicked
     */
    private void removeColour(){
        highschoolCircle.getStyleClass().remove("clicked");
        collegeCircle.getStyleClass().remove("clicked");
        olympicsCircle.getStyleClass().remove("clicked");
    }

    /**
     * The user clicked the highschool button
     * @param e
     */
    public void highSchool(ActionEvent e){
        //set any button that may be clicked to an unclicked state
        removeColour();

        System.out.println("high school");
        //set the level
        GameEngine.getInstance().setLevel(Level.HIGHSCHOOL);
        
        //make sure the level set
        if(GameEngine.getInstance().getLevel() == Level.HIGHSCHOOL){
            message.setText("level changed to high school");
        }else{
            message.setText("The level did not change.");
        }

        //put button in a clicked state
        highschoolCircle.getStyleClass().add("clicked");
    }

    /**
     * user clicked the college button
     * @param e
     */
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

    /**
     * user clicked the olympics button
     * @param e
     */
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

    /**
     * user clicked the back button
     * @param e
     * @throws IOException
     */
    public void returnToMenu(ActionEvent e) throws IOException{
        removeColour();

        System.out.println("back");
        ScreenNavigator.switchScene(e, "/fxml/player-screen.fxml");
    }
}
