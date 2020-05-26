package assignment02;

import java.util.Scanner;

public class PriceListApp {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		PriceList pricelist = new PriceList();
		int regionCount=0;
		
		do {
			System.out.println("\n============= MAIN MENU =============");
			System.out.println("(1) Add a oil to price  list.");
			System.out.println("(2) View Region Information.");
			System.out.println("(3) Print the entire price list.");
			System.out.println("(4) Exit the program.");
			System.out.println("=====================================");
			System.out.print("\nChoose a menu: ");
			
			int choice = kb.nextInt();
		
			switch(choice) {
			 	case 1:
			 		try {
			 			if ( regionCount>=pricelist.getVertical() )
			 				throw new FullArrayException();
			 		}catch (FullArrayException e) {
			 			System.out.println(e.getMessage());
			 			int expand = kb.nextInt();
			 			pricelist.extendList(expand);
			 			System.out.println("List is extended!\n");
			 		}
			 		
			 		for (int i=0 ; i<2 ; i++) {
					 	System.out.print("Company: ");
					 	String company = kb.next();
					 	System.out.print("Supply Price: ");
					 	int price = kb.nextInt();
					 		
					 	if(i==0) {
					 		Gasoline gasoline = new Gasoline(price, company);
					 		pricelist.setPriceList(regionCount, i, gasoline);
					 		System.out.println("Gasoline added!\n");
					 	}
					 	else{
					 		Diesel diesel = new Diesel(price, company);
					 		pricelist.setPriceList(regionCount, i, diesel);
					 		System.out.println("Diesel added!");
					 	}
			 		}
			 		regionCount++;
			 		break;
			 		
			 	case 2:
			 		System.out.print("Region number to view: ");
			 		int region = kb.nextInt();
			 		
			 		if(region <= regionCount) {
			 			System.out.println("\n--------- REGION #" + region + " ---------");
				 		System.out.println(pricelist.getRegionInfo(region-1));
				 		System.out.println("--------------------------------");
			 		}else
			 			System.out.println("Out of index!");
			 		break;
			 	
			 	case 3:
			 		pricelist.printList();
			 		break;
			 	
			 	case 4:
			 		System.out.println("Exit application");
			 		System.exit(0);
			 		break;
			 	
			 	default:
			 		System.out.println("Insert 1 ~ 4 ");
			}
		}while(true);
	}
}
