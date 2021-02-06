package encryptdecrypt.crypt;

public class UnicodeDecryption implements Crypt {
    @Override
    public String solution(String text, int key) {
        char[] message = text.toCharArray();
        char[] encryptedMessage = new char[message.length];
        for (int i = 0; i < message.length; i++) {
            int ch = message[i];
            int inCh = ch - key;
            encryptedMessage[i] = (char) inCh;
        }
        return new String(encryptedMessage);
    }
}
