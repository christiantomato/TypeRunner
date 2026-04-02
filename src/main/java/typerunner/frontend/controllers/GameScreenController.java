package typerunner.frontend.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import typerunner.backend.GameEngine;
import typerunner.backend.Race;
import typerunner.frontend.ScreenNavigator;

/**
 * Game Screen Controller
 * 
 * Controlls the GUI logic for the game screen
 * 
 * @author Sahej Sethi
 * @author Christian Tamayo
 */

public class GameScreenController implements Initializable {

    /** the current level user is on (high school, college, olympics) */
    @FXML private Text currLevel;
    /** the paragraph text that they need to type out */
    @FXML private TextFlow paragraph;
    /** the text area where they type out the words */
    @FXML private TextArea inputField;
    /** live display of wpm */
    @FXML private Text wpm;
    /** live display of time */
    @FXML private Text time;
    /** live display of score */
    @FXML private Text score;
    /** live display of peak wpm */
    @FXML private Text peakWpm;
    /** live display of health or "stamina" */
    @FXML private Text health;

    /** the actual string of text they are typing */
    private String targetText;
    /** a list storing which letters are correct */
    private ArrayList<Boolean> correctness; 
    /** timeline to constantly update stats */
    private Timeline gameLoop;
    /** boolean to make sure game has been setup before user starts typing */
    private boolean gameIsSetup;

    /**
     * Back to Player Screen
     * 
     * Takes the user back to the player screen. 
     * 
     * @param e the button event
     */

    @FXML
    private void backButton(ActionEvent e) throws IOException{
        try {
            //if the game is running set the running var to false
            if(GameEngine.getInstance().isGameRunning()) {
                GameEngine.getInstance().setGameRunning(false);
                System.out.println("going back to player screen");
                ScreenNavigator.switchScene(e, "/fxml/player-screen.fxml");
            }
        } 

        catch(Exception exception) {
            System.out.println("exception going back to player screen:\n" + exception);
        }
    }

    /**
     * Setup Game
     * 
     * Sets the game with the initial conditions.
     * 
     * *String Builder Parsing with help of ChatGPT*
     * 
     * @param e the button event
     */

    @FXML
    private void setupGame(ActionEvent e) {
        //clear before setting up
        paragraph.getChildren().clear();
        System.out.println("starting game");

        //create a new race and set it to the game engine, and start the game
        Race newRace = new Race();
        GameEngine.getInstance().setCurrentRace(newRace);
        GameEngine.getInstance().startGame();

        //initalize correctness array
        this.correctness = new ArrayList<>();

        targetText = newRace.getRaceText();

        //add it to the text flow
        Text textNode = new Text(targetText);
        paragraph.getChildren().add(textNode);

        //for debugging
        System.out.println(targetText);

        gameIsSetup = true;

        //every 100 mills, update stats
        gameLoop = new Timeline(new KeyFrame(Duration.millis(100), event -> updateStats()));
        //update indefinitely
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }

    /**
     * On Key Pressed
     * 
     * Listens for specific keys pressed like backspaces, so we can update index accordingly
     * 
     * @param e the key event
     */

    @FXML
    private void onKeyPressed(KeyEvent e) {
        //listen for backspaces
        if(e.getCode() == KeyCode.BACK_SPACE) {
            System.out.println("BACKSPACE pressed");
            //get the back end to handle logic for backspace pressed
            GameEngine.getInstance().getCurrentRace().handleBackspace();
            //update the frontend
            if (!correctness.isEmpty()) {
                correctness.remove(correctness.size() - 1);
            }
            return;
        }
    }

    /**
     * Get Key Input
     * 
     * Gets the key that was pressed inside the text area
     */

    @FXML
    private void getKeyInput(KeyEvent e) {
        if(gameIsSetup) {
            //get the key that has been typed
            String inputCharAsString = e.getCharacter();
            System.out.println(inputCharAsString);

            //boolean for if they typed correct char
            boolean correctCharTyped = false;

            //safety check 
            if(!inputCharAsString.isEmpty()) {
                char inputChar = inputCharAsString.charAt(0);

                //check for backspace character on windows machines, and ignore
                if(inputChar == '\b'){
                    System.out.println("backspace detected, ignoring input char (for windows)");
                    return;
                }

                //check the input in the backend and return bool
                correctCharTyped = GameEngine.getInstance().getCurrentRace().checkInput(inputChar);
                System.out.println("correct input? " + correctCharTyped);
                //add it to our correct ness list
                correctness.add(correctCharTyped);

                //based on the result, update paragraph text
                updateParagraphText();
            }
            else {
                System.out.println("nothing inputted (for mac)");
            }
        }
        else {
            System.out.println("game not setup yet.");
        }  
    }

    /**
     * Update Paragraph Text
     * 
     * Gives feedback on characters that are being correctly or incorrectly typed
     */

    private void updateParagraphText() {
        //clear old
        paragraph.getChildren().clear();

        //build charcter by character based on if its correct or not
        for(int i = 0; i < targetText.length(); i++) {
            //get the char at the index
            Text t = new Text(String.valueOf(targetText.charAt(i)));

            if(i < correctness.size()) {
                //if correct
                if(correctness.get(i)) {
                    t.setStyle("-fx-fill: green;");
                } 
                //if wrong
                else {
                    t.setStyle("-fx-fill: red;");
                }
            }

            //add it to the flow
            paragraph.getChildren().add(t);
        }
    }

    /**
     * Update Statistics
     * 
     * Gets the current statistics from the backend to display on the frontend
     */

    private void updateStats() {
        //System.out.println("UPDATING STATS");
        //get the race that is happening
        Race race = GameEngine.getInstance().getCurrentRace();
         
        //set the stats
        wpm.setText(String.valueOf(race.getWpm()));
        time.setText(String.valueOf(race.getTimeInSeconds()));
        score.setText(String.valueOf(race.getScore()));
        peakWpm.setText(String.valueOf(race.getPeakWPM()));
        health.setText(String.valueOf(race.getStamina()));

        if(!GameEngine.getInstance().isGameRunning()) {
            gameLoop.stop();
        }
    }

    /**
     * Initalize Method
     * 
     * idk what this really is yet ill look into it gang
     */

    public void initialize(URL arg0, ResourceBundle arg1) {
        //set the level title 
        currLevel.setText(GameEngine.getInstance().getLevel().name());
    }
}
