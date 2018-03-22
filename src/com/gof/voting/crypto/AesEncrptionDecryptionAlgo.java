package com.gof.voting.crypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * AesEncrptionDecryptionAlgo.java class is used to encryption and decryption.
 * 
 * @author suraj singh
 *
 */
public class AesEncrptionDecryptionAlgo {

	private static final String ALGO = "AES";

	private static final String FILE_PATH = "/com/gof/voting/config/test.txt";

	/**
	 * Encrypt a string with AES algorithm.
	 *
	 * @param data
	 *            is a string
	 * @return the encrypted string
	 */
	public String encrypt(String data) {
		Key key = null;
		Cipher c = null;
		byte[] encVal = null;
		try {
			key = generateKey();
			c = Cipher.getInstance(ALGO);
			c.init(Cipher.ENCRYPT_MODE, key);
			encVal = c.doFinal(data.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new BASE64Encoder().encode(encVal);
	}

	/**
	 * Decrypt a string with AES algorithm.
	 *
	 * @param encryptedData
	 *            is a string
	 * @return the decrypted string
	 * @throws Exception
	 */
	public String decrypt(String encryptedData) {
		Key key = null;
		Cipher c = null;
		byte[] decordedValue = null;
		byte[] decValue = null;
		try {
			key = generateKey();
			c = Cipher.getInstance(ALGO);
			c.init(Cipher.DECRYPT_MODE, key);
			decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
			decValue = c.doFinal(decordedValue);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new String(decValue);
	}

	/**
	 * Generate a new encryption key.
	 */
	private static Key generateKey() throws Exception {
		return new SecretKeySpec(getPublicKey().getBytes(), ALGO);
	}

	private static String getPublicKey() {
		BufferedReader br = null;
		StringBuilder sb = null;
		try {
			InputStream in = AesEncrptionDecryptionAlgo.class
					.getResourceAsStream(FILE_PATH);
			br = new BufferedReader(new InputStreamReader(in));
			sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	
	/*public static void main(String[] args) throws Exception {
		AesEncrptionDecryptionAlgo sha256CryptoAES = new AesEncrptionDecryptionAlgo();
		String enc = sha256CryptoAES.encrypt("surajcse");
		System.out.println(enc);
		String dec = sha256CryptoAES.decrypt(enc);
		System.out.println(dec);
		System.out.println("suraj".equals(dec));
	}*/
	 
}
