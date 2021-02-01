package encryptdecrypt;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String category = sc.nextLine();
        String line = sc.nextLine();
        int key = sc.nextInt();

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
