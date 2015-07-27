package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.Student;

@Controller
public class FormController {

	@RequestMapping("/form")
	public String form(){
		return "form";
	}
	
}
