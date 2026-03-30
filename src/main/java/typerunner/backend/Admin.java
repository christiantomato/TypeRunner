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
    private ArrayList<String> playerUsernames; 

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

        //initalize an empty list
        this.playerUsernames = new ArrayList<>();
    }
}
