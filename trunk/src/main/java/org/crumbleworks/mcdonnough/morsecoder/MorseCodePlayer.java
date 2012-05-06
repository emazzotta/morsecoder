package org.crumbleworks.mcdonnough.morsecoder;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MorseCodePlayer {
    private long audioMorseCodeSpaceSleep = Constants.AUDIO_MORSECODE_SPACE_SLEEP;
    private long audioPlaySpeed = Constants.AUDIO_PLAY_NORMAL_SPEED;

    private WavePlayer playShortWave;
    private WavePlayer playLongWave;
    private String morseCode;

    public MorseCodePlayer(String morseCode) {
        this.morseCode = morseCode;
    }

    public boolean isMorseCode() {
        for(int i = 0; i < morseCode.length(); i++) {
            if(morseCode.charAt(i) != '.' && morseCode.charAt(i) != '-' && morseCode.charAt(i) != '/') {
                return false;
            }
        }
        return true;
    }

    public void play() throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException, InvalidMorseCodeAudioOutputException {
        this.isMorseCode();
        playShortWave = new WavePlayer(Constants.AUDIO_WAV_MORSECODE_SHORT_PATH, audioPlaySpeed);
        playLongWave = new WavePlayer(Constants.AUDIO_WAV_MORSECODE_LONG_PATH, audioPlaySpeed);

        for(int i = 0; i < morseCode.length(); i++) {
            if(morseCode.charAt(i) == '.') {
                playShortWave.play();
            }
            else if(morseCode.charAt(i) == '-') {
                playLongWave.play();
            }
            else if(morseCode.charAt(i) == '/') {
                Thread.sleep(audioMorseCodeSpaceSleep);
            }
            else {
                throw new InvalidMorseCodeAudioOutputException("String to Audio-Output Contains Invalid Character(s)");
            }
        }
    }

    public void setAudioMorseCodeSpaceSleep(long audioMorseCodeSpaceSleep) {
        this.audioMorseCodeSpaceSleep = audioMorseCodeSpaceSleep;
    }

    public void setAudioPlaySpeed(long audioPlaySpeed) {
        this.audioPlaySpeed = audioPlaySpeed;
    }
}