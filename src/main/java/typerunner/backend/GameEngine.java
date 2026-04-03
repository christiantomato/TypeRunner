package typerunner.backend;

/**
 * Game Engine
 * 
 * Responsible for starting and stopping the game state and managing over-arching logic. 
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
    private Level currentLevel;
    /** toggle for instant death */
    private boolean instantDeath;
    /** flag for game running */
    private boolean isGameRunning;

    /**
     * Game Engine Constructor
     * 
     * Private constructor to construct a single instance of the game engine.
     * Initalizes default values for a race.
     */

    private GameEngine(){
        this.currentRace = null;
        this.currentLevel = Level.HIGHSCHOOL;
        this.instantDeath = false;
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
     * Starts the game by setting the boolean flag. 
     */

    public void startGame() {
        isGameRunning = true;
    }

    /**
     * Update Game
     * 
     * Called constantly during a race to perform updates.  
     */

    public void updateGame() {
        //update these stats
        currentRace.updateAccuracy();
        currentRace.updateWpm();
    }

    /**
     * End Game
     * 
     * Ends the game, and most importantly writes all the statistics for the player when called. 
     */

    public void endGame() {
        System.out.println("logging game, writing statistics...");

        //get the current player
        Player player = LoginManager.getInstance().getCurrentUser();

        //update the players statistics with the stats tracked from completed race
        player.getStatistics().updateStats(
            currentRace.getWpm(), 
            currentRace.getPeakWPM(), 
            currentRace.getAccuracy(), 
            this.currentLevel,
            currentRace.getErrorCount(), 
            currentRace.getTimeInSeconds(), 
            currentRace.getScore(), 
            currentRace.getTypedWords());
        //write the changes
        AccountManager.getInstance().saveAccounts(); 

        //update flag
        this.isGameRunning = false;
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
     * Get Level
     * 
     * Getter for the level of the game.
     * 
     * @return the current level
     */

    public Level getLevel(){
        return this.currentLevel;
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
     * Get Instant Death
     * 
     * Getter for instant death mode.
     * 
     * @return the boolean
     */

    public boolean getInstantDeath(){
        return this.instantDeath;
    }

    /**
     * Set Instant Death
     * 
     * Setter for the instant death mode.
     * 
     * @param toggle true = instant death, false = normal
     */

    public void setInstantDeath(Boolean toggle){
        this.instantDeath = toggle;
    }

    /**
     * Is Game Running 
     * 
     * Getter for game running flag. 
     * 
     * @return true if the game is running, false otherwise
     */

    public boolean isGameRunning() {
        return this.isGameRunning;
    }

    /**
     * Setter for Game Running
     * 
     * Sets the boolean.
     * Important when we want to end the game, but not write the statistics!
     * 
     * @param bool value
     */

    public void setGameRunning(boolean bool) {
        this.isGameRunning = bool;
    }
}
