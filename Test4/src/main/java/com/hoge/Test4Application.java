package com.hoge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Test4Application {

	public static void main(String[] args) {
		//最初に呼び出される処理
		System.out.println("> Iocコンテナが初期化される前");
		//@PostConstructで指定された関数はIocコンテナの初期化後、呼び出される
		ApplicationContext context = SpringApplication.run(Test4Application.class, args);
		System.out.println("> Iocコンテナが初期化された後");
		
		Girl girl = context.getBean(Girl.class);

		System.out.println("> IocコンテナがGirlを破棄する前");
		//@PreDestroyで指定された関数は破棄される前に実行される
		((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(girl);
		System.out.println("> IocコンテナがGirlを破棄した後");


	}

}