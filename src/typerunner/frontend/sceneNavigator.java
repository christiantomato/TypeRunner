package typerunner.frontend;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class sceneNavigator {

    public static void switchScene(ActionEvent e, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(sceneNavigator.class.getResource(fxmlFile));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
    }
}
