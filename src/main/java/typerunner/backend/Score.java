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
    /** what the level difficult was */
    private Level level;
    /** what their wpm achieved was */
    private double wpm;
    /** what their accuracy achieved was */
    private double accuracy;

    /**
     * Score Constructor 
     * 
     * Constructs a new scores object with the necessary parameters.
     *
     * @param level the level difficulty they were playing (1, 2, 3)
     * @param wpm the wpm achieved
     * @param accuracy the accuracy achieved
     */

    public Score(Level level, double wpm, double accuracy) {
        this.level = level;
        this.wpm = wpm;
        this.accuracy = accuracy;
    }

    /**
     * Getter for Level
     *
     * @return the player's level
     */

    public Level getLevel() {
        return this.level;
    }

    /**
     * Getter for WPM
     *
     * @return the wpm int
     */

    public double getWPM() {
        return this.wpm;
    }

    /**
     * Getter for accuracy
     * 
     * Gets the accuracy achieved by the player
     *
     * @return the accuracy int
     */

    public double getAccuracy() {
        return this.accuracy;
    }

    /**
     * Calculate Score
     * 
     * Calculates the score value based on the fields
     * 
     * @return the score value
     */

    public int calculateScore() {
        return (int)(this.level.getDifficulty() + wpm + accuracy);
    }
}
