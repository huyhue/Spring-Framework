package edu.poly.spring.model;

public class Engine {
	private String code;
	
	public Engine() {
	}
	
	public Engine(String code) {
		super();
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Engine [code=" + code + "]";
	}
	
}
