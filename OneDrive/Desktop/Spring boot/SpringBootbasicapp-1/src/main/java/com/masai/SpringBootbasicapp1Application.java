package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootbasicapp1Application {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SpringBootbasicapp1Application.class, args);
		
		A a = ctx.getBean("a",A.class);
		a.funA();
	}

}
