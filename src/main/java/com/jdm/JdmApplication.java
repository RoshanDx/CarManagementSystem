package com.jdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class JdmApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdmApplication.class, args);
		
		
	}

}
