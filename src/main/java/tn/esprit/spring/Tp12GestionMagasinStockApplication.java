package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Tp12GestionMagasinStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp12GestionMagasinStockApplication.class, args);
	}
}
