package com.vault.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VaultApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(VaultApplication.class, args);
		Secretss secrets = context.getBean(Secretss.class);
		System.out.println("Login: " + secrets.username);
//		System.out.println("Password: " + secrets.getPassword());

	}

}
