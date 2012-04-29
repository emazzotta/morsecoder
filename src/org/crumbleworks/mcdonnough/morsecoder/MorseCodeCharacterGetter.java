package org.crumbleworks.mcdonnough.morsecoder;

import java.util.List;

public class MorseCodeCharacterGetter {
    private String pathToMorsecodeXML;
    private List<MorseCodeCharacter> morseCharacters;
    
    public MorseCodeCharacterGetter(String pathToMorsecodeXML) {
        this.pathToMorsecodeXML = pathToMorsecodeXML;
        loadMorseCharacters();
    }
    
    private void loadMorseCharacters() {
        morseCharacters = new MorseCodeParser().parseDocument(pathToMorsecodeXML);
    }
    
    public String getCodeForLetter(String letter) {
        for(MorseCodeCharacter mc : morseCharacters) {
            if(mc.getLetter().equalsIgnoreCase(letter)) {
                return mc.getCode();
            }
        }
        
        return "[undefined]";
    }
    
    public String getLetterForCode(String code) {
        for(MorseCodeCharacter mc : morseCharacters) {
            if(mc.getCode().equalsIgnoreCase(code)) {
                return mc.getLetter();
            }
        }
        
        return "[undefined]";
    }
}
