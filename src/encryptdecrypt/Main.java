package encryptdecrypt;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String line = "";
        String category = "enc";
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                category = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                line = args[i + 1];
            }
        }

        if (category.equals("enc")) {
            char[] message = line.toCharArray();
            char[] encryptedMessage = new char[message.length];
            for (int i = 0; i < message.length; i++) {
                int ch = message[i];
                int inCh = ch + key;
                encryptedMessage[i] = (char) inCh;
            }
            System.out.println(new String(encryptedMessage));
        }

        if (category.equals("dec")) {
            char[] message = line.toCharArray();
            char[] encryptedMessage = new char[message.length];
            for (int i = 0; i < message.length; i++) {
                int ch = message[i];
                int inCh = ch - key;
                encryptedMessage[i] = (char) inCh;
            }
            System.out.println(new String(encryptedMessage));
        }

    }
}
