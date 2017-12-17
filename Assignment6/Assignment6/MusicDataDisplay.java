import acm.graphics.*;
import java.awt.event.*;

public class MusicDataDisplay extends GCanvas implements ComponentListener {
	
	public MusicDataDisplay() {
		addComponentListener(this);
		currentAlbum = null;
	}
	
	public void printAlbumData(Album currentAlbum) {
		this.currentAlbum = currentAlbum;
		update();
	}
	
	public void update() {
		removeAll();
		if(currentAlbum != null) {
			albumName = currentAlbum.getAlbumName();
			bandName = currentAlbum.getBandName();
			numCopies = currentAlbum.getNumCopies();
			displayWordData();
			displayGraphData();
		}
	}
	
	private void displayWordData() {
		String str1 = "Album [" + albumName + "] by [" + bandName + "]";
		String str2 = numCopies + " in stock";
		add(new GLabel(str1, 10, getHeight() / 2));
		add(new GLabel(str2, 10, getHeight() / 2 + getHeight() / 20 + 20));
	}
	
	private void displayGraphData() {
		int width = getWidth() / 30;
		int height = getHeight() / 20;
		for(int i = 0; i < numCopies; i++) {
			GRect rect = new GRect(width, height);
			rect.setFilled(true);
			add(rect, 10 + i * (width + 2), getHeight() / 2 + 5);
		}
	}
	
	public void componentResized(ComponentEvent e) { update();}
	public void componentShown(ComponentEvent e) {}
	public void componentMoved(ComponentEvent e) {}
	public void componentHidden(ComponentEvent e) {}
	
	private Album currentAlbum;
	private String albumName;
	private String bandName;
	private int numCopies;

}
