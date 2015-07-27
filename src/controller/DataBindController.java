package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bean.Student;

@Controller
public class DataBindController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		System.out.println("initBinder");
		dataBinder.setDisallowedFields("name");
	}
	
	@RequestMapping("/testBind")
	public String testBind(@Valid Student student,Errors errors){
		if(errors.hasErrors())
			return "form";
		System.out.println(student);
		return "index";
	}
	
	@RequestMapping("/testBind2")
	public String testBind2(@RequestParam("name") String name){
		System.out.println(name);
		return "index";
	}
}
