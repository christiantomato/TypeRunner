package typerunner;
/* 
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import typerunner.backend.PlayerStatistics;

class PlayerStatisticsTest {

    private PlayerStatistics stats;
    private static final double DELTA = 1e-15; // Tolerance for double comparisons

    @BeforeEach
    void setUp() {
        stats = new PlayerStatistics(
                50.0,   // averageWPM
                80.0,   // peakWPM
                95.5,   // accuracypercentage
                3,      // level
                10,     // errorCount
                120,    // totalTimePlayed
                5000,   // highestscore
                2000    // totalWordsTyped
        );
    }

    @Test
    void testBasic() {
        assertEquals(2,1 + 1);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(50.0, stats.getAverageWPM(), DELTA);
        assertEquals(80.0, stats.getPeakWPM(), DELTA);
        assertEquals(95.5, stats.getAccuracypercentage(), DELTA);
        assertEquals(3, stats.getLevel());
        assertEquals(10, stats.getErrorCount());
        assertEquals(120, stats.getTotalTimePlayed());
        assertEquals(5000, stats.getHighestscore());
        assertEquals(2000, stats.getTotalWordsTyped());
    }

    @Test
    void testSetAverageWPM() {
        stats.setAverageWPM(60.0);
        assertEquals(60.0, stats.getAverageWPM(), DELTA);
    }

    @Test
    void testSetPeakWPM() {
        stats.setPeakWPM(90.0);
        assertEquals(90.0, stats.getPeakWPM(), DELTA);
    }

    @Test
    void testSetAccuracyPercentage() {
        stats.setAccuracypercentage(98.0);
        assertEquals(98.0, stats.getAccuracypercentage(), DELTA);
    }

    @Test
    void testSetLevel() {
        stats.setLevel(5);
        assertEquals(5, stats.getLevel());
    }

    @Test
    void testSetErrorCountAddsValue() {
        // Note: Based on your test name, this method increments the count
        stats.setErrorCount(5); 
        assertEquals(15, stats.getErrorCount());
    }

    @Test
    void testSetTotalTimePlayed() {
        stats.setTotalTimePlayed(200);
        assertEquals(200, stats.getTotalTimePlayed());
    }

    @Test
    void testSetHighestScore() {
        stats.setHighestscore(7000);
        assertEquals(7000, stats.getHighestscore());
    }

    @Test
    void testSetTotalWordsTyped() {
        stats.setTotalWordsTyped(3000);
        assertEquals(3000, stats.getTotalWordsTyped());
    }
}
*/