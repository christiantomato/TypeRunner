package typerunner.backend;

import java.util.ArrayList;
import java.util.Random;

/**
 * Manages the state and logic for a single race in the TypeRunner game. This
 * class tracks the player's progress, speed, stamina, and handles the
 * activation of power-ups like SpeedBoost and StaminaRefill based on game
 * events.
 *
 * @author Olorunfemi Martins
 * @author Noh Woldetinsae
 * @author Tanya Sahota
 * @version 1.0
 */
public class Race {

    /*The total number of words in the race text.*/
    private int totalWords;
    
    /**The elapsed time in the race.*/
    private int time;

    /**The number of consecutively typed correct words.*/
    private int wordsTyped;

    /*** The player's current words per minute (WPM).*/
    private int wpm;

    /**The player's current speed or progress metric. Will be used to determine how far the player goes in the screen*/
    private int playerSpeed;

    /** The player's current stamina, ranging from 0 to 100.*/
    private int Stamina = 100;

    /**The word list used for this specific race*/
    private ArrayList<Word> wordList;

    /**The actual string of words that the frontend will use*/
    private String raceText;

    /** the index for the race text */
    private int currentRaceIndex = 0;

    /* Track the current word the player is typing from wordList */
    private int currentWordIndex = 0;

    /* Track the start and end times of the race */
    private long startTime;
    private long endTime;

    /*Speed of the bot i.e. duration of translation */
    private int botSpeed;

    public Race() {
        //this.level = GameEngine.getInstance().getLevel();
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

        //int randomIndex = random.nextInt(5460);
        //list.add(dictionary.getWordList().get(randomIndex));
        //fullText.append(list.get(0).getFullText());


        for (int i = 1; i < numWords; i++) {
            int randomIndex = random.nextInt(5460);
            String wordToAdd = dictionary.getWordList().get(randomIndex).getFullText();
            
            //add a space after each word except for the last one
            if(i<numWords -1){
                wordToAdd += " ";
            }

            list.add(new Word(wordToAdd));
            fullText.append(wordToAdd);
        }

        //set the string of text to be typed
        this.raceText = fullText.toString();

        //set the created word list
        this.wordList = list;

        // Set total words for tracking progress
        this.totalWords = wordList.size();


        /* 
        * Commented out for now will deal with bot logic later
        * Set bot speed based on the level's difficulty

        this.botSpeed = level.getDifficulty() * 10; 
        */
        
    }

    /**
     * Returns the full race text for the frontend to display.
     *
     * @return the race text.
     */
    public String getRaceText() {
        return this.raceText;
    }

    /**
     * Get Current Race Index
     * 
     * Getter for the index in the race text
     * 
     * @return the current index in the race text
     */

    public int getCurrentRaceIndex() {
        return this.currentRaceIndex;
    }

    /**
     * Processes a single character input.
     *
     * @param input The character typed by the user get that
     * @return true if the character was correct, false otherwise.
     */
    public boolean checkInput(char input) {

        if (currentWordIndex >= wordList.size()) {
            return false; // prevent indexOutofBounds exception if all words are completed
        }

        // Get the word the player is currently supposed to type from the wordList
        Word currentWord = wordList.get(currentWordIndex);

        // Check if the character matches the next character in that word
        // calls the checkCharacterMatch method in Word.java to see if the char inputted matches the next char in the word
        boolean isCorrect = currentWord.checkCharacterMatch(input);

        //If the character they typed is correct, we check if the word is complete and move to the next one if it is 
        if (isCorrect) {
            if(currentWord.isComplete()) {

                //wordsTypedIncrement(currentWord); 
                currentWordIndex++;
            }
        } else {
            // Handle a typo: reduce stamina directly
            reduceStamina(5);
        }

        this.currentRaceIndex+=1;
        return isCorrect;
    }


    

    /**
     * Starts the race timer.
     */
    public void startRaceTime() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Ends the race timer.
     */
    public void endRaceTime() {
        endTime = System.currentTimeMillis();
    }

