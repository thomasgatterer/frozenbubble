package net.library.jiga;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class JavaSoundManageTG {
    private GameApplet gameApplet;
    private Map<String, AudioInputStream> audioStreams;

    public JavaSoundManageTG(GameApplet gameApplet) {
        this.gameApplet = gameApplet;
        this.audioStreams = new HashMap<>();
    }

    private AudioInputStream loadAudioStream(String filename) throws IOException, UnsupportedAudioFileException {
        AudioInputStream audioStream = audioStreams.get(filename);

        if (audioStream == null) {
            URL audioUrl = gameApplet.getClass().getResource(filename);

            if (audioUrl != null) {
                audioStream = AudioSystem.getAudioInputStream(audioUrl);
                audioStreams.put(filename, audioStream);
            } else {
                System.err.println("Audio File [" + filename + "] not found");
            }
        }

        return audioStream;
    }

    public void loadAudio(String[] files) {
        for (String file : files) {
            try {
                loadAudioStream(file);
            } catch (IOException | UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
        }
    }

    public void playSound(String filename) {
        AudioInputStream audioStream = audioStreams.get(filename);

        if (audioStream != null) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
