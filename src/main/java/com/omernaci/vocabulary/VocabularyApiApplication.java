package com.omernaci.vocabulary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VocabularyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VocabularyApiApplication.class, args);
	}
}
