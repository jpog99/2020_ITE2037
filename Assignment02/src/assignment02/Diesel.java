package assignment02;

public class Diesel extends Oil {
	private int price;
	private double VAT;
	private double envTax;
	
	public Diesel(int price, String company) {
		super(company,"diesel");
		this.price = price;
		VAT = (  (int)(1 + (Math.random()*30))  )/100.0;
		envTax = 500;
		super.setConsumerPrice(price + envTax + price*VAT);
	}
	
	@Override
	public double getOilPrice() {
		return price;
	}
	
	public String toString() {
		return super.toString() + "\nSupply Price: " + price;
	}

}
