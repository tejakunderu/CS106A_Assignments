import java.util.*;

public class ExpandableArray {
	
	public ExpandableArray() {
		array = new ArrayList<Object>();
	}
		
	public void set(int index, Object value) {
		if(array.size() <= index)
			expandArray(index);
		array.set(index, value);
	}
	
	private void expandArray(int endIndex) {
		int startIndex = array.size();
		for(int i = startIndex; i <= endIndex; i++) {
			array.add(null);
		}
	}
		
	public Object get(int index) {
		if(array.size() <= index)
			expandArray(index);
		return array.get(index);
	}
	
	public int size() {
		return array.size();
	}
	
	private ArrayList<Object> array;

}
