
public class Student {
	
	public Student(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return ID;
	}
	
	public double getUnits() {
		return unitsTaken;
	}
	
	public void setUnits(double units) {
		unitsTaken = units;
	}
	
	public void addUnits(int x) {
		unitsTaken += x;
	}
	
	public boolean canGraduate() {
		return unitsTaken>=UNITS_TO_GRADUATE;
	}
	
	public String toString() {
		return name+"(#"+ID+")";
	}
	
	public static final double UNITS_TO_GRADUATE = 180;
	
	private String name;
	private int ID;
	private double unitsTaken;
}
