import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

class SimpleAudioPlayer
{
    static Clip clip;

    static AudioInputStream audioInputStream;

    static void SimpleAudioPlayer(String filePath) {
        try {
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        }catch(UnsupportedAudioFileException e){

        }catch(IOException e){

        }catch(LineUnavailableException e){

        }

    }

}
