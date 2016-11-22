package model;

import java.util.Calendar;

public class Account {

	private Long id;
	private String name;
	private String email;
	private Calendar created_on;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Calendar created_on) {
		this.created_on = created_on;
	}
	public Long getId() {
		return id;
	}
	
}
