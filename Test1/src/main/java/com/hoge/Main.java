package com.hoge;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
    	//JavaベースConfigurationでDIコンテナを生成
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //DIインスタンスを取得
        UseFunctionService bean = context.getBean(UseFunctionService.class);
        //DIインスタンスのメソッドを呼び出す
        System.out.println(bean.sayHello("Hoge"));
        context.close();
    }
    
//try-with-resources文でも可能　java.io.Closeable実装しているので
//    public static void main(String[] args) {
//    	try(AnnotationConfigApplicationContext context = 
//    			new AnnotationConfigApplicationContext(MyConfig.class)){}
//    }
}
