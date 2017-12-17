import acm.program.*;
import java.util.*;

public class MusicShop extends ConsoleProgram {
	
	public void run() {
		setFont("-56");
		println("Welcome to Music Shop!");
		while(!quit) {
			printSelections();
			int selection = readSelectionFromUser();
			implementSelection(selection);
		}
		println("\nSee ya later!");
	}
	
	private void printSelections() {
		println("\nPlease make a selection (0 to quit): ");
		println("1. List all songs");
		println("2. List all albums");
		println("3. Add a song");
		println("4. Add an album");
		println("5. List songs on an album");
		println("6. Update song price");
	}
	
	private int readSelectionFromUser() {
		int selection = 0;
		while(true) {
			selection = readInt("Selection: ");
			if(selection >= 0 && selection < 7)
				break;
			println("Invalid selection!");
		}
		return selection;
	}
	
	private void implementSelection(int selection) {
		switch(selection) { 
		case 0:
			quit = true;
			break;
		case 1:
			listAllSongs();
			break;
		case 2: 
			listAllAlbums();
			break;
		case 3:
			addNewSong();
			break;
		case 4:
			addNewAlbum();
			break;
		case 5: 
			listSongsOnAnAlbum();
			break;
		case 6: 
			updateSongPrice();
			break;
		default: 
		}
	}
	
	private void listAllSongs() {
		println("All songs carried by the store: ");
		for(int i = 0; i < songs.size(); i++)
			println(songs.get(i).toString());
	}
	
	private void listAllAlbums() {
		println("All albums carried by the store: ");
		if(albums.size() > 0) {
			for(String album: albums.keySet())
				println(albums.get(album).toString());
		}
	}
	
	private void addNewSong() {
		String songName = readLine("Song name (Enter to quit): ");
		if(!songName.equals("")) {
			String bandName = readLine("Band name: ");
			if(!songExists(songName, bandName)) {
				double price = readDouble("Price: ");
				Song newSong = new Song(songName, bandName, price);
				songs.add(newSong);
				println("New song added to the store.");
			} else println("That song is already in the store.");
		} 
	}
	
	private boolean songExists(String songName, String bandName) {
		if(songs.size() == 0) 
			return false;
		for(Song currentSong: songs) {
			String title = currentSong.getSongName();
			String band = currentSong.getBandName();
			if (songName.equalsIgnoreCase(title) && bandName.equalsIgnoreCase(band))
				return true;
		}
		return false;
	}
	
	private void addNewAlbum() {
		newAlbum = true;
		String albumName = readLine("Album name: ");
		String bandName = readLine("Band name: ");
		Album currentAlbum = null;
		if(!albums.containsKey(albumName.toLowerCase())) {
			currentAlbum = new Album(albumName, bandName);
			albums.put(albumName.toLowerCase(), currentAlbum);
		} else {
			currentAlbum = albums.get(albumName.toLowerCase());
			newAlbum = false;
		}
		addSongsToAlbum(currentAlbum);
	}
	
	private void addSongsToAlbum(Album currentAlbum) {
		String albumName = currentAlbum.getAlbumName();
		String bandName = currentAlbum.getBandName();
		while(true) {
			String songName = readLine("Song name (Enter to quit): ");
			if(songName.equals(""))
				break;
			if(!songExists(songName, bandName)) {
				double price = readDouble("Price: ");
				Song newSong = new Song(songName, bandName, price);
				songs.add(newSong);
				currentAlbum.addSong(newSong);
				println("New song added to the store.");
				println("Song added to album.");
			} else {
				Song existingSong = getSongFromStore(songName, bandName);
				if(newAlbum) {
					currentAlbum.addSong(existingSong);
					println("That song is already in the store.");
					println("Song added to album.");
				} else if(!songExistsInAlbum(songName, albumName)) {
					currentAlbum.addSong(existingSong);
					println("That song is already in the store.");
					println("Song added to album.");
				} else println("Song is already in the album");
			}
		}
	}
	
	private Song getSongFromStore(String songName, String bandName) {
		Song existingSong = null;
		for(Song currentSong: songs) {
			String title = currentSong.getSongName();
			String band = currentSong.getBandName();
			if (songName.equalsIgnoreCase(title) && bandName.equalsIgnoreCase(band))
				existingSong = currentSong;
		}	
		return existingSong;
	}
	
	private boolean songExistsInAlbum(String songName, String albumName) {
		Album currentAlbum = albums.get(albumName);
		Iterator<Song> songList = currentAlbum.getSongs();
		while(songList.hasNext()) {
			String title = songList.next().getSongName();
			if(songName.equalsIgnoreCase(title))
				return true;
		}
		return false;
	}
	
	private void listSongsOnAnAlbum() {
		String albumName = readLine("Album name: ");
		while(!albums.containsKey(albumName.toLowerCase())) {
			println("No album by that name in the store.");
			albumName = readLine("Album name (Enter to quit): ");
			if(albumName.equals("")) 
				break;
		}
		if(!albumName.equals("")) {
			Album currentAlbum = albums.get(albumName);
			println(albumName + " contains the following songs: ");
			Iterator<Song> songList = currentAlbum.getSongs();
			while(songList.hasNext())
				println(songList.next().toString());
		}
	}
	
	private void updateSongPrice() {
		String songName = readLine("Song name: ");
		String bandName = readLine("Band name: ");
		while(!songExists(songName, bandName)) {
			println("No song by that name in the store.");
			songName = readLine("Song name (Enter to quit): ");
			if(songName.equals("")) 
				break;
			bandName = readLine("Band name: ");
		}
		if(!songName.equals("")) {
			double price = readDouble("New price: ");
			Song currentSong = getSongFromStore(songName, bandName);
			currentSong.setPrice(price);
			println("Price for " + songName + "updated.");
		}
	}
	
	private boolean quit;
	private boolean newAlbum;
	private ArrayList<Song> songs = new ArrayList<Song>();
	private HashMap<String, Album> albums = new HashMap<String, Album>();
}
