package com.hoge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UseFunctionService {
	@Autowired
	FunctionService functionService;
	
	public String sayHello(String word) {
		return functionService.sayHello(word);
	}
}
