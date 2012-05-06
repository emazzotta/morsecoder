package org.crumbleworks.mcdonnough.morsecoder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EncoderTest {

    Encoder morseEncoder = new Encoder();

    @Test
    public void testIfEncodeWorksAsExpected() {
        assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../" + Constants.ERROR_STRING + "//", morseEncoder.encode("Hello, world!"));
    }

    @Test
    public void testIfEncodeWorksAsExpectedWithOneSpecialCasesNotSeparated() {
        assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../" + Constants.ERROR_STRING + "//...---...//", morseEncoder.encode("Hello, world! [SOS]"));
    }

    @Test
    public void testIfEncodeWorksAsExpectedWithGivingAnInvalidWord() {
        assertEquals("[undefined]/.../---/...//", morseEncoder.encode("[SOS"));
    }

    @Test
    public void testIfEncodeWorksAsExpectedWithThreeSpecialCasesNotSeparated() throws InvalidMorseCodeAudioOutputException {
        assertEquals("...././.-../.-../---/--..--//.--/---/.-./.-../-../" + Constants.ERROR_STRING + "//...---...//...---...//...---...//",
                morseEncoder.encode("Hello, world! [SOS][SOS][SOS]"));
    }

    @Test
    public void testIfExpectedAmountOfOccurencesIsFound() {
        assertEquals(3, morseEncoder.findOccurencesOfSequenceInString("o", "oozoa"));
    }
}