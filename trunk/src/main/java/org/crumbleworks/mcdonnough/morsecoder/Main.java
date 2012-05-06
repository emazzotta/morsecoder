package org.crumbleworks.mcdonnough.morsecoder;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

    public static void main(String args[]) throws InvalidMorseCodeAudioOutputException, InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        Encoder encoder = new Encoder();
        Decoder decoder = new Decoder();
        MorseCodePlayer player;

        if(args.length == 0) {
            System.out.println(new Main().getInvalidArgumentMessage(""));
        }
        else if(args[0].equals("--help")) {
            System.out.println(new Main().getUsageHelp());
        }
        else if(args.length == 1) {
            System.out.println(new Main().getInvalidArgumentMessage(args[0]));
        }
        else {
            String text = args[args.length - 1];

            player = new MorseCodePlayer(text);
            if(!player.isMorseCode())
                player = new MorseCodePlayer(encoder.encode(text));

            for(int i = 0; i < args.length - 1; i++) {
                String currentArgument = args[i];

                if(currentArgument.equals("-e") || currentArgument.equals("--encode")) {
                    System.out.println("Encoding '" + text + "'");
                    System.out.println("Encoded text in morsecode: " + encoder.encode(text) + "\n");
                }
                else if(currentArgument.equals("-d") || currentArgument.equals("--decode")) {
                    System.out.println("Decoding '" + text + "'");
                    System.out.println("Decoded morsecode in text: " + decoder.decode(text) + "\n");
                }
                else if(currentArgument.equals("-p") || currentArgument.equals("--play")) {
                    System.out.println("Playing morsecode...");
                    player.play();
                }
                else if(currentArgument.startsWith("-sPauseSpeed=") || currentArgument.startsWith("--settingsPauseSpeed=")) {
                    player.setAudioMorseCodeSpaceSleep(new Main().determinePauseSpeedSettingOption(currentArgument));
                }
                else if(currentArgument.startsWith("-sPlaySpeed=") || currentArgument.startsWith("--settingsPlaySpeed=")) {
                    player.setAudioPlaySpeed(new Main().determinePlaySpeedSettingOption(currentArgument));
                }
                else {
                    System.out.println(new Main().getInvalidArgumentMessage(currentArgument));
                    break;
                }
            }
        }
    }

    private long determinePauseSpeedSettingOption(String argument) {
        String speed = argument.substring(argument.indexOf("=") + 1);

        try {
            Long.parseLong(speed);
        }
        catch(Exception e) {
        	System.out.println(new Main().getInvalidArgumentMessage(speed));
            System.exit(1);
        }

        return Long.parseLong(speed);
    }

    private long determinePlaySpeedSettingOption(String argument) {
        String speed = argument.substring(argument.indexOf("=") + 1).toLowerCase();

        if(speed.equals("normal")) {
            return Constants.AUDIO_PLAY_NORMAL_SPEED;
        }
        else if(speed.equals("moderate")) {
            return Constants.AUDIO_PLAY_MODERATE_SPEED;
        }
        else if(speed.equals("fast")) {
            return Constants.AUDIO_PLAY_FAST_SPEED;
        }
        else if(speed.equals("veryfast")) {
            return Constants.AUDIO_PLAY_VERY_FAST_SPEED;
        }
        else {
        	System.out.println(new Main().getInvalidArgumentMessage(speed));
            System.exit(1);
        }

        return Constants.AUDIO_PLAY_NORMAL_SPEED;
    }

    private String getUsageHelp() {
        String usageHelp = "\ncrumbleWorks MorseCoder by Patrick Baechli & Emanuele Mazzotta ver. 1.0 - A Morsecode Library.\n";
        usageHelp += "Usage: java -jar MorseCoder.jar [OPTION]... [TEXT]\n\n";

        usageHelp += "At least one argument mandatory.\n";
        usageHelp += "Text must be in quotes (\") when containing spaces.\n\n";

        usageHelp += "Convert:\n";
        usageHelp += "-e, --encode\tEncode the text to morsecode.\n";
        usageHelp += "-d, --decode\tDecode the morsecode to text.\n\n";

        usageHelp += "Play:\n";
        usageHelp += "-p, --play\tAudio output morsecode. Can be text or morsecode.\n\n";

        usageHelp += "Settings:\n";
        usageHelp += "Warning! These options must be set before the 'Play' options!\n\n";
        usageHelp += "Option:\t\t-sPauseSpeed=n, --settingsPauseSpeed=n\nExplanation:\tSet pause of a space in milliseconds (n being the number) when playing morsecode.\n\n";
        usageHelp += "Option:\t\t-sPlaySpeed=opt, --settingsPlaySpeed=opt\nExplanation:\tSet speed of playing morsecode. Available options: NORMAL, MODERATE, FAST, VERYFAST\n\n";

        return usageHelp;
    }

    private String getInvalidArgumentMessage(String invalidCommand) {
        String errorMessage = "MorseCoder: unknown option '" + invalidCommand + "'\n";
        errorMessage += "Usage: java -jar MorseCoder.jar [OPTION]... [TEXT]\n\n";

        errorMessage += "Try 'java -jar MorseCoder.jar --help' for more options.\n";

        return errorMessage;
    }
}