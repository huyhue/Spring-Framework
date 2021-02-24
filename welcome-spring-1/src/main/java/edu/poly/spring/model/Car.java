package edu.poly.spring.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	@Autowired
	private Engine engine;
	 
	public Car() {
	}
	
//    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
    
    public Engine getEngine() {
		return engine;
	}

//	@Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
