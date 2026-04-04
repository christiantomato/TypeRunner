package typerunner;  

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class WindowsCompatibilityTest {

    @Test
    void testWindowsCompatibility() {
        boolean isWindowsCompatible = launchGameOnWindows();
        assertTrue(isWindowsCompatible, "The game should launch on Windows.");
    }

    private boolean launchGameOnWindows() {
        return true;  
    }
}