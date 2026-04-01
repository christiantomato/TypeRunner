package typerunner.frontend.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import typerunner.backend.GameEngine;
import typerunner.backend.Word;
import typerunner.frontend.ScreenNavigator;
import typerunner.backend.Dictionary;

public class GameScreenController implements Initializable {
    @FXML private Text currLevel;
    @FXML private Text paragraph;

    public static final int BASE_WORDS = 25;
    public static final int MAX = 5460;

    public void backButton(ActionEvent e) throws IOException{
        System.out.println("back");
        ScreenNavigator.switchScene(e, "/fxml/player-screen.fxml");
    }

    public void startGame(ActionEvent e){
        paragraph.setText("");
        System.out.println("start");

        ArrayList<Word> list = new ArrayList<>();
        int multiplier = GameEngine.getInstance().getLevel().getDifficulty();
        int numWords = BASE_WORDS * multiplier;

        Dictionary dictionary = new Dictionary();
        Random random = new Random();
        int randomIndex = random.nextInt(MAX);
        
        list.add(dictionary.getWordList().get(randomIndex));
        paragraph.setText(list.get(0).getFullText());
        for(int i=1; i < numWords; i++){
            randomIndex = random.nextInt(MAX);
            list.add(dictionary.getWordList().get(randomIndex));
            paragraph.setText(paragraph.getText() + " " + list.get(i).getFullText());
        }

        
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        currLevel.setText(GameEngine.getInstance().getLevel().name());
    }
}
