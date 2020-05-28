package com.hoge;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test3Controller {
	
	//return file -> index.html 
	@GetMapping("/")
	public String index() {return "index";}
	
	@GetMapping("form")
	public String form() {return "form";}
	
	@PostMapping("hello")
	public ModelAndView hello(
			@RequestParam(name="name")String name, ModelAndView mav) {
		mav.addObject("name" , name);
		mav.setViewName("hello");
		return mav;
	}
}
