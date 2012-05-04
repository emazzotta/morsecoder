package org.crumbleworks.mcdonnough.morsecoder;

public class Utilities {

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