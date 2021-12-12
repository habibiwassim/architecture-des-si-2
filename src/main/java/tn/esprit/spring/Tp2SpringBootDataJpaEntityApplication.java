package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Tp2SpringBootDataJpaEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp2SpringBootDataJpaEntityApplication.class, args);
	}

}
