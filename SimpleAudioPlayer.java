import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class SimpleAudioPlayer
{
    static Clip clip;

    static AudioInputStream audioInputStream;

    void SimpleAudioPlayer(String filePath) {
        URL url =getClass().getResource(filePath);
        try {
            audioInputStream =
                    AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        }catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }
    }


