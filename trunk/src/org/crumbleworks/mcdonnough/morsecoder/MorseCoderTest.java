package org.crumbleworks.mcdonnough.morsecoder;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MorseCoderTest {
	MorseCoder morseCoder;

	@Before
	public void initializeMorseCoder() throws Exception {
		morseCoder = new MorseCoder("./data/morsecode_general.xml");
	}

	@Test
	public void testIfEncodeWorksAsExpected() {
		assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../" + MorseCodeUtilities.ERROR_STRING + "//", morseCoder.encode("Hello, world!"));
	}
	
	@Test
	public void testIfEncodeWorksAsExpectedWithThreeSpecialCasesNotSeparated() {
		assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../" + MorseCodeUtilities.ERROR_STRING + "//...---...//...---...//...---...//", morseCoder.encode("Hello, world! [SOS][SOS][SOS]"));
	}
	
	@Test
	public void testIfDecodeWorksAsExpected() {
		assertEquals("HELLO, WORLD", morseCoder.decode("...././.-../.-../---/--..--/   /.--/---/.-./.-../-../"));
	}
}