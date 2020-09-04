package selftest;

public class Project01_1 {
	public static void main(String[] args) {
		
		int counter = 3;
		int totalDistance = 15;
		
		int quotient = totalDistance / counter;
		int remainder = totalDistance % counter;
			
		System.out.println("Quotient of totalDistance / counter: " + quotient);
		System.out.println("Remainder of totalDistance / counter: " + remainder);
	}
}
