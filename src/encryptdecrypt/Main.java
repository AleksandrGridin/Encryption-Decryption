package encryptdecrypt;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String line = "";
        String category = "enc";
        int key = 0;
        String in = "";
        String out = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                category = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                line = args[i + 1];
            } else if (args[i].equals("-in")) {
                in = in + args[i + 1];
            } else if (args[i].equals("-out")) {
                out = out + args[i + 1];
            }
        }

        try {

            if (category.equals("enc")) {
                if (!in.isEmpty()) {
                    if (!out.isEmpty()) {
                        write(new File(out), enc(read(new File(in)), key));
                    } else {
                        System.out.println(enc(read(new File(in)), key));
                    }
                } else {
                    if (!out.isEmpty()) {
                        write(new File(out), enc(line, key));
                    } else {
                        System.out.println(enc(line, key));
                    }
                }
            }

            if (category.equals("dec")) {
                if (!in.isEmpty()) {
                    if (!out.isEmpty()) {
                        write(new File(out), dec(read(new File(in)), key));
                    } else {
                        System.out.println(dec(read(new File(in)), key));
                    }
                } else {
                    if (!out.isEmpty()) {
                        write(new File(out), dec(line, key));
                    } else {
                        System.out.println(dec(line, key));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }



    }

    private static String enc(String line, int key) {
        char[] message = line.toCharArray();
        char[] encryptedMessage = new char[message.length];
        for (int i = 0; i < message.length; i++) {
            int ch = message[i];
            int inCh = ch + key;
            encryptedMessage[i] = (char) inCh;
        }

        return new String(encryptedMessage);
    }

    private static String dec(String line, int key) {
        char[] message = line.toCharArray();
        char[] encryptedMessage = new char[message.length];
        for (int i = 0; i < message.length; i++) {
            int ch = message[i];
            int inCh = ch - key;
            encryptedMessage[i] = (char) inCh;
        }
        return new String(encryptedMessage);
    }

    private static String read(File file) {
        String line = "";
        try (Scanner read = new Scanner(file)){
            while (read.hasNext()) {
                line = read.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return line;
    }

    private static void write(File file, String line) {
        try (FileWriter write = new FileWriter(file)){
            write.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
