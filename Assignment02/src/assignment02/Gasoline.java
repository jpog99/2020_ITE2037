package assignment02;

public class Gasoline extends Oil {

	private int price;
	private double VAT;
	
	public Gasoline(int price, String company) {
		super(company,"gasoline");
		this.price = price;
		VAT =( (int)(1 + (Math.random()*30)) )/100.0;
		super.setConsumerPrice(price+price*VAT);
	}
	
	@Override
	public double getOilPrice() {
		return price;
	}
	
	public String toString() {
		return super.toString() + "\nSupply Price: " + price;
	}
	
}
