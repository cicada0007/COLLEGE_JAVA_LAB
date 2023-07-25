import java.math.BigInteger;
import java.security.SecureRandom;

public class RSAEncryption
{

    private BigInteger privateKey, publicKey, modulus;

    public void generateKeys(int keySize) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(keySize / 2, random);
        BigInteger q = BigInteger.probablePrime(keySize / 2, random);
        modulus = p.multiply(q);
        publicKey = new BigInteger("65537");
        privateKey = publicKey.modInverse(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
    }

    public BigInteger encrypt(String message) {
        return new BigInteger(message.getBytes()).modPow(publicKey, modulus);
    }

    public String decrypt(BigInteger ciphertext) {
        return new String(ciphertext.modPow(privateKey, modulus).toByteArray());
    }

    public static void main(String[] args) {
        RSAEncryption rsa = new RSAEncryption();
        int keySize = 1024;
        rsa.generateKeys(keySize);

        String message = "Hello, RSA encryption!";
        BigInteger encryptedMessage = rsa.encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = rsa.decrypt(encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
