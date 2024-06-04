package beans;

public class Address {
	private String street;
	private String number;
	private String city;
	private int postCode;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(String street, String number, String city, int postCode) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.postCode = postCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

}
