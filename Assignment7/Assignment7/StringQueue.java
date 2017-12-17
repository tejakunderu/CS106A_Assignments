import java.util.*;

public class StringQueue {
	
	public StringQueue() {
		array = new ArrayList<String>();
	}
	
	public void add(String str) {
		array.add(str);
	}
	
	public String poll() {
		if(array.size() == 0)
			return null;
		String str = array.get(0);
		array.remove(0);
		return str;
	}
	
	public int size() {
		return array.size();
	}
	
	private ArrayList<String> array;

}
