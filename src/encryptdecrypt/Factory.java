package encryptdecrypt;

import encryptdecrypt.crypt.Crypt;

public abstract class Factory {

    String crypt(String mode, String text, int key) {
        if (mode.equals("enc")) {
            Crypt t = setEncrypt();
            return t.solution(text, key);
        }
        if (mode.equals("dec")) {
            Crypt t = setDecrypt();
            return t.solution(text, key);
        }
        return "";
    }


    abstract Crypt setEncrypt();

    abstract Crypt setDecrypt();
}
