package com.hoge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		//Spring run
		ApplicationContext context = SpringApplication.run(App.class,args);
		//Ioc(DI)
		DbConnect db = context.getBean(DbConnect.class);
		db.connect();
	}

}
