package typerunner.backend;

/**
    * This class represents a word that the player needs to type during the race.
    * It keeps track of the full text of the word, the current index of the character being typed, and the points value of the word.
    * @author Noh Woldetinsae 

*/
public class Word {

    private String fullText;
    private int typeIndex;
    private int pointsValue;

    /**
     * Constructor for the Word class. It uses the full text of the word and its points value to initialize the object.
     * @param fullText The full text of the word that the player needs to type.
     * @param pointsValue The points value of the word, which determines how many points the player earns for typing it correctly.
     */
    public Word(String fullText) {
        this.fullText = fullText;
        //this.pointsValue = pointsValue;
        this.typeIndex = 0;
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
     * Returns the points value of the word.
     * @return The points value of the word.
     */ 
    public int getPointsValue() {
        return pointsValue;
    }
    
    /**
     * Checks if the input character matches the next character in the word that the player needs to type.
     * If it matches, it advances the type index and returns true. Otherwise, it returns false.
     * @param input The character input by the player.
     * @return True if the input character matches the next character in the word, false otherwise.
     */
    public boolean checkCharacterMatch(char input) {
        if(!isComplete() && input == fullText.charAt(typeIndex)) {
            typeIndex++;
            return true;
        }
        return false;
    }

    /**
     * Checks if the player has completed typing the word by comparing the type index with the length of the full text.
     * @return True if the player has completed typing the word, false otherwise.
     */
    public boolean isComplete() {
        return typeIndex >= fullText.length();
    }

    /**
     * Returns the remaining text that the player needs to type. If the word is complete, it returns an empty string.
     * @return The remaining text that the player needs to type, or an empty string if the word is complete.
     */
    public String getRemainingText() {
        if(isComplete()) {
            return "";
        }
        return fullText.substring(typeIndex);
    }


}
