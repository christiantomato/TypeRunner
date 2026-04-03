package typerunner.backend;

import java.util.ArrayList;
import java.util.Random;

/**
 * Manages the state and logic for a single race in the TypeRunner game. This
 * class tracks the player's progress, speed, stamina, and handles the
 * activation of power-ups like SpeedBoost and staminaRefill based on game
 * events.
 *
 * @author Christian Tamayo
 * @author Noh Woldetinsae
 * @author Olorunfemi Martins
 */

public class Race {

    //Typing 

    /** The word list used for this specific race */
    private ArrayList<Word> wordList;
    /** The actual string of words that the frontend will use */
    private String raceText;
    /** The index in the string of the race text */
    private int currentStringIndex;
    /** The index for the current word the player is typing from wordList */
    private int currentWordIndex;
    /** Perfect typed words count - no mistakes */
    private int perfectWordStreak;

    //Race Variables

    /** The elapsed time in the race.*/
    private int time;
    /** Track the start and end times of the race */
    private long startTime;
    private long endTime;
    /** Error count */
    private int errorCount;
    /** Speed of the bot i.e. duration of translation */
    private int botSpeed;

    //Player Statistics Tracking

    /** The player's current words per minute (WPM).*/
    private int wpm;
    /** Peak wpm for the race */
    private int peakWPM;
    /** Accuracy */
    private double accuracy;
    /** Current score */
    private Score score;
    /** The player's current stamina, ranging from 0 to 100.*/
    private int stamina = 100;

    //Constants

    /** base words constant */
    public static final int BASE_WORDS = 15;
    /** max words list constant */
    public static final int MAX = 5460;


    /**
     * Race Constructor
     * 
     * Sets up the race with initial values and builds the string to type out.
     */

    public Race() {
        //initialize all starting values
        this.currentStringIndex = 0;
        this.currentWordIndex = 0;
        this.perfectWordStreak = 0;
        this.time = 0;
        this.errorCount = 0;
        this.wpm = 0;
        this.peakWPM = 0;
        this.accuracy = 0.0;
        this.stamina = 100;
        this.score = new Score(GameEngine.getInstance().getLevel());

        //modify health if instant death
        if(GameEngine.getInstance().getInstantDeath()) {
            this.stamina = 1;
        }

        //get difficulty and num words
        ArrayList<Word> list = new ArrayList<>();
        int multiplier = GameEngine.getInstance().getLevel().getDifficulty();
        //multiply the amount of words by level difficulty
        int numWords = BASE_WORDS * multiplier;

        Dictionary dictionary = new Dictionary();
        Random random = new Random();

        //build the target text along with the words list
        StringBuilder fullText = new StringBuilder();

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

        /* 
        * Commented out for now will deal with bot logic later ----> ok if you say so - chris
        * Set bot speed based on the level's difficulty

        this.botSpeed = level.getDifficulty() * 10; 
         */
    }

    /**
     * Check Input
     * 
     * Critical function that processes a single character input.
     *
     * @param input The character typed by the user
     * @return true if the character typed was correct, false otherwise.
     */

    public boolean checkInput(char input) {
        //when the first char is typed, start the timer
        if(this.currentStringIndex == 0) {
            System.out.println("starting timer");
            startRaceTime();
        }

        //Get the word the player is currently supposed to type from the wordList
        Word currentWord = this.wordList.get(currentWordIndex);
        //Check if the character matches the next character in that word
        boolean isCorrect = currentWord.checkCharacterMatch(input);

        //update game stats
        GameEngine.getInstance().updateGame();

        //some debugging print statements
        //System.out.println("current word: " + currentWord);
        //System.out.println("current word index now: " + currentWord.getTypeIndex());
        //System.out.println("Elapsed time in seconds: " + getTimeInSeconds() + "s");
        //System.out.println("Current stamina: " + getStamina());

        //If the character they typed is correct, we check if the word is complete and move to the next one if it is 
        if(isCorrect) {
            //check if it is complete
            if(currentWord.isComplete()) {
                System.out.println("going to next word.");
                //update word streak
                this.streakIncrement(currentWord); 
                this.currentWordIndex++;
            }
        } 
        else {
            //Handle a typo:

            //reduce stamina
            reduceStamina(5);
            //add an error
            this.errorCount++;
            //Reset perfect word streak on a typo
            this.perfectWordStreak = 0;
        }

        //GAME END if string index reached end
        if(this.currentStringIndex == this.raceText.length() - 1) {
            System.out.println("ending timer");
            //End the timer when the last character is typed
            this.endRaceTime(); 
            // when the player finishes a race, call the endGame method in GameEngine
            GameEngine.getInstance().endGame(); 
            return true;
        }

        //increment the string index whether correct or not
        this.currentStringIndex += 1;
        //return the boolean for correct input
        return isCorrect;
    }

