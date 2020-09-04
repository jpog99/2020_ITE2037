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
			int i = 0;
			int j = 0;
			while(inputStream.hasNextLine()) {
				String line = inputStream.nextLine(); //line == seoul 1 1500
				if(line.equals("POPULATION 4300")) {
					String num = line.substring(11);
					population = Integer.parseInt(num);
					continue;
				}
				if(line.equals("CANDIDATES 8")) {
					String cand = line.substring(11);
					candidates = new Candidate[Integer.parseInt(cand)];
					continue;
				}
				
				if(i<candidates.length) {
					candidates[i] = new Candidate(line, population);
					i++;
					continue;
				}
				
				if(line.equals("REGIONS 5")) {
					String regionSize = line.substring(8);
					regions = new Region[Integer.parseInt(regionSize)];
					continue;
				}
				
				if(j<regions.length) {
					if(j==0) regions[j] = new Region( line.substring(0,5), Integer.parseInt(line.substring(6,7)), Integer.parseInt(line.substring(8)), candidates);
					if(j==1) regions[j] = new Region( line.substring(0,5), Integer.parseInt(line.substring(6,7)), Integer.parseInt(line.substring(8)), candidates);
					if(j==2) regions[j] = new Region( line.substring(0,7), Integer.parseInt(line.substring(8,9)), Integer.parseInt(line.substring(10)), candidates);
					if(j==3) regions[j] = new Region( line.substring(0,7), Integer.parseInt(line.substring(8,9)), Integer.parseInt(line.substring(10)), candidates);
					if(j==4) regions[j] = new Region( line.substring(0,5), Integer.parseInt(line.substring(6,7)), Integer.parseInt(line.substring(8)), candidates);
					
					j++;
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
        try {
            writer = new PrintWriter(new FileOutputStream(outputFile));
            for(int i=0 ; i<candidates.length ; i++) {
                writer.println(candidates[i]);
                for(int j=0 ; j<regions.length ; j++)
                    writer.println(regions[j].getRegionName() + ": " + candidates[i].toRegionString(j+1));
            }
            writer.close();
        }catch (IOException e) {
            System.out.println("Error");
        }
        }
	
	public void runSimulation() throws InterruptedException{
		for(Region r:regions) {
			r.start();
			r.join();
		}
		saveData();
	}
}
