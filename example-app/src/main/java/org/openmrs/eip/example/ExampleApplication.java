package org.openmrs.eip.example;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.openmrs.eip.app.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
@ComponentScan({"org.openmrs.eip.mysql.watcher", "org.openmrs.eip.example"})
public class ExampleApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleApplication.class);
	
	public static void main(final String[] args) {
		logger.info("Starting example application...");
		
		SpringApplication.run(ExampleApplication.class, args);
	}

}
