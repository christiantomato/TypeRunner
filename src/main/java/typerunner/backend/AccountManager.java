package typerunner.backend;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Account Manager
 *
 * This class handles all the logic with reading and writing from the player
 * database. There is only ever one instance of this class, accessible globally. 
 *
 * @author Olorunfemi Martins Kayode
 * @author Noh Woldetinsae
 * @author Christian Tamayo
 */

public class AccountManager {

    /** the singular instance of this class */
    private static AccountManager instance;
    /** the list of all accounts */
    private ArrayList<Player> accounts;
    /** the database file of accounts */
    private File databaseFile;
    /** our Gson */
    private final Gson gson;

    /**
     * Account Manager Constructor
     *
     * The constructor for the account manager. It is private so no other
     * classes can build it, as we want only one instance throughout the
     * program.
     *
     * @param filePath the json file storing account information
     */

    private AccountManager(String filePath) {
        //set the file with the path
        this.databaseFile = new File(filePath);
        //create the Gson builder
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        //init the accounts list
        this.accounts = new ArrayList<>();
        //load any data that has been written already
        loadAccounts();
    }

    /**
     * Get Instance
     *
     * Returns the instance of the account manager. If it has not been
     * initialized yet, it calls the constructor and builds it. Static so we can
     * call it from anywhere to get the account manager instance.
     *
     * @return the instance of the account manager
     * @see AccountManager
     */

    public static AccountManager getInstance() {
        //create an instance if there isn't one
        if (instance == null) {
            instance = new AccountManager("accounts.json");
        }
        return instance;
    }

    /**
     * Set Player Under Admin
     *
     * Adds the player to the list of players for the admin.
     */

    public void setPlayerUnderAdmin(String adminUsername, String playerUsername) {
        Admin admin = (Admin) findPlayer(adminUsername);
        admin.addPlayer(playerUsername);
    }

    /**
     * Reset Statistics
     * 
     * Resets the statistics for a player, then writes the change to the file. 
     * 
     * @param player the player whose stats are being reset
     * @return true if successful, false otherwise
     */

    public boolean resetStats(Player player) {
        if(player != null) {
            player.getStatistics().resetStats();;
            saveAccounts();
            return true;
        }
        return false;
    }

    /**
     * Reset Password
     * 
     * Resets the password for the selected player.
     * 
     * @param player player whos password is being reset
     * @param newPassword the new password
     * @return true if successful, false otherwise
     */

    public boolean resetPassword(Player player, String newPassword) {
        if (player != null && newPassword != null) {
            player.setPassword(newPassword);
            saveAccounts();
            return true;
        }
        return false;
    }

    /**
     * Create Account Method
     *
     * Creates either a player or admin account.
     *
     * @param username the username
     * @param password the password
     * @param isAdmin admin account if true, player if false
     * @return true if account creation was successful
     */

    public boolean createAccount(String username, String password, boolean isAdmin, String adminstrator) {
        //make sure a player with that username does not already exist
        if (findPlayer(username) == null) {
            //create admin account
            if (isAdmin) {
                Admin newAdmin = new Admin(username, password);
                accounts.add(newAdmin);
                saveAccounts();
                return true;
            } //create a regular player account
            else {
                //create new player
                Player newPlayer = new Player(username, password);
                //add it to the accounts
                accounts.add(newPlayer);
                //get the admin of the player
                Admin adminOfPlayer = (Admin) findPlayer(adminstrator);
                //add the player under the administrator
                adminOfPlayer.addPlayer(newPlayer.getUsername());
                //write everything
                saveAccounts();
                return true;
            }
        }
        return false;
    }

    /**
     * Find Player
     * 
     * Finds a player by their username, and returns the player object. 
     * 
     * @param username the player we are finding
     * @return the player object
     */

    public Player findPlayer(String username) {
        if(username == null) {
            return null;
        }

        for (Player p : accounts) {
            if (p.getUsername().equals(username)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Sort by Highscore
     * 
     * Sorts all the accounts by their highscores so we can display them on the leaderboard. 
     * 
     * @return the list of sorted players
     */

    public ArrayList<Player> sortByHighscore() {
        //the list where we will sort the players
        ArrayList<Player> sortedList = new ArrayList<>();

        for (Player player : this.accounts) {
            //get the score
            int currentScore = player.getStatistics().getHighscore().getScoreValue();

            //boolean to track if we have inserted it into the list
            boolean inserted = false;

            //find correct position
            for(int i = 0; i < sortedList.size(); i++) {
                //get the player at i
                Player sortedPlayer = sortedList.get(i);
                //get the score of the player
                int sortedScore = sortedPlayer.getStatistics().getHighscore().getScoreValue();

                //descending order (highest first)
                if(currentScore > sortedScore) {
                    sortedList.add(i, player);
                    inserted = true;
                    break;
                }
            }

            //if not inserted, goes at the end
            if(!inserted) {
                sortedList.add(player);
            }
        }
        return sortedList;
    }

    /**
     * Load Accounts
     * 
     * Responsible for reading from the Json and updating the information.
     */

    public void loadAccounts() {
        if (!databaseFile.exists()) return;

        try (Reader reader = new FileReader(databaseFile)) {
            //parse the JSON into a generic list of elements
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            this.accounts = new ArrayList<>();

            for (JsonElement element : jsonArray) {
                JsonObject obj = element.getAsJsonObject();
                
                //check the "isAdmin" boolean
                boolean isThisAnAdmin = obj.has("isAdmin") && obj.get("isAdmin").getAsBoolean();

                if(isThisAnAdmin) {
                    //build an Admin
                    this.accounts.add(gson.fromJson(obj, Admin.class));
                } 
                else {
                    //build a player
                    this.accounts.add(gson.fromJson(obj, Player.class));
                }
            }
        } 
        catch (IOException e) {
            System.err.println("Error loading JSON: " + e);
        }
    }

    /**
     * Save Accounts to Database
     *
     * Writes the data from the accounts list into pretty string in the json.
     */

    public void saveAccounts() {
        try {
            Writer writer = new FileWriter(databaseFile);
            gson.toJson(accounts, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error saving JSON: " + e);
        }
    }

    /**
     * Get Accounts
     * 
     * A getter for the list of accounts. 
     * 
     * @return list of the accounts
     */

    public ArrayList<Player> getAccounts() {
        return accounts;
    }
}
