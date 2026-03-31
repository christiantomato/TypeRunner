package typerunner.backend;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;



public class Dictionary {

    private ArrayList<Word> wordList;
    private Scanner scanner;

    public Dictionary(){

        this.wordList = new ArrayList<>();
        System.out.println(1);

        File file = new File("group01\\src\\main\\java\\typerunner\\backend\\data\\words.txt");
        System.out.println(2);

        try {
            this.scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                System.out.println(line);
                if(line.length() > 1){
                    Word word = new Word(line);
                    wordList.add(word);
                }
            }
            scanner.close();
           
        }
         catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
   
    }



    public ArrayList<Word> getWordList() {
        return wordList;
    }
    
}
