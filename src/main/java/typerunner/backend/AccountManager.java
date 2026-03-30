package typerunner.backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Account Manager
 * 
 * This class handles all the logic with reading and writing from the player database.
 * There is only ever one instance of this class.
 * 
 * @author Olorunfemi Martins Kayode
 * @author Christian Tamayo
 */

public class AccountManager {
    /** the singular instance of this class */
    private static AccountManager instance;
    /** the list of player account */
    private List<Player> accounts;
    /** the database file */
    private File databaseFile;
    /** not sure what a Gson is */
    private final Gson gson;

    /**
     * Account Manager Constructor
     * 
     * The constructor for the account manager. It is private so no other classes can build it, 
     * as we want only one instance throughout the program. 
     * 
     * @param filePath the json file storing account information
     */

    private AccountManager(String filePath) { 
        this.databaseFile = new File(filePath);
        // Pretty printing makes the JSON file human-readable
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.accounts = new ArrayList<>();
        loadAccounts();
    }

    /**
     * Get Instance
     * 
     * Returns the instance of the account manager. If it has not been initialized yet, 
     * it calls the constructor and builds it. 
     * Static so we can call it from anywhere to get the account manager instance. 
     * 
     * @return the instance of the account manager
     * @see AccountManager
     */

    public static AccountManager getInstance() {
        //create an instance if there isn't one
        if(instance == null) {
            instance = new AccountManager("accounts.json");
        }
        return instance;
    }

    // --- UML PUBLIC METHODS ---

    public boolean resetStats(Player player) {
        if (player != null) {
            player.resetStats();
            saveAccounts();
            return true;
        }
        return false;
    }

    public boolean resetPassword(Player player, String newPassword) {
        if (player != null && newPassword != null) {
            player.setPassword(newPassword);
            saveAccounts();
            return true;
        }
        return false;
    }

    public boolean createAccount(String username, String password, boolean isAdmin, String stringid) {
        // Check irrespective of case
        if (findPlayer(username) == null) {
            Player newPlayer = new Player(stringid, username, password, isAdmin);
            accounts.add(newPlayer);
            saveAccounts();
            return true;
        }
        return false;
    }

    public Player findPlayer(String username) { 
        if (username == null) return null;
        for (Player p : accounts) {
            // Logic for entering it irrespective of case
            if (p.getUsername().equalsIgnoreCase(username)) {
                return p;
            }
        }
        return null;
    }

    public void loadAccounts() { 
        if (!databaseFile.exists()) return;

        try (Reader reader = new FileReader(databaseFile)) {
            Type listType = new TypeToken<ArrayList<Player>>(){}.getType();
            List<Player> loadedData = gson.fromJson(reader, listType);
            if (loadedData != null) {
                this.accounts = loadedData;
            }
        } catch (IOException e) {
            System.err.println("Error loading JSON: " + e.getMessage());
        }
    }

    public void saveAccounts() { 
        try (Writer writer = new FileWriter(databaseFile)) {
            gson.toJson(accounts, writer);
        } catch (IOException e) {
            System.err.println("Error saving JSON: " + e.getMessage());
        }
    }
}