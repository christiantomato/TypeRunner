package typerunner.backend;

public class Bot extends Player {

    private int wpmTarget;
    private int accuracyTarget;
    private int difficulty;


    public Bot(String botName) {
        super(botName, "none");
    }

    public String generateTypedText(String prompt){
        return "";
    }

    public int stimulateScore(){
        return 0;
    }
}
