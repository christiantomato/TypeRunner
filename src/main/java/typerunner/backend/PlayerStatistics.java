package typerunner.backend;

/**
 * Represents the statistics of a player in the TypeRunner game.
 * Tracks metrics such as words per minute (WPM), accuracy, level, errors, time played, and highest score.
 * @author Olorunfemi Martins
 */
public class PlayerStatistics {
    private double averageWPM;
    private double peakWPM;
    private double accuracypercentage;
    private int level;
    private int errorCount;
    private int totalTimePlayed;
    private int highestscore;
    private int totalWordsTyped;

    /**
     * Constructs a new PlayerStatistics object with the specified initial values.
     *
     * @param averageWPM         the player's average words per minute
     * @param peakWPM            the player's peak words per minute
     * @param accuracypercentage the player's typing accuracy percentage
     * @param level              the current level of the player
     * @param errorCount         the total number of typing errors made
     * @param totalTimePlayed    the total time the player has spent playing
     * @param highestscore       the highest score achieved by the player
     * @param totalWordsTyped    the total number of words typed by the player
     */
    public PlayerStatistics(double averageWPM, double peakWPM, double accuracypercentage, int level, int errorCount, int totalTimePlayed, int highestscore, int totalWordsTyped) {
        this.averageWPM = averageWPM;
        this.peakWPM = peakWPM;
        this.accuracypercentage = accuracypercentage;
        this.level = level;
        this.errorCount = errorCount;
        this.totalTimePlayed = totalTimePlayed;
        this.highestscore = highestscore;
        this.totalWordsTyped = totalWordsTyped;
    }

    /**
     * Gets the player's average words per minute.
     *
     * @return the average WPM
     */
    public double getAverageWPM() {
        return averageWPM;
    }

    /**
     * Sets the player's average words per minute.
     *
     * @param averageWPM the new average WPM
     */
    public void setAverageWPM(double averageWPM) {
        this.averageWPM = averageWPM;
    }

    /**
     * Gets the player's peak words per minute.
     *
     * @return the peak WPM
     */
    public double getPeakWPM() {
        return peakWPM;
    }

    /**
     * Sets the player's peak words per minute.
     * Checks if their new WPM is higher than their current peak WPM before updating.
     *
     * @param peakWPM the new peak WPM
     */
    public void setPeakWPM(double peakWPM) {
        if (peakWPM > this.peakWPM) { 
            this.peakWPM = peakWPM;
        }
    }

    /**
     * Gets the player's typing accuracy percentage.
     *
     * @return the accuracy percentage
     */
    public double getAccuracypercentage() {
        return accuracypercentage;
    }

    /**
     * Sets the player's typing accuracy percentage.
     * Check if their new accuracy percentage is higher than their current accuracy percentage before updating.
     * @param accuracypercentage the new accuracy percentage
     */
    public void setAccuracypercentage(double accuracypercentage) {
        if(accuracypercentage >= this.accuracypercentage) {
            this.accuracypercentage = accuracypercentage;
        }
    }

    /**
     * Gets the player's current level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the player's current level.
     *
     * @param level the new level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the total number of errors made by the player.
     *
     * @return the error count
     */
    public int getErrorCount() {
        return errorCount;
    }

    /**
     * Adds to the player's total error count.
     *
     * @param errorCount the number of errors to add to the current count
     */
    public void setErrorCount(int errorCount) {
        this.errorCount += errorCount;
    }

    /**
     * Gets the total time played by the player.
     *
     * @return the total time played
     */
    public int getTotalTimePlayed() {
        return totalTimePlayed;
    }

    /**
     * Sets the total time played by the player.
     *
     * @param totalTimePlayed the new total time played
     */
    public void setTotalTimePlayed(int totalTimePlayed) {
        this.totalTimePlayed = totalTimePlayed;
    }

    /**
     * Gets the highest score achieved by the player.
     *
     * @return the highest score
     */
    public int getHighestscore() {
        return highestscore;
    }

    /**
     * Sets the highest score achieved by the player.
     *
     * @param highestscore the new highest score
     */
    public void setHighestscore(int highestscore) {
        this.highestscore = highestscore;
    }

    /**
     * Gets the total number of words typed by the player.
     *
     * @return the total words typed
     */
    public int getTotalWordsTyped() {
        return totalWordsTyped;
    }

    /**
     * Sets the total number of words typed by the player.
     *
     * @param totalWordsTyped the new total words typed
     */
    public void setTotalWordsTyped(int totalWordsTyped) {
        this.totalWordsTyped = totalWordsTyped;
    }

    public void resetActualStats() {
        this.averageWPM =  0.0;
        this.peakWPM = 0.0;
        this.accuracypercentage = 0.0;
        this.level = 1;
        this.errorCount = 0;
        this.totalTimePlayed = 0;
        this.highestscore = 0;
        this.totalWordsTyped = 0;
    }

    public void insertStats(double averageWPM, double peakWPM, double accuracypercentage, int level, int errorCount, int totalTimePlayed, int highestscore, int totalWordsTyped) {
        this.averageWPM = averageWPM;
        this.peakWPM = peakWPM;
        this.accuracypercentage = accuracypercentage;
        this.level = level;
        this.errorCount = errorCount;
        this.totalTimePlayed = totalTimePlayed;
        this.highestscore = highestscore;
        this.totalWordsTyped = totalWordsTyped;
    }


}
