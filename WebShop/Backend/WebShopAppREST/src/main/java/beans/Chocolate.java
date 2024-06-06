package beans;

public class Chocolate {

	private String id;
	private String name;
	private double price;
	private String species;
	private String factoryId;
	private String type;
	private double weight;
	private String description;
	private String image;
	private String status;
	private int quantity;

	public Chocolate() {
		this.quantity=0;
	}
	
	public Chocolate(String id, String name, double price, String species, String factory, String type, double weight, String description, String image, String status, int quantity) {
		this.id=id;
		this.name = name;
		this.price = price;
		this.species = species;
		this.factoryId = factory;
		this.type = type;
		this.weight = weight;
		this.description = description;
		this.image = image;
		this.status = status;
		this.quantity = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
