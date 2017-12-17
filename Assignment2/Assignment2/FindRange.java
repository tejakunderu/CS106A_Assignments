/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int sentinel = 0;
	
	public void run() {
		int x = 0;
		int max = 0;
		int min = 0;
		int i = 0;
		
		while(true){
			x = readInt("? ");
			if(x==sentinel) break;
			if(i==0){
				max=x;
				min=x;
			} else {
				if(x>max) max = x;
		    	if(x<min) min = x;
			}
			i++;
		}
		
		switch (i) {
		case 0:
			println("no values entered");
			break;
		default:
		    println("max = "+max+", min = "+min);
			break;
		}
	}
}

