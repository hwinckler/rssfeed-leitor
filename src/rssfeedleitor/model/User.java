package rssfeedleitor.model;

import java.util.Date;

public class User {

	private Integer id;
	private String email;
	private Date date;
	
	public User() {
	}
	
	public User(String email){
		this.email = email;
		this.date = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
