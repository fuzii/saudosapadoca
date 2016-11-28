package model;

import java.util.Calendar;
import java.util.List;

public class Establishment {

	private Long id;
	private String name;
	private String alias;
	private Long registerNumber;
	private Calendar created_on;
	private List<Address> address;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Long getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(Long registerNumber) {
		this.registerNumber = registerNumber;
	}
	public Calendar getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Calendar created_on) {
		this.created_on = created_on;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
}
