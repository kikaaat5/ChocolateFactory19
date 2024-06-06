package beans;

public class Shopping {
	
	private String id;
	//private List<Chocolate> chocolate;
	private Factory factory;
	private DateTime date;
	private double price;
	private User user;
	private ShoppingStatus status;
	
	public Shopiing() {
		
	}
	
	public Shopping(String id, Factory factory, DateTime date, double price, User user, ShoppingStatus status) {
		this.id=id;
		this.factory=factory;
		this.date=date;
		this.price=price;
		this.user=user;
		this.status=status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ShoppingStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingStatus status) {
		this.status = status;
	}
	
	
}
