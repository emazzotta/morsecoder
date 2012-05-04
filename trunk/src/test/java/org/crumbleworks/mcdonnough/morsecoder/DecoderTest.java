package org.crumbleworks.mcdonnough.morsecoder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecoderTest {

	Decoder morseDecoder = new Decoder();
	
	@Test
	public void testIfDecodeWorksAsExpected() {
		assertEquals("HELLO, WORLD", morseDecoder.decode("...././.-../.-../---/--..--//.--/---/.-./.-../-../"));
	}
}