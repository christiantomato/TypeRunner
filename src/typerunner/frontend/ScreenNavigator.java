package typerunner.frontend;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Class for Navigating and Managing Screens
 * 
 * Includes helper methods for switching scenes and closing stages.
 * 
 * @author Christian Tamayo
 */

public class ScreenNavigator {

    /**
     * Switches Scenes
     * 
     * Cleanly switches scenes given an fxml file. 
     * 
     * @param e the corresponding event
     * @param fxmlFile the fxml for the screen we are switching to
     * @throws IOException if there is an input/output problem
     */

    public static void switchScene(ActionEvent e, String fxmlFile) throws IOException {
        //load from the fxml file
        Parent root = FXMLLoader.load(ScreenNavigator.class.getResource(fxmlFile));
        //get the current stage
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //set the new root node
        stage.getScene().setRoot(root);
    }

    /**
     * Confirmation Popup
     * 
     * Alerts the user with a popup when commiting a destructive action. 
     * Execution is paused until user confirms. 
     * 
     * @param owner the stage on which this method was called
     * @param title the title of the popup
     * @param message the message to give the user
     * @return true if confirmed, false otherwise
     */

    public static boolean confirmationPopup(Stage owner, String title, String message) {
        //create an alert and set title and messgage
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(message);

        //pass in the stage it is on
        alert.initOwner(owner);
        //make it so that the user cannot continue until popup is dealt with
        alert.initModality(Modality.WINDOW_MODAL);

        //get the result
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    /**
     * Information Popup
     * 
     * Creates a popup displaying a string of information. 
     * 
     * @param owner the stage on which this method was called
     * @param title the title of the popup
     * @param header the header of the popup
     * @param information the information to display
     */

    public static void informationPopup(Stage owner, String title, String header, String information) {
        //create an alert and set title and messgage
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        //pass in parameters
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(information);

        //pass in the stage it is on
        alert.initOwner(owner);
        //make it so that the user cannot continue until popup is closed
        alert.initModality(Modality.WINDOW_MODAL);

        //show it
        alert.showAndWait();
    }

    /**
     * Close The Stage
     * 
     * Closes the currect stage.
     * 
     * @param e the button event
     */

    public static void closeStage(ActionEvent e) {
        //get the current stage
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //close it
        stage.close();
    }
}
