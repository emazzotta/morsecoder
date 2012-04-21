package org.crumbleworks.mcdonnough.morsecoder;

import java.util.ArrayList;
import java.util.List;

public class MorseCode {
    private String pathToMorsecodeXML;
    private List<MorseCharacter> morseCharacters;
    
    public MorseCode(String pathToMorsecodeXML) {
        this.pathToMorsecodeXML = pathToMorsecodeXML;
        morseCharacters = new ArrayList<MorseCharacter>();
        
        loadMorseCharacters();
    }
    
    private void loadMorseCharacters() {
        morseCharacters = new MorseCodeParser().parseDocument(pathToMorsecodeXML);
    }
    
    public String getCodeForLetter(String letter) {
        for(MorseCharacter mc : morseCharacters) {
            if(mc.getLetter().equalsIgnoreCase(letter)) {
                return mc.getCode();
            }
        }
        
        return "[undefined]";
    }
    
    public String getLetterForCode(String code) {
        for(MorseCharacter mc : morseCharacters) {
            if(mc.getCode().equalsIgnoreCase(code)) {
                return mc.getLetter();
            }
        }
        
        return "[undefined]";
    }
}
