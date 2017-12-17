import acm.program.*;

public class RemoveStringOccurences extends ConsoleProgram {
	
	public void run() {
		String input = readLine("Enter string: ");
		String occurence = readLine("Enter occurence to remove: ");
		String output = removeStringOccurence(input, occurence);
		println(output);
	}
	
	private String removeStringOccurence(String input, String occurence) {
		while(true) {
			int index = input.indexOf(occurence);
			if(index == -1) break;
			input = input.substring(0, index) + input.substring(index + occurence.length());
		}
		return input;
	}

}
