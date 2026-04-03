package typerunner.backend;

/**
 * Bot
 * 
 * Represents a computer-controlled opponent in a TypeRunner race.
 * Extends Player to inherit basic player properties, but uses
 * simulated typing behavior instead of real user input.
 * 
 * @author Olurnfemi Martins Kayode
 * @author Noh Woldetinsae
 */
public class Bot extends Player {

    /** Flag for tracking if this bot has crossed the finish line */
    private boolean finishedRace;

    /**
     * Bot Constructor
     * 
     * Creates a new bot opponent with a given name and no password.
     * 
     * @param botName the display name of the bot
     */
    public Bot(String botName) {
        super(botName, "none");
        this.finishedRace = false;
    }

    /**
     * Is Finished
     * 
     * Returns whether this bot has completed the race.
     * Finished bots are immune to setback power-ups.
     * 
     * @return true if the bot has crossed the finish line
     */
    public boolean isFinished() {
        return finishedRace;
    }

    /**
     * Set Finished
     * 
     * Marks this bot as having completed the race.
     * 
     * @param finished true to mark as finished, false otherwise
     */
    public void setFinished(boolean finished) {
        this.finishedRace = finished;
    }

    /**
     * Generate Typed Text
     * 
     * Simulates the bot typing a given prompt.
     * 
     * @param prompt the text the bot should type
     * @return the simulated typed output
     */
    public String generateTypedText(String prompt) {
        return "";
    }

    /**
     * Simulate Score
     * 
     * Generates a simulated score for the bot at the end of a race.
     * 
     * @return the bot's simulated score
     */
    public int stimulateScore() {
        return 0;
    }
}