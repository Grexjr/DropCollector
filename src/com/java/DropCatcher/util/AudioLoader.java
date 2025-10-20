package com.java.DropCatcher.util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AudioLoader {

    public static void playSound(String sound){
        try {// Use the class to load resource from the jar
            URL soundURL = AudioLoader.class.getResource("/assets/" + sound);

            // Null check to handle if it isn't loaded properly
            if (soundURL == null) {
                System.out.println("AUDIO FILE NOT FOUND" + sound);
            }

            // Convert the URL into an audio input stream to be used
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);

            // Set the clip for playing, open it, and start it
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void playMusic(String music){
        try {
            // Convert InputStream to AudioInputStream
            InputStream audioSource = AudioLoader.class.getResourceAsStream("/assets/" + music);
            if(audioSource == null){
                System.out.println("AUDIO FILE NOT FOUND" + music);
            }
            // Convert InputStream to AudioInputStream
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioSource);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
            exception.printStackTrace();
        }
    }



}
