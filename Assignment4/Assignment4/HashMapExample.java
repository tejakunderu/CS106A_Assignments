import acm.program.*;
import java.util.*;

public class HashMapExample extends ConsoleProgram {
	
	public void run() {
		println("Reading phone numbers");
		readPhoneNumbers();
		
		println("\nLooking up phone numbers");
		lookUpNumbers();
		
		println("\nDisplaying phone numbers");
		displayAllNumbers();
		displayAllNumbersAlt();
	}
	
	private void readPhoneNumbers() {
		while(true) {
			String name = readLine("\nEnter name: ");
			if(name.equals("")) break;
			int number = readInt("Enter phone number: ");
			
			phonebook.put(name, number);
		}
	}
	
	private void lookUpNumbers() {
		while(true) {
			String name = readLine("\nEnter name to look up: ");
			if(name.equals("")) break;
			Integer number = phonebook.get(name);
			if(number == null) 
				println("Number not in phonebook"); 
			else println(number);
		}
	}
	
	private void displayAllNumbers() {
		Iterator<String> i = phonebook.keySet().iterator();
		while(i.hasNext()) {
			String name = i.next();
			int number = phonebook.get(name);
			println("\nThe number of contact " + name + " is " + number);
		}
	}
	
	private void displayAllNumbersAlt() {
		println("\n");
		for(String name: phonebook.keySet()) {
			int number = phonebook.get(name);
			println("\nThe number of contact " + name + " is " + number);
		}
	}
	
	private Map<String, Integer> phonebook = new HashMap<String, Integer>();

}
