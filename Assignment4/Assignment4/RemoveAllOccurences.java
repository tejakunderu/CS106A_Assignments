import acm.program.*;

public class RemoveAllOccurences extends ConsoleProgram {
	
	public void run() {
		String input = readLine("Enter string: ");
		char ch = '\0';
		String occurence = "";
		while(true) {
			occurence = readLine("Enter occurence to remove: ");
			if(occurence.length() == 1) {
				ch = occurence.charAt(0);
				break;
			}
			println("Invalid character!");
		}
		println("The string \"" + input + "\" after removing all occurences of '" + ch + "' is \"" + removeAllOccurences(input, ch) + "\"");
		
	}
	
	private String removeAllOccurences(String input, char ch) {
		int index = 0;
		while(true) {
			index = findAnOccurence(input, ch);
			if(index == -1) break;
			input = recreateStringWithoutOccurence(input, index);
		}
		return input;
	}
	
	private int findAnOccurence(String input, char ch) {
		return input.indexOf(ch);
	}
	
	private String recreateStringWithoutOccurence(String input, int index) {
		return (input.substring(0,index) + input.substring(index + 1));
	}

}
