import acm.program.*;

public class Palindrome extends ConsoleProgram {
	
	public void run() {
		String input = readLine("Enter String to check for palindrome: ");
		String output = reverseString(input);
		println("The reverse of the string \"" + input + "\" is \"" + output + "\"");
		println("Is the string a palindrome? " + isPalindrome(input));
	}
	
	private boolean isPalindrome(String input) {
		for(int i = 0; i < input.length() / 2; i++) {
			if(input.charAt(i) != input.charAt(input.length() - 1 - i)) return false;
		}
		return true;
		
		//String output = reverseString(input);
		//return(input.equals(output));
	}
	
	private String reverseString(String input) {
		String output = "";
		for(int i = 0; i < input.length(); i++) {
			output = input.charAt(i) + output;
		}
		return output;
	}

}
