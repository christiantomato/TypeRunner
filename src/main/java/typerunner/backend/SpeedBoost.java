package typerunner.backend;

/**
 * Represents the Speed Boost power-up in the TypeRunner game.
 * This power-up provides a temporary speed advantage to the player when activated.
 * Activation is typically triggered by achieving a certain number of consecutively typed correct words.
 * @author Olorunfemi Martins
 */
public class SpeedBoost implements PowerUp{
    /** The distance or advantage gained from the speed boost. */
    private int boostDistance;
    /** The number of consecutive words required to trigger the boost. */
    private int requiredConsecutivetWords;

    /**
     * Constructs a new SpeedBoost power-up with specific parameters.
     *
     * @param boostDistance The distance advantage this boost provides.
     * @param requiredConsecutivetWords The number of consecutive correct words needed to trigger this boost.
     */
    public SpeedBoost(int boostDistance, int requiredConsecutivetWords) {
        this.boostDistance = boostDistance;
        this.requiredConsecutivetWords = requiredConsecutivetWords;
    }

    /**
     * Gets the distance advantage provided by this speed boost.
     *
     * @return The boost distance.
     */
    public int getBoostDistance() {
        return boostDistance;
    }

    /**
     * Gets the number of consecutive correct words required to trigger the boost.
     *
     * @return The number of required consecutive words.
     */
    public int getRequiredConsecutivetWords() {
        return requiredConsecutivetWords;
    }

    /**
     * Activates the speed boost for the specified player.
     * <p>
     * Note: The implementation logic is pending the finalization of the game's speed and player progression mechanics.
     *
     * @param player The player to apply the power-up to.
     */
    @Override
    public void activate(Player player) {
        // Logic to activate the speed boost for the player
        // Not implemented yet, as it depends on the game mechanics and how the player's speed is managed
    }

    /**
     * Checks if the conditions to trigger the power-up have been met.
     * <p>
     * Note: This is a placeholder and currently always returns true. The actual implementation
     * would check the player's state for consecutive correct words.
     *
     * @return true as a placeholder, but should return whether the trigger condition is met.
     */
    @Override
    public boolean isTriggered() {
        return true;
    }   

    /**
     * Calculates the boost distance based on the game level.
     * <p>
     * Note: This method does not modify the state of the current object.
     * Its name is misleading; a name like {@code calculateBoostDistance} would be more appropriate.
     *
     * @param level The game level to calculate the boost distance for.
     * @return The calculated boost distance for the given level.
     */
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

    /**
     * Calculates the number of required consecutive words based on the game level.
     * <p>
     * Note: This method does not modify the state of the current object.
     * Its name is misleading; a name like {@code calculateRequiredConsecutiveWords} would be more appropriate.
     *
     * @param level The game level to calculate the requirement for.
     * @return The number of required consecutive words for the given level.
     */
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
