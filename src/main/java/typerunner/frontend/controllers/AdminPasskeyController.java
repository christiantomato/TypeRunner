package typerunner.frontend.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import typerunner.frontend.ScreenNavigator;

/**
 * Controller for the Passkey Screen
 * 
 * Handles the GUI events on this page. Works with backend to
 * allow access to the administrator controls screen.
 * The global admin passkey for typerunner is 1234.
 * 
 * @author Christian Tamayo
 */

public class AdminPasskeyController {

    /** the passkey passwordfield*/
    @FXML private PasswordField passkeyField;
    /** the hardcoded passkey to get through*/
    private static final String PASSKEY = "1234";

    /**
     * Passkey Verification
     * 
     * Checks the inputted passkey to determine whether to allow access
     * to the controls page. 
     * 
     * @param e the button event
     */

    @FXML
    private void validatePasskey(ActionEvent e) {
        try {
            System.out.println("pressed validate");

            //get the inputted passkey
            String passkey = passkeyField.getText();

            //print for debugging purposes
            System.out.println(passkey);

            //make sure its not blank
            if(passkey.isBlank()) {
                System.out.println("passkey field is blank"); 
                return;
            }

            //check the passkey
            if(passkey.equals(PASSKEY)) {
                System.out.println("going to admin controls");
                ScreenNavigator.switchScene(e, "/fxml/admin-controls.fxml");
            }
            else {
                System.out.println("incorrect passkey");
                //TODO: give feed back that it was incorrect...
            }
        } 

        catch(Exception exception) {
            System.out.println("exception while validating passkey:\n" + exception);
        }
    }
    
    /**
     * Return to the Main Menu
     * 
     * takes the user back to the main menu. 
     * 
     * @param e the button event
     */

    @FXML
    private void returnToMenu(ActionEvent e) {
        try {
            System.out.println("going back to menu page");
            ScreenNavigator.switchScene(e, "/fxml/menu.fxml");
        } 

        catch(Exception exception) {
            System.out.println("exception going back to menu:\n" + exception);
        }
    }

    /**
     * Toggles Passkey Visibility
     * 
     * shows the passkey being inputted using the checkbox. 
     * 
     * @TODO: IMPLEMENT IT 
     * 
     * @param e
     */

    @FXML
    private void togglePasskey(ActionEvent e) {
        System.out.println("toggling visibility");
    }
}
