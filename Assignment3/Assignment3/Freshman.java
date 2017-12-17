
public class Freshman extends Student {
	
	public Freshman(String name, int ID) {
		super(name, ID);
		setUnits(0);
	}
	
	public String toString() {
		return ("Freshman: " + getName() + "(#" + getID() + ")");
	}
	
}
