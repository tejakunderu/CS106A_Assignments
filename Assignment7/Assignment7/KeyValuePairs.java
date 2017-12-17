import java.util.*;
import acm.program.*;

public class KeyValuePairs extends ConsoleProgram {
	
	public void run() {
		setFont("-56");
		initialiseFirstMap();
		initialiseSecondMap();
		int i = commonKeyValuePairs(map1, map2);
		println("The number of common key value pairs in Map 1 and Map 2 are: " + i);
	}
	
	private void initialiseFirstMap() {
		map1 = new HashMap<String, String>();
		println("Enter values for Map 1");
		while(true) {
			String key = readLine("Enter key: ");
			if(key.equals("") && (map1.size() != 0)) break;
			String value = readLine("Enter value: ");
			map1.put(key, value);
		}
	}
	
	private void initialiseSecondMap() {
		map2 = new HashMap<String, String>();
		println("Enter values for Map 2");
		while(true) {
			String key = readLine("Enter key: ");
			if(key.equals("") && (map2.size() != 0)) break;
			String value = readLine("Enter value: ");
			map2.put(key, value);
		}
	}
	
	private int commonKeyValuePairs(HashMap<String, String> map1, HashMap<String, String> map2) {
		int i = 0;
		for(String key1: map1.keySet())
			if(map2.containsKey(key1))
				if(map2.get(key1).equals(map1.get(key1)))
					i++;
		return i;
	}
	
	private HashMap<String, String> map1;
	private HashMap<String, String> map2;

}
