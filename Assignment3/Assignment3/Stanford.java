import acm.program.*;

public class Stanford extends ConsoleProgram {
	
		public void run() {
			
			Incrementor ID = new Incrementor(1000);
			
			Student S1 = new Student("Mark", ID.nextValue());
			Student S2 = new Freshman("Dave", ID.nextValue());
			Student S3 = new Student("Matt", ID.nextValue());
			
			S1.setUnits(155.5);
			S3.setUnits(175);
			
			println("Student " + S1.getName() + " has " + S1.getUnits() + " units");
			println("Can graduate? " + S1.canGraduate());
			
			println("\nStudent " + S2.getName() + " has " + S2.getUnits() + " units");
			println("Can graduate? " + S2.canGraduate());
			
			println("\nStudent " + S3.getName() + " has " + S3.getUnits() + " units");
			println("Can graduate? " + S3.canGraduate());
			
			println("\nStudents have taken CS106A!");
			
			S1.addUnits(5); S2.addUnits(5); S3.addUnits(5);
			
			println("\nCan " + S1.getName() + " graduate now? " + S1.canGraduate());
			if (S1.canGraduate()) println("Rock on! " + S1.toString());
			
			println("\nCan " + S2.getName() + " graduate now? " + S2.canGraduate());
			if (S2.canGraduate()) println("Rock on! " + S2.toString());
			
			println("\nCan " + S3.getName() + " graduate now? " + S3.canGraduate());
			if (S3.canGraduate()) println("Rock on! " + S3.toString());	
		}
}
