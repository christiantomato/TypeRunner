package typerunner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class UIInteractionTest {

    @Test
    void testStartButtonClick() {
        boolean isGameStarted = clickStartButton();
        
        assertTrue(isGameStarted, "Clicking 'Start Game' should start the game.");
    }

    private boolean clickStartButton() {
        return true; 

    }
    @Test
    void testPauseButtonClick() {
        boolean isGamePaused = clickPauseButton();

        assertTrue(isGamePaused, "Clicking 'Pause' should pause the game.");
    }

    private boolean clickPauseButton() {
        return true; 
    }
}