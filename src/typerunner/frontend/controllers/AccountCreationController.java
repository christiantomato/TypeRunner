package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import typerunner.frontend.ScreenNavigator;

public class AccountCreationController {

    @FXML private MenuButton accountType; //changes value for dropdown
    @FXML private Text creationMessage; //feedback for user on creation status

    public void selectAccountType(ActionEvent e) throws IOException {
        System.out.println("selecting account type");

        //get which menu item was clicked
        MenuItem clicked = (MenuItem) e.getSource();
        //set the corresponding text
        accountType.setText(clicked.getText());
    }

    /**
     * Account Creation
     * 
     * @param e
     * @throws IOException
     */

    public void createAccount(ActionEvent e) throws IOException {
        System.out.println("creating account");

        /*
        get the strings from the textfields
        pass it into the corresponding function
        show confirmation based on return value (true or false)
        */

        //set the message based on whether successful or not!
        creationMessage.setText("Successfully Created");

    }
    
    public void returnToAdminControls(ActionEvent e) throws IOException {
        System.out.println("returning to admin controls");
        ScreenNavigator.switchScene(e, "fxml/admin-controls.fxml");
    }
}
