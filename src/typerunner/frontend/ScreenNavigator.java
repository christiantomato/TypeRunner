package typerunner.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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

    public static void closeStage(ActionEvent e) {
        //get the current stage
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //close it
        stage.close();
    }
}
