package com.groupswd391.fall22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class Fall22Application {

	public static void main(String[] args) {
		SpringApplication.run(Fall22Application.class, args);
	}

}
