package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Interface.PasswordEncoder;
import Interface.UserRepository;

/*
 * Java�x�[�XConfiguration
 * 1.@Configuration���`����
 * 2.@Bean��DI����
 * 	2.1 ���\�b�h����Bean���ƂȂ�
 * 	2.2 @Bean(name = "xx")��Bean����ݒ�ł���
 * 3.Java�x�[�XConfiguration�𗘗p����
 * 	3.1 ApplicationContext xx = new AnnotationConfigApplicationContext(xx.class);
 * 4.���\�b�h�̈�����ǉ����邱�Ƃ��\�����A�ʓrBean��`����Ă���K�v������
 * 5.�߂�l��Bean�̃C���X�^���X�Ƃ��Ē�`�����
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
