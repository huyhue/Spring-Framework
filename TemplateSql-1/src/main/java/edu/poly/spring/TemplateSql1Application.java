package edu.poly.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TemplateSql1Application implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbc;
	
	public static void main(String[] args) {
		SpringApplication.run(TemplateSql1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * FROM customers";
		List<Customer> cus = jdbc.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
		cus.forEach(System.out :: println);
		
	}

}
