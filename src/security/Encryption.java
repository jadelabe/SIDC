package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;

public class Encryption {

	public static byte[] generateSalt() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		return bytes;
	}

	public static String encryptPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
		byte[] hash = generateHashWithSalt(password, salt);
		byte[] saltPlusHash = new byte[hash.length + salt.length];
		System.arraycopy(salt, 0, saltPlusHash, 0, salt.length);
		System.arraycopy(hash, 0, saltPlusHash, salt.length, hash.length);
		return byteToString(saltPlusHash);
	}

	public static boolean checkPassword(String hash, String input) throws NoSuchAlgorithmException {
		byte[] salt = new byte[20];
		System.out.println(hash.length());
		for (int i = 0; i < 20; i++) {
			salt[i] = stringToByte(hash)[i];
		}
		if (hash.equals(encryptPassword(input, salt))) {
			return true;
		} else {
			return false;
		}
	}

	private static byte[] generateHashWithSalt(String input, byte[] salt) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.reset();
		md.update(salt);
		byte[] hashedBytes = md.digest(stringToByte(input));
		return hashedBytes;
	}

	private static String byteToString(byte[] input) {
		return org.apache.commons.codec.binary.Base64.encodeBase64String(input);
	}

	private static byte[] stringToByte(String input) {
		if (Base64.isBase64(input)) {
			return Base64.decodeBase64(input);
		} else {
			return Base64.encodeBase64(input.getBytes());
		}
	}

}
