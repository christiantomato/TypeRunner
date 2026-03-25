package typerunner.backend;

public class Admin extends Player {

    private String passKeyHash;
    
    public Admin(String username, String password, String passKey) {
        super(username, password); // Admins use their password as the passKey for simplicity
        this.passKeyHash = passKey;
    }

    public boolean validatePassKey(String inputKey) {
        return this.passKeyHash.equals(inputKey);
    }

    public void changePassKey(String newPassKey) {
        this.passKeyHash = newPassKey; // hash it?
    }

    public void resetHighScores(Player player) {
        player.resetStats();
    }


    
}
