package com.cglia.customquery;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableAspectJAutoProxy
public class CustomqueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomqueryApplication.class, args);
	}

}
