import acm.program.*;

public class LetterSubstitutionCipher2 extends ConsoleProgram {
	
	public void run() {
		String plaintext = readLine("Enter plaintext: ");
		String key = readKey();
		String ciphertext = encrypt(plaintext, key);
		String decryption = decrypt(ciphertext, key);
		println("Ciphertext: \"" + ciphertext + "\"");
		println("Decryption: \"" + decryption + "\"");
	}
	
	private String readKey() {
		String key = readLine("Enter 26-alphabet key: ");
		while(!isKeyLegal(key)) {
			println("Key is invalid!");
			key = readLine("Enter valid key: ");
		}
		return key;
	}
	
	private boolean isKeyLegal(String key) {
		if(key.length() != 26) return false;
		for(int i = 0; i < 26; i++) {
			if(Character.isLowerCase(key.charAt(i))) return false;
			char ch = key.charAt(i);
			for(int j = i + 1; j < 26; j++) {
				if(key.charAt(j) == ch) return false;
			}
		}
		return true;
	}
	
	private String encrypt(String input, String key) {
		String output = "";
		for(int i = 0; i < input.length(); i++) {
			output += encryptCharacter(input.charAt(i), key);
		}
		return output;
	}
	
	private char encryptCharacter(char ch, String key) {
		if(Character.isLetter(ch)) ch = key.charAt(Character.toUpperCase(ch) - 'A');
		return ch;
	}

	private String decrypt(String input, String key) {
		String output = "";
		for(int i = 0; i < input.length(); i++) {
			output += decryptCharacter(input.charAt(i), key);
		}
		return output;
	}
	
	private char decryptCharacter(char ch, String key) {
		int index = key.indexOf(ch);
		if(index != -1) ch = (char)(index + 'A');
		return ch;
	}
	
//	key QWERTYUIOPASDFGHJKLZXCVBNM
}
