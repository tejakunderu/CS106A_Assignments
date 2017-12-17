/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

	public NameSurferEntry(String line) {
		name = "";
		decade = new int[NDECADES];
		readLineUsingTokenizer(line);
	}
	
	private void readLineUsingTokenizer(String line) {
		StringTokenizer tk = new StringTokenizer(line);
		for(int i = -1; tk.hasMoreTokens(); i++) {
			if(i == -1)
				name = tk.nextToken();
			else decade[i] = Integer.parseInt(tk.nextToken());
		}
	}

	public String getName() {
		return name;
	}

	public int getRank(int decade) {
		return this.decade[(decade - START_DECADE )/ 10];
	}

	public String toString() {
		String str = "";
		str += name + " [ ";
		for(int i = 0; i < decade.length; i++)
			str += decade[i] + " ";
		str += "]";
		return str;
	}
	
	private String name;
	private int[] decade;
}

