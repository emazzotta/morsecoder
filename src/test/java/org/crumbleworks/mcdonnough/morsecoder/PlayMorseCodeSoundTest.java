package org.crumbleworks.mcdonnough.morsecoder;

import org.junit.Test;


public class PlayMorseCodeSoundTest {

	PlayMorseCodeSound playMorseCodeSound;
	
	@Test(expected=InvalidMorseCodeAudioOutputException.class)
	public void testIfPlayAudioOfInvalidMorseCodeFailsAsExpected() throws InvalidMorseCodeAudioOutputException {
		playMorseCodeSound = new PlayMorseCodeSound("String-Not-Containing-Any-Valid-Morse-Code");
		playMorseCodeSound.play();
	}
	
	@Test
	public void testIfPlayAudioOfValidMorseCodeWorksAsExpected() throws InvalidMorseCodeAudioOutputException {
		playMorseCodeSound = new PlayMorseCodeSound(".../---/...");
		playMorseCodeSound.play();
	}
}