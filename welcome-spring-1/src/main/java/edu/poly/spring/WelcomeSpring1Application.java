package edu.poly.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.poly.spring.model.Car;
import edu.poly.spring.model.Company;
import edu.poly.spring.model.Teacher;
import edu.poly.spring.model.User;

@SpringBootApplication
public class WelcomeSpring1Application {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(WelcomeSpring1Application.class, args);
//		Company company = (Company) context.getBean("company");
//		System.out.println("Company: "+company.getName());
//		User u = (User) context.getBean("getUser");
//		System.out.println("User: "+  u.getUsername());

		// Cấu hình IOC bằng XML
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Company obj = (Company) context.getBean("tenCongTy");
//		System.out.println("Ten Cong Ty: "+  obj.getName());
//		Teacher t = (Teacher) context.getBean("teacher");
//		System.out.println("Teacher: "+ t);

//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
//        ClientService  client = applicationContext.getBean(ClientService.class);
//        client.processMsg(" sending email ");

//		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
//        DatabaseInitiaizer  db = applicationContext.getBean(DatabaseInitiaizer.class);
//        applicationContext.close();

//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Car obj = (Car) context.getBean("car");
//		if (obj.getEngine() != null) {
//			System.out.println(obj.getEngine().getCode());
//		}

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
//        MessageService messageService = context.getBean(MessageService.class);
//        messageService.sendMsg1();
//        context.close();

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		Mobile mobile = context.getBean(Mobile.class);
		mobile.getMessageService().sendMsg1();
		context.close();

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
