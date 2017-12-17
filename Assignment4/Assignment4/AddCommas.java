import acm.program.*;

public class AddCommas extends ConsoleProgram {
	
	public void run() {
		while(true) {
			String input = readLine("Enter a number: ");
			if(input.length() == 0) break;
			println(addCommas(input));
		}
	}
	
	private String addCommas(String input) {
		String output = "";
		int length = input.length() - 1;
		for(int i = length; i >=0; i--) {
			if((length - i) % 3 == 0 && i != length) output = ',' + output;
			output = input.charAt(i) + output;
		}
		return output;
	}

}
