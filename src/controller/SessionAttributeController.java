package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import bean.Student;

@Controller
@SessionAttributes(value={"student"})
public class SessionAttributeController {

	/**
	 * 使用sessionattributes后，指定value值或type值后，@RequestMapping中map的属性除了会添加进requset中，还会添加进sessoin域中
	 * @param student
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSession")
	public String testSession(Student student,ModelMap map){
		System.out.println("testSessoin");
		student=new Student(1,"mu");
		map.put("student", student);
		return "session";
	}
	
	@ModelAttribute
	public void getModel(ModelMap map){
		map.put("student", new Student(2, "mu"));
	}
	
	@RequestMapping("/testSession2")
	public String testSessoin2(@ModelAttribute("student") Student student){
		System.out.println("testSession2");
		System.out.println(student);
		return "session";
	}
}
