package selfTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class HasNextLineDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		
		try {
			inputStream = new Scanner(new FileInputStream("resource\\BladeRunner.txt"));
			outputStream = new PrintWriter(new FileOutputStream("resource\\NumberedRunner.txt"));
			
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			System.exit(0);
		}
		
		int i=1;
		String line=null;
		while(inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			outputStream.println(i + " " + line);
			i++;
		}
		inputStream.close();
		outputStream.close();
	}

}
