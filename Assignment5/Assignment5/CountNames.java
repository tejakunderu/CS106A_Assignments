import java.util.*;
import acm.program.*;

public class CountNames extends ConsoleProgram {
	
	public void run() {
		readNames();
		countNames();
		printNames();
	}
	
	private void readNames() {
		names = new ArrayList<String>();
		while(true) {
			String prompt = readLine("Enter name: ");
			if(prompt.equals("")) break;
			names.add(prompt);
		}
	}
	
	private void countNames() {
		nameCount = new HashMap<String, Integer>();
		for(String temp: names) {
			if(!nameExists(temp)) 
				nameCount.put(temp, 1);
			else updateCount(temp);
		}
	}
	
	private boolean nameExists(String temp) {
		for(String name: nameCount.keySet()) {
			if(temp.equals(name)) 
				return true;
		}
		return false;
	}
	
	private void updateCount(String temp) {
		int count = nameCount.get(temp);
		count ++;
		nameCount.remove(temp);
		nameCount.put(temp, count);
	}
	
	private void printNames() {
		for(String name: nameCount.keySet()) 
			println("Entry [" + name + "] has count " + nameCount.get(name));
	}
	
	private ArrayList<String> names;
	private Map<String, Integer> nameCount;

}
