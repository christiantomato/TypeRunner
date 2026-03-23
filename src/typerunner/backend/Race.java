package typerunner.backend;

public class Race {

    private int totalWords;
    private Level level;
    private int botSpeed;
    private int time;
    private int wordsTyped;
    private int wpm;

    public int getTotalWords() {
        return totalWords;
    }  

    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getBotSpeed() {
        return botSpeed;
    }

    public int setBotSpeed(int botSpeed) {
        this.botSpeed = botSpeed;
        return botSpeed;
    }

    

    public int getTime() {
        return time;
    }   

    public void setTime(int time) {
        this.time = time;
    }  
    public int getWordsTyped() {
        return wordsTyped;
    }
    public void wordsTypedIncrement() {
        this.wordsTyped++;
    }

    public int getWpm() {
        return wpm;
    }
    public void updateWpm() {
    }

    
    
}
