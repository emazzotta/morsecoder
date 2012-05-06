package org.crumbleworks.mcdonnough.morsecoder;

import java.util.List;

public class MorseCodeCharacterGetter {

    private List<MorseCodeCharacter> morseCodeCharacters;

    public MorseCodeCharacterGetter(String pathToMorsecodeXML) {
        morseCodeCharacters = new Parser().parseDocument(pathToMorsecodeXML);
    }

    public String getCodeForLetter(String letter) {
        for(MorseCodeCharacter mc : morseCodeCharacters) {
            if(mc.getLetter().equalsIgnoreCase(letter)) {
                return mc.getCode();
            }
        }

        return Constants.ERROR_STRING;
    }

    public String getLetterForCode(String code) {
        for(MorseCodeCharacter mc : morseCodeCharacters) {
            if(mc.getCode().equalsIgnoreCase(code)) {
                return mc.getLetter();
            }
        }

        return Constants.ERROR_STRING;
    }
}