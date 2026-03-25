package typerunner.backend;

public class SpeedBoost implements PowerUp{
    private int boostDistance;
    private int requiredConsecutivetWords;

    public SpeedBoost(int boostDistance, int requiredConsecutivetWords) {
        this.boostDistance = boostDistance;
        this.requiredConsecutivetWords = requiredConsecutivetWords;
    }

    public int getBoostDistance() {
        return boostDistance;
    }

    public int getRequiredConsecutivetWords() {
        return requiredConsecutivetWords;
    }

    @Override
    public void activate(Player player) {
        // Logic to activate the speed boost for the player
        // Not implemented yet, as it depends on the game mechanics and how the player's speed is managed
    }

    @Override
    public boolean isTriggered() {
        return true;
    }   

    public int setBoostDistance(Level level) {
        int boostDistance = 0;
        int levelDifficulty = level.getDifficulty();
        if (levelDifficulty == 1) {
            boostDistance = 2;
        } else if (levelDifficulty == 2) {
            boostDistance = 4;
        } else if (levelDifficulty == 3) {
            boostDistance = 6;
        }

        return boostDistance;
    }   

    public int setRequiredConsecutiveWords(Level level) {
        int requiredConsecutiveWords = 0;
        int levelDifficulty = level.getDifficulty();
        if (levelDifficulty == 1) {
            requiredConsecutiveWords = 5;
        } else if (levelDifficulty == 2) {
            requiredConsecutiveWords = 10;
        } else if (levelDifficulty == 3) {
            requiredConsecutiveWords = 15;
        }

        return requiredConsecutiveWords;
    }








    
}
