package typerunner.frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import typerunner.backend.AccountManager;
import typerunner.frontend.ScreenNavigator;

/**
 * Controller for the Account Creation Screen
 * 
 * Handles GUI events on this page. Details for a new account are inputted here
 * and sent to the backend to initialize a new account. 
 * 
 * @author Christian Tamayo
 */

public class AccountCreationController {

    /** the menu button for account type */
    @FXML private MenuButton accountType; //changes value for dropdown
    /** the feedback message upon attempting to create a new account */
    @FXML private Text creationMessage; //feedback for user on creation status
    /** the new username field */
    @FXML private TextField usernameField;
    /** the new password field */
    @FXML private TextField passwordField;
    /** the administrator field */
    @FXML private TextField administratorField;
    /** the account type for creation */
    private String accountTypeString;

    /**
     * Select Account Type
     * 
     * Visually updates the dropdown menu so user can see what 
     * type of account they are creating. 
     * 
     * @param e the dropdown clicked event
     */

    public void selectAccountType(ActionEvent e) {
        System.out.println("selecting account type");

        //get which menu item was clicked
        MenuItem clicked = (MenuItem) e.getSource();

        //display the selected type and save the value
        accountType.setText(clicked.getText());
        accountTypeString = clicked.getText();
    }

    /**
     * Account Creation
     * 
     * Creates an account based on the inputs for account type and textfields. 
     * Values are passed in to backend method, and feedback message is displayed on click. 
     * 
     * @param e the button event
     */

    public void createAccount(ActionEvent e) {
        System.out.println("creating account");

        //get the strings from the fields
        String username = usernameField.getText();
        String password = passwordField.getText();
        String administrator = administratorField.getText();

        //print everything out for debugging purposes
        System.out.println(username);
        System.out.println(password);
        System.out.println(administrator);

        //make sure the username or password are not blank, and that the account type is selected
        if(username.isBlank() || password.isBlank() || accountTypeString == null) {
            System.out.println("username or password is blank, or unselected type");
            return;
        }

        //create based on the account type
        if(accountTypeString.equals("Player")) {
            //check to make sure the administrator field is not empty
            if(administrator.isBlank()) {
                System.out.println("specify the administrator that is managing this account.");
                return;
            }

            System.out.println("creating player account");
            //TODO: pass in parameters to method

            //get the instance of the account manager
            AccountManager accountManager = AccountManager.getInstance();

            //create the player account - we need to pass in the administrator as well!
            //accountManager.createAccount(username, password, false, administrator)
        }
        else if(accountTypeString.equals("Administrator")) {
            System.out.println("creating admin account");
            //TODO: pass in parameters to method
        }
        else {
            //the user has not selected...
            System.out.println("select an account type.");
        }

        //TODO: set the correct display message based on return value from account creation
        creationMessage.setText("Successfully Created");
    }

    /**
     * Return to Admin Controls
     * 
     * takes the user back to the admin controls screen.
     * 
     * @param e the button event
     */

    public void returnToAdminControls(ActionEvent e) {
        try {
            System.out.println("returning to admin controls");
            ScreenNavigator.switchScene(e, "fxml/admin-controls.fxml");
        } 

        catch (Exception exception) {
            System.out.println("exception while returning to admin controls:\n" + exception);
        }
    }
}
