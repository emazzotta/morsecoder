package org.crumbleworks.mcdonnough.morsecoder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DecoderTest.class, EncoderTest.class, MorseCodePlayerTest.class })
public class AllTests {
}