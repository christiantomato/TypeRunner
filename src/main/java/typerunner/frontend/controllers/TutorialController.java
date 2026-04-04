package typerunner.frontend.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import typerunner.frontend.ScreenNavigator;

/**
 * controller class to handle the tutorial page, uses arrays to display the seperate information as if they are seperate pages
 * 
 * @author Sahej
 */

public class TutorialController {
    
    /*next page button */
    @FXML private Button rightButton;
    /*previous page button */
    @FXML private Button leftButton;
    /*page count text */
    @FXML private Text pageCount;
    /*tutorial description */
    @FXML private Text description;
    /*left and right image */
    @FXML private ImageView leftImage;
    @FXML private ImageView rightImage;

    
    /*array with every image for tutorials */
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

    /*an array with all the descriptions */
    private String[] descriptions = {
        "The first step in being able to play TypeRunner, is to create an account! To do so, first you must select on \"Admin Controls\" in the main menu, following this you must enter the games parental passkey; \"1234\".",
        "Once you've entered the passkey, you are taken to the admin control panel, from here we can click \"Create Account\" to make our first accounts. In the New Account page you'll need to enter a username and password, followed by an optional administrator overlooking the account, you may also, using the dropdown, select whether this account is for a player, or an administrator.",
        "Now that you've created you first account, you can click on Login within the main menu, and enter the username and password you created earlier, to login!",
        "From here you've entered the Player Screen, to begin your first race, simply click Start New Game, followed by start in the top right corner, following this, a paragraph will appear on your screen, the goal is to type this paragraph out using your keyboard, as quickly as possible! make sure you type carefully, every 5 perfectly typed words, grants your player more health, and sets your opponents back on the track!",
        "Once you've completed your first race, feel free to go back to the Player Screen and check out the Select Level page, where you can select the difficulty of the game. Every player begins at the high school level, needing to reach 40WPM to progress to the next level, and 60 to the level after that. if you'd like an even bigger challenge, feel free to click the hardcore button on the top left of the Game Screen to enable a no mistake gamemode."
    };

    /*variable that indicates the current page and max page */
    private int currPage = 0;
    private final int MAX_PAGE = 4;

    /**
     * automatically runs when on the page
     */
    @FXML
    public void initialize(){
        //disables the previous page button as its the first page
        leftButton.setDisable(true);
        
        //set images
        leftImage.setImage(images[0]);
        rightImage.setImage(images[1]);
        
        //set description and page count
        description.setText(descriptions[currPage]);
        pageCount.setText(currPage+1 + "/" + 5);
    }

    /**
     * user clicked the return to menu button
     * @param e
     */
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

    /**
     * user clicked the next page button
     * @param e
     */
    @FXML
    private void nextPage(ActionEvent e){
        //if the user is going to the next page then they should be able to go to the previous page now
        leftButton.setDisable(false);

        //increment the current page
        currPage++;

        //set page count text, images, and description
        pageCount.setText(currPage+1 + "/" + 5);
        leftImage.setImage(images[currPage * 2]);
        rightImage.setImage(images[(currPage * 2) + 1]);
        description.setText(descriptions[currPage]);

        //if we are at the max page then the player shouldnt be able to click the next page button anymore
        if(currPage == MAX_PAGE){
            rightButton.setDisable(true);
        }
    }

    /**
     * method to handle the user clicking the previous page button
     * @param e
     */
    @FXML
    private void previousPage(ActionEvent e){
        //if we go back a page then we should be able to go forward a page now
        rightButton.setDisable(false);

        //deincrement the current page variable
        currPage--;

        //set the page count, the images, and description
        pageCount.setText(currPage+1 + "/" + 5);
        leftImage.setImage(images[currPage * 2]);
        rightImage.setImage(images[(currPage * 2) + 1]);
        description.setText(descriptions[currPage]);

        //if its the first page then the user shouldnt be able to back any more pages
        if(currPage == 0){
            leftButton.setDisable(true);
        }

    }
}
