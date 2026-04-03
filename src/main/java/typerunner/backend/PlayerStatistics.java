package typerunner.backend;

/**
 * Player Statistics Data Model
 * 
 * Represents the statistics of a player in the TypeRunner game.
 * Tracks all specified metrics in project specification, and extra like total games played. 
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
    private Level level;
    /** total incorrect keystrokes typed */
    private int errorCount;
    /** total time that they have played */
    private double totalTimePlayed;
    /** the high score object for highest score */
    private Score highscore;
    /** total amount of correctly typed words */
    private int correctWordsTyped;

    /**
     * Player Statistics Constructor
     * 
     * Constructs a new PlayerStatistics object with default values.
     */

    public PlayerStatistics() {
        this.gamesPlayed = 0;
        this.averageWPM = 0;
        this.peakWPM = 0;
        this.accuracyPercentage = 0;
        this.level = Level.HIGHSCHOOL;
        this.errorCount = 0;
        this.totalTimePlayed = 0;
        this.highscore = new Score(Level.HIGHSCHOOL);
        this.correctWordsTyped = 0;
    }

    /**
     * Update Statistics
     * 
     * Updates the statistics for a player.
     * This is called after a game is finished to track stats.
     */

    public void updateStats(int mostRecentWpm, int mostRecentPeakWpm, double mostRecentAccuracy, Level mostRecentLevel, int mostRecentErrorCount, double mostRecentTime, int mostRecentScore, int mostRecentCorrectTyped) {
        //update the average wpm
        this.averageWPM = ((this.averageWPM * this.gamesPlayed) + mostRecentWpm) / (this.gamesPlayed + 1);

        //update the average accuracy
        this.accuracyPercentage = ((this.accuracyPercentage * this.gamesPlayed) + mostRecentAccuracy) / (this.gamesPlayed + 1);

        //update the peak wpm
        if(this.peakWPM < mostRecentPeakWpm) {
            this.peakWPM = mostRecentPeakWpm;
        }

        //update error count
        this.errorCount += mostRecentErrorCount;

        //update time played
        this.totalTimePlayed += mostRecentTime;

        //update total correct words typed
        this.correctWordsTyped += mostRecentCorrectTyped;

        //update highscore
        if(this.highscore.getScoreValue() < mostRecentScore) {
            this.highscore.setScoreValue(mostRecentScore);
            this.highscore.setLevel(mostRecentLevel);
            this.highscore.setAccuracy(mostRecentAccuracy);
            this.highscore.setWpm(mostRecentWpm);
        }

        //update their current unlocked level based on if their wpm has hit the required threshold
        if(mostRecentWpm > 50) {
            this.level = Level.COLLEGE;
        }
        if(mostRecentWpm > 70) {
            this.level = Level.OLYMPICS;
        }

        //add to the total games played
        this.gamesPlayed++;
    }

    //getters for each stat...

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
        return this.averageWPM;
    }

    /**
     * Gets the player's peak words per minute.
     *
     * @return the peak WPM
     */

    public double getPeakWPM() {
        return this.peakWPM;
    }

    /**
     * Gets the player's typing accuracy percentage.
     *
     * @return the accuracy percentage
     */

    public double getaccuracyPercentage() {
        return this.accuracyPercentage;
    }

    /**
     * Gets the player's current level.
     *
     * @return the level
     */

    public Level getLevel() {
        return this.level;
    }

    /**
     * Gets the total number of errors made by the player.
     *
     * @return the error count
     */
    public int getErrorCount() {
        return this.errorCount;
    }

    /**
     * Gets the total time played by the player.
     *
     * @return the total time played
     */

    public double getTotalTimePlayed() {
        return this.totalTimePlayed;
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
     * Gets the total number of correct words typed by the player.
     *
     * @return the total correct words typed
     */

    public int getCorrectWordsTyped() {
        return this.correctWordsTyped;
    }

    /**
     * Reset Statistics
     * 
     * Resets all the statistics with default values.
     */

    public void resetStats() {
        this.gamesPlayed = 0;
        this.averageWPM =  0.0;
        this.peakWPM = 0.0;
        this.accuracyPercentage = 0.0;
        this.level = Level.HIGHSCHOOL;
        this.errorCount = 0;
        this.totalTimePlayed = 0;
        this.highscore = new Score(Level.HIGHSCHOOL);
        this.correctWordsTyped = 0;
    }

    /**
     * Player Statistics ToString
     * 
     * Returns a nicely formatted string for the player statistics.
     * 
     * @return a nice statistics string
     */

    public String toString() {
        String str = "";

        str += "Games Played: " + this.gamesPlayed + "\n\n";
        str += "Average WPM: " + this.averageWPM + "\n\n";
        str += "Peak WPM: " + this.peakWPM + "\n\n";
        str += "Accuracy " + this.accuracyPercentage + "\n\n";
        str += "Level Unlocked: " + this.level + "\n\n";
        str += "Total Error Count " + this.errorCount + "\n\n";
        str += "Total Time Played (s): " + this.totalTimePlayed + "\n\n";
        str += "Highscore: " + this.highscore.getScoreValue() + "\n\n";
        str += "Correct Words Typed: " + this.correctWordsTyped + "\n\n";

        return str;
    }
}
