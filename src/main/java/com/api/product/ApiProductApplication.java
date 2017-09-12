package com.api.product;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiProductApplication {
	
	@PostConstruct
    void started() {
      TimeZone.setDefault(TimeZone.getTimeZone("TimeZone"));
    }
	
//	@Bean
//	public LocaleResolver localeResolver() {
//		return new FixedLocaleResolver(new Locale("pt", "BR"));
//	}

	public static void main(String[] args) {
		SpringApplication.run(ApiProductApplication.class, args);
	}

}
