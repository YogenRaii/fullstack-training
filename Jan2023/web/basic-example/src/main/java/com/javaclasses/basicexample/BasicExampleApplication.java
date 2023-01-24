package com.javaclasses.basicexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// spring -> framework (mvc framework)
// spring boot -> tool that wraps spring framework
@SpringBootApplication
public class BasicExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicExampleApplication.class, args);
	}

}
