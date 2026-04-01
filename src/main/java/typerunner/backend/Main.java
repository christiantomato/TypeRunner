package typerunner.backend;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Create an instance of AccountManager
        //AccountManager accountManager = AccountManager.getInstance();

        // Create some accounts
      //  accountManager.createAccount("admin1", "password123", true, "admin1-id");
        //accountManager.createAccount("player1", "password456", false, "player1-id");
        //accountManager.createAccount("player2", "password789", , true);

        //accountManager.createAccount("admin1", "password123", true, "admin1");
        //accountManager.createAccount("player1", "password456", false, "admin1");

       // accountManager.createAccount("player2", "password456", false, "admin1");

        //accountManager.getAccounts();

        //accountManager.getAccounts();
        //accountManager.getAccounts()



 

        // Save accounts to JSON
        //accountManager.saveAccountsToJson();


        //Testing Dicionary.java to see if the words appear in the wordList
        Dictionary dictionary = new Dictionary();
        ArrayList<Word> words = dictionary.getWordList();
        int limit = 10; // Limit the number of words printed to 10
        
        for (int i = 0; i < limit; i++) {
            Word currentWord = words.get(i);
            System.out.println((i + 1) + ": " + currentWord.getFullText());
        }
        
        if (words.isEmpty()) {
            System.out.println("The word list is empty. Check your file path or words.txt content.");
        }


        
    }
}

    
    

