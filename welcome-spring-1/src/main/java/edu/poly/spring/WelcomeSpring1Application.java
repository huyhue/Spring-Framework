package edu.poly.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import edu.poly.spring.model.Company;
import edu.poly.spring.model.User;

@SpringBootApplication
public class WelcomeSpring1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WelcomeSpring1Application.class, args);
		Company company = (Company) context.getBean("company");
		System.out.println("Company: "+company.getName());
		
//		SpringApplication.run(WelcomeSpring1Application.class, args);
	}

	@Bean(name = "company")
	public Company getCompany() {
		Company comp = new Company();
		comp.setName("Fpoly");
		comp.setLogo("Ply");
		return comp;
	}
	
	@Bean()
	public User getUser() {
		User u = new User();
		u.setUsername("HuyTP");
		u.setPassword("123");
		return u;
	}
}
