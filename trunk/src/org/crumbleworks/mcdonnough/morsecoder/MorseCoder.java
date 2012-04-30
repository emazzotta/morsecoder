package org.crumbleworks.mcdonnough.morsecoder;

public class MorseCoder {
	
    private MorseCodeCharacterGetter morseCodeCharacterGetter;
    private MorseCodeUtilities morseCodeUtilities;
    private StringBuffer morseEncodedTextBuffer;
    private StringBuffer morseDecodedTextBuffer;
    
    public MorseCoder(String pathToMorsecodeXML) {
        morseCodeCharacterGetter = new MorseCodeCharacterGetter(pathToMorsecodeXML);
        morseCodeUtilities = new MorseCodeUtilities();
        morseEncodedTextBuffer = new StringBuffer();
        morseDecodedTextBuffer = new StringBuffer();
    }
    
    public String encode(String unencodedText) {
        String[] splittedUnencodedText = unencodedText.split(" ");
        
        for(int encodedWordsCounter = 0; encodedWordsCounter < splittedUnencodedText.length; encodedWordsCounter++) {
            String wordToEncode = splittedUnencodedText[encodedWordsCounter];
            
            if(wordToEncode.startsWith("[") && wordToEncode.endsWith("]")) {
            	handleExceptionalWords(wordToEncode);
            } else {
                handleUsualWords(wordToEncode);
            }
        }
        
        return new String(morseEncodedTextBuffer);
    }

	private void handleUsualWords(String wordToEncode) {
		for(int charCounter = 0; charCounter < wordToEncode.length(); charCounter++) {
		    String tempChar = wordToEncode.subSequence(charCounter, charCounter+1).toString();
		    morseEncodedTextBuffer.append(morseCodeCharacterGetter.getCodeForLetter(tempChar) + "/");
		}
		
		morseEncodedTextBuffer.append("/");
	}

	private void handleExceptionalWords(String wordToEncode) {
		if(morseCodeUtilities.findOccurencesOfSequenceInString("]", wordToEncode) == morseCodeUtilities.findOccurencesOfSequenceInString("[", wordToEncode)) {
			String[] splittedUnencodedText = wordToEncode.split("]");
			
			for(int amountOfSpecialWordsEncoded = 0; amountOfSpecialWordsEncoded < morseCodeUtilities.findOccurencesOfSequenceInString("]", wordToEncode); amountOfSpecialWordsEncoded++) {
				morseEncodedTextBuffer.append(morseCodeCharacterGetter.getCodeForLetter(splittedUnencodedText[amountOfSpecialWordsEncoded] + "]") + "//");
			}
		} else {
			handleUsualWords(wordToEncode);
		}
	}
    
    public String decode(String morseEncodedText) {
        String[] splittedMorseCode = morseEncodedText.split("//");
        
        for(int wordCounter = 0; wordCounter < splittedMorseCode.length; wordCounter++) {
            String word = splittedMorseCode[wordCounter];
            String[] letters = word.split("/");
            
            for(int letterCounter = 0; letterCounter < letters.length; letterCounter++) {
                String letter = letters[letterCounter];
                morseDecodedTextBuffer.append(morseCodeCharacterGetter.getLetterForCode(letter));
            }
            
            if(wordCounter != (splittedMorseCode.length-1)) morseDecodedTextBuffer.append(" ");
        }
        
        return new String(morseDecodedTextBuffer);
    }
}