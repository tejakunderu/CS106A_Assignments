/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

	public void reset() {
		removeAll();
		initializeObjects();
		addObjects();
	}
	
	private void initializeObjects() {
		scaffold = new GLine(getWidth() / 2 - BEAM_LENGTH, getHeight() / 5, getWidth() / 2 - BEAM_LENGTH, getHeight() / 4 + SCAFFOLD_HEIGHT);
		beam = new GLine(getWidth() / 2 - BEAM_LENGTH, getHeight() / 5, getWidth() / 2, getHeight() / 5);
		rope = new GLine(getWidth() / 2, getHeight() / 5, getWidth() / 2, getHeight() / 5 + ROPE_LENGTH);
		head = new GOval(getWidth() / 2 - HEAD_RADIUS, getHeight() / 5 + ROPE_LENGTH, 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
		body = new GLine(getWidth() / 2, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS, getWidth() / 2, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
		left_upper_arm = new GLine(getWidth() / 2, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2 - UPPER_ARM_LENGTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		right_upper_arm = new GLine(getWidth() / 2, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2 + UPPER_ARM_LENGTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);
		left_lower_arm = new GLine(getWidth() / 2 - UPPER_ARM_LENGTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2 - UPPER_ARM_LENGTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		right_lower_arm = new GLine(getWidth() / 2 + UPPER_ARM_LENGTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD, getWidth() / 2 + UPPER_ARM_LENGTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
		left_hip = new GLine(getWidth() / 2, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH, getWidth() / 2 - HIP_WIDTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
		right_hip = new GLine(getWidth() / 2, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH, getWidth() / 2 + HIP_WIDTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);
		left_leg = new GLine(getWidth() / 2 - HIP_WIDTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH, getWidth() / 2 - HIP_WIDTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		right_leg = new GLine(getWidth() / 2 + HIP_WIDTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH, getWidth() / 2 + HIP_WIDTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		left_foot = new GLine(getWidth() / 2 - HIP_WIDTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, getWidth() / 2 - HIP_WIDTH - FOOT_LENGTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		right_foot = new GLine(getWidth() / 2 + HIP_WIDTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH, getWidth() / 2 + HIP_WIDTH + FOOT_LENGTH, getHeight() / 5 + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);
		
		dispWord = new GLabel("");
		dispWord.setFont("-30");
		incorrectGuesses = new GLabel("");
		incorrectGuesses.setFont("-20");
	}
	
	private void addObjects() {
		add(scaffold); 
		add(beam); 
		add(rope); 
		add(dispWord, 15, getHeight() - 50); 
		add(incorrectGuesses, 15, getHeight() - 25);
	}

	public void displayWord(String word) {
		dispWord.setLabel(word);
	}

	public void noteIncorrectGuess(char letter) {
		guess += letter;
		incorrectGuesses.setLabel(guess);
		addPart(Hangman.guessesLeft);
	}
	
	private void addPart(int i) {
		switch(i) {
		case 7: add(head);
				break;
		case 6: add(body);
				break;
		case 5: add(left_upper_arm);
				add(left_lower_arm);
				break;
		case 4: add(right_upper_arm);
				add(right_lower_arm);
				break;
		case 3: add(left_hip);
				add(left_leg);
				break;
		case 2: add(right_hip);
				add(right_leg);
				break;
		case 1: add(left_foot);
				break;
		case 0: add(right_foot);
				break;
		}
	}
	
	private GLine scaffold, beam, rope;
	private GOval head;
	private GLine body;
	private GLine left_upper_arm, right_upper_arm;
	private GLine left_lower_arm, right_lower_arm;
	private GLine left_hip, right_hip;
	private GLine left_leg, right_leg;
	private GLine left_foot, right_foot;
	
	private GLabel dispWord;
	private GLabel incorrectGuesses;
	
	private String guess = "";

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
