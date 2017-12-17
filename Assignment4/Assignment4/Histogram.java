import acm.program.*;
import java.io.*;
import acm.util.*;

public class Histogram extends ConsoleProgram {
	
	private static final int NUM_STUDENTS = 50;
	
	public void run() {
		addScoresToFile();
		readScores();
		printHistogram();
	}
	
	private void addScoresToFile() {
		PrintWriter write = null;
		try {
			write = new PrintWriter(new FileWriter("MidtermScores.txt"));
		} catch(IOException ex) {
			throw new ErrorException(ex);
		}
		for(int i = 0; i < NUM_STUDENTS; i++) {
			int score = rand.nextInt(0, 100);
			write.println(score);
		}
		write.close();
	}
	
	private void readScores() {
		BufferedReader rd = null;
		
		try {
			rd = new BufferedReader(new FileReader("MidtermScores.txt"));
			while(true) {
				String str = rd.readLine();
				if(str == null) break;
				int score = convertScoreToInt(str);
				categorizeScore(score);
			}
		} catch(IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private int convertScoreToInt(String str) {
		int score = 0;
		while(true) {
			String temp = "" + score;
			if(str.equals(temp)) break;
			score ++;
		}
		return score;
	}
	
	private void categorizeScore(int score) {
		histogram[score / 10] ++;
	}
	
	private void printHistogram() {
		println("00 - 09: " + getStars(histogram[0]));
		println("10 - 19: " + getStars(histogram[1]));
		println("20 - 29: " + getStars(histogram[2]));
		println("30 - 39: " + getStars(histogram[3]));
		println("40 - 49: " + getStars(histogram[4]));
		println("50 - 59: " + getStars(histogram[5]));
		println("60 - 69: " + getStars(histogram[6]));
		println("70 - 79: " + getStars(histogram[7]));
		println("80 - 89: " + getStars(histogram[8]));
		println("90 - 99: " + getStars(histogram[9]));
		println("    100: " + getStars(histogram[10]));
	}
	
	private String getStars(int count) {
		String stars = "";
		for(int i = 0; i < count; i++)
			stars += "*";
		return stars;
	}

	private RandomGenerator rand = RandomGenerator.getInstance();
	private int[] histogram = new int[11];
}
