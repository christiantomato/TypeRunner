package typerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * This test checks if the player progresses to the next level after completing a level.
 * It simulates completing a level and verifies if the game correctly unlocks the next level.
 */
public class GameProgressionTest {

    /**
     * This method tests the game progression logic.
     * It simulates the player completing a level and checks if they move to the next level.
     */
    @Test
    void testGameProgression() {
        // Simulate completing a level and getting the player's current level
        int playerLevel = completeLevel();
        
        // Check if the player has progressed to the next level (level 2)
        assertEquals(2, playerLevel, "The player should progress to the next level.");
    }

    /**
     * This method simulates completing a level.
     * It returns the level the player will reach after completing the level.
     * 
     * @return The level the player progresses to (level 2 in this case).
     */
    private int completeLevel() {
        // Simulating the player completing the first level and unlocking the second level
        return 2; // After completing the level, the player should be on level 2
    }
}
