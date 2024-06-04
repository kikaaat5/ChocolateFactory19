package beans;

public class TypeOfCustomer {
	private Type type;
	private double discount;
	private int Points;
	
	public TypeOfCustomer(Type type, double discount, int points) {
		super();
		this.type = type;
		this.discount = discount;
		Points = points;
	}
	public TypeOfCustomer() {
		// TODO Auto-generated constructor stub
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getPoints() {
		return Points;
	}
	public void setPoints(int points) {
		Points = points;
	}
	

}
