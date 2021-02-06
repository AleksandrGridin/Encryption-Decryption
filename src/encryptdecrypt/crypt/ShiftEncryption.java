package encryptdecrypt.crypt;

public class ShiftEncryption implements Crypt {

    @Override
    public String solution(String text, int key) {
        char[] message = text.toCharArray();
        char[] encryptedMessage = new char[message.length];
        for (int i = 0; i < message.length; i++) {
            if (!Character.isLetter(message[i])) {
                encryptedMessage[i] = message[i];
                continue;
            }
            int ch = message[i];

            int inCh;

            if (ch >= 65 && ch <= 90) {
                if (ch + key > 90) {
                    inCh = (ch + key - 1) - 90 + 65;
                } else {
                    inCh = ch + key;
                }
            } else {
                if (ch + key > 122) {
                    inCh = (ch + key - 1) - 122 + 97;
                } else {
                    inCh = ch + key;
                }
            }
            encryptedMessage[i] = (char) inCh;
        }
        return new String(encryptedMessage);
    }
}
