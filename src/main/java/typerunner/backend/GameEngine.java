package typerunner.backend;
/* 
import javax.lang.System;
import java.text.DecimalFormat;
*/
/**
 * The GameEngine class is responsible for managing the overall game state and logic of the TypeRunner game.
 * 
*/
public class GameEngine {

    private static GameEngine instance;

    private Player currentPlayer;
    private Race currentRace;
    private boolean isGameRunning;

    private GameEngine( ){
        
    }

    public static GameEngine getInstance(){
        if (instance == null){
            instance = new GameEngine();
        }
        return instance;
    }

    public void init(Player player) {
        this.currentPlayer = player;
        //this.currentRace = new  Race();
        this.isGameRunning = true;
    }

    public void startGame() {

        // Initialize game stat
        isGameRunning = true;
    }
    public void updateGame() {
        // Update game state, check for win/loss conditions, etc.
    }

    public void endGame() {
        // Handle end of game logic, such as displaying results, saving stats, etc.
        isGameRunning = false;
    }

    public void setLevel(Level level){
        this.currentRace.setLevel(level);
    }

    public Level getLevel(){
        return this.currentRace.getLevel();
    }

    // 
    public void processKey(char input){

    }




    
}
