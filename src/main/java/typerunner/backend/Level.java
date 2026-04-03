package typerunner.backend;

/**
 * Level Enumeration
 * 
 * Just an enumeration for our 3 different levels, defined from easiest to hardest:
 * 
 * HIGHSCHOOL (default)
 * COLLEGE (unlocked at a wpm of 60> achieved)
 * OLYMPICS (unlocked at a wpm of 80> achieved)
 * 
 * @author Christian Tamayo
 * @author Olorunfemi Martins
 */

public enum Level {

    HIGHSCHOOL(1),
    COLLEGE(2),
    OLYMPICS(3);

    /** the integer for difficulty based on enum */
    private final int difficulty;

    /**
     * Enum Constructor
     * 
     * Set the corresponding difficulty for each enum. 
     * 
     * @param difficulty
     */

    Level(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Get Difficulty
     * 
     * Getter for the enum as int
     * 
     * @return the enum difficulty integer
     */

    public int getDifficulty() {
        return difficulty;
    }
}
