import acm.program.*;

public class LetterSubstitutionCipher extends ConsoleProgram {
	
	public void run() {
		String input = readLine("Enter plaintext: ");
		String encryptionKey = "";
		while(true) {
			encryptionKey = readLine("Enter 26 alphabet key: ");
			if(encryptionKey.length() == 26) break;
			println("Key does not have 26 characters!");
		}
		String output = substitutionEncryptString(input, encryptionKey);
		println("The encrypted message is \"" + output + "\"");
		String decrypt = substitutionEncryptString(output, generateDecryptionKey(encryptionKey));
		println("The decrypted message is \"" + decrypt + "\"");
	}
	
	private String substitutionEncryptString(String input, String key) {
		String output = "";
		for(int i = 0; i < input.length(); i++) {
			output += substitutionEncryptChar(input.charAt(i), key);
		}
		return output;
	}
	
	private char substitutionEncryptChar(char chIn, String key) {
		int j = 0;
		if(Character.isUpperCase(chIn)) {
			while(true) {
				if(chIn == (char)('A' + j)) return Character.toUpperCase(key.charAt(j));
				j++;
			}
		} else if(Character.isLowerCase(chIn)) {
			while(true) {
				if(chIn == (char)('a' + j)) return Character.toLowerCase(key.charAt(j));
				j++;
			}
		} else return chIn;
	}
	
	private String generateDecryptionKey(String keyIn) {
		String keyOut = "";
		for(int i = 0; i < keyIn.length(); i++) {
			keyOut += decryptionKeyChar(keyIn, i);
		}
		return keyOut;
	}
	
	private char decryptionKeyChar(String keyIn, int i) {
		char chOut = '\0';
		for(int j = 0; j < keyIn.length(); j++) {
			if(Character.isUpperCase(keyIn.charAt(j))) {
				if((char)('A' + i) == keyIn.charAt(j)) chOut = (char)(j + 'A'); 
			} else if(Character.isLowerCase(keyIn.charAt(j))) {
				if((char)('a' + i) == keyIn.charAt(j)) chOut = (char)(j + 'a'); 
			}
		}
		return chOut;
	}
	
	//key qwertyuiopasdfghjklzxcvbnm
}
