package org.crumbleworks.mcdonnough.morsecoder;

import static org.junit.Assert.*;

import org.junit.Test;

public class MorseCodeUtilitiesTest {

	MorseCodeUtilities morseCodeStringUtilities = new MorseCodeUtilities();
	
	@Test
	public void testIfExpectedAmountOfOccurencesIsFound() {
		String haystack = "Hi I'm Finsoeodeosfodos!";
		
		assertEquals(5, morseCodeStringUtilities.findOccurencesInStringOfSequence("o", haystack));
	}
}