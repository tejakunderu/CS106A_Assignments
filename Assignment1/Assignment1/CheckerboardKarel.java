/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run(){
		fillColumn1();
		while(frontIsClear()){
			move();
			fillColumn2();
			if(frontIsClear()){
				move();
				fillColumn1();
			}
		}
	}
	
	public void fillColumn1(){
		turnLeft();
		putBeeper();
		while(frontIsClear()){
			move();
			if(frontIsClear()){
				move();
				putBeeper();
			}
		}
		turnAround();
		while(frontIsClear())
			move();
		turnLeft();
	}
	
	public void fillColumn2(){
		turnLeft();
		if(frontIsClear()){
			move();
			putBeeper();
		}
		while(frontIsClear()){
			move();
			if(frontIsClear()){
				move();
				putBeeper();
			}
		}
		turnAround();
		while(frontIsClear())
			move();
		turnLeft();
	}

}
