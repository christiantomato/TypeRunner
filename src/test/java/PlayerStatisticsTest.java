package test.java;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import typerunner.backend.PlayerStatistics;

public class PlayerStatisticsTest {

    private PlayerStatistics stats;
    private static final double DELTA = 1e-15; // Tolerance for double comparisons

    @Before
    public void setUp() {
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
    public void testBasic() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testConstructorAndGetters() {
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
    public void testSetAverageWPM() {
        stats.setAverageWPM(60.0);
        assertEquals(60.0, stats.getAverageWPM(), DELTA);
    }

    @Test
    public void testSetPeakWPM() {
        stats.setPeakWPM(90.0);
        assertEquals(90.0, stats.getPeakWPM(), DELTA);
    }

    @Test
    public void testSetAccuracyPercentage() {
        stats.setAccuracypercentage(98.0);
        assertEquals(98.0, stats.getAccuracypercentage(), DELTA);
    }

    @Test
    public void testSetLevel() {
        stats.setLevel(5);
        assertEquals(5, stats.getLevel());
    }

    @Test
    public void testSetErrorCountAddsValue() {
        stats.setErrorCount(5); // should ADD, not replace
        assertEquals(15, stats.getErrorCount());
    }

    @Test
    public void testSetTotalTimePlayed() {
        stats.setTotalTimePlayed(200);
        assertEquals(200, stats.getTotalTimePlayed());
    }

    @Test
    public void testSetHighestScore() {
        stats.setHighestscore(7000);
        assertEquals(7000, stats.getHighestscore());
    }

    @Test
    public void testSetTotalWordsTyped() {
        stats.setTotalWordsTyped(3000);
        assertEquals(3000, stats.getTotalWordsTyped());
    }
}