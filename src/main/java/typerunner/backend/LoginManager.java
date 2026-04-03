package typerunner.backend;

/**
 * Login Manager
 * 
 * Manages user authentication and login state for the TypeRunner game.
 * This class handles logging in, logging out, and tracking the currently active user.
 * Only one instance of this class is ever present, and is accessible globally. 
 * 
 * @author Christian Tamayo
 * @author Olorunfemi Martins Kayode
 */

public class LoginManager {

    /** the instance of the login manager */
    private static LoginManager instance;
    /** the account manager */
    private AccountManager accountManager;
    /** the currently logged-in player, or null if no one is logged in. */
    private Player currentUser;
    /** user logged in variable */
    private boolean userLoggedIn;

    /**
     * Login Manager Constructor 
     * 
     * Constructs a new LoginManager and initalizes defaults for instance variables
     *
     * @param accountManager the account manager to use for credential verification
     */
    
    private LoginManager() {
        this.accountManager = AccountManager.getInstance();
        this.currentUser = null;
        this.userLoggedIn = false;
    }

    /**
     * Get Instance
     *
     * Returns the instance of the login manager. If it has not been
     * initialized yet, it calls the constructor and builds it. Static so we can
     * call it from anywhere to get the account manager instance.
     *
     * @return the instance of the login manager
     * @see LoginManager
     */

    public static LoginManager getInstance() {
        //create an instance if there isn't one
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    /**
     * Login
     * 
     * Attempts to log in a user with the provided username and password.
     *
     * @param username the username of the player trying to log in
     * @param password the password of the player trying to log in
     * @return {@code true} if the login was successful, {@code false} otherwise
     */

    public boolean login(String username, String password) {
        //find the player in the database
        Player player = this.accountManager.findPlayer(username);
        
        //check password
        if(player != null && player.getPassword().equals(password)) {
            //set the current user
            this.currentUser = player;
            //set flag
            this.userLoggedIn = true;
            return true;
        }
        return false;
    }

    /**
     * Logout
     * 
     * Logs out the current user, clearing the active session.
     */

    public void logout() {
        this.currentUser = null;
    }

    /**
     * Get Current User
     * 
     * Retrieves the currently logged-in player.
     *
     * @return the current {@link Player} object, or {@code null} if no user is logged in
     */

    public Player getCurrentUser() {
        return this.currentUser;
    }

    /**
     * Is Logged In
     * 
     * Checks if a user is currently logged in.
     *
     * @return {@code true} if a user is logged in, {@code false} otherwise
     */

    public boolean isLoggedIn() {
        return this.userLoggedIn;
    }
}
