package typerunner.frontend.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;
import typerunner.backend.Bot;
import typerunner.backend.GameEngine;
import typerunner.backend.Race;
import typerunner.frontend.ScreenNavigator;

/**
 * Game Screen Controller
 * Controlls the GUI logic for the game screen
 * * @author Sahej Sethi
 * @author Christian Tamayo
 */

public class GameScreenController implements Initializable {

    @FXML private Text currLevel;
    @FXML private TextFlow paragraph;
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

    
    // --- FXML INJECTIONS FOR MOVEMENT AND UI ---
    @FXML private Rectangle player1; // Human Player
    @FXML private Rectangle player2; // Bot 1
    @FXML private Rectangle player3; // Bot 2 
    @FXML private Rectangle player4; // Bot 3
    @FXML private Rectangle player5; // Bot 4
    
    

    private String targetText;
    private ArrayList<Boolean> correctness; 
    /** timeline to constantly update stats */
    private Timeline gameLoop;
    private boolean gameIsSetup;

    public static final int BASE_WORDS = 25;
    public static final int MAX = 5460;

    // --- VARIABLES FOR MOVEMENT & BOT LOGIC ---
    // Expanded track length to reach the checkered boxes
    private double trackLength = 400.0; 
    private double distancePerChar;
    private AnimationTimer uiUpdater;
    
    // List to keep track of all bot timelines
    private List<Timeline> botTimelines = new ArrayList<>();

    @FXML
    private void backButton(ActionEvent e) throws IOException {
        if (uiUpdater != null) uiUpdater.stop();
        stopAllBots();

        try {
            //if the game is running set the running var to false
            if(GameEngine.getInstance().isGameRunning()) {
                GameEngine.getInstance().setGameRunning(false);
            }
            System.out.println("going back to player screen");
            ScreenNavigator.switchScene(e, "/fxml/player-screen.fxml");
        } catch(Exception exception) {
            System.out.println("exception going back to player screen:\n" + exception);
        }
    }

    @FXML
    private void setupGame(ActionEvent e) {
        paragraph.getChildren().clear();
        System.out.println("starting game");

        //create a new race and set it to the game engine, and start the game
        correctness = new ArrayList<>();

        Race newRace = new Race();
        GameEngine.getInstance().setCurrentRace(newRace);
        GameEngine.getInstance().startGame();

        //initalize correctness array
        this.correctness = new ArrayList<>();

        targetText = newRace.getRaceText();

        Text textNode = new Text(targetText);
        paragraph.getChildren().add(textNode);
        gameIsSetup = true;

        //every 100 mills, update stats
        gameLoop = new Timeline(new KeyFrame(Duration.millis(100), event -> updateStats()));
        //update indefinitely
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();

        // --- STARTUP LOGIC FOR MOVEMENT ---
        // Calculate how much the player moves per correct keystroke
        distancePerChar = trackLength / targetText.length();

        // Clear any old timelines
        botTimelines.clear();

        // Create all 4 bots
        Bot bot1 = new Bot("Robo 1");
        Bot bot2 = new Bot("Robo 2");
        Bot bot3 = new Bot("Robo 3");
        Bot bot4 = new Bot("Robo 4");

        // Start them all moving
        startBotMovement(bot1, player2);
        startBotMovement(bot2, player3);
        startBotMovement(bot3, player4);
        startBotMovement(bot4, player5);

        // Start background UI tasks
        startLiveUIUpdate();
        
        inputField.requestFocus();
    }

    @FXML
    private void onKeyPressed(KeyEvent e) {
        if(e.getCode() == KeyCode.BACK_SPACE) {
            GameEngine.getInstance().getCurrentRace().handleBackspace();
            if (!correctness.isEmpty()) {
                correctness.remove(correctness.size() - 1);
            }

            // Move the player backwards visually (prevent them from going past the start line)
            player1.setTranslateX(Math.max(0, player1.getTranslateX() - distancePerChar));
            return;
        }
    }

