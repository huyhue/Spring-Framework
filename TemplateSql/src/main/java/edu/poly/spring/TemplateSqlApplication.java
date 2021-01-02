package edu.poly.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateSqlApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepository customerRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TemplateSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Customer> cus = customerRepo.findAll();
		cus.forEach(System.out :: println);
		
	}

	
}
