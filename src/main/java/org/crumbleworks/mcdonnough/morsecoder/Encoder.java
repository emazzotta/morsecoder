package org.crumbleworks.mcdonnough.morsecoder;

public class Encoder {
	
	private MorseCodeCharacterGetter morseCodeCharacterGetter;
    private Utilities morseCodeUtilities;
    private StringBuffer morseEncodedTextBuffer;
    
	public Encoder(String pathToMorsecodeXML) {
		morseCodeCharacterGetter = new MorseCodeCharacterGetter(pathToMorsecodeXML);
        morseCodeUtilities = new Utilities();
        morseEncodedTextBuffer = new StringBuffer();
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
}