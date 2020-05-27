package com.hoge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	//application.prorerties Value GET
	@Value("load.db.config")
	private String url;
	
	@Bean
	public DbConnect mySqlConnect() {
		//SET
		DbConnect mysql = new MySqlConnect();
		System.out.println("AppConfig Class :" + url);		
		mysql.setUrl(url);
		
		return mysql;
	}
	
}
