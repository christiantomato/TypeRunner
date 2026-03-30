package typerunner.backend;

/**
 * Defines the contract for all power-ups available in the TypeRunner game.
 * <p>
 * Implementing classes, such as {@link SpeedBoost} and {@link StaminaRefill},
 * must provide specific logic for activation and trigger conditions.
 *
 * @author Olorunfemi Martins
 */
public interface PowerUp {

    /**
     * Represents a generic level attribute for a power-up.
     * <p>
     * <b>Note:</b> This is a static, hardcoded value. Its purpose is not clearly
     * defined in the context of dynamic game levels (see {@link Level}).
     * Consider refactoring or removing if it is not used.
     */
    int level = 1;


    /**
     * Checks if the conditions required to trigger the power-up have been met.
     *
     * @return {@code true} if the power-up's trigger conditions are met, {@code false} otherwise.
     */
    boolean isTriggered();
}
