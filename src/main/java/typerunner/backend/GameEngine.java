package typerunner.backend;

/**
 * Game Engine
 * 
 * Responsible for managing the overall game state and logic of the TypeRunner game.
 * 
 * @author Christian Tamayo
 * @author Noh Woldetinsae
 * @author Olorunfemi Martins
 * @author Sahej Sethi
*/

public class GameEngine {

    /** the single instance of the game engine */
    private static GameEngine instance;
    /** the current race being played out */
    private Race currentRace;
    /** the level of the current race */
    private Level currentLevel = Level.HIGHSCHOOL;
    /** flag for game running */
    private boolean isGameRunning;

    /**
     * Game Engine Constructor
     * 
     * Private constructor to construct a single instance of the game engine. 
     */

    private GameEngine(){
        this.currentRace = null;
        this.isGameRunning = false;
    }

    /**
     * Get Instance
     * 
     * Gets the singular instance, and creates it if not initalized yet. 
     * 
     * @return the singular instance
     */

    public static GameEngine getInstance(){
        if (instance == null){
            instance = new GameEngine();
        }
        return instance;
    }

    /**
     * Start Game
     * 
     * Starts the game. 
     */

    public void startGame() {
        isGameRunning = true;
    }

    /**
     * Update Game
     * 
     * Called constantly to update stats
     */

    public void updateGame() {
        // Update game state, check for win/loss conditions, etc.
        currentRace.updateAccuracy();
        currentRace.updateWpm();
        //currentRace.updateStamina();
    }

    /**
     * End Game
     * 
     * Ends the game. 
     */

    public void endGame() {
        isGameRunning = false;
    }

    /**
     * Set Current Race
     * 
     * Setter for the current race.
     */

    public void setCurrentRace(Race newRace) {
        this.currentRace = newRace;
    }

    /**
     * Get Current Race
     * 
     * Getter for the current race. 
     * 
     * @return the current race
     */

    public Race getCurrentRace() {
        return this.currentRace;
    }


    /**
     * Set Level
     * 
     * Setter for the level of the game.
     * 
     * @param level the level of the game
     */

    public void setLevel(Level level){
        this.currentLevel = level;
    }

    /**
     * Get Level
     * 
     * Getter for the level of the game.
     * 
     * @return the current level
     */

    public Level getLevel(){
        return this.currentLevel;
    }

    public boolean isGameRunning() {
        return this.isGameRunning;
    }
}
