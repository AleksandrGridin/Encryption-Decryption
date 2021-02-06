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
        String alg = "shift";
        Factory factory = new ShiftCryptFactory();

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
            } else if (args[i].equals("-alg")) {
                alg = args[i + 1];
            }
        }

        if (alg.equals("shift")) {
            factory = new ShiftCryptFactory();
        } else if (alg.equals("unicode")) {
            factory = new UnicodeCryptFactory();
        }


        try {
            String str;
            if (in.isEmpty()) {
                str = factory.crypt(category, line, key);
            } else {
                str = read(new File(in));
            }
            if (out.isEmpty()) {
                System.out.println(str);
            } else {
                write(new File(out), factory.crypt(category, str, key));
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        
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
