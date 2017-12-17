import acm.program.*;

public class RemoveDoubledLetters extends ConsoleProgram {
	
	public void run() {
		String input = readLine("Enter string: ");
		String output = removeDoubledLetters(input);
		println("String after removing doubled letters: \"" + output + "\"");
	}
	
	private String removeDoubledLetters(String input) {
		String output = "";
		char ch;
		for(int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			if(i == 0 || ch != input.charAt(i - 1)) output += input.charAt(i); 
		}
		return output;
	}
	
}
