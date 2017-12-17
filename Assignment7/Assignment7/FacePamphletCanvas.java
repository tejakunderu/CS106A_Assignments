/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	public FacePamphletCanvas() {
		
	}

	public void showMessage(String msg) {
		GLabel message = new GLabel(msg);
		message.setFont(MESSAGE_FONT);
		double x = getWidth() / 2 - message.getWidth() / 2;
		double y = getHeight() - BOTTOM_MESSAGE_MARGIN;
		add(message, x, y);
	}
	
	public void displayProfile(FacePamphletProfile profile) {
		removeAll();
		if(profile != null) {
			addName(profile.getName());
			addPicture(profile.getImage());
			addStatus(profile.getName(), profile.getStatus());
			addFriends(profile.getFriends());
		}
	}
	
	private void addName(String name) {
		GLabel label = new GLabel(name);
		label.setColor(Color.BLUE);
		label.setFont(PROFILE_NAME_FONT);
		nameHeight = label.getAscent();
		vMargin = TOP_MARGIN + label.getAscent();
		label.setLocation(LEFT_MARGIN, vMargin);
		add(label);
	}
	
	private void addPicture(GImage image) {
		vMargin += IMAGE_MARGIN;
		if(image != null) {
			image.setBounds(LEFT_MARGIN, vMargin, IMAGE_WIDTH, IMAGE_HEIGHT);
			add(image);
		} else {
			GRect rect = new GRect(IMAGE_WIDTH, IMAGE_HEIGHT);
			rect.setLocation(LEFT_MARGIN, vMargin);
			add(rect);
			
			GLabel label = new GLabel("No Image");
			label.setFont(PROFILE_IMAGE_FONT);
			double x = LEFT_MARGIN + IMAGE_WIDTH / 2 - label.getWidth() / 2;
			double y = vMargin + IMAGE_HEIGHT / 2 + label.getAscent() / 2;
			label.setLocation(x, y);
			add(label);
		}
	}
	
	private void addStatus(String name, String status) {
		vMargin += STATUS_MARGIN + IMAGE_HEIGHT;
		GLabel label = new GLabel("");
		label .setFont(PROFILE_STATUS_FONT);
		label.setLocation(LEFT_MARGIN, vMargin + label.getAscent());
		add(label);
		if(!status.equals("")) {
			label.setLabel(name + " is " + status);
		} else {
			label.setLabel("No current status");
		}
	}
	
	private void addFriends(Iterator<String> it) {
		GLabel friends = new GLabel("Friends:");
		friends.setFont(PROFILE_FRIEND_LABEL_FONT);
		double x = getWidth() / 2;
		double y = TOP_MARGIN + nameHeight + IMAGE_MARGIN;
		friends.setLocation(x, y);
		add(friends);
		
		if(it != null) {
			for(int i = 0; it.hasNext(); i++) {
				GLabel label = new GLabel(it.next());
				label.setFont(PROFILE_FRIEND_FONT);
				label.setLocation(x, y + (i + 1) * label.getHeight());
				add(label);
			}
		}
	}

	private double nameHeight;
	private double vMargin;
}
