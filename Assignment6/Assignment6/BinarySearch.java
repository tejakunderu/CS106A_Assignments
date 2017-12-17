import acm.program.*;
import java.util.*;
import java.io.*;
import acm.util.*;

public class BinarySearch extends ConsoleProgram {
	
	public void run() {
		num = new ArrayList<Integer>();
		readNumbersInFile("numbers.txt");
		int key = readInt("Enter number to search between 1 and 100: ");
		int index = findNumberIndex(key);
		println("The number " + key + " was found at index " + index);
	}
	
	private void readNumbersInFile(String filename) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while(true) {
				String str = rd.readLine();
				if(str == null) break;
				num.add(Integer.parseInt(str));
			}
		} catch(IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private int findNumberIndex(int key) {
		int low = 0;
		int high = num.size() - 1;
		int mid = 0;
		while(true) {
			mid = (low + high) / 2;
			int i = num.get(mid);
			println("index high: " + high + ", index low: " + low + ", mid: " + mid + ", value at index: " + i);
			if(i == key)
				break;
			else if(i > key && high != low)
				high = mid - 1;
			else if(i < key && high != low)
				low = mid + 1;
			else if(high == low) 
				return -1;
		}
		return mid;
	}
	
	private ArrayList<Integer> num;

}
