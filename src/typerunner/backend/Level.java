package typerunner.backend;

public enum Level {
    HIGHSCHOOL(1),
    COLLEGE(2),
    OLYMPICS(3);

    private final int difficulty;

    Level(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
