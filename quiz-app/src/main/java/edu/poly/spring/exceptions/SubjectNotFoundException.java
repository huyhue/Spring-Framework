package edu.poly.spring.exceptions;

public class SubjectNotFoundException extends RuntimeException{
	public SubjectNotFoundException() {
		super("Subject Not Found Exception");
	}
}