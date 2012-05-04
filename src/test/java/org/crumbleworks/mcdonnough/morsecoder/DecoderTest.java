package org.crumbleworks.mcdonnough.morsecoder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecoderTest {

	Decoder morseDecoder = new Decoder(Constants.RESOURCE_PATH + "morsecode_general.xml");
	
	@Test
	public void testIfDecodeWorksAsExpected() {
		assertEquals("HELLO, WORLD", morseDecoder.decode("...././.-../.-../---/--..--//.--/---/.-./.-../-../"));
	}
}