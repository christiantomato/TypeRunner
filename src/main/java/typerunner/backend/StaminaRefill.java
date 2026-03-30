package typerunner.backend;

/**
 * Represents the Stamina Refill power-up in the TypeRunner game.
 * This power-up provides a bonus to the player's stamina.
 *  @author Olorunfemi Martins
 */
public class StaminaRefill implements PowerUp {
    private int staminaBonus;

    /**
     * Constructs a new StaminaRefill power-up.
     *
     * @param staminaBonus The amount of stamina bonus provided by this power-up.
     */
    public StaminaRefill(int staminaBonus) {
        this.staminaBonus = staminaBonus;
    }

    /**
     * Gets the stamina bonus amount.
     *
     * @return The stamina bonus.
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
     * Checks if the power-up has been triggered.
     * <p>
     * Note: This is a placeholder and currently always returns true.
     *
     * @return true, as a placeholder.
     */
    @Override
    public boolean isTriggered() {
        return true;
    }

}
