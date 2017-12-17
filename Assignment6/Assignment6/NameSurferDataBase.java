/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

import java.util.*;
import java.io.*;
import acm.util.*;

public class NameSurferDataBase implements NameSurferConstants {
	
	public NameSurferDataBase(String filename) {
		nameLog = new HashMap<String, NameSurferEntry>();
		readFileUsingBufferedReader(filename);
	}
	
	private void readFileUsingBufferedReader(String filename) {
		String str = "";
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while(true) {
				str = rd.readLine();
				if(str == null) break;
				addEntryToDataBase(str);
			}
			rd.close();
		} catch(IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private void addEntryToDataBase(String str) {
		NameSurferEntry entry = new NameSurferEntry(str);
		String name = entry.getName();
		nameLog.put(name.toLowerCase(), entry);
	}
	
	public NameSurferEntry findEntry(String name) {
		return nameLog.get(name.toLowerCase());
	}
	
	private HashMap<String, NameSurferEntry> nameLog;

}

