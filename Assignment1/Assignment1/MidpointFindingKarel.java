/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run(){
		zigzagLeftToRight();
		positionForStepTwo();
		zigzagRightToLeft();
		returnToInitialPosition();
		clearSingleBeepers();
		findRemainingBeeper();
		clearBeepersAround();
		putBeeperAtMidpoint();
	}
	
	private void zigzagLeftToRight(){
		putBeeper();
		while(frontIsClear()){
			if(facingEast()){
				move();
				putBeeper();
				turnLeft();
			}else{
				move();
				putBeeper();
				turnRight();
			}		
		}
	}
	
	private void returnToInitialPosition(){
		if(facingWest()){
			turnLeft();
			moveToWall();
			turnRight();
			moveToWall();
			turnAround();
		} else if(facingEast()){
			turnRight();
			moveToWall();
			turnRight();
			moveToWall();
			turnAround();
		} else if(facingNorth()){
			turnAround();
			moveToWall();
			turnRight();
			moveToWall();
			turnAround();
		}
	}
	
	private void moveToWall(){
		while(frontIsClear())
			move();
	}
	
	private void positionForStepTwo(){
		if(facingEast()){
			turnRight();
			moveToWall();
		} else {
			turnAround();
			moveToWall();
		}
		turnRight();
	}
	
	private void zigzagRightToLeft(){
		putBeeper();
		while(frontIsClear()){
			if(facingWest()){
				move();
				putBeeper();
				turnRight();
			} else {
				move();
				putBeeper();
				turnLeft();
			}		
		}
	}
	
	private void clearSingleBeepers(){
		clearRow();
		while(leftIsClear()){
			moveToNextRow();
			clearRow();
			if(rightIsClear()){
				moveToNextRow();
				clearRow();
			} else turnAround();
		}
		returnToInitialPosition();
	}
	
	private void clearRow(){
		while(frontIsClear()){
			if(beepersPresent())
				pickBeeper();
			move();
		}
		if(beepersPresent())
			pickBeeper();
	}
	
	private void moveToNextRow(){
		if(facingEast()){
			turnLeft();
			move();
			turnLeft();
		} else {
			turnRight();
			move();
			turnRight();
		}
	}
	
	private void findRemainingBeeper(){
		while(noBeepersPresent()){
			if(frontIsClear())
				move();
			else moveToNextRow();
		}
	}
	
	private void clearBeepersAround(){
		clearBeeperAhead();
		turnAround();
		clearBeeperAhead();
		turnLeft();
		clearBeeperAhead();
		turnAround();
		clearBeeperAhead();
		turnLeft();
	}
	
	private void clearBeeperAhead(){
		if(frontIsClear())
			move();
		if(beepersPresent())
			pickBeeper();
		turnAround();
		move();
		turnAround();
	}
	
	private void putBeeperAtMidpoint(){
		if(facingEast()){
			pickBeeper();
			turnRight();
			moveToWall();
			putBeeper();
		} else {
			pickBeeper();
			turnLeft();
			moveToWall();
			putBeeper();
		}
	}
}
