import acm.program.*;

public class AddIntegers extends ConsoleProgram {
	public void run() {
		println("This program adds two integers");
		int n1 = readInt("Enter n1: ");
		int n2 = readInt("Enter n2: ");
		int sum = n1+n2;
		println("The sum of integers "+n1+" and "+n2+" is "+sum+"");
	}
}