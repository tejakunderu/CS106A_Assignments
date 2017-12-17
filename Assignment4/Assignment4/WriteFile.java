import acm.util.*;
import acm.program.*;
import java.io.*;

public class WriteFile extends ConsoleProgram {
	
	public void run() {
		BufferedReader rd = openFile("Enter filename to read: ");
		try {
			PrintWriter write = new PrintWriter(new FileWriter("copy.txt"));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				println("Read line: [" + line + "]");
				write.println(line);
			}
			rd.close();
			write.close();
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
