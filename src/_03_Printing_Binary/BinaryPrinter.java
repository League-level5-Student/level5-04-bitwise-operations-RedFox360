package _03_Printing_Binary;

public class BinaryPrinter {
	/*
	 * Complete the methods below so they print the passed in parameter in binary.
	 * Do not use the Integer.toBinaryString method!
	 * Use the main method to test your methods.
	 */

	
	public void printByteBinary(byte b) {
		// We first want to print the bit in the one's place
		for (int i = 7; i >= 0; i--) {
			System.out.print((b >> i) & 1);
		}
		//Use this method to print the remaining 7 bits of b
	}
	
	public void printShortBinary(short s) {
		// Create 2 byte variables
		byte byte1, byte2;
		// Use bit shifting and masking (&) to save the first
		// 8 bits of s in one byte, and the second 8 bits of
		// s in the other byte
		byte1 = (byte) (s >> 8);
		System.out.println(byte1);
		// Call printByteBinary twice using the two bytes
		// Make sure they are in the correct order
	}
	
	public void printIntBinary(int i) {
		// Create 2 short variables
		
		// Use bit shifting and masking (&) to save the first
		// 16 bits of i in one short, and the second 16 bits of
		// i in the other short
		
		// Call printShortBinary twice using the two short variables
		// Make sure they are in the correct order
	}
	
	public void printLongBinary(long l) {
		// Use the same method as before to complete this method
	}
	
	public static void main(String[] args) {
		// Test your methods here
		BinaryPrinter printer = new BinaryPrinter();
		System.out.println("---BYTE---");
		printer.printByteBinary((byte) 8);
		System.out.println("\n---SHORT---");
		printer.printShortBinary((short) 65535);
	}
}