    @FXML
    private void getKeyInput(KeyEvent e) {
        if(gameIsSetup) {
            String inputCharAsString = e.getCharacter();
            

            boolean correctCharTyped = false;

            if(!inputCharAsString.isEmpty()) {
                char inputChar = inputCharAsString.charAt(0);

                //check for backspace character on windows machines, and ignore
                if(inputChar == '\b'){
                    System.out.println("backspace detected, ignoring input char (for windows)");
                    return;
                }

                correctCharTyped = GameEngine.getInstance().getCurrentRace().checkInput(inputChar);
                correctness.add(correctCharTyped);
                updateParagraphText();
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
        for(int i = 0; i < targetText.length(); i++) {
            Text t = new Text(String.valueOf(targetText.charAt(i)));
            if(i < correctness.size()) {
                if(correctness.get(i)) {
                    t.setStyle("-fx-fill: green;");
                } else {
                    t.setStyle("-fx-fill: red;");
                }
            }
            paragraph.getChildren().add(t);
        }
    }

    // /**
    //  * Update Statistics
    //  * 
    //  * Gets the current statistics from the backend to display on the frontend
    //  */

    // private void updateStats() {
    //     //System.out.println("UPDATING STATS");
    //     //get the race that is happening
    //     Race race = GameEngine.getInstance().getCurrentRace();
         
    //     //set the stats
    //     wpm.setText(String.valueOf(race.getWpm()));
    //     time.setText(String.valueOf(race.getTimeInSeconds()));
    //     score.setText(String.valueOf(race.getScore()));
    //     peakWpm.setText(String.valueOf(race.getPeakWPM()));
    //     health.setText(String.valueOf(race.getStamina()));

    //     if(!GameEngine.getInstance().isGameRunning()) {
    //         gameLoop.stop();
    //     }
    // }

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
     * Start Bot Movement
     * Handles sliding the bot racer forward based on the difficulty level
     */
    private void startBotMovement(Bot bot, Rectangle botShape) {
        int difficulty = GameEngine.getInstance().getLevel().getDifficulty();
        int baseWpm = 40 - (difficulty * 1); 
        
        // Add random variance so they don't all tie (+/- 5 WPM)
        double botWpm = baseWpm + (Math.random() * 10 - 5);

        double charsPerSecond = (botWpm * 5.0) / 60.0;
        double distancePerSecond = charsPerSecond * distancePerChar;
        double distancePerTick = distancePerSecond / 10.0; // 10 ticks a second

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            botShape.setTranslateX(botShape.getTranslateX() + distancePerTick);
            
            // Check if the bot crossed the exact finish line
            if (botShape.getTranslateX() >= trackLength) {
                botShape.setTranslateX(trackLength); // Snap exactly to the finish line
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        botTimelines.add(timeline);
    }

    /**
     * Start Live UI Update
     * Background timer to constantly refresh WPM, time, and stamina text
     */
    private void startLiveUIUpdate() {
        uiUpdater = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Race currentRace = GameEngine.getInstance().getCurrentRace();
                if (currentRace == null) return;

                wpm.setText(String.valueOf(currentRace.getWpm()));
                time.setText(currentRace.getTimeInSeconds() + "s");
                health.setText(String.valueOf(currentRace.getStamina()));
                
                // Game Over
                if (currentRace.getStamina() <= 0) {
                    this.stop();
                    stopAllBots(); 
                    System.out.println("Game Over! Stamina depleted.");
                    inputField.setDisable(true);
                }
                
                // Player Wins
                if (currentRace.getCurrentRaceIndex() >= currentRace.getRaceText().length()) {
                    this.stop();
                    stopAllBots(); 
                    System.out.println("You finished the race!");
                    inputField.setDisable(true);
                }
            }
        };
        uiUpdater.start();
    }
    
    private void stopAllBots() {
        for (Timeline t : botTimelines) {
            if (t != null) {
                t.stop();
            }
        }
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        if(GameEngine.getInstance().getLevel() != null) {
            currLevel.setText(GameEngine.getInstance().getLevel().name());
        }
    }
}

