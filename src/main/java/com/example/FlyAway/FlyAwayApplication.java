package com.example.FlyAway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class FlyAwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlyAwayApplication.class, args);
	}

}
