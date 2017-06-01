import java.util.function.BinaryOperator;

public class MoveToFront {
	// apply move-to-front encoding, reading from standard input and writing to standard output
	public static void encode()
	{
		String input = StdIn.readAll();
		char[] chars = new char[256];
		for (int i = 0; i < 256; i++) {
			chars[i] = (char) i;
		}
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			for (int j = 0; j < 256; j++) {
				if (c == chars[j]) {
					BinaryStdOut.write((char) j);
					chars = moveToFront(chars, j);
				}
			}
		}
		BinaryStdOut.flush();
	}

	public static char[] moveToFront(char[] chars, int index) {
		char c = chars[index];
		char temp = chars[0];
		chars[0] = c;
		c = temp;
		for (int i = 1; i <= index; i++) {
			temp = chars[i];
			chars[i] = c;
			c = temp;
		}
		return chars;
	}
	// apply move-to-front decoding, reading from standard input and writing to standard output
	public static void decode()
	{
		char[] chars = new char[256];
		for (int i = 0; i < 256; i++) {
			chars[i] = (char) i;
		}
		while (!BinaryStdIn.isEmpty()) {
			char c = BinaryStdIn.readChar();
			int index = (int) c;
			StdOut.print(chars[index]);
			chars = moveToFront(chars, index);
		}
	}
	// if args[0] is '-', apply move-to-front encoding
	// if args[0] is '+', apply move-to-front decoding
	public static void main(String[] args)
	{
		if (args[0].equals("-"))
			encode();
		else if (args[0].equals("+"))
			decode();
	}
}