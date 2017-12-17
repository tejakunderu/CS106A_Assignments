import acm.program.*;
import java.util.*;
import java.io.*;
import acm.util.*;

public class FlightPlanner extends ConsoleProgram {
	
	public void run() {
		setup();
		planStartingCity();
		planRoundTrip();
		printRoute();
	}
	
	private void setup() {
		data = new FlightData("flights.txt");
		cities = data.getCities();
		println("Welcome to Flight Planner!");
		println("Here's a list of all the cities in our database: ");
		for(String city: cities)
			println(" " + city);
	}
	
	private void planStartingCity() {
		println("Let's plan a round-trip route!");
		roundTrip = new ArrayList<String>();
		startingCity = readStartingCityFromUser("Enter the starting city: ");
		roundTrip.add(startingCity);
	}
	
	private String readStartingCityFromUser(String prompt) {
		String str = readLine(prompt);
		while(!cities.contains(str))
			str = readLine("Invalid city! " + prompt);
		return str;
	}
	
	private String readCityFromUser(String prompt, String city) {
		String str = readLine(prompt);
		ArrayList<String> destinations = data.getDestinationsForCity(city);
		while(true) {
			if(!cities.contains(str)) 
				str = readLine("Invalid city! " + prompt);
			else if(!destinations.contains(str)) {
				println("Can't go to " + str + " from " + city);
				str = readLine(prompt);
			} else break;
		}
		return str;
	}
	
	private void planRoundTrip() {
		println("From " + startingCity + " you can fly directly to: ");
		for(String city: data.getDestinationsForCity(startingCity))
			println(city);
		String currentCity = readCityFromUser("Where do you want to go from " + startingCity + "? ", startingCity);
		while(true) {
			roundTrip.add(currentCity);
			println("From " + currentCity + " you can fly directly to: ");
			for(String city: data.getDestinationsForCity(currentCity))
				println(city);
			currentCity = readCityFromUser("Where do you want to go from " + currentCity + "? ", currentCity);
			if(currentCity.equals(startingCity))
				break;
		}
	}
	
	private void printRoute() {
		println("The route you've chosen is: ");
		String str = "";
		for(String city: roundTrip)
			str += city + " -> ";
		str += startingCity;
		println(str);
	}
	
	private FlightData data;
	private String startingCity;
	private ArrayList<String> roundTrip;
	private ArrayList<String> cities;
	
}
