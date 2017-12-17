import acm.program.*;
import java.io.*;
import java.util.*;

public class WordCount extends ConsoleProgram {
	
	public void run() {
		readFile("File: ");
		countContents();
		println("Lines = " + lines);
		println("Words = " + words);
		println("Characters = " + characters);
	}
	
	private void readFile(String prompt) {
		rd = null;
		String filename = readLine(prompt);
		while(rd == null) {
			try {
				rd = new BufferedReader(new FileReader(filename));
			} catch(IOException e) {
				println("File not found");
				filename = readLine(prompt);
			}
		}
	}
	
	private void countContents() {
		String line = "";
		while(true) {
			try {
				line = rd.readLine();
			} catch(IOException e) {}
			if(line == null) 
				break;
			countWords(line);
			lines ++;
		}
	}
	
	private void countWords(String line) {
		StringTokenizer tk = new StringTokenizer(line);
		while(tk.hasMoreTokens()) {
			words ++;
			countCharacters(tk.nextToken());
		}
	}
	
	private void countCharacters(String word) {
		for(int i = 0; i < word.length(); i++) {
			if(Character.isLetterOrDigit(word.charAt(i))) 
				characters ++;
		}
	}
	
	private BufferedReader rd = null;
	private int lines = 0;
	private int words = 0;
	private int characters = 0;
}
