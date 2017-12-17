/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;
import java.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		while(true) {
			if(nPlayers <= MAX_PLAYERS) break;
			nPlayers = dialog.readInt("Invalid number! Enter number of players");
		}
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		scoreCard = new int[N_CATEGORIES][nPlayers];
		selectedCategories = new int[16][nPlayers];
		for(int i = 0 ; i < N_SCORING_CATEGORIES; i++) {
			for(int player = 1; player <= nPlayers; player++) {
				firstRoll(player);
				nextRoll();
				nextRoll();
				selectCategoryAndUpdateScore(player);
			}
		}
		displayFinalScores();
	}
	
	private void firstRoll(int player) {
		display.printMessage(playerNames[player - 1] + "'s turn! Click \"Roll Dice\" button to roll the dice");
		display.waitForPlayerToClickRoll(player);
		rollDice();
		display.displayDice(dice);
	}
	
	private void rollDice() {
		dice = new int[N_DICE];
		for(int i = 0; i < N_DICE; i++)
			dice[i] = rgen.nextInt(1, 6);
	}
	
	private void nextRoll() {
		display.printMessage("Select the dice you wish to re-roll and click \"Roll Again\"");
		display.waitForPlayerToSelectDice();
		reRollDice();
		display.displayDice(dice);
	}
	
	private void reRollDice() {
		for(int i = 0; i < N_DICE; i++)
			if(display.isDieSelected(i)) dice[i] = rgen.nextInt(1, 6);
	}
	
	private void selectCategoryAndUpdateScore(int player) {
		display.printMessage("Select a category for this roll");
		while(true) {
			category = display.waitForPlayerToSelectCategory();
			if(selectedCategories[category][player - 1] == 0) break;
			display.printMessage("Category already selected! Select a different category");
		}
		selectedCategories[category][player - 1] = 1;
		setCategoryScore();
		updateScoresArray(player);
		display.updateScorecard(category, player, score);
		display.updateScorecard(TOTAL, player, scoreCard[TOTAL - 1][player - 1]);
	}
	
	private void setCategoryScore() {
		if(!checkCategory(category))
			score = 0;
		else computeCategoryScore();
	}
	
	private int computeCategoryScore() {
		switch(category) {
		case ONES: score = computeBasicCategoryScore(ONES);
					break;
		case TWOS: score = computeBasicCategoryScore(TWOS);
					break;
		case THREES: score = computeBasicCategoryScore(THREES);
					break;
		case FOURS: score = computeBasicCategoryScore(FOURS);
					break;
		case FIVES: score = computeBasicCategoryScore(FIVES);
					break;
		case SIXES: score = computeBasicCategoryScore(SIXES);
					break;
		case THREE_OF_A_KIND: score = computeTotalOnDice();
					break;
		case FOUR_OF_A_KIND: score = computeTotalOnDice();
					break;
		case FULL_HOUSE: score = 25;
					break;
		case SMALL_STRAIGHT: score = 30;
					break;
		case LARGE_STRAIGHT: score = 40;
					break;
		case YAHTZEE: score = 50;
					break;
		case CHANCE: score = computeTotalOnDice();
					break;
		}
		return score;
	}
	
	private int computeBasicCategoryScore(int category) {
		int score = 0;
		for(int i = 0; i < N_DICE; i++)
			if(dice[i] == category) 
				score += category;
		return score;
	}
	
	private int computeTotalOnDice() {
		int score = 0;
		for(int i = 0; i < N_DICE; i++)
			score += dice[i];
		return score;
	}
	
	private void updateScoresArray(int player) {
		scoreCard[category - 1][player - 1] = score;
		scoreCard[TOTAL - 1][player - 1] += score;
	}
	
	private void displayFinalScores() {
		int winner = 0;
		int maxScore = 0;
		for(int player = 1; player <= nPlayers; player++) {
			calculateUpperScore(player);
			checkForUpperBonus(player);
			calculateLowerScore(player);
			if(scoreCard[TOTAL - 1][player - 1] > maxScore){
				winner = player;
				maxScore = scoreCard[TOTAL - 1][player - 1];
			}
		}
		display.printMessage("Congratulations, " + playerNames[winner - 1] + ", you're the winner with a total score of " + maxScore + "!");
	}
	
	private void calculateUpperScore(int player) {
		for(int i = ONES; i <= SIXES; i++)
			scoreCard[UPPER_SCORE - 1][player - 1] += scoreCard[i - 1][player - 1];
		display.updateScorecard(UPPER_SCORE, player, scoreCard[UPPER_SCORE - 1][player - 1]);
	}
	
	private void checkForUpperBonus(int player) {
		if(scoreCard[UPPER_SCORE - 1][player - 1] > 63) {
			scoreCard[UPPER_BONUS][player - 1] = 35;
			scoreCard[TOTAL - 1][player - 1] += 35;
			display.updateScorecard(TOTAL, player, scoreCard[TOTAL - 1][player - 1]);
		}
		display.updateScorecard(UPPER_BONUS, player, scoreCard[UPPER_BONUS - 1][player - 1]);
	}
	
	private void calculateLowerScore(int player) {
		for(int i = THREE_OF_A_KIND; i <= CHANCE; i++)
			scoreCard[LOWER_SCORE - 1][player - 1] += scoreCard[i - 1][player - 1];
		display.updateScorecard(LOWER_SCORE, player, scoreCard[LOWER_SCORE - 1][player - 1]);
	}
	
	private boolean checkCategory(int category) {
		switch(category) {
		case THREE_OF_A_KIND: return checkForMultiplesOnDice(3);
		case FOUR_OF_A_KIND: return checkForMultiplesOnDice(4);
		case YAHTZEE: return checkForMultiplesOnDice(5);
		case FULL_HOUSE: return (checkForMultiplesOnDice(2) && checkForMultiplesOnDice(3));
		case SMALL_STRAIGHT: return checkForStraight(SMALL_STRAIGHT);
		case LARGE_STRAIGHT: return checkForStraight(LARGE_STRAIGHT);
		default: return true;
		}
	}
	
	private boolean checkForMultiplesOnDice(int value) {
		int[] count = new int[N_DICE];
		for(int i = 0; i < N_DICE; i++)
			for(int j = 0; j < N_DICE; j++)
				if(dice[i] == dice[j]) count[i]++;
		
		for(int i = 0; i < N_DICE; i++) {
			if(count[i] == value)
				return true;
		}
		return false;
	}
	
	private boolean checkForStraight(int value) {
		ArrayList<Integer> rolls = new ArrayList<Integer>();
		for(int i = 0; i < N_DICE; i++)
			rolls.add(dice[i]);
		
		ArrayList<Integer> commonValuesSmall = new ArrayList<Integer>(Arrays.asList(3, 4));
		ArrayList<Integer> commonValuesLarge = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5));
		
		switch(value) {
		case SMALL_STRAIGHT: if(rolls.containsAll(commonValuesSmall))
								if(rolls.contains(1) && rolls.contains(2))
									return true;
								else if(rolls.contains(2) && rolls.contains(5))
									return true;
								else if(rolls.contains(5) && rolls.contains(6))
									return true;
		case LARGE_STRAIGHT: if(rolls.containsAll(commonValuesLarge))
								if(rolls.contains(1) || rolls.contains(6))
									return true;
		}
		return false;
	}
		
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private int[] dice;
	private int score;
	private int category;
	private int[][] selectedCategories;
	private int[][] scoreCard;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}
