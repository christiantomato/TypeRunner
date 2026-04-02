package typerunner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

//to do

public class Main extends Application {

    /**
     * Start
     * 
     * A method from the Application class. We override it here and use it to
     * setup our application and run the game. 
     * 
     * @param primaryStage the main stage that we start on
     * @throws Exception if something goes wrong
     */

    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //create our FXML loader and initalize it with the main menu fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));

        //set the root node as the main menu fxml
        Parent root = loader.load();

        //set the title of the stage 
        primaryStage.setTitle("TypeRunner");
        
        //create a scene with the root node to set on our stage
        primaryStage.setScene(new Scene(root));

        //load css file
        primaryStage.getScene().getStylesheets().add(getClass().getResource("/styles/global.css").toExternalForm());
        
        //set fullscreen and dont let them leave
        // primaryStage.setFullScreen(true);
        // primaryStage.setFullScreenExitHint("");
        // primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        //make stage non-resizeable
        primaryStage.setResizable(false);
        
        //make sure it is visible
        primaryStage.show();

        //play menu theme
        playMusic("/audio/menu-music-loop.m4a");
        
    }

    public void playMusic(String path){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }

        Media song = new Media(getClass().getResource(path).toExternalForm());
        mediaPlayer = new MediaPlayer(song);
        mediaPlayer.setCycleCount(-1);
        mediaPlayer.setVolume(0.2);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        //inherited from application and calls the start method
        launch(args);
    }
}