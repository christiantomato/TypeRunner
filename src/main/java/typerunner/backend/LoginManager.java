package typerunner.backend;

/**
 * Manages user authentication and login state for the TypeRunner game.
 * This class handles logging in, logging out, and tracking the currently active user.
 * @author Olorunfemi Martins Kayode
 */
public class LoginManager {

    /** The currently logged-in player, or null if no one is logged in. */
    private Player currentUser;

    /** The account manager used to look up and verify user credentials. */
    private AccountManager accountManager;

    /**
     * Constructs a new LoginManager with the specified AccountManager.
     *
     * @param accountManager the account manager to use for credential verification
     */
    public LoginManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    /**
     * Attempts to log in a user with the provided username and password.
     *
     * @param username the username of the player trying to log in
     * @param password the password of the player trying to log in
     * @return {@code true} if the login was successful, {@code false} otherwise
     */
    public boolean login(String username, String password) {
        Player player = accountManager.findPlayer(username);
        
        if (player != null && player.getPassword().equals(password)) {
            this.currentUser = player;
            return true;
        }
        return false;
    }

    /**
     * Logs out the current user, clearing the active session.
     */
    public void logout() {
        this.currentUser = null;
    }

    /**
     * Retrieves the currently logged-in player.
     *
     * @return the current {@link Player} object, or {@code null} if no user is logged in
     */
    public Player getCurrentUser() {
        return currentUser;
    }

    /**
     * Checks if a user is currently logged in.
     *
     * @return {@code true} if a user is logged in, {@code false} otherwise
     */
    public boolean isLoggedIn() {
        return currentUser != null;
    }
}