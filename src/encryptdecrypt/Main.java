package encryptdecrypt;


public class Main {
    public static void main(String[] args) {
        final int firstLetter = 97;
        final int lastLetter = 122;
        String line = "we found a treasure!";
        char[] message = line.toCharArray();
        char[] encryptedMessage = new char[message.length];

        for (int i = 0; i < message.length; i++) {
            if (!Character.isLetter(message[i])) {
                encryptedMessage[i] = message[i];
                continue;
            }
            int ch = message[i];
            int inCh = lastLetter - ch + firstLetter;
            encryptedMessage[i] = (char) inCh;
        }
        System.out.println(new String(encryptedMessage));


    }
}
