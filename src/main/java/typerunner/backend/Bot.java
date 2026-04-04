package typerunner.backend;

/**
 * Bot Class
 * 
 * Represents a computer-controlled opponent in a TypeRunner race.
 * Extends Player to inherit basic player properties, but uses
 * simulated typing behavior instead of real user input.
 * 
 * @author Olurnfemi Martins Kayode
 * @author Noh Woldetinsae
 * @author Tanya Sahota
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
        return this.finishedRace;
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
}