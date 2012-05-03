package org.crumbleworks.mcdonnough.morsecoder;

import java.io.FileNotFoundException;

public class PlayMorseCodeSound {

	private PlayWave playShortWave;
	private PlayWave playLongWave;
	private String morseCode;
	private static String SHORT_PATH = MorseCodeUtilities.RESOURCE_PATH + "sfx\\short.wav";
	private static String LONG_PATH = MorseCodeUtilities.RESOURCE_PATH + "sfx\\long.wav";
	private static long MORSECODE_SPACE_SLEEP = 250;
	
	public PlayMorseCodeSound(String morseCode) {
		this.morseCode = morseCode;
		playShortWave = new PlayWave(SHORT_PATH);
		playLongWave = new PlayWave(LONG_PATH);
	}
	
	public void play() throws InvalidMorseCodeAudioOutputException {
		for(int i=0;i<morseCode.length();i++) {
			if(morseCode.charAt(i) != '.' && morseCode.charAt(i) != '-' && morseCode.charAt(i) != '/') {
				throw new InvalidMorseCodeAudioOutputException("String to Audio-Output Contains Invalid Character(s)");
			}
		}
		
		for(int i=0;i<morseCode.length();i++) {
			try {
				if(morseCode.charAt(i) == '.') {
					playShortWave.play();
				} else if(morseCode.charAt(i) == '-') {
					playLongWave.play();
				} else {
					Thread.sleep(MORSECODE_SPACE_SLEEP);
				}
			} catch (FileNotFoundException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}