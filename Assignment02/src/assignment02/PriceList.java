package assignment02;

public class PriceList {
	private Oil[][] pricelist;
	private int vertical;
	
	public PriceList() {
		vertical = 2;
		pricelist = new Oil[vertical][2];
	}
	
	public int getVertical() {
		return vertical;
	}
	
	public void setPriceList(int i, int j , Oil oil) {
		pricelist[i][j] = oil;
	}
	
	public void extendList(int amount) {
		vertical += amount;
		Oil[][] extendedList = new Oil[vertical][2];
		for(int i=0 ; i<this.pricelist.length ; i++) {
			extendedList[i][0] = this.pricelist[i][0];
			extendedList[i][1] = this.pricelist[i][1];
		}
		
		this.pricelist = extendedList;
	}
	
	public String getRegionInfo(int i) {
		 return pricelist[i][0].toString() + "\n\n" + pricelist[i][1].toString();
	}
	
	public void printList() {
		System.out.println("\t\t Gasoline \t Diesel");
		System.out.println("========================================");
		
		int i=0;
		while(i<vertical) {
			if(pricelist[i][0]==null) break;
			System.out.printf("Region #%d \t %.2f \t %.2f \n", i+1, pricelist[i][0].getConsumerPrice(), pricelist[i][1].getConsumerPrice());
			i++;
		}	
		System.out.println("========================================");
	}
}
