package com.hoge;

public abstract class DbConnect {
	
	private String url;
	
	public abstract void connect();

	public String getUrl() {return url;}
	
	public void setUrl(String url) {this.url = url;}
}
