package org.crumbleworks.mcdonnough.morsecoder;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCoderTest {
	MorseCoder c;

	@Before
	public void setUp() throws Exception {
		c = new MorseCoder("./data/morsecode_general.xml");
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}
	
	@Test
	public void testEncode() {
		assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../[undefined]//...---...//...---...", c.encode("Hello, world! [SOS][SOS]"));
	}
	
	@Test
	public void testDecode() {
		assertEquals("HELLO, WORLD[undefined] [SOS] [SOS] ", c.decode("...././.-../.-../---/--..--//.--/---/.-./.-../-../[undefined]//...---...//...---..."));
	}
}
