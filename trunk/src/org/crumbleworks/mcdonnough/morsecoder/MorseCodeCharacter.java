package org.crumbleworks.mcdonnough.morsecoder;

public class MorseCodeCharacter {
    private String letter;
    private String code;
    
    public MorseCodeCharacter(String letter, String code) {
        this.letter = letter;
        this.code = code;
    }

    public MorseCodeCharacter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the letter
     */
    public String getLetter() {
        return letter;
    }

    /**
     * @param letter the letter to set
     */
    public void setLetter(String letter) {
        this.letter = letter;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
}
