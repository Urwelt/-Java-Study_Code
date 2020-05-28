package com.hoge;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Girl {

	@PostConstruct
	public void postConstruct(){
		System.out.println("\t>> 初期化後、Girlオブジェクトはこの関数を実行する");
		}

	@PreDestroy
	public void preDestroy(){
		System.out.println("\t>> 破棄される前、Girlオブジェクトはこの関数を実行する");
		}
}
