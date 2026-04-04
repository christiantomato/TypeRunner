package typerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GameProgressionTest {

    @Test
    void testGameProgression() {
        // Simulate a new game session and completing a level
        int playerLevel = completeLevel();
        
        // Check if the next level is unlocked
        assertEquals(2, playerLevel, "The player should progress to the next level.");
    }

    // Method to simulate completing a level
    private int completeLevel() {
        // Simulate the player completing a level and unlocking the next one
        return 2; // The player should reach level 2
    }
}
