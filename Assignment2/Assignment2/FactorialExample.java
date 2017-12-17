import acm.program.*;
import java.lang.*;

public class FactorialExample extends ConsoleProgram {
	private static final int MAX_NUM = 10;
	
	public void run() {
//		for (int i=0;i<=MAX_NUM;i++)
//			println("the factorial of "+i+" is "+ComputeFactorial(i));
		
		int i = readInt("?: ");
		println("Factorial is: " + ComputeFactorial(i));
	}
	
//	private int ComputeFactorial(int fac){
//		int factorial = 1;
//		for(int j=1;j<=fac;j++)
//			factorial *= j;
//		return factorial;
//	}
	
	private int ComputeFactorial(int fac) {
		if(fac == 1) return 1;
		return fac * ComputeFactorial(fac - 1);
	}
}