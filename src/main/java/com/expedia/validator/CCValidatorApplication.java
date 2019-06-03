package com.expedia.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CCValidatorApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(CCValidatorApplication.class);

	public static void main(String[] args) {
		try{
			SpringApplication.run(CCValidatorApplication.class, args);
		} catch (Exception ex) {
			LOGGER.error("Error while starting the web service");
		}
	}

}
