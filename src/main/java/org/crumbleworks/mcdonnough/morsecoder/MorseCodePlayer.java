package org.crumbleworks.mcdonnough.morsecoder;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MorseCodePlayer {

	private WavePlayer playShortWave;
	private WavePlayer playLongWave;
	private String morseCode;
	
	public MorseCodePlayer(String morseCode) {
		this.morseCode = morseCode;
		playShortWave = new WavePlayer(Constants.AUDIO_WAV_MORSECODE_SHORT_PATH);
		playLongWave = new WavePlayer(Constants.AUDIO_WAV_MORSECODE_LONG_PATH);
	}
	
	public boolean isMorseCode() throws InvalidMorseCodeAudioOutputException {
		for(int i=0;i<morseCode.length();i++) {
			if(morseCode.charAt(i) != '.' && morseCode.charAt(i) != '-' && morseCode.charAt(i) != '/') {
				throw new InvalidMorseCodeAudioOutputException("String to Audio-Output Contains Invalid Character(s)");
			}
		}
		return true;
	}
	
	public void play() throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException, InvalidMorseCodeAudioOutputException {
		this.isMorseCode();
		
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