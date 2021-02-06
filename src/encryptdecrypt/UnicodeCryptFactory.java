package encryptdecrypt;

import encryptdecrypt.crypt.Crypt;
import encryptdecrypt.crypt.UnicodeDecryption;
import encryptdecrypt.crypt.UnicodeEncryption;

public class UnicodeCryptFactory extends Factory {

    @Override
    Crypt setEncrypt() {
        return new UnicodeEncryption();
    }

    @Override
    Crypt setDecrypt() {
        return new UnicodeDecryption();
    }
}
