package typerunner.frontend.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import typerunner.frontend.ScreenNavigator;

public class AccountCreationController {

    //the account type dropdown
    @FXML
    private MenuButton accountType;

    public void selectAccountType(ActionEvent e) throws IOException {
        MenuItem clicked = (MenuItem) e.getSource();
        accountType.setText(clicked.getText());
    }

    /**
     * Account Creation
     * 
     * @param e
     * @throws IOException
     */

    public void createAccount(ActionEvent e) throws IOException {
        /*
        get the strings from the textfields
        pass it into the corresponding function
        show confirmation based on return value (true or false)
        */

        System.out.println("creating account");
    }
    
    public void returnToAdminControls(ActionEvent e) throws IOException {
        System.out.println("returning to admin controls");
        ScreenNavigator.switchScene(e, "fxml/admin-controls.fxml");
    }
}
