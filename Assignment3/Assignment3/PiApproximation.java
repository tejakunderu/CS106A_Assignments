import acm.program.*;
import acm.util.*;

public class PiApproximation extends ConsoleProgram {
	
	private static final int NDARTS = 100000;
	
	public void run () {
		int inside = 0;
		
		for(int i=0; i<NDARTS; i++){
			double x = rgen.nextDouble(-1.0, +1.0);
			double y = rgen.nextDouble(-1.0, +1.0);
			if(x*x+y*y < 1.0)
				inside ++;
		}
			
		double pi = (inside*4.0)/NDARTS;
		println("The value of Pi is approximately " + pi);	
	}

	private RandomGenerator rgen = RandomGenerator.getInstance();
}
