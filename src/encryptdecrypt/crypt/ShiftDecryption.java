package encryptdecrypt.crypt;

public class ShiftDecryption implements Crypt {

    @Override
    public String solution(String text, int key) {
        char[] message = text.toCharArray();
        char[] decryptedMessage = new char[message.length];
        for (int i = 0; i < message.length; i++) {
            if (!Character.isLetter(message[i])) {
                decryptedMessage[i] = message[i];
                continue;
            }
            int ch = message[i];

            int inCh;

            if (ch >= 65 && ch <= 90) {
                if (ch - key < 65) {
                    inCh = (ch - key + 1) + 90 - 65;
                } else {
                    inCh = ch - key;
                }
            } else {
                if (ch - key < 97 ) {
                    inCh = (ch - key + 1) + 122 - 97;
                } else {
                    inCh = ch - key;
                }
            }
            decryptedMessage[i] = (char) inCh;
        }
        return new String(decryptedMessage);
    }

}
