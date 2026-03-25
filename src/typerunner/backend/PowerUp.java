package typerunner.backend;

public interface PowerUp {
    
    // this will be implemented by SpeedBoost and StaminaRefill classes

    int level = 1;

    public void activate(Player player); // This method will be overridden by specific power-up types
    public boolean isTriggered(); // This method will check if the power-up is currently active for the player
       
    
}
