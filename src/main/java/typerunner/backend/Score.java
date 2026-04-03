package typerunner.backend;

/**
 * Score Data Model
 * 
 * Represents a player's score entry in the TypeRunner game.
 * Determined by the factors:
 * 
 * 1. level 
 * 2. wpm achieved
 * 3. accuracy achieved
 * 
 * Their values are then added together to give a numeric value of the score.
 * 
 * @author Olorunfemi Martins
 * @author Christian Tamayo
 */

public class Score {

    /** what the level difficulty was */
    private Level level;
    /** what their wpm achieved was */
    private int wpm;
    /** what their accuracy achieved was */
    private double accuracy;
    /** the integer which stores the score, calculated with our special formula */
    private int scoreValue;

    /**
     * Score Constructor 
     * 
     * Constructs a new scores object with default values, and a passed in level since 
     * Game Engine can pass in what level was selected.
     */

    public Score(Level level) {
        this.level = level;
        this.wpm = 0;
        this.accuracy = 0;
    }

     /**
     * Calculate Score
     * 
     * Calculates the score value based on the fields.
     * Literally just sums each individual value. 
     * Games with less than 70% accuracy are not logged, avoiding keyboard mashing, 
     * ensuring scores are fair and weighted properly with this calculation.
     * 
     * @return the calculated score value
     */

    public int calculateScore(Level level, int wpm, double accuracy) {
        this.scoreValue = (int)(this.level.getDifficulty() + wpm + accuracy);
        return this.scoreValue;
    }

    /**
     * Getter for Level
     *
     * Gets the level for this score object.
     * 
     * @return the player's level
     */

    public Level getLevel() {
        return this.level;
    }

    /**
     * Setter for Level
     * 
     * Sets the level for this score. 
     */

    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Getter for WPM
     *
     * Gets the wpm for this score. 
     * 
     * @return the wpm int
     */

    public int getWPM() {
        return this.wpm;
    }

     /**
     * Setter for WPM
     * 
     * Sets the new wpm.
     * 
     * @param wpm the new wom
     */

    public void setWpm(int wpm) {
        this.wpm = wpm;
    }

    /**
     * Getter for accuracy
     * 
     * Gets the accuracy achieved by the player. 
     *
     * @return the accuracy int
     */

    public double getAccuracy() {
        return this.accuracy;
    }

    /**
     * Setter for Accuracy
     * 
     * Sets the new accuracy. 
     * 
     * @param accuracy the new accuracy 
     */

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * Get Score Value
     * 
     * Gets the value of the score.
     * 
     * @return the score value
     */

    public int getScoreValue() {
        return this.scoreValue;
    }

    /**
     * Set Score Value
     * 
     * Sets a new score value.
     * 
     * @param score new score
     */

    public void setScoreValue(int score) {
        this.scoreValue = score;
    }
}
