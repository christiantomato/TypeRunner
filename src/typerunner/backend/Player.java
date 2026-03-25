package typerunner.backend;

/**
 * Represents one player in the TypeRunner game
 * Stores the player's ID, username, scores, and unlocked level
 * 
 * @author Tanya Sahota
 * @version 1.0
 */
public class Player { 

    /** Unique ID for the player */
    private String id; 
    /** Username for the player */
    private String username;
    /** Total games the user has played */
    private int totalGames; 
    /** User's total score across all games */
    private int totalScore;
    /** User's best score yet in a single game */
    private int bestScore;
    /** Highest level unlocked by the user */
    private int unlockedLevel;
    /** User's password for authentication */
    private String password;
    /** Isadmin verification */
    private boolean isAdmin = false;
    /** 
     * Creates a new player with the given ID and username
     * All starting stats are set to default
     * @param id the unique ID of the player
     * @param username the username of the player
     */
    public Player(String id, String username, String password, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        /* Start with 0 total games */
        this.totalGames = 0;
        /* Start with total score = 0 */
        this.totalScore = 0;
        /* Start with best score = 0 */
        this.bestScore = 0; 
        /* Start with unlocked level 1 */
        this.unlockedLevel = 1; 
    }
    /** 
     * Gets player ID
     * @return the player's ID
     */
    public String getId() { 
        return id;
    }
    /** 
     * Gets player username
     * @return player's username
     */
    public String getUsername() { 
        return username; 
    }
    /** 
     * Update player stats after game is finished
     * 
     * @param score the score the player got in the completed game
     */
    public void recordGame(int score) {
    totalGames++;
    totalScore += score;

    if (score > bestScore) {
        bestScore = score;
    }
}
    /** 
     * Get user best score
     * @return player's best score
     */
    public int getBestScore() {
        return bestScore;
    }
    /** 
     * Get highest unlocked level
     * @return highest unlocked level
     */
    public int getUnlockedLevel() { 
        return unlockedLevel;
    }
    /** 
     * Set the player's unlocked level
     * @param unlockedLevel
     */
    public void setUnlockedLevel(int unlockedLevel) {
        this.unlockedLevel = unlockedLevel;
    }
    /** 
     * Reset all stats back to default
     */
    public void resetStats() {
        this.totalGames = 0;
        this.totalScore = 0;
        this.bestScore = 0;
        this.unlockedLevel = 1;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }


    

    
    
}