package com.vault.vault;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableConfigurationProperties(MyConfiguration.class)
@Slf4j
public class VaultApplication implements CommandLineRunner {

	private final MyConfiguration config;

	public VaultApplication(MyConfiguration config) {
		this.config = config;
	}

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Key : " + config.getKey());
	}

}
