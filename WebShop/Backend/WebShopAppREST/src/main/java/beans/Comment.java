package beans;

public class Comment {
	
	private int id;
	private User user;
	private Factory factory;
	private String text;
	private double grade;
	
	public Comment() {
		
	}
	
	public Comment(int id, User user, Factory factory, String text, double grade) {
		this.id=id;
		this.user=user;
		this.factory=factory;
		this.text=text;
		this.grade=grade;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
}
