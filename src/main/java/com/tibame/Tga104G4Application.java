package com.tibame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Tga104G4Application {

	public static void main(String[] args) {
		SpringApplication.run(Tga104G4Application.class, args);
	}

}
