package beans;

import java.awt.Image;

import javax.swing.ImageIcon;

import dao.LocationDAO;

public class Factory {


	private String name;
	//private List<Chocolate> chocolate;
	private String workingHours;
	private Status status;
	private Location location;
	private int locationId;
	private String logo;
	private double grade;
	
	private LocationDAO locationDAO = new LocationDAO();
	
	public Factory() {
		// TODO Auto-generated constructor stub
	}

	
	public Factory(String name, String workingHours, Status status, int locationId, String logo, double grade) {
		super();
		this.name = name;
		this.workingHours = workingHours;
		this.status = status;
		this.locationId = locationId;
		this.location = locationDAO.findById(locationId);
		this.logo = logo;
		this.grade = grade;
		
	}


	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	
}
