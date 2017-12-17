import stanford.karel.*;

public class BorderKarel extends SuperKarel {
	
	public void run() {
		for(int i = 0; i < 4; i++) {
			positionToFillBorder();
			fillBorder();
		}
	}
	
	private void positionToFillBorder() {
		if(!frontIsClear()) turnLeft();
		turnLeft();
		move();
		turnRight();
	}
	
	private void fillBorder() {
		while(frontIsClear()) {
			move();
			if(!beepersPresent() && frontIsClear()) putBeeper();
		}
	}

}
