package assignment03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ElectionSim {

	private String outputFile;
	private int population;
	private Candidate[] candidates;
	private Region[] regions;
	
	public ElectionSim(String inputFile, String outputFile) {
		this.outputFile = outputFile;
		
		try {
			Scanner inputStream = new Scanner(new FileInputStream(inputFile));
			int idx = 0;
			while(inputStream.hasNext()) {
				String token = inputStream.next();
				if(token.equals("POPULATION")) {
					population = inputStream.nextInt();
				}
				else if(token.equals("CANDIDATES")) {
					int candidateNum = inputStream.nextInt();
					candidates = new Candidate[candidateNum];
				}
				else if(token.equals("REGIONS")) {
					int regionsize = inputStream.nextInt();
					regions = new Region[regionsize];
					for(int i=0 ; i<regions.length ; i++) 
						regions[i] = new Region(new String(inputStream.next()), new Integer(inputStream.nextInt()), new Integer(inputStream.nextInt()), candidates);	
				}else {
						candidates[idx] = new Candidate(token, population);
						idx++;
				}
			}
			inputStream.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(0);
		}
	}
	
	public void saveData() {
		Arrays.sort(candidates);
		
		PrintWriter writer = null;
		try{
			writer = new PrintWriter(new FileOutputStream(outputFile));
			
			for(int i=0 ; i<candidates.length ; i++) {
				writer.println(candidates[i]);
				for(int j=1 ; j<=5 ; j++)
					writer.println(regions[j-1].getRegionName() + ": " +candidates[i].toRegionString(j));
				
				writer.println("\n=========================================");
			}
		}catch(IOException e) {
			System.out.println("Error writing to file!");
		}
		
		writer.close();

	}
	
	public void runSimulation() throws InterruptedException{
		for(int i=0 ; i<regions.length ; i++) {
			regions[i].start();
			regions[i].join();
		}
		saveData();
	}
}
