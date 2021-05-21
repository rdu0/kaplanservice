package com.kaplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class KaplanApplication {
	public static void main(String[] args) {
		SpringApplication.run(KaplanApplication.class, args);
	}

}

