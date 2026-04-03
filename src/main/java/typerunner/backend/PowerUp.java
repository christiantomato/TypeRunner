package typerunner.backend;

/**
 * Defines the contract for all power-ups available in the TypeRunner game.
 * <p>
 * Implementing classes, such as {@link SpeedBoost} and {@link StaminaRefill},
 * must provide specific logic for activation and trigger conditions.
 *
 * @author Olorunfemi Martins
 * @author Christian Tamayo
 */

public interface PowerUp {

    /**
     * Trigger
     *
     * Triggers the Power Up effect.
     */

    void trigger();
}
