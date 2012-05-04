package org.crumbleworks.mcdonnough.morsecoder;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilitiesTest {

	Utilities morseCodeStringUtilities = new Utilities();
	
	@Test
	public void testIfExpectedAmountOfOccurencesIsFound() {
		assertEquals(3, morseCodeStringUtilities.findOccurencesOfSequenceInString("o", "oozoa"));
	}
}