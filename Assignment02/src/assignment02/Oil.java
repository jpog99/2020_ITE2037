package assignment02;

public abstract class Oil {
	private String company;
	private String oilType;
	private double consumerPrice;

	public Oil(String company, String oilType) {
		this.company = company;
		this.oilType = oilType;
		consumerPrice = 0;
	}
	
	public double getConsumerPrice() {
		return consumerPrice;
	}
	
	public void setConsumerPrice(double price) {
		this.consumerPrice = price;
	}
	
	public String toString() {
		return "Company: " + company + "\nOil Type: " + oilType;
	}
	
	public abstract double getOilPrice();
}
