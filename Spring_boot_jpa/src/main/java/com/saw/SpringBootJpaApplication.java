package com.saw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.saw.service.MyService;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootJpaApplication.class, args);
		MyService service = applicationContext.getBean(MyService.class);

//		service.save();
//		service.getAllEmployee();
		service.saveProduct();
	}

}
