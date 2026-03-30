package typerunner.backend;

/**
 * Represents the Stamina Refill power-up, which grants a temporary boost to the player's stamina.
 * <p>
 * This power-up is typically triggered when a player's stamina falls below a certain
 * threshold during a race, allowing them to regain energy to continue typing effectively.
 *
 * @author Olorunfemi Martins
 */
public class StaminaRefill implements PowerUp {

    /** The base amount of stamina to restore when activated. */
    private int staminaBonus;

    /**
     * Constructs a new StaminaRefill power-up with a specified base bonus.
     *
     * @param staminaBonus The intended amount of stamina to restore.
     *                     <b>Note:</b> This value is currently ignored by {@link #getStaminaBonus(int)}.
     */
    public StaminaRefill(int staminaBonus) {
        this.staminaBonus = staminaBonus;
    }

    /**
     * Gets the stamina bonus amount based on the current game level.
     * <p>
     * <b>Warning:</b> This method's logic currently overrides the {@code staminaBonus}
     * value set in the constructor. It returns a hardcoded value based on the
     * provided level number.
     *
     * @param Levelnum The current level number used to determine the bonus amount.
     * @return The hardcoded stamina bonus for the given level, or 0 if the level is not recognized.
     */
    public int getStaminaBonus(int Levelnum) {
        switch (Levelnum) {
            case 1:
                staminaBonus = 40;
                break;
            case 2:
                staminaBonus = 20;
                break;
            case 3:
                staminaBonus = 10;
                break;
            default:
                staminaBonus = 0; // Default case if Levelnum is out of expected range
        }
        return staminaBonus;
    }

    /**
     * Triggers the stamina refill effect.
     * @return {@code true} unconditionally in its current state.
     */
    @Override
    public boolean isTriggered() {
        return true;
    }

}
