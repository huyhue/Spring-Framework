package edu.poly.spring.model;

public class Student {
	private String name;
    private float mark;

    public Student(){

    }

    public Student(String name, float mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	public float getStudentMark() {
        return mark;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", mark=" + mark + "]";
	}
	
}
