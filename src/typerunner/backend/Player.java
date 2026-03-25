package typerunner.backend;

public class Player { // Represents one player in the TypeRunner game

    private String id; // Unique ID for the player
    private String username; // Username for the player
    private int totalGames; // Total games the user has played
    private int totalScore; // User's total score across all games
    private int bestScore; // User's best score yet in a single game
    private int unlockedLevel; // Highest level unlocked by the user

    public Player(String id, String username) { // Creates a new player with an ID and username with default starting stats
        this.id = id;
        this.username = username;
        this.totalGames = 0; // Start with 0 total games
        this.totalScore = 0; // Start with total score = 0
        this.bestScroe = 0; // Start with best score = 0
        this.unlockedLevel = 1; // Start with level 1 unlocked
    }

    public String getId() { // Get player ID
        return id; // Return player ID
    }

    public String getUsername() { // Get username
        return username; // Return username
    }
    public void recordGame(int score) { // Update player stats after game is finished
    totalGames++;
    totalScore += score;

    if (score > bestScore) {
        bestScore = score;
    }
}

    public int getBestScore() { // Get user best score
        return bestScore; // Return user best score
    }

    public int getUnlockedLevel() { // Get highest unlocked level
        return unlockedLevel; // Return highest unlocked level
    }

    public void setUnlockedLevel(int unlockedLevel) { // Set the player's unlocked level
        this.unlockedLevel = unlockedLevel;
    }

    public void resetStats() { // Reset all stats back to default
        this.totalGames = 0;
        this.totalScore = 0;
        this.bestScore = 0;
        this.unlockedLevel = 1; // Reset to level 1
    }
        this.totalScore = 0;
        this.bestScroe = 0;
        this.unlockedLevel = 1; // Reset to level 1
    }


    

    
    
}
