package com.unisc.farmacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class ProjetoFarmaciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFarmaciaApplication.class, args);
	}
}
