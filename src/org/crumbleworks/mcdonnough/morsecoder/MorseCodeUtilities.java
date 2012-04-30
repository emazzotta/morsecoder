package org.crumbleworks.mcdonnough.morsecoder;

public class MorseCodeUtilities {

	public static String ERROR_STRING = "[undefined]";
	
	public int findOccurenceInStringOf(String needle, String haystack) {
		int len = needle.length();
		int occurenceCounter = 0;
		
		int start = haystack.indexOf(needle);
		while (start != -1) {
			occurenceCounter++;
			start = haystack.indexOf(needle, start+len);
		}
		
		return occurenceCounter;
	}
}