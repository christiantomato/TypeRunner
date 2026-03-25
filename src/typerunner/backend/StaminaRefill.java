package typerunner.backend;

public class StaminaRefill implements PowerUp {
    private int staminaBonus;

    public StaminaRefill(int staminaBonus) {
        this.staminaBonus = staminaBonus;
    }

    public int getStaminaBonus() {
        return staminaBonus;
    }

    @Override
    public void activate(Player player) {
        // Logic to activate the stamina refill for the player
        // Not implemented yet, as it depends on the game mechanics and how the player's stamina is managed
    }

    @Override
    public boolean isTriggered() {
        return true;
    }

}
