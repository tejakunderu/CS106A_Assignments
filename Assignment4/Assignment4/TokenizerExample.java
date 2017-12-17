import acm.program.*;
import java.util.*;

public class TokenizerExample extends ConsoleProgram {
	
	public void run() {
		String input = readLine("Enter string to tokenize: ");
		println("\nThe tokens in the string are - ");
		printTokens(input);
	}
	
	private void printTokens(String input) {
		StringTokenizer tokenizer = new StringTokenizer(input, ".,! ");
		for(int count = 0; tokenizer.hasMoreTokens(); count++) println("Token #" + count + ": \"" + tokenizer.nextToken() + "\"");
	}

}
