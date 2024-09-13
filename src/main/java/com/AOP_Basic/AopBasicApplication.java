package com.AOP_Basic;

import com.AOP_Basic.AOPService.AOPService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class AopBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopBasicApplication.class, args);

	}

}
