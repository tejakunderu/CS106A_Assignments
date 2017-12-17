import acm.program.*;

public class CountUppercase extends ConsoleProgram {
	
	public void run() {
		String input = readLine("Enter string: ");
		int output = countUppercase(input);
		println("The number of uppercase letters in \"" + input + "\" is \"" + output + "\"");
	}
	
	private int countUppercase(String input) {
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			if(Character.isUpperCase(input.charAt(i))) count++; 
		}
		return count;
	}

}
