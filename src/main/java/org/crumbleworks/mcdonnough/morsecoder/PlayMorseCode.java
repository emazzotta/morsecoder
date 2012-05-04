package org.crumbleworks.mcdonnough.morsecoder;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayMorseCode {

	private PlayWave playShortWave;
	private PlayWave playLongWave;
	private String morseCode;
	
	public PlayMorseCode(String morseCode) {
		this.morseCode = morseCode;
		playShortWave = new PlayWave(Constants.AUDIO_WAV_MORSECODE_SHORT_PATH);
		playLongWave = new PlayWave(Constants.AUDIO_WAV_MORSECODE_LONG_PATH);
	}
	
	public void play() throws InvalidMorseCodeAudioOutputException, InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		for(int i=0;i<morseCode.length();i++) {
			if(morseCode.charAt(i) != '.' && morseCode.charAt(i) != '-' && morseCode.charAt(i) != '/') {
				throw new InvalidMorseCodeAudioOutputException("String to Audio-Output Contains Invalid Character(s)");
			}
		}
		
		for(int i=0;i<morseCode.length();i++) {
			if(morseCode.charAt(i) == '.') {
				playShortWave.play();
			} else if(morseCode.charAt(i) == '-') {
				playLongWave.play();
			} else {
				Thread.sleep(Constants.AUDIO_MORSECODE_SPACE_SLEEP);
			}
		}
	}
}