    /**
     * Handle Backspace
     *
     * Handles logic and decrements indices when backspace is pressed.
     */

    public void handleBackspace() {
        System.out.println("handling backspace");

        //Get the word the player is currently supposed to type from the wordList
        Word currentWord = wordList.get(this.currentWordIndex);

        //if we are on the first letter of the word
        if (currentWord.getTypeIndex() == 0) {
            //go back a word, unless we are on the very first word then do nothing
            if (this.currentWordIndex == 0) {
                return;
            }
            //go back a word
            this.currentWordIndex--;
            //set the new current word
            currentWord = wordList.get(this.currentWordIndex);
            //decrement the word type index
            currentWord.decrementTypeIndex();
        } 
        else {
            //otherwise, go back a letter in the word
            currentWord.decrementTypeIndex();
        }

        //prints for debugging
        //System.out.println("the current word: " + currentWord);
        //System.out.println("the index for the current word now: " + currentWord.getTypeIndex());

        //decrement it for the entire race text
        if (this.currentStringIndex > 0) {
            this.currentStringIndex--;
        }
    }

    /**
     * Streak Increment
     * 
     * Checks if we are hitting a streak of perfectly typed words.
     * 5 in a row equals a power up. 
     * 
     * @param word that was just typed completely
     */

    public void streakIncrement(Word word) {
        //check if the word has been completely typed and typed perfecly
        if(word.isPerfectlyTyped()) {
            this.perfectWordStreak++;
        } 
        else {
            //reset streak
            this.perfectWordStreak = 0;
        }

        //if below half stamina and reached a perfect word streak of 5, activite stamina refill (unless we are on instant death!)
        if(this.stamina <= 50 && this.perfectWordStreak == 5 && !GameEngine.getInstance().getInstantDeath()) {
            StaminaRefill staminaRefill = new StaminaRefill(20);
            this.stamina += staminaRefill.getStaminaBonus(GameEngine.getInstance().getLevel().getDifficulty());
            if (stamina > 100) {
                stamina = 100; // Cap stamina at 100
            }
            System.out.println("Stamina refill triggered! New stamina: " + this.stamina);
            //reset the perfect word streak
            this.perfectWordStreak = 0;
        }
    }

    /**
     * Reduce Stamina
     * 
     * Reduces the player's stamina by a specified amount. Ends the game if they lose all. 
     *
     * @param amount the amount to reduce stamina by.
     * @return the new stamina value after reduction.
     */

    public void reduceStamina(int amount) {
        this.stamina -= amount;
        if(stamina <= 0) {
            //the player died, game should end, write stats, display just 0 tho
            this.stamina = 0;
            GameEngine.getInstance().endGame();
        }
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
     * Update WPM
     * 
     * Updates the player's words per minute (WPM).
     * TODO: make peakWPM not cooked...
     */
    
    public void updateWpm() {
        int elapsedTimeInSeconds = getTimeInSeconds();
        if (elapsedTimeInSeconds > 0) {
            this.wpm = (int) ((this.currentWordIndex / (double) elapsedTimeInSeconds) * 60);
            if (this.wpm > this.peakWPM) {
                this.peakWPM = this.wpm; // Update peak WPM if current WPM is higher
            }
        } else {
            this.wpm = 0; // Avoid division by zero
        }
    }

    /**
     * Get WPM
     * 
     * Gets the player's current words per minute (WPM).
     *
     * @return the current WPM.
     */

    public int getWpm() {
        return this.wpm;
    }

     /**
     * Update Accuracy
     * 
     * Updates the accuracy by calculating correct/total.
     */

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
     * Trigger Setback
     * 
     * Returns the setback distance for bots based on the current level.
     * Called when the player hits a word streak milestone.
     * 
     * @return the distance to push bots back
     */

    public double triggerSetback() {
        switch (GameEngine.getInstance().getLevel()) {
            case HIGHSCHOOL:
                return 30.0;
            case COLLEGE:
                return 50.0;
            case OLYMPICS:
                return 80.0;
            default:
                return 30.0;
        }
    }

    /**
     * Check if setback should trigger
     * Triggers every 5 correct words
     * 
     * @return true if the streak milestone was just hit
     */

    public boolean shouldTriggerSetback() {
        return perfectWordStreak > 0 && perfectWordStreak % 5 == 0;
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
     * Gets the speed of the bot opponent.
     *
     * @return the bot's speed.
     */
    public int getBotSpeed() {
        return this.botSpeed;
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
    public int getCurrentStringIndex() {
        return this.currentStringIndex;
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
     * Sets the elapsed time for the race.
     *
     * @param time the new time value.
     */

    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Error Count 
     * @return error count
     */
    public int getErrorCount() {
        return this.errorCount;
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
     * Typed Words
     * 
     * Getter for the number of typed words, wherever the word index ended.
     * 
     * @return typed words    
     */
    public int getTypedWords() {
        return this.currentWordIndex;
    }
}
