/*
 * File: FacePamphletDatabase.java
 * -------------------------------
 * This class keeps track of the profiles of all users in the
 * FacePamphlet application.  Note that profile names are case
 * sensitive, so that "ALICE" and "alice" are NOT the same name.
 */

import java.util.*;

public class FacePamphletDatabase implements FacePamphletConstants {

	public FacePamphletDatabase() {
		profiles = new HashMap<String, FacePamphletProfile>();
	}
	
	public void addProfile(FacePamphletProfile profile) {
		String name = profile.getName();
		profiles.put(name, profile);
	}

	public FacePamphletProfile getProfile(String name) {
		return profiles.get(name);
	}
	
	public void deleteProfile(String name) {
		FacePamphletProfile currentProfile = profiles.get(name);
		profiles.remove(name);
		updateOtherProfiles(name, currentProfile); 
	}
	
	private void updateOtherProfiles(String name, FacePamphletProfile currentProfile) {
		Iterator<String> it = currentProfile.getFriends();
		if(it != null) {
			while(it.hasNext())
				profiles.get(it.next()).removeFriend(name);
		}
	}

	public boolean containsProfile(String name) {
		if(profiles.keySet().contains(name))
			return true;
		else return false;
	}

	private HashMap<String, FacePamphletProfile> profiles;
	
}
