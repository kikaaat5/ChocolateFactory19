package beans;

import dao.AddressDAO;

public class Location {

	private int id;
	private double longitude;
	private double latitude;
	private Address address;
	private int addressId;
	
	private AddressDAO addressDAO = new AddressDAO();
	public Location() {
		// TODO Auto-generated constructor stub
	}
	public Location(int id,double longitude, double latitude, int addressId) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.addressId = addressId;
		address = addressDAO.findById(addressId);
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public double getId() {
		return id;
	}

	
	
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

}
