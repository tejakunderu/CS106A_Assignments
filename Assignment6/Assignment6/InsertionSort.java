import  acm.program.*;
import java.util.*;

public class InsertionSort extends ConsoleProgram {
	
	public void run() {
		unSorted = new ArrayList<Integer>();
		readElementsToSort();
		sortElementsInArray();
		printSortedElements();
	}
	
	private void readElementsToSort() {
		println("Enter elements you want to sort: ");
		while(true) {
			int i = readInt("?: ");
			if(i == 0) break;
			unSorted.add(i);
		}
		int length = unSorted.size();
		sorted = new int[length];
		for(int i = 0; i < length; i++)
			sorted[i] = unSorted.get(i);
	}
	
	private void sortElementsInArray() {
		for(int i = 1; i < sorted.length; i++) {
			int current = i - 1;
			int main = i;
			while(true) {
				if(sorted[main] < sorted[current]) {
					swapElements(main, current);
					main = current;
				}
				current--;
				if(current == -1) break;
			}
		}
	}
	
	private void swapElements(int main, int current) {
		int temp = sorted[main];
		sorted[main] = sorted[current];
		sorted[current] = temp;
	}
	
	private void printSortedElements() {
		println("The elements in ascending order: ");
		for(int i = 0; i < sorted.length; i++)
			println(sorted[i]);
	}
	
	private ArrayList<Integer> unSorted;
	private int[] sorted;

}
