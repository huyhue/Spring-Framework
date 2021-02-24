package edu.poly.spring.model;

public class Teacher {
	private Student student;
	// Dựa vào constructor

	public void Teacher() {
		student = new Student("Huy", 9.8f);
	}

	// Dựa vào Setter method
	void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public Teacher(Student student) {
		super();
		this.student = student;
	}

	public float getStudentMark() {
		return student.getStudentMark();
	}

	@Override
	public String toString() {
		return "Teacher [student=" + student + "]";
	}
}
