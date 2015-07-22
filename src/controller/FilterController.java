package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FilterController {

	@RequestMapping("/firstFilter")
	public String firstFilter(){
		System.out.println("firstFilter");
		return "index";
	}
	
	@RequestMapping("/secondFilter")
	public String secondFilter(){
		System.out.println("secondFilter");
		return "index";
	}
}
