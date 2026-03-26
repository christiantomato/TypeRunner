package typerunner.backend;

/**
 * Represents a player's score entry in the TypeRunner game.
 * This class stores the player's name, their achieved score, and the level they reached.
 * @author Olorunfemi Martins
 */
public class scores {
    private String name;
    private int score;
    private int level;

    /**
     * Constructs a new scores object with the specified name, score, and level.
     *
     * @param name  the name of the player
     * @param score the score achieved by the player
     * @param level the level reached by the player
     */
    public scores(String name, int score, int level) {
        this.name = name;
        this.score = score;
        this.level = level;
    }

    /**
     * Gets the level reached by the player.
     *
     * @return the player's level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the name of the player.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the score achieved by the player.
     *
     * @return the player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the name of the player.
     *
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the score achieved by the player.
     *
     * @param score the new score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Sets the level reached by the player.
     *
     * @param level the new level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

}