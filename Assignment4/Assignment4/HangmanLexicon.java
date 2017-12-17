/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.*;
import java.util.*;


public class HangmanLexicon {
	
	public HangmanLexicon() {
		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
		} catch(IOException e) {}
		strList = new ArrayList<String>();
		readWordsIntoArray(rd);
	}
	
	private void readWordsIntoArray(BufferedReader rd) {
		String word = "";
		while(true) {
			try {
				word = rd.readLine();
			} catch(IOException e) {}
			if(word == null) break;
			strList.add(word);
		}
	}

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return strList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return strList.get(index);
	}
	
	private ArrayList<String> strList;
}
