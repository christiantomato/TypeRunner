package typerunner.frontend.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        "Now that you've created you first account, you can click on Login within the main menu, and enter the username and password you created earlier, to login!",
        "From here you've entered the Player Screen, to begin your first race, simply click Start New Game, followed by start in the top right corner, following this, a paragraph will appear on your screen, the goal is to type this paragraph out using your keyboard, as quickly as possible! make sure you type carefully, every 5 perfectly typed words, grants your player more health, and sets your opponents back on the track!",
        "Once you've completed your first race, feel free to go back to the Player Screen and check out the Select Level page, where you can select the difficulty of the game. Every player begins at the high school level, needing to reach 40WPM to progress to the next level, and 60 to the level after that. if you'd like an even bigger challenge, feel free to click the hardcore button on the top left of the Game Screen to enable a no mistake gamemode."
    };

    private int currPage = 0;
    private final int MAX_PAGE = 4;

    @FXML
    public void initialize(){
        leftButton.setDisable(true);
        leftImage.setImage(images[0]);
        rightImage.setImage(images[1]);
        description.setText(descriptions[currPage]);
        pageCount.setText(currPage+1 + "/" + 5);
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

        pageCount.setText(currPage+1 + "/" + 5);
        leftImage.setImage(images[currPage * 2]);
        rightImage.setImage(images[(currPage * 2) + 1]);
        description.setText(descriptions[currPage]);

        if(currPage == MAX_PAGE){
            rightButton.setDisable(true);
        }
    }

    @FXML
    private void previousPage(ActionEvent e){
        rightButton.setDisable(false);

        currPage--;

        pageCount.setText(currPage+1 + "/" + 5);
        leftImage.setImage(images[currPage * 2]);
        rightImage.setImage(images[(currPage * 2) + 1]);
        description.setText(descriptions[currPage]);

        if(currPage == 0){
            leftButton.setDisable(true);
        }

    }
}
