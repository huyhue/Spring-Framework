package edu.poly.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.poly.spring.domain.Student;

@SpringBootApplication
public class WelcomeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WelcomeSpringApplication.class, args);

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		Student st = (Student) context.getBean("tenST");
//		System.out.println("Name Student: "+ st.getName());
//		FirstBean firstBean = context.getBean(FirstBean.class);
//        firstBean.test();
//		context.close();

	}

}
