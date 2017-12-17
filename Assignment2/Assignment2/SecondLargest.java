import acm.program.*;

public class SecondLargest extends ConsoleProgram {
	
	public void run() {
		println("Enter integers to compute");
		initializeValues();
		computeValues();
		println("The largest value is " + largest);
		println("The second largest value is " + secondLargest);
	}
	
	private void initializeValues() {
		largest = readInt("?: ");
		i = readInt("?: ");
		if (i > largest) {
			secondLargest = largest;
			largest = i;
		} else secondLargest = i;
	}
	
	private void computeValues() {
		while(i != 0) {
			i = readInt("?: ");
			if (i > largest) {
				secondLargest = largest;
				largest = i;
			} else if(i > secondLargest) secondLargest = i;
		}
	}
	
	private int largest = 0;
	private int secondLargest = 0;
	private int i = 0;
}
