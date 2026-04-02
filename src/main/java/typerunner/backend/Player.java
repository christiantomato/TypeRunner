package typerunner.backend;

/**
 * Represents one player in the TypeRunner game
 * Stores the player's ID, username, scores, and unlocked level
 * 
 * @author Tanya Sahota
 * @author Christian Tamayo
 * @version 1.0
 */

public class Player {
    /** username for the player */
    private String username;
    /** user's password for authentication */
    private String password;
    /** the statistics of the player */
    private PlayerStatistics statistics;
    /** boolean flag for the json file */
    protected boolean isAdmin = false;

    /** 
     * Player Constructor
     * 
     * Creates a new player with the given ID and username
     * All starting stats are set to default
     * 
     * @param username the username of the player
     * @param password the password of the player
     * @param administrator the admin of the player
     */

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        //initalize the statistics object with default values
        this.statistics = new PlayerStatistics(0, 0,0,0,1,0,0,new Score(Level.HIGHSCHOOL), 0);
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
     * Is Admin
     * 
     * Getter for admin flag 
     * 
     * @return true if admin, false if just regular player
     */

    public boolean isAdmin() {
        return this.isAdmin;
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
     * Set Password
     * 
     * Sets a new password for the player. 
     * 
     * @param newPassword the new password
     */

    public void setPassword(String newPassword) {
        this.password = newPassword;
    } 
}
