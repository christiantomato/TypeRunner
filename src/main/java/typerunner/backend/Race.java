package typerunner.backend;

import java.util.ArrayList;
import java.util.Random;

/**
 * Manages the state and logic for a single race in the TypeRunner game. This
 * class tracks the player's progress, speed, stamina, and handles the
 * activation of power-ups like SpeedBoost and staminaRefill based on game
 * events.
 *
 * @author Olorunfemi Martins
 * @author Noh Woldetinsae
 * @author Tanya Sahota
 * @author Christian Tamayo
 * @version 1.0
 */

public class Race {

    //Typing 

    /** The word list used for this specific race */
    private ArrayList<Word> wordList;
    /** The total number of words in the race text.*/
    private int totalWords;
    /** The actual string of words that the frontend will use */
    private String raceText;
    /** The index in the string of the race text */
    private int currentRaceIndex = 0;
    /** The index for the current word the player is typing from wordList */
    private int currentWordIndex = 0;

    //race variables

    /** The elapsed time in the race.*/
    private int time;
    /** Track the start and end times of the race */
    private long startTime;
    private long endTime;
    /** Counter for correct characters typed. */
    private int correctCounter = 0;
    /** Error count */
    private int errorCount = 0;

     /** Speed of the bot i.e. duration of translation */
    private int botSpeed;

    //player statistics tracking

    /** The player's current words per minute (WPM).*/
    private int wpm;
    /** Peak wpm for the race */
    private int peakWPM = 0;
    /** Accuracy */
    private double accuracy = 0.0;
    /** Current score */
    private Score score;
    /** The number of consecutively typed correct words.*/
    private int currentWordStreak;
    /** The player's current stamina, ranging from 0 to 100.*/
    private int stamina = 100;

    //constants

    /** base words constant */
    public static final int BASE_WORDS = 15;
    /** max words list constant */
    public static final int MAX = 5460;

