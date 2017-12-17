/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

//import acm.graphics.*;
import acm.program.*;
import acm.util.*;

//import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	public static void main(String[] args) {
		new Hangman().start(args);
	}
	
	//public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 630;
	
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}
	
    public void run() {
		setup();
		while(!gameOver()) {
			println("The word now looks like this: " + dispWord);
			println("You have " + guessesLeft + " guesses left.");
			input = readInput();
			ch = Character.toUpperCase(input.charAt(0));
			dispWord = checkForCharacter(word, currentWord, ch);
			canvas.displayWord(dispWord);
		}
	}
    
    private void setup() {
    	canvas.reset();
    	println("Welcome to Hangman!");
    	int wordCount = hang.getWordCount();
    	word = hang.getWord(rand.nextInt(0, wordCount - 1));
    	for(int i = 0; i < word.length(); i++) {
    		currentWord += "-";
    	}
    	dispWord = createDisplayWord(currentWord);
    }
    
    private String readInput() {
    	String input = "";
    	input = readLine("Your guess: ");
    	while(!inputIsLegal(input)) {
    		println("Input is illegal!");
    		println("Enter an alphabet between A and Z");
    		input = readLine("Your guess: ");
    	}
    	return input;
    }
    
    private boolean inputIsLegal(String input) {
    	if(input.length() != 1) return false;
    	char ch = input.charAt(0);
    	if(!Character.isLetter(ch)) return false;
    	return true;
    }
    
    private String createDisplayWord(String currentWord) {
    	String output = "";
    	for(int i = 0; i < currentWord.length(); i++) output += currentWord.charAt(i) + " ";
    	return output.substring(0, output.length() - 1);
    }
    
    private String checkForCharacter(String word, String currentWord, char ch) {
    	if(word.indexOf(ch) == -1) {
    		println("There are no " + ch + "'s in this word.");
    		guessesLeft--;
    		canvas.noteIncorrectGuess(ch);
    		return dispWord;
    	}
    	if(currentWord.indexOf(ch) != -1) {
    		return dispWord;
    	}
    	
    	String output = "";
    	for(int i = 0; i < word.length(); i++) {
    		if(word.charAt(i) != ch && currentWord.charAt(i) != ch) {
    			output += currentWord.charAt(i);
    		} else {
    			output += ch;
    		}
    	}
    	
    	println("That guess is correct.");
    	this.currentWord = output;
    	return createDisplayWord(output);
    }
    
    private boolean gameOver() {
    	if(word.equals(currentWord)) {
    		println("You guessed the word: " + word);
    		println("You win.");
    		return true;
    	}
    	if(guessesLeft == 0) {
    		println("You're completely hung.");
    		println("The word was " + word);
    		println("You lose.");
    		return true;
    	}
    	return false;
    }
    
    private String word;
    private String dispWord = "";
    private String currentWord = "";
    private String input = "";
    private char ch;
    public static int guessesLeft = 8;
    private HangmanLexicon hang = new HangmanLexicon();
    private RandomGenerator rand = RandomGenerator.getInstance();
    private HangmanCanvas canvas;

}
