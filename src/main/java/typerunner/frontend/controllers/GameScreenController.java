package typerunner.frontend.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import typerunner.backend.GameEngine;
import typerunner.backend.Word;
import typerunner.frontend.ScreenNavigator;
import typerunner.backend.Dictionary;

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
    /** the actual string of text they are typing */
    private String targetText;
    /** boolean to make sure game has been setup before user starts typing */
    private boolean gameIsSetup;

    /** the base words */
    public static final int BASE_WORDS = 25;
    /** the max amount */
    public static final int MAX = 5460;

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
            System.out.println("going back to player screen");
            ScreenNavigator.switchScene(e, "/fxml/player-screen.fxml");
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
        System.out.println("start");

        //get difficulty and num words
        ArrayList<Word> list = new ArrayList<>();
        int multiplier = GameEngine.getInstance().getLevel().getDifficulty();
        int numWords = BASE_WORDS * multiplier;

        Dictionary dictionary = new Dictionary();
        Random random = new Random();

        //build the target text along with the words list
        StringBuilder fullText = new StringBuilder();

        int randomIndex = random.nextInt(MAX);
        list.add(dictionary.getWordList().get(randomIndex));
        fullText.append(list.get(0).getFullText());

        for(int i = 1; i < numWords; i++) {
            randomIndex = random.nextInt(MAX);
            list.add(dictionary.getWordList().get(randomIndex));
            fullText.append(" ").append(list.get(i).getFullText());
        }

        //set the target text
        targetText = fullText.toString();

        //add it to the text flow
        Text textNode = new Text(targetText);
        paragraph.getChildren().add(textNode);

        System.out.println(targetText);

        gameIsSetup = true;
    }

    /**
     * Get Key Input
     * 
     * Gets the key that was pressed inside the text area
     */

    @FXML
    private void getKeyInput(KeyEvent e) {
        if(gameIsSetup) {
            //get the text from the texfield
            String textAreaString = inputField.getText();

            //get the key that has been typed
            String inputChar = e.getCharacter();
            System.out.println(inputChar);

            
        }   
    }

    /**
     * Update Paragraph Text
     * 
     * Gives feedback on characters that are being correctly or incorrectly typed
     */

    public void updateParagraphText(boolean correct, int index) {

    }

    /**
     * Sahejs Method
     * 
     * 
     */

    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        currLevel.setText(GameEngine.getInstance().getLevel().name());
    }
}
