package org.crumbleworks.mcdonnough.morsecoder;

public class MorseCoder {
	
    private MorseCodeCharacterGetter morseCodeCharacterGetter;
    
    public MorseCoder(String pathToMorsecodeXML) {
        morseCodeCharacterGetter = new MorseCodeCharacterGetter(pathToMorsecodeXML);
    }
    
    public String encode(String unencodedText) {
        String[] splittedUnencodedText = unencodedText.split(" ");
        StringBuffer morseEncodedTextBuffer = new StringBuffer();
        
        for(int encodedWordsCounter = 0; encodedWordsCounter < splittedUnencodedText.length; encodedWordsCounter++) {
            String wordToEncode = splittedUnencodedText[encodedWordsCounter];
            
            if(wordToEncode.startsWith("[") && wordToEncode.endsWith("]")) {
                morseEncodedTextBuffer.append(morseCodeCharacterGetter.getCodeForLetter(wordToEncode) + "/");
            }
            else {
                for(int charCounter = 0; charCounter < wordToEncode.length(); charCounter++) {
                    String tempChar = wordToEncode.subSequence(charCounter, charCounter+1).toString();
                    morseEncodedTextBuffer.append(morseCodeCharacterGetter.getCodeForLetter(tempChar) + "/");
                }
            }
            
            morseEncodedTextBuffer.append("/");
        }
        
        return new String(morseEncodedTextBuffer);
    }
    
    public String decode(String morseEncodedText) {
        String[] splittedMorseCode = morseEncodedText.split("//");
        StringBuffer text = new StringBuffer();
        
        for(int wordCounter = 0; wordCounter < splittedMorseCode.length; wordCounter++) {
            String word = splittedMorseCode[wordCounter];
            String[] letters = word.split("/");
            
            for(int letterCounter = 0; letterCounter < letters.length; letterCounter++) {
                String letter = letters[letterCounter];
                text.append(morseCodeCharacterGetter.getLetterForCode(letter));
            }
            
            text.append(" ");
        }
        
        return new String(text);
    }
}