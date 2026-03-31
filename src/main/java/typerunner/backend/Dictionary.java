package typerunner.backend;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;



public class Dictionary {

    private ArrayList<Word> wordList;
    private Scanner scanner;

    public Dictionary(){
        this.wordList = new ArrayList<>();
        File file = new File("src/main/java/typerunner/backend/data/words.txt");
       
        try {
             this.scanner = new Scanner(file);
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
        }
   
    }



    public ArrayList<Word> getWordList() {
        return wordList;
    }
    
}
