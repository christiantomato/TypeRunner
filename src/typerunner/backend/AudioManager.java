package typerunner.backend;

public class AudioManager {

    private double volume;
    private String currentTrack;
    private boolean isPlaying;

    public void playMusic() {
        isPlaying = true;
    }
    public void pauseMusic() {
        isPlaying = false;
    }
    public void stopMusic() {
        isPlaying = false;
        currentTrack = null;

    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    public boolean isPlaying() {
        return isPlaying;
    }
    
}

