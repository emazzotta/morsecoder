package org.crumbleworks.mcdonnough.morsecoder;

public class Encoder {
    private MorseCodeCharacterGetter morseCodeCharacterGetter;
    private StringBuffer morseEncodedTextBuffer;

    public Encoder() {
        morseCodeCharacterGetter = new MorseCodeCharacterGetter(Constants.MORSECODE_CONTENT_XML_PATH);
    }

    public String encode(String unencodedText) {
        morseEncodedTextBuffer = new StringBuffer();
        String[] splittedUnencodedText = unencodedText.split(" ");

        for(int encodedWordsCounter = 0; encodedWordsCounter < splittedUnencodedText.length; encodedWordsCounter++) {
            String wordToEncode = splittedUnencodedText[encodedWordsCounter];

            if(wordToEncode.startsWith("[") && wordToEncode.endsWith("]")) {
                handleIncompletelySeparatedWords(wordToEncode);
            }
            else {
                handleCorrectlySeparatedWord(wordToEncode);
            }
        }

        return new String(morseEncodedTextBuffer);
    }

    public int findOccurencesOfSequenceInString(String needle, String haystack) {
        int occurenceCounter = 0;

        int currentOccurencePosition = haystack.indexOf(needle);
        while(currentOccurencePosition != -1) {
            occurenceCounter++;
            currentOccurencePosition = haystack.indexOf(needle, currentOccurencePosition + needle.length());
        }

        return occurenceCounter;
    }

    private void handleCorrectlySeparatedWord(String wordToEncode) {
        for(int charCounter = 0; charCounter < wordToEncode.length(); charCounter++) {
            String tempChar = wordToEncode.subSequence(charCounter, charCounter + 1).toString();
            morseEncodedTextBuffer.append(morseCodeCharacterGetter.getCodeForLetter(tempChar) + "/");
        }
        morseEncodedTextBuffer.append("/");
    }

    private void handleIncompletelySeparatedWords(String wordToEncode) {
        if(findOccurencesOfSequenceInString("]", wordToEncode) == findOccurencesOfSequenceInString("[", wordToEncode)) {
            String[] splittedUnencodedText = wordToEncode.split("]");
            for(int amountOfSpecialWordsEncoded = 0; amountOfSpecialWordsEncoded < findOccurencesOfSequenceInString("]", wordToEncode); amountOfSpecialWordsEncoded++) {
                morseEncodedTextBuffer.append(morseCodeCharacterGetter.getCodeForLetter(splittedUnencodedText[amountOfSpecialWordsEncoded] + "]") + "//");
            }
        }
        else {
            handleCorrectlySeparatedWord(wordToEncode);
        }
    }
}