package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text. Each number 0-63 is
	 * mapped to a character. NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE
	 * ENCODING! Since the numbers 0 through 63 can be represented using 6 bits,
	 * every four (4) characters will represent twenty four (24) bits of data. 4 * 6
	 * = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being
	 * converted do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML
	 * file (for web development), so that way a web site does not have to look for
	 * an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */

	final static char[] base64Chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '+', '/' };

	// 1. Complete this method so that it returns the the element in
	// the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c) {
		for (byte i = 0; i < base64Chars.length; i++) {
			if (c == base64Chars[i])
				return i;
		}
		return (byte) -1;
	}

	// 2. Complete this method so that it will take in a string that is 4
	// characters long and return an array of 3 bytes (24 bits). The byte
	// array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s) {
		byte[] bytes = new byte[3];
		byte[] chars = new byte[4];
		char[] c = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = convertBase64Char(c[i]);
		}
		bytes[0] = (byte) (chars[0] << 2 | chars[1] >> 4);
		bytes[1] = (byte) (chars[1] << 4 | chars[2] >> 2);
		bytes[2] = (byte) (chars[2] << 6 | chars[3]);
		return bytes;
	}

	// 3. Complete this method so that it takes in a string of any length
	// and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		byte[] bytes = new byte[(int) Math.floor(file.length() * 0.75)];
		char[] chars = file.toCharArray();
		byte[] c = new byte[chars.length];
		int bc = 0;
		for (int i = 0; i < chars.length; i++) {
			c[i] = convertBase64Char(chars[i]);
		}
		for (int i = 0; i < c.length; i+=4) {
			bytes[bc] = (byte) (c[i] << 2 | c[i+1] >> 4);
			bytes[bc+1] = (byte) (c[i+1] << 4 | c[i+2] >> 2);
			bytes[bc+2] = (byte) (c[i+2] << 6 | c[i+3]);
			bc+=3;
		}
		return bytes;
	}
}
