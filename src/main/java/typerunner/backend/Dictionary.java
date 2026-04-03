package typerunner.backend;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Dictionary Class
 * 
 * Creates a dictionary of word objects from our words.txt file
 * so that we can create strings of text for typing. 
 * 
 * @author Christian Tamayo
 * @author Noh Woldetinsae
 * @author Sahej Sethi
 */

public class Dictionary {

    /** the list of word objects we will create */
    private ArrayList<Word> wordList;
    /** the scanner to parse the file */
    private Scanner scanner;

    /**
     * Dictionary Constructor
     * 
     * Parses the file and creates each respective word object. 
     */

    public Dictionary(){
        //initalize the empty list
        this.wordList = new ArrayList<>();
        
        try {
            //create the file obj
            File file = new File(getClass().getResource("/data/words.txt").toURI());
            //init scanner
            this.scanner = new Scanner(file);
            
            //loop through
            while(scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                if(line.length() > 1){
                    Word word = new Word(line);
                    wordList.add(word);
                }
            }
            
            scanner.close();
        }
         catch (Exception e) {
            System.out.println("Error reading the file: " + e);
        }
    }

    /**
     * Get Word List
     * 
     * Getter for the word list. 
     * 
     * @return the list of words
     */

    public ArrayList<Word> getWordList() {
        return wordList;
    }
}
