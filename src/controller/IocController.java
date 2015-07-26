package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MuService;

@Controller
public class IocController {

	@Autowired
	private MuService muService;
	
	@RequestMapping("/testIoc")
	public String testIoc(){
		muService.show();
		return "index";
	}
}
