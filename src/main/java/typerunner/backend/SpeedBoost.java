package typerunner.backend;

/**
 * Represents the Speed Boost power-up, which grants a temporary speed advantage.
 * <p>
 * This power-up is designed to be triggered when a player types a specific number
 * of words correctly in a row. The amount of boost and the trigger condition
 * can be configured based on the game level.
 *
 * @author Olorunfemi Martins
 * @author Christian Tamayo
 */

public class SpeedBoost implements PowerUp {

    /** The distance or advantage gained from the speed boost. */
    private int boostDistance;

    /** The number of consecutive correct words needed to trigger this boost. */
    private int requiredConsecutiveWords;

    /** The game level associated with this power-up instance. */
    private int levelnum;

    /**
     * Constructs a new SpeedBoost power-up with specific parameters.
     *
     * @param levelnum                 The game level this boost is for.
     * @param boostDistance            The intended distance advantage this boost provides.
     *                                 <b>Note:</b> This value is currently ignored by {@link #getBoostDistance(int)}.
     * @param requiredConsecutiveWords The number of consecutive correct words needed to trigger this boost.
     */

    public SpeedBoost(int levelnum, int boostDistance, int requiredConsecutiveWords) {
        this.boostDistance = boostDistance;
        this.levelnum = levelnum;
        this.requiredConsecutiveWords = requiredConsecutiveWords;
    }

    /**
     * Gets the distance advantage for a specific game level.
     * <p>
     * <b>Warning:</b> This method's logic currently overrides the {@code boostDistance}
     * value set in the constructor. It returns a hardcoded value based on the
     * provided level number, rather than returning the instance's state.
     *
     * @param levelnum The level number used to determine the boost amount.
     * @return The hardcoded boost distance for the given level, or 0 if the level is not recognized.
     */

    public int getBoostDistance(int levelnum) {
        switch (levelnum) {
            case 1:
                this.boostDistance = 10;
            case 2:
                this.boostDistance = 20;
            case 3:
                this.boostDistance = 30;
            default:
                this.boostDistance = 0; // Default case if levelnum is out of the expected range
        }
        return this.boostDistance;
    }

    /**
     * Trigger
     * 
     * Triggers the Speed Boost Power Up. 
     */
    @Override
    public void trigger() {
        //triggers a speed boost clearly whoever was supposed to work on this didn't do it 
    }

    public int getLevelNum() {
        return this.levelnum;
    }

    public int getRequiredConsecutive() {
        return this.requiredConsecutiveWords;
    }
}
