package encryptdecrypt;

import encryptdecrypt.crypt.Crypt;
import encryptdecrypt.crypt.ShiftDecryption;
import encryptdecrypt.crypt.ShiftEncryption;

public class ShiftCryptFactory extends Factory {

    @Override
    Crypt setEncrypt() {
        return new ShiftEncryption();
    }

    @Override
    Crypt setDecrypt() {
        return new ShiftDecryption();
    }
}
