package typerunner.backend;

public class Race {

    private int totalWords;
    private Level level;
    private int botSpeed;
    private int time;
    private int wordsTyped;
    private int wpm;
    private int playerSpeed;
    private int Stamina = 100;

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

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    public void triggerSpeedBoost(int level) {
       

        switch (level) {
            case 1:
                SpeedBoost speedBoost = new SpeedBoost(level, 10, 5);

                if (speedBoost.isTriggered()) {
                    setPlayerSpeed(getPlayerSpeed() + speedBoost.getBoostDistance(level));
                }
                break;
            case 2:
                SpeedBoost speedBoost2 = new SpeedBoost(level, 20, 10); 
                if (speedBoost2.isTriggered()) {
                    setPlayerSpeed(getPlayerSpeed() + speedBoost2.getBoostDistance(level));
                }
                break;
            case 3:
                SpeedBoost speedBoost3 = new SpeedBoost(level, 30, 15);
                if (speedBoost3.isTriggered()) {
                    setPlayerSpeed(getPlayerSpeed() + speedBoost3.getBoostDistance(level));
                }
                break;
            default:
                // Handle default case if needed
                break;

        }   
    }

    public void setTime(int time) {
        this.time = time;
    }  


    public void wordsTypedIncrement(Word word) {
        if (word.isComplete()) {
            wordsTyped++;
        }
        else {
            reduceStamina(20); // Reduce stamina by 20 for each incorrect word
            wordsTyped = 0; // Reset consecutive words count on incorrect word 
        }

        int stams = checkStamina();
        if (stams <= 50 && wordsTyped > 0) {
            StaminaRefill staminaRefill = new StaminaRefill(20); // Example stamina bonus
            if (staminaRefill.isTriggered()) {
                Stamina += staminaRefill.getStaminaBonus(level.getDifficulty());
                if (Stamina > 100) {
                    Stamina = 100; // Cap stamina at 100
                }
            }
        }



        int levelnum = level.getDifficulty();
        if (levelnum == 1 && wordsTyped == 5) {
            triggerSpeedBoost(levelnum);
            wordsTyped = 0; // Reset consecutive words count after triggering boost
        } else if (levelnum == 2 && wordsTyped == 10) {
            triggerSpeedBoost(levelnum);
            wordsTyped = 0; // Reset consecutive words count after triggering boost
        } else if (levelnum == 3 && wordsTyped == 15) {
            triggerSpeedBoost(levelnum);
            wordsTyped = 0; // Reset consecutive words count after triggering boost
        }
  
    }

    public int getWpm() {
        return wpm;
    }

    public void updateWpm() {
    }

    public int getStamina() {
        return Stamina;
    }

    public int checkStamina() {
        return Stamina;
    }

    public int reduceStamina(int amount) {
        Stamina -= amount;
        if (Stamina < 0) {
            Stamina = 0; // Ensure stamina doesn't go negative
        }
        return Stamina;
    }   


    
    
}
