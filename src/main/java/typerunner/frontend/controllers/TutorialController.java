package typerunner.frontend.controllers;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import typerunner.frontend.ScreenNavigator;

public class TutorialController {
    
    @FXML private Button rightButton;
    @FXML private Button leftButton;
    @FXML private Text pageCount;
    @FXML private Text description;
    @FXML private ImageView leftImage;
    @FXML private ImageView rightImage;

    private Image[] images = {
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-one.png")),
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-two.png")),
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-three.png")),
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-four.png")),
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-five.png")),
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-six.png")),
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-seven.png")),
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-eight.png")),
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-nine.png")),
        new Image(getClass().getResourceAsStream("/images/tutorial-picture-ten.png")),
    };

    private String[] descriptions = {
        "The first step in being able to play TypeRunner, is to create an account! To do so, first you must select on \"Admin Controls\" in the main menu, following this you must enter the games parental passkey; \"1234\".",
        "Once you've entered the passkey, you are taken to the admin control panel, from here we can click \"Create Account\" to make our first accounts. In the New Account page you'll need to enter a username and password, followed by an optional administrator overlooking the account, you may also, using the dropdown, select whether this account is for a player, or an administrator.",
        ""
    };

    private int currPage = 0;
    private final int MAX_PAGE = 4;

    @FXML
    public void initialize(){
        leftButton.setDisable(true);
        leftImage.setImage(images[0]);
        rightImage.setImage(images[1]);
    }

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

    @FXML
    private void nextPage(ActionEvent e){
        leftButton.setDisable(false);

        currPage++;

        leftImage.setImage(images[currPage * 2]);
        rightImage.setImage(images[(currPage * 2) + 1]);

        if(currPage == MAX_PAGE){
            rightButton.setDisable(true);
        }
    }

    @FXML
    private void previousPage(ActionEvent e){
        rightButton.setDisable(false);

        currPage--;

        leftImage.setImage(images[currPage * 2]);
        rightImage.setImage(images[(currPage * 2) + 1]);

        if(currPage == 0){
            leftButton.setDisable(true);
        }

    }
}
