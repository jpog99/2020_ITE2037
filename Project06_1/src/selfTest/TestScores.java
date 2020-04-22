package selfTest;
import java.util.Scanner;

public class TestScores {
	public static final int MAX_NUMBER_SCORES = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] scores = new double[MAX_NUMBER_SCORES];
		int counting = 0;
		
		System.out.println("This program reads test scores and shows");
		System.out.println("how much each differs from the average.");
		System.out.println("Enter test scores:");
		
		counting = fillArray(scores);
		showDifference(scores, counting);
		
	}

	public static int fillArray(double[] a)
	{
		System.out.println("Mark the end of the list with a negative number.");	
		Scanner kb = new Scanner(System.in);
		int i = 0;
		for(i=0 ; i<a.length ; i++) {
			double input = kb.nextDouble();
			if(input >= 0) 
				a[i] = input;
			else break;
		}
		
		return i;
	}
	
	public static void showDifference(double[] a, int count)
	{
		double average = computeAverage(a, count);
		
		System.out.println("Average of the scores = " + average);
		System.out.println("The scores are: ");
		
		for(int i=0 ; i<count ; i++) 
			System.out.println(a[i] + " differs from average by "+ (a[i]-average));
		
	}
	
	public static double computeAverage(double[] a, int count)
	{	
		double total=0;
		for (int i=0 ; i<count ; i++) 
			total += a[i];
		
		if(count>0)
			return total/count;
		else {
			System.out.println("error");
			return 0;
		}
	}
}
