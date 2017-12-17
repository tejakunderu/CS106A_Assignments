import acm.program.*;
import acm.util.*;

public class DieRoll extends ConsoleProgram {
	private static final int NUM_SIDES = 6;
	
	public void run() {
		int num_dice = readInt("Enter number of dice: ");
		int max_score = NUM_SIDES * num_dice;
		int num_rolls = 0;
		while(true){
			int score = rollDice(num_dice);
			num_rolls++;
			if(score == max_score) break;
			println("Rolled "+score);
		}
		println("Rolled "+max_score+" after "+num_rolls+" rolls");
	}
	
	private int rollDice(int num_dice) {
		int score = 0;
		for(int i=0;i<num_dice;i++)
			score = score + randGen.nextInt(1,NUM_SIDES);
		return score;
	}

	private RandomGenerator randGen = RandomGenerator.getInstance();
}
