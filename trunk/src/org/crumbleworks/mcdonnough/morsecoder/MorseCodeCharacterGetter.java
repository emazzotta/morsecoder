package org.crumbleworks.mcdonnough.morsecoder;

import java.util.List;

public class MorseCodeCharacterGetter {
	
    private List<MorseCodeCharacter> morseCodeCharacters;
    
    public MorseCodeCharacterGetter(String pathToMorsecodeXML) {
        morseCodeCharacters = new MorseCodeParser().parseDocument(pathToMorsecodeXML);
    }
    
    public String getCodeForLetter(String letter) {
        for(MorseCodeCharacter mc : morseCodeCharacters) {
            if(mc.getLetter().equalsIgnoreCase(letter)) {
                return mc.getCode();
            }
        }
        
        return MorseCodeUtilities.ERROR_STRING;
    }
    
    public String getLetterForCode(String code) {
        for(MorseCodeCharacter mc : morseCodeCharacters) {
            if(mc.getCode().equalsIgnoreCase(code)) {
                return mc.getLetter();
            }
        }
        
        return MorseCodeUtilities.ERROR_STRING;
    }
}