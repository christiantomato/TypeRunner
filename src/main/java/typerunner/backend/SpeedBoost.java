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


    private int requiredConsecutiveWords;   
    private int levelnum;

    /**
     * Constructs a new SpeedBoost power-up with specific parameters.
     *
     * @param boostDistance The distance advantage this boost provides.
     * @param requiredConsecutivetWords The number of consecutive correct words needed to trigger this boost.
     */
    public SpeedBoost(int levelnum, int boostDistance, int requiredConsecutiveWords) {
        this.boostDistance = boostDistance;
        this.levelnum = levelnum;
        this.requiredConsecutiveWords = requiredConsecutiveWords;
    }

    /**
     * Gets the distance advantage provided by this speed boost.
     *
     * @return The boost distance.
     */
    public int getBoostDistance(int levelnum) {
        switch (levelnum) {
            case 1:
                boostDistance = 10;
                break;
            case 2:
                boostDistance = 20;
                break;
            case 3:
                boostDistance = 30;
                break;
            default:
                boostDistance = 0; // Default case if levelnum is out of expected range
        }
        return boostDistance;
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

}
