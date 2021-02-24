package edu.poly.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import edu.poly.spring.domain.Student;

@Configuration
@PropertySources({ @PropertySource("classpath:config.properties") })
public class AppConfig {

	@Bean(name = "tenST", initMethod = "init", destroyMethod = "destroy")
	public Student ok1() {
		Student st = new Student();
		st.setName("Gia Huy");
		return st;
	}
	
	@Lazy(value = true)
    @Bean
    public FirstBean firstBean() {
        return new FirstBean();
    }

    @Bean
    public SecondBean secondBean() {
        return new SecondBean();
    }
}
