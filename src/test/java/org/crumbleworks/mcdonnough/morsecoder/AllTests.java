package org.crumbleworks.mcdonnough.morsecoder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DecoderTest.class, EncoderTest.class, PlayMorseCodeTest.class, UtilitiesTest.class })
public class AllTests {
}