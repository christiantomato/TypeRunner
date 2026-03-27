package typerunner.frontend.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import typerunner.frontend.ScreenNavigator;

/**
 * Controller for the Passkey Page
 * 
 * Handles the GUI events on this page. Works with backend to
 * allow access to the administrator controls screen.
 * 
 * @author Christian Tamayo
 */

public class AdminPasskeyController {

    /** the passkey passwordfield*/
    @FXML private PasswordField passkeyField;

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

            /*
            boolean successful = backend.passkey(passkey);
            if true, navigate to the admin controls...
            */
        
            System.out.println("going to admin controls");
            ScreenNavigator.switchScene(e, "fxml/admin-controls.fxml");
        } 

        catch (Exception exception) {
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
            ScreenNavigator.switchScene(e, "fxml/menu.fxml");
        } 

        catch (Exception exception) {
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
