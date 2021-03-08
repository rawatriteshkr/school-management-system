package com.kipragno.tech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {
        "com.kipragno.tech.config",
        "com.kipragno.tech.controller",
        "com.kipragno.tech.entity",
        "com.kipragno.tech.exception",
        "com.kipragno.tech.filter",
        "com.kipragno.tech.initializer",
        "com.kipragno.tech.model",
        "com.kipragno.tech.repo",
        "com.kipragno.tech.service",
        "com.kipragno.tech.util",
        "com.kipragno.tech.generator",
        "com.kipragno.tech.config.mail"
    })
public class SpringBootDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);
	
	public static void main(String[] args) {
		logger.info("Application Started...");
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
