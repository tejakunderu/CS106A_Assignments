import java.util.*;
import acm.program.*;

public class UniqueNames extends ConsoleProgram {
	
	public void run() {
		readNames();
		checkUniqueNames();
		printUniqueNames();
	}
	
	private void readNames() {
		names = new ArrayList<String>();
		while(true) {
			String prompt = readLine("Enter name: ");
			if(prompt.equals("")) break;
			names.add(prompt);
		}
	}
	
	private void checkUniqueNames() {
		uniqueNames = new ArrayList<String>();
		for(String temp: names) {
			if(!nameExists(temp)) 
				uniqueNames.add(temp);
		}
	}
	
	private boolean nameExists(String temp) {
		for(String name: uniqueNames) {
			if(temp.equals(name)) 
				return true;
		}
		return false;
	}
	
	private void printUniqueNames() {
		println("Unique names from the list are: ");
		for(String name: uniqueNames) 
			println(name);
	}
	
	private ArrayList<String> names;
	private ArrayList<String> uniqueNames;

}
