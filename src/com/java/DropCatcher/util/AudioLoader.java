package com.java.DropCatcher.util;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AudioLoader {

    // USED TO CREATE SINGLE INSTANCE OF MUSIC CLIP RATHER THAN LOADING NEW ONE
    private static Clip musicClip;

    // USED TO CREATE A SINGLE INSTANCE OF AUDIO CLIPS
    private static Clip dropSound;
    private static Clip failSound;

    // Init method for the audio loader
    public static void init(){
        dropSound = loadSoundClip("DropletFINAL.wav");
        failSound = loadSoundClip("LifeLoss2.wav");
    }

    private static Clip loadSoundClip(String sound){
        try (InputStream is = AudioLoader.class.getResourceAsStream("/assets/"+sound)){
            if(is == null){
                System.out.println("AUDIO FILE NOT FOUND: " + sound);
                return null;
            }

            // Convert to AudioInputStream
            try(AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(is))){
                Clip c = AudioSystem.getClip();
                c.open(audioInputStream);
                audioInputStream.close();
                return c;
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void playDropSound(){
        if(dropSound != null){
            dropSound.setFramePosition(0);
            dropSound.start();
        }
    }

    public static void playLifeLoss(){
        if(failSound != null){
            failSound.setFramePosition(0);
            failSound.start();
        }
    }

    public static void playMusic(String music){
        try {
            // Checks if the music is already playing and does not load things again
            if(musicClip != null && musicClip.isRunning()){
                return;
            }

            // Convert InputStream to AudioInputStream
            InputStream audioSource = AudioLoader.class.getResourceAsStream("/assets/" + music);
            if(audioSource == null){
                System.out.println("AUDIO FILE NOT FOUND" + music);
            }

            try(AudioInputStream audioInput = AudioSystem.getAudioInputStream(new BufferedInputStream(audioSource))){
                musicClip = AudioSystem.getClip();
                musicClip.open(audioInput);
                audioInput.close();
                musicClip.loop(Clip.LOOP_CONTINUOUSLY);
                musicClip.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
            exception.printStackTrace();
        }
    }



}
