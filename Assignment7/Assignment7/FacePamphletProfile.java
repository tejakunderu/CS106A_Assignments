/*
 * File: FacePamphletProfile.java
 * ------------------------------
 * This class keeps track of all the information for one profile
 * in the FacePamphlet social network.  Each profile contains a
 * name, an image (which may not always be set), a status (what 
 * the person is currently doing, which may not always be set),
 * and a list of friends.
 */

import acm.graphics.*;
import java.util.*;

public class FacePamphletProfile implements FacePamphletConstants {
	
	public FacePamphletProfile(String name) {
		this.name = name;
		profilePicture = null;
		status = "";
		friends = new ArrayList<String>();
	}
 
	public String getName() {
		return name;
	}

	public GImage getImage() {
		return profilePicture;
	}

	public void setImage(GImage image) {
		profilePicture = image;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public boolean addFriend(String friend) {
		if(!friends.contains(friend)) {
			friends.add(friend);
			return true;
		} else return false; 
	}

	public boolean removeFriend(String friend) {
		if(friends.contains(friend)) {
			friends.remove(friend);
			return true;
		} else return false;
	}

	public Iterator<String> getFriends() {
		if(friends.size() == 0)
			return null;
		else return friends.iterator();
	}
	
	public String toString() {
		String str = "" + name 
					+ " (" + status
					+ "): ";
		int size = friends.size();
		if(size != 0) {
			str += friends.get(0);
			for(int i = 1; i < size; i++)
				str += ", " + friends.get(i);
		}
		return str;
	}
	
	private String name;
	private GImage profilePicture;
	private String status;
	private ArrayList<String> friends;
}
