package typerunner.backend;

import java.util.ArrayList;

/**
 * Administrator Class
 * 
 * Defines the properties of an administrator. They supervise any amount of players,
 * and can play the game as normal. 
 * 
 * @author Christian Tamayo
 */

public class Admin extends Player {
    /** a list of all the players they manage */
    private ArrayList<String> playersManaging; 

    /**
     * Admin Constructor
     * 
     * Passes in the username and password, and initalizes an empty list
     * where players can be added into upon creation of their accounts. 
     * 
     * @param username the username of the admin
     * @param password the password of the admin
     */

    public Admin(String username, String password) {
        //pass into super
        super(username, password);
        this.isAdmin = true;

        //initalize an empty list
        this.playersManaging = new ArrayList<>();
    }

    /**
     * Get Players Managing
     * 
     * Getter for the list of players under the admin,
     */

    public ArrayList<String> getPlayers() {
        return this.playersManaging;
    }

    /**
     * Add Player
     * 
     * Adds a player to the list under the admin. 
     * 
     * @param playerUsername the player to add under the admin
     */

    public void addPlayer(String playerUsername) {
        playersManaging.add(playerUsername);
    }
}
