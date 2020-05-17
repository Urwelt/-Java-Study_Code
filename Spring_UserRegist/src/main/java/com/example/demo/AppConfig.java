package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Interface.PasswordEncoder;
import Interface.UserRepository;

/*
 * JavaベースConfiguration
 * 1.@Configurationを定義する
 * 2.@BeanでDIする
 * 	2.1 メソッド名がBean名となる
 * 	2.2 @Bean(name = "xx")でBean名を設定できる
 * 3.JavaベースConfigurationを利用する
 * 	3.1 ApplicationContext xx = new AnnotationConfigApplicationContext(xx.class);
 * 4.メソッドの引数を追加することが可能だが、別途Bean定義されている必要がある
 * 5.戻り値がBeanのインスタンスとして定義される
 */

@Configuration
public class AppConfig {
	@Bean
	UserRepository userRepository() {
		return new UserRepositoryImpl();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UseService userService() {
		return UserServiceImpl(userRepository(), passwordEncoder());
	}
}
