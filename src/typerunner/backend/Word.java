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
     * @param fullText
     * @param pointsValue
     */
    public Word(String fullText, int pointsValue) {
        this.fullText = fullText;
        this.pointsValue = pointsValue;
        this.typeIndex = 0;
    }

    public String getFullText() {
        return fullText;
    }

    public int getTypeIndex() {
        return typeIndex;
    }

    public int getPointsValue() {
        return pointsValue;
    }
    
    public boolean checkCharacterMatch(char input) {
        if(!isComplete() && input == fullText.charAt(typeIndex)) {
            typeIndex++;
            return true;
        }
        return false;
    }

    public boolean isComplete() {
        return typeIndex >= fullText.length();
    }

    public String getRemainingText() {
        if(isComplete()) {
            return "";
        }
        return fullText.substring(typeIndex);
    }


}
