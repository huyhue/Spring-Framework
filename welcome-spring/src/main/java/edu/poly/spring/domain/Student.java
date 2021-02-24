package edu.poly.spring.domain;

public class Student {
	
	private String studentId, name;
	private int majorId;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String studentId, String name) {
		super();
		this.studentId = studentId;
		this.name = name;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	
	public void init() {
		System.out.println("Init student");
	}
	
	public void destroy() {
		System.out.println("Destroy student");
	}
	
}
