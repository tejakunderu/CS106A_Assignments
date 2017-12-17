import acm.program.*;

public class ReverseString extends ConsoleProgram {
	
	public void run() {
		String input = readLine("Enter String to reverse: ");
		String output = reverseString(input);
		println("The reverse of the String \"" + input + "\" is \"" + output + "\"");
	}
	
	private String reverseString(String input) {
		String output = "";
		for(int i = 0; i < input.length(); i++) {
			output = input.charAt(i) + output;
		}
		return output;
	}

}
