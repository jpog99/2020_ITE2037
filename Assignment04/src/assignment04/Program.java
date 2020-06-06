package assignment04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		DictionaryArray dict = new DictionaryArray();
		Scanner kb = new Scanner(System.in);
		do {
			System.out.println("\n====================MAIN MENU=================");
			System.out.println("(1) Add a word to dictionary.");
			System.out.println("(2) Show definition of word.");
			System.out.println("(3) Show word list.");
			System.out.println("(4) Remove word.");
			System.out.println("(5) Print all contents.");
			System.out.println("(6) Exit program.");
			System.out.println("=====================================");
			System.out.print("Choose a menu: ");
			int menu = kb.nextInt();
			switch(menu) {
			case 1:
				try {
					kb.nextLine();
					System.out.print("Enter the new word: ");
					String word = kb.nextLine();
					System.out.print("Enter the definition: ");
					String definition = kb.nextLine();
					dict.insertEntry(word, definition);
					System.out.println("New word added successfully!");
				}catch(AlreadyExistsInDictException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				try {
					kb.nextLine();
					System.out.print("Word for searching: ");
					String word = kb.nextLine();
					dict.getDefinition(word);
				}catch(EmptyException e) {
					System.out.println(e.getMessage());
				}catch(NotInDicException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				try {
					dict.printWords();
				}catch(EmptyException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:
				try {
					kb.nextLine();
					System.out.print("Word to remove: ");
					String word = kb.nextLine();
					dict.removeWord(word);
					System.out.println("\"" + word + "\" successfully removed from dictionary!");
				}catch(EmptyException e) {
					System.out.println(e.getMessage());
				}catch(NotInDicException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:
				try {
					dict.printAll();
				}catch (EmptyException e){
					System.out.println(e.getMessage());
				}
				break;
				
			case 6:
				try {
					kb.nextLine();
					System.out.println("Enter a file name: ");
					String filename = kb.nextLine();
					PrintWriter writer = new PrintWriter(new FileOutputStream(filename));
					writer.print(dict.getDictList());
					System.out.println("Successfully saved as " + filename + "!");
					writer.close();
				}catch(FileNotFoundException e){
					System.out.println("Error saving to file!");
				}
				
				System.out.println("Exiting Program...");
				System.exit(0);
				break;
				
			default:
				System.out.println("Insert 1~6");
			}
				
			
		}while(true);
	}
	
}
