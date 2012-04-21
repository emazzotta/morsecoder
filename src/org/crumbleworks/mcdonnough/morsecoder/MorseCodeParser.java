package org.crumbleworks.mcdonnough.morsecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MorseCodeParser extends DefaultHandler {
    private List<MorseCharacter> tempMorseCharacters;
    private MorseCharacter tempMorseCharacter;
    
    private boolean letter, code;
   
    public MorseCodeParser() {
        tempMorseCharacters = new ArrayList<MorseCharacter>();
        
        letter = false;
        code = false;
    }
    
    public List<MorseCharacter> parseDocument(String pathToDocument) {
        File file = new File(pathToDocument);
        InputSource is = null;
        
        try {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            is = new InputSource(reader);
            is.setEncoding("UTF-8");
        }
        catch(FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        SAXParserFactory spf = SAXParserFactory.newInstance();
        
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse(is, this);
        }
        catch(ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        
        return tempMorseCharacters;
    }
    
    @Override
    public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("morsecharacter")) {
            tempMorseCharacter = new MorseCharacter();
        }
        else if (qName.equalsIgnoreCase("letter")) {
            letter = true;
        }
        else if (qName.equalsIgnoreCase("code")) {
            code = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if(letter) {
            tempMorseCharacter.setLetter(new String(ch, start, length));
            letter = false;
        }
        else if(code) {
            tempMorseCharacter.setCode(new String(ch, start, length));
            code = false;
            
            tempMorseCharacters.add(tempMorseCharacter);
        }
    }
}
