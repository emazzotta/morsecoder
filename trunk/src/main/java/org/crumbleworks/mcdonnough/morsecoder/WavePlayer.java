package org.crumbleworks.mcdonnough.morsecoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WavePlayer {

	private String wavFilePath;
	
	public WavePlayer(String wavFilePath) {
		this.wavFilePath = wavFilePath;
	}

	public void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File soundFile = new File(wavFilePath);
		SourceDataLine audioLine = null;
		
		if(!soundFile.exists()) {
			throw new FileNotFoundException("Wave file not found: " + wavFilePath);
		}
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		
		AudioFormat audioFormat = audioInputStream.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		
		audioLine = (SourceDataLine) AudioSystem.getLine(info);
		audioLine.open(audioFormat);
		audioLine.start();
		
		int amountOfBytesRead = 0;
		byte[] byteBuffer = new byte[Constants.AUDIO_EXTERNAL_BUFFER_SIZE];
		
		while(amountOfBytesRead != -1) {
			audioInputStream.skip(Constants.AUDIO_PLAY_MODERATE_SPEED);
			amountOfBytesRead = audioInputStream.read(byteBuffer, 0, byteBuffer.length);
			if(amountOfBytesRead >= 0) {
				audioLine.write(byteBuffer, 0, amountOfBytesRead);
			}
		}
		
		audioLine.drain();
		audioLine.close();
	}
}