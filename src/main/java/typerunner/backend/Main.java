package typerunner.backend;


public class Main {
    public static void main(String[] args) {
        // Create an instance of AccountManager
        AccountManager accountManager = AccountManager.getInstance();

        // Create some accounts
      //  accountManager.createAccount("admin1", "password123", true, "admin1-id");
        //accountManager.createAccount("player1", "password456", false, "player1-id");
        //accountManager.createAccount("player2", "password789", , true);

        accountManager.createAccount("admin1", "password123", true, "admin1");
        accountManager.createAccount("player1", "password456", false, "admin1");

        accountManager.getAccounts();

        //accountManager.getAccounts();
        //accountManager.getAccounts()


 

        // Save accounts to JSON
        //accountManager.saveAccountsToJson();
    }

    
    
}
