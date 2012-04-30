package org.crumbleworks.mcdonnough.morsecoder;

public class MorseCodeUtilities {

	public static String ERROR_STRING = "[undefined]";
	
	public int findOccurencesInStringOfSequence(String needle, String haystack) {
		int occurenceCounter = 0;
		
		int currentOccurencePosition = haystack.indexOf(needle);
		while(currentOccurencePosition != -1) {
			occurenceCounter++;
			currentOccurencePosition = haystack.indexOf(needle, currentOccurencePosition + needle.length());
		}
		
		return occurenceCounter;
	}
}