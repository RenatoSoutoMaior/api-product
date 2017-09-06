package com.api.product;

import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class ApiProductApplication {
	
//	@PostConstruct
//    void started() {
//      TimeZone.setDefault(TimeZone.getTimeZone("TimeZone"));
//    }
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiProductApplication.class, args);
	}

}
