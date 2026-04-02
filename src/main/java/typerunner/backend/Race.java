package typerunner.backend;

import java.util.ArrayList;
import java.util.Random;

/**
 * Manages the state and logic for a single race in the TypeRunner game.
 * This class tracks the player's progress, speed, stamina, and handles the
 * activation of power-ups like SpeedBoost and StaminaRefill based on game events.
 *
 * @author Olorunfemi Martins
 * @author Noh Woldetinsae
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

    /** The word list used for this specific race */
    private ArrayList<Word> wordList;

    /** the actual string of words */
    private String raceText;

    /* Track the current word the player is typing */
    private int currentWordIndex = 0;

    /* Track the start and end times of the race */
    private long startTime;
    private long endTime;



    public Race() {
        this.level = GameEngine.getInstance().getLevel();
        //this.wordList = selectedWords;
        // Initialize starting values
        this.currentWordIndex = 0;
        this.wordsTyped = 0;
        this.Stamina = 100;
        this.time = 0;

        //get difficulty and num words
        ArrayList<Word> list = new ArrayList<>();
        int multiplier = GameEngine.getInstance().getLevel().getDifficulty();
        int numWords = 25 * multiplier;

        Dictionary dictionary = new Dictionary();
        Random random = new Random();

        //build the target text along with the words list
        StringBuilder fullText = new StringBuilder();

        int randomIndex = random.nextInt(5640);
        list.add(dictionary.getWordList().get(randomIndex));
        fullText.append(list.get(0).getFullText());

        for(int i = 1; i < numWords; i++) {
            randomIndex = random.nextInt(5640);
            list.add(dictionary.getWordList().get(randomIndex));
            fullText.append(" ").append(list.get(i).getFullText());
        }

        //set the string of text to be typed
        this.raceText = fullText.toString();

        //set the created word list
        this.wordList = list;

        // Set total words for tracking progress
        //this.totalWords = selectedWords.size();
    
        // Set bot speed based on the level's difficulty
        this.botSpeed = level.getDifficulty() * 10;
    }

    /*
    * Return the full race text
     */
    public String getRaceText() {
        return this.raceText;
    }



    /**
     * Processes a single character input.
     * @param input The character typed by the user.
     * @return true if the character was correct, false otherwise.
     */
    public boolean checkInput(char input) {
        if (currentWordIndex >= wordList.size()) return false; // prevent indexOutofBounds exception if all words are completed

        // Get the word the player is currently supposed to type
        Word currentWord = wordList.get(currentWordIndex);
        
        // Check if the character matches the next character in that word
        boolean isCorrect = currentWord.checkCharacterMatch(input);

        if (isCorrect) {
            // If the word is finished, move to the next one
            if (currentWord.isComplete()) {
                wordsTypedIncrement(currentWord); // Trigger your stamina/boost logic
                currentWordIndex++;
            }
        } else {
            // Handle a typo: reduce stamina directly
            reduceStamina(5);
        }
        
        return isCorrect;
    }


    public void startRaceTime(){
        startTime = System.currentTimeMillis();
    }

    public void endRaceTime(){
        endTime = System.currentTimeMillis();
    }
    

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
     * @return elapsed time
     */
    public int getTimeInSeconds() {
        return (int) ((endTime - startTime) / 1000);
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
