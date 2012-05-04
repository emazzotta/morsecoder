package org.crumbleworks.mcdonnough.morsecoder;

public class Constants {

	public static final int AUDIO_EXTERNAL_BUFFER_SIZE = 1048576;
	public static final long AUDIO_PLAY_NORMAL_SPEED = 0;
	public static final long AUDIO_PLAY_MODERATE_SPEED = 4000;
	public static final long AUDIO_PLAY_FAST_SPEED = 6000;
	public static final long AUDIO_PLAY_VERY_FAST_SPEED = 7000;
	public static final long AUDIO_MORSECODE_SPACE_SLEEP = 250;
	
	public static final String RESOURCE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\";
	public static final String TEST_RESOURCE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\";
	public static final String AUDIO_WAV_MORSECODE_SHORT_PATH = Constants.RESOURCE_PATH + "sfx\\short.wav";
	public static final String AUDIO_WAV_MORSECODE_LONG_PATH = Constants.RESOURCE_PATH + "sfx\\long.wav";
	
	public static final String ERROR_STRING = "[undefined]";
}