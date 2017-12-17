import java.util.*;
import java.io.*;
import acm.util.*;

public class FlightData {
	
	public FlightData(String filename) {
		flightData = new HashMap<String, ArrayList<String>>();
		cities = new ArrayList<String>();
		readCitiesFromFile(filename);
	}

	private void readCitiesFromFile(String filename) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while(true) {
				String line = rd.readLine();
				if(line == null)
					break;
				if(line.length() != 0)
					readFlightDataFromLine(line);
			}
		} catch(IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private void readFlightDataFromLine(String line) {
		int index = line.indexOf("-> ");
		if(index == -1)
			throw new ErrorException("Illegal Flight Entry " + line);
		String fromCity = line.substring(0, index).trim();
		String toCity = line.substring(index + 3).trim();
		defineCity(fromCity);
		defineCity(toCity);
		getDestinationsForCity(fromCity).add(toCity);
	}
	
	private void defineCity(String city) {
		if(!cities.contains(city)) {
			cities.add(city);
			flightData.put(city, new ArrayList<String>());
		}
	}
	
	public ArrayList<String> getCities() {
		return cities;
	}
	
	public ArrayList<String> getDestinationsForCity(String city) {
		return flightData.get(city);
	}

	private HashMap<String, ArrayList<String>> flightData;
	private ArrayList<String> cities;
}
