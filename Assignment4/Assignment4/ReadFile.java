import java.io.*;
import acm.program.*;
import acm.util.*;

public class ReadFile extends ConsoleProgram {
	
	public void run() {
		BufferedReader rd = openFile("Enter filename to read: ");
		try {
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				println("Read line: [" + line + "]");
			}
			rd.close();
		} catch(IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private BufferedReader openFile(String prompt) {
		BufferedReader rd = null;
		while(rd == null) {
			try {
				String filename = readLine(prompt);
				rd = new BufferedReader(new FileReader(filename));
			} catch(IOException ex) {
				println("File Not Found");
			}
		}
		return rd;
	}

}
