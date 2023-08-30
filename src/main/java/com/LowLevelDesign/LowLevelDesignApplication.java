package com.LowLevelDesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LowLevelDesignApplication {
	private static final Logger log = LoggerFactory.getLogger(LowLevelDesignApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LowLevelDesignApplication.class, args);
	}
}
