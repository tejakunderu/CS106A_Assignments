import acm.program.*;

public class UseCounter extends ConsoleProgram {
	public void run() {
		Incrementor count1 = new Incrementor();
		Incrementor count2 = new Incrementor(1000);
		
		println("Five values for count1: ");
		countFiveTimes(count1);
		
		println("\nFive values for count2: ");
		countFiveTimes(count2);
		
		println("\nAnother five values for count1: ");
		countFiveTimes(count1);
	}
	
	private void countFiveTimes(Incrementor count) {
		for(int i = 0; i < 5; i++)
			println(count.nextValue());
	}
}
