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
	public void testEncode() {
		assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../[undefined]//...---...//...---...", morseCoder.encode("Hello, world! [SOS][SOS]"));
	}
	
	@Test
	public void testDecode() {
		assertEquals("HELLO, WORLD[undefined] [SOS] [SOS] ", morseCoder.decode("...././.-../.-../---/--..--//.--/---/.-./.-../-../[undefined]//...---...//...---..."));
	}
}