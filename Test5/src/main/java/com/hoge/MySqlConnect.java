package com.hoge;
/*
 * extend -> DbConnect
 */
public class MySqlConnect extends DbConnect {

	@Override
	public void connect() {
		System.out.println("App Class : "+getUrl());
	}
	
}
