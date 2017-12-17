import acm.program.*;

public class CaesarCipher extends ConsoleProgram {
	
	public void run() {
		String input = readLine("Enter string to encrypt: ");
		int key = readInt("Enter key: ");
		String output = caesarEncrypt(input, key);
		println("\nThe encrypted string is \"" + output + "\"");
		String decrypt = caesarEncrypt(output, -key);
		println("\nThe decrypted string is \"" + decrypt + "\"");
	}
	
	private String caesarEncrypt(String input, int key) {
		if(key < 0) key = (key % 26) + 26;
		String output = "";
		char ch;
		for(int  i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			output += encryptChar(ch, key);
		}
		return output;
	}
	
	private char encryptChar(char ch, int key) {
		if(Character.isUpperCase(ch)) {
			ch = (char)('A' + ((ch - 'A' + key) % 26));
		} else if(Character.isLowerCase(ch)) {
			ch = (char)('a' + ((ch - 'a' + key) % 26));
		}
		return ch;
	}

}
