package beans;

public class ShoppingCart {
	
	private String id;
	private ArrayList<Chocolate> chocolate;
	private User user;
	private double price;
	
	public ShoppingCart() {
		
	}
	
	public ShoppingCart(String id, User user, double price) {
		this.id=id;
		this.user = user;
		this.price = price;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
