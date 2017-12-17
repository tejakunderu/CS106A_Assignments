import java.util.*;

public class Album {
	
	public Album(String albumName, String bandName) {
		album = albumName;
		band = bandName;
	}
	
	public String getAlbumName() {
		return album;
	}
	
	public String getBandName() {
		return band;
	}
	
	public void addSong(Song songName) {
		songs.add(songName);
	}
	
	public Iterator<Song> getSongs() {
		return songs.iterator();
	}
	
	public String toString() {
		return ("\"" + album + "\" by " + band);
	}
	
	private String album;
	private String band;
	private ArrayList<Song> songs = new ArrayList<Song>();;

}
