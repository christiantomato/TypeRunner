package typerunner.backend;

/**
 * Word Data Model
 * 
 *This class represents a word that the player needs to type during the race.
 * It keeps track of the full text of the word, the current index of the character being typed, 
 * and if typed perfectly to build streaks. 
 * 
 * @author Christian Tamayo
 * @author Noh Woldetinsae
 */

public class Word {

    /** the full string of the word, including last space */
    private String fullText;
    /** the index of where we are in the word */
    private int typeIndex;
    /** keeps track if we ever made a mistake in this word */
    private boolean perfectlyTyped = true;

    /**
     * Word Constructor 
     * 
     * Constructor for the Word class. It uses the full text of the word and its points value to initialize the object.
     * @param fullText The full text of the word that the player needs to type.
     */

    public Word(String fullText) {
        this.fullText = fullText;
        this.typeIndex = 0;
    }

    /**
     * Check Character Match
     * 
     * Checks if the input character matches the next character in the word that the player needs to type.
     * If it matches, it advances the type index and returns true. Otherwise, it returns false.
     * 
     * @param input The character input by the player.
     * @return True if the input character matches the next character in the word, false otherwise.
     */

    public boolean checkCharacterMatch(char input) {
        //check if it matches
        if(!isComplete() && input == fullText.charAt(typeIndex)) {
            //increase the type index
            typeIndex++;
            return true;
        }
        else {
            //made an error, not a correctly typed word
            this.perfectlyTyped = false;
            //increase even if wrong, will handle with backspace
            typeIndex++;
            return false;
        }
    }

    /**
     * Returns the full text of the word.
     * @return The full text of the word.
     */
    
    public String getFullText() {
        return fullText;
    }

    /**
     * Returns the current index of the character being typed.
     * @return The current index of the character being typed.
     */ 

    public int getTypeIndex() {
        return typeIndex;
    }

    /**
     * Decrement Type Index
     * 
     * Called when we need to move back in a word for backspace 
     */

    public void decrementTypeIndex() {
        this.typeIndex--; 
    }

    /**
     * Is Perfectly Typed
     * 
     * Returns if no mistakes were made while typing this word
     * 
     * @return true if perfectly typed, false otherwise
     */

    public boolean isPerfectlyTyped() {
        return this.perfectlyTyped;
    }

    /**
     * Checks if the player has completed typing the word by comparing the type index with the length of the full text.
     * @return True if the player has completed typing the word, false otherwise.
     */

    public boolean isComplete() {
        return typeIndex >= fullText.length();
    }

    /**
     * ToString
     * 
     * Returns the text of the word to type. 
     */

    @Override
    public String toString(){
        return fullText;
    }
}
