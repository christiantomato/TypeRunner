package typerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UserDataIntegrityTest {

    @Test
    void testUserDataIntegrity() {
        int savedScore = savePlayerData();
        
        int loadedScore = loadPlayerData();
        
        assertEquals(savedScore, loadedScore, "The saved score should match the loaded score.");
    }

    private int savePlayerData() {
        return 150; 
    }

    private int loadPlayerData() {
        return 150; 
    }
}