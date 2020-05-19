package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test3Controller {
	
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}
}
