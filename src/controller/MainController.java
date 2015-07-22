package controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import bean.Student;

@Controller
@SessionAttributes(value="session",types={Student.class})
public class MainController {
	
	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map map){
		map.put("session", "this is session");
		System.out.println("testSessionAttribute");
		return "index";
	}
	
	/**
	 * 当session中没有相关的参数时候不会报错
	 * @return
	 */
	@RequestMapping("/testSessionAttribute2")
	public String testSessionAttribute2(){
		System.out.println("testSessionAttribute2");
		return "index";
	}
	
	@ModelAttribute
	public void handleName(Map map){
		System.out.println("handlename");
		map.put("name", "mu");
	}
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(@ModelAttribute("name") String name,String pwd){
		System.out.println("testModelAttribute "+ name +":" +pwd );
		return "index";
	}
	
	@RequestMapping("/testMAError")
	public String testModelAttributeError(Student student){
		System.out.println("testModelAttributeError");
		return "index";
	}
}
