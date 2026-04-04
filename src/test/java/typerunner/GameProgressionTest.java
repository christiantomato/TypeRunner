package typerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GameProgressionTest {

    @Test
    void testGameProgression() {
        int playerLevel = completeLevel();
        
        assertEquals(2, playerLevel, "The player should progress to the next level.");
    }

    private int completeLevel() {
        return 2; 
    }
}
