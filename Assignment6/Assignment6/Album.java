
public class Album {

	public Album(String album, String band, int copies) {
		albumName = album;
		bandName = band;
		numCopies = copies;
	}
	
	public String getAlbumName() {
		return albumName;
	}
	
	public String getBandName() {
		return bandName;
	}
	
	public int getNumCopies() {
		return numCopies;
	}
	
	public String toString() {
		return ("\"" + albumName + 
				"\" by " + bandName + 
				": " + numCopies + " in stock"); 
	}
	
	private String albumName;
	private String bandName;
	private int numCopies;
	
}
