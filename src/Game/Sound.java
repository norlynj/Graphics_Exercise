package Game;


import java.io.IOException;
import javax.sound.sampled.*;

public class Sound {
    public static synchronized void play(final String audioName) 
    {          
        new Thread(new Runnable() { 
            @Override
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(
                      Sound.class.getResourceAsStream(audioName));
                    clip.open(audioIn);
                    clip.start(); 
                } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                    System.err.println(e.getMessage());
                }
              }
            }).start();
    } 
        
}
