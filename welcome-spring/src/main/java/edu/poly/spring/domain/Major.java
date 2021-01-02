package edu.poly.spring.domain;

import java.io.Serializable;

public class Major implements Serializable{
	private int majorId;
	private String name;
	
	public Major() {
	}
	public Major(int majorId, String name) {
		super();
		this.majorId = majorId;
		this.name = name;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