    /**
     * Gets the total number of words for the race.
     *
     * @return the total number of words.
     */
    public int getTotalWords() {
        return totalWords;
    }

    /**
     * Sets the total number of words for the race.
     *
     * @param totalWords the total number of words.
     */
    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }



    /**
     * Gets the speed of the bot opponent.
     *
     * @return the bot's speed.
     */
    public int getBotSpeed() {
        return this.botSpeed;
    }

    /**
     * Sets the speed of the bot opponent.
     * This will be used to set the translation duration of the bot in the frontend and will be based on the level difficulty and if the speedboost powerup is triggered or not
     *
     * @param botSpeed the bot's new speed.
     * @return the bot's updated speed.
     */
    public int setBotSpeed(int botSpeed) {
        this.botSpeed = botSpeed;
        return botSpeed;
    }

    /**
     * Gets the elapsed time of the race.
     *
     * @return elapsed time
     */
    public int getTimeInSeconds() {
        return (int) ((endTime - startTime) / 1000);
    }

    /**
     * Gets the player's current speed.
     *
     * @return the player's speed.
     */
    public int getPlayerSpeed() {
        return playerSpeed;
    }

    /**
     * Sets the player's current speed.
     *
     * @param playerSpeed the player's new speed.
     */
    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    /**
     * Applies a speed boost to the player based on the current level. This
     * method creates a {@link SpeedBoost} power-up and increases the player's
     * speed.
     *
     * @param level the current game level, used to determine the boost amount.
     */
    public void triggerSpeedBoost(int level) {
        // let's first get the player moving
        // and logic should be changed so that the bots are the ones that move back


        /*
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
        */

    }

    /**
     * Sets the elapsed time for the race.
     *
     * @param time the new time value.
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Updates the race state after a word is typed. If the word is completed
     * correctly, the typed word counter increases. If the word is incorrect,
     * stamina is reduced and the counter resets. This method also checks
     * whether stamina refill or speed boost power-ups should be triggered based
     * on the player's current state and level.
     *
     * @param word the {@link Word} object that was just attempted by the
     * player.
     */
    public void wordsTypedIncrement(Word word) {
        if (word.isComplete()) {
            wordsTyped++;
        } else {
            reduceStamina(20); // Reduce stamina by 20 for each incorrect word
            wordsTyped = 0; // Reset consecutive words count on incorrect word 
        }

        int stams = checkStamina();
        if (stams <= 50 && wordsTyped > 0) {
            StaminaRefill staminaRefill = new StaminaRefill(20); // Example stamina bonus
            if (staminaRefill.isTriggered()) {
                Stamina += staminaRefill.getStaminaBonus(GameEngine.getInstance().getLevel().getDifficulty());
                if (Stamina > 100) {
                    Stamina = 100; // Cap stamina at 100
                }
            }
        }

        /*Old logic for speedboost */
        /* 
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
        */

    }

    /**
     * Gets the player's current words per minute (WPM).
     *
     * @return the current WPM.
     */
    public int getWpm() {
        return wpm;
    }

    /**
     * Updates the player's words per minute (WPM).
     */
    public void updateWpm() {
        
        int elapsedTimeInSeconds = getTimeInSeconds();
        if (elapsedTimeInSeconds > 0) {
            this.wpm = (int) ((wordsTyped / (double) elapsedTimeInSeconds) * 60);
        } else {
            this.wpm = 0; // Avoid division by zero
        }
    }

    /**
     * Gets the player's current stamina.
     *
     * @return the current stamina value.
     */
    public int getStamina() {
        return Stamina;
    }

    /**
     * Checks the player's current stamina.
     *
     * @return the current stamina value.
     */
    public int checkStamina() {
        return Stamina;
    }


    /**
     * Reduces the player's stamina by a specified amount. Stamina will not drop
     * below 0.
     *
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
