package org.crumbleworks.mcdonnough.morsecoder;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Test;

public class MorseCodePlayerTest {

    MorseCodePlayer playMorseCodeSound;

    @Test(expected = InvalidMorseCodeAudioOutputException.class)
    public void testIfPlayAudioOfInvalidMorseCodeFailsAsExpected() throws InvalidMorseCodeAudioOutputException, InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        playMorseCodeSound = new MorseCodePlayer("String-Not-Containing-Any-Valid-Morse-Code");
        playMorseCodeSound.play();
    }

    @Test
    public void testIfPlayAudioOfValidMorseCodeWorksAsExpected() throws InvalidMorseCodeAudioOutputException, InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        playMorseCodeSound = new MorseCodePlayer("...-");
        playMorseCodeSound.play();
    }
}