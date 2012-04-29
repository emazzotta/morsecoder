package org.crumbleworks.mcdonnough.morsecoder;

public class MorseCoder {
    private MorseCode morseCode;
    
    public MorseCoder(String pathToMorsecodeXML) {
        morseCode = new MorseCode(pathToMorsecodeXML);
    }
    
    public String encode(String text) {
        String[] splittedText = text.split(" ");
        StringBuffer morsecode = new StringBuffer();
        
        for(int wordCounter = 0; wordCounter < splittedText.length; wordCounter++) {
            String word = splittedText[wordCounter];
            
            if(word.startsWith("[") && word.endsWith("]")) {
                morsecode.append(morseCode.getCodeForLetter(word) + "/");
            }
            else {
                for(int charCounter = 0; charCounter < word.length(); charCounter++) {
                    String tempChar = word.subSequence(charCounter, charCounter+1).toString();
                    morsecode.append(morseCode.getCodeForLetter(tempChar) + "/");
                }
            }
            
            morsecode.append("/");
        }
        
        return new String(morsecode);
    }
    
    public String decode(String morsecode) {
        String[] splittedMorseCode = morsecode.split("//");
        StringBuffer text = new StringBuffer();
        
        for(int wordCounter = 0; wordCounter < splittedMorseCode.length; wordCounter++) {
            String word = splittedMorseCode[wordCounter];
            String[] letters = word.split("/");
            
            for(int letterCounter = 0; letterCounter < letters.length; letterCounter++) {
                String letter = letters[letterCounter];
                text.append(morseCode.getLetterForCode(letter));
            }
            
            text.append(" ");
        }
        
        return new String(text);
    }
}