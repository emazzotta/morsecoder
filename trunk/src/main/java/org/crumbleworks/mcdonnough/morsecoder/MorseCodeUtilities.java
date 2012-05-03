package org.crumbleworks.mcdonnough.morsecoder;

public class MorseCodeUtilities {

	public static String ERROR_STRING = "[undefined]";
	public static String RESOURCE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\";
	public static String TEST_RESOURCE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\";
	
	public int findOccurencesOfSequenceInString(String needle, String haystack) {
		int occurenceCounter = 0;
		
		int currentOccurencePosition = haystack.indexOf(needle);
		while(currentOccurencePosition != -1) {
			occurenceCounter++;
			currentOccurencePosition = haystack.indexOf(needle, currentOccurencePosition + needle.length());
		}
		
		return occurenceCounter;
	}
}