package typerunner.backend;

public class Player {

    private String id;
    private String username;
    private int totalGames;
    private int totalScore;
    private int bestScroe;
    private int unlockedLevel;

    public Player(String id, String username) {
        this.id = id;
        this.username = username;
        this.totalGames = 0;
        this.totalScore = 0;
        this.bestScroe = 0;
        this.unlockedLevel = 1; // Start with level 1 unlocked
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public void recordGame(int score) {
        
    }

    public int getBestScore() {
        return bestScroe;
    }

    public int getUnlockedLevel() {
        return unlockedLevel;
    }

    public void setUnlockedLevel(int unlockedLevel) {
        this.unlockedLevel = unlockedLevel;
    }

    public void resetStats() {
        this.totalGames = 0;
        this.totalScore = 0;
        this.bestScroe = 0;
        this.unlockedLevel = 1; // Reset to level 1
    }


    

    
    
}
