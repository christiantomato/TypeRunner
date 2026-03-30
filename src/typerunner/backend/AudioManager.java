package typerunner.backend;
/**
 * The AudioManager class handles audio playback functionality.
 * This includes playing, pausing, stopping music, and controlling volume.
 * 
 * @author Tanya Sahota
 * @version 1.0
 */

public class AudioManager {
/** The current volume level of the audio. */
    private double volume;
/** The name of the current track being played. */
    private String currentTrack;
/** Whether an audio is currently playing or not. */
    private boolean isPlaying;
/** Starts to play music and sets isPlaying state to true. */
    public void playMusic() {
        isPlaying = true;
    }
/** Pauses the music and sets isPlaying state to false. */
    public void pauseMusic() {
        isPlaying = false;
    }
/** Stops the music and sets isPlaying state to false and currentTrack to null. */
    public void stopMusic() {
        isPlaying = false;
        currentTrack = null;

    }
/** Sets the volume level.
 * 
 * @param volume the new volume level to set.
 */
    public void setVolume(double volume) {
        this.volume = volume;
    }
/** Checks if music is currently playing.
 * 
 * @return true if music is playing, false otherwise.
 * @return
 */
    public boolean isPlaying() {
        return isPlaying;
    }
    
}

