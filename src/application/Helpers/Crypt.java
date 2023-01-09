package application.Helpers;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Methods to encrypt or decrypt Data
 * 
 * @author Christian
 */
public class Crypt {
	/**
	 * 
	 * @param key  String of key
	 * @param data String of Data to be encrypted
	 * @return String of encrypted Data
	 * @throws Exception
	 */
	public String encrypt(String key, String data) throws Exception {
		try {
			byte[] decodedKey = Base64.getDecoder().decode(key);
			SecretKey secretKey = new SecretKeySpec(decodedKey, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedData = cipher.doFinal(data.getBytes());
			return Base64.getEncoder().encodeToString(encryptedData);
		} catch (Exception error) {
			PopUps.errorMessage(error.getMessage());
			return null;
		}
	}

	/**
	 *
	 * @return Base64 String of generated Key
	 * @throws NoSuchAlgorithmException
	 */
	public String createKey() {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128);
			SecretKey secretKey = keyGen.generateKey();
			return Base64.getEncoder().encodeToString(secretKey.getEncoded());
		} catch (Exception error) {
			PopUps.errorMessage(error.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @param key           String of key
	 * @param encryptedData String of Data to be decrypted
	 * @return String of decrypted Data
	 * @throws Exception
	 */
	public String decrypt(String key, String encryptedData) throws Exception {
		try {
		byte[] decodedKey = Base64.getDecoder().decode(key);
		SecretKey secretKey = new SecretKeySpec(decodedKey, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
		return new String(decryptedData);
		} catch (Exception error) {
			PopUps.errorMessage(error.getMessage());
			return null;
		}
	}
}
