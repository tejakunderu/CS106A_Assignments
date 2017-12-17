import java.util.*;
import java.io.*;
import acm.util.*;

public class MusicDataBase {
	
	public MusicDataBase(String filename) {
		map = new HashMap<String, Album>();
		readDataFromFile(filename);
	}
	
	private void readDataFromFile(String filename) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				readDataFromLine(line);
			}
			rd.close();
		} catch(IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private void readDataFromLine(String line) {
		String album = "";
		String band = "";
		int copies = 0;
		
		int albumStart = line.indexOf("[") + 1;
		int albumEnd = line.indexOf("]");
		album = line.substring(albumStart, albumEnd);
		
		int bandStart = line.indexOf("[", albumEnd + 1) + 1;
		int bandEnd = line.indexOf("]", albumEnd + 1);
		band = line.substring(bandStart, bandEnd);
		line = line.substring(bandEnd + 2); 
		
		copies = Integer.parseInt(line);
		
		Album currentAlbum = new Album(album, band, copies);
		map.put(album.toLowerCase(), currentAlbum);
	}
	
	public Album getAlbumFromName(String album) {
		return map.get(album);
	}

	private HashMap<String, Album> map;
}