    public Race() {
        // Initialize starting values
        this.currentWordIndex = 0;
        this.currentWordStreak = 0;
        this.wpm = 0;
        this.time = 0;
        this.score = new Score(GameEngine.getInstance().getLevel());

        //set health for instant death
        if(GameEngine.getInstance().getInstantDeath()) {
            this.stamina = 1;
        }
        else this.stamina = 100;

        //get difficulty and num words
        ArrayList<Word> list = new ArrayList<>();
        int multiplier = GameEngine.getInstance().getLevel().getDifficulty();
        int numWords = BASE_WORDS * multiplier;

        Dictionary dictionary = new Dictionary();
        Random random = new Random();

        //build the target text along with the words list
        StringBuilder fullText = new StringBuilder();

        //int randomIndex = random.nextInt(5460);
        //list.add(dictionary.getWordList().get(randomIndex));
        //fullText.append(list.get(0).getFullText());
        for (int i = 0; i < numWords; i++) {
            int randomIndex = random.nextInt(MAX);
            String wordToAdd = dictionary.getWordList().get(randomIndex).getFullText();

            //add a space after each word except for the last one
            if (i < numWords - 1) {
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
        // if player health/stamina is 0 then end the game
        if(getStamina() <= 0) {
            GameEngine.getInstance().endGame();
            return false;
        }


        // when the first char is typed, start the timer
        if (currentRaceIndex == 0) {
            GameEngine.getInstance().updateGame();
            System.out.println("starting timer");
            startRaceTime();
        }
        if (currentWordIndex >= wordList.size()) {
            return false; // prevent indexOutofBounds exception if all words are completed
        }

        //update WPM every time they type a char
        updateWpm();
        System.out.println("current WPM: " + getWpm());

        // Get the word the player is currently supposed to type from the wordList
        Word currentWord = wordList.get(currentWordIndex);

        // Check if the character matches the next character in that word
        // calls the checkCharacterMatch method in Word.java to see if the char inputted matches the next char in the word
        boolean isCorrect = currentWord.checkCharacterMatch(input);

        System.out.println("current word: " + currentWord);
        System.out.println("current word index now: " + currentWord.getTypeIndex());
        System.out.println("Elapsed time in seconds: " + getTimeInSeconds() + "s");
        System.out.println("Current stamina: " + getStamina());

        //If the character they typed is correct, we check if the word is complete and move to the next one if it is 
        if (isCorrect) {
            this.correctCounter++; // Increment correct character counter for accuracy calculation
            if (currentWord.isComplete()) {
                System.out.println("going to next word.");
                currentWordStreakIncrement(currentWord); 
                currentWordIndex++;
            }
        } else {
            // Handle a typo: reduce stamina directly
            reducestamina(5);

            // If what they tpyed is wrong, increase errorCount
             this.errorCount++;
           
        }

        this.currentRaceIndex += 1;

        //GAME END
        if (this.currentRaceIndex >= raceText.length()) {
            System.out.println("ending timer");
            //End the timer when the last character is typed
            endRaceTime(); 
            // when the player finishes a race, call the endGame method in GameEngine
            GameEngine.getInstance().endGame(); 
        }
        return isCorrect;
    }

    /** 
     * Calculate Accuracy */

    public void updateAccuracy() {
        this.accuracy = ((double) (((double)this.raceText.length() - (double)this.errorCount)/(double)this.raceText.length())) * 100;
    }

    /**
     * Gets the player's accuracy
     *
     * @return the current accuracy.
     */
    public double getAccuracy() {
        return this.accuracy;
    }

    /**
     * Handle Backspace
     *
     * Decrements indices when backspace is pressed.
     */
    public void handleBackspace() {
        System.out.println("handling backspace start");
        //Get the word the player is currently supposed to type from the wordList
        Word currentWord = wordList.get(this.currentWordIndex);

        //if we are on the first letter of the word
        if (currentWord.getTypeIndex() == 0) {
            //go back a word unless we are on the very first word
            if (this.currentWordIndex == 0) {
                return;
            }
            //go back a word
            this.currentWordIndex--;
            //set the new current word
            currentWord = wordList.get(this.currentWordIndex);
            //decrement index
            currentWord.decrementTypeIndex();
        } else {
            //otherwise, go back a letter in the word
            currentWord.decrementTypeIndex();
        }

        System.out.println("the current word: " + currentWord);
        System.out.println("the index for the current word now: " + currentWord.getTypeIndex());
        

        //decrement it for the entire race text
        if (this.currentRaceIndex > 0) {
            this.currentRaceIndex--;
        }
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
     * Error Count 
     * @return error count
     */
    public int getErrorCount() {
        return this.errorCount;
    }

    

    /**
     * Sets the speed of the bot opponent. This will be used to set the
     * translation duration of the bot in the frontend and will be based on the
     * level difficulty and if the speedboost powerup is triggered or not
     *
     * @param botSpeed the bot's new speed.
     * @return the bot's updated speed.
     */
    public int setBotSpeed(int botSpeed) {
        this.botSpeed = botSpeed;
        return botSpeed;
    }

    /**
     * Gets the elapsed time of the race. This will be used to calculate the
     * player's WPM and also for the frontend to display
     *
     * @return elapsed time
     */
    public int getTimeInSeconds() {
        long now = System.currentTimeMillis();
        if (this.endTime > 0) {
            now = endTime;
        }

        this.time = (int) ((now - startTime) / 1000);
        return time;
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
    public void currentWordStreakIncrement(Word word) {
        if (word.isComplete()) {
            currentWordStreak++;
        } else {
            reducestamina(10); // Reduce stamina by 20 for each incorrect word
            System.out.println("REDUCED STAMINA " + stamina);
            currentWordStreak = 0; // Reset consecutive words count on incorrect word 3

        }

        int stams = getStamina();
        if (stams <= 50 && currentWordStreak >=5) {
            StaminaRefill staminaRefill = new StaminaRefill(20); // Example stamina bonus
            if (staminaRefill.isTriggered()) {
                stamina += staminaRefill.getStaminaBonus(GameEngine.getInstance().getLevel().getDifficulty());
                if (stamina > 100) {
                    stamina = 100; // Cap stamina at 100
                }
                System.out.println("Stamina refill triggered! New stamina: " + stamina);
            }
        }

        /*Old logic for speedboost */
 /* 
        int levelnum = level.getDifficulty();
        if (levelnum == 1 && currentWordStreak == 5) {
            triggerSpeedBoost(levelnum);
            currentWordStreak = 0; // Reset consecutive words count after triggering boost
        } else if (levelnum == 2 && currentWordStreak == 10) {
            triggerSpeedBoost(levelnum);
            currentWordStreak = 0; // Reset consecutive words count after triggering boost
        } else if (levelnum == 3 && currentWordStreak == 15) {
            triggerSpeedBoost(levelnum);
            currentWordStreak = 0; // Reset consecutive words count after triggering boost
        }
         */
    }

    /**
     * Updates the player's words per minute (WPM).
     */
    public void updateWpm() {

        int elapsedTimeInSeconds = getTimeInSeconds();
        if (elapsedTimeInSeconds > 0) {
            this.wpm = (int) ((currentWordStreak / (double) elapsedTimeInSeconds) * 60);
            if (this.wpm > this.peakWPM) {
                this.peakWPM = this.wpm; // Update peak WPM if current WPM is higher
            }
        } else {
            this.wpm = 0; // Avoid division by zero
        }
    }

    /**
     * Gets the player's current words per minute (WPM).
     *
     * @return the current WPM.
     */
    public int getWpm() {
        return this.wpm;
    }

     /**
     * Getter for score
     * 
     * @return score
     */
    public int getScore() {
        return this.score.calculateScore(GameEngine.getInstance().getLevel(),this.wpm, this.accuracy);
    }

    /**
     * Get Peak WPM
     * 
     * @return peakWPM
     * Getter for the peak WPM achieved during
     */
    public int getPeakWPM() {
        return this.peakWPM;
    }

    /** 
     * Getter for the number of correctly typed words after game ends
     * 
     * @return correctly typed words    
     */
    public int getCorrectlyTypedWords() {
        return wordList.size(); 
    }

    /**
     * Gets the player's current stamina.
     *
     * @return the current stamina value.
     */
    public int getStamina() {
        return stamina;
    }


    /**
     * Reduces the player's stamina by a specified amount. stamina will not drop
     * below 0.
     *
     * @param amount the amount to reduce stamina by.
     * @return the new stamina value after reduction.
     */
    public int reducestamina(int amount) {
        stamina -= amount;
        if (stamina < 0) {
            stamina = 0; // Ensure stamina doesn't go negative
        }
        return stamina;
    }

}
