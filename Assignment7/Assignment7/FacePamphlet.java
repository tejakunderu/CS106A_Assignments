/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import javax.swing.*;
import acm.util.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {
	
	public static void main(String[] args) {
		new FacePamphlet().start(args);
	}

	public void init() {
		initializeInterators();
		addActionListeners();
		currentProfile = null;
		data = new FacePamphletDatabase();
		canvas = new FacePamphletCanvas();
		add(canvas);
    }
	
	private void initializeInterators() {
		initializeNorthBorder();
		initializeWestBorder();
	}
	
	private void initializeNorthBorder() {
		add(new JLabel("Name "), NORTH);
		
		nameField = new JTextField(TEXT_FIELD_SIZE);
		add(nameField, NORTH);
		
		add(new JButton("Add"), NORTH);
		add(new JButton("Delete"), NORTH);
		add(new JButton("Lookup"), NORTH);
	}
	
	private void initializeWestBorder() {
		changeStatus = new JTextField(TEXT_FIELD_SIZE);
		add(changeStatus, WEST);
		changeStatus.setActionCommand("Change Status");
		changeStatus.addActionListener(this);
		
		add(new JButton("Change Status"), WEST);
		
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		
		changePicture = new JTextField(TEXT_FIELD_SIZE);
		add(changePicture, WEST);
		changePicture.setActionCommand("Change Picture");
		changePicture.addActionListener(this);
		
		add(new JButton("Change Picture"), WEST);
		
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		
		addFriend = new JTextField(TEXT_FIELD_SIZE);
		add(addFriend, WEST);
		addFriend.setActionCommand("Add Friend");
		addFriend.addActionListener(this);
		
		add(new JButton("Add Friend"), WEST);
	}
    
    public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		executeActionCommand(cmd);
	}
    
    private void executeActionCommand(String cmd) {
    	String name = nameField.getText().trim();
		String status = changeStatus.getText().trim();
		String picture = changePicture.getText().trim();
		String friend = addFriend.getText().trim();
		switch(cmd) {
		case "Add":
			if(!name.equals(""))
				addProfile(name);
			nameField.setText("");
			break;
		case "Delete":
			if(!name.equals(""))
				deleteProfile(name);
			nameField.setText("");
			break;
		case "Lookup":
			if(!name.equals(""))
				lookupProfile(name);
			nameField.setText("");
			break;
		case "Change Status":
			if(!status.equals(""))
				changeProfileStatus(status);
			changeStatus.setText("");
			break;
		case "Change Picture":
			if(!picture.equals(""))
				changeProfilePicture(picture);
			changePicture.setText("");
			break;
		case "Add Friend":
			if(!friend.equals(""))
				addFriend(friend);
			addFriend.setText("");
			break;
		default:
		}
    }
    
    private void addProfile(String name) {
    	if(data.containsProfile(name)) {
    		currentProfile = data.getProfile(name);
        	canvas.displayProfile(currentProfile);
    		canvas.showMessage("A profile with the name " + name + " already exists");
    	} else {
    		FacePamphletProfile newProfile = new FacePamphletProfile(name);
    		data.addProfile(newProfile);
    		currentProfile = newProfile;
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("New profile created");
    	}
    }
    
    private void deleteProfile(String name) {
    	currentProfile = null;
    	canvas.displayProfile(currentProfile);
    	if(data.containsProfile(name)) {
    		data.deleteProfile(name);
    		canvas.showMessage("Profile of " + name + " deleted");
    	} else {
    		canvas.showMessage("A profile with the name " + name + " does not exist");
    	}
    }
    
    private void lookupProfile(String name) {
    	if(data.containsProfile(name)) {
    		currentProfile = data.getProfile(name);
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("Displaying " + name);
    	} else {
    		currentProfile = null;
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("A profile with the name " + name + " does not exist");
    	}
    }
    
    private void changeProfileStatus(String status) {
    	if(currentProfile != null) {
    		currentProfile.setStatus(status);
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage("Status updated to " + status);
    	} else {
    		canvas.displayProfile(null);
    		canvas.showMessage("Please select a profile to change status");
    	}
    }
    
    private void changeProfilePicture(String picture) {
    	if(currentProfile != null) {
    		GImage img = null;
    		try {
    			img = new GImage(picture);
    		} catch (ErrorException ex) {
    			canvas.displayProfile(currentProfile);
    			canvas.showMessage("Unable to open image file: " + picture);
    		}
    		if(img != null) {
    			currentProfile.setImage(img);
    			canvas.displayProfile(currentProfile);
    			canvas.showMessage("Picture updated");
    		}
    	} else {
    		canvas.displayProfile(null);
    		canvas.showMessage("Please select a profile to change picture");
    	}
    }
    
    private void addFriend(String friend) {
    	if(currentProfile != null) {
    		addIfProfileExists(friend);
    	} else {
    		canvas.displayProfile(null);
    		canvas.showMessage("Please select a profile to add friend");
    	}
    }
    
    private void addIfProfileExists(String friend) {
    	if(data.containsProfile(friend)) {
    		if(currentProfile.addFriend(friend)) {
    			canvas.displayProfile(currentProfile);
    			canvas.showMessage(friend + " added as a friend");
    			updateFriendProfile(friend);
    		} else {
    			canvas.displayProfile(currentProfile);
    			canvas.showMessage(currentProfile.getName() 
    								+ " already has " + friend 
    								+ " as a friend");
    		}
    	} else {
    		canvas.displayProfile(currentProfile);
    		canvas.showMessage(friend + " does not exist");
    	}
    }
    
    private void updateFriendProfile(String friend) {
    	String name = currentProfile.getName();
    	data.getProfile(friend).addFriend(name);
    }

    private JTextField nameField;
    private JTextField changeStatus;
    private JTextField changePicture;
    private JTextField addFriend;
    private FacePamphletProfile currentProfile;
    private FacePamphletDatabase data;
    private FacePamphletCanvas canvas;
}
