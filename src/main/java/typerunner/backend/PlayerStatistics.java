package typerunner.backend;

/**
 * Player Statistics Data Model
 * 
 * Represents the statistics of a player in the TypeRunner game.
 * Tracks metrics such as words per minute (WPM), accuracy, level, errors, time played, and highest score.
 * 
 * @author Christian Tamayo
 * @author Olorunfemi Martins
 */

public class PlayerStatistics {
    /** total games player */
    private int gamesPlayed;
    /** average wpm */
    private double averageWPM;
    /** highest wpm reached */
    private double peakWPM;
    /** their total accuracy */
    private double accuracyPercentage;
    /** the highest level unlocked */
    private int level;
    /** total incorrect keystrokes typed */
    private int errorCount;
    /** total time that they have played */
    private int totalTimePlayed;
    /** the high score object for highest score */
    private Score highscore;
    /** total amount of correctly typed words */
    private int totalCorrectWordsTyped;

    /**
     * Constructs a new PlayerStatistics object with the specified initial values.
     *
     * @param gamesPlayed               the total games played
     * @param averageWPM                the player's average words per minute
     * @param peakWPM                   the player's peak words per minute
     * @param accuracyPercentage        the player's typing accuracy percentage
     * @param level                     the current level of the player
     * @param errorCount                the total number of typing errors made
     * @param totalTimePlayed           the total time the player has spent playing
     * @param highscore                 the highest score achieved by the player
     * @param totalCorrectWordsTyped    the total number of words correclty typed by the player
     */

    public PlayerStatistics(int gamesPlayed, double averageWPM, double peakWPM, double accuracyPercentage, int level, int errorCount, int totalTimePlayed, Score highscore, int totalCorrectWordsTyped) {
        this.gamesPlayed = gamesPlayed;
        this.averageWPM = averageWPM;
        this.peakWPM = peakWPM;
        this.accuracyPercentage = accuracyPercentage;
        this.level = level;
        this.errorCount = errorCount;
        this.totalTimePlayed = totalTimePlayed;
        this.highscore = highscore;
        this.totalCorrectWordsTyped = totalCorrectWordsTyped;
    }

    /**
     * Getter for Games Played
     * 
     * Gets the player's total games played. 
     *
     * @return the average WPM
     */

    public int getGamesPlayed() {
        return this.gamesPlayed;
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
     * Gets the player's peak words per minute.
     *
     * @return the peak WPM
     */

    public double getPeakWPM() {
        return peakWPM;
    }

    /**
     * Gets the player's typing accuracy percentage.
     *
     * @return the accuracy percentage
     */

    public double getaccuracyPercentage() {
        return accuracyPercentage;
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
     * Gets the total number of errors made by the player.
     *
     * @return the error count
     */
    public int getErrorCount() {
        return errorCount;
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
     * Gets the highest score achieved by the player.
     *
     * @return the highest score
     */

    public Score getHighscore() {
        return this.highscore;
    }

    /**
     * Gets the total number of words typed by the player.
     *
     * @return the total words typed
     */

    public int gettotalCorrectWordsTyped() {
        return totalCorrectWordsTyped;
    }

    /**
     * Update Statistics
     * 
     * Updates the statistics for a player after a game is finished. 
     * 
     */

    public void updateStats(int mostRecentWpm, int mostRecentPeakWpm, double mostRecentAccuracy, int mostRecentErrorCount, int mostRecentTime, int mostRecentScore, int mostRecentCorrectWordsTyped) {
        //update the average wpm
        this.averageWPM = ((this.averageWPM * this.gamesPlayed) + mostRecentWpm) / this.gamesPlayed + 1;

        //update the average accuracy
        this.accuracyPercentage = ((this.accuracyPercentage * this.gamesPlayed) + mostRecentAccuracy) / this.gamesPlayed + 1;

        //update the peak wpm
        if(this.peakWPM < mostRecentPeakWpm) {
            this.peakWPM = mostRecentPeakWpm;
        }

        //update error count
        this.errorCount += mostRecentErrorCount;

        //update time played
        this.totalTimePlayed += mostRecentTime;

        //update total correct words typed
        this.totalCorrectWordsTyped += mostRecentCorrectWordsTyped;

        //update highscore
        if(this.highscore.getScoreValue() < mostRecentScore) {
            this.highscore.setScoreValue(mostRecentScore);
        }

        //add to the total games played
        this.gamesPlayed++;
    }

    /**
     * Reset Statistics
     * 
     * Resets all the statistics
     */

    public void resetStats() {
        this.gamesPlayed = 0;
        this.averageWPM =  0.0;
        this.peakWPM = 0.0;
        this.accuracyPercentage = 0.0;
        this.level = 1;
        this.errorCount = 0;
        this.totalTimePlayed = 0;
        this.highscore = null;
        this.totalCorrectWordsTyped = 0;
    }
}
