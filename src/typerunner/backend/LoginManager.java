package typerunner.backend;

public class LoginManager {
    private Player currentUser;
    private AccountManager accountManager;

    public LoginManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public boolean login(String username, String password) {
        Player player = accountManager.findPlayer(username);
        
        if (player != null && player.getPassword().equals(password)) {
            this.currentUser = player;
            return true;
        }
        return false;
    }

    public void logout() {
        this.currentUser = null;
    }

    public Player getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }
}