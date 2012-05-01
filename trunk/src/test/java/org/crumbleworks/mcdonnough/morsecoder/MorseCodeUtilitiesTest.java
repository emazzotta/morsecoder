package org.crumbleworks.mcdonnough.morsecoder;

import static org.junit.Assert.*;

import org.junit.Test;

public class MorseCodeUtilitiesTest {

	MorseCodeUtilities morseCodeStringUtilities = new MorseCodeUtilities();
	
	@Test
	public void testIfExpectedAmountOfOccurencesIsFound() {
		assertEquals(3, morseCodeStringUtilities.findOccurencesOfSequenceInString("o", "oozoa"));
	}
}