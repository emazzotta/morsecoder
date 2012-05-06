package org.crumbleworks.mcdonnough.morsecoder;

public class InvalidMorseCodeAudioOutputException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidMorseCodeAudioOutputException(String message) {
        super(message);
    }
}