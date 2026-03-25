package typerunner.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class SceneNavigator {

    public static void switchScene(ActionEvent e, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(SceneNavigator.class.getResource(fxmlFile));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
    }

    public static void closeStage(ActionEvent e) {
        //get the current stage
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        //close it
        stage.close();
    }
}
