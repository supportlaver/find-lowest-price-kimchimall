package com.supportkim.kimchimall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KimchiMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(KimchiMallApplication.class, args);
	}

}
