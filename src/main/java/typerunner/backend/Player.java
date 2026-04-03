package typerunner.backend;

/**
 * Represents one player in the TypeRunner game
 * Stores the player's ID, username, scores, and unlocked level
 * 
 * @author Christian Tamayo
 * @author Tanya Sahota
 */

public class Player {
    /** username for the player */
    private String username;
    /** user's password for authentication */
    private String password;
    /** the statistics data object of the player */
    private PlayerStatistics statistics;
    /** boolean flag for the json parsing! */
    protected boolean isAdmin = false;

    /** 
     * Player Constructor
     * 
     * Creates a new player with the given ID and username.
     * All starting stats are set to default.
     * 
     * @param username the username of the player
     * @param password the password of the player
     * @param administrator the admin of the player
     */

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.statistics = new PlayerStatistics();
    }

    /** 
     * Get Username
     * 
     * Gets player username.
     * 
     * @return player's username
     */

    public String getUsername() { 
        return username; 
    }

    /**
     * Get Password
     * 
     * Getter for password. 
     * 
     * @return the players password
     */

    public String getPassword() {
        return password;
    }

     /**
     * Set Password
     * 
     * Sets a new password for the player. 
     * Super helpful when reseting password. 
     * 
     * @param newPassword the new password
     */

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    /**
     * Get Statistics
     * 
     * Getter for player statistics
     * 
     * @return the statistics object
     */

    public PlayerStatistics getStatistics() {
        return this.statistics;
    }
    
    /**
     * Is Admin
     * 
     * Getter for admin flag 
     * 
     * @return true if admin, false if just regular player
     */

    public boolean isAdmin() {
        return this.isAdmin;
    }
}
