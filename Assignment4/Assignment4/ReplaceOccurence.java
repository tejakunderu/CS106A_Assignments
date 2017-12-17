import acm.program.*;

public class ReplaceOccurence extends ConsoleProgram {
	
	public void run() {
		String  input = readLine("Enter string: ");
		String occurence = readLine("Enter occurence to replace: ");
		String replacement = readLine("Enter replacement: ");
		String output = replaceOccurence(input, occurence, replacement);
		println(output);
	}
	
	private String replaceOccurence(String input, String occurence, String replacement) {
		String output = "";
		int index = input.indexOf(occurence);
		if(index == -1) return "\nNo \"" + occurence + "\" found in string";
		output = input.substring(0,index) + replacement + input.substring(index + occurence.length());
		return "\nThe string \"" + input + "\" after replacing \"" + occurence + "\" with \"" + replacement + "\" is \"" + output + "\"";
	}
}
