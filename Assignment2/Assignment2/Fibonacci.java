import acm.program.*;
import acm.graphics.*;

public class Fibonacci extends ConsoleProgram {
	private static final int MAX_TERM_VALUE = 10000; 
	
	public void run () {
		println("This program lists the Fibonacci sequence.");
		int a = 0;
		int b = 1;
		int temp = 0;
		
		while(a<MAX_TERM_VALUE){
			println(a);
			temp = b;
			b = a + b;
			a = temp;
		}
	}
}
