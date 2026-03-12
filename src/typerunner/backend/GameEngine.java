package typerunner.backend;

public class GameEngine {

    private Player currentPlayer;
    private Race currentRace;
    private boolean isGameRunning;

    public GameEngine(Player player) {
        this.currentPlayer = player;
        this.currentRace = new  Race();
        this.isGameRunning = true;
    }

    public void startGame() {

        // Initialize game stat
        isGameRunning = true;}
    public void updateGame() {
        // Update game state, check for win/loss conditions, etc.
    }

    public void endGame() {
        // Handle end of game logic, such as displaying results, saving stats, etc.
        isGameRunning = false;
    }

}
