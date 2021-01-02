package edu.poly.spring.model;

public class Company {
	private String name, logo;
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public Company(String name, String logo) {
		super();
		this.name = name;
		this.logo = logo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
