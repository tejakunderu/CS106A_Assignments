/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int hail_Num = readInt("Enter a number: ");
		int temp = hail_Num;
		int count = 0;
		while(temp!=1){
			if(temp%2==0){
				println(temp+" is even so I take half: "+temp/2);
				temp = temp/2;
				count++;
			} else {
				println(temp+" is odd, so I make 3n + 1: "+(3*temp+1));
				temp=3*temp+1;
				count++;
			}
		}
		println("The process took "+count+" to reach 1");
	}
}

