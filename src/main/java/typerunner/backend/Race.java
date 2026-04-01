package typerunner.backend;

/**
 * Manages the state and logic for a single race in the TypeRunner game.
 * This class tracks the player's progress, speed, stamina, and handles the
 * activation of power-ups like SpeedBoost and StaminaRefill based on game events.
 *
 * @author Olorunfemi Martins
 * @author Tanya Sahota
 * @version 1.0
 */
public class Race {

    /** The total number of words in the race text. */
    private int totalWords;
    /** The difficulty level of the current race. */
    private Level level = Level.HIGHSCHOOL;
    /** The speed of the bot opponent. */
    private int botSpeed;
    /** The elapsed time in the race. */
    private int time;
    /** The number of consecutively typed correct words. */
    private int wordsTyped;
    /** The player's current words per minute (WPM). */
    private int wpm;
    /** The player's current speed or progress metric. */
    private int playerSpeed;
    /** The player's current stamina, ranging from 0 to 100. */
    private int Stamina = 100;

    /**
     * Gets the total number of words for the race.
     * @return the total number of words.
     */
    public int getTotalWords() {
        return totalWords;
    }  

    /**
     * Sets the total number of words for the race.
     * @param totalWords the total number of words.
     */
    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    /**
     * Gets the difficulty level of the race.
     * @return the race {@link Level}.
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Sets the difficulty level for the race.
     * @param level the race {@link Level}.
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Gets the speed of the bot opponent.
     * @return the bot's speed.
     */
    public int getBotSpeed() {
        return botSpeed;
    }

    /**
     * Sets the speed of the bot opponent.
     * @param botSpeed the bot's new speed.
     * @return the bot's updated speed.
     */
    public int setBotSpeed(int botSpeed) {
        this.botSpeed = botSpeed;
        return botSpeed;
    }

    /**
     * Gets the elapsed time of the race.
     * @return the current time.
     */
    public int getTime() {
        return time;
    }   

    /**
     * Gets the player's current speed.
     * @return the player's speed.
     */
    public int getPlayerSpeed() {
        return playerSpeed;
    }

    /**
     * Sets the player's current speed.
     * @param playerSpeed the player's new speed.
     */
    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    /**
     * Applies a speed boost to the player based on the current level.
     * This method creates a {@link SpeedBoost} power-up and increases the player's speed.
     * 
     * @param level the current game level, used to determine the boost amount.
     */
    public void triggerSpeedBoost(int level) {
       

        switch (level) {
            case 1:
                SpeedBoost speedBoost = new SpeedBoost(level, 10, 5);

                if (speedBoost.isTriggered()) {
                    setPlayerSpeed(getPlayerSpeed() + speedBoost.getBoostDistance(level));
                }
                break;
            case 2:
                SpeedBoost speedBoost2 = new SpeedBoost(level, 20, 10); 
                if (speedBoost2.isTriggered()) {
                    setPlayerSpeed(getPlayerSpeed() + speedBoost2.getBoostDistance(level));
                }
                break;
            case 3:
                SpeedBoost speedBoost3 = new SpeedBoost(level, 30, 15);
                if (speedBoost3.isTriggered()) {
                    setPlayerSpeed(getPlayerSpeed() + speedBoost3.getBoostDistance(level));
                }
                break;
            default:
                // Handle default case if needed
                break;

        }   
    }

    /**
     * Sets the elapsed time for the race.
     * @param time the new time value.
     */
    public void setTime(int time) {
        this.time = time;
    }  


    /**
     * Updates the race state after a word is typed.
     * If the word is completed correctly, the typed word counter increases.
     * If the word is incorrect, stamina is reduced and the counter resets.
     * This method also checks whether stamina refill or speed boost power-ups
     * should be triggered based on the player's current state and level.
     *
     * @param word the {@link Word} object that was just attempted by the player.
     */
    public void wordsTypedIncrement(Word word) {
        if (word.isComplete()) {
            wordsTyped++;
        }
        else {
            reduceStamina(20); // Reduce stamina by 20 for each incorrect word
            wordsTyped = 0; // Reset consecutive words count on incorrect word 
        }

        int stams = checkStamina();
        if (stams <= 50 && wordsTyped > 0) {
            StaminaRefill staminaRefill = new StaminaRefill(20); // Example stamina bonus
            if (staminaRefill.isTriggered()) {
                Stamina += staminaRefill.getStaminaBonus(level.getDifficulty());
                if (Stamina > 100) {
                    Stamina = 100; // Cap stamina at 100
                }
            }
        }



        int levelnum = level.getDifficulty();
        if (levelnum == 1 && wordsTyped == 5) {
            triggerSpeedBoost(levelnum);
            wordsTyped = 0; // Reset consecutive words count after triggering boost
        } else if (levelnum == 2 && wordsTyped == 10) {
            triggerSpeedBoost(levelnum);
            wordsTyped = 0; // Reset consecutive words count after triggering boost
        } else if (levelnum == 3 && wordsTyped == 15) {
            triggerSpeedBoost(levelnum);
            wordsTyped = 0; // Reset consecutive words count after triggering boost
        }
  
    }

    /**
     * Gets the player's current words per minute (WPM).
     * @return the current WPM.
     */
    public int getWpm() {
        return wpm;
    }

    /**
     * Updates the player's words per minute (WPM).
     * Note: This method is currently a placeholder and has no implementation.
     */
    public void updateWpm() {
    }

    /**
     * Gets the player's current stamina.
     * @return the current stamina value.
     */
    public int getStamina() {
        return Stamina;
    }

    /**
     * Checks the player's current stamina.
     * @return the current stamina value.
     */
    public int checkStamina() {
        return Stamina;
    }

    /**
     * Reduces the player's stamina by a specified amount.
     * Stamina will not drop below 0.
     * @param amount the amount to reduce stamina by.
     * @return the new stamina value after reduction.
     */
    public int reduceStamina(int amount) {
        Stamina -= amount;
        if (Stamina < 0) {
            Stamina = 0; // Ensure stamina doesn't go negative
        }
        return Stamina;
    }   


    
    
}
