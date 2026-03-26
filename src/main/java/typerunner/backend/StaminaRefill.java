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
    public int getStaminaBonus() {
        return staminaBonus;
    }

    /**
     * Activates the stamina refill power-up for the specified player.
     * <p>
     * Note: The implementation logic is pending the finalization of the player's stamina mechanics.
     *
     * @param player The player to apply the power-up to.
     */
    @Override
    public void activate(Player player) {
        // Logic to activate the stamina refill for the player
        // Not implemented yet, as it depends on the game mechanics and how the player's stamina is managed
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
