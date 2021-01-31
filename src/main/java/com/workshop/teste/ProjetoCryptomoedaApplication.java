package com.workshop.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={BatchAutoConfiguration.class})
public class ProjetoCryptomoedaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoCryptomoedaApplication.class, args);
	}

}
