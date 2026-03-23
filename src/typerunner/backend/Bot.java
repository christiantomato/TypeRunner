package typerunner.backend;

public class Bot extends Player {

    private int wpmTarget;
    private int accuracyTarget;
    private int difficulty;


    public Bot(String id, String username) {
        super(id, username);
    }

    public String generateTypedText(String prompt){
        return "";
    }

    public int stimulateScore(){
        return 0;
    }

    
    
}
