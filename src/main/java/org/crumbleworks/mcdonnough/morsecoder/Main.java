package org.crumbleworks.mcdonnough.morsecoder;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

	public static void main(String args[]) throws InvalidMorseCodeAudioOutputException, InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		Encoder encoder;
		Decoder decoder;
		MorseCodePlayer player;

		if(args.length == 0) {
			System.out.println(new Main().getInvalidArgumentMessage(""));
		} else if(args[0].equals("--help")) {
			System.out.println(new Main().getUsageHelp());
		} else if(args.length == 1) {
			System.out.println(new Main().getInvalidArgumentMessage(args[0]));
		} else {
			String text = args[args.length-1];
			for(int i=0;i<args.length-1;i++) {
				if(args[i].equals("-e") || args[i].equals("--encode")) {
					encoder = new Encoder();
					System.out.println("Encoding '" + text + "'...");
					System.out.println("Encoded text in morsecode: " + encoder.encode(text));
				} else if(args[i].equals("-d") || args[i].equals("--decode")) {
					decoder = new Decoder();
					System.out.println("Decoding '" + text + "'...");
					System.out.println("Decoded morsecode in text: " + decoder.decode(text));
				} else if(args[i].equals("-p") || args[i].equals("--play")) {
					encoder = new Encoder();
					System.out.println("Playing morsecode...");
					player = new MorseCodePlayer(text);
					if(!player.isMorseCode()) {
						player = new MorseCodePlayer(encoder.encode(text));
					}
					player.play();
				} else {
					System.out.println(new Main().getInvalidArgumentMessage(args[i]));
					break;
				}
			}
		}
	}
	
	private String getUsageHelp() {
		String usageHelp = "\ncrumbleWorks MorseCoder by Patrick Baechli & Emanuele Mazzotta ver. 1.0 - A Morsecode Library.\n";
		usageHelp += "Usage: java -jar MorseCoder.jar [OPTION] [TEXT]\n\n";
		
		usageHelp += "At least one argument mandatory.\n\n";
		
		usageHelp += "Convert:\n";
		usageHelp += "-e, --encode\tEncode the text to morsecode.\n";
		usageHelp += "-d, --decode\tDecode the morsecode to text.\n";
		
		usageHelp += "Play:\n";
		usageHelp += "-p, --play\tAudio output morsecode. Can be text or morsecode.\n";
		
		return usageHelp;
	}
	
	private String getInvalidArgumentMessage(String invalidCommand) {
		String errorMessage = "MorseCoder: unknown option " + invalidCommand + "\n";
		errorMessage += "Usage: java -jar MorseCoder.jar [OPTION]... [TEXT]\n\n";
		
		errorMessage += "Try 'java -jar MorseCoder.jar --help' for more options.";
		
		return errorMessage;
	}
